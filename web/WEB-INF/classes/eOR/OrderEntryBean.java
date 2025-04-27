/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
************************************************************************
*  ClassName          	:  OrderEntryBean
*  Description          :  Used for Order Entry(New Orders, Order Set, Amend Orders)
*  Methods            	:
*  Exception          	:
*  Authors            	:
*  Version            	: 1.0
*  Date            		:
*  Revision History     :
***************************************************************************
*   Version      Date    Name    Remarks
***************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
10/10/2011	IN29181		DineshT     		?				?					Added the 'and condition in the if construct'
24/10/2011  IN029071    Chowminya G     	?				?					Incident No: IN029071 - <CRF - new rules for Discharge advice> 
22/11/2011  IN029647	Chowminya G     	?				?					Incident No: IN029647 - <CRF - new rules for Discharge advice linked issue of IN029071>
20/01/2012	IN029143	Menaka V			?				?					<JD-CRF-0111 This option is available in HIS 2.x and KAUH needs to be in 	EM version. In the current workflow the option is being used frequently. When a physician selects the patient, system will ask to enter the PIN Code. Physician needs to authenticate in the Prescription screen using the PIN code. This will prevent from unauthorised access while the physician is on rounds>.	
25/01/2012	IN030563	Ramesh G			?				?					The Pin No. for placing ordering is selected as Ordering Practitioner‘s Pin – Prompt once for all categories. When we Place Order set s the Practitioner name is disabled and the Pin No of ordering  Practitioner is not accepted
31/01/2012	IN030711	Menaka V			?				?					When the User is not assigned any Pin No. and he enters any Pin	No.,Wrong prompt message is displayed
01/02/2012	IN030797	Menaka V			?				?					CA>For a Particular Logged in User the Practitioner ID is disabled and	cannot proceed to place orders.
15/02/2012  IN031116	Menaka V			?				?					Functionality equivalent to 5.x, placing consultation order.
21/02/2012  IN032925	Menaka V			?				?					Order id should include facility id to facilitate multi-facility option.
01/06/2012	IN032796	Ramesh G			?				?					Collection Label is not getting printed.
01/10/2012  IN035189  	Dinesh T			?				?					Thai Date conversions problem in normal and amend mode
11/07/2012	IN033892	Menaka V			?				?					While placing order from the register visit screen, 500 internal server is
12/09/2012  IN31901		NijithaS	    	?				?					Incident No: IN31901 - Bru-HIMS-CRF-263
24/09/2012  IN035349	Chowminya G	    	?				?					CRF-CA- Bru-HIMS-CRF-121/04- Unable to Place multi OT Orders with same order ID 
08/10/2012	IN034769	Ramesh G			?				?					ML-BRU-SCF-0371 
29/11/2012	IN031304	Karthi L			?				?					To load three tier waiting list screen when RD_OA_INTEGRATION_YN param is Y	and order_category is RD(IN035976)
31/01/2013  IN037633	Chowminya G	    	?				?					Amend Orders is not working
31/01/2013 	IN037091	vijayakumark		?				?						While placing order from the register visit screen, 500 internal server is encountered and script error appears
03/04/2013  IN035929 	Karthi L			?				?					When user Place in OR/CA, user should not see Service charges.
16/04/2013	IN038117	Karthi L			?				?					The setup parameter for manage specimen function is not cover in procedure unit
05/07/2013  IN039001    Nijithas			?				?					If the Practitioner's Full Name consists of "+" , system does not allow to place the Order even if  correct Pin No is entered. 
13/06/2013	IN038776	Ramesh G			?				?					This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes
13/08/2013	IN042045	Chowminya G	    	?				?					System should not allow to copy for the drugs for which Verbal Order Applicable is not selected
28/10/2013	IN044542	Chowminya			?				?					Unable to place order ?New for External Patient encounter type due to script debug error
01/12/2013	IN038787	Ramesh G			?				?					Bru-HIMS-CRF-358
24/01/2014	IN046592	Ramesh G			?				?					Manage Specimen is taking more than 40 seconds to complete after clicking on Record when multiple records are selected. The response time is very slow.	
12/02/2014  IN045719	Chowminya			?				?					Multifacility Processing - location type E, The Performing loc as Ordering facility		
20/02/2014	IN024984	Karthi			22-02-2014		  Ramesh				Conditional reordering by clinician			
27/02/2014	IN047469	Chowminya		05/03/2014		  Ramesh				Amend Order splitting issue					
14/03/2014	IN047637	Karthi									  				System allowing to Reorder multi orders without entering duplicate reason
28/03/2014				NijithaS												Fix for suspended orders.
22/04/2014  IN042962	Chowminya     											CRF:Print Order Sheet From Existing Orders
20/05/2014	IN044502    Nijitha S	   											Bru-HIMS-CRF-400
02/07/2014	IN048467 	Nijitha S												HSA-CRF-0150
13/08/2014	IN049419	Ramesh G			?				?					An Audit Trail for Additional Information Amendment of Order
19/08/2014  IN050610    Chowminya									        	CRF Link 2:dependency date validation differed in Order format
26/08/2014  IN050607	Nijitha S												KDAH-SCF-0255
08/09/2014  IN041371	Chowminya												When adding additional tests on the already placed tests,the new tests are not getting saved
24/9/2014	IN051367		Nijitha S		Regression-OP-Transaction – Register Visit
29/10/2014	IN045340	Karthi L												Order format details are not displayed while releasing order by preview.

29/04/2015	IN055190	Vijayakumar K	29/04/2015		Dinesh T		KDAH-SCF-0296 [IN:055190] - Wrong order category is getting updated.
09/05/2016	IN058811	Raja S			10/05/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable 
																		(ALL Order Categories) is a national requirement.
09/05/2016	IN058388/
			IN058669	Raja S			10/05/2016		Ramesh G		System displays ‘Reqd/opt’ in place order screen incorrect. 
30/11/2016	IN062319	Karthi L										ML-MMOH-CRF-0508.1 [IN062319] 
27/03/2017	IN063686	Vijayakumar K									PMG2017-GHL-CRF-0001 [IN:063686]
09/06/2017	IN063816	Vijayakumar K									GHL-CRF-0445.1 [IN:063816]	
16/06/2017	IN064531	Vijayakumar K		16/06/2017		Ramesh G	CRF-OR-GHL-CRF-0445.1/02 - System displays an alert message " Barcode report has been Submitted to the printer" [IN:064531]
27/06/2017  IN064614	Vijayakumar K		27/06/2017		Ramesh G	CRF-OR-GHL-CRF-0445.1/03 - Unable to place order if report server is down / having issue. [IN:064614]
03/07/2017  IN062607	Raja S				03/07/2017		Ramesh G	ML-MMOH-CRF-0727
15/09/2017	IN065264	Vijayakumar K	15/09/2017		Ramesh G		OR-Common-Place Order [IN:065264]
30/10/2017 	IN061906	Kamalakannan G	30/10/2017		Ramesh G		added new replace string "##FILTERSET##" for getting ordersets for diagnosis
15/12/2017	IN065942	Dinesh T		15/12/2017		Ramesh G		In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
08/02/2018	IN066436	Raja S			08/02/2018		Ramesh G		SS-SCF-0777
06/07/2018	IN067246	Raja S			06/07/2018		Ramesh G		GHL-CRF-0516
17/07/2018	IN064543	Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
01/08/2018	IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
24/08/2018	IN68475			Dinesh T		24/08/2018	Ramesh G			Amend an order which has comments in the order format window. 
																			The preview window is not showing the already recorded comments 
																			in the preview window which is invoked on press of Preview button on the right corner of the bottom of the screen
08/10/2018	  IN063719		Kamalakannan 	08/10/2018	Ramesh G		GHL-CRF-0419																			
11/02/2019	IN069657	Dinesh  T	11/02/2019	Ramesh G	IN069657																				
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
27/05/2019	IN069027	Ramesh G											MMS-DM-CRF-0150
27/05/2019  IN068553    Ramya Maddena	06/06/2019  Ramesh G    GHL-CRF-0554
14/10/2019  IN071315	Nijitha S     15/10/2019		Ramesh G		GHL-CRF-0607
17/10/2019	 IN071393		sivabagyam	 17/10/2019        Ramesh G       ML-MMOH-SCF-1369
12/12/2019	 IN066302		sivabagyam	 12/12/2019        Ramesh G      	MO-CRF-20125.1
12/12/2019	 IN072036		sivabagyam	 12/12/2019        Ramesh G      	BSP-SCF-0080
05/02/2020	IN068314	Nijitha S	05/02/2020	Ramesh G	ML-MMOH-CRF-1229
17/02/2020	IN071260		Nijitha S	17/02/2020	Ramesh G	MMS-KH-CRF-0029.3
09/03/2020	IN072668	Nijitha S		 09/02/2020		   Ramesh G 
21/05/2020	IN073051	SIVABAGYAM M		21/05/2020		RAMESH G		MO-GN-5555 
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
06/07/2020	IN072654	Nijitha S	06/07/2020	Ramesh G	MMS-KH-CRF-0029.4
28/06/2020		IN071820		Ramesh G		28/06/2020		Ramesh G		ML-MMOH-SCF-1413	
04/08/2020		IN073562		Nijitha S	04/08/2020	Remesh G	MMS-KH-CRF-0029.4/01
13/04/2020		IN072627		Nijitha S				Ramesh G	MMS-KH-CRF-0029.4/04
14/12/2020	10531		  	Nijitha S	        14/12/2020	    Remesh G	   ML-MMOH-SCF-1685-TF
12/01/2020	11766			Nijitha S			12/01/2020		Nijitha S	   ML-MMOH-SCF-1694-TF
22/02/2021	14699			Nijitha S			22/02/2021		Ramesh G	   ML-MMOH-SCF-1733
03/01/2022	6868			Ramesh G			03/01/2022		Ramesh G	   AAKH-CRF-0125
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178

-------------------------------------------------------------------------------------------------------
*/

package eOR;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;

import eOR.Common.*;
import eOR.OROrderEntry.* ;

import javax.servlet.http.*;

import oracle.jdbc.OracleCallableStatement;//IN068314
import org.json.simple.JSONObject;

import webbeans.eCommon.ConnectionManager;
import com.ehis.util.DateUtils;

import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public  class  OrderEntryBean extends OrAdapter implements Serializable , SceduleFreqeuncyInterface
{
  //SceduleFreqeuncyInterface is the interface where it gets the bean class(For Schedule Frequency), and to implement its two methods.[getScheduleFrequencyStr() and setScheduleFrequencyStr()]
  HashMap		hashPatientEmailDetails		= new HashMap();
  private String encounter_id        		= null ;
  private String patient_id          		= null ;
  private String patient_class       		= null ;
  private String location_type       		= null ;
  private String location_code       		= null ;
  private String practitioner_id     		= null ;
  private String practitioner_name   		= null ;
  private String practitioner_type    		= null ;
  private String order_category_yn    		= null ;
  private String order_type_code_yn   		= null ;
  private String order_privilege_level		= null ;
  private String pin_ident_by_category_yn 	= null ;
  private String service_code        		= null ;
  private String order_category      		= null ;
  private String order_type          		= null ;
  private String attend_practitioner_id     = null ;
  private String attend_practitioner_name	= null ;
  private String responsibility_id       	= null ;
  private String called_from_ca       		= null ;
  private String relationship_id      		= null ;
  private String privilege_applicability      		= null ;
  private String priv_applicability      		= null ;
  private String[] amend_frequency_value      		= null ;
  private String new_amend_frequency_value      		= "" ;
  private String patientDischarged			= null;
  private String invokeFunction          	= null ;
  private String frame_color          		= null ;
  private String sex              			= null ;
  private String age              			= null ;
  private String dob              			= null ;
  private String facility_name     	    	= null , discharge_date_time = null;
  private String visit_adm_date        		= null ;
  private String order_id          			= null , order_line_no		  = null;
  private String ammend_called_from      	= null , called_from_function = null;
  private String amend_order_type			= null , sys_date			  = null;
  private StringBuffer amend_clinical_comments  = null;
  private StringBuffer displayDetail=new StringBuffer();
  //IN049419 Start.
  private String amend_reason 				= null;
  private String Amend_auditTrailYN			= null;
  private String dup_temp_code_remarks			= null; //IN062607
  //ML-MMOH-CRF-0508.1 [IN062319] - Start
  	private Map multiListCompMnemonicMap 			= null; 
	private Map multiListCompMnemonicMapClone		= null; 
  	private List multiCheckCompMnemonicList			= null;
	private List completeMultiCheckCompList			= null;
	private Map dupeMultiCompMnemonicMapClone		= null;
	private List dupeAllMultiCompMnemonicList		= null;
	private List validateMnemonicList				= null;
	private List validateAllMnemonicList			= null;
	private Map validateMnemonicMap					= null;
	
	public List getValidateAllMnemonicList() {
		return validateAllMnemonicList;
	}
	public void setValidateAllMnemonicList(List validateAllMnemonicList) {
		this.validateAllMnemonicList = validateAllMnemonicList;
	}
	public void clearValidateAllMnemonicList(){
		if(validateAllMnemonicList != null){
			validateAllMnemonicList.clear();
		}
	}
	public List getValidateMnemonicList() {
		return validateMnemonicList;
	}
	public void setValidateMnemonicList(List validateMnemonicList) {
		this.validateMnemonicList = validateMnemonicList;
	}
	public void clearValidateMnemonicList(){
		if(validateMnemonicList != null){
			validateMnemonicList.clear();
		}
	}
	public Map getValidateMnemonicMap() {
		return validateMnemonicMap;
	}
	public void setValidateMnemonicMap(Map validateMnemonicMap) {
		this.validateMnemonicMap = validateMnemonicMap;
	}
	public void clearValidateMnemonicMap(){
		if(validateMnemonicMap != null){
			validateMnemonicMap.clear();
		}
	}
	public List getDupeAllMultiCompMnemonicList() {
		return dupeAllMultiCompMnemonicList;
	}
	public void setDupeAllMultiCompMnemonicList(List dupeAllMultiCompMnemonicList) {
		this.dupeAllMultiCompMnemonicList = dupeAllMultiCompMnemonicList;
	}
	public void clearDupeAllMultiCompMnemonicList(){
		if(dupeAllMultiCompMnemonicList != null){
			dupeAllMultiCompMnemonicList.clear();
		}
	}
	public Map getDupeMultiCompMnemonicMapClone() {
		return dupeMultiCompMnemonicMapClone;
	}			
	public void setDupeMultiCompMnemonicMapClone(Map dupeMultiCompMnemonicMapClone) {
		this.dupeMultiCompMnemonicMapClone = dupeMultiCompMnemonicMapClone;
	}
	public void clearDupeMultiCompMnemonicMapClone(){
		if(dupeMultiCompMnemonicMapClone != null){
			dupeMultiCompMnemonicMapClone.clear();
		}
	}
	public List getCompleteMultiCheckCompList() {
		return completeMultiCheckCompList;
	}
	public void setCompleteMultiCheckCompList(List completeMultiCheckCompList) {
		this.completeMultiCheckCompList = completeMultiCheckCompList;
	}
	public void clearCompleteMultiCheckCompList(){
		if(completeMultiCheckCompList != null){
			completeMultiCheckCompList.clear();
		}
	}
	public List getMultiCheckCompMnemonicList() {
		return multiCheckCompMnemonicList;
	}
	public void setMultiCheckCompMnemonicList(List multiCheckCompMnemonicList) {
		this.multiCheckCompMnemonicList = multiCheckCompMnemonicList;
	}
	public void clearMultiCheckCompMnemonicList(){
		if(multiCheckCompMnemonicList != null){
			multiCheckCompMnemonicList.clear();
		}	
	}
	public Map getMultiListCompMnemonicMapClone() {
		return multiListCompMnemonicMapClone;
	}
	public void setMultiListCompMnemonicMapClone(Map multiListCompMnemonicMapClone) {
		this.multiListCompMnemonicMapClone = multiListCompMnemonicMapClone;
	}
	public void clearMultiListCompMnemonicMapClone(){
		if(multiListCompMnemonicMapClone != null) {
			multiListCompMnemonicMapClone.clear();
		}	
	}
	public Map getMultiListCompMnemonicMap() {
		return multiListCompMnemonicMap;
	}
	public void setMultiListCompMnemonicMap(Map multiListCompMnemonicMap) {
		this.multiListCompMnemonicMap = multiListCompMnemonicMap;
	}
	public void clearMultiListCompMnemonicMap(){
		if(multiListCompMnemonicMap != null){
			multiListCompMnemonicMap.clear();
		}	
	}
// ML-MMOH-CRF-0508.1 [IN062319] - End
  public String getAmend_auditTrailYN() {
	return Amend_auditTrailYN;
  }
  public void setAmend_auditTrailYN(String amend_auditTrailYN) {
	Amend_auditTrailYN = amend_auditTrailYN;
  }
//IN067246 starts
  public String getPlacedCareSetOrder() {
	return chkOrderCatalogCode;
  }
//IN067246 ends
  public String getAmend_reason() {
	return amend_reason;
  }
  public void setAmend_reason(String amend_reason) {
	this.amend_reason = amend_reason;
  }
  //IN049419 End.
  //IN069657, starts
  private String rdInstallYn = "N";
  
  public void setRDInstallYN(String rdInstallYn) {
	 this.rdInstallYn = rdInstallYn;
  }
  
  public String getRDInstallYN() {
	return rdInstallYn;
  }
  //IN069657,ends
  // Used For Duplicate Check
  private String validated_status      		= null ;

// Added by Sridhar Reddy to Fix IN019007
  private String login_pract_id      		= null ;
// End

  //private String p_test_date_time_behind  = null, test_date_time_ahead  = null, catalog_desc_behind	= null;
  //private String catalog_desc_ahead		= null, ordered_pract_behind  = null, ordered_pract_ahead   = null;
  //private String order_status_behind     	= null, order_status_ahead	  = null, end_date_time_behind	= null;
  //private String end_date_time_ahead		= null;
  private String vb_status       			= null, va_status             = null;
  // Till Here
  private String episode_id         		= null, episode_visit_num     = null;
  private String team_id					= null, order_mode			  = null;
  private String refresh_yn         		= null; //Used For Refreshing or coming out of the tabs to Existing order, after the record completion of the order
  private String restrict_yn        		= null; //Used For Pharmacy Orders
  private String def_catalog_code     		= null; //Used For Pharmacy Orders(Oncology Regimen)
  private String default_tab        		= null; //Used For Pharmacy Orders(R -> For Prescription, O -> Oncology)
  private String accession_number			= null; //Used when it is called from RD/OT Module, extra parameters will be passed to update in the table
  private String accession_type				= null; //Used when it is called from RD/OT Module, extra parameters will be passed to update in the table, so when next time from there module if they see which is that orderable that are placed from the RD and OT

  //Used For Insertion and Updation
  private int total_count          			= 0, count_chk_records  = 0;
  private int amend_total_count    			= 0, care_set_count  	= 0;
  private HashMap hashValues       			= null;
// private HashMap tabData          		= null;
  private HashMap copyOrders   	    		= null; // Used for Storing order_id and order_line_no for the CopyOrders
  private HashMap phDetails   	    		= null; // Used in OrderSet for PH values
  private ArrayList copy_order_details     	= null;
  private ArrayList multi_patient_details   = null;
  private LinkedHashMap temp_values			= new LinkedHashMap();

  private Hashtable print_values   	    	= null; // Used for On Line Printing
//  private Hashtable stored_print_values     = null; // Used for On Line Printing
  private Hashtable print_specimen_values	= null; // Used for On Line Printing (Specimen Labels)
  private Hashtable print_specimen_labels	= null; // Used for On Line Printing in Lab Module Installed(Specimen Labels)  //IN046592
  private Hashtable oa_bookappt_values		= null; // Used to be passed for OA Booking Appointment
  private Hashtable external_order_stlmt_bill_data		= null; // Used to be passed for External Orders Billing Settlement Details  Added by Uma 3/20/2009
  private String trn_group_ref		= ""; // Added by Uma 12/8/2009 for CRF -560
  public String chkOrderCatalogCode	= "" ; //IN067246 
  HttpServletRequest request         	  	= null;   //[IN032796]
  HttpServletResponse response       	  	= null;   //[IN032796]
  //eOR.Common.OrderEntryRecordBean  orderEntryRecordBean  = null;
  eOR.Common.OrderEntryRecordBean  orderEntryRecordBean = null;
  eOR.OrderEntryBillingQueryBean  orderEntryBillBean = null;
  eOR.ExternalOrdersBean  externalOrdersBean = null;

  private HashMap consentDetails			= new HashMap(); // Used for Storing multi consent details added by Hari

  private HashMap schdMap = null; // Added By Sridhar Reddy SRR20056-CRF-0274

  /*Added By Uma on 10/15/2009 for SRR20056-195*/
	public Hashtable print_report_values	= null; // Used for On Line Printing (Billing Refund Report)
	/* Ends Here*/
  public Hashtable print_barcode_values 	= null;//IN064531
	int print_count		= 0;
  private String confirm_reqd_YN = "N";//IN042962
  //Added for Bru-HIMS-CRF-400[IN044502] Start
  private HashMap hmRenewOrderIds = null;

	public Hashtable prn_lbl_values 	= new Hashtable();//IN065942

  public HashMap getRenewOrderIds() {
	return hmRenewOrderIds;
  }
  public void clearRenewOrders() {
	if(hmRenewOrderIds!=null)
		hmRenewOrderIds.clear();
  }
  public void setRenewOrderIds(HashMap hmRenewOrderIds) {
	  if(this.hmRenewOrderIds == null)
		  this.hmRenewOrderIds = new HashMap();
		this.hmRenewOrderIds = hmRenewOrderIds;
  }
  //Added for Bru-HIMS-CRF-400[IN044502] End
  //********************* Testing for the bean values *****************************
/*   public void valueBound(HttpSessionBindingEvent event)
   {

   }
   public void valueUnbound(HttpSessionBindingEvent event)
   {

   } */
  HashMap<String, String> instrnContentType = new HashMap<String,String>();//IN64543
/*********************Constructor *************************/
//IN068314 Starts
 public String fpp_patient_yn ="N";
 
 public Boolean isfppapplicable = false;
 public Boolean getIsfppapplicable() {
	return isfppapplicable;
 }
public void setIsfppapplicable(Boolean isfppapplicable) {
	this.isfppapplicable = isfppapplicable;
}
public String getFpp_patient_yn() {
	return fpp_patient_yn;
 }
 public void setFpp_patient_yn(String fpp_patient_yn) {
	this.fpp_patient_yn = fpp_patient_yn;
 }
 //IN068314 Ends
//IN071260 Starts
 HashMap<String, String> druginteractionYN = new HashMap<String,String>();//IN64543
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

//IN071260 Ends
 public OrderEntryBean(){
	setSiteSpecific("DX_CHK_BFR_PLACE_ORDERS");  //IN069027
	setSiteSpecific("DISABLE_PANL_DUPLICATE_CHECK");//IN066302
	// try{
    //doCommon();
	//}catch(Exception e) {}
 }
  /*  As a special case, this method is not called (Exceptional), since it will affect
      the Pharmacy related Bean like (PrescriptionBean_1 & DrugSearchBean)
      For the storage of data,etc....
      Changes have been done after Verification and after informing the standards team
  */
 /*public void initialize(){
 		encounter_id        	= "" ;	patient_id          	  = "" ; patient_class      = "" ;
		location_type       	= "" ;  location_code       	  = "" ; practitioner_id    = "" ;
 		practitioner_name   	= "" ; 	practitioner_type    	  = "" ; order_category_yn  = "" ;
		order_type_code_yn   	= "" ;  order_privilege_level	  = "" ; order_category     = "" ;
		pin_ident_by_category_yn= "" ;  service_code        	  = "" ; order_type         = "" ;	attend_practitioner_id  = "" ;	attend_practitioner_name  = "" ; responsibility_id  = "" ;
		called_from_ca       	= "" ;	relationship_id      	  = "" ; frame_color        = "" ;	sex              		= "" ; 	age              		  = "" ; dob       		    = "" ;
 		facility_name     	    = "" ;	visit_adm_date        	  = "" ; discharge_date_time= "" ;
 		order_id          		= "" ;  order_line_no			  = "" ; ammend_called_from = "" ;  called_from_function	= "" ;	amend_order_type		  = "" ; sys_date		    = "" ;
		discharge_date_time		= "" ;
 		amend_clinical_comments = new StringBuffer();
		// Used For Duplicate Check
		validated_status      	= "" ;	p_test_date_time_behind   = "" ;  vb_status         = "" ;
		catalog_desc_behind     = "" ;  ordered_pract_behind	  = "" ; order_status_behind= "" ; end_date_time_behind	= "" ;	va_status           	  = "" ;  catalog_desc_ahead= "" ;
		ordered_pract_ahead     = "" ;  order_status_ahead		  = "" ; end_date_time_ahead= "" ; test_date_time_ahead	= "" ; 	order_mode				  = "" ; // Till Here
		episode_id         		= "" ; episode_visit_num		  = "";
		accession_type			= "" ; accession_number			  = ""; //USED for RD/OT Module
		refresh_yn         		= "N"; //Used For Refreshing or coming out of the tabs to Existing order, after the record completion of the order
		restrict_yn        		= "N"; //Used For Pharmacy Orders
		def_catalog_code     	= ""; //Used For Pharmacy Orders(Oncology Regimen)
		default_tab        		= ""; //Used For Pharmacy Orders(R -> For Prescription, O -> Oncology)
		//Used For Insertion and Updation
		total_count          		= 0 ; count_chk_records  = 0; amend_total_count	= 0 ; care_set_count = 0;
		hashValues       			= new HashMap();
		tabData          			= new HashMap();
		print_values   	    		= new Hashtable(); // Used for On Line Printing
		stored_print_values 		= new Hashtable(); // Used for On Line Printing
		print_specimen_values		= new Hashtable(); // Used for On Line Printing
		oa_bookappt_values			= new Hashtable(); // Used to be passed for OA Booking Appointment
		request         		 	= null;
		response       	  			= null;
		//eOR.Common.OrderEntryRecordBean  orderEntryRecordBean  = null;
		orderEntryRecordBean 		= new eOR.Common.OrderEntryRecordBean();
		super.initialize();
 } // End of initialize
 */

//  **************  Set Methods ******************
  
   public void  setInvokeFunction(String  invokeFunction) 
   { 
		this.invokeFunction = checkForNull(invokeFunction,""); 
   }
   public void  setPatientId(String  patient_id) { this.patient_id = checkForNull(patient_id,""); }
   public void  setEncounterId(String  encounter_id) { this.encounter_id = checkForNull(encounter_id,""); }
   public void  setPatientClass(String patient_class) { this.patient_class = checkForNull(patient_class,""); }
   public void  setLocationType(String  location_type) {this.location_type = checkForNull(location_type,""); }
   public void  setLocationCode(String  location_code) {this.location_code = checkForNull(location_code,""); }
   public void  setPractitionerId(String  practitioner_id) { this.practitioner_id = checkForNull(practitioner_id,""); }
   public void  setPractitionerType(String  practitioner_type) {this.practitioner_type = checkForNull(practitioner_type,""); }
   public void  setPractitionerName(String practitioner_name) {this.practitioner_name = checkForNull(practitioner_name,""); }
   public void  setOrderCategoryYn(String  order_category_yn) {this.order_category_yn = checkForNull(order_category_yn,""); }
   public void  setOrderTypeCodeYn(String  order_type_code_yn) {this.order_type_code_yn = checkForNull(order_type_code_yn,""); }
   public void  setOrderPrivilegeLevel(String  order_privilege_level) {this.order_privilege_level= checkForNull(order_privilege_level,""); }
   public void  setPinIdentByCategoryYn(String  pin_ident_by_category_yn) {this.pin_ident_by_category_yn= checkForNull(pin_ident_by_category_yn,""); }
   public void  setServiceCode(String  service_code) {this.service_code= checkForNull(service_code,""); }
   public void  setOrderCategoryValue(String order_category) {this.order_category = checkForNull(order_category,""); }
   public void  setOrderTypeValue(String order_type) {this.order_type = checkForNull(order_type,""); }
   public void  setAttendPractitionerId(String pract_id) {this.attend_practitioner_id = checkForNull(pract_id,""); }
   public void  setAttendPractitionerName(String pract_name) {this.attend_practitioner_name = checkForNull(pract_name,""); }
   public void  setSysDate(String sys_date) { this.sys_date = checkForNull(sys_date,"");}

   public void  setResponsibilityId(String responsibility_id) {this.responsibility_id = checkForNull(responsibility_id,""); }
   public void  setCalledFromCA(String called_from_ca) {this.called_from_ca = checkForNull(called_from_ca,""); }
   public void  setRelationshipId(String relationship_id) {this.relationship_id = checkForNull(relationship_id,""); }

   public void  setFrameColor(String frame_color) {this.frame_color = checkForNull(frame_color,""); }
   public void  setSex(String sex) {this.sex = checkForNull(sex,""); }
   public void  setAge(String age) {this.age = checkForNull(age,""); }
   public void  setDob(String dob) {this.dob = checkForNull(dob,""); }
   public void  setFacilityName(String facility_name) {this.facility_name = checkForNull(facility_name,""); }
   public void  setVisitAdmDate(String visit_adm_date) {this.visit_adm_date = checkForNull(visit_adm_date,""); }
   public void  setDischargeDate(String discharge_date_time) {this.discharge_date_time = checkForNull(discharge_date_time,""); }

   public void  setOrderId(String order_id) {this.order_id = checkForNull(order_id,""); }
   public void  setOrderLineNo(String order_line_no) {this.order_line_no = checkForNull(order_line_no,""); }
   public void  setAmendOrder(String ammend_called_from)
 {
	   this.ammend_called_from = checkForNull(ammend_called_from,"");
   }  // Remove this method, kept for backward compatibility
   public void  setAmendOrderType(String amend_order_type)
  {
	   this.amend_order_type = checkForNull(amend_order_type,"");
  }
   public void  setCalledFromFunction(String called_from_function) 
   {
		this.called_from_function = checkForNull(called_from_function,""); 
   }  // To identify it is coming from Renewal Order or Amend Order

   public void  setEpisodeID(String episode_id) 
   {
		this.episode_id = checkForNull(episode_id,""); 
   }
   public void  setEpisodeVisitNum(String episode_visit_num) 
   {
		this.episode_visit_num = checkForNull(episode_visit_num,""); 
   }
   public void  setTeamID(String team_id)
   {
		this.team_id = checkForNull(team_id,""); 
   }

   public void  setCopyOrderDetails(ArrayList copy_order_details) 
   { 
		this.copy_order_details = copy_order_details;
   }   // Used for Copy Order
   public void  setCopyOrderIDDetails(HashMap copyOrders) 
   { 
		this.copyOrders = copyOrders;
   }   // Used for Copy Order to store the order_id and order_line_no

   public void  setPHDetails(HashMap phDetails) 
   { 
		this.phDetails = phDetails;
   }   // Used in OrderSet for PH Category

   public void  setMultiPatientDetails(ArrayList multi_patient_details)
   {
	   this.multi_patient_details = multi_patient_details; 
   }   // For Multi Patient Orders, to store the patient_id, encounter_id and patient_class	
   public void  setRefreshYn(String refresh_yn) 
   {
		this.refresh_yn = checkForNull(refresh_yn,"N"); 
   } //Used to refresh the page or not
   public void  setRestrictYn(String restrict_yn) 
   {
		this.restrict_yn = checkForNull(restrict_yn,"N"); 
   } //Used For Pharmacy Orders
   public void  setOncologyDefCatalogCode(String def_catalog_code) 
   {
		this.def_catalog_code = checkForNull(def_catalog_code,""); 
   } //Used For Pharmacy Orders(Oncology Regimen)
   public void  setOrderMode(String order_mode) 
   {
		this.order_mode = checkForNull(order_mode,""); 
   } //set the order_mode,from the modal window search
   public void  setAccessionType(String accession_type) 
   {
		this.accession_type = checkForNull(accession_type,""); 
   }	//set the accession_type,When called from RD/OT to know that they have placed an order from RD/OT Module
   public void  setAccessionNumber(String accession_number) 
   {
		this.accession_number = checkForNull(accession_number,""); 
   } //set the accession_number,When called from RD/OT to know that they have placed an order from RD/OT Module

   public void  setAmendClinicalComments(StringBuffer amend_clinical_comments) 
   {
	   this.amend_clinical_comments.delete(0,this.amend_clinical_comments.length());
       this.amend_clinical_comments.append(amend_clinical_comments);
   }

   public void setTempValues(String key,String value)
	{
		temp_values.put(key,value);
	}
	public void setPatientDischarged(String patientDischarged)
	{
		this.patientDischarged = checkForNull(patientDischarged,"N");
	}
	public String getPatientDischarged()
	{
		return patientDischarged;
	}
	public String getTempvalue(String key)
	{
		if(temp_values.containsKey(key))
		return (String)temp_values.get(key);
		else
		return null;
	}
	/*Added by Uma on 8/22/2009 for PMG20089-CRF641*/
	public void setPrivilegeApplicability(String value)
	{
		this.privilege_applicability = checkForNull(value,"N");
	}
	public void setPrivApplicability(String value)
	{
		this.priv_applicability = checkForNull(value,"N");
	}
	/* End Here*/

//Added By Sridhar Reddy on 26/03/2010 to fix IN019007 Authorization previlages
	public void setLoginPractId(String login_pract_id)
	{
		this.login_pract_id = checkForNull(login_pract_id,"");
	}
	public String getLoginPractId()
	{
		return this.login_pract_id;
	}
		
//End
	public void clearTemp()
	{
		temp_values.clear();
	}


	// Commented By Sridhar Reddy V on 05092009 SRR20056-CRF-0274
   // If Schedule Frequency is entered, then store the values, Method called from dynamic frequency Jsp to store the Schedule Frequency
/*   public boolean setScheduleFrequencyStr(Hashtable hash){
	 try{
		   String code       		=  checkForNull((String)hash.get("code"),"");
		   String duration_type   	=  checkForNull((String)hash.get("durationType"),"");
		   String start_time_assign	=  checkForNull((String)hash.get("start_time_assign"),"");
		   String start_day_assign	=  checkForNull((String)hash.get("start_day_assign"),"");
		   int repeat        		=  Integer.parseInt(checkForNull((String)hash.get("repeat"),"0"));
		   String row_value  		= checkForNull((String)hash.get("row_value"),"0");
		   HashMap hashMap  		= new HashMap();
		   if(duration_type.trim().equalsIgnoreCase("W") || duration_type.trim().equalsIgnoreCase("M"))
				hashMap.put("admin_day_or_time","D");
		   else
				hashMap.put("admin_day_or_time","H");

			   hashMap.put("duration_type",duration_type);
			   hashMap.put("start_time_assign",start_time_assign);
			   hashMap.put("start_day_assign",start_day_assign);
			   hashMap.put("repeat",String.valueOf(repeat));
			   hashMap.put("row_value",row_value);


		   if(duration_type.equals("W"))
		   {
			   // For Days to be taken
				for(int i=1 ; i <= 7 ; i++){
				  hashMap.put("dayDisplay"+i,checkForNull((String)hash.get("dayDisplay"+i),"")); // Text/Legend
				  hashMap.put("daySM_display"+i,checkForNull((String)hash.get("daySM"+i),""));  // Will be used when retrieving in the modal window
				  if(!checkForNull((String)hash.get("daySM"+i),"").equals(""))
					hashMap.put("daySM"+i,"Y"); // values (If it is checked value == "Y")
				  else
					hashMap.put("daySM"+i,"N"); // values  (If it is unchecked value == "N")
				}
		   }
		   // For Hours to be taken
			for(int j=1 ; j <= repeat ; j++){
			  hashMap.put("displayHrs"+j,checkForNull((String)hash.get("displayHrs"+j),"")); // Legends
			  hashMap.put("time"+j,checkForNull((String)hash.get("time"+j),"")); // Values
			}
 		// Set it into the bean with unique code
		orderEntryRecordBean.setOrderFormats(code, (code+"_"+row_value),hashMap);
	 return true;
	}
	catch(Exception e)
	{

	    return false;
	}
}  */


// Added by Sridhar Reddy on 31/08/09 SRR20056-CRF-0274
public boolean setScheduleFrequencyStr(Hashtable ht)
{
	 try
	 {
			String locale = properties.getProperty("LOCALE");
			String code 			= (String)ht.get("code");
			String duration_type 	= (String)ht.get("durationType");
			int repeat        		=  Integer.parseInt(checkForNull((String)ht.get("repeat"),"0"));
			String row_value		= (String)ht.get("row_value");
			ArrayList scheduleFrequencyDatas	=	new ArrayList();
			//HashMap scheduleFrequency	=	new HashMap();
			ArrayList day_list	= new ArrayList();
			ArrayList day_names	= new ArrayList();
			ArrayList time_list	= new ArrayList();
			ArrayList dose_list	= new ArrayList();
			ArrayList<String> week_days	= new ArrayList<String>();
			String time_value	= (String)ht.get("time1");
			HashMap freq_char_list	 = new HashMap();
			freq_char_list.put("called_from",ht.get("called_from"));
			freq_char_list.put("repeat",repeat);
			freq_char_list.put("durationType",duration_type);
			//freq_char_list.put("start_date_time",ht.get("start_day_param"));
			freq_char_list.put("end_date_time",ht.get("end_date_time"));
			week_days = getDayOfWeek(DateUtils.convertDate((String)ht.get("start_day_param"), "DMY",locale, "en"));
			for(int j=1 ; j <= repeat ; j++)
			{
				if(duration_type.equals("D"))
				{
					day_list.add("0");
				}
				else
				{
					if(!ht.get("admin_day"+(j)).equals(""))
					{
						day_list.add(ht.get("admin_day"+(j)));
					}
					else
					{
						day_list.add("0");
					}
				}
				if(duration_type.equals("W"))
				{
					if(!ht.get("admin_day"+(j)).equals(""))
					{
						String temp = (String)ht.get("admin_day"+(j));
						if (temp == null || temp.equals(""))
						{
							temp = "0";
						}
						if (!temp.equals("0"))
						{
										if(duration_type.equals("L"))
										{
											if(Integer.parseInt(temp)>7)
                                                temp =(((Integer.parseInt(temp)-1)%7)+1)+"";
										}
										day_names.add(week_days.get((Integer.parseInt(temp))-1));
									}

								}
							}else{
								if(!ht.get("admin_day"+(j)).equals(""))
								{
									day_names.add("");
								}
							}
							if(!ht.get("time"+j).equals("")){
								time_value	= (String)ht.get("time"+j);
							}
							time_list.add(time_value);
							dose_list.add((String)ht.get("qty"+j));
						}
					
				    /*ArrayList dateList = null;
				    ArrayList dayList = null;
				    HashMap dataMap = null;
					HashMap paramMap = new HashMap();
					ArrayList dateList1=new ArrayList();
					
					paramMap.put("start_day_param",ht.get("start_day_param"));
					paramMap.put("duration",ht.get("pr_duration"));
					paramMap.put("duration_type",ht.get("pr_duration_type"));
					paramMap.put("durationType",ht.get("durationType"));
					paramMap.put("repeat",ht.get("repeat"));
					paramMap.put("Interval_value",ht.get("Interval_value")==("")?"1":ht.get("Interval_value"));
					paramMap.put("start_time_param",ht.get("start_time_param"));
					paramMap.put("start_time_param",ht.get("start_time_param"));
					
					if(day_list.size() > 0)
					{
						HashMap dates_map = (HashMap)getScheduleDates(paramMap,day_list,time_list);
						
						if(dates_map!= null && dates_map.size() > 0)
						{
							setScheduleDates(dates_map);
							schdMap =(HashMap) getScheduleDates();
							
						}
					}
					if(schdMap!= null && schdMap.size() > 0)
					{			
						for(int x=1; x<=repeat; x++)
						{			
							dataMap = (HashMap)schdMap.get(x);
						
							dateList = (ArrayList)dataMap.get("DATES");
							
							if(dateList!=null && dateList.size() > 0)
							{
								for(int y=0; y < dateList.size(); y++)	
								{
									dateList1.add(dateList.get(y));
								}
							}
						}
					}
					
					Object dateArr[] = dateList1.toArray();
					String minSchdate ="";
					String freq_date = "";
					String start_day_param = "";
					String start_time_param = "";
					if(dateArr.length>0)
					{
					 minSchdate=(String)dateArr[0];
						for(int z=0; z < dateArr.length; z++)	
						{	if(!minSchdate.equalsIgnoreCase((String)dateArr[z]))
							{
								if(com.ehis.util.DateUtils.isAfter(minSchdate,(String)dateArr[z],"DMY", language_id))
									minSchdate=(String)dateArr[z];
							}
						}
					}
					String currDate=com.ehis.util.DateUtils.getCurrentDate("DMY",language_id);	
					if(!(minSchdate.equals("") && (ht.get("start_day_param").equals(""))))
					{
						start_day_param=(String)(ht.get("start_day_param"));
						freq_date = minSchdate;
						if(com.ehis.util.DateUtils.isAfter(currDate,start_day_param,"DMY", language_id)  && com.ehis.util.DateUtils.isAfter(freq_date,start_day_param,"DMY", language_id))
						{
							if(!freq_date.equalsIgnoreCase(start_day_param))
							{
								start_day_param=freq_date;
								start_time_param="00:00";
							}
						}
					}
				
					freq_char_list.put("start_date_time",start_day_param);
					//freq_char_list.put("start_time_param",start_time_param);
					
					
				*/
				//	scheduleFrequency.put(code,scheduleFrequencyDatas);
					scheduleFrequencyDatas.add(freq_char_list);
					scheduleFrequencyDatas.add(day_list);
					scheduleFrequencyDatas.add(day_names);
					scheduleFrequencyDatas.add(time_list);
					scheduleFrequencyDatas.add(dose_list);
					orderEntryRecordBean.setOrderFormats(code, (code+"_"+row_value),scheduleFrequencyDatas);

					
			return true;
	}
	catch(Exception e)
	{

	    return false;
	}
}

	 public ArrayList<String> getDayOfWeek(String sDate)
	{
		String[] Days={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		ArrayList<String> dayList = new ArrayList<String>();
		java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d = new java.util.Date();
		try
		{
			if (sDate != null && !sDate.equals(""))
			{
			  df.setLenient(false);
			  d = df.parse(sDate);
			  //java.util.Calendar c=java.util.Calendar.getInstance();
			  int x = d.getDay();
			  int y = Days.length;
			   for (int i = x;i<y ;i++ )
			   {
					dayList.add(Days[i]);
					if (i==Days.length-1)
					{
						for (int j = 0;j<x ;j++ )
						{
							dayList.add(Days[j]);
						}
					}
			   }
		   }
		} catch(java.text.ParseException e) {
		  e.printStackTrace();
		  return null;
		}
		return dayList;
	}

	public void  setScheduleDates(HashMap schdMap)
	{
		this.schdMap = schdMap;
	}
	public HashMap getScheduleDates()
	{
		return this.schdMap;
	}

/*	public void getScheduleDates(HashMap hash ,ArrayList arrList)
	{
		String durationType = (String)hash.get("durationType");
		String start_day_param = (String)hash.get("start_day_param");
		String pr_duration_type = (String)hash.get("duration_type");
		int duration = Integer.parseInt((hash.get("duration")==null?"0":(String)hash.get("duration")));
		int repeat = Integer.parseInt((hash.get("repeat")==null?"0":(String)hash.get("repeat")));
		int totalDuration = 0;
		String currentDate = "";
		String dayName = "";

		ArrayList dateList = null;
		ArrayList dayList = null;
		HashMap schdMap = new HashMap();
		HashMap repeatMap = null;
		if ((durationType.toUpperCase()).equals("L"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
				totalDuration = duration * 12;
			else
				totalDuration = duration;
		}else if ((durationType.toUpperCase()).equals("W"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
				totalDuration = duration * 52;
			else if((pr_duration_type.toUpperCase()).equals("L"))
				totalDuration = duration * 4;
			else
				totalDuration = duration;
		}else if ((durationType.toUpperCase()).equals("D"))
		{
			if((pr_duration_type.toUpperCase()).equals("Y"))
				totalDuration = duration * 365;
			else if((pr_duration_type.toUpperCase()).equals("L"))
				totalDuration = duration * 30;
			else if((pr_duration_type.toUpperCase()).equals("W"))
				totalDuration = duration * 7;
			else
				totalDuration = duration;
		}

		

		for (int j = 0;j < repeat ; j++)
		{
			dateList = new ArrayList();
			dayList = new ArrayList();
			repeatMap = new HashMap();
			String str = (String)arrList.get(j);
			int val = Integer.parseInt(str);
			currentDate = DateUtils.plusDate(start_day_param, "DMY", "en", val - 1, "d");
			dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");
			dateList.add(currentDate);
			dayList.add(dayName);
			for (int i = 0;i<totalDuration - 1 ;i++ )
			{
				if ((durationType.toUpperCase()).equals("L"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 12, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");

				}else if ((durationType.toUpperCase()).equals("W"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 7, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");
				}else if ((durationType.toUpperCase()).equals("D"))
				{
					currentDate = DateUtils.plusDate(currentDate, "DMY", "en", 1, "d");
					dayName = DateUtils.getDayOfWeekAsShortText( currentDate, "DMY", "en");
				}

				dateList.add(currentDate);
				dayList.add(dayName);
			}
			repeatMap.put("DATES",dateList);
			repeatMap.put("DAYS",dayList);
			schdMap.put(j+1,repeatMap);
		}
		setScheduleDates(schdMap);
	} */
//End SRR20056-CRF-0274

//Used For Multi Consent added by Hari
public void setConsentFormDtl(String key, HashMap consentDetails) {
		this.consentDetails.put(key , consentDetails);
}


 /*---------------------------------GET METHODS---------------------------------*/
  public String getInvokeFunction() 
  { 
	return this.invokeFunction ; 
  }
  public String getPatientId() { return this.patient_id ; }
  public String getEncounterId() { return this.encounter_id ; }
  public String getPatientClass() { return this.patient_class; }
  public String getLocationType() { return this.location_type ; }
  public String getLocationCode() { return this.location_code; }

  public String getPractitionerId() { return this.practitioner_id ; }
  public String getPractitionerName() { return this.practitioner_name ; }

  public String getPractitionerType() { return this.practitioner_type ; }
  public String getSysDefDate() { return this.sys_date; }

  public String getOrderCategoryYn() { return this.order_category_yn ; }
  public String getOrderTypeCodeYn() { return this.order_type_code_yn ; }
  public String getOrderPrivilegeLevel() { return this.order_privilege_level ; }
  public String getPinIdentByCategoryYn() { return this.pin_ident_by_category_yn ; }
  public String getServiceCode() { return this.service_code ; } ;
  public String getOrderCategoryValue() { return this.order_category ; }
  public String getOrderTypeValue() { return this.order_type ; }
  public String getAttendPractitionerId() { return this.attend_practitioner_id ; }
  public String getAttendPractitionerName() { return this.attend_practitioner_name ; }

  public String getResponsibilityId() { return this.responsibility_id ; }
  public String getCalledFromCA() { return this.called_from_ca ; }
  public String getRelationshipId() { return this.relationship_id ; }

  public String getFrameColor() { return this.frame_color ; }
  public String getSex() { return this.sex ; }
  public String getAge() { return this.age ; }
  public String getDob() { return this.dob ; }
  public String getFacilityName() { return this.facility_name; }
  public String getVisitAdmDate() { return this.visit_adm_date; }
  public String getDischargeDateTime(){ return this.discharge_date_time; }
  public String getOrderId() { return this.order_id; }				 // Renewal or Amend
  public String getOrderLineNo() { return this.order_line_no; }
  public String getAmendOrder() {
	  return this.ammend_called_from;
	  }  // Remove it later, kept for backward compatibility
  public String getAmendOrderType() {
	 return this.amend_order_type;
	  }
  public String getCalledFromFunction() { return this.called_from_function; }  // To identify it is coming from Renewal Order or Amend Order (used in Pharmacy Function)

  public String getRefreshYn() { return this.refresh_yn; }
  public String getRestrictYn() { return this.restrict_yn; }    // Pharmacy Orders
  public String getOncologyDefCatalogCode() { return this.def_catalog_code; }    // Pharmacy Orders
  public String getPHDefaultTab() { return this.default_tab; }    // Pharmacy Orders
  public String getEpisodeID() { return this.episode_id; }
  public String getEpisodeVisitNum() { return this.episode_visit_num; }
  public String getTeamID() { return this.team_id; }
  public String getOrderMode() { return this.order_mode; }

  // Used when called from RD/OT Module
  public String getAccessionType() { return this.accession_type; }
  public String getAccessionNumber() { return this.accession_number; }

  public StringBuffer getAmendClinicalComments() {
	  return this.amend_clinical_comments;
	  }
  public ArrayList getCopyOrderDetails() { return this.copy_order_details;}
  public HashMap  getCopyOrderIDDetails() { return this.copyOrders;}   // Used for Copy Order to get the order_id and order_line_no
  public HashMap  getPHDetails() { return this.phDetails;}   // Used for OrderSet for PH Category

  public ArrayList getMultiPatientDetails() { return this.multi_patient_details; } // Used for MultiPatient Order to get the patient_id, encounter_id and patient_class
  public Hashtable getPrintValues() { return this.print_values; }
//  public Hashtable getStorePrintValues() { return this.stored_print_values; }
  public Hashtable getStoreSpecimenPrintValues() { return this.print_specimen_values; }
  public Hashtable getPrintSpecimenLables(){return this.print_specimen_labels;}  ////IN046592
  public Hashtable getOABookApptValues()	{ return this.oa_bookappt_values; }  // For Booking Appointment
  public Hashtable getExternalOrderBillSettlementDetails()	{ return this.external_order_stlmt_bill_data; }  // For External Order Billing Settlement Details  Added by Uma 3/20/2009
  public String getTrnGroupRefId()	{ return this.trn_group_ref; }  //Added by Uma 12/8/2009 for CRF-560
  /*Added by Uma on 8/22/2009 for PMG20089-CRF641*/
  public String getPrivilegeApplicability()
 {
	return this.privilege_applicability;
 }
 public String getPrivApplicability()
 {
	return this.priv_applicability;
 }
/* End Here*/
/*Added By Uma on 10/15/2009 for SRR20056-195*/
public Hashtable getStoreReportPrintValues() { return this.print_report_values; }
/*Ends Here*/
//IN064531 starts
public Hashtable getBarcodePrintValues() { return this.print_barcode_values; }
//IN064531 ends

public Hashtable getPrnLblvalues() { return this.prn_lbl_values; }//IN065942

//Modified by Sridhar Reddy on 050909 SRR20056-CRF-0274
  // If schedule Frequency has been entered(Method called from jsp on click of the hyperlink to show the values already entered)
  public ArrayList getScheduleFrequencyStr(String code,String row_value){
    ArrayList arr_hash = new ArrayList();
    //HashMap hash_val   = new HashMap();
    //HashMap  hash_map  = new HashMap();
   try{
        //int repeat     = 0;
		//String keyVal = code+"_"+row_value;
		arr_hash       = (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(  code, code+"_"+row_value);
       /*	if(hash_val!= null && hash_val.size() >0)
        {
			repeat 	   = Integer.parseInt(checkForNull((String) hash_val.get("repeat"),"0"));
	       // For Hours to be taken
	       for(int j=1 ; j <= repeat ; j++){
		       hash_map   = new HashMap();
				if(!checkForNull((String)hash_val.get("time"+j),"").equals(""))
		        {
         			 hash_map.put("admin_day","");
         			 hash_map.put("admin_day_or_time",(String)hash_val.get("admin_day_or_time"));
         			 hash_map.put("admin_time",checkForNull((String)hash_val.get("time"+j),""));
         			 hash_map.put("start_time_assign",(String) hash_val.get("start_time_assign"));
         			 hash_map.put("start_day_assign",(String) hash_val.get("start_day_assign"));
         			 arr_hash.add(hash_map) ;
        		}
       	    //hash_map.put("displayHrs"+j,checkForNull((String)hash_val.get("displayHrs"+j),""));
        	}
        	if(((String) hash_val.get("duration_type")).equals("W"))
        	{
        	     // For Days to be taken
        	   	for(int i=1 ; i <= 7 ; i++){
        	   	hash_map   = new HashMap();
        	   	if(checkForNull((String)hash_val.get("daySM"+i),"").equals("Y"))
        	   	{
					hash_map.put("admin_day_or_time",(String)hash_val.get("admin_day_or_time"));
	        	   	hash_map.put("admin_day",checkForNull((String)hash_val.get("daySM_display"+i),""));
        	   	    hash_map.put("start_time_assign",(String) hash_val.get("start_time_assign"));
           	        hash_map.put("start_day_assign",(String) hash_val.get("start_day_assign"));
           	  		hash_map.put("admin_time","");
           	  		arr_hash.add(hash_map) ;
           		}
           		//hash_map.put("dayDisplay"+i,checkForNull((String)hash_val.get("dayDisplay"  +i),""));
           	}
          }
        }*/ // End of hash_val
      /*   Do not clear the Values (hashMap), it will clear from the bean the values set in the hashmap
			if(hash_val!=null) {	hash_val.clear(); hash_val = null;	}
	        if(hash_map!=null) {		hash_map.clear(); hash_map = null;  }  */
      }
      catch(Exception e)
      {
		e.printStackTrace();
      }
    return arr_hash;
 }
//added for multiConsent by Hari on 03/05/07

 public HashMap getConsentFormDtl(String key) 
{
	return (HashMap)consentDetails.get(key) ;
}

// Added by Sridhar Reddy to call from OP Visitregistration
 /**
  **  Get the Instance of the OrderEntryRecordBean
  **/
  public void setOrderEntryRecordBean(eOR.Common.OrderEntryRecordBean orderEntryRecordBean){
       this.orderEntryRecordBean=orderEntryRecordBean;
  }
  public void setOrderEntryBillBean(eOR.OrderEntryBillingQueryBean orderEntryBillBean){
	 this.orderEntryBillBean=orderEntryBillBean;
  }
//End



 /**
  **  Get the Instance of the OrderEntryRecordBean
  **/
  public Object getOrderEntryRecordBean(){
       return this.orderEntryRecordBean;
  }

   /**
  **  Get the Instance of the OrderEntryRecordBean
  **/
  public Object getOrderEntryBillBean(){
	 return this.orderEntryBillBean;
  }

  public void clearDataBean() {
    orderEntryRecordBean.clearBean();
  }

  public void clearBillBean() {
    orderEntryBillBean.clearBean();
  }

/*********************METHOD TO SET AT ONCE*************************/
public void setAll( Hashtable recordSet ) 
{
	try
	{
		total_count			= (Integer.parseInt(checkForNull((String)recordSet.get("total_rows"),"0"))) ;
		amend_total_count   = (Integer.parseInt(checkForNull((String)recordSet.get("amend_total_rows"),"0"))) ;
    	care_set_count     	= (Integer.parseInt(checkForNull((String)recordSet.get("care_set_count"),"0"))) ;
    	validated_status   	= (String)recordSet.get("validated_status");
		
    	setAllValues(recordSet);
    	setMode((String)recordSet.get("mode")); // Set the Mode Common
		this.request     	= (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;	//Ramesh
		this.response     	= (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;	//Ramesh
  	}
  	catch(Exception e)
  	{
		e.printStackTrace();
  	}
 }//end of setALL

// Get the HashMap Value. In the Duplicate Check
public HashMap getAllValues() {
   return this.hashValues ;
}

// Set all the Values to be used for the Validation or for insertion/updation in ejb
protected void setAllValues(Hashtable recordSet) 
{	
  try
  {
		hashValues       			= new HashMap();  // Re-initialization done here
		count_chk_records			= 0;
		int total_order_cat_count	= 0;
		String catalog_code   		= "", catalog_code_desc = "";
		String catalog_code_dc		= "", catalog_code_ad  	= "", reg_reqd_yn  		= "";
		String ind_catalog_code		= "", order_type_code	= "", comment 			= "";
		String preps_instrn			= "", preps_dept_instrn	= "", pat_preps_instrn  = "";
		String header_comments		= "", cosign_reqd_yn	= "N";
		String Ccurrent="";
		ArrayList OrderFormatTypes	= null;
		String[] order_type_records	= null;
		StringTokenizer St_catalog_desc = null;
		String stop_message			= "";

		ArrayList arrSeqNo		= new ArrayList();
		HashMap orderFormatHash = new HashMap(); // To Store it in the HashMap
		boolean orset_ind_flag = isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
		//int i           		= 0;
		//IN055190 starts
		//hashValues.put("order_category",checkForNull((String)recordSet.get("order_category"),"")); // Order Category
		if(checkForNull((String)recordSet.get("order_category"),"").equals("CS"))
		{
			hashValues.put("order_category",checkForNull((String)recordSet.get("order_category"),"")); // Order Category
		}	
		//IN055190 ends
		hashValues.put("order_set_bill_yn",checkForNull((String)recordSet.get("order_set_bill_yn"),"N")); // Order Set Billing indicator
		hashValues.put("amend_order_set_bill_yn",checkForNull((String)recordSet.get("amend_order_set_bill_yn"),"N")); // Order Set Billing indicator
		/************************Email Orders Setting the Values**********************/
		if((checkForNull((String)recordSet.get("email_yn"),"").equals("Y")))
		{
			String locale = properties.getProperty("LOCALE");
			locale = (locale == null || locale.equals(""))?"en":locale;
			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
			java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
			displayDetail.append((String)buildEmailDetails());
			displayDetail.append("<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">");			displayDetail.append("<tr><td  width=\"30%\">"+or_labels.getString("eOR.OrderCatalogs.label")+"</td>");
			displayDetail.append("<td  width=\"40%\">"+common_labels.getString("Common.PatientInstructions.label")+"</td>");
			displayDetail.append("<td  width=\"40%\">"+common_labels.getString("Common.Comments.label")+"</td></tr>");
		}
		/************************Email Orders Setting the Values End**********************/
		/************************Amend/Review Orders Setting the Values**********************/
		//IN049419 Start.
		hashValues.put("amend_reason",checkForNull((String)getAmend_reason(),"")); 
		hashValues.put("amend_auditTrailYN", checkForNull((String)getAmend_auditTrailYN(),"N"));
		setAmend_reason("");
		setAmend_auditTrailYN("N");
		//IN049419 End.
		if(getAmendOrder().equalsIgnoreCase("existing_order"))
		{
			if(amend_total_count > 0)
			{		// Amend values to be set   //setAmendValues(amend_total_count,recordSet);
				stop_message = setAmendValues(recordSet);
			}
			// Setting the values for the Line

			for(int k=0;k<amend_total_count;k++)
			{
				if(checkForNull(stop_message,"").equals("")) 
				{ 
					// stop_message, First time will be "" and if any message is there don't proceed
					hashValues.put("removable_amend_catalog_code"+k,checkForNull((String)recordSet.get("amend_catalog_code"+k),"")); // ck+<catalog_code_value>
					hashValues.put("removable_bill_amend_catalog_code"+k,checkForNull((String)recordSet.get("amend_order_id"+k),"")+checkForNull((String)recordSet.get("amend_order_line_num"+k),"")); // amend_order_id+<amend_order_line_num>
					// For Amend no need to set the specimen_type and nurse_collect_yn, so pass it as Header
					//hashValues.put("amend_format_line_values"+k,setOrderFormat(("AMEND"+checkForNull((String)recordSet.get("amend_catalog_code"+k),"")), ("AMEND"+checkForNull((String)recordSet.get("amend_catalog_code"+k),"")+"_"+k),"Header",checkForNull((String)recordSet.get("lb_instal_yn"),"N"),checkForNull((String)recordSet.get("amend_order_category"+j),"CS"),0));
					stop_message = checkOrderFormat((checkForNull((String)recordSet.get("amend_catalog_code"+k),"")), (checkForNull((String)recordSet.get("amend_catalog_code"+k),"")+"_0"));

					hashValues.put("amend_format_line_values"+k, setOrderFormat((checkForNull((String)recordSet.get("amend_catalog_code"+k),"")), (checkForNull((String)recordSet.get("amend_catalog_code"+k),"")+"_0"), checkForNull((String)recordSet.get("amend_order_type"+k),""),"Line_Detail",checkForNull((String)recordSet.get("lb_instal_yn"),"N"), checkForNull((String)recordSet.get("amend_order_category"+k),"CS"), k));
				}  //End of if stop_message
			} // End of for
		} // End of if   getAmendOrder().equals("existing_order")
		/************************New Orders Setting the Values**********************/
		// For Header
		hashValues.put("authorized",checkForNull((String)recordSet.get("authorized"),"false"));
		hashValues.put("special_approved",checkForNull((String)recordSet.get("special_approved"),"false"));
		hashValues.put("consented",checkForNull((String)recordSet.get("consented"),"false"));
		// Call a method to get the Episode Id and Episode Visit Num and store it in the bean
		//getEpisode(checkForNull((String)recordSet.get("encounter_id"),""));
		hashValues.put("episode_id", checkForNull(getEpisodeID(),""));  // Episode Id passed to the EJB
		hashValues.put("episode_visit_num", checkForNull(getEpisodeVisitNum(),"")); // Episode Visit Num passed to the EJB
		hashValues.put("encounter_id",checkForNull((String)recordSet.get("encounter_id"),""));
		hashValues.put("email_yn",checkForNull((String)recordSet.get("email_yn"),""));
		hashValues.put("appl_user_name",checkForNull((String)recordSet.get("appl_user_name"),""));
		
		if (!language_id.equals("en"))
		{
			String sys_date=checkForNull((String)recordSet.get("sys_date"),"");
			sys_date = DateUtils.convertDate(sys_date,"DMYHM",language_id,"en");
			recordSet.put("sys_date",sys_date);
		}

		hashValues.put("sys_date",checkForNull((String)recordSet.get("sys_date"),""));
		hashValues.put("function_from",checkForNull((String)recordSet.get("function_from"),""));
		//Ramesh Start
		hashValues.put("deceased_yn",checkForNull((String)recordSet.get("deceased_yn"),""));
		hashValues.put("medico_legal_yn",checkForNull((String)recordSet.get("medico_legal_yn"),""));
		hashValues.put("postmortem_status",checkForNull((String)recordSet.get("postmortem_status"),""));
		hashValues.put("body_part_yn",checkForNull((String)recordSet.get("body_part_yn"),""));
		hashValues.put("registration_no",checkForNull((String)recordSet.get("registration_no"),""));
		//Ramesh End.
		hashValues.put("dup_override_reason",(HashMap)getDupeReasonHashMap()); // IN024984
		hashValues.put("task_code",checkForNull((String)recordSet.get("task_code"),""));
		hashValues.put("task_srl_no",checkForNull((String)recordSet.get("task_srl_no"),""));
		hashValues.put("patient_class", getPatientClass());

		hashValues.put("lb_instal_yn",checkForNull((String)recordSet.get("lb_instal_yn"),"N"));
		hashValues.put("rd_install_yn",checkForNull((String)recordSet.get("rd_install_yn"),"N"));
		hashValues.put("ot_install_yn",checkForNull((String)recordSet.get("ot_install_yn"),"N"));

		hashValues.put("xh_install_yn",checkForNull(getFacilityModuleInstallYn("XH"),"N"));

		// check if MO module is installed or not
		hashValues.put("mo_install_yn",checkForNull(getModuleInstallYn("MO"),"N"));
		if(checkForNull((String)hashValues.get("mo_install_yn"),"").equals("Y")) 
		{
			/*Modified by Uma on 1/11/2010 for IN017231 PMG20089-CRF-0830*/
			String[] record = (String[])getDeceasedPatientYn((String)recordSet.get("patient_id"));
			//hashValues.put("deceased_yn", checkForNull(getDeceasedPatientYn((String)recordSet.get("patient_id")),"N")); // FROM MP_patient
			hashValues.put("deceased_yn", checkForNull((String)record[0],"N")); // FROM MP_patient
			/*Ends Here*/
		} 
		else 
		{
			hashValues.put("deceased_yn", "N"); // othertime it will be N(patient is not deceased)
		}
		if(checkForNull((String)hashValues.get("mo_install_yn"),"").equals("Y") && checkForNull((String)hashValues.get("deceased_yn"),"").equals("Y")) 
		{
			hashValues.put("mo_mortuary_count",  String.valueOf(getMortuaryRegnCount((String)recordSet.get("patient_id")))); // FROM MO_MORTUARY_REGN
		}
		// If installed, then check if the patient is deceased or not
		hashValues.put("primary_order_type",checkForNull((String)recordSet.get("primary_order_type"),""));

		// For RD/OT Related
		hashValues.put("accession_type", checkForNull(getAccessionType(),""));
		hashValues.put("accession_number", checkForNull(getAccessionNumber(),""));
		if(checkForNull((String)recordSet.get("amend_order_set_bill_yn"),"N").equals("N"))
		{
			hashValues.put("billing_revise_order_set_dtls",orderEntryBillBean.getOrderBillDtls(getPatientId()+getEncounterId()+checkForNull((String)recordSet.get("care_set_catalog_code"),"")));
		}

		// For the Line Details (Set the values)
		for(int j=0;j<total_count;j++)
		{
			String startedtime="";
			String started_time="";
			catalog_code = checkForNull(((String)recordSet.get("catalog_code"+j)),"");
			hashValues.put("removable_catalog_code"+j,checkForNull((String)recordSet.get("catalog_code"+j),"")); // ck+<catalog_code_value>
			if(checkForNull((String)recordSet.get("ck"+catalog_code),"N").equalsIgnoreCase("Y") && checkForNull(stop_message,"").equals("")) // stop_message, First time will be "" and if any message is there don't proceed
			{
				if(orset_ind_flag)
					chkOrderCatalogCode =chkOrderCatalogCode+catalog_code+"~"; //IN067246
				hashValues.put("catalog_code"+count_chk_records,checkForNull((String)recordSet.get("catalog_code"+j),"")); // ck+<catalog_code_value>
				hashValues.put("cat_desc"+count_chk_records,checkForNull((String)recordSet.get("cat_desc"+j),""));
				hashValues.put("order_catalog_nature"+count_chk_records,checkForNull((String)recordSet.get("order_catalog_nature"+j),""));
				hashValues.put("order_type"+count_chk_records,checkForNull((String)recordSet.get("order_type"+j),""));
				startedtime=checkForNull((String)recordSet.get("start_date_time"+j),"");
				/*thai date change*/
				if (!language_id.equals("en"))
				{
					started_time = DateUtils.convertDate(startedtime,"DMYHM",language_id,"en");
					recordSet.put("start_date_time"+j,started_time);
				}

				Ccurrent = DateUtils.getCurrentDate("DMYHM",language_id);

				if(startedtime.equals(Ccurrent) || !DateUtils.isAfterNow (startedtime,"DMYHM",language_id))
				{
					hashValues.put("Ccurrent"+count_chk_records,"N");					
				}
				else
				{
					hashValues.put("Ccurrent"+count_chk_records,"Y");
				}
				/*thai date change*/

				/* Added By Uma on 8/28/2009, For CRF 640-OR*/
				if((((checkForNull((String)recordSet.get("appt_reqd_yn"+count_chk_records),"N")).equalsIgnoreCase("Y"))&&((((checkForNull((String)recordSet.get("routine_appt_reqd_yn"+count_chk_records),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("priority"+count_chk_records),"")).equalsIgnoreCase("R")))||((((checkForNull((String)recordSet.get("stat_appt_reqd_yn"+count_chk_records),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("priority"+count_chk_records),"")).equalsIgnoreCase("S")))||((((checkForNull((String)recordSet.get("urgent_appt_reqd_yn"+count_chk_records),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("priority"+count_chk_records),"")).equalsIgnoreCase("U")))))
				{
					hashValues.put("future_order_YN"+count_chk_records,"N");
				}
				else
				{
					/* Added By Kishore kumar N on 05-Aug-09, For CRF 640-OR*/
					if(startedtime.equals(Ccurrent) || !DateUtils.isAfterNow (startedtime,"DMYHM",language_id))
					{
						hashValues.put("future_order_YN"+count_chk_records,"N");
					}
					else
					{
						hashValues.put("future_order_YN"+count_chk_records,checkForNull(getFutureOderYn((String)recordSet.get("catalog_code"+j) ,getPatientClass(),(String)recordSet.get("start_date_time"+j)),"N"));
					}
					/* ends here.*/
				}
				/* End Here*/ hashValues.put("start_date_time"+count_chk_records,checkForNull((String)recordSet.get("start_date_time"+j),""));
				hashValues.put("priority"+count_chk_records,checkForNull((String)recordSet.get("priority"+j),""));
				hashValues.put("quantity"+count_chk_records,checkForNull((String)recordSet.get("quantity"+j),""));
				hashValues.put("quantity_uom"+count_chk_records,checkForNull((String)recordSet.get("quantity_uom"+j),""));
				hashValues.put("frequency_val"+count_chk_records,checkForNull((String)recordSet.get("frequency_val"+j),""));
				hashValues.put("duration"+count_chk_records,checkForNull((String)recordSet.get("duration"+j),""));
				hashValues.put("duration_value"+count_chk_records,checkForNull((String)recordSet.get("duration_value"+j),""));

				/*thai date change*/
				if (!language_id.equals("en"))
				{
					String end_date_time=checkForNull((String)recordSet.get("end_date_time"+j),"");
					end_date_time = DateUtils.convertDate(end_date_time,"DMYHM",language_id,"en");
					recordSet.put("end_date_time"+j,end_date_time);
				}
				/*thai date change*/

				hashValues.put("end_date_time"+count_chk_records,checkForNull((String)recordSet.get("end_date_time"+j),""));
				hashValues.put("chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_yn"+j),""));
				hashValues.put("chk_for_dupl_status"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_status"+j),""));
				hashValues.put("activity_type"+count_chk_records,checkForNull((String)recordSet.get("activity_type"+j),""));
				hashValues.put("check_for_dupl_level"+count_chk_records,checkForNull((String)recordSet.get("check_for_dupl_level"+j),""));
				hashValues.put("chk_for_dupl_ahead_action"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_ahead_action"+j),""));
				hashValues.put("chk_for_dupl_ahead_period"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_ahead_period"+j),""));
				hashValues.put("chk_for_dupl_ahead_unit"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_ahead_unit"+j),""));
				hashValues.put("chk_for_dupl_behind_action"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_behind_action"+j),""));
				hashValues.put("chk_for_dupl_behind_period"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_behind_period"+j),""));
				hashValues.put("chk_for_dupl_behind_unit"+count_chk_records,checkForNull((String)recordSet.get("chk_for_dupl_behind_unit"+j),""));
				hashValues.put("contr_msr_panel_id"+count_chk_records,checkForNull((String)recordSet.get("contr_msr_panel_id"+j),""));

				hashValues.put("ord_auth_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("ord_auth_reqd_yn"+j),"N"));
				hashValues.put("authorised_yn"+count_chk_records,checkForNull((String)recordSet.get("authorised_yn"+j),"N"));
				if(checkForNull((String)recordSet.get("cosign_reqd_yn"),"N").equals("Y"))
				{
					cosign_reqd_yn = "Y";
				}
				else
				{
					cosign_reqd_yn = checkForNull((String)recordSet.get("ord_cosign_reqd_yn"+j),"N");
				}

				hashValues.put("ord_cosign_reqd_yn"+count_chk_records, cosign_reqd_yn);
				hashValues.put("ord_consent_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("ord_consent_reqd_yn"+j),"N"));
				hashValues.put("complete_on_order_yn"+count_chk_records,checkForNull((String)recordSet.get("complete_on_order_yn"+j),"N"));
				hashValues.put("ord_spl_appr_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("ord_spl_appr_reqd_yn"+j),"N"));
				hashValues.put("result_applicable_yn"+count_chk_records,checkForNull((String)recordSet.get("result_applicable_yn"+j),"N"));
				hashValues.put("bill_yn"+count_chk_records,checkForNull((String)recordSet.get("bill_yn"+j),"N"));
				hashValues.put("billing_call_yn"+count_chk_records,checkForNull((String)recordSet.get("billing_call_yn"+j),"N"));
				hashValues.put("billing_revise_dtls"+count_chk_records,orderEntryBillBean.getOrderBillDtls(getPatientId()+getEncounterId()+checkForNull((String)recordSet.get("catalog_code"+j),"")));
				hashValues.put("fpp_yn"+count_chk_records,checkForNull((String)recordSet.get("fpp_yn"+j),""));//IN068314
				hashValues.put("fpp_category"+count_chk_records,checkForNull((String)recordSet.get("fpp_category"+j),""));//IN068314
				//if(com.ehis.util.DateUtils.isAfterNow (startedtime,"DMYHM",language_id))
				/*Added by Uma on 8/28/2009 for PMG20089 -CRF 640*/
				if((((checkForNull((String)recordSet.get("appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&((((checkForNull((String)recordSet.get("routine_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("priority"+j),"")).equalsIgnoreCase("R")))||((((checkForNull((String)recordSet.get("stat_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("priority"+j),"")).equalsIgnoreCase("S")))||((((checkForNull((String)recordSet.get("urgent_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("priority"+j),"")).equalsIgnoreCase("U")))))
				{
					hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("bill_now"+j),"N"));
				}
				else
				{
					if(startedtime.equals(Ccurrent) || !DateUtils.isAfterNow (startedtime,"DMYHM",language_id))
					{
						hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
					}
					else
					{
						String future_flag="";
						if(startedtime.length()>0&&checkForNull((String)recordSet.get("future_date"+j),"").length()>0&&!startedtime.equals("")&&!checkForNull((String)recordSet.get("future_date"+j),"").equals(""))
						{
							future_flag=getFutureChkYN(startedtime,checkForNull((String)recordSet.get("future_date"+j),""));
							if(future_flag.equalsIgnoreCase("Y"))
							{
								hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("bill_now"+j),"N"));
							}
							else
							{
								hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
							}
						}
						else
						{
							hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
						}		
					}
				}
				/* End Here*/
				arrSeqNo				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+catalog_code, catalog_code);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
					comment 				=  (String) arrSeqNo.get(0); // comment
					preps_instrn         =  (String) arrSeqNo.get(1); // preps
					preps_dept_instrn    =  (String) arrSeqNo.get(2); // Dept
					pat_preps_instrn     =  (String) arrSeqNo.get(3); // patient Instrn.
				}
				else
				{
					comment 			= ""; preps_instrn      = "";
					preps_dept_instrn	= "" ; pat_preps_instrn  = "";
				}
				if((checkForNull((String)recordSet.get("email_yn"),"").equals("Y")))
				{

					if(comment.equals("")&&pat_preps_instrn.equals(""))
					{
					}
					else
					{
						displayDetail.append("<tr><td wrap=\"yes\" width=\"30%\">");
						displayDetail.append(getEmailCatalogDesc(catalog_code));
						displayDetail.append("</td><td wrap=\"yes\" width=\"40%\">");
						displayDetail.append(pat_preps_instrn);
						displayDetail.append("</td><td wrap=\"yes\" width=\"40%\">");
						displayDetail.append(comment);
						displayDetail.append("</td></tr>");
					}
				}
				hashValues.put("line_comments"+count_chk_records,checkForNull(comment,""));
				hashValues.put("line_preps"+count_chk_records,checkForNull(preps_instrn,""));
				hashValues.put("line_pat_instrn"+count_chk_records,checkForNull(pat_preps_instrn,""));
				hashValues.put("line_dept_instrn"+count_chk_records,checkForNull(preps_dept_instrn,""));

				//}
				hashValues.put("performing_facility_id"+count_chk_records,checkForNull((String)recordSet.get("performing_facility_id"+j),""));
				// For Field Mnemonic Fields
				// First time the specimen type,nurse collect(For Lab) and study_loc (For Radiology Dept) is set from the screen, they will be null
				hashValues.put("specimen_type"+count_chk_records,checkForNull((String)recordSet.get("specimen_type"+j),""));
				hashValues.put("specimen_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("specimen_reqd_yn"+j),"N")); // //First time  it will be null, Only in SetOrderformat value will be set to insert into the LB table
				hashValues.put("collection_stage"+count_chk_records,checkForNull((String)recordSet.get("collection_stage"+j),""));
				// //First time  it will be null, Only in SetOrderformat value will be set to insert into the LB table
				hashValues.put("dispatch_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("dispatch_reqd_yn"+j),"N")); // //First time  it will be null, Only in SetOrderformat value will be set to insert into the LB table

				hashValues.put("nurse_collect"+count_chk_records,checkForNull((String)recordSet.get("nurse_collect"+j),"N"));
				hashValues.put("study_loc"+count_chk_records,checkForNull((String)recordSet.get("study_loc"+j),"")); //First time  it will be null, Only in SetOrderformat value will be set
				hashValues.put("pregnant_yn"+count_chk_records,checkForNull((String)recordSet.get("pregnant_yn"+j),"")); //First time  it will be null, Only in SetOrderformat value will be set
				hashValues.put("lmp_date"+count_chk_records,checkForNull((String)recordSet.get("lmp_date"+j),"")); //First time  it will be null, Only in SetOrderformat value will be set
				hashValues.put("notify_yn"+count_chk_records, checkForNull((String)recordSet.get("notify_yn"+j),"N")); //First time  it will be null, Only in SetOrderformat value will be set

				// Till here
				hashValues.put("appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("appt_reqd_yn"+j),"N"));
				hashValues.put("routine_appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("routine_appt_reqd_yn"+j),"N"));
				hashValues.put("stat_appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("stat_appt_reqd_yn"+j),"N"));
				hashValues.put("urgent_appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("urgent_appt_reqd_yn"+j),"N"));
				hashValues.put("chart_result_type"+count_chk_records,checkForNull((String)recordSet.get("chart_result_type"+j),"D"));
				hashValues.put("routine_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("routine_chk_for_dupl_yn"+j),"N"));
				hashValues.put("urgent_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("urgent_chk_for_dupl_yn"+j),"N"));
				hashValues.put("stat_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("stat_chk_for_dupl_yn"+j),"N"));
				hashValues.put("consent_stage"+count_chk_records,checkForNull((String)recordSet.get("consent_stage"+j),""));
				//added on 08/05/07
				hashValues.put("consent_form_id"+count_chk_records,checkForNull((String)recordSet.get("consent_form_id"+j),""));//IN030298
				hashValues.put("num_of_consent_req_bo"+count_chk_records,checkForNull((String)recordSet.get("num_of_consent_req_bo"+j),"0"));
				hashValues.put("num_of_consent_req_br"+count_chk_records,checkForNull((String)recordSet.get("num_of_consent_req_br"+j),"0"));
				
				if(checkForNull((String)recordSet.get("ord_consent_reqd_yn"+j),"N").equals("Y"))
				{
					if(getConsentFormDtl(j+catalog_code+(String)hashValues.get("order_category")) != null)
					{
						hashValues.put("multi_consent_dtl"+count_chk_records,(HashMap)getConsentFormDtl(j+catalog_code+(String)hashValues.get("order_category")));
					}
					//else
					//{
					//hashValues.put("multi_consent_dtl"+count_chk_records,(HashMap)getConsent(catalog_code));
					//}
				}//ends here

				hashValues.put("auto_report_yn"+count_chk_records,checkForNull((String)recordSet.get("auto_report_yn"+j),"N"));
				hashValues.put("result_auth_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("result_auth_reqd_yn"+j),"N"));
				hashValues.put("order_category"+count_chk_records,checkForNull((String)recordSet.get("group_order_category"+j),"CS"));
				hashValues.put("freq_nature"+count_chk_records,checkForNull((String)recordSet.get("freq_nature"+j),"F"));
				hashValues.put("cont_order_yn"+count_chk_records,checkForNull((String)recordSet.get("cont_order_yn"+j),"N"));
				hashValues.put("end_date_time"+count_chk_records,checkForNull((String)recordSet.get("end_date_time"+j),""));
				hashValues.put("performing_dept_loc_code"+count_chk_records,checkForNull((String)recordSet.get("performing_dept_loc_code"+j),""));

				//REDEFINE THE APPT_REQD_YN BASED UPON THE PRIORITY/STAT/URGENT APPT_REQD_YN
				if(!((String)recordSet.get("locn_appt_reqd_yn"+j)).equals(""))
				{
					if(checkForNull((String)recordSet.get("priority"+j),"").equals("R"))
					{
						if((((String)recordSet.get("routine_appt_reqd_yn"+j)).equals("Y")) && (((String)recordSet.get("locn_appt_reqd_yn"+j)).equals("Y")))
						{
							hashValues.put("appt_reqd_yn"+count_chk_records,"Y");
						}
						else
						{
							hashValues.put("appt_reqd_yn"+count_chk_records,"N");
						}
					}
					else if(checkForNull((String)recordSet.get("priority"+j),"").equals("S"))
					{
						if((((String)recordSet.get("stat_appt_reqd_yn"+j)).equals("Y")) && (((String)recordSet.get("locn_appt_reqd_yn"+j)).equals("Y")))
						{
							hashValues.put("appt_reqd_yn"+count_chk_records,"Y");
						}
						else
						{
							hashValues.put("appt_reqd_yn"+count_chk_records,"N");
						}
					}
					else if(checkForNull((String)recordSet.get("priority"+j),"").equals("U"))
					{
						if((((String)recordSet.get("urgent_appt_reqd_yn"+j)).equals("Y")) && (((String)recordSet.get("locn_appt_reqd_yn"+j)).equals("Y")))
						{
							hashValues.put("appt_reqd_yn"+count_chk_records,"Y");
						}
						else
						{
							hashValues.put("appt_reqd_yn"+count_chk_records,"N");
						}
					}
				}
				else
				{
					if(checkForNull((String)recordSet.get("priority"+j),"").equals("R"))
					{
						hashValues.put("appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("routine_appt_reqd_yn"+j),"N"));
					}
					else if(checkForNull((String)recordSet.get("priority"+j),"").equals("S"))
					{
						hashValues.put("appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("stat_appt_reqd_yn"+j),"N"));
					}
					else if(checkForNull((String)recordSet.get("priority"+j),"").equals("U"))
					{
						hashValues.put("appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("urgent_appt_reqd_yn"+j),"N"));
					}
				}
				//IN31901 Starts
				/*if(Constants.ORDER_CATEGORY.equals((String)recordSet.get("order_category"))){
					if("".equals((String)recordSet.get("performing_dept_loc_code"+j)))
					{	
						//hashValues.put("appt_reqd_yn"+count_chk_records,"Y"); //--[IN035349] Commented
						hashValues.put("appt_reqd_yn"+count_chk_records,(String)hashValues.get("appt_reqd_yn"+count_chk_records));//--[IN035349]
					}else
					{
						hashValues.put("appt_reqd_yn"+count_chk_records,"N");
					}
				}*/
				//IN31901 Ends
				// Order set and for Pharmacy only value will be there for others null
				hashValues.put("form_code"+count_chk_records,checkForNull((String)recordSet.get("form_code"+j),""));
				hashValues.put("route_code"+count_chk_records,checkForNull((String)recordSet.get("route_code"+j),""));
				hashValues.put("strength_value"+count_chk_records,checkForNull((String)recordSet.get("strength_value"+j),""));
				hashValues.put("dosage_by"+count_chk_records,checkForNull((String)recordSet.get("dosage_by"+j),""));
				hashValues.put("dosage"+count_chk_records,checkForNull((String)recordSet.get("dosage"+j),""));
				hashValues.put("strength_per_pres_uom"+count_chk_records,checkForNull((String)recordSet.get("strength_per_pres_uom"+j),""));
				hashValues.put("strength_per_value_pres_uom"+count_chk_records,checkForNull((String)recordSet.get("strength_per_value_pres_uom"+j),""));
				hashValues.put("fract_dose_round_up_yn"+count_chk_records,checkForNull((String)recordSet.get("fract_dose_round_up_yn"+j),""));
				hashValues.put("content_in_pres_base_uom"+count_chk_records,checkForNull((String)recordSet.get("content_in_pres_base_uom"+j),""));
				hashValues.put("prn_doses_pres_prd_fill"+count_chk_records,checkForNull((String)recordSet.get("prn_doses_pres_prd_fill"+j),""));
				hashValues.put("uom"+count_chk_records,checkForNull((String)recordSet.get("uom"+j),""));
				hashValues.put("pres_base_uom"+count_chk_records,checkForNull((String)recordSet.get("pres_base_uom"+j),""));
				hashValues.put("repeat_value"+count_chk_records,checkForNull((String)recordSet.get("repeat_value"+j),""));
				hashValues.put("stock_uom"+count_chk_records,checkForNull((String)recordSet.get("stock_uom"+j),""));

				// PH Details.
				// Get the Description For the Catalog
				// Call a method getOrderCatalogDesc() to get the value for the CATALOG_SYNONYM_DC,CATALOG_SYNONYM_AD
				catalog_code_desc = checkForNull(getOrderCatalogDesc(catalog_code),"");
				if(!catalog_code_desc.equals(""))
				St_catalog_desc = new StringTokenizer(catalog_code_desc,"~");
				while(St_catalog_desc.hasMoreTokens())
				{
					catalog_code_dc     = checkForNull(St_catalog_desc.nextToken(),"");   // Get the Description for catalog_code_dc
					catalog_code_ad     = checkForNull(St_catalog_desc.nextToken(),"");   // Get the Description for catalog_code_ad
				}
				hashValues.put("catalog_code_dc"+count_chk_records,catalog_code_dc);
				hashValues.put("catalog_code_ad"+count_chk_records,catalog_code_ad);
				hashValues.put("order_line_seq_num"+count_chk_records,checkForNull((String)recordSet.get("order_line_seq_num"+j),""));
				// Call a method getRegReqdValue() to get the regd. reqdyn, but if Order_category is "LB" and lab Module (RL)is installed , or order_category is "RD" and RD Module (RD) is installed or order_category is "OT" and OT Module (OT) is installed then make the reg_reqd_yn as "N"
				if( ((checkForNull((String)recordSet.get("group_order_category"+j),"CS").equalsIgnoreCase("LB")) && (checkForNull((String)recordSet.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) )  ||  ((checkForNull((String)recordSet.get("group_order_category"+j),"CS").equalsIgnoreCase("RD")) && (checkForNull((String)recordSet.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) )  || ((checkForNull((String)recordSet.get("group_order_category"+j),"CS").equalsIgnoreCase("OT")) && (checkForNull((String)recordSet.get("ot_install_yn"),"N").equalsIgnoreCase("Y")) )) // If Order_category is "LB" and lab is installed , or order_category is "RD" and RD  is installed or order_category is "OT" and "OT" is installed then make the reg_reqd_yn as "N"
				reg_reqd_yn  = "N";
				else
				reg_reqd_yn = ((String)getRegReqdValue((String)recordSet.get("order_type"+j)));
				
				hashValues.put("reg_reqd_yn"+count_chk_records, checkForNull(reg_reqd_yn,"N"));
				// Call a method getOrderStatus() to get the order status code

				//hashValues.put("order_status_code"+count_chk_records,(getOrderStatus(checkForNull((String)recordSet.get("ord_auth_reqd_yn"+j),"N"),checkForNull(((String)recordSet.get("ord_consent_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("complete_on_order_yn"+j)),"N"),checkForNull(reg_reqd_yn,"N"),checkForNull(((String)recordSet.get("ord_spl_appr_reqd_yn"+j)),"N"),((String)hashValues.get("authorized")),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")), checkForNull((String)hashValues.get("consent_stage"+j),""),checkForNull((String)hashValues.get("auto_report_yn"+j),"N"), checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N"),  checkForNull((String)hashValues.get("xh_install_yn"),"N") )));

				hashValues.put("order_status_code"+count_chk_records,(getOrderStatus(checkForNull((String)recordSet.get("ord_auth_reqd_yn"+j),"N"),checkForNull(((String)recordSet.get("ord_consent_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("complete_on_order_yn"+j)),"N"),checkForNull(reg_reqd_yn,"N"),checkForNull(((String)recordSet.get("ord_spl_appr_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("authorised_yn"+j)),"N"),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")), checkForNull((String)hashValues.get("consent_stage"+j),""),checkForNull((String)hashValues.get("auto_report_yn"+j),"N"), checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N"),  checkForNull((String)hashValues.get("xh_install_yn"),"N") )));


				stop_message = checkOrderFormat((checkForNull((String)recordSet.get("catalog_code"+j),"")),  (checkForNull((String)recordSet.get("catalog_code"+j),"")+"_0")); // call a method to check if the order has to be stopped or not if any field_mnemonic is attached to it

				hashValues.put("header_line_values"+count_chk_records,setOrderFormat(checkForNull((String)recordSet.get("catalog_code"+j),""), (checkForNull((String)recordSet.get("catalog_code"+j),"")+"_0"),checkForNull((String)recordSet.get("order_type"+j),""),"Line_Detail",checkForNull((String)recordSet.get("lb_instal_yn"),"N"),checkForNull((String)recordSet.get("group_order_category"+j),"CS"),count_chk_records));
				// For the Schedule Frequency, calling a method setScheduleFormat() where it will set the values for each line
				hashValues.put("schedule_format_line_values"+count_chk_records,setScheduleFormat(checkForNull("Schedule"+(String)recordSet.get("catalog_code"+j),""), ("Schedule"+checkForNull((String)recordSet.get("catalog_code"+j),"")+"_"+j)));
				hashValues.put("splty_code"+count_chk_records, checkForNull((String)recordSet.get("splty_code"+j),""));
				hashValues.put("barcode_reqd_yn"+count_chk_records, checkForNull((String)recordSet.get("barcode_reqd_yn"+j),""));//IN063816
				hashValues.put("prn_regd_ord"+count_chk_records, checkForNull((String)recordSet.get("prn_regd_ord"+j),""));//IN065942
				hashValues.put("format_id"+count_chk_records,checkForNull((String)recordSet.get("format_id"+j),""));//IN066436
				hashValues.put("instrn_content_type"+count_chk_records,checkForNull((String)recordSet.get("instrn_content_type"+j),"T"));//IN64543
				count_chk_records++;
				//i++;
			}
		}  
		
		//Set all the individual hdg values and also the line values into tabData
		if((checkForNull((String)recordSet.get("email_yn"),"").equals("Y")))
		{
			displayDetail.append("</table></html>");
			hashValues.put("displayDetail",displayDetail.toString());
			displayDetail.setLength(0);
		}
		/* for thai date change*/
		if ( !language_id.equals("en") )
		{
			String order_date_time = (String)recordSet.get("order_date_time");
			if (order_date_time.equals(" ") || order_date_time.equals("null")) order_date_time="";
			order_date_time = DateUtils.convertDate(order_date_time,"DMYHM",language_id,"en");
			recordSet.put("order_date_time",order_date_time);
		}
		/* for thai date change */
		String locale = properties.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		hashValues.put("order_date_time",checkForNull((String)recordSet.get("order_date_time"),""));
		header_comments  =  checkForNull((String)recordSet.get("header_comments"),"");

		if(header_comments.indexOf("\"")!=-1)
			header_comments= header_comments.replace('"','\n');
		
		hashValues.put("header_comments",java.net.URLDecoder.decode(header_comments,"UTF-8"));
		hashValues.put("multi_patient_details", getMultiPatientDetails()); // set all the patient_details arraylist will be used in MultiPatientOrders
		hashValues.put("patient_id",checkForNull((String)recordSet.get("patient_id"),""));
		hashValues.put("location_type",checkForNull((String)recordSet.get("location_type"),""));
		hashValues.put("location_code",checkForNull((String)recordSet.get("location_code"),""));
		hashValues.put("ordering_practitioner_id",getPractitionerId());
		hashValues.put("cosigned",checkForNull((String)recordSet.get("cosigned"),"false"));
		hashValues.put("priority_hdr",checkForNull((String)recordSet.get("priority_hdr"),""));
		hashValues.put("order_mode",getOrderMode());	// For the order_mode
   		hashValues.put("session_id",checkForNull((String)recordSet.get("session_id"),""));
		hashValues.put("total_count",String.valueOf(count_chk_records));
		hashValues.put("care_set_catalog_code",(checkForNull((String)recordSet.get("care_set_catalog_code"),""))); // For Order Set catalog_code(order_set_id)
		hashValues.put("care_set_catalog_desc",(checkForNull((String)recordSet.get("care_set_catalog_desc"),""))); // For Order Set catalog_desc(order_set_id)
		hashValues.put("called_from",(checkForNull((String)recordSet.get("called_from"),""))); // For Order Set catalog_code(order_set_id)
		hashValues.put("amend_total_count",String.valueOf(amend_total_count)); // for Amend
		hashValues.put("care_set_count", String.valueOf(care_set_count)); // for Amend
		hashValues.put("multi_patient_details", getMultiPatientDetails()); // For the Multi Patient Orders
		hashValues.put("ref_facility_id", checkForNull((String)recordSet.get("ref_facility_id"),"")); // For the External Orders
		/*thai date change*/
		if ( !language_id.equals("en") )
		{

			String ref_date_time = (String)recordSet.get("ref_date_time");
			if (ref_date_time.equals(" ") || ref_date_time.equals("null") || ref_date_time == null) 
				ref_date_time="";

			if(ref_date_time!=null && ref_date_time!="")
			{
				ref_date_time = DateUtils.convertDate(ref_date_time,"DMYHM",language_id,"en");
			}
			recordSet.put("ref_date_time",ref_date_time);

		}
		/* thai date cahnge*/
		hashValues.put("ref_date_time",(String)recordSet.get("ref_date_time")); // For the External Orders
		hashValues.put("ref_sent_pract_id", checkForNull((String)recordSet.get("ref_sent_pract_id"),"")); // For the External Orders
		hashValues.put("ref_sent_remarks", checkForNull((String)recordSet.get("ref_sent_remarks"),"")); // For the External Orders
		order_category		= checkForNull((String)recordSet.get("order_category"),"");
		total_order_cat_count = (Integer.parseInt(checkForNull((String)recordSet.get("total_order_cat_count"),"0"))) ;
		hashValues.put("total_order_cat_count", String.valueOf(total_order_cat_count)); // When called from Preview
		//Query from mp_patient and find whether it is a deceased patient or not

		// For the Order Formats Header, call a function which will return a HashMap with all values
		if(care_set_count>0)  // then check if it is coming from preview..
		total_order_cat_count = care_set_count;
		if(total_order_cat_count > 0)  // Only For Care Sets (or when it is coming from Preview)
		{
			for(int t=0;t<total_order_cat_count;t++)
			{
				//hashValues.put("header_format_values"+t,setOrderFormat(checkForNull((String)recordSet.get("care_set_order_category"+t),""), (checkForNull((String)recordSet.get("care_set_order_category"+t),"")+"_"+"0"),"Line_Detail",checkForNull((String)recordSet.get("lb_instal_yn"),"N"),checkForNull((String)recordSet.get("care_set_order_category"+j),"CS"),t)));
				// Pass a string as "Detail" to set the value for the specimen_type and nurse_collect_yn for Lab and study_loc for Radiology Dept.
				OrderFormatTypes	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE_CARE_SET"+checkForNull((String)recordSet.get("care_set_order_category"+t),""), "0");
				if(OrderFormatTypes==null) // If not present, then if it comes from the PHARMACY
				OrderFormatTypes	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE"+checkForNull((String)recordSet.get("care_set_order_category"+t),""), "0");
				//if(OrderFormatTypes==null) // If not present, then if it comes from the PHARMACY
				//OrderFormatTypes	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE"+checkForNull((String)recordSet.get("order_category"+t),""), "0");

				if(OrderFormatTypes!=null && OrderFormatTypes.size() > 0) //Other than header there will be only one loop
				{
					for(int count=0;count<OrderFormatTypes.size();count++)	// Only one loop for line level
					{
						if(checkForNull(stop_message,"").equals("")) 
						{
							order_type_records 			= (String[])OrderFormatTypes.get(count);
							order_type_code				= order_type_records[1]; // Take only the order type code(For Pharamcy order_type_code may be null so make it ALL)
							if(order_type_code!=null && order_type_code.equals("ALL"))
							order_type_code			= "";
							if(care_set_count>0)		 // then coming from the care sets
							ind_catalog_code		= "ORDER_SET"+ order_type_code+checkForNull((String)recordSet.get("care_set_order_category"+t),"");
							else // From Preview
							//ind_catalog_code		= checkForNull((String)recordSet.get("care_set_order_category"+t),""); // commented for IN045340
							ind_catalog_code		= order_type_code + checkForNull((String)recordSet.get("care_set_order_category"+t),""); // modified for IN045340
							// Check for the message,if it is there stop it
							stop_message = checkOrderFormat((ind_catalog_code), (ind_catalog_code+"_"+"0"));  //No catalog description header level
							// Store the values in the Hash Map bind with the Order Type code

							orderFormatHash.put("header_format_values"+order_type_code, setOrderFormat(ind_catalog_code, ind_catalog_code+"_"+"0",order_type_code,"Line_Detail",checkForNull((String)recordSet.get("lb_instal_yn"),"N"),checkForNull((String)recordSet.get("care_set_order_category"+t),"CS")  ,0));

						} // End of if stop_message
					} // End of for count
					hashValues.put("header_format_values"+t, orderFormatHash);


				} // End of orderformattypes
				else // put an empty values
				hashValues.put("header_format_values"+t, orderFormatHash);
				hashValues.put("care_set_order_category"+t,(checkForNull((String)recordSet.get("care_set_order_category"+t),"")));
			}

		}
		else  // For Other Orders(No need to set the specimen_type,nurse_collect and study_loc so pass a string as  'Header')
		{     // This is the Header Level only, Take the value from the bean
			// Same for the Amend Order and New Orders
			OrderFormatTypes	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE"+order_category, "0");
			if(OrderFormatTypes!=null && OrderFormatTypes.size() > 0) //Other than header there will be only one loop
			{
				for(int count=0;count<OrderFormatTypes.size();count++)	// Only one loop for line level
				{
					if(checkForNull(stop_message,"").equals("")) 
					{
						order_type_records 			= (String[])OrderFormatTypes.get(count);
						order_type_code				= order_type_records[1]; // Take only the order type code
						ind_catalog_code			= order_type_code+(checkForNull((String)recordSet.get("order_category"),""));
						stop_message				= checkOrderFormat((ind_catalog_code), (ind_catalog_code+"_"+"0"));  //No catalog description header level

						// Store the values in the Hash Map bind with the Order Type code
						orderFormatHash.put("header_format_values"+order_type_code, setOrderFormat(ind_catalog_code, ind_catalog_code+"_"+"0",order_type_code,"Header",checkForNull((String)recordSet.get("lb_instal_yn"),"N"), checkForNull((String)recordSet.get("order_category"),"CS"),0));
					}
				}
				hashValues.put("header_format_values", orderFormatHash);

			}
			else // put an empty values
			hashValues.put("header_format_values",orderFormatHash);
		}

		hashValues.put("pract_type",recordSet.get("pract_type"));//IN065942

		hashValues.put("stop_message",stop_message); // Set it in the hashmap, will return from the insert method
		/*********************Till Here **********************************/
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

/*
 *  Setting the Values for the Amend/Review Order
 */
private String setAmendValues(Hashtable recordSet) throws Exception
{
//String amend_grouping	= "";
String amend_catalog_code = "" , comment		 = "",  stop_message	 = "";
String preps_instrn		= "", preps_dept_instrn  = "" , pat_preps_instrn = "";
String catalog_code_desc= "", catalog_code_dc    = "" , catalog_code_ad  = "";
String reg_reqd_yn		= "", cosign_reqd_yn	 = "N";
StringTokenizer St_catalog_desc = null;
ArrayList arrSeqNo		= new ArrayList();
String labchk="";
String amend_start_date_time="";
String amendstartdatetime="";
String start_date_time="";
String Ccurrent="";

try
{
for(int j=0;j<amend_total_count;j++) //For the Amend Count total
{
	amend_catalog_code = checkForNull((String)recordSet.get("amend_catalog_code"+j),"");
	if(checkForNull(stop_message,"").equals(""))
   { // first time willbe "" , stop when any message is there
		new_amend_frequency_value = checkForNull((String)recordSet.get("amend_frequency_val"+j),"");
		if(new_amend_frequency_value.indexOf("~~")!=-1)
		{
			amend_frequency_value = (String[])new_amend_frequency_value.split("~~");
			new_amend_frequency_value = amend_frequency_value[0];
		}	
	
		boolean diff= (Boolean)compareArrayList(((ArrayList)getScheduleFrequency(((String)recordSet.get("amend_order_id"+j)),((String)recordSet.get("amend_order_line_num"+j)))),((ArrayList)setScheduleFormat(checkForNull("Schedule"+(String)recordSet.get("amend_catalog_code"+j),""), ("Schedule"+checkForNull((String)recordSet.get("amend_catalog_code"+j),"")+"_"+j))),((String)recordSet.get("old_amend_frequency_val"+j)),new_amend_frequency_value);
		if(checkForNull((String)recordSet.get("amend_start_date_time"+j),"^^").equals(checkForNull((String)recordSet.get("old_amend_start_date_time"+j),"^^")) && checkForNull(new_amend_frequency_value,"^^").equals(checkForNull((String)recordSet.get("old_amend_frequency_val"+j),"^^")) && checkForNull((String)recordSet.get("amend_duration"+j),"^^").equals(checkForNull((String)recordSet.get("amend_duration_code"+j),"^^")) && checkForNull((String)recordSet.get("amend_performing_dept_loc_code"+j),"^^").equals(checkForNull((String)recordSet.get("amend_perform_loc_code"+j),"^^")) &&!diff)
		{

			amend_start_date_time=checkForNull((String)recordSet.get("amend_start_date_time"+j),"");
			/*thai date change*/
			 if (!language_id.equals("en"))
			{
				amendstartdatetime = DateUtils.convertDate(amend_start_date_time,"DMYHM",language_id,"en");
				recordSet.put("amend_start_date_time"+j,amendstartdatetime);
			}
			Ccurrent=DateUtils.getCurrentDate("DMYHM",language_id);
			if(amend_start_date_time.equals(Ccurrent) || !DateUtils.isAfterNow (amend_start_date_time,"DMYHM",language_id))
			{
				hashValues.put("Ccurrent"+count_chk_records,"N");
			}
			else
			{
				hashValues.put("Ccurrent"+count_chk_records,"Y");
			}

			  hashValues.put("amend_catalog_code"+j, amend_catalog_code); // ck+<amend_catalog_code_value>
			  hashValues.put("amend_order_type"+j,checkForNull((String)recordSet.get("amend_order_type"+j),""));
			  hashValues.put("amend_cat_desc"+j,checkForNull((String)recordSet.get("amend_cat_desc"+j),""));
			  hashValues.put("amend_priority"+j,checkForNull((String)recordSet.get("amend_priority"+j),""));
			  hashValues.put("amend_splty_code"+j,checkForNull((String)recordSet.get("amend_splty_code"+j),""));
			  hashValues.put("amend_quantity"+j,checkForNull((String)recordSet.get("amend_quantity"+j),""));
			  hashValues.put("amend_frequency_val"+j,checkForNull((String)recordSet.get("amend_frequency_val"+j),""));
			  hashValues.put("amend_duration_value"+j,checkForNull((String)recordSet.get("amend_duration_value"+j),""));

			 /* Added by Uma on 8/28/2009 for PMG20089 - CRF 640*/
			 if((((checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&((((checkForNull((String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("R")))||((((checkForNull((String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("S")))||((((checkForNull((String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("U")))))
			{
				hashValues.put("amend_future_order_YN"+j,"N");
			}
			else
			 {
			  /* Added by Kishore Kumar N, on 06-Aug-09, For CRF 640-OR */
			   if(amend_start_date_time.equals(Ccurrent) || !DateUtils.isAfterNow (amend_start_date_time,"DMYHM",language_id))
				{
				   hashValues.put("amend_future_order_YN"+j,"N");
				}
				else
				{
					hashValues.put("amend_future_order_YN"+j,checkForNull((String)recordSet.get("amend_future_order_YN"+j),""));
				}
			  /* ends here.  */
			 }
			 /* End Here*/
			  hashValues.put("amend_start_date_time"+j,checkForNull((String)recordSet.get("amend_start_date_time"+j),""));
			  hashValues.put("amend_end_date_time"+j,checkForNull((String)recordSet.get("amend_end_date_time"+j),""));
			  hashValues.put("amend_duration_code"+j,checkForNull((String)recordSet.get("amend_duration_code"+j),""));
			  hashValues.put("amend_performing_facility_id"+j,checkForNull((String)recordSet.get("amend_performing_facility_id"+j),""));
			  hashValues.put("amend_rep_group_ref"+j,checkForNull((String)recordSet.get("amend_rep_group_ref"+j),""));
			  hashValues.put("amend_trn_group_ref"+j,checkForNull((String)recordSet.get("amend_trn_group_ref"+j),""));
			  hashValues.put("ord_appr_reqd_yn"+j,checkForNull((String)recordSet.get("ord_appr_reqd_yn"+j),""));
			  hashValues.put("amend_specimen_type"+j,checkForNull((String)recordSet.get("amend_specimen_type"+j),""));
			  hashValues.put("amend_nurse_collect"+j,checkForNull((String)recordSet.get("amend_nurse_collect"+j),"N"));
			  hashValues.put("amend_order_line_num"+j,checkForNull((String)recordSet.get("amend_order_line_num"+j),""));
			  hashValues.put("amend_performing_dept_loc_code"+j,checkForNull((String)recordSet.get("amend_performing_dept_loc_code"+j),""));
			  hashValues.put("amend_order_category"+j,checkForNull((String)recordSet.get("amend_order_category"+j),""));
			  hashValues.put("amend_order_catalog_nature"+j,checkForNull((String)recordSet.get("amend_order_catalog_nature"+j),""));
			  hashValues.put("amend_billing_call_yn"+j,checkForNull((String)recordSet.get("amend_billing_call_yn"+j),""));
			  hashValues.put("amend_actual_value"+j,checkForNull((String)recordSet.get("amend_actual_value"+j),""));
			  hashValues.put("amend_actual_old_value"+j,checkForNull((String)recordSet.get("amend_actual_old_value"+j),""));
			  hashValues.put("amend_billing_revise_dtls"+j,orderEntryBillBean.getOrderBillDtls(getOrderId()+checkForNull((String)recordSet.get("amend_order_line_num"+j),"")));
			  //hashValues.put("amend_order_status_code"+j,(getOrderStatus(checkForNull((String)recordSet.get("amend_ord_auth_reqd_yn"+j),"N"),checkForNull(((String)recordSet.get("amend_ord_consent_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("amend_complete_on_order_yn"+j)),"N"),checkForNull(reg_reqd_yn,"N"),checkForNull(((String)recordSet.get("amend_ord_spl_appr_reqd_yn"+j)),"N"),((String)hashValues.get("authorized")),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")), checkForNull((String)hashValues.get("consent_stage"+j),""), checkForNull((String)hashValues.get("auto_report_yn"+j),"N"), checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N"), checkForNull(((String)hashValues.get("xh_install_yn")),"N")  )));
			 hashValues.put("amend_order_status_code"+j,(getOrderStatus(checkForNull((String)recordSet.get("amend_ord_auth_reqd_yn"+j),"N"),checkForNull(((String)recordSet.get("amend_ord_consent_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("amend_complete_on_order_yn"+j)),"N"),checkForNull(reg_reqd_yn,"N"),checkForNull(((String)recordSet.get("amend_ord_spl_appr_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("amend_authorised_yn"+j)),"N"),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")), checkForNull((String)hashValues.get("consent_stage"+j),""), checkForNull((String)hashValues.get("auto_report_yn"+j),"N"), checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N"), checkForNull(((String)hashValues.get("xh_install_yn")),"N")  )));
			 hashValues.put("amend_instrn_content_type"+j,checkForNull((String)recordSet.get("amend_instrn_content_type"+j),"T"));//IN64543
			 hashValues.put("fpp_yn"+j,checkForNull((String)recordSet.get("fpp_yn"+j),""));//IN068314
			 hashValues.put("fpp_category"+j,checkForNull((String)recordSet.get("fpp_category"+j),""));//IN068314
			/*Added by Uma on 8/28/2009 for PMG20089 -CRF 640*/
			if((((checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&((((checkForNull((String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("R")))||((((checkForNull((String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("S")))||((((checkForNull((String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("U")))))
		   {
				hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("amend_bill_now"+j),"N"));
				
		   }
		   else
		  {
			 if(amend_start_date_time.equals(Ccurrent) || !DateUtils.isAfterNow (amend_start_date_time,"DMYHM",language_id))
			{
				hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
			}
			else
		   {
				String future_flag="";
				if(amend_start_date_time.length()>0&&checkForNull((String)recordSet.get("amend_future_date"+j),"").length()>0&&!amend_start_date_time.equals("")&&!checkForNull((String)recordSet.get("amend_future_date"+j),"").equals(""))
				{
					future_flag=getFutureChkYN(amend_start_date_time,checkForNull((String)recordSet.get("amend_future_date"+j),""));
					if(future_flag.equalsIgnoreCase("Y"))
					{
						//hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("bill_now"+j),"N"));
						hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("amend_bill_now"+j),"N"));
					}
					else
					{
						hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
					}	//hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("bill_now"+j),"N"));
				}
				 else
				{
					hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
				}
			}
		  }
		  /*End Here*/
		  hashValues.put("amend_old_quantity"+j,checkForNull((String)recordSet.get("amend_old_quantity"+j),""));
		  hashValues.put("amend_routine_appt_reqd_yn"+j,checkForNull((String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N"));
		  hashValues.put("amend_stat_appt_reqd_yn"+j,checkForNull((String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N"));
		  hashValues.put("amend_urgent_appt_reqd_yn"+j,checkForNull((String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N"));
		  hashValues.put("amend_appt_reqd_yn"+j,checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N"));
		  hashValues.put("amend_routine_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_routine_chk_for_dupl_yn"+j),"N"));
		  hashValues.put("amend_urgent_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_urgent_chk_for_dupl_yn"+j),"N"));
		  hashValues.put("amend_stat_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_stat_chk_for_dupl_yn"+j),"N"));
		  hashValues.put("amend_consent_stage"+count_chk_records,checkForNull((String)recordSet.get("amend_consent_stage"+j),"N"));
		  //added on 08/05/07
		  hashValues.put("amend_num_of_consent_req_bo"+count_chk_records,checkForNull((String)recordSet.get("amend_num_of_consent_req_bo"+j),"0"));
		  hashValues.put("amend_num_of_consent_req_br"+count_chk_records,checkForNull((String)recordSet.get("amend_num_of_consent_req_br"+j),"0"));
		  hashValues.put("amend_order_set_id",checkForNull((String)recordSet.get("amend_order_set_id"+j),""));
		  if(checkForNull((String)recordSet.get("amend_order_set_bill_yn"),"N").equals("Y"))
		  {
				String amend_order_set_line_no="1";
				hashValues.put("billing_revise_order_set_dtls",orderEntryBillBean.getOrderBillDtls(checkForNull((String)recordSet.get("amend_order_set_id"+j),"")+amend_order_set_line_no));
				hashValues.put("bill_dateString",checkForNull((String)recordSet.get("bill_dateString"),""));
		  }
		  hashValues.put("amend_order_set_line_num"+count_chk_records,checkForNull((String)recordSet.get("amend_order_set_line_num"+j),""));

		  if(checkForNull((String)recordSet.get("amend_ord_consent_reqd_yn"+j),"N").equals("Y"))
		 {
					//hashValues.put("multi_consent_dtl"+count_chk_records,(HashMap)getConsentFormDtl(j+amend_catalog_code+checkForNull((String)recordSet.get("amend_order_category"+j),"")));
					if(getConsentFormDtl(j+amend_catalog_code+(String)recordSet.get("amend_order_category"+j)) != null)
					{
						hashValues.put("amend_multi_consent_dtl"+count_chk_records,(HashMap)getConsentFormDtl(j+amend_catalog_code+checkForNull((String)recordSet.get("amend_order_category"+j),"")));
					}
				//	else
				//	{
				
				//		//hashValues.put("multi_consent_dtl"+j,(HashMap)getConsent(amend_catalog_code));
				//	}
			}
//			  hashValues.put("RECORDED_YN"+count_chk_records,checkForNull((String)recordSet.get("RECORDED_YN"+j),"0"));
			  hashValues.put("amend_auto_report_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_auto_report_yn"+j),"N"));

			 //REDEFINE THE APPT_REQD_YN BASED UPON THE PRIORITY/STAT/URGENT APPT_REQD_YN
			 if(checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N").equals("Y"))
			{
				 if(checkForNull((String)recordSet.get("amend_priority"+j),"").equals("R"))
					hashValues.put("amend_appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N"));
				 else if(checkForNull((String)recordSet.get("amend_priority"+j),"").equals("S"))
					 hashValues.put("amend_appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N"));
				 else if(checkForNull((String)recordSet.get("amend_priority"+j),"").equals("U"))
					 hashValues.put("amend_appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N"));
			 }
			  comment				= checkForNull((String)recordSet.get("amend_line_comments"+j),"");
			  preps_instrn			= checkForNull((String)recordSet.get("amend_line_preps"+j),"");
			  pat_preps_instrn		= checkForNull((String)recordSet.get("amend_line_pat_instrn"+j),"");
			  preps_dept_instrn		= checkForNull((String)recordSet.get("amend_line_dept_instrn"+j),"");

			  arrSeqNo				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+amend_catalog_code, amend_catalog_code);
			  if(arrSeqNo!=null && arrSeqNo.size()>0)
			  {
				   comment 				=  (String) arrSeqNo.get(0); // comment
				   preps_instrn         =  (String) arrSeqNo.get(1); // preps
				   preps_dept_instrn    =  (String) arrSeqNo.get(2); // Dept
				   pat_preps_instrn     =  (String) arrSeqNo.get(3); // patient Instrn.
			  }
			  hashValues.put("amend_line_comments"+j, checkForNull(comment,""));
			  hashValues.put("amend_line_preps"+j, checkForNull(preps_instrn,""));
			  hashValues.put("amend_line_pat_instrn"+j, checkForNull(pat_preps_instrn,""));
			  hashValues.put("amend_line_dept_instrn"+j, checkForNull(preps_dept_instrn,""));
			  hashValues.put("amend_format_id"+j,checkForNull((String)recordSet.get("amend_format_id"+j),""));//IN066436
			  if((checkForNull((String)recordSet.get("email_yn"),"").equals("Y")))
			{

				if(comment.equals("")&&pat_preps_instrn.equals(""))
				{
				}
				else
				{
					displayDetail.append("<tr><td wrap=\"yes\" width=\"30%\">");
					displayDetail.append(getEmailCatalogDesc(amend_catalog_code));
					displayDetail.append("</td><td wrap=\"yes\" width=\"40%\">");
					displayDetail.append(pat_preps_instrn);
					displayDetail.append("</td><td wrap=\"yes\" width=\"40%\">");
					displayDetail.append(comment);
					displayDetail.append("</td></tr>");
				}
			 }
		   }
		   else if(amend_total_count > 0 )
		   {
			    amend_start_date_time=checkForNull((String)recordSet.get("amend_start_date_time"+j),"");
				/*thai date change*/
				 if (!language_id.equals("en"))
				{
					start_date_time = DateUtils.convertDate(amend_start_date_time,"DMYHM",language_id,"en");
					recordSet.put("start_date_time"+j,start_date_time);
				}
				else
				{
					start_date_time=amend_start_date_time;
					recordSet.put("start_date_time"+j,start_date_time);
				}
				Ccurrent=DateUtils.getCurrentDate("DMYHM",language_id);
				if(amend_start_date_time.equals(Ccurrent) || !DateUtils.isAfterNow (amend_start_date_time,"DMYHM",language_id))
			   {
					hashValues.put("Ccurrent"+count_chk_records,"N");
			   }
				else
			   {
					hashValues.put("Ccurrent"+count_chk_records,"Y");
			   }
				if(amend_total_count==1)
					amend_total_count--; // Subtract the count for the amend_total_count
				else
					hashValues.put("amend_cnt","0");

				hashValues.put("removable_catalog_code"+count_chk_records, checkForNull(amend_catalog_code,"")); // ck+<catalog_code_value>
				hashValues.put("catalog_code"+count_chk_records, checkForNull(amend_catalog_code,"")); // ck+<catalog_code_value>
				hashValues.put("cat_desc"+count_chk_records, checkForNull((String)recordSet.get("amend_cat_desc"+j),""));
				hashValues.put("order_catalog_nature"+count_chk_records,checkForNull((String)recordSet.get("amend_order_catalog_nature"+j),""));
				hashValues.put("order_type"+count_chk_records,checkForNull((String)recordSet.get("amend_order_type"+j),""));
				//hashValues.put("start_date_time"+count_chk_records ,checkForNull((String)recordSet.get("amend_start_date_time"+j),""));

				/* Added By Uma on 8/28/2009, For CRF 640-OR*/
				if((((checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&((((checkForNull((String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("R")))||((((checkForNull((String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("S")))||((((checkForNull((String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("U")))))
				{
					//hashValues.put("future_order_YN"+j,"N");
					hashValues.put("future_order_YN"+count_chk_records,"N"); //IN047469 changed indexing
				}
				else
				{
				 /*
					Added by Kishore Kumar N, on 06-Aug-09, For CRF 640-OR

				*/
					if(amend_start_date_time.equals(Ccurrent) || !DateUtils.isAfterNow (amend_start_date_time,"DMYHM",language_id))
					{	
						hashValues.put("future_order_YN"+count_chk_records,"N");
					}
					else
					{
						//hashValues.put("future_order_YN"+j,checkForNull(getFutureOderYn(amend_catalog_code, getPatientClass(), start_date_time),"N"));//IN047469 changed indexing
						hashValues.put("future_order_YN"+count_chk_records,checkForNull(getFutureOderYn(amend_catalog_code, getPatientClass(), start_date_time),"N"));
					}
				}
				/* End Here*/
				hashValues.put("start_date_time"+count_chk_records ,checkForNull(start_date_time,""));
				hashValues.put("priority"+count_chk_records,checkForNull((String)recordSet.get("amend_priority"+j),""));
				hashValues.put("splty_code"+count_chk_records,checkForNull((String)recordSet.get("amend_splty_code"+j),""));
				hashValues.put("quantity"+count_chk_records,checkForNull((String)recordSet.get("amend_quantity"+j),""));
				hashValues.put("quantity_uom"+count_chk_records,checkForNull((String)recordSet.get("amend_quantity_uom"+j),""));

				String amend_frequency_code=checkForNull((String)recordSet.get("amend_frequency_code"+j),"");
				StringTokenizer ammend=new StringTokenizer(amend_frequency_code,"~~");
				String amend_frequency="";
				while(ammend.hasMoreTokens())
			    {
					 amend_frequency=ammend.nextToken();
					 break;
			    }
				hashValues.put("frequency_val"+count_chk_records,amend_frequency); // frequency_val
                hashValues.put("duration"+count_chk_records,checkForNull((String)recordSet.get("amend_duration"+j),""));
				hashValues.put("duration_value"+count_chk_records,checkForNull((String)recordSet.get("amend_duration_value"+j),""));
				hashValues.put("end_date_time"+count_chk_records,checkForNull((String)recordSet.get("amend_end_date_time"+j),""));
				hashValues.put("chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_yn"+j),""));
				hashValues.put("chk_for_dupl_status"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_status"+j),""));
				hashValues.put("activity_type"+count_chk_records,checkForNull((String)recordSet.get("amend_activity_type"+j),""));
				hashValues.put("check_for_dupl_level"+count_chk_records,checkForNull((String)recordSet.get("amend_check_for_dupl_level"+j),""));
				hashValues.put("chk_for_dupl_ahead_action"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_ahead_action"+j),""));
				hashValues.put("chk_for_dupl_ahead_period"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_ahead_period"+j),""));
				hashValues.put("chk_for_dupl_ahead_unit"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_ahead_unit"+j),""));
				hashValues.put("chk_for_dupl_behind_action"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_behind_action"+j),""));
				hashValues.put("chk_for_dupl_behind_period"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_behind_period"+j),""));
				hashValues.put("chk_for_dupl_behind_unit"+count_chk_records,checkForNull((String)recordSet.get("amend_chk_for_dupl_behind_unit"+j),""));
				hashValues.put("contr_msr_panel_id"+count_chk_records,checkForNull((String)recordSet.get("amend_contr_msr_panel_id"+j),""));
				hashValues.put("ord_auth_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_ord_auth_reqd_yn"+j),"N"));
				
				hashValues.put("authorised_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_authorised_yn"+j),"N"));

				if(checkForNull((String)recordSet.get("cosign_reqd_yn"),"N").equals("Y"))
				{
					cosign_reqd_yn = "Y";
				}
				else
				{
 					cosign_reqd_yn = checkForNull((String)recordSet.get("amend_ord_cosign_reqd_yn"+j),"N");
				}
				hashValues.put("ord_cosign_reqd_yn"+count_chk_records, checkForNull(cosign_reqd_yn,"N"));
				hashValues.put("ord_consent_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_ord_consent_reqd_yn"+j),"N"));
				hashValues.put("complete_on_order_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_complete_on_order_yn"+j),"N"));
				hashValues.put("ord_spl_appr_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_ord_spl_appr_reqd_yn"+j),"N"));
				hashValues.put("result_applicable_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_result_applicable_yn"+j),"N"));
				//hashValues.put("bill_yn"+count_chk_records,checkForNull((String)recordSet.get("bill_yn"+j),"N"));
				hashValues.put("bill_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_bill_yn"+j),"N"));
				hashValues.put("billing_call_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_billing_call_yn"+j),"N"));
				hashValues.put("amend_actual_value"+count_chk_records,checkForNull((String)recordSet.get("amend_actual_value"+j),""));
				hashValues.put("amend_actual_old_value"+count_chk_records,checkForNull((String)recordSet.get("amend_actual_old_value"+j),""));
				hashValues.put("billing_revise_dtls"+count_chk_records,orderEntryBillBean.getOrderBillDtls(getOrderId()+checkForNull((String)recordSet.get("amend_order_line_num"+j),"")));
				/*Added by Uma on 8/28/2009 for PMG20089 -CRF 640*/
				if((((checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&((((checkForNull((String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("R")))||((((checkForNull((String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("S")))||((((checkForNull((String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N")).equalsIgnoreCase("Y"))&&(checkForNull((String)recordSet.get("amend_priority"+j),"")).equalsIgnoreCase("U")))))
			   {
					hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("amend_bill_now"+j),"N"));
					
			   }
			   else
			  {
				if( start_date_time.equals(Ccurrent) || !DateUtils.isAfterNow (start_date_time,"DMYHM",language_id))
			   {
					hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
			   }
				else
			   {
					String future_flag="";
					//if(start_date_time.length()>0&&checkForNull((String)recordSet.get("future_date"+j),"").length()>0&&!start_date_time.equals("")&&!checkForNull((String)recordSet.get("future_date"+j),"").equals(""))
					if(start_date_time.length()>0&&checkForNull((String)recordSet.get("amend_future_date"+j),"").length()>0&&!start_date_time.equals("")&&!checkForNull((String)recordSet.get("amend_future_date"+j),"").equals(""))
					{
						future_flag=getFutureChkYN(start_date_time,checkForNull((String)recordSet.get("amend_future_date"+j),""));
						if(future_flag.equalsIgnoreCase("Y"))
						{
							//hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("bill_now"+j),"N"));
							hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("amend_bill_now"+j),"N"));
						}
						else
						{
							hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
						}
					}
					else
					 {
						hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,"N");
					  }
			//hashValues.put("FUTURE_ORDER_CHARGE_LATER_YN"+count_chk_records,checkForNull((String)recordSet.get("bill_now"+j),"N"));
			   }
			  }
			  /*End Here*/
				comment					= checkForNull((String)recordSet.get("amend_line_comments"+j),"");
				preps_instrn			= checkForNull((String)recordSet.get("amend_line_preps"+j),"");
				pat_preps_instrn		= checkForNull((String)recordSet.get("amend_line_pat_instrn"+j),"");
				preps_dept_instrn		= checkForNull((String)recordSet.get("amend_line_dept_instrn"+j),"");

				arrSeqNo				= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+amend_catalog_code, amend_catalog_code);
				if(arrSeqNo!=null && arrSeqNo.size()>0)
				{
					   comment 				=  (String) arrSeqNo.get(0); // comment
					   preps_instrn         =  (String) arrSeqNo.get(1); // preps
					   preps_dept_instrn    =  (String) arrSeqNo.get(2); // Dept
					   pat_preps_instrn     =  (String) arrSeqNo.get(3); // patient Instrn.
				}
				hashValues.put("line_comments"+count_chk_records,checkForNull(comment,""));
				hashValues.put("line_preps"+count_chk_records,checkForNull(preps_instrn,""));
				hashValues.put("line_pat_instrn"+count_chk_records,checkForNull(pat_preps_instrn,""));
				hashValues.put("line_dept_instrn"+count_chk_records,checkForNull(preps_dept_instrn,""));
				hashValues.put("performing_facility_id"+count_chk_records,checkForNull((String)recordSet.get("amend_performing_facility_id"+j),""));	
				
				hashValues.put("amend_rep_group_ref"+count_chk_records,checkForNull((String)recordSet.get("amend_rep_group_ref"+j),""));
				hashValues.put("amend_trn_group_ref"+count_chk_records,checkForNull((String)recordSet.get("amend_trn_group_ref"+j),""));

				// For Field Mnemonic Fields
				// First time the specimen type,nurse collect(For Lab) and study_loc (For Radiology Dept) is set from the screen, they will be null
				hashValues.put("specimen_type"+count_chk_records,checkForNull((String)recordSet.get("specimen_type"+j),""));
				hashValues.put("specimen_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("specimen_reqd_yn"+j),"N")); // //First time  it will be null, Only in SetOrderformat value will be set to insert into the LB table
				hashValues.put("collection_stage"+count_chk_records,checkForNull((String)recordSet.get("collection_stage"+j),"")); // //First time  it will be null, Only in SetOrderformat value will be set to insert into the LB table
				hashValues.put("dispatch_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("dispatch_reqd_yn"+j),"N")); // //First time  it will be null, Only in SetOrderformat value will be set to insert into the LB table
				hashValues.put("nurse_collect"+count_chk_records,checkForNull((String)recordSet.get("nurse_collect"+j),"N"));
				hashValues.put("study_loc"+count_chk_records,checkForNull((String)recordSet.get("study_loc"+j),"")); //First time  it will be null, Only in SetOrderformat value will be set
				hashValues.put("pregnant_yn"+count_chk_records,checkForNull((String)recordSet.get("pregnant_yn"+j),"")); //First time  it will be null, Only in SetOrderformat value will be set
				hashValues.put("lmp_date"+count_chk_records,checkForNull((String)recordSet.get("lmp_date"+j),"")); //First time  it will be null, Only in SetOrderformat value will be set
				hashValues.put("notify_yn"+count_chk_records,checkForNull((String)recordSet.get("notify_yn"+j),"N")); //First time  it will be null, Only in SetOrderformat value will be set
				hashValues.put("appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N"));
				hashValues.put("routine_appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N"));
				hashValues.put("stat_appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N"));
				hashValues.put("urgent_appt_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N"));
	  			hashValues.put("routine_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_routine_chk_for_dupl_yn"+j),"N"));
			    hashValues.put("urgent_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_urgent_chk_for_dupl_yn"+j),"N"));
			    hashValues.put("stat_chk_for_dupl_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_stat_chk_for_dupl_yn"+j),"N"));
				hashValues.put("consent_stage"+count_chk_records,checkForNull((String)recordSet.get("amend_consent_stage"+j),""));
				hashValues.put("auto_report_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_auto_report_yn"+j),""));
				//added on 08/05/07
				hashValues.put("num_of_consent_req_br"+count_chk_records,checkForNull((String)recordSet.get("amend_num_of_consent_req_br"+j),"0"));
				hashValues.put("num_of_consent_req_bo"+count_chk_records,checkForNull((String)recordSet.get("amend_num_of_consent_req_bo"+j),"0"));
				hashValues.put("order_set_id",checkForNull((String)recordSet.get("amend_order_set_id"+j),""));
				if(checkForNull((String)recordSet.get("amend_order_set_bill_yn"),"N").equals("Y"))
				{
					String amend_order_set_line_no="1";					hashValues.put("billing_revise_order_set_dtls",orderEntryBillBean.getOrderBillDtls(checkForNull((String)recordSet.get("amend_order_set_id"+j),"")+amend_order_set_line_no));
					hashValues.put("bill_dateString",checkForNull((String)recordSet.get("bill_dateString"),""));
				}
				hashValues.put("order_set_line_num"+count_chk_records,checkForNull((String)recordSet.get("amend_order_set_line_num"+j),""));
				if(checkForNull((String)recordSet.get("amend_ord_consent_reqd_yn"+j),"N").equals("Y"))
				{
					 //hashValues.put("multi_consent_dtl"+count_chk_records,(HashMap)getConsentFormDtl(j+amend_catalog_code+checkForNull((String)recordSet.get("amend_order_category"+j),"")));
					if(getConsentFormDtl(j+amend_catalog_code+(String)recordSet.get("amend_order_category"+j)) != null)
					{
						hashValues.put("multi_consent_dtl"+count_chk_records,(HashMap)getConsentFormDtl(j+amend_catalog_code+checkForNull((String)recordSet.get("amend_order_category"+j),"")));
					}
			//		else
			//		{
				//			//hashValues.put("multi_consent_dtl"+count_chk_records,(HashMap)getConsent(amend_catalog_code));
			//		}
				 }
					//ends here
				//REDEFINE THE APPT_REQD_YN BASED UPON THE PRIORITY/STAT/URGENT APPT_REQD_YN
				 if(checkForNull((String)recordSet.get("amend_appt_reqd_yn"+j),"N").equals("Y"))
				{
					if(checkForNull((String)recordSet.get("priority"+j),"").equals("R"))
						hashValues.put("appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("amend_routine_appt_reqd_yn"+j),"N"));
					else if(checkForNull((String)recordSet.get("priority"+j),"").equals("S"))
						 hashValues.put("appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("amend_stat_appt_reqd_yn"+j),"N"));
					else if(checkForNull((String)recordSet.get("priority"+j),"").equals("U"))
						 hashValues.put("appt_reqd_yn"+count_chk_records, checkForNull( (String)recordSet.get("amend_urgent_appt_reqd_yn"+j),"N"));
				}
				//IN31901 Starts
					/*if(Constants.ORDER_CATEGORY.equals((String)recordSet.get("order_category"))){
						if("".equals((String)recordSet.get("amend_perform_loc_code"+j))){
							//hashValues.put("appt_reqd_yn"+count_chk_records,"Y");
							hashValues.put("appt_reqd_yn"+count_chk_records,(String)hashValues.get("appt_reqd_yn"+count_chk_records));//--[IN035349]
						}else{
							hashValues.put("appt_reqd_yn"+count_chk_records,"N");
						}
					}*/
				//IN31901 Ends
				hashValues.put("result_auth_reqd_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_result_auth_reqd_yn"+j),"N"));
				hashValues.put("order_category"+count_chk_records,checkForNull((String)recordSet.get("amend_order_category"+j),"CS"));
				hashValues.put("freq_nature"+count_chk_records,checkForNull((String)recordSet.get("amend_freq_nature"+j),"F"));
				hashValues.put("cont_order_yn"+count_chk_records,checkForNull((String)recordSet.get("amend_cont_order_yn"+j),"N"));
				hashValues.put("end_date_time"+count_chk_records,checkForNull((String)recordSet.get("amend_end_date_time"+j),""));
				hashValues.put("performing_dept_loc_code"+count_chk_records,checkForNull((String)recordSet.get("amend_perform_loc_code"+j),""));
				// Get the Description For the Catalog
				// Call a method getOrderCatalogDesc() to get the value for the CATALOG_SYNONYM_DC,CATALOG_SYNONYM_AD
				catalog_code_desc = checkForNull(getOrderCatalogDesc(amend_catalog_code),"");
				if(!catalog_code_desc.equals(""))
				  St_catalog_desc = new StringTokenizer(catalog_code_desc,"~");
				while(St_catalog_desc.hasMoreTokens())
				{
				  catalog_code_dc     = checkForNull(St_catalog_desc.nextToken(),"");   // Get the Description for catalog_code_dc
				  catalog_code_ad     = checkForNull(St_catalog_desc.nextToken(),"");   // Get the Description for catalog_code_ad
				}
				hashValues.put("catalog_code_dc"+count_chk_records,catalog_code_dc);
				hashValues.put("catalog_code_ad"+count_chk_records,catalog_code_ad);
				//hashValues.put("order_line_seq_num"+count_chk_records,checkForNull((String)recordSet.get("order_line_seq_num"+j),""));
				// Call a method getRegReqdValue() to get the regd. reqdyn
				labchk=getmoduleRL((String)recordSet.get("amend_catalog_code"+j),(String)recordSet.get("amend_order_category"+j),(String)recordSet.get("amend_order_type"+j),login_facility_id);//added on 7/9/2007 for lb_instal_yn by uma
				//if((checkForNull((String)recordSet.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")) && (checkForNull((String)recordSet.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")))  // If Order_category is "LB" and lab is installed then make the reg_reqd_yn as "N":changed on 7/9/2007 for lb_instal_yn by uma
				if((checkForNull((String)recordSet.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB"))&&(checkForNull(labchk,"").equalsIgnoreCase("IBARL")))
					// If Order_category is "LB" and lab is installed then make the reg_reqd_yn as "N"
				  reg_reqd_yn  = "N";
				else
				  reg_reqd_yn = ((String)getRegReqdValue((String)recordSet.get("amend_order_type"+j)));
				hashValues.put("reg_reqd_yn"+count_chk_records, checkForNull(reg_reqd_yn,"N"));
				// Call a method getOrderStatus() to get the order status code
				//hashValues.put("order_status_code"+count_chk_records,(getOrderStatus(checkForNull((String)recordSet.get("amend_ord_auth_reqd_yn"+j),"N"),checkForNull(((String)recordSet.get("amend_ord_consent_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("amend_complete_on_order_yn"+j)),"N"),checkForNull(reg_reqd_yn,"N"),checkForNull(((String)recordSet.get("amend_ord_spl_appr_reqd_yn"+j)),"N"),((String)hashValues.get("authorized")),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")), checkForNull((String)hashValues.get("consent_stage"+j),""), checkForNull((String)hashValues.get("auto_report_yn"+j),"N"), checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N"), checkForNull(((String)hashValues.get("xh_install_yn")),"N")  )));
				hashValues.put("order_status_code"+count_chk_records,(getOrderStatus(checkForNull((String)recordSet.get("amend_ord_auth_reqd_yn"+j),"N"),checkForNull(((String)recordSet.get("amend_ord_consent_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("amend_complete_on_order_yn"+j)),"N"),checkForNull(reg_reqd_yn,"N"),checkForNull(((String)recordSet.get("amend_ord_spl_appr_reqd_yn"+j)),"N"),checkForNull(((String)recordSet.get("amend_authorised_yn"+j)),"N"),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")), checkForNull((String)hashValues.get("consent_stage"+j),""), checkForNull((String)hashValues.get("auto_report_yn"+j),"N"), checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N"), checkForNull(((String)hashValues.get("xh_install_yn")),"N")  )));
				

				// For the Order Format Lines, calling a method setOrderFormat() where it will set the values for each line
				// Pass it "Detail" to set the value for the nurse_collect_yn and specimen_type for Lab and study_loc for Radiology Dept
				//if(care_set_count > 0)  // Only For Care Sets
				//hashValues.put("header_line_values"+count_chk_records,setOrderFormat(checkForNull((String)recordSet.get("catalog_code"+j),""), (checkForNull((String)recordSet.get("catalog_code"+j),"")+"_"+j),"Line_Detail",checkForNull((String)recordSet.get("lb_instal_yn"),"N"),checkForNull((String)recordSet.get("group_order_category"+j),"CS"), i));
				// for both care sets and new orders

				stop_message				= checkOrderFormat(checkForNull((String)recordSet.get("amend_catalog_code"+j),""), (checkForNull((String)recordSet.get("amend_catalog_code"+j),"")+"_0"));  //No catalog description header level
				//hashValues.put("header_line_values"+count_chk_records,setOrderFormat(checkForNull((String)recordSet.get("amend_catalog_code"+j),""), (checkForNull((String)recordSet.get("amend_catalog_code"+j),"")+"_0"),checkForNull((String)recordSet.get("amend_order_type"+j),""),"Line_Detail",checkForNull((String)recordSet.get("lb_instal_yn"),"N"),checkForNull((String)recordSet.get("amend_order_category"+j),"CS"),count_chk_records));changed on 7/9/2007 for lb_instal_yn by uma
				hashValues.put("header_line_values"+count_chk_records,setOrderFormat(checkForNull((String)recordSet.get("amend_catalog_code"+j),""), (checkForNull((String)recordSet.get("amend_catalog_code"+j),"")+"_0"),checkForNull((String)recordSet.get("amend_order_type"+j),""),"Line_Detail",labchk,checkForNull((String)recordSet.get("amend_order_category"+j),"CS"),count_chk_records));
				// For the Schedule Frequency, calling a method setScheduleFormat() where it will set the values for each line
				hashValues.put("schedule_format_line_values"+count_chk_records,setScheduleFormat(checkForNull("Schedule"+(String)recordSet.get("amend_catalog_code"+j),""), ("Schedule"+checkForNull((String)recordSet.get("amend_catalog_code"+j),"")+"_"+j)));
				// For Deletion in the Amend Order.(cos, the order_id has changed and old one to be deleted)
				hashValues.put("amend_delete_line_num"+count_chk_records,  checkForNull((String)recordSet.get("amend_order_line_num"+j),""));
				hashValues.put("barcode_reqd_yn"+count_chk_records,  checkForNull((String)recordSet.get("amend_barcode_reqd_yn"+j),""));//IN063816
				hashValues.put("amend_format_id"+count_chk_records,checkForNull((String)recordSet.get("amend_format_id"+j),""));//IN066436
				hashValues.put("instrn_content_type"+count_chk_records,checkForNull((String)recordSet.get("amend_instrn_content_type"+j),"T"));//IN64543
				hashValues.put("fpp_yn"+count_chk_records,checkForNull((String)recordSet.get("fpp_yn"+j),""));//IN073051
				hashValues.put("fpp_category"+count_chk_records,checkForNull((String)recordSet.get("fpp_category"+j),""));//IN073051
				count_chk_records++;	//i++;
			} // End of Else
		 } // End of stop_message.equals("")
	} // End of for
	 hashValues.put("amend_order_id",getOrderId());

  }
  catch(Exception e)
  {
	e.printStackTrace();
  }
  return stop_message;
}

// Method to set the order_formats on click of the apply
//private HashMap setOrderFormat(String catalog_code,String row_value, String order_type_code, String called_from,String lb_instal_yn, String order_category, int row) throws Exception {changed on 7/9/2007 for lb_instal_yn by uma
private HashMap setOrderFormat(String catalog_code,String row_value, String order_type_code, String called_from,String labchk, String order_category, int row) throws Exception 
{
	/* For the Header the order_category will be passed as the catalog_code and the row_value will be 0
	* For the Line the catalog_code will be same but the row_value will be the row
	* For the called_from the value may be "Header" or "Line_Detail", "Header" will come when no need to set the specimen_type and nurse_collect_yn,
	* But the "Line_detail" will come for the line level to set the nurse_collect_yn and specimen_type which will be used for Laboratory orders..
	* and study_loc for Radiology Dept Orders
	* and LMP_DATE and PREGNANT_YN will be used for Radialogy Orders
	*/
	HashMap orderFormatHash  	= new HashMap(); // To Store it in the HashMap
	ArrayList arrSeq_num  	= new java.util.ArrayList(); // get the Seq in ArrayList
	Hashtable template    	= new java.util.Hashtable(); // get the Template values in the HashTable
	int new_seq_num     	  	= 0;
	StringBuffer order_format_values = new StringBuffer();
	String specimen_reqd_yn	= "N";
	String  Order_Frt_Values="";
	String  l_field_type ="";
	String ord_field_value="";
	String ord_field_values_oth_desc="";
	String ord_field_mnemonic="";
	String ord_field_type="";
	String mother_patient_id  = "", mother_patient_name = ""; // String pref_surg_date		= "";
	
	if(order_category.equalsIgnoreCase("LB"))
	{
		labchk=getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id);
	}
	else
	{
		labchk="";
	}
	try
	{
		arrSeq_num        		= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
		if(arrSeq_num!= null && arrSeq_num.size() >0)
		{
			int i = 0;
			for(i=0;i<arrSeq_num.size();i++)
			{
				new_seq_num    = Integer.parseInt((String)arrSeq_num.get(i)); //((Integer)arrSeq_num.get(i)).intValue(); // get the seq_num
				template  = (java.util.Hashtable)  orderEntryRecordBean.getOrderFormats ( catalog_code, (catalog_code+new_seq_num) );
				orderFormatHash.put("new_seq_num"+i,String.valueOf(new_seq_num));
				ord_field_mnemonic=checkForNull((String)template.get("field_mnemonic"));

				if(ord_field_mnemonic.equals("null")||ord_field_mnemonic.equals(" "))
				ord_field_mnemonic="";
				ord_field_type=checkForNull((String)template.get("field_type"));
				if(ord_field_type.equals("null")||ord_field_type.equals(" "))
				ord_field_type="";
				ord_field_values_oth_desc=checkForNull((String)template.get("field_values_oth_desc"));
				if(ord_field_values_oth_desc.equals("null")||ord_field_values_oth_desc.equals(" "))
				ord_field_values_oth_desc="";
				labchk = checkForNull(labchk);
				if(labchk.equals("null")||labchk.equals(" ")||labchk==null)
				labchk="";
				if(order_category.equals("null")||order_category.equals(" "))
				order_category="";
				if((ord_field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT")||ord_field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT_DESC"))&&order_category.equalsIgnoreCase("LB")&&labchk.equalsIgnoreCase("IBARL")&&ord_field_type.equalsIgnoreCase("L"))
				{
					ord_field_value=checkForNull((String)template.get("field_values"),"");
					if(ord_field_value.equals("null")||ord_field_value.equals(" "))
					ord_field_value="";
					if(!ord_field_values_oth_desc.equals(""))
					{
						orderFormatHash.put("field_mnemonic"+i,"REQUEST_COMMENT_DESC");
					}
					else
					{
						orderFormatHash.put("field_mnemonic"+i,"REQUEST_COMMENT");
					}
				}
				else
				{
					orderFormatHash.put("field_mnemonic"+i,(String) template.get("field_mnemonic"));
				}
				orderFormatHash.put("seq_num"+i,(String) template.get("seq_num"));
				orderFormatHash.put("label_text"+i,(String) template.get("label_text"));
				orderFormatHash.put("accept_option"+i,(String) template.get("accept_option"));
				orderFormatHash.put("field_type"+i,(String) template.get("field_type"));
				orderFormatHash.put("discr_msr_uom"+i,(String) template.get("discr_msr_uom"));
				l_field_type =(String) template.get("field_type");
				Order_Frt_Values=(String)template.get("field_values");

				// if(Order_Frt_Values.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
				//This Regular Expression to check the date format
				if((ord_field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT")||(ord_field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT_DESC")))&&order_category.equalsIgnoreCase("LB")&&labchk.equalsIgnoreCase("IBARL")&&ord_field_type.equalsIgnoreCase("L"))
				{
					if(!ord_field_values_oth_desc.equals(""))
					{
						orderFormatHash.put("field_values"+i,(String)template.get("field_values_oth_desc"));
					}
					else
					{
						orderFormatHash.put("field_values"+i,(String)template.get("field_values"));
					}
				}
				else
				{
					if ((l_field_type.equals("D") || l_field_type.equals("E")) && !Order_Frt_Values.equals(""))
					{
						int temp=Order_Frt_Values.indexOf("/");
						//String	date1=""; //Check Style Unused local variable
						String	date="";
						if(temp!=-1)
						{
							date=Order_Frt_Values.substring(temp-2,temp+8);
							//IN035189,starts
							/*if ( !language_id.equals("en") )
							{
								date1 =DateUtils.convertDate(date,"DMY",language_id,"en");
							}
							else
								date1 =date;*/
							//IN035189, ends
						}
						//Order_Frt_Values=Order_Frt_Values.replace(date,date);//IN035189
						//orderFormatHash.put("order_format_values",Order_Frt_Values);
						orderFormatHash.put("field_values"+i,Order_Frt_Values);
					}
					else
					{
						orderFormatHash.put("field_values"+i,(String)template.get("field_values"));
					}
				}
				//IN050610 - Start to handle the message of other dependency comp in Amend
				if("Y".equals((String) template.get("oth_dependency_yn")))
				{
					orderFormatHash.put("dependency_yn"+i,(String) template.get("oth_dependency_yn"));
				}
				else
				{
					orderFormatHash.put("dependency_yn"+i,(String) template.get("dependency_yn"));
				}
				//IN050610 - End
				orderFormatHash.put("single_or_multi"+i,(String) template.get("single_or_multi"));
				if(((String) template.get("field_mnemonic")).equalsIgnoreCase("COLLECTION_STAGE")) 
				{ // System Defined cannot be changed
					hashValues.put("collection_stage"+row,checkForNull((String) template.get("field_values"),""));
				}
				//Only for Laboratory Orders, the specimen type and nurse_collect_yn will be set, for others it will go as null which will be sent from the jsp.
				if(called_from.equalsIgnoreCase("Line_Detail"))
				{   // Only for Laboratory the SPECIMEN_TYPE & NURSE_COLLECT_YN will come, for others it won't come and for few other field mnemonmics it will come
					if(((String) template.get("field_mnemonic")).equalsIgnoreCase("SPECIMEN_TYPE")) // System Defined cannot be changed
					{
						// Logic to insert the column SPECIMEN_REQD_YN in or_order_line_lb table.
						//if(lb_instal_yn.equals("Y") && order_category.equals("LB"))changed on 7/9/2007 for lb_instal_yn by uma

						/*if((checkForNull(labchk,"").equalsIgnoreCase("IBARL")) &&order_category.equals("LB"))
						{
						specimen_reqd_yn	 = getSpecimenMandYn(catalog_code) ; //Call this method, passing the catalog code to get the  Y or N
						if(checkForNull(specimen_reqd_yn,"N").equals("R")) // Because in the query for that coluumn, for Y it is decoded as R, and for N it is decoded as O
						specimen_reqd_yn  = "Y";
						else
						specimen_reqd_yn  = "N";
						}
						else
						{*/
						if(checkForNull((String)template.get("accept_option"),"N").equals("R")) // If it is required
							specimen_reqd_yn = "Y";
						else
							specimen_reqd_yn = "N";
						//}

						// till here
						hashValues.put("specimen_reqd_yn"+row, specimen_reqd_yn);
						hashValues.put("specimen_type"+row,checkForNull((String) template.get("field_values"),""));
					}
					else if(((String) template.get("field_mnemonic")).equalsIgnoreCase("COLLECTION_STAGE")) 
					{ // System Defined cannot be changed
						hashValues.put("collection_stage"+row,checkForNull((String) template.get("field_values"),""));
					}
					else if(((String) template.get("field_mnemonic")).equalsIgnoreCase("DISPATCH_REQD_YN")) 
					{// System Defined cannot be changed
						//hashValues.put("collection_stage"+row,checkForNull((String) template.get("field_values"),""));
						hashValues.put("dispatch_reqd_yn"+row,checkForNull((String) template.get("field_values"),"N"));
					} 
					else if(((String) template.get("field_mnemonic")).equalsIgnoreCase("NURSE_COLLECT_YN")) // System Defined cannot be changed
					hashValues.put("nurse_collect"+row,checkForNull((String) template.get("field_values"),"N"));
					else if(((String) template.get("field_mnemonic")).equalsIgnoreCase("STUDY_LOC")) // It will come for STUDY_LOC (For Radiology Dept )system defined value cannot be changed
					hashValues.put("study_loc"+row,checkForNull((String) template.get("field_values"),""));
					else if(((String) template.get("field_mnemonic")).equalsIgnoreCase("PREGNANT_YN")) // It will come for PREGNANT_YN (For Radialogy)system defined value cannot be changed
					hashValues.put("pregnant_yn"+row,checkForNull((String) template.get("field_values"),"N"));
					else if(((String) template.get("field_mnemonic")).equalsIgnoreCase("LMP_DATE")) // It will come for LMP_DATE (For Radiology )system defined value cannot be changed
					hashValues.put("lmp_date"+row,checkForNull((String) template.get("field_values"),""));

					// Set the Notify Yn depending upon the dependency (From the screen population)
					if(checkForNull((String)template.get("notify_yn"),"N").equals("Y")) 
					{ // If atleast one notify_yn = 'Y', then value will go as 'Y'
						hashValues.put("notify_yn"+row, checkForNull((String)template.get("notify_yn"),"N")); //Notify_yn
					} // else it will have the value as N only.
				} // End of if called_from LINE_DETAIL

				/*   if(((String) template.get("field_mnemonic")).equalsIgnoreCase("PREF_SURG_DATE")) // It will come for PREF_SURG_DATE, OT Installed
				{   // If order_category="OT" & field_mnemonic is PREF_SURG_DATE != start_date_time(line_level -->screen) & patient_class as "DC" or "OP", change the patient_class and set the episode_id and encounter_id as null
				pref_surg_date = checkForNull((String) template.get("field_values"),"");
				hashValues.put("pref_surg_date"+order_type_code, pref_surg_date);
				} // End of PREF_SURG_DATE
				*/
				// Mother Patient_id
				if(((String)  template.get("field_mnemonic")).equalsIgnoreCase("NN_MOTHER_PAT_ID")) // It will come for NN_MOTHER_PAT_ID, LB (RL installed), for mother patient_id
				{
					mother_patient_id = checkForNull((String) template.get("field_values"),"");
					hashValues.put("mother_patient_id"+order_type_code, mother_patient_id);
				} // End of NN_MOTHER_PAT_ID

				// Mother Patient Name
				if(((String)  template.get("field_mnemonic")).equalsIgnoreCase("NN_MOTHER_PAT_NAME")) // It will come for NN_MOTHER_PAT_ID, LB (RL installed), for mother patient_id
				{
					mother_patient_name = checkForNull((String) template.get("field_values"),"");
					hashValues.put("mother_patient_name"+order_type_code, mother_patient_name);
				} // End of NN_MOTHER_PAT_ID
				//Used for concatenation and to insert into the order_line_text in the hdr and detail
				if(!((String) template.get("field_mnemonic")).equalsIgnoreCase(""))
				{
					Order_Frt_Values=(String)template.get("field_values");

					if ((l_field_type.equals("D") || l_field_type.equals("E")) && !Order_Frt_Values.equals(""))
					{
						int temp=Order_Frt_Values.indexOf("/");
						String	date1="";
						String	date="";
						if(temp!=-1)
						{
							date=Order_Frt_Values.substring(temp-2,temp+8);
							if ( !language_id.equals("en") )
							{
								date1 =DateUtils.convertDate(date,"DMY",language_id,"en");
							}
							else
							date1 =date;
						}
						Order_Frt_Values=Order_Frt_Values.replace(date,date1);
						order_format_values.append ((String) template.get("label_text")+" : "+Order_Frt_Values+", ");
					}
					else
					{
						order_format_values.append ((String) template.get("label_text")+" : "+(String)template.get("field_values")+" "+(String)template.get("discr_msr_uom")+" "+(String)template.get("field_values_oth_desc")+", ");
					}
				}
			}
			orderFormatHash.put("order_format_count",(String.valueOf(i)));
			orderFormatHash.put("order_format_values",(String)order_format_values.toString());
		}
		else
			orderFormatHash.put("dummy","");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	order_format_values.setLength(0);
	return orderFormatHash;
}

// Method to Check whether the order can be processed or not, if the order formats are there
// If it has to be stopped, the filed_mnemonic_action will be 'N' and the order will be stopped
// from proceeding further (i.e u cannot place an order) and also the message should be displayed

// Before generating an order, check if any field_mnemonic is attached, which has the
// field_mnemonic_action as "N" and a message attached to it, if it is there,cannot place an order
// Throw the message and return
private String checkOrderFormat(String catalog_code, String row_value) throws Exception {
  /** For the Header the order_category will be passed as the catalog_code and the row_value will be 0
   ** For the Line the catalog_code will be same but the row_value will be the row
   **/
   ArrayList arrSeq_num  	= new java.util.ArrayList(); // get the Seq in ArrayList
   Hashtable template    	= new java.util.Hashtable(); // get the Template values in the HashTable
   int new_seq_num     	  	= 0;
   String stop_message		= "";
   try{
		  arrSeq_num        		= (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
 		  if(arrSeq_num!= null && arrSeq_num.size() >0)
		  {
				for(int i=0;i<arrSeq_num.size();i++)
				{
			       new_seq_num    = Integer.parseInt((String)arrSeq_num.get(i)); //((Integer)arrSeq_num.get(i)).intValue(); // get the seq_num
 			       template  = (java.util.Hashtable)  orderEntryRecordBean.getOrderFormats ( catalog_code, (catalog_code+new_seq_num) );
				   if(checkForNull((String) template.get("field_mnemonic_action"),"").equals("S") && !(checkForNull((String) template.get("field_values"),"").equals("")) )
					{
					   if(checkForNull((String) template.get("field_type"),"").equals("D") || checkForNull((String) template.get("field_type"),"").equals("E") ){
						   java.text.SimpleDateFormat dateFormat = null;
						   //String defaultDate = "";
						   if(checkForNull((String) template.get("field_type"),"").equals("D")){
							   dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
							  // defaultDate = getSysDate();
							  // defaultDate = defaultDate.substring(0,10);// to take only the server date
						   }else{
							   dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy kk:mm" ) ;
							  // defaultDate = getSysDate();
						   }

						  //  java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy kk:mm" ) ;

							String	currentdate			=  dateFormat.format(new java.util.Date()) ;
							String	to_date			=  checkForNull((String) template.get("field_values"),"");



							java.text.ParsePosition pos = new java.text.ParsePosition(0);
							java.text.ParsePosition pos1 = new java.text.ParsePosition(0);

							java.util.Date from = dateFormat.parse(currentdate, pos);
							java.util.Date to = dateFormat.parse(to_date, pos1);

							int result = from.compareTo(to);


							if(checkForNull((String) template.get("field_value_type"),"").equals("E") && result == 0){
								stop_message = checkForNull((String) template.get("field_action_msg"),"")+"  because of Field Mnemonic "+ checkForNull((String) template.get("field_mnemonic"),"");
							}else if(checkForNull((String) template.get("field_value_type"),"").equals("G") && result < 0){
								stop_message = checkForNull((String) template.get("field_action_msg"),"")+"  because of Field Mnemonic "+ checkForNull((String) template.get("field_mnemonic"),"");
							}else if(checkForNull((String) template.get("field_value_type"),"").equals("L") && result > 0){
								stop_message = checkForNull((String) template.get("field_action_msg"),"")+"  because of Field Mnemonic "+ checkForNull((String) template.get("field_mnemonic"),"");
							}else{
								stop_message = "";

							}

					   }else{
							stop_message = checkForNull((String) template.get("field_action_msg"),"")+"  because of Field Mnemonic "+ checkForNull((String) template.get("field_mnemonic"),"");
					   }
				   }

 				}
		  } // End of for arrSeqNum.size()

	}
	catch(Exception e){
	
		e.printStackTrace();
	}
	return stop_message;
 } //End of checkOrderFormat

// Modified By Sridhar Reddy V on 050909 SRR20056-CRF-0274
// Schedule Frequency set for the line Level....(Apply)
private ArrayList setScheduleFormat(String catalog_code,String row_value) throws Exception {
  ArrayList arr_val  = new ArrayList();
  HashMap hash_map  = new HashMap();
  //int repeat      = 0;
  arr_val      = (java.util.ArrayList) orderEntryRecordBean.getOrderFormats(catalog_code, row_value);
  if(arr_val == null)
  {
	  arr_val = new ArrayList();
	  hash_map.put("dummy_val","");
	  arr_val.add(hash_map);
	  //hash_map.put(row_value,arr_val);
    /*  hash_map.put("duration_type",(String) hash_val.get("duration_type"));
      hash_map.put("start_time_assign",(String) hash_val.get("start_time_assign"));
      hash_map.put("start_day_assign",(String) hash_val.get("start_day_assign"));
      hash_map.put("repeat",(String) hash_val.get("repeat"));
      repeat = Integer.parseInt(checkForNull((String) hash_val.get("repeat"),"0"));
        if(((String) hash_val.get("duration_type")).equals("W"))
        {
           // For Days to be taken
			for(int i=1 ; i <= 7 ; i++){
		        hash_map.put("daySM"+i,checkForNull((String)hash_val.get("daySM"+i),""));
				hash_map.put("dayDisplay"+i,checkForNull((String)hash_val.get("dayDisplay"+i),""));
        }
      }
       // For Hours to be taken
       for(int j=1 ; j <= repeat ; j++){
         hash_map.put("time"+j,checkForNull((String)hash_val.get("time"+j),""));
         hash_map.put("displayHrs"+j,checkForNull((String)hash_val.get("displayHrs"+j),""));
      }*/
  }

  return arr_val;
}  // End of setScheduleFormat
/*********************METHOD TO Insert*************************/
public HashMap insert()
{
  boolean result            = false;
  StringBuffer tmpBuff      = new StringBuffer();
  HashMap map			    = new HashMap() ;

  java.util.Properties  properties   = getProperties();
  String user_id			= properties.getProperty( "ecis_jdbc_user" ) ;
  String user_password      = properties.getProperty( "ecis_jdbc_password" ) ;
  String jdbc_dns			= properties.getProperty( "ecis_jdbc_dns" );
  String database_name      = "";
  if(jdbc_dns!=null)
		database_name       = jdbc_dns.substring(jdbc_dns.lastIndexOf(":")+1,jdbc_dns.length());
  map.put( "result", new Boolean( false ) ) ;
  HashMap tabdata           = new HashMap() ;
   // if stop message is there then cannot proceed with the order
  String bill_message="";
  //IN050607 Starts
  String ord_cat = getOrderCategoryValue();
  String ordering_rule_yn = "Y";//IN051367
  String discharge_date_time =  "";
  try {
	 discharge_date_time = getDischargeDateTime(getPatientId(),getEncounterId() );
	 if(!"".equals(discharge_date_time))//IN051367
	 {
	 setDischargeDate(discharge_date_time);
	 ordering_rule_yn = getOrderingRuleYn(ord_cat);
	 }	//IN051367
  } catch (Exception e1) {
	e1.printStackTrace();
  }
 
  if("Y".equals(ordering_rule_yn))
  {//IN050607 Ends
  if(hashValues!=null && (checkForNull((String)hashValues.get("stop_message"),"").equals("")) ) 
  {
	  try
	  {	  	
			int categorySize = 0;
			if(hashValues.get("called_from").equals("PREVIEW"))
			{
				categorySize = 1;				
			}
			else
			{
				//This is called before Order Insertion or Updation of orders
				HashMap OrderCategories =  new HashMap();
				String key			= (getPatientId()+getEncounterId());  // Unique key to keep the Value in the Bean
				// Call the below method from the bean to check if any previous values are there in the bean
				// If any records are there, then fetch them and put it in the hashmap,
				// so that u can checked the existing entries (already)
				java.util.HashMap previousValues = (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
				OrderCategories = (HashMap)getOrderCategories(previousValues);
				categorySize = OrderCategories.size();
			}

			HashMap generate_hash = (HashMap)generateUniqueIds(); // Put it in the global HashMap
			
			// (HashMap)generateUniqueIds(hashValues);
			// Get the unique id (Combination)
			if(generate_hash!=null)
			{
				result = ((Boolean) generate_hash.get( "result" )).booleanValue();
				tabdata.put( "mapUniqueId" , (HashMap)generate_hash.get("mapUniqueId") ) ;
				tabdata.put( "mapOrderId" , (HashMap)generate_hash.get("mapOrderId") ) ;
				tabdata.put( "mapOrderStatus" , (HashMap)generate_hash.get("mapOrderStatus")) ;
				tabdata.put( "properties" , getProperties() ) ;
				tabdata.put( "login_by_id" , login_by_id ) ;
				tabdata.put( "login_at_ws_no" , login_at_ws_no ) ;
				tabdata.put( "login_facility_id" , login_facility_id ) ;
				tabdata.put( "user_id" , user_id ) ;
				tabdata.put( "user_password" , user_password ) ;
				tabdata.put( "database_name" , database_name ) ;
				tabdata.put( "hashValues" , hashValues);
				tabdata.put( "categorySize" , categorySize);
				tabdata.put( "invokeFunction" , getInvokeFunction());

				tabdata.put( "p_called_from_ca" , getCalledFromCA());//IN071315
				if((getPatientClass().equalsIgnoreCase("XT")) || (getPatientClass().equalsIgnoreCase("OP")) || (getPatientClass().equalsIgnoreCase("EM")))
				{
					String ext_bill_interface_yn=checkForNull((String)getBillingInterfaceYn(),"N");

					if(ext_bill_interface_yn.equalsIgnoreCase("Y"))
					{
						tabdata.put( "discount_allow_yn",getDiscountAllowedYN());
						tabdata.put( "bill_interface_yn",ext_bill_interface_yn);
					}
					else
					{
						tabdata.put( "discount_allow_yn","N");
						tabdata.put( "bill_interface_yn","N");
					}
				}
				//IN071260 Starts
					tabdata.put( "drugInterDetailsLB" , druginteractionDtl);
					
				//IN071260 Ends
			 }
			 
		  }
		  catch(Exception e)
	      {
			e.printStackTrace();
		  }
		  if(result)
		  {
			HashMap sqlMap = new HashMap() ;

			try
			{				
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT") );
				sqlMap.put( "SQL_ORDER_ENTRY_ORDER_COMMENT_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ORDER_COMMENT_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_COMMENTS_SEQ_NUM", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_COMMENTS_SEQ_NUM"));
				sqlMap.put( "SQL_ORDER_ENTRY_ORDER_COMMENT_CLOB_SELECT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ORDER_COMMENT_CLOB_SELECT") );
				sqlMap.put( "SQL_ORDER_ENTRY_ORDER_FIELD_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ORDER_FIELD_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ORDER_LINE_FIELD_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_HDR_UPDATE",OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_HDR_UPDATE"));
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_UPDATE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_UPDATE") );
				//sqlMap.put( "SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_UPDATE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_UPDATE") );
				//sqlMap.put( "SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_UPDATE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_UPDATE") );
				sqlMap.put( "SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_DELETE") );
				sqlMap.put( "SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_DELETE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_DELETE") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_LB_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_LB_INSERT") );
				//Ramesh
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_MO_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_MO_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_UPDATE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_RD_UPDATE") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_UPDATE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_RX_UPDATE") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_DELETION", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_DELETION") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_DELETION", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_DELETION") );
				sqlMap.put( "SQL_OR_BL_WITHOUT_ORDER_CATALOG", OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_COUNT_SELECT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_COUNT_SELECT") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_DELETION", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_DELETION") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_DELETION", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_DELETION") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_FIELD_INSERT") );
				sqlMap.put( "SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_INSERT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_OR_ORDER_LINE_FIELD_INSERT") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_FREQ_EXPLOSION", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FREQ_EXPLOSION") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_SPECIMEN_GEN", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_GEN") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_INSERT_SY_REPORT") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO") );
				//[IN041340]sqlMap.put( "SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_NO","CALL ins_gtt_tests_with_no( ? ,? ,?, ? ,? ,?,?)" );//DineshT
				sqlMap.put( "SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SPECIMEN_INSERT_WITHOUT_NO") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_BILLING_LINE_NUM_QUERY", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILLING_LINE_NUM_QUERY") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILLING_LINE_UPDATION") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_ORDER_CATALOG_LINE") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_ORDERABLE_CHECKED") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_PROC_FOR_EXT_SERVICE_REC_FOR_CHRG_STAGE") );
				//sqlMap.put( "SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE_CODE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_BODY_DATA_DETAILS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_BODY_DATA_DETAILS") );

					//String query1=OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");

				    //query1=query1.replaceFirst("?",language_id);

				//sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_MESSAGE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE"));
				bill_message=OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_MESSAGE");
				if(bill_message.indexOf("?")!=-1)
				{
						bill_message   = bill_message.substring(0,bill_message.indexOf("?"))+"'"+language_id+"'"+bill_message.substring(bill_message.indexOf("?")+1)  ;
				}
				sqlMap.put( "SQL_OR_ORDER_ENTRY_BILL_MESSAGE",bill_message);
				sqlMap.put( "SQL_OR_ORDER_ENTRY_PRIOR_ORDERS", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRIOR_ORDERS") );
				sqlMap.put( "SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_UPDATE_CONSULT_MED_ID") );
				sqlMap.put( "SQL_ORDER_ENTRY_OR_INSERT_ORDER_OTH_MODULE", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_INSERT_ORDER_OTH_MODULE") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_PH_EQVL", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PH_EQVL") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_PH_INSERT_DTLS", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PH_INSERT_DTLS") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_CP_UPDATE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CP_UPDATE") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_MO_UPDATE", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MO_UPDATE") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_PATIENT_MO_CATALOG_SELECT", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PATIENT_MO_CATALOG_SELECT") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_PATIENT_MO_ORDER_FOR_POSTMORTERM_COUNT", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PATIENT_MO_ORDER_FOR_POSTMORTERM_COUNT") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_MO_ORDER_FOR_POSTMORTERM_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_MO_ORDER_FOR_POSTMORTERM_INSERT") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_OR_AUTOREPORT_COMPLETION", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_OR_AUTOREPORT_COMPLETION") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_APPL_SELECT", 	OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_APPL_SELECT") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_GENERATION", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_ID_EXT_GENERATION") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_RL_NEONATES", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RL_NEONATES") );
				sqlMap.put( "SQL_OR_ORDER_ENTRY_FORMAT_HDR_CHK", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_HDR_CHK") );

				// added on 08/05/07

			//	sqlMap.put( "SQL_OR_ORDER_GET_STATUS_CODE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_GET_STATUS_CODE") );
				sqlMap.put("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_CONSENT_FORM_DRAFT_INSERT"));
				sqlMap.put("SQL_OR_ORDER_ENTRY_CANCEL_LINE2", OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CANCEL_LINE2"));
				sqlMap.put("SQL_OR_ASSOCIATE_CONSENT", OrRepositoryExt.getOrKeyValue("SQL_OR_ASSOCIATE_CONSENT") );
				sqlMap.put("SQL_OR_CONSENT_DRAFT_AMEND_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_CONSENT_DRAFT_AMEND_DELETE") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_EMAIL", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_EMAIL_PWD", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL_PWD") );
				sqlMap.put("SQL_OR_ORDER_ENTRY_EXTERNAL_ORDER_OR_GET_BILL_DOC_TYPE", OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EXTERNAL_ORDER_OR_GET_BILL_DOC_TYPE") );
				sqlMap.put("SQL_OR_BL_USER_CHECK_FOR_CASH_COUNTER", OrRepositoryExt.getOrKeyValue("SQL_OR_BL_USER_CHECK_FOR_CASH_COUNTER") );
				//upto here
 			  }
			  catch(Exception e)
			  {
				e.printStackTrace() ;
			  }
		//	OROrderEntryHome home = null ; 		//	OROrderEntryRemote remote = null ;
			
			 try
			 {
					Object home = com.ehis.eslp.ServiceLocator.getInstance ().getHome(OrRepository.getOrKeyValue("OR_ORDER_ENTRY_JNDI"), OROrderEntryHome.class, getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					/*
					InitialContext context = new InitialContext() ;
					Object object = context.lookup( OrRepository.getOrKeyValue("OR_ORDER_ENTRY_JNDI") ) ;
					home  = (OROrderEntryHome) PortableRemoteObject.narrow( object, OROrderEntryHome.class ) ;
					remote  = home.create() ;
					map    = remote.insert( tabdata, sqlMap ) ;
					*/
					Object argArray[]	= new Object[2];
 						argArray[0]		= tabdata;
						argArray[1]		= sqlMap;
 					Class [] paramArray = new Class[2];
 						paramArray[0]	= tabdata.getClass();
						paramArray[1]	= sqlMap.getClass();
 					map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
 					// Remove the objects
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					// Nullifying the Objects
					argArray			= null;
					paramArray			= null;
					boolean result1 = ((Boolean) map.get( "result" )).booleanValue() ; 
				//[IN032796] Start
					//IN046592 Start.
					print_specimen_labels = new Hashtable();
					int recCount = 0;
					//IN046592 End.
					int count_records = map.get("count_records")== null ? 0 :(Integer)map.get("count_records");
					if(count_records>0){
						//IN046592 Start.
						for(int cr=0;cr<count_records;cr++){
							String report_exec_ind =(String) map.get("report_exec_ind"+cr);	 
							if(result1 && ("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind))){	
								print_specimen_labels.put("order_id"+recCount,(String) map.get("order_id_"+cr));
								print_specimen_labels.put("facility_id"+recCount,(String) map.get("orderingFacility"+cr));  //IN034769
								print_specimen_labels.put("specimen_no"+recCount,(String) map.get("specimen_no"+cr));
								print_specimen_labels.put("login_at_ws_no"+recCount,login_at_ws_no);
								print_specimen_labels.put("source_type"+recCount,(String)map.get("source_type"+cr));	
								print_specimen_labels.put("source_code"+recCount,(String)map.get("source_code"+cr));
								print_specimen_labels.put("order_type_code"+recCount,(String)map.get("order_type_code"+cr));
								print_specimen_labels.put("language_id"+recCount,language_id);
								print_specimen_labels.put("specimen_type"+recCount,(String) map.get("specimen_type"+cr));//IN071820
								//System.out.println("orderentryBean.java Order.java====================3003=============>"+(String)map.get("specimen_type"+cr));
								recCount++;
							}
						}
						print_specimen_labels.put("total_recs",Integer.toString(recCount));
						
						/*for(int cr=0;cr<count_records;cr++){	
							String report_exec_ind =(String) map.get("report_exec_ind"+cr);	 
							if(result1 && ("RC".equals(report_exec_ind)||"RS".equals(report_exec_ind))){
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
						// IN046592 End.
					}
				//[IN032796] End

					//OROrderEntryTest remote = new OROrderEntryTest();
					//map = remote.insert(tabdata, sqlMap ) ;
					//String str = ((String)map.get("traceVal"));

				    //tmpBuff.append("BEAN FROM EJB"+str);
						
					if((((String)map.get( "message")).trim()).equalsIgnoreCase("RECORD_INSERTED"))
					{
						String ohorder_id=(String)map.get( "order_id");
						if(externalOrdersBean!=null)
							externalOrdersBean.setOrderId(ohorder_id);

						// Call a method removeBeanValues () from the bean to remove the values (catalog_codes,etc..)
						removeBeanValues();
						// Call a method to print a report for the order_id generated, store it in the Hashtable
//						stored_print_values		= (Hashtable) map.get("print_values");  // Global HashTable used to stored the values (for consent orders)
						print_specimen_values	= (Hashtable) map.get("print_specimen_values");  // Global HashTable used to stored the values(for specimen print)
						/*Added by Uma on 10/15/2009 for SRR20056-CRF195*/
						print_report_values	= (Hashtable) map.get("print_report_values");  // Global HashTable used to stored the values(for billing report print)
						/* Ends Here*/

						oa_bookappt_values		= (Hashtable) map.get("oa_bookappt_values");  // Global HashTable used to stored the values(for to be passed to the Appointment booking)
						external_order_stlmt_bill_data		= (Hashtable) map.get("external_order_stlmt_bill_data");  // Global HashTable used to stored the values(for to be passed to the External Order Billing  Settlement Details  Added by Uma 3/20/2009)
						trn_group_ref		= (String) map.get("trn_group_ref");  // Global String used to stored the trn_group_ref_id
						//callOnLinePrinting(beanObj.getPrintValues(), stored_print_values);
						// And print_values also stored in Global HashTable //callOnLinePrinting(stored_values);
						//map.put("message",getMessage((String)map.get( "message")));
						String called_from=(String)hashValues.get("called_from");
						if(called_from.equalsIgnoreCase("OH"))
						{
							StringBuffer chking=new StringBuffer();
							chking.append(getMessage(language_id, (String) map.get( "message" ), "SM"));
							chking.append("<BR1>");
							chking.append((String)map.get("order_id"));
							map.put("message", chking.toString()) ;
						}
						else
						{
							map.put("message", getMessage(language_id, (String) map.get( "message" ), "SM"));
						}
						map.put("order_id", (String)map.get("order_id"));
				        map.put("traceVal", (String)tmpBuff.toString());
				        //IN064614 starts
				//IN071315  Start.
				        //String str_barcode_count_records = map.get("barcode_count_records").toString();//Commented to handle Null Pointer Exception
				        String str_barcode_count_records = null;
				        int barcode_count_records =0;
				        if(map.get("barcode_count_records")!=null){
				        	str_barcode_count_records = map.get("barcode_count_records").toString();
				        	barcode_count_records = Integer.parseInt(str_barcode_count_records);
				        }
					//IN071315 End.				    	
				        if(barcode_count_records >0 && "TR".equalsIgnoreCase(getOrderCategoryValue()))
				        {
				        	print_barcode_values = (Hashtable) map.get("print_barcode_values");
				        	print_barcode_values.put("barcode_count_records",barcode_count_records);
				        }
				        //IN064614 ends

						prn_lbl_values = (Hashtable) map.get("prn_lab_values");//IN065942						
					}
					else
					{
						map.put("message",(String) map.get( "message" ));
						map.put("result",new Boolean(false));
					}
				} catch(Exception e) {

					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
			  }
			  /*finally {
			 try {	if( remote != null ) remote.remove() ;
				} catch( Exception ee ) {

				  map.put( "message", ee.getMessage() ) ;
				}
 			  }
			  */
		  } // End of if result (if order_id is not there)
		  else
		  {
			  map.put("message",getMessage(language_id,"ORDER_ID_GENERATION_PATIENT","OR"));
			  map.put("result",new Boolean(false));
		  }
  } 
  // End of if
  else { // come out
      map.put("message", checkForNull((String)hashValues.get("stop_message"),""));
	  map.put("result", new Boolean(false));
  }
  }//IN050607 Starts
  else{
	 map.put("message", getMessage(language_id,"OR_ORDERING_RULE_CHK","OR"));
	 map.put("result", new Boolean(false));
  }//IN050607 Ends
    map.put("traceVal", (String)tmpBuff.toString());
	tmpBuff.setLength(0);  // Clearing the string buffer
    return map ;
 }//end of insert
 /********************Validate Method ****************************/
 public HashMap validate() throws Exception {
  HashMap map 		= new HashMap() ;
  boolean status 	= true;
  boolean panel_dup_chk=isSiteSpecific("DISABLE_PANL_DUPLICATE_CHECK");//IN066302
/***************/

if(getAmendOrder().equalsIgnoreCase("existing_order"))
{
	 if(amend_total_count > 0)
	  {
			String perform_yn = getStatus(getOrderId(),(String)hashValues.get("amend_order_type0"));// amend_order_id is passed
			if(perform_yn.equalsIgnoreCase("N")){
				map.put( "message", "APP-OR0271 Cannot Perform this Opeartion. Since Order Status has been Changed by Some Other User" ) ;
				map.put("result", new Boolean( false ) ) ;
				return map ;
			}
	  }
}
/**************/
  if(validated_status.equals("validation_reqd"))
  {
		if(count_chk_records > 0) status = validateSuspendedCheck(); // Call this to do the Duplicate check for Suspended Codes
		if(status)
		{
			if(count_chk_records > 0 || amend_total_count >0) 
				if(!panel_dup_chk)//IN066302
				status = validateSamePanelDuplCheck(); // Call this to do the Duplicate check for same panels code
			if(status)
			{
				// First check for the Restriction , Lab is installed, and order_category is 'LB' (OR) Radialogy is installed, and order_category is 'RD'
				// and it is an Panel, then check the Test code and Panel should not be selected
	    		if(count_chk_records > 0 || amend_total_count >0) status = validatePanelDuplCheck(); // Call this to do the Duplicate check
				if(status) // No Duplicates were found, then check for each individual
				{
				    if(count_chk_records > 0) status = validateDuplCheck(); // Call this to do the Duplicate check
					if(status)
					{	// Exam conflict done here
						if(count_chk_records > 0) status = validateExamConflicts(); // Call this to do Exam conflict for Radialogy
						if(status) // Radialogy Appointment Check
						{
							if(count_chk_records > 0 || amend_total_count >0) status = validateAppointment(); // Call this to do validate Appointments
							map.put( "message", "" ) ;
							if(!status)  // If status is false, then show the modal window for the duplication
								 map.put( "flag", String.valueOf(OrRepository.SHOW_MODAL_WINDOW)) ;
							else
    					  		map.put( "flag","");
					   }
					   else
					   {
							map.put( "message", "" ) ;
							map.put( "flag", String.valueOf(OrRepository.SHOW_MODAL_WINDOW)) ;
					   }
				   }
				   else
				   {
						map.put( "message", "" ) ;
						map.put( "flag", String.valueOf(OrRepository.SHOW_MODAL_WINDOW)) ;
				   }
			 	}
			 	else // Show in the modal window
			 	{
					map.put( "message", "" ) ;
					map.put( "flag", String.valueOf(OrRepository.SHOW_MODAL_WINDOW)) ;
				}
			}
			else //Else display the error in the modal window
			{
				map.put( "message", "" ) ;
				map.put( "flag", String.valueOf(OrRepository.SHOW_MODAL_WINDOW)) ;
			}
		} // Else show the errors in the Modal window.
		else
		{
			map.put( "message", "" ) ;
			map.put( "flag", String.valueOf(OrRepository.SHOW_MODAL_WINDOW)) ;
		}
  }
  map.put("hashValues",hashValues);			// used to set the bean values
  map.put("result", new Boolean( status ) ) ;
  return map ;
 }//end of validate

 /*------------------------------------------------------------------------------*/
 /*        Generation of Order Id Logic Derived Here							 */
 /*------------------------------------------------------------------------------*/
 private HashMap generateUniqueIds() throws Exception {
  HashMap map       		= new HashMap();
 // HashMap mapUniqueId  		= new HashMap();//IN071393
 // HashMap mapOrderId   		= new HashMap();//IN071393
  LinkedHashMap mapUniqueId  		= new LinkedHashMap();//IN071393
  LinkedHashMap mapOrderId   		= new LinkedHashMap();//IN071393
  HashMap mapOrderStatus	= new HashMap();
  boolean result     		= false;
  String grouping     		= "", comb_string     	= "", amend_grouping      		= "";
  String addnl_fields		= "";// comb_string_temp  = "";//51003
  String temp_string   		= "", order_type     	= "";//consent_temp_string="";/51003
  String order_type_val		= "", regd_reqd_yn     	= "", order_status_code     	= "";
  String auth_reqd_yn		= "", consent_reqd_yn   = "", appt_reqd_yn				= "";
  String priority    		= "", ord_spl_appr_reqd_yn   	= "";
  String order_category  	= "", complete_on_order_yn   	= "";
  String order_set_id		= "", split_grouping	= ""; int grouping_seq_no		= 0; // split_grouping & grouping_seq_no used for OA_book_appt
  String consent_stage_hdr	= "", auto_report_yn	= "N";
  String consent_form_id   = "";//IN030298
  String consent_stage  = "";// IN037633
  StringTokenizer St_order_type = null;
  String record[]			= null;
  String labchk="";
  String catalog_code="";
  ArrayList multi_patient	= null;

  Connection connection 		= null;
  PreparedStatement pstmt 	= null;
  ResultSet resultSet 		= null;

  ArrayList arrayList  		= new ArrayList() ;
  ArrayList consentstage  		= new ArrayList() ;
  String split_auth = "";
  int count        			= 0;
  String order_id			= "" , pat_id			= "", encounter_id	= "",patient_class	= "";
  int count_patient			= 1; // By Default one patient

  print_values     			= new Hashtable();    // Used for Printing
  multi_patient				= getMultiPatientDetails();  // Get the Multi Patient Orders Details
  if(multi_patient!=null && multi_patient.size() > 0)
		count_patient		= multi_patient.size();
  pat_id					= checkForNull((String)hashValues.get("patient_id"),""); // Get the Patient Id (if One patient)
  encounter_id				= checkForNull((String)hashValues.get("encounter_id"),""); // Get the Encounter_id (if One patient)
  patient_class				= checkForNull((String)hashValues.get("patient_class"),""); // Get the Patient_class
  try{
	 if(hashValues!=null){
		 count = Integer.parseInt((String)hashValues.get("total_count"));
	  }

      // For Care Set to generate the Order_Set_id
	  if(care_set_count > 0) {
			order_set_id 	= ((String)generateOrderId("CS", patient_class,login_facility_id) );//IN032925
			hashValues.put("order_set_id",checkForNull(order_set_id,""));
	  }

	   if(amend_total_count > 0) // Amend is also there
		 {
	        //amend_grouping = ((String)hashValues.get("amend_grouping"));



			 for(int i=0; i<amend_total_count; i++) { // One record is enough all will be same
				// OO0 is for appt_reqd_yn grouping, in amend it is restrice
				
				if(checkForNull((String)hashValues.get("amend_ord_consent_reqd_yn"+i),"N").equals("Y"))
			  {
				  consentstage.add(checkForNull((String)hashValues.get("amend_consent_stage"+i),"N"));
			  }
			  else
			  {
					 consentstage.add("N");
			  }

				String amend_frequency_code=checkForNull((String)hashValues.get("amend_frequency_val"+i),"^^");
				StringTokenizer ammend=new StringTokenizer(amend_frequency_code,"~~");


				String amend_frequency="";
				while(ammend.hasMoreTokens())
			    {
					 amend_frequency = ammend.nextToken();

					 break;
			    }
			  

			  if((checkForNull((String)hashValues.get("amend_ord_auth_reqd_yn"+i)).equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_authorised_yn"+i)).equalsIgnoreCase("N")))
			  {
					split_auth = "Y";
			  }
			  else
			  {
				  split_auth = "N";
			  }
				if(amend_frequency_code.equals("^^"))
				{
					amend_grouping		= "N"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("order_category"),"CS")+"~~"+"C"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("amend_performing_facility_id"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_order_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_priority"+i),"^^")+"~~"+checkForNull((String)hashValues.get("ord_appr_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("amend_specimen_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_nurse_collect"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_start_date_time"+i),"^^")+"~~"+amend_frequency+"~~"+checkForNull((String)hashValues.get("amend_duration_value"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_performing_dept_loc_code"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_splty_code"+i),"^^")+"~~"+checkForNull(split_auth,"^^")+"~~"+"000";//uncommented IN041371
					//amend_grouping		= "N"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("order_category"),"CS")+"~~"+"C"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("amend_performing_facility_id"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_order_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_priority"+i),"^^")+"~~"+checkForNull((String)hashValues.get("ord_appr_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("amend_specimen_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_nurse_collect"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_start_date_time"+i),"^^")+"~~"+amend_frequency+"~~"+checkForNull((String)hashValues.get("amend_duration_value"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_performing_dept_loc_code"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_splty_code"+i),"^^")+"~~"+checkForNull(split_auth,"^^")+"~~"+"000"+checkForNull((String)hashValues.get("amend_consent_stage"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_consent_form_id"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_ord_consent_reqd_yn"+i),"N");
					//IN041371 starts
					if(checkForNull((String)hashValues.get("amend_ord_consent_reqd_yn"+i),"N").equals("Y"))
					{
						amend_grouping = amend_grouping +"~~"+checkForNull((String)hashValues.get("amend_consent_stage"+i),"amend_consent_stage"+i);
						amend_grouping = amend_grouping +"~~"+checkForNull((String)hashValues.get("consent_form_id"+i),"consent_form_id"+i);
					}
					else
					{
						amend_grouping = amend_grouping +"~~^^~~^^";
					}
					//IN041371 ends
					
				}
				else
				{
					amend_grouping		= "N"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("order_category"),"CS")+"~~"+"C"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("amend_performing_facility_id"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_order_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_priority"+i),"^^")+"~~"+checkForNull((String)hashValues.get("ord_appr_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("amend_specimen_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_nurse_collect"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_start_date_time"+i),"^^")+"~~"+amend_frequency+"~~"+checkForNull((String)hashValues.get("amend_duration_value"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_performing_dept_loc_code"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_splty_code"+i),"^^")+"~~"+checkForNull(split_auth,"^^")+"~~"+i+"~~"+"000";//uncommented IN041371
					//amend_grouping		= "N"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("order_category"),"CS")+"~~"+"C"+"~~"+"N"+"~~"+"N"+"~~"+"N"+"~~"+checkForNull((String)hashValues.get("amend_performing_facility_id"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_order_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_priority"+i),"^^")+"~~"+checkForNull((String)hashValues.get("ord_appr_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("amend_specimen_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_nurse_collect"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_start_date_time"+i),"^^")+"~~"+amend_frequency+"~~"+checkForNull((String)hashValues.get("amend_duration_value"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_performing_dept_loc_code"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_splty_code"+i),"^^")+"~~"+checkForNull(split_auth,"^^")+"~~"+i+"~~"+"000"+checkForNull((String)hashValues.get("amend_consent_stage"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_consent_form_id"+i),"^^")+"~~"+checkForNull((String)hashValues.get("amend_ord_consent_reqd_yn"+i),"N");
					//IN041371 starts
					if(checkForNull((String)hashValues.get("amend_ord_consent_reqd_yn"+i),"N").equals("Y"))
					{
						amend_grouping = amend_grouping +"~~"+checkForNull((String)hashValues.get("amend_consent_stage"+i),"amend_consent_stage"+i);
						amend_grouping = amend_grouping +"~~"+checkForNull((String)hashValues.get("consent_form_id"+i),"consent_form_id"+i);
					}
					else
					{
						amend_grouping = amend_grouping +"~~^^~~^^";
					}
					//IN041371 ends
				}
				//IN073051 starts
			/*	 String fpp_yn = checkForNull((String)hashValues.get("fpp_yn"+i),"^^");
				   String fpp_category = checkForNull((String)hashValues.get("fpp_category"+i),"^^");
				   amend_grouping = amend_grouping +"~~"+fpp_yn+"~~"+fpp_category;*///10531
				   //IN073051 ends
			 } // End of for
			 
			arrayList.add(amend_grouping); // If it is same it will over write ..
			hashValues.put("amend_grouping",checkForNull(amend_grouping,"")); // Only one will be there
		 } // end of amend_total_count
	    if(count > 0 )
		{
	      for(int i=0; i<count; i++)
		  {		//If it an RD Category and rd_install_yn (rd is installed) , it should not break the order

   			   if( (!(checkForNull((String)hashValues.get("rd_install_yn"),"N").equals("Y") && checkForNull((String)hashValues.get("order_category"+i),"CS").equals("RD")) ) && checkForNull((String)hashValues.get("appt_reqd_yn"+i),"N").equals("Y")) {
 				  grouping_seq_no++; // Increase the counter, so that if appt_reqd_yn is there will go as an different order
	 		      split_grouping = splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
			   } else if(checkForNull((String)hashValues.get("chart_result_type"+i),"D").equals("P")) {
				  grouping_seq_no++; // Increase the counter,(For Treatment if procedure is there) so that if chart_result_type is there will go as an different order
			      split_grouping = splitGroupingOrders(grouping_seq_no); // call a method to get the split_grouping like "000" or "001" etc
			   } else split_grouping = "000";
				
			   if(checkForNull((String)hashValues.get("ord_consent_reqd_yn"+i),"N").equals("Y") && 	consent_stage_hdr.equals("")) // Then take the consent stage and set it for the Header also (first time)
			   {
					consent_stage_hdr	= checkForNull((String)hashValues.get("consent_stage"+i),"");
			   }
			    if(checkForNull((String)hashValues.get("ord_consent_reqd_yn"+i),"N").equals("Y"))
			  {
				  consentstage.add(checkForNull((String)hashValues.get("consent_stage"+i),"N"));
				
			  }
			  else
			  {
					 consentstage.add("N");
			  }
			
 			  //HashMap mapGroup = new HashMap();
			 
	           addnl_fields = checkForNull((String)hashValues.get("ord_auth_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("ord_consent_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("complete_on_order_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("ord_cosign_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("order_category"+i),"CS")+"~~"+checkForNull((String)hashValues.get("freq_nature"+i),"F")+"~~"+checkForNull((String)hashValues.get("cont_order_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("auto_report_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("appt_reqd_yn"+i),"N")+"~~";
   		       // If it null or empty replace with ^^
			   //If it is for OT orders and OT is installed, then take the primary ordertype for grouping
			   if(checkForNull((String)hashValues.get("order_category"+i),"CS").equals("OT"))
			   {
					order_type = checkForNull((String)hashValues.get("primary_order_type"),"^^");
					if(order_type.equals("^^")) //if it is null
						order_type = checkForNull((String)hashValues.get("order_type"+i),"^^");
			   } else {
				    order_type = checkForNull((String)hashValues.get("order_type"+i),"^^");
			   }
			 
			   catalog_code=checkForNull((String)hashValues.get("catalog_code"+i));//added on 7/9/2007 for lb_instal_yn logic by uma
			
			   if((checkForNull((String)hashValues.get("ord_auth_reqd_yn"+i)).equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("authorised_yn"+i)).equalsIgnoreCase("N")))
			  {
					split_auth = "Y";
			  }
			  else
			  {
				  split_auth = "N";
			  }
			   String freq_val = checkForNull((String)hashValues.get("frequency_val"+i),"^^");
			   if(freq_val.equals("^^"))
			   {
					grouping = addnl_fields + checkForNull((String)hashValues.get("performing_facility_id"+i),"^^")+"~~"+order_type+"~~"+checkForNull((String)hashValues.get("priority"+i),"^^")+"~~"+checkForNull((String)hashValues.get("ord_spl_appr_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("specimen_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("nurse_collect"+i),"^^")+"~~"+checkForNull((String)hashValues.get("start_date_time"+i),"^^")+"~~"+freq_val+"~~"+checkForNull((String)hashValues.get("duration_value"+i),"^^")+"~~"+checkForNull((String)hashValues.get("performing_dept_loc_code"+i),"^^")+"~~"+checkForNull((String)hashValues.get("splty_code"+i),"^^")+"~~"+checkForNull(split_auth,"^^")+"~~"+split_grouping;
					//changed on 7/11/2007 for catalogcode
					
					//IN030298 starts
					if((checkForNull((String)hashValues.get("ord_consent_reqd_yn"+i),"N")).equalsIgnoreCase("Y"))
					{
						grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_stage"+i),"consent_stage"+i);//IN037633
						grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_form_id"+i),"consent_form_id"+i);
					}
					else
					{
						//grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_stage"+i),"^^");//IN037633
						//grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_form_id"+i),"^^");
						grouping = grouping +"~~^^~~^^";//emg for medicity
					}
					//IN030298 ends

			   }
        	   else
			   {
				   grouping = addnl_fields + checkForNull((String)hashValues.get("performing_facility_id"+i),"^^")+"~~"+order_type+"~~"+checkForNull((String)hashValues.get("priority"+i),"^^")+"~~"+checkForNull((String)hashValues.get("ord_spl_appr_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("specimen_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("nurse_collect"+i),"^^")+"~~"+checkForNull((String)hashValues.get("start_date_time"+i),"^^")+"~~"+freq_val+"~~"+checkForNull((String)hashValues.get("duration_value"+i),"^^")+"~~"+checkForNull((String)hashValues.get("performing_dept_loc_code"+i),"^^")+"~~"+checkForNull((String)hashValues.get("splty_code"+i),"^^")+"~~"+checkForNull(split_auth,"^^")+"~~"+i+"~~"+split_grouping;
				   
				   //IN030298 starts
				   if((checkForNull((String)hashValues.get("ord_consent_reqd_yn"+i),"N")).equalsIgnoreCase("Y"))
					{
						grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_stage"+i),"consent_stage"+i);//IN037633
						grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_form_id"+i),"consent_form_id"+i);
					}
					else
					{
						//grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_stage"+i),"^^");//IN037633
						//grouping = grouping +"~~"+checkForNull((String)hashValues.get("consent_form_id"+i),"^^");
						grouping = grouping +"~~^^~~^^";//emg for medicity
					}
					//IN030298 ends

				   //changed on 7/11/2007 for catalogcode
			   }

				
 		       //grouping = addnl_fields + checkForNull((String)hashValues.get("performing_facility_id"+i),"^^")+"~~"+order_type+"~~"+checkForNull((String)hashValues.get("priority"+i),"^^")+"~~"+checkForNull((String)hashValues.get("ord_spl_appr_reqd_yn"+i),"N")+"~~"+checkForNull((String)hashValues.get("specimen_type"+i),"^^")+"~~"+checkForNull((String)hashValues.get("nurse_collect"+i),"^^")+"~~"+checkForNull((String)hashValues.get("start_date_time"+i),"^^")+"~~"+checkForNull((String)hashValues.get("frequency_val"+i),"^^")+"~~"+checkForNull((String)hashValues.get("duration_value"+i),"^^")+"~~"+checkForNull((String)hashValues.get("performing_dept_loc_code"+i),"^^")+"~~"+checkForNull((String)hashValues.get("catalog_code"+i),"^^")+"~~"+split_grouping;
			  
			// IN068314 Start.			   
			/*   String fpp_yn = checkForNull((String)hashValues.get("fpp_yn"+i),"^^");
			   String fpp_category = checkForNull((String)hashValues.get("fpp_category"+i),"^^");
			   grouping = grouping +"~~"+fpp_yn+"~~"+fpp_category;*///10531
			// IN068314 End.			   
			   arrayList.add(grouping);

	          //mapGroup.put("order_id_grouping",grouping); //arrayList.add( mapGroup );
			
		}

		ArrayList orderCategory = new ArrayList();
		ArrayList categoryArray = new ArrayList();
		HashMap catalogs = new HashMap();
		ArrayList toSort = new ArrayList();
		ArrayList finalList = new ArrayList();
		for(int i=0;i<arrayList.size();i++)
	    {
	
			if(!orderCategory.contains(checkForNull((String)hashValues.get("order_category"+i),"CS")))
			{
				orderCategory.add(checkForNull((String)hashValues.get("order_category"+i),"CS"));
	
				categoryArray = new ArrayList();
				categoryArray.add(arrayList.get(i));
			}
			else
			{
				categoryArray.add(arrayList.get(i));
			}
			catalogs.put((checkForNull((String)hashValues.get("order_category"+i),"CS")),categoryArray);
		}

		if(orderCategory!=null)
		{
			if(orderCategory.size()>0)
			{
				for(int i=0;i<orderCategory.size();i++)
				{
					toSort = new ArrayList();
					toSort = (ArrayList)catalogs.get((String)orderCategory.get(i));
		
//----------------------------------------- IN071393 starts------------------------------------
					/* 
					for(int j=0;j<toSort.size()-1;j++)
					{
						
			
						for(int k=0;k<toSort.size()-j-1;k++)
						{
							  comb_string		 = (String)toSort.get(k);
							  comb_string_temp   = (String)toSort.get(k+1);
							  //Substring used to remove the auth_reqd_yn,complete, order_category and cosign_reqd_yn and then do the sortint / grouping
							 
							  if((((String)toSort.get(k)).substring(28, comb_string.length())).compareTo( ((String)toSort.get(k+1)).substring(28, comb_string_temp.length()) ) > 0  )
							  {
								 temp_string     = (String)toSort.get(k);
								 consent_temp_string     = (String)consentstage.get(k);
								 
								 toSort.set(k,(String)toSort.get(k+1));
								 toSort.set(k+1,temp_string);
								 consentstage.set(k,(String)consentstage.get(j+1));
								 consentstage.set(k+1,consent_temp_string);
								 
							  } // End of if
						} // end of for k
					} // end of for j
					*/
					//----------------------------------------- IN071393 ends------------------------------------
					catalogs.put(orderCategory.get(i),toSort);
					for(int z=0;z<toSort.size();z++)
					{
						finalList.add(toSort.get(z));
					}
				}//end of i
			}
		}
	    // Sorting Done Here
		/*for(int i=0;i<arrayList.size()-1;i++)
	    {			
			for(int j=0;j<arrayList.size()-i-1;j++)
			{				  
				  comb_string		 = (String)arrayList.get(j);				  
			      comb_string_temp   = (String)arrayList.get(j+1);
				  //Substring used to remove the auth_reqd_yn,complete, order_category and cosign_reqd_yn and then do the sortint / grouping
				  
			      if((((String)arrayList.get(j)).substring(28, comb_string.length())).compareTo( ((String)arrayList.get(j+1)).substring(28, comb_string_temp.length()) ) > 0  )
				  {
			 		 temp_string     = (String)arrayList.get(j);
			 		 consent_temp_string     = (String)consentstage.get(j);
					 
	         		 arrayList.set(j,(String)arrayList.get(j+1));
		             arrayList.set(j+1,temp_string);
					 consentstage.set(j,(String)consentstage.get(j+1));
					 consentstage.set(j+1,consent_temp_string);
					 			 
			      } // End of if
	       } // end of for j
		} // end of for i*/
	     // Grouping Done here
	
		if(finalList!=null)
		{
			arrayList = finalList;
		}
		
		for(int k=0;k<count_patient;k++)
		{   // Atleast one patient selected at a time, If Multi Patient Orders, Multi Patient may come
			if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
			{
				record			= (String[]) multi_patient.get(k);
				pat_id			= checkForNull(record[0],""); //patient_id
				encounter_id	= checkForNull(record[1],""); //encounter_id
			} // End of multi_patient != null
			temp_string = "";
			ArrayList StatusOrder=new ArrayList();
			String OrderStatus="";
 		    for(int i=0;i<arrayList.size();i++)
			{
				comb_string    = (String)arrayList.get(i); //28

				order_type_val 	= ((String)arrayList.get(i));
				//split the first to get the order type
				if(order_type_val != null)
					St_order_type = new StringTokenizer(order_type_val,"~~");
				while(St_order_type.hasMoreTokens())
				{
					auth_reqd_yn   			= checkForNull(St_order_type.nextToken(),"N");
					consent_reqd_yn 		= checkForNull(St_order_type.nextToken(),"N");
					complete_on_order_yn	= checkForNull(St_order_type.nextToken(),"N");
					St_order_type.nextToken();  // cosign_reqd_yn
					order_category = St_order_type.nextToken();  // order_category
					St_order_type.nextToken();  // freq_nature
					St_order_type.nextToken();  // cont_order_yn
					auto_report_yn			= checkForNull(St_order_type.nextToken(),"N");
					//auto_report_yn  (used for getting hdr status)
					appt_reqd_yn			= checkForNull(St_order_type.nextToken(),"N");  // to pass to getOrderStatus
					// Real grouping starts from here
					St_order_type.nextToken();  // performing_facility_id 	=
					order_type 				= checkForNull(St_order_type.nextToken(),""); // For order_type;
					priority			 	= checkForNull(St_order_type.nextToken(),"");
					ord_spl_appr_reqd_yn 	= checkForNull(St_order_type.nextToken(),"N");
					St_order_type.nextToken();   // specimen_type
					St_order_type.nextToken();   // nurse_collect
					St_order_type.nextToken();   // start_date_time

					
					St_order_type.nextToken();   // frequency_val
					St_order_type.nextToken();   // duration_value
					St_order_type.nextToken();   // performing_dept_loc_code

					split_grouping			= checkForNull(St_order_type.nextToken(),""); //Not used(OA Appt) new order if 'Y'
					// Other fields no need
					consent_stage			= checkForNull(St_order_type.nextToken(),"");//IN037633
					consent_form_id			= checkForNull(St_order_type.nextToken());//IN030298
					break;
				} // End of while
 			    if(!temp_string.equals(((String)arrayList.get(i)).substring(28, comb_string.length())))
				{
					StatusOrder.clear();
					OrderStatus = "";
					mapUniqueId.put((((String)arrayList.get(i)).substring(28, comb_string.length())),(String)arrayList.get(i));
	        		temp_string  = (((String)arrayList.get(i)).substring(28, comb_string.length()));
			        // To get the order_category for the Care Sets
			        // Get the Order Type and call a method to call the regd_reqd_yn
				    // From the length 28 it will be ordertype b'coz auth_reqd_yn+"~~"+consent_reqd_yn+"~~"+cosign_reqd_yn+"~~"+order_category+"~~"+freq_nature+"~~"+cont_order_yn+"~~"+appt_reqd_yn+"~~"+auto_report_yn+"~~"+performing_fid+"~~"+split_grouping
					// Split grouping will be used if appt_reqd_yn is there it will split into new order
					

					
					// Till Here
					// If it is not for amend order, call the method to generate the order_id
					// other wise the order_id will  be aleady there
					if(amend_grouping.length()> 0) // For Amend where the grouping will have value
					{
	   					if(temp_string.equalsIgnoreCase(amend_grouping.substring(28,amend_grouping.length()))) // For Amend order
						{
							order_id   = getOrderId();
						}
						else
						{   // Call a method to generate the orderId
							order_id 	= ((String)generateOrderId(checkForNull(order_category,""), patient_class,login_facility_id) );//IN032925
						}
					}
					else // For New Orders
					{
						// Call the generateOrderId method to generate the order_id
						order_id 	= ((String)generateOrderId(checkForNull(order_category,""), patient_class,login_facility_id) );//IN032925
 					}
					// Till here
					// If order_id is null, then give the message and come out
				   	if(checkForNull(order_id,"").equals(""))
		   			{
		   			  	result 		 = true;
						break;
				   	}
 				   	// Set the order_id in the hashmap.
			 	//mapOrderId.put((((String)arrayList.get(i)).substring(28,comb_string.length())),order_id);
	  				
					mapOrderId.put((((String)arrayList.get(i)).substring(28,comb_string.length()))+pat_id+encounter_id, order_id);
					//mapOrderId.put("catalog_code",catalog_code);
		 			if(!result)
			 		{
			 			if(!temp_string.equalsIgnoreCase(amend_grouping)) // For New orders
						{
							// Call a method getRegReqdValue() to get the Regd.
							labchk=getmoduleRL(catalog_code,order_category,order_type,login_facility_id);
							//if(order_category.equalsIgnoreCase("LB") && (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")))changed on 7/9/2007 for lb_instal_yn by uma
						
							if((order_category.equalsIgnoreCase("LB"))&&(checkForNull(labchk,"").equalsIgnoreCase("IBARL")))
								regd_reqd_yn = "N";
							else
								regd_reqd_yn = ((String)getRegReqdValue(order_type));
 							// Find the Order Status getOrderStatus() for the order_type
							//order_status_code = ((String)getOrderStatus(auth_reqd_yn,consent_reqd_yn,complete_on_order_yn,regd_reqd_yn,ord_spl_appr_reqd_yn,(String)hashValues.get("authorized"),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")),checkForNull(consent_stage_hdr,""), auto_report_yn, appt_reqd_yn,  checkForNull((String)hashValues.get("xh_install_yn"),"N") ));
							
							order_status_code = ((String)getOrderStatus(auth_reqd_yn,consent_reqd_yn,complete_on_order_yn,regd_reqd_yn,ord_spl_appr_reqd_yn,(String)hashValues.get("authorized"),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")),checkForNull(((String)consentstage.get(i)),"N"), auto_report_yn, appt_reqd_yn,  checkForNull((String)hashValues.get("xh_install_yn"),"N") ));

  							mapOrderStatus.put(order_id+pat_id+encounter_id, order_status_code);
							StatusOrder.add(((String)getOrderStatus(auth_reqd_yn,consent_reqd_yn,complete_on_order_yn,regd_reqd_yn,ord_spl_appr_reqd_yn,(String)hashValues.get("authorized"),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")),((String)consentstage.get(i)), auto_report_yn, appt_reqd_yn,  checkForNull((String)hashValues.get("xh_install_yn"),"N") )));
							
							
							// Set the values in the Hash Table for the Printing Purpose
							// Names/Key remain the same as in OnLinePrinting.java
							if( (!order_status_code.equalsIgnoreCase("PO")) && (!order_status_code.equalsIgnoreCase("PC"))  && (!order_status_code.equalsIgnoreCase("PS"))) // If it is not a pending Order
							{
								String print_option = (String)getPrintOptionInd(login_facility_id,order_type,patient_class,getLocationCode());
									if("N".equals(confirm_reqd_YN) && "C".equals(print_option))
									{
										confirm_reqd_YN = "Y";
									}	
								print_values.put("ord_id"+print_count,order_id);		 		 // order_id
								print_values.put("ord_typ_code"+print_count,order_type);		 // order_type_code
								print_values.put("patient_class"+print_count, patient_class);	 // patient_class
								print_values.put("priority"+print_count,priority);	 		     // priority
								print_values.put("source_type",getLocationType());	 // Location Type
								print_values.put("location_code"+print_count,getLocationCode()); // Location Code
								print_values.put("facility_id"+print_count,login_facility_id);	 // facility_id
									print_values.put("print_option"+print_count,print_option);//IN042962
									print_values.put("confirm_reqd_YN",confirm_reqd_YN);//IN042962
								print_count++;
							} // End of !order_status_code //OS
						} // End of if !temp_string.equalsIgnoreCase(amend_grouping)
					} // end of if !result
				} // End of if !temp
				else
				{
				    StatusOrder.add(((String)getOrderStatus(auth_reqd_yn,consent_reqd_yn,complete_on_order_yn,regd_reqd_yn,ord_spl_appr_reqd_yn,(String)hashValues.get("authorized"),((String)hashValues.get("consented")),((String)hashValues.get("special_approved")),((String)consentstage.get(i)), auto_report_yn, appt_reqd_yn,  checkForNull((String)hashValues.get("xh_install_yn"),"N") )));
					
					  
					for(int s=0;s<StatusOrder.size();s++)
					{
						OrderStatus = OrderStatus+"'"+StatusOrder.get(s)+"',";
						
					}
					
					mapOrderStatus.put(order_id+pat_id+encounter_id, getStatusHeader(OrderStatus.substring(0,OrderStatus.length()-1)));
					
				
				}
			} // End of for i arraylist
		 } // End of k (Patient_selected)
		   	// for(int k=0 ; k<arrayListDerived.size(); k++ )
  			//	map.put((HashMap) arrayListDerived.get(k),(HashMap) arrayListDerived.get(k));
	    } // end of if count
	    else if(amend_total_count > 0) // For Amend Orders  (Only when Amend Order is there)
   		{
	 		amend_grouping = ((String)hashValues.get("amend_grouping"));

			
		  	//mapUniqueId.put((amend_grouping.substring(28,amend_grouping.length())),amend_grouping);
		 	mapOrderId.put((amend_grouping.substring(28,amend_grouping.length())+pat_id+encounter_id ),getOrderId());
		 }
		if(print_count > 0 )
		{
			print_values.put("total_recs", String.valueOf(print_count));
			print_values.put("order_entry", "OrderEntry");
		}
		map.put("mapUniqueId",mapUniqueId) ;
		map.put("mapOrderId",mapOrderId);
		map.put("mapOrderStatus",mapOrderStatus);
		


	 } catch(Exception e) {

	        map.put( "message", e.getMessage() ) ;
	        e.printStackTrace() ;
      }
	  finally
	 {
			closeResultSet( resultSet ) ;
   			closeStatement( pstmt ) ;
   			closeConnection(connection);
	 }
		if(result)
			map.put( "result", new Boolean( false ) ) ;
		else
			map.put( "result", new Boolean( true ) ) ;

	    return map;
 } // End of generateUniqueIds

 // Generation Of Order Id
 //private String generateOrderId(String order_category,String patient_class) throws Exception {
  private String generateOrderId(String order_category,String patient_class,String login_facility_id) throws Exception {//IN032925
  		Connection connection 		= null;
  		PreparedStatement pstmt 	= null;
  		ResultSet resultSet 		= null;
  		String order_id				= "";
  		try
  		{
			
 			connection	= getConnection();
 			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_ORDER_ID_GENERATION") ) ;
  			pstmt.setString(1,checkForNull(order_category,""));
  			pstmt.setString(2,checkForNull(patient_class,""));
			pstmt.setString(3,checkForNull(login_facility_id,""));//IN032925
  			resultSet	= pstmt.executeQuery() ;
  			if(resultSet!=null) // Only One Record
 			{
  				while (resultSet.next() ) {
  					order_id = checkForNull(resultSet.getString("order_id"), "" );
 				}
 			}
 		}catch ( Exception e ){

  			e.printStackTrace() ;
  		} finally {
  			closeResultSet( resultSet ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(connection);
  		}
  		return order_id;
 } // end of the generateOrderId

	// Get the Regd Reqd. Yn by passing the order_type
	private String getRegReqdValue(String order_type) throws Exception {
  		Connection connection 		= null;
  		PreparedStatement pstmt 	= null;
  		ResultSet resultSet 		= null;
  		String regn_reqd_yn			= "N";
  		if(order_type.equals("^^")) order_type = "";
  		try
  		{
 			connection	= getConnection();
 			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_REG_SELECT") ) ;
  			pstmt.setString(1,checkForNull(order_type.trim(),""));
  			resultSet	= pstmt.executeQuery() ;
  			if(resultSet!=null) // Only One Record
 			{
 				while (resultSet.next() ) {
  					regn_reqd_yn = checkForNull(resultSet.getString( "regn_reqd_yn"), "N" );
 				}
 			}
 		}catch ( Exception e ){

  			e.printStackTrace() ;
  		} finally {
  			closeResultSet( resultSet ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(connection);
  		}
  		return regn_reqd_yn;
	} // end of the getRegReqdValue

   // Get the order_status
   private String getOrderStatus(String auth_reqd_yn, String consent_reqd_yn, String complete_on_order_yn,String regd_reqd_yn, String special_approved_yn,String authorized,String consented,String specialApproved,String consent_stage,String auto_report_yn, String appt_reqd_yn, String xh_install_yn)throws Exception {
	  
   		Connection connection 		= null;
   		PreparedStatement pstmt 	= null;
   		ResultSet resultSet 		= null;
   		String order_status			= "", order_status_code = "";
		if(authorized.equalsIgnoreCase("N"))
	   {
			authorized = "false";
	   }
	   else if(authorized.equalsIgnoreCase("Y"))
	   {
			authorized = "true";
	   }
   		authorized					= checkForNull(authorized,"false");
   	   //14699 Starts
   	   if("N".equals(specialApproved)) 
 	   {
   			specialApproved = "false";
 	   }
 	   else if("Y".equals(specialApproved))  
 	   {
 		  specialApproved = "true";
 	   }
   	   specialApproved   =checkForNull(specialApproved,"false");
   	   //14699 Ends
   		try 
   		{

   			// Put the logic to get the values(order_status_type)
			if(consent_stage.equals("N"))
				consent_stage="";

			if (consent_reqd_yn.equalsIgnoreCase("Y") && (consent_stage.equals("")||consent_stage.equals("A")))
				  order_status = "00";
			else if (auth_reqd_yn.equalsIgnoreCase("Y") && authorized.equalsIgnoreCase("false"))
				  order_status = "03";
			else if (special_approved_yn.equalsIgnoreCase("Y") && specialApproved.equalsIgnoreCase("false"))
				  order_status = "05";
			else if (consent_reqd_yn.equalsIgnoreCase("Y") && consent_stage.equals("R"))
				  order_status = "10";
			else if (complete_on_order_yn.equalsIgnoreCase("Y"))
			{
				if (auto_report_yn.equals("Y"))
					order_status = "85";
				else
					order_status = "60";
			}
			else if( regd_reqd_yn.equalsIgnoreCase("Y"))
			{
				if(checkForNull(appt_reqd_yn,"N").equals("Y") && checkForNull(xh_install_yn,"N").equals("Y"))
					order_status = "10";
				else
					order_status = "25";
			}
			else
				order_status = "10";

   			connection	= getConnection();
  			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_STATUS_SELECT") ) ;
   			pstmt.setString(1,checkForNull(order_status,""));
   			resultSet	= pstmt.executeQuery() ;
   			if(resultSet!=null) // Only One Record
  			{
   				while (resultSet.next() ) {
   					order_status_code = checkForNull(resultSet.getString( "order_status_code"), "" );
  				}
  			}
   		}catch ( Exception e ){

   			e.printStackTrace() ;
   		} finally {
   			closeResultSet( resultSet ) ;
   			closeStatement( pstmt ) ;
   			closeConnection(connection);
   		}

   		return order_status_code;
	} // end of the getOrderStatus

	private String getStatusHeader(String status)throws Exception {
   		Connection connection 		= null;
   		PreparedStatement pstmt 	= null;
   		ResultSet resultSet 		= null;
   		String order_status			= "";
   		try
   		{

   			// Put the logic to get the values(order_status_type)
			StringBuffer Order_Status_Query=new StringBuffer();

   			connection	= getConnection();		Order_Status_Query.append(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_HEADER_STATUS") ) ;
			Order_Status_Query.append(status);
			Order_Status_Query.append("))");
  			pstmt		= connection.prepareStatement(Order_Status_Query.toString()) ;

   			resultSet	= pstmt.executeQuery() ;
   			if(resultSet!=null) // Only One Record
  			{
   				while (resultSet.next() ) {
   					order_status = checkForNull(resultSet.getString( "order_status_code"), "" );
  				}
  			}
   		}catch ( Exception e ){

   			e.printStackTrace() ;
   		} finally {
   			closeResultSet( resultSet ) ;
   			closeStatement( pstmt ) ;
   			closeConnection(connection);
   		}

   		return order_status;
	} // end of the getOrderStatus
/*********************METHOD TO Reset the Class variable*************************/
 /*public void clear() {
	encounter_id				= null ;	patient_id					= null ;
	patient_class				= null ;	location_type				= null ;
	location_code				= null ; 	practitioner_id				= null ;
 	practitioner_name			= null ; 	practitioner_type			= null ;
 	order_category_yn			= null ; 	order_type_code_yn			= null ;
 	order_privilege_level		= null ;	pin_ident_by_category_yn	= null ;
	service_code				= null ;	order_category				= null ;
	order_type					= null ;	attend_practitioner_id		= null ;
	attend_practitioner_name   	= null ;	responsibility_id	 		= null ;
	called_from_ca  			= null ;	relationship_id  			= null ;

	frame_color	  				= null ;	sex			  				= null ;
	age			  				= null ;	dob			  				= null ;
	facility_name				= null ;	p_test_date_time_behind 	= null ;
	vb_status 					= null ;	catalog_desc_behind  		= null ;
	ordered_pract_behind 		= null ;	order_status_behind 		= null ;
	end_date_time_behind 		= null ;	va_status 					= null ;
	catalog_desc_ahead  		= null ;	ordered_pract_ahead 		= null ;
	order_status_ahead  		= null ;	end_date_time_ahead  		= null ;
	test_date_time_ahead		= null ;	validated_status			= null ;
	visit_adm_date				= null ;	order_id					= null ;
	discharge_date_time			= null ;
	ammend_called_from			= null ;	amend_order_type			= null ;
	episode_id					= null ;	episode_visit_num			= null ;
	team_id						= null ;	order_mode					= null;
	def_catalog_code			= null ;  	default_tab					= null ;
	refresh_yn					= null ;
	accession_type				= null ;	accession_number			= null ;

	request						= null ;	response					= null ;
	// To clear the String Buffer
	amend_clinical_comments		= null;
	total_count					= 0;		count_chk_records			= 0;
	amend_total_count			= 0;		care_set_count				= 0;
	hashValues.clear();
	tabData.clear();
	print_values.clear();		// Used for On Line Printing
	stored_print_values.clear(); // Used for On Line Printing
	print_specimen_values.clear(); // Used for On Line Printing
	copyOrders.clear();	// Copy Orders
	phDetails.clear();  // Used for PH OrderSet
	phDetails					= null;
	copyOrders					= null;
	hashValues					= null;
	tabData						= null;
	print_values				= null;
	stored_print_values			= null;
	print_specimen_values		= null;
	copy_order_details			= null;
	multi_patient_details		= null;

	orderEntryRecordBean.clearBean();
	super.clear() ;

 }//end of clear
 */
  // Remove this method after

  /* As a special case, this clear method is used for initializing the values,
     which actually should have been done in the initialize() method, (In this bean we
     have not used and in the clear method should have been used to nullify the objects)
     But taking as a exceptional case and not to affect the Pharmacy related Bean
     like (PrescriptionBean_1 & DrugSearchBean) for the storage of data,etc....

     Changes have been done after Verification and after informing the standards team
  */
  public void clear(){
   		encounter_id        		= "" ;		patient_id          		= "" ;
   		patient_class       		= "" ; 		location_type       		= "" ;
   		location_code       		= "" ; 		practitioner_id     		= "" ;
   		practitioner_name   		= "" ; 		practitioner_type    		= "" ;
   		order_category_yn    		= "" ; 		order_type_code_yn   		= "" ;
  		order_privilege_level		= "" ; 		pin_ident_by_category_yn 	= "" ;
  		service_code        		= "" ; 		order_category      		= "" ;
  		order_type          		= "" ; 		attend_practitioner_id   	= "" ;
  		attend_practitioner_name 	= "" ; 		responsibility_id       	= "" ;
  		called_from_ca       		= "" ; 		relationship_id      		= "" ;

		frame_color          		= "" ;		sex              			= "" ;
   		age              			= "" ; 		dob              			= "" ;
   		facility_name     	        = "" ;		visit_adm_date        		= "" ;
		discharge_date_time			= "" ;
   		order_id          			= "" ;		order_line_no 				= "";
   		ammend_called_from      	= "" ;		called_from_function		= "";
   		amend_order_type			= "" ;		sys_date			  		= "";
   		amend_clinical_comments  	= new StringBuffer();
  		// Used For Duplicate Check
  		validated_status      		= "" ;
  		//p_test_date_time_behind 	= "" ;		test_date_time_ahead		= "";
		//catalog_desc_behind     	= "" ;		catalog_desc_ahead			= "" ;
		//ordered_pract_behind		= "" ;		ordered_pract_ahead     	= "" ;
		//order_status_behind     	= "" ;		order_status_ahead			= "" ;
		//end_date_time_behind		= "" ;		end_date_time_ahead      	= "" ;
		vb_status       			= "" ;		va_status           		= "" ;
  		// Till Here
  		episode_id         			= "" ;		episode_visit_num			= "";
		team_id						= "" ;
		order_mode					= "" ;
		accession_type				= "" ;		accession_number			= "";
  		refresh_yn         			= "N"; //Used For Refreshing or coming out of the tabs to Existing order, after the record completion of the order
  		restrict_yn        			= "N"; //Used For Pharmacy Orders
  		def_catalog_code     		= "" ; //Used For Pharmacy Orders(Oncology Regimen)
  		default_tab        			= "" ; //Used For Pharmacy Orders(R -> For Prescription, O -> Oncology)

  		//Used For Insertion and Updation
  		total_count          		= 0 ;		count_chk_records			= 0;
  		amend_total_count    		= 0 ;		care_set_count				= 0;
  		hashValues       			= new HashMap();
// 		tabData          			= new HashMap();
		copyOrders					= new HashMap();  // used for Copy Orders
		phDetails					= new HashMap();  // Used for PH OrderSet

		copy_order_details			= new ArrayList();
		multi_patient_details		= new ArrayList();
		//  	print_values   	    		= new Hashtable(); // Used for On Line Printing
// 		stored_print_values 		= new Hashtable(); // Used for On Line Printing (consent orders)
//		print_specimen_values		= new Hashtable(); // Used for On Line Printing
		oa_bookappt_values			= new Hashtable(); // Used to be passed for OA Booking Appointment
  		//request         		 	= null;		//response       	  		= null;
  		//eOR.Common.OrderEntryRecordBean  orderEntryRecordBean  = null;
  		orderEntryRecordBean 		= new eOR.Common.OrderEntryRecordBean();
  		orderEntryBillBean			= new OrderEntryBillingQueryBean();
  		externalOrdersBean			= new ExternalOrdersBean();
//		orderEntryQueryBean			= new eOR.OrderEntryQueryBean();
		consentDetails				= new HashMap(); // Used for Multi Consent Orders
		druginteractionDtl = new HashMap<String, ArrayList<OrderDrugInteractionVO>>();//IN071260 
		druginteractionYN = new HashMap<String, String>();//IN071260
  		super.clear();
  }


   public void clearPrintingValues(){
		print_values   	    		= new Hashtable(); // Used for On Line Printing
		print_specimen_values		= new Hashtable(); // Used for On Line Printing
		print_specimen_labels		= new Hashtable(); //IN046592
		confirm_reqd_YN				= "N";//IN042962
		print_barcode_values		= new Hashtable(); //IN064614
		prn_lbl_values		= new Hashtable(); //IN065942
   }
 /*********************** Till Here *******************************/

/************************METHOD TO Update****************************/
 public HashMap modify(){
	/*HashMap map = new HashMap(); 	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ; return map;
	*/
	return null;
 }//end of modify
 /********************* Till Here *****************************/
 /*********************METHOD TO Delete*************************/
 public HashMap delete(){
	/*HashMap map = new HashMap(); 	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." ); return map;
	*/
	return null;
 }//end of delete
 /********************* Till Here *****************************/

 private void doCommon() throws Exception {
 }

 public void loadData() throws Exception {
 }

 	// To populate the Order Category, From the Addl. Search, same to populate the order_category from the tick sheets and this same function is used to
	// poulate the order_category from the Image Screen also
public ArrayList getOrderCategory(String called_from) throws Exception 
{
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
			ArrayList OrderCategory = new ArrayList() ;
			try{
					connection	= getConnection();
 					if(checkForNull(called_from,"").equalsIgnoreCase("ALL_ORDER")) {  // To Populate the OrderCategory from the Addnl. Search
					
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST") ) ;//IN031116
			pstmt = connection.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? ORDER BY short_desc") ;//IN031116
						pstmt.setString(1, language_id);

					} else if(checkForNull(called_from,"").equalsIgnoreCase("TICK_SHEETS")) {  // To Populate the OrderCategory from the Tick Sheets (to bring the NOn specific also)
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT") ) ;
						pstmt.setString(1, language_id);

					}  else {    // To Populate the Image Order Category from the Image Screen
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC3") ) ;
						pstmt.setString(1, language_id);
					}
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record	= null;
						while(resultSet.next())
						{
							record 	  = new String[2];
							record[0] = resultSet.getString( "order_category" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;
							OrderCategory.add(record) ;
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
				return OrderCategory;
	}	 // End of the getOrderCategory
	// To populate the Order Type, From the Addl. Search
	public ArrayList getOrderType(String order_category) throws Exception {
  			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			ArrayList OrderType = new ArrayList() ;
			try{
					connection	= getConnection();
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE") ) ;
					pstmt.setString(1, language_id);
					pstmt.setString(2,checkForNull( order_category,""));
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record = null;
						while(resultSet.next())
						{
							record 	  = new String[2];
							record[0] = resultSet.getString( "order_type_code" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;
							OrderType.add(record) ;
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
				return OrderType;
	}	 // End of the getOrderType
	// To get the pre_sel_order_type_yn, From the Addl. Search
	public String getPreOrderType(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String pre_sel_order_type_yn= "N";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRESEL_ORDER_TYPE") ) ;
				pstmt.setString(1, checkForNull( order_category,""));
				pstmt.setString(2, checkForNull( getPatientClass(),"")); //Pass the Patient class
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						pre_sel_order_type_yn = checkForNull( resultSet.getString( "preselect_order_type_code_yn" ), "N" );
					}
				}
				return pre_sel_order_type_yn; // Only one record per
			}catch ( Exception e )	{

					e.printStackTrace() ;
					return null;
			} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
			}
	}	 // End of the getPreOrderType

 	// To populate the Section
	public ArrayList getSectionPopulate(String order_category,String tick_sheet_id,String order_type_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList SectionValues = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SECTION") ) ;
				pstmt.setString(1, language_id);
				pstmt.setString(2,checkForNull(order_category.trim(),""));
				pstmt.setString(3,checkForNull(tick_sheet_id.trim(),""));
				pstmt.setString(4,checkForNull(order_type_code.trim(),""));

				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record = new String[2];
						record[0] = checkForNull(resultSet.getString( "section_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "section_desc" ),"")  ;
						SectionValues.add(record) ;
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
			return SectionValues;
	}	 // End of the getSectionPopulate

	// Get the values for painting the additional search order catalog
	public ArrayList getOrderCatalog(HashMap param) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String ph_install_yn		= "N";
		ArrayList OrderCatalog		= new ArrayList() ;
		String priv_applicability_yn ="";
		priv_applicability_yn = checkForNull((String)param.get("priv_applicability_yn"),"");
		String sql					= ""; // For Debugging
		try
		{
				connection	= getConnection();				sql=OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CATALOG_ORDER_TYPE_ALL_COUNT");
				if(checkForNull((String) param.get("restrict_by"),"").equalsIgnoreCase("N")) // If restrict_by has been checked
				{
					sql=sql.replace("##CATCODE##","");
				}
				else
				{
					ph_install_yn	= getModuleInstallYn("PH"); //Pass the module_id to found out whether the
					if(ph_install_yn.equalsIgnoreCase("Y"))
					{
						sql=sql.replace("##CATCODE##"," AND a.order_catalog_code IN (SELECT drug_code  code FROM ph_generic_name_for_service a,ph_drug b WHERE a.generic_id = b.generic_id AND a.eff_status ='E' AND service_code = ? UNION SELECT order_catalog_code  code FROM or_order_catalog_by_index WHERE service_code = ?) ");
					}
					else
					{
						sql=sql.replace("##CATCODE##"," AND a.order_catalog_code IN (SELECT order_catalog_code  code FROM or_order_catalog_by_index WHERE service_code = ?)  ");
					}
				}
				if(priv_applicability_yn.equalsIgnoreCase("Y"))
				{
					sql=sql.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
				}
				else
				{
					sql=sql.replace("##FILTERCAT##"," ");
				}
				pstmt		= connection.prepareStatement(sql);
					//if(checkForNull((String) param.get("restrict_by"),"").equalsIgnoreCase("N")) // If restrict_by has been checked
					//{
						pstmt.setString(1,  getPractitionerType());
						pstmt.setString(2,  getPractitionerType());
						pstmt.setString(3,  checkForNull((String) param.get("order_category"),""));
						pstmt.setString(4,  checkForNull((String) param.get("order_catalog_nature"),""));// because to get the count for all,atomic  ,profile etc
						pstmt.setString(5,  checkForNull((String) param.get("criteria"),""));
						pstmt.setString(6,  checkForNull((String) param.get("orderable_text"),""));
						pstmt.setString(7,  checkForNull((String) param.get("orderable_text"),""));
						pstmt.setString(8,  checkForNull((String) param.get("orderable_text"),""));
						pstmt.setString(9,  checkForNull((String) param.get("criteria"),""));
						pstmt.setString(10,  checkForNull((String) param.get("orderable_text"),""));
						pstmt.setString(11,  checkForNull((String) param.get("orderable_text"),""));
						pstmt.setString(12,  checkForNull((String) param.get("orderable_text"),""));
						pstmt.setString(13,  getPatientClass());
						pstmt.setString(14, getPatientId());
						pstmt.setString(15, checkForNull(getSex(),""));
						pstmt.setString(16, checkForNull(getDob(),"")) ;
						//pstmt.setString(17, getPatientClass());
						pstmt.setString(17, getLoginFacilityId());
						pstmt.setString(18, getEncounterId());
						pstmt.setString(19, getPatientClass());
						pstmt.setString(20, checkForNull(getVisitAdmDate(),"")) ;
						pstmt.setString(21, checkForNull(getDischargeDateTime(),""));
						pstmt.setString(22,  checkForNull((String) param.get("order_category"),""));
						pstmt.setString(23, getLoginFacilityId());
						pstmt.setString(24, getServiceCode());
						pstmt.setString(25, getPractitionerId());
						pstmt.setString(26, getLocationType());
						pstmt.setString(27, getLocationCode());
						pstmt.setString(28, getLoginFacilityId());
						pstmt.setString(29, checkForNull((String) param.get("order_type"),"").trim());
						pstmt.setString(30,checkForNull((String)param.get("activity_type"),"").trim());
					//}
				if(checkForNull((String) param.get("restrict_by"),"").equalsIgnoreCase("Y")) // If restrict_by is unchecked
				{
					pstmt.setString(31, getServiceCode());
					ph_install_yn	= getModuleInstallYn("PH"); //Pass the module_id to found out whether the
					if(ph_install_yn.equalsIgnoreCase("Y"))
					{
							pstmt.setString(32, getServiceCode());
					}
					if(priv_applicability_yn.equalsIgnoreCase("Y"))
					{
						pstmt.setString(33,getPractitionerId());		//P_PRACTITIONER_ID
						pstmt.setString(34,getResponsibilityId());		//P_RESP_ID
						pstmt.setString(35,getPrivilegeApplicability());		//P_PRIV_APPL_YN
					}
				}
				else if (priv_applicability_yn.equalsIgnoreCase("Y"))
				{
					pstmt.setString(31,getPractitionerId());		//P_PRACTITIONER_ID
					pstmt.setString(32,getResponsibilityId());		//P_RESP_ID
					pstmt.setString(33,getPrivilegeApplicability());		//P_PRIV_APPL_YN
				}

				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = resultSet.getString( "count" )  ;
						record[1] = resultSet.getString( "order_catalog_nature" )  ;
						OrderCatalog.add(record) ;
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
	}	 // End of the getOrderCatalog

	// To populate the TickSheet List Box in the Tick Sheet
	public ArrayList getTickSheet(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList TickSheet = new ArrayList() ;
		String sql ="SELECT   tick_sheet_id,   tick_sheet_desc tick_sheet_desc,         order_category, seq_no    FROM or_tick_sheet_lang_vw a   WHERE order_category = NVL (?, order_category)     and language_id=?     AND eff_status = 'E'	 AND (indexed_yn = 'N'	 or (   indexed_yn = 'Y'  and exists (select 1 from or_tick_sheet_by_index		 where order_category=a.order_category	and tick_sheet_id=a.tick_sheet_id	and		(  (index_type='P' and practitioner_id = ?)  or 	(index_type='S' and service_code = ?) or  (index_type='F' and facility_id = ?  AND DECODE (source_type, 'A', ?, source_type) = ? AND DECODE (source_code, '*ALL', ?, source_code) = ?	  )  )		)   ) ) ##FPP_APPLICABLEYN## ORDER BY seq_no";//IN072524
		try{
				connection	= getConnection();
				//IN072524 Starts
				//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_TICK_SHEET_POPULATE"));
				if("Y".equals(fpp_patient_yn)){
					sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
					pstmt				= connection.prepareStatement(sql);
				}
				else{
					sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN = 'N') ");
					pstmt				= connection.prepareStatement(sql); 
				}//IN072524 Ends
				pstmt.setString(1, checkForNull(order_category,""));
				pstmt.setString(2, language_id);
				pstmt.setString(3, getPractitionerId());
				pstmt.setString(4, getServiceCode());
				pstmt.setString(5, getLoginFacilityId());
				pstmt.setString(6, getLocationType());
				pstmt.setString(7, getLocationType());
				pstmt.setString(8, getLocationCode());
				pstmt.setString(9, getLocationCode());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record =  null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = resultSet.getString( "tick_sheet_id" )  ;
						record[1] = resultSet.getString( "tick_sheet_desc" )  ;

						TickSheet.add(record) ;
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
			return TickSheet;
	}	 // End of the getTickSheet

// Get the Pract Type , only one record  // For overwriting the pract type when it comes from modal
	public String getPractType(String pract_id ) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String pract_type			= "";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRACT_TYPE") ) ;
				pstmt.setString(1,checkForNull(pract_id,""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )               // Only One Record
				{
					while(resultSet.next())
					{
						pract_type = checkForNull(resultSet.getString( "pract_type" ),"") ;
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
			return pract_type;
	}	 // End of the getPractType

	// To populate the TickSheet Items in the Tick Sheet frame
	public ArrayList getTickSheetItems(String order_category,String tick_sheet_id,String section_code,String order_type, String activity_type,String priv_applicability_yn) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql = "";
		int reccount = 0;

		ArrayList TickSheetItems = new ArrayList() ;
		try{
				connection	= getConnection();
				//sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_TICK_SHEET_ITEM");//IN042045
				sql = "SELECT  a.order_catalog_code order_catalog_code, OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(a.ORDER_CATALOG_CODE,or_get_synonym_type (?, a.order_catalog_code),?,'1') catalog_synonym, b.order_category order_category, a.tick_sheet_id, a.section_code, b.order_type_code order_type_code,  b.order_catalog_nature order_catalog_nature, or_performing_facility_id(?,b.order_category, b.order_type_code,b.order_catalog_code,?,?) performing_facility, b.prompt_alert_yn  prompt_alert_yn, b.prompt_alert_msg  prompt_alert_msg,b.security_level security_level,b.consent_reqd_yn consent_reqd_yn,b.consent_form_id  consent_form_id,b.qty_reqd_yn qty_reqd_yn,b.qty_uom qty_uom,b.split_dose_yn split_dose_yn,b.taper_dose_yn taper_dose_yn,b.freq_applicable_yn freq_applicable_yn,b.soft_stop_yn soft_stop_yn,b.cont_order_yn cont_order_yn,b.refill_cont_order_yn refill_cont_order_yn,b.continuous_freq_order continuous_freq_order,b.comment_format_id comment_format_id,b.chk_for_dupl_yn chk_for_dupl_yn,b.ord_auth_level ord_auth_level,b.ord_cosign_level ord_cosign_level,b.ord_spl_appr_level ord_spl_appr_level,b.appt_reqd_yn appt_reqd_yn,b.appt_time appt_time,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,b.dept_only_yn dept_only_yn,b.complete_on_order_yn complete_on_order_yn,b.bill_yn bill_yn,b.result_auth_reqd_yn result_auth_reqd_yn,c.ord_auth_reqd_yn ord_auth_reqd_yn,c.ord_cosign_reqd_yn ord_cosign_reqd_yn,c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,b.result_auth_reqd_yn result_auth_reqd_yn,b.chart_result_type chart_result_type,b.discr_msr_panel_id discr_msr_panel_id,b.contr_mod_id contr_mod_id, b.contr_msr_panel_id contr_msr_panel_id, ##FILTERPRIV## b.explanatory_text  FROM (select order_catalog_code,tick_sheet_seq_num,section_code,tick_sheet_id from or_tick_sheet_item where tick_sheet_id = ? and section_code = ? ) a, or_order_catalog b, or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d WHERE   a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code and c.patient_class = NVL ((SELECT patient_class FROM or_order_catalog_by_ptcl WHERE order_catalog_code = a.order_catalog_code AND patient_class = ? AND review_applicablity = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND B.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,'','','','','','',a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category)) AND b.eff_Status ='E'   and nvl(activity_type,'!') = nvl(?,nvl(activity_type,'!')) AND b.order_type_code = NVL (?, b.order_type_code)  ##FILTERCAT## ORDER BY b.order_catalog_nature DESC, a.tick_sheet_seq_num";//IN042045
				if(priv_applicability_yn.equalsIgnoreCase("Y"))
				{
					sql = sql.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
					sql = sql.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
				}
				else if(priv_applicability_yn.equalsIgnoreCase("N"))
				{
					sql = sql.replace("##FILTERCAT##","");
					sql = sql.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");
				}
				else
				{
					sql = sql.replace("##FILTERCAT##","");
					sql = sql.replace("##FILTERPRIV##"," 'Y' priv_yn, ");
				}

				pstmt		= connection.prepareStatement(sql); //OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_TICK_SHEET_ITEM"));
				pstmt.setString(++reccount,   getPractitionerType());
				pstmt.setString(++reccount,   language_id);
				pstmt.setString(++reccount,  getLoginFacilityId());
				pstmt.setString(++reccount,  getLocationType());
				pstmt.setString(++reccount,  getLocationCode());
				/*
				pstmt.setString(6, getLoginFacilityId());
				pstmt.setString(7, getLoginById());
				pstmt.setString(8, getResponsibilityId());
				/*Added by Uma on 8/22/2009 for PMG20089 -CRF 641*/
				if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N")))
				{
					pstmt.setString(++reccount , getPractitionerId());		//P_PRACTITIONER_ID
					pstmt.setString(++reccount , getResponsibilityId());		//P_RESP_ID
					pstmt.setString(++reccount , getAuthorisationOrOrderingYn("ORD"));		//P_PRIV_APPL_YN
				}
				/* End Here*/
				pstmt.setString(++reccount, checkForNull(tick_sheet_id.trim(),""));
				pstmt.setString(++reccount, checkForNull(section_code,""));
				//if(checkForNull(order_category.trim(),"").equals("*A"))
					//pstmt.setString(11, null);
				//else
					//pstmt.setString(11, checkForNull(order_category.trim(),""));
				/*Commented by Uma for performance tuning
				pstmt.setString(++reccount, language_id);
				pstmt.setString(++reccount, getPatientClass());
				pstmt.setString(++reccount, getPatientId());
				pstmt.setString(++reccount, checkForNull(getSex(),""));
				pstmt.setString(++reccount, checkForNull(getDob(),"")) ;
				pstmt.setString(++reccount, getPatientClass());Ends Here performance tuning*/
				pstmt.setString(++reccount, getPatientClass());
				pstmt.setString(++reccount, getPatientClass());
				pstmt.setString(++reccount, checkForNull(getSex(),""));
				pstmt.setString(++reccount, checkForNull(getDob(),"")) ;
				pstmt.setString(++reccount, getLoginFacilityId());
				pstmt.setString(++reccount, checkForNull(getEncounterId(),""));
				pstmt.setString(++reccount, getPatientClass());
				pstmt.setString(++reccount, getVisitAdmDate()) ;
				pstmt.setString(++reccount, checkForNull(getDischargeDateTime(),"")) ;
				pstmt.setString(++reccount,   getPractitionerType());//IN042045
				if(checkForNull(order_category.trim(),"").equals("*A"))
					pstmt.setString(++reccount, null);
				else
					pstmt.setString(++reccount, checkForNull(order_category.trim(),""));
				//pstmt.setString(++reccount, getLoginFacilityId());Commented by Uma on 4/10/2010 for performance tuning
				pstmt.setString(++reccount, checkForNull(activity_type,""));
				pstmt.setString(++reccount, checkForNull(order_type,""));
				/*Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
				if(priv_applicability_yn.equalsIgnoreCase("Y"))
				{
					pstmt.setString(++reccount , getPractitionerId());		//P_PRACTITIONER_ID
					pstmt.setString(++reccount , getResponsibilityId());		//P_RESP_ID
					pstmt.setString(++reccount , getPrivilegeApplicability());		//P_PRIV_APPL_YN
				}
				/*End here*/
			
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[13];
						record[0] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "catalog_synonym" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_catalog_nature" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "discr_msr_panel_id" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "prompt_alert_yn" ),"N")  ;
						record[5] = checkForNull(resultSet.getString( "prompt_alert_msg" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "contr_msr_panel_id" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "ord_spl_appr_reqd_yn" ),"N")  ;
						/*Added by Uma on 8/22/2009 for PMG20089 -CRF 641
						record[11] = checkForNull(resultSet.getString( "enable_yn" ),"")  ;*/
						record[11] = checkForNull(resultSet.getString( "priv_yn" ),"")  ;
						/*End Here*/
						record[12] = checkForNull(resultSet.getString( "explanatory_text" ),"")  ;
						TickSheetItems.add(record) ;
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
			return TickSheetItems;
	}	 // End of the getTickSheetItems

  	// Population of the order catalogs in the FrequentOrders Tab based upon the search_by
	// if it is from the practitioner_tab, it search_by will be practitioner otherwise patient
	// in RecentAccessed By Practitioner
    public ArrayList getFrequentOrdersItems(String search_by, String patient_id, String no_of_occurances,String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//int reccount = 0;

		ArrayList FrequentItems		= new ArrayList() ;
		try{
				connection	= getConnection();

				if(search_by.equals("practitioner")) {
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FREQUENT_ORDERS_BY_PRACITIONER"));
					pstmt.setString(25,  getPractitionerId());		//PRACITIONER
					pstmt.setString(27,  patient_id);		//patient_id
				}else  {
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FREQUENT_ORDERS_BY_PATIENT"));
					pstmt.setString(25,  patient_id);		//patient_id
				}
				pstmt.setString(1, language_id);
				pstmt.setString(2,   getLoginFacilityId()); // Facility_id
				pstmt.setString(3,   getLocationType()); // source_type
				pstmt.setString(4,   getLocationCode()); // source_code(or_performing_facility_id)
                pstmt.setString(5, language_id);
				pstmt.setString(6,   getLoginFacilityId());
				pstmt.setString(7,   getPatientId());
				pstmt.setString(8,   getEncounterId());
				pstmt.setString(9,   getPatientClass());	 //(or_bl_catalog_dtl)
				pstmt.setString(10,   getEpisodeID());		//(or_bl_catalog_dtl)
				pstmt.setString(11,   getEpisodeVisitNum());  //(or_bl_catalog_dtl)
				/*Modified by Uma on 8/24/2009 for PMG20089 CRF-641
				pstmt.setString(12,  getLoginFacilityId());   // FACILITY_ID
				pstmt.setString(13,  getLoginById());		// login_by_id
				pstmt.setString(14,  getResponsibilityId());  // P_RESP_ID   (OR_PRIVILEGE_BY_ORDER)
				Added by Uma on 8/24/2009 for PMG20089 CRF-641
				*/
				pstmt.setString(12 , getPractitionerId());		//P_PRACTITIONER_ID
				pstmt.setString(13 , getResponsibilityId());		//P_RESP_ID
				pstmt.setString(14 , getAuthorisationOrOrderingYn("ORD"));		//P_PRIV_APPL_YN
				/*End Here*/
				pstmt.setString(15,  getLoginFacilityId());//Added by Uma on 4/10/2010 for performance tuning
				pstmt.setString(16, language_id);
				pstmt.setString(17,  getPractitionerType());
				/*Commented by Uma on 4/10/2010 for performance tuning
				pstmt.setString(17,  getPatientClass());
				pstmt.setString(18,  getPatientId());
				pstmt.setString(19,  checkForNull(getSex(),""));
				pstmt.setString(20,  checkForNull(getDob(),"")) ;Ends Here by Uma for performance tuning*/
				pstmt.setString(18,  getPatientClass());
 				pstmt.setString(19,  getLoginFacilityId());
				pstmt.setString(20,  getEncounterId());
				pstmt.setString(21,  getPatientClass());
				pstmt.setString(22,  checkForNull(getVisitAdmDate(),"")) ;
				pstmt.setString(23,  checkForNull(getDischargeDateTime(),"")) ;
				pstmt.setString(24,  order_category) ;
 				//pstmt.setString(28,  getLoginFacilityId());Commented by Uma on 4/10/2010 for performance tuning
				
				// 25th column had been set already when preparing the statement
				pstmt.setString(26,  no_of_occurances);	//no of occurances
				// 27th column had been set already when preparing the statement (For the PRACTITIONER)

				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[16];
						record[0] = checkForNull(resultSet.getString( "Group_Name" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "catalog_synonym" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_catalog_nature" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "discr_msr_panel_id" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "prompt_alert_yn" ),"N")  ;
						record[6] = checkForNull(resultSet.getString( "prompt_alert_msg" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "contr_msr_panel_id" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "ord_spl_appr_reqd_yn" ),"N")  ;
						record[12] = checkForNull(resultSet.getString( "bill_message" ),"")  ;
						//record[13] = checkForNull(resultSet.getString( "enable_yn" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "priv_yn" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "explanatory_text" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "or_operational_module_yn" ),"")  ;

						FrequentItems.add(record) ;
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
			return FrequentItems;
	}	 // End of the getFrequentOrdersPractitionerItems

// Logic to derive the Frame Count and Painting Dynamically(Addnl Search Tab )
	public ArrayList getFrameCount(int group_frame_count,int profile_frame_count,int atomic_frame_count) throws Exception {
		ArrayList FrameList = new ArrayList() ;
		try{
				String frame_names 				= "";
				String group_frame 				= "";
				String profile_frame 			= "";
				String atomic_frame				= "";
				int group_display_size			= 0, profile_display_size = 0;
				int atomic_display_size			= 0;
				String frame_size				= "0%,0%,0%";

				if( group_frame_count  > 0 && atomic_frame_count > 0 && profile_frame_count > 0)
				{
					frame_names					= "All";
					if(group_frame_count < 8)		{ group_frame = "22%";group_display_size = OrRepository.DISPLAY_MIN_RECORDS; }
					else	 						{ group_frame = "33%";group_display_size = OrRepository.DISPLAY_EQ_RECORDS; }
					if(	profile_frame_count < 8)   { profile_frame = "22%";profile_display_size = OrRepository.DISPLAY_MIN_RECORDS; }
					else    					   { profile_frame = "33%";profile_display_size = OrRepository.DISPLAY_EQ_RECORDS; }
					if(group_frame_count < 8 && profile_frame_count < 8 )
					{
						atomic_frame 			= "56%";
						atomic_display_size 	= OrRepository.DISPLAY_EQ_RECORDS;
					}
					else if((group_frame_count > 8 && profile_frame_count < 8) || (group_frame_count < 8 && profile_frame_count > 8))
					{
					  	atomic_frame 			= "45%";	//frame_size			= "33%,33%,34%";
					  	atomic_display_size 	= OrRepository.DISPLAY_EQ_RECORDS;
					}
					else
					{
						atomic_frame 			= "33%";
						atomic_display_size 	= OrRepository.DISPLAY_EQ_RECORDS;
					}

					frame_size					= ""+group_frame+","+profile_frame+","+atomic_frame+"";
				}
				else if( group_frame_count > 0 && atomic_frame_count > 0 && profile_frame_count == 0)
				{
					frame_names				= "Group_Atomic";
					if(group_frame_count < 8 && atomic_frame_count < 8 || group_frame_count < 8 && atomic_frame_count > 8)
					{
						group_frame 		= "22%";group_display_size 	= OrRepository.DISPLAY_MIN_RECORDS;
						atomic_frame 		= "78%";atomic_display_size = OrRepository.DISPLAY_RECORDS;
					}
					else if(group_frame_count > 8 && atomic_frame_count < 8)
					{
						group_frame 		= "78%";group_display_size 	= OrRepository.DISPLAY_RECORDS;
						atomic_frame 		= "22%";atomic_display_size = OrRepository.DISPLAY_MIN_RECORDS;
					}
					else
					{
						group_frame 		= "50%";group_display_size = OrRepository.DISPLAY_EQ_RECORDS;
						atomic_frame 		= "50%";atomic_display_size = OrRepository.DISPLAY_EQ_RECORDS;
					}
					frame_size				= ""+group_frame+",0%,"+atomic_frame+"";
				}
				else if( group_frame_count > 0 && atomic_frame_count == 0 && profile_frame_count > 0)
				{
					frame_names				= "Group_Profile";
					if(group_frame_count < 8 && profile_frame_count < 8 || group_frame_count < 8 && profile_frame_count > 8)
					{
						group_frame 		= "22%";group_display_size 	 = OrRepository.DISPLAY_MIN_RECORDS;
						profile_frame 		= "78%";profile_display_size = OrRepository.DISPLAY_RECORDS;
					}
					else if(group_frame_count > 8 && profile_frame_count < 8)
					{
						group_frame 		= "78%";group_display_size = OrRepository.DISPLAY_RECORDS;
						profile_frame 		= "22%";profile_display_size = OrRepository.DISPLAY_MIN_RECORDS;
					}
					else
					{
						group_frame 		= "50%";group_display_size = OrRepository.DISPLAY_EQ_RECORDS;
						profile_frame 		= "50%";profile_display_size = OrRepository.DISPLAY_EQ_RECORDS;
					}
					frame_size				= ""+group_frame+","+profile_frame+",0%";
					//frame_size			= "50%,0%,50%";
				}
				else if( group_frame_count == 0 && atomic_frame_count > 0 && profile_frame_count > 0)
				{
					frame_names				= "Atomic_Profile";
					if(atomic_frame_count < 8 && profile_frame_count < 8 || profile_frame_count < 8 && atomic_frame_count > 8)
					{
						profile_frame 		= "22%";
						atomic_frame 		= "78%";profile_display_size = OrRepository.DISPLAY_MIN_RECORDS;
						atomic_display_size = OrRepository.DISPLAY_RECORDS;
					}
					else if(profile_frame_count > 8 && atomic_frame_count < 8)
					{
						profile_frame 		= "78%";
						atomic_frame 		= "22%";profile_display_size = OrRepository.DISPLAY_RECORDS;
						atomic_display_size = OrRepository.DISPLAY_MIN_RECORDS;
					}
					else
					{
						profile_frame 		= "50%";profile_display_size = OrRepository.DISPLAY_EQ_RECORDS;
						atomic_frame 		= "50%";atomic_display_size = OrRepository.DISPLAY_EQ_RECORDS;
					}
					frame_size				= "0%,"+profile_frame+","+atomic_frame+"";
					//frame_size			= "0%,50%,50%";
				}
				else if( group_frame_count > 0 && atomic_frame_count == 0 && profile_frame_count == 0)
				{
					frame_names				= "Group";
					frame_size				= "100%,0%,0%";
					group_display_size		= OrRepository.DISPLAY_MAX_RECORDS;
				}
				else if( group_frame_count == 0 && atomic_frame_count > 0 && profile_frame_count == 0)
				{
					frame_names				= "Atomic";
					frame_size				= "0%,0%,100%";
					atomic_display_size		= OrRepository.DISPLAY_MAX_RECORDS;
				}
				else if( group_frame_count == 0 && atomic_frame_count == 0 && profile_frame_count > 0)
				{
					frame_names				= "Profile";
					frame_size				= "0%,100%,0%";
					profile_display_size	= OrRepository.DISPLAY_MAX_RECORDS;
				}
				String[] record = new String[8];
					record[0] = frame_names;  // Name of the Frames to be used for global variable in JS
					record[1] = frame_size ;  // Size of the Frame;
					record[2] = group_frame;  // Size of the Group Frame
					record[3] = profile_frame;// Size of the Profile Frame
					record[4] = atomic_frame; // Size of the Atomic Frame
					record[5] = String.valueOf(group_display_size); // Size for the Display Record Frame
					record[6] = String.valueOf(profile_display_size);
					record[7] = String.valueOf(atomic_display_size);
					FrameList.add(record) ;

			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}
			return FrameList;
	}	 // End of the getFrameCounts

	// Get the Order Categories When the HashMap is passed, it is splitted and get the Order Categories
	public HashMap getOrderCategories(HashMap previousValues) throws Exception {
		HashMap hmOrderCategory		= new HashMap();
		try{
			if(previousValues!=null)		// Get the Previous Values from the Bean
			{
				java.util.Set setValues 		 = previousValues.keySet();
				java.util.Iterator iterator 	 = setValues.iterator();
				String entryValue 				 = "";
				String keyItems[]  				 = null;
				for(int i=0;i<previousValues.size();i++)
				{
					entryValue 	= ((String)iterator.next()) ;
					keyItems  	= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
					if(keyItems[0]!=null && !keyItems[0].equals("ck"))     // If it is a Hidden Field
					{
						if(keyItems[0]!=null && keyItems[0].equals("h1"))	// For Order Category
						{
							if( !( checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equals((String)hmOrderCategory.get((String)previousValues.get("h1"+keyItems[1])))) )
							{
								hmOrderCategory.put( checkForNull((String)previousValues.get("h1"+keyItems[1]),"") ,checkForNull((String)previousValues.get("h1"+keyItems[1]),"") );
							}
						}
					}
				} // End of for
   			}	// End of if
   			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}
			return hmOrderCategory;
	}	 // End of the getOrderCategories


	// Building the String to be executed for the in condition for order_type_code || order_catalog_code in Place Order
	public String  getOrderTypeCatalog(HashMap previousValues) throws Exception {
		String str 				= "";
		StringBuffer sb 		= new StringBuffer();
		ArrayList arrCheckBoxVal= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
		//TreeMap   previousValues	= new TreeMap(); Convert into the Tree Map
		//previousValues.putAll(previousValues_param);
		// Till here
		try{
			if(previousValues!=null && arrCheckBoxVal!=null)		// Get the Previous Values from the Bean
			{
				//java.util.Set setValues 		 = previousValues.keySet();
				//java.util.Iterator iterator 	 = setValues.iterator();
				String entryValue 				 = "";
				String keyItems[]				 = null;

				

				for(int i=0;i<arrCheckBoxVal.size();i++)
				{
				
					// For the ArrayList, the size will be same
					if(arrCheckBoxVal!=null)
					{
						entryValue	= (String)arrCheckBoxVal.get(i);
					}
					//entryValue 					= ((String)iterator.next()) ;
					keyItems			= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
				
					if(keyItems[0]!=null && keyItems[0].equals("ck"))     // If it is a Check Box
					{
						sb.append("'"+keyItems[1]+ "'||'"+checkForNull((String)previousValues.get("h2"+keyItems[1]),"") +"','"+ (i+1) +"'," );
					}
				}
				str = sb.toString() ;
				if(str.length() > 0)
					str = str.substring(0, str.length()-1);

			
			} // End of if previousValues
		}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
		}
		sb.setLength(0);  // Clearing the string buffer
		return str;
	}	 // End of the getOrderTypeCatalog

	// Building the String to be executed for the in condition for the order_type_code
	// when getting the format_id in the Header Level(Place Order)
	// Called from the OrderEntryPlaceOrderHeader.jsp
	// Building the String to be executed for the in condition for order_type_code || order_catalog_code in Place Order
	public String getOrderTypes(HashMap previousValues) throws Exception 
	{
		String str 				= "";
		StringBuffer sb 		= new StringBuffer();
		ArrayList arrCheckBoxVal= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
		try
		{
			if(previousValues!=null && arrCheckBoxVal!=null)// Get the Previous Values from the Bean
			{
				String entryValue 				 = "";
				String keyItems[]				 = null;
				for(int i=0;i<arrCheckBoxVal.size();i++)
				{
					// For the ArrayList, the size will be same
					if(arrCheckBoxVal!=null)
					{
						entryValue	= (String)arrCheckBoxVal.get(i);
					}
					keyItems		= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
					if(keyItems[0]!=null && keyItems[0].equals("ck"))     // If it is a Check Box
					{
						sb.append("'"+ checkForNull((String)previousValues.get("h2"+keyItems[1]),"") +"',");
					}
				}
				str = sb.toString() ;
				if(str.length() > 0)
				str = str.substring(0, str.length()-1);
			} // End of if previousValues
		}
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		sb.setLength(0);  // Clearing the string buffer
		return str;
	}	 

	//Getting the ordertypes for the Careset to be executed for Order Format
	public String getCareSetOrderTypes (String order_set_code) throws Exception {
 		Connection connection 		= null;
 		PreparedStatement pstmt 	= null;
 		ResultSet resultSet 		= null;
 		try
 		{
			connection		= getConnection();
 			pstmt			= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_SET_GROUP_ORDER_TYPE_SELECT") ) ;
			pstmt.setString(1, language_id);
 			pstmt.setString(2, order_set_code);
 			resultSet		= pstmt.executeQuery() ;
 			StringBuffer sb	= new StringBuffer();
 			if(resultSet!=null) // Only One Record
			{
 				while (resultSet.next() ) {
 					sb.append("'"+checkForNull( resultSet.getString( "order_type_code" ), "" ) +"',");
				}
			}
			String str =   sb.toString() ;
			sb.setLength(0);  // Clearing the string buffer
			if(str.length() > 0)
			  return str.substring(0, str.length()-1);
			else
			  return null;

 		}catch ( Exception e ){

 			e.printStackTrace() ;
 			return null;
 		} finally {
 			closeResultSet( resultSet ) ;
 			closeStatement( pstmt ) ;
 			closeConnection(connection);
 		}
	} // end of the getCareSetOrderTypes

	// Building the String to be executed for the in condition for order_catalog_code in Place Order//IN042045 pract_type
	//public String  getOrderCatalogCode(HashMap previousValues,String order_category) throws Exception 
	public String  getOrderCatalogCode(HashMap previousValues,String order_category,String pract_type) throws Exception 
	{
		String str 					= "";
		StringBuffer sb 			= new StringBuffer();
		ArrayList arrCheckBoxVal	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
		/*Added by Uma on 2/22/2010 for IN019522*/
		ArrayList careset		= new ArrayList();
		/*Ends Here*/
		try{
				// To give a different tab when it is PH , query to get the order_catalog_nature and if it "S" -- order set get the order_catalog_code for the order_set
				if(arrCheckBoxVal!=null && previousValues!=null  && order_category.equalsIgnoreCase("PH") )
				{
 					// Call a method to get the catalog code , it will return string buffer
					//sb				= getPharmacyCatalogCodes(arrCheckBoxVal,previousValues,order_category);
					sb				= getPharmacyCatalogCodes(arrCheckBoxVal,previousValues,order_category,pract_type);//IN042045
					str 			=  sb.toString() ;
					if(str.length() > 0)
						str 		= str.substring(0, str.length()-1);
				} // End of if order_category "PH"
				else if(previousValues!=null && arrCheckBoxVal!=null && !order_category.equalsIgnoreCase("PH") )		// Get the Previous Values from the Bean
				{

					String entryValue 				 = "";
					String keyItems[]				 = null;
					for(int i=0;i<arrCheckBoxVal.size();i++)
					{	// For the ArrayList, the size will be same
						if(arrCheckBoxVal!=null)
						{
							entryValue	= (String)arrCheckBoxVal.get(i);
						}  //entryValue = ((String)iterator.next()) ;
						keyItems		= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
						if(keyItems[0]!=null && keyItems[0].equals("ck"))     // If it is a Check Box
						{
							//if(order_category.equalsIgnoreCase("PH") || order_category.equalsIgnoreCase("CS"))
							if(order_category.equalsIgnoreCase("CS"))
							{	 // Building the String to be executed for the in condition for order_catalog_code in Place Order for Pharmacy (Dispensing Order)
								//Commented by Jyothi to fix IN020585 on 09/04/2010
							 	//if((checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equalsIgnoreCase("PH")) || (checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equalsIgnoreCase("CS")) )
							 	if((checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equalsIgnoreCase("CS")) )
								{
									/*Added by Uma on 2/22/2010 for IN019522*/
									if(!careset.contains(keyItems[1]))
									{
										careset.add(keyItems[1]);
										sb.append("" +keyItems[1]+ ",");      //Just give the code, no need to built as string
									}
									/*Ends Here for IN019522*/
								}
							}
							else
							{
								//Commented by Jyothi to fix IN020585 on 09/04/2010
								//if(!(checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equalsIgnoreCase("PH")) || (checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equalsIgnoreCase("CS")))
								if(!(checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equalsIgnoreCase("CS")))
								{
									sb.append("'" +keyItems[1]+ "',");
								}
							}
						}
				  	}
					str =  sb.toString() ;
					if(str.length() > 0)
						str = str.substring(0, str.length()-1);
				} // End of if previous_values && arrCheckBoxVal
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			}
			sb.setLength(0);  // Clearing the string buffer
			return str;
	}	 // End of the getOrderCatalogCode


	// To get the Pharmacy related Catalog Codes
	//private StringBuffer getPharmacyCatalogCodes(ArrayList arrCheckBoxVal, HashMap previousValues,String order_category)//IN042045
	private StringBuffer getPharmacyCatalogCodes(ArrayList arrCheckBoxVal, HashMap previousValues,String order_category,String pract_type) throws Exception {
		String entryValue 			= "";
		String order_catalog_nature	= "";
		String catalog_code			= "", order_set_code	= "";
		String regimen_yn			= "N", ph_install_yn	= "N";
		int count					= 0;
		StringBuffer sb 			= new StringBuffer();
		String keyItems[] 			= null;
		String sql 					= null;
		Connection connection 		= null;
		PreparedStatement pstmt		= null;
		ResultSet resultSet 		= null;
		String iv_prep_yn			= "";
		default_tab					= "R&iv_prep_default=";
		try{
			connection	= getConnection();
			for(int i=0;i<arrCheckBoxVal.size();i++)
			{
				regimen_yn			= "N"; catalog_code = "";
				entryValue			= (String)arrCheckBoxVal.get(i); // Only one catalog code
				keyItems 			= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
				if(keyItems[0]!=null && keyItems[0].equals("ck"))     // If it is a Check Box
				{
					if(previousValues!=null)
					{
						if(checkForNull((String)previousValues.get("h1"+keyItems[1]),"").equalsIgnoreCase("PH"))
							catalog_code = checkForNull(keyItems[1],"");      //Get the order_catalog_code
					}
				}
				order_set_code = catalog_code; // keepthe order_set_id to be send as an parameter
				if(!catalog_code.equals(""))
				{
					sql 		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_SET_CATALOG_NATURE");
					pstmt		= connection.prepareStatement(sql);
					pstmt.setString(1, order_category);
					pstmt.setString(2, catalog_code);
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						while(resultSet.next())  // Only one record
						{
							order_catalog_nature = checkForNull(resultSet.getString( "order_catalog_nature" ),"")  ;
							iv_prep_yn			 = checkForNull(resultSet.getString( "iv_prep_yn" ),"")  ;
						}
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					if(order_catalog_nature.equalsIgnoreCase("S"))
					{
						ph_install_yn	= getModuleInstallYn("PH"); //Pass the module_id to found out whether the module has been installed or not
						if(ph_install_yn.equals("Y") && arrCheckBoxVal.size() == 1)
						{
			 				sql 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PH_ORDER_SET");
							pstmt			= connection.prepareStatement(sql);
							pstmt.setString(1, catalog_code);
							pstmt.setString(2, getServiceCode());
							resultSet	= pstmt.executeQuery() ;
							if ( resultSet != null )
							{
								while(resultSet.next())  // Only one record
								{
									count	 = resultSet.getInt(1);
								}
							}
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
							if(count == 1)
							{
								sql 			= OrRepository.getOrKeyValue("SQL_PH_ONCOLOGY_REGIMEN_SERVICE_SELECT");
								pstmt			= connection.prepareStatement(sql);
								pstmt.setString(1, getServiceCode());
								resultSet		= pstmt.executeQuery() ;
								if ( resultSet != null )
								{
									while(resultSet.next())  // Only one record
									{
										regimen_yn = checkForNull(resultSet.getString( "regimen_yn" ),"N")  ;
									}
								}
								closeResultSet( resultSet ) ;
								closeStatement( pstmt ) ;
							}
					 	} // End of ph_install_yn
				 		if(regimen_yn.equals("Y"))
				 		{
							sb.append("" +catalog_code+ ",");
							setOncologyDefCatalogCode(catalog_code);
							default_tab = "C&iv_prep_default="+iv_prep_yn+"&order_set_code="+order_set_code;
				 		}
				 		else
				 		{   // Get the order set id
				 			//sql 		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_SET_CATALOG_CODE");
				 			//IN042045 Start
				 			if("NS".equals(pract_type))
				 			{	
								if (iv_prep_yn.equals("") )
								{
								 	sql 		= "SELECT a.order_catalog_code||'#'||OCURRANCE_NUM||'#'||a.ORDER_TYPE_CODE order_catalog_code FROM or_order_set_component a, or_order_catalog b WHERE a.order_catalog_code = b.order_catalog_code and order_set_code = ? AND a.order_category = ? AND 'Y' = (select APPL_TO_VERBAL_ORDER_YN from ph_drug where drug_code = b.order_catalog_code) order by b.short_desc"	;
								}
								else
								{
								 	sql 		= "SELECT a.order_catalog_code order_catalog_code FROM or_order_set_component a, or_order_catalog b WHERE a.order_catalog_code = b.order_catalog_code and order_set_code = ? AND a.order_category = ? AND 'Y' = (select APPL_TO_VERBAL_ORDER_YN from ph_drug where drug_code = b.order_catalog_code) order by b.short_desc"	;
								}
				 			}
				 			else //IN042045 End
				 			{
				 				if (iv_prep_yn.equals("") )
								{
								 	sql 		= "SELECT a.order_catalog_code||'#'||OCURRANCE_NUM||'#'||a.ORDER_TYPE_CODE order_catalog_code FROM or_order_set_component a, or_order_catalog b WHERE a.order_catalog_code = b.order_catalog_code and order_set_code = ? AND a.order_category = ? order by b.short_desc"	;
								}
								else
								{
								 	sql 		= "SELECT a.order_catalog_code order_catalog_code FROM or_order_set_component a, or_order_catalog b WHERE a.order_catalog_code = b.order_catalog_code and order_set_code = ? AND a.order_category = ? order by b.short_desc"	;
								}	
				 			}
							pstmt		= connection.prepareStatement(sql);
							pstmt.setString(1, catalog_code);
							pstmt.setString(2, order_category);
							resultSet	= pstmt.executeQuery() ;
							if ( resultSet != null )
							{
								while(resultSet.next())  // Only one record
								{
									catalog_code = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
									sb.append("" +catalog_code+ ",");
								}
							}
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
							default_tab = "R&iv_prep_default="+iv_prep_yn+"&order_set_code="+order_set_code;
			 	 		} // End of else
					} // End of else order_catalog_nature
					else sb.append("" +catalog_code+ ",");
			 	} // End of ! catalog_code.equals("")
		 	} // End of For

			return sb;
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
		}finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
	} // End of getPharmacyCatalogCodes

	//Query to Paint the Records in the Place Order Screen
	public ArrayList getPlaceOrdersResult(String order_type_and_order_catalog,String order_category,String catalog_code , String called_from) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql 					= "";
		int reccount = 0;

		ArrayList PlaceOrder = new ArrayList() ;
		try{
				connection	= getConnection();

				if( checkForNull(called_from,"").equalsIgnoreCase("PREVIEW") ){ // For OrderEntry Preview
					sql	= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_PREVIEW_SELECT");
					//IN055190 starts
					if(!"".equals(order_category))
					{
						sql = sql.replace("##FILTERCATEGORY##"," AND A.ORDER_CATEGORY IN ("+order_category+")");
					}
					else
					{
						sql = sql.replace("##FILTERCATEGORY##","");
					}
					//IN055190 ends
				} else { //  For Normal Orders
					sql	= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_SELECT");
				}
				// Since could not setString in the In operator , find the ? place holder and replace it with the values
				int  count 	= sql.lastIndexOf("?");
				sql  		= sql.substring(0,count) + order_type_and_order_catalog.trim() + sql.substring(count+1)  ;
				count 		= sql.lastIndexOf("?");
				sql  		= sql.substring(0,count) +catalog_code.trim() + sql.substring(count+1)  ;
				count 		= sql.lastIndexOf("?");
				sql  		= sql.substring(0,count) +order_type_and_order_catalog.trim() +sql.substring(count+1)  ;			
			
				pstmt		= connection.prepareStatement(sql);

				String ord_practitioner_id ="";
				if (getLoginPractId().equals(""))
				{
					ord_practitioner_id = getLoginById();
				}else{
					ord_practitioner_id = getLoginPractId();
				}
			
				if( checkForNull(called_from,"").equalsIgnoreCase("PREVIEW") )
				{
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount, getLoginFacilityId());
					pstmt.setString(++reccount, getLocationType());	// source_type
					pstmt.setString(++reccount, getLocationCode());  // source_code
					pstmt.setString(++reccount, language_id);//Added by Ambiga.M for 18146
					pstmt.setString(++reccount, getRDInstallYN());//IN069657
					pstmt.setString(++reccount, language_id);
					/*Added by Uma on 8/25/2009 for PMG20089 - CRF 641*/
					
					pstmt.setString(++reccount , ord_practitioner_id);		//P_LOGIN_PRACTITIONER_ID
				//	pstmt.setString(++reccount , getLoginById());		//P_LOGIN_PRACTITIONER_ID
					pstmt.setString(++reccount , getResponsibilityId());		//P_RESP_ID
					pstmt.setString(++reccount , getAuthorisationOrOrderingYn("AUT"));		//P_PRIV_APPL_YN
					/* End Here*/
					pstmt.setString(++reccount, getLoginFacilityId());//Added by Uma on 4/10/2010 for performance tuning
					pstmt.setString(++reccount, getPractitionerType());
					//pstmt.setString(++reccount, checkForNull(order_category,""));//IN055190 commented
					pstmt.setString(++reccount, getPatientClass());
				}else
				{
					pstmt.setString(++reccount, getPractitionerType());
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount, getLoginFacilityId());
					pstmt.setString(++reccount, getLocationType());	// source_type
					pstmt.setString(++reccount, getLocationCode());  // source_code
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount, getRDInstallYN());//IN069657
					pstmt.setString(++reccount, language_id);
					/*Added by Uma on 8/25/2009 for PMG20089 - CRF 641*/
				//	pstmt.setString(++reccount , getLoginById());		//P_LOGIN_PRACTITIONER_ID
					pstmt.setString(++reccount , ord_practitioner_id);		//P_LOGIN_PRACTITIONER_ID
					pstmt.setString(++reccount , getResponsibilityId());		//P_RESP_ID
					pstmt.setString(++reccount , getAuthorisationOrOrderingYn("AUT"));		//P_PRIV_APPL_YN
					/* End Here*/
					pstmt.setString(++reccount, getLoginFacilityId());//Added by Uma on 4/10/2010 for performance tuning 
					pstmt.setString(++reccount, checkForNull(order_category,""));
					pstmt.setString(++reccount, getPatientClass());

				}

				/*pstmt.setString(9, checkForNull(order_type_and_order_catalog.trim(),""));
				pstmt.setString(10, catalog_code.trim());
				pstmt.setString(11, checkForNull(order_type_and_order_catalog.trim(),""));	   */
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						//record 	  = new String[71];//IN048467 - HSA-CRF-0150 IN063816
						//record 	  = new String[72];//IN048467 - HSA-CRF-0150 IN063816//IN065942, commented
						//record 	  = new String[73];//IN048467 - HSA-CRF-0150 IN063816//IN065942
						record 	  = new String[76];//IN064543//IN068314
						record[0] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "catalog_synonym" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_catalog_nature" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_category"),"")  ;
						record[4] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "performing_facility_id" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "discr_msr_panel_id" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "security_level" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "consent_reqd_yn" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "consent_form_id" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "qty_reqd_yn" ),"N")  ;
						record[11] = checkForNull(resultSet.getString( "qty_uom" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "split_dose_yn" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "taper_dose_yn" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "freq_applicable_yn" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "soft_stop_yn" ),"N")  ;
						record[16] = checkForNull(resultSet.getString( "cont_order_yn" ),"N")  ;
						record[17] = checkForNull(resultSet.getString( "refill_cont_order_yn" ),"")  ;
						record[18] = checkForNull(resultSet.getString( "chk_for_dupl_yn" ),"")  ;

						record[19] = checkForNull(resultSet.getString( "soft_stop_yn" ),"N")  ;
						record[20] = checkForNull(resultSet.getString( "cont_order_yn" ),"N")  ;
						record[21] = checkForNull(resultSet.getString( "refill_cont_order_yn" ),"")  ;
						record[22] = checkForNull(resultSet.getString( "chk_for_dupl_yn" ),"")  ;
						record[23] = checkForNull(resultSet.getString( "chk_for_dupl_status" ),"")  ;
						record[24] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_action" ),"")  ;
						record[25] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_period" ),"")  ;
						record[26] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_unit" ),"")  ;
						record[27] = checkForNull(resultSet.getString( "chk_for_dupl_behind_action" ),"")  ;
						record[28] = checkForNull(resultSet.getString( "chk_for_dupl_behind_period" ),"")  ;

						record[29] = checkForNull(resultSet.getString( "chk_for_dupl_behind_unit" ),"")  ;
						record[30] = checkForNull(resultSet.getString( "ord_auth_level" ),"")  ;
						record[31] = checkForNull(resultSet.getString( "ord_cosign_level" ),"")  ;
						record[32] = checkForNull(resultSet.getString( "ord_spl_appr_level" ),"")  ;
						record[33] = checkForNull(resultSet.getString( "appt_reqd_yn" ),"")  ;
						record[34] = checkForNull(resultSet.getString( "appt_time" ),"")  ;
						record[35] = checkForNull(resultSet.getString( "pat_instrn_age_sex_yn" ),"N")  ;
						record[36] = checkForNull(resultSet.getString( "dept_only_yn" ),"")  ;
						record[37] = checkForNull(resultSet.getString( "complete_on_order_yn" ),"")  ;

						record[38] = checkForNull(resultSet.getString( "bill_yn" ),"N")  ;
						record[39] = checkForNull(resultSet.getString( "result_applicable_yn" ),"")  ;
						record[40] = checkForNull(resultSet.getString( "result_auth_reqd_yn" ),"N")  ;
						record[41] = checkForNull(resultSet.getString( "chart_result_type" ),"")  ;
						record[42] = checkForNull(resultSet.getString( "discr_msr_panel_id" ),"")  ;
						record[43] = checkForNull(resultSet.getString( "contr_mod_id" ),"")  ;
						record[44] = checkForNull(resultSet.getString( "contr_msr_panel_id" ),"")  ;
						record[45] = checkForNull(resultSet.getString( "image_link_id" ),"")  ;
						record[46] = checkForNull(resultSet.getString( "indexed_yn" ),"")  ;
						record[47] = checkForNull(resultSet.getString( "format_id_mandatory" ),"")  ;

						record[48] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"N")  ;
						record[49] = checkForNull(resultSet.getString( "ord_cosign_reqd_yn" ),"N")  ;
						record[50] = checkForNull(resultSet.getString( "ord_spl_appr_reqd_yn" ),"N")  ;
						record[51] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"N")  ;
						record[52] = checkForNull(resultSet.getString( "priority_appl" ),"")  ;
						record[53] = checkForNull(resultSet.getString( "activity_type" ),"")  ;
						record[54] = checkForNull(resultSet.getString( "check_for_dupl_level" ),"")  ;
						record[55] = checkForNull(resultSet.getString( "routine_appt_reqd_yn" ),"N")  ;
						record[56] = checkForNull(resultSet.getString( "stat_appt_reqd_yn" ),"N")  ;
						record[57] = checkForNull(resultSet.getString( "urgent_appt_reqd_yn" ),"N")  ;

						record[58] = checkForNull(resultSet.getString( "routine_chk_for_dupl_yn" ),"N")  ;
						record[59] = checkForNull(resultSet.getString( "urgent_chk_for_dupl_yn" ),"N")  ;
						record[60] = checkForNull(resultSet.getString( "stat_chk_for_dupl_yn" ),"N")  ;
						record[61] = checkForNull(resultSet.getString( "consent_stage" ),"")  ;
						record[62] = checkForNull(resultSet.getString( "explanatory_text" ),"")  ;
						record[63] = checkForNull(resultSet.getString( "auto_report_yn" ),"N")  ;
						//added on 08/05/07
						record[64] = checkForNull(resultSet.getString( "num_of_consent_req_bo" ),"0")  ;
						record[65] = checkForNull(resultSet.getString( "num_of_consent_req_br" ),"0")  ;
						record[66] = checkForNull(resultSet.getString( "clin_cmts_reqd_yn" ),"N")  ;
						//ends here
						/*Added by Uma on 8/26/2009 for PMG20089 - CRF 641*/
						record[67] = checkForNull(resultSet.getString( "can_authorise_yn" ),"N")  ;
						record[68] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						/*End Here*/
						record[69] = checkForNull(resultSet.getString( "OR_OPERATIONAL_MODULE_YN" ),"")  ;//Added by Uma on 4/10/2010 for performance tuning
						record[70] = checkForNull(resultSet.getString( "ORD_SKIP_AUTH_IND" ),"")  ;//IN048467 - HSA-CRF-0150
						record[71] = checkForNull(resultSet.getString( "BARCODE_REQD_YN" ),"")  ;//IN063816
						record[72] = checkForNull(resultSet.getString( "prn_regd_ord" ),"")  ;//IN065942
						record[73] = checkForNull(resultSet.getString( "INSTRN_CONTENT_TYPE" ),"T")  ;//IN064543
						record[74] = checkForNull(resultSet.getString( "fpp_yn" ),"")  ;//IN064543//IN068314
						record[75] = checkForNull(resultSet.getString( "fpp_category" ),"")  ;//IN064543//IN068314
						PlaceOrder.add(record) ;
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
			return PlaceOrder;
		}	 // End of the getPlaceOrdersResult
//IN058388-IN058669 starts
	public ArrayList getPlaceOrdersResult(String order_type_and_order_catalog,String order_category,String catalog_code , String called_from,String order_type_and_order_catalog_sort) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql 					= "";
		int reccount = 0;

		ArrayList PlaceOrder = new ArrayList() ;
		try{
				connection	= getConnection();

				if( checkForNull(called_from,"").equalsIgnoreCase("PREVIEW") ){ 
					sql	= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_PREVIEW_SELECT");
					if(!"".equals(order_category))
					{
						sql = sql.replace("##FILTERCATEGORY##"," AND A.ORDER_CATEGORY IN ("+order_category+")");
					}
					else
					{
						sql = sql.replace("##FILTERCATEGORY##","");
					}
				} else { 
					sql	= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_SELECT");
				}
				int  count 	= sql.lastIndexOf("?");
				sql  		= sql.substring(0,count) + order_type_and_order_catalog_sort.trim() + sql.substring(count+1)  ;
				count 		= sql.lastIndexOf("?");
				sql  		= sql.substring(0,count) +catalog_code.trim() + sql.substring(count+1)  ;
				count 		= sql.lastIndexOf("?");
				sql  		= sql.substring(0,count) +order_type_and_order_catalog.trim() +sql.substring(count+1)  ;
			
				pstmt		= connection.prepareStatement(sql);

				String ord_practitioner_id ="";
				if (getLoginPractId().equals(""))
				{
					ord_practitioner_id = getLoginById();
				}else{
					ord_practitioner_id = getLoginPractId();
				}

				if( checkForNull(called_from,"").equalsIgnoreCase("PREVIEW") )
				{
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount, getLoginFacilityId());
					pstmt.setString(++reccount, getLocationType());
					pstmt.setString(++reccount, getLocationCode());
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount, getRDInstallYN());//IN069657
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount , ord_practitioner_id);
					pstmt.setString(++reccount , getResponsibilityId());
					pstmt.setString(++reccount , getAuthorisationOrOrderingYn("AUT"));
					pstmt.setString(++reccount, getLoginFacilityId());
					pstmt.setString(++reccount, getPractitionerType());
					pstmt.setString(++reccount, getPatientClass());
				}else
				{
					pstmt.setString(++reccount, getPractitionerType());
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount, getLoginFacilityId());
					pstmt.setString(++reccount, getLocationType());
					pstmt.setString(++reccount, getLocationCode());
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount, getRDInstallYN());//IN069657
					pstmt.setString(++reccount, language_id);
					pstmt.setString(++reccount , ord_practitioner_id);
					pstmt.setString(++reccount , getResponsibilityId());
					pstmt.setString(++reccount , getAuthorisationOrOrderingYn("AUT"));
					pstmt.setString(++reccount, getLoginFacilityId());
					pstmt.setString(++reccount, checkForNull(order_category,""));
					pstmt.setString(++reccount, getPatientClass());

				}

				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						//record 	  = new String[71];//IN063816
						//record 	  = new String[72];//IN063816//IN065942, commented
						//record 	  = new String[73];//IN065942
						record 	  = new String[76];//IN064543//IN068314
						record[0] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "catalog_synonym" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_catalog_nature" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_category"),"")  ;
						record[4] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "performing_facility_id" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "discr_msr_panel_id" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "security_level" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "consent_reqd_yn" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "consent_form_id" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "qty_reqd_yn" ),"N")  ;
						record[11] = checkForNull(resultSet.getString( "qty_uom" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "split_dose_yn" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "taper_dose_yn" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "freq_applicable_yn" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "soft_stop_yn" ),"N")  ;
						record[16] = checkForNull(resultSet.getString( "cont_order_yn" ),"N")  ;
						record[17] = checkForNull(resultSet.getString( "refill_cont_order_yn" ),"")  ;
						record[18] = checkForNull(resultSet.getString( "chk_for_dupl_yn" ),"")  ;

						record[19] = checkForNull(resultSet.getString( "soft_stop_yn" ),"N")  ;
						record[20] = checkForNull(resultSet.getString( "cont_order_yn" ),"N")  ;
						record[21] = checkForNull(resultSet.getString( "refill_cont_order_yn" ),"")  ;
						record[22] = checkForNull(resultSet.getString( "chk_for_dupl_yn" ),"")  ;
						record[23] = checkForNull(resultSet.getString( "chk_for_dupl_status" ),"")  ;
						record[24] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_action" ),"")  ;
						record[25] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_period" ),"")  ;
						record[26] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_unit" ),"")  ;
						record[27] = checkForNull(resultSet.getString( "chk_for_dupl_behind_action" ),"")  ;
						record[28] = checkForNull(resultSet.getString( "chk_for_dupl_behind_period" ),"")  ;

						record[29] = checkForNull(resultSet.getString( "chk_for_dupl_behind_unit" ),"")  ;
						record[30] = checkForNull(resultSet.getString( "ord_auth_level" ),"")  ;
						record[31] = checkForNull(resultSet.getString( "ord_cosign_level" ),"")  ;
						record[32] = checkForNull(resultSet.getString( "ord_spl_appr_level" ),"")  ;
						record[33] = checkForNull(resultSet.getString( "appt_reqd_yn" ),"")  ;
						record[34] = checkForNull(resultSet.getString( "appt_time" ),"")  ;
						record[35] = checkForNull(resultSet.getString( "pat_instrn_age_sex_yn" ),"N")  ;
						record[36] = checkForNull(resultSet.getString( "dept_only_yn" ),"")  ;
						record[37] = checkForNull(resultSet.getString( "complete_on_order_yn" ),"")  ;

						record[38] = checkForNull(resultSet.getString( "bill_yn" ),"N")  ;
						record[39] = checkForNull(resultSet.getString( "result_applicable_yn" ),"")  ;
						record[40] = checkForNull(resultSet.getString( "result_auth_reqd_yn" ),"N")  ;
						record[41] = checkForNull(resultSet.getString( "chart_result_type" ),"")  ;
						record[42] = checkForNull(resultSet.getString( "discr_msr_panel_id" ),"")  ;
						record[43] = checkForNull(resultSet.getString( "contr_mod_id" ),"")  ;
						record[44] = checkForNull(resultSet.getString( "contr_msr_panel_id" ),"")  ;
						record[45] = checkForNull(resultSet.getString( "image_link_id" ),"")  ;
						record[46] = checkForNull(resultSet.getString( "indexed_yn" ),"")  ;
						record[47] = checkForNull(resultSet.getString( "format_id_mandatory" ),"")  ;

						record[48] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"N")  ;
						record[49] = checkForNull(resultSet.getString( "ord_cosign_reqd_yn" ),"N")  ;
						record[50] = checkForNull(resultSet.getString( "ord_spl_appr_reqd_yn" ),"N")  ;
						record[51] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"N")  ;
						record[52] = checkForNull(resultSet.getString( "priority_appl" ),"")  ;
						record[53] = checkForNull(resultSet.getString( "activity_type" ),"")  ;
						record[54] = checkForNull(resultSet.getString( "check_for_dupl_level" ),"")  ;
						record[55] = checkForNull(resultSet.getString( "routine_appt_reqd_yn" ),"N")  ;
						record[56] = checkForNull(resultSet.getString( "stat_appt_reqd_yn" ),"N")  ;
						record[57] = checkForNull(resultSet.getString( "urgent_appt_reqd_yn" ),"N")  ;

						record[58] = checkForNull(resultSet.getString( "routine_chk_for_dupl_yn" ),"N")  ;
						record[59] = checkForNull(resultSet.getString( "urgent_chk_for_dupl_yn" ),"N")  ;
						record[60] = checkForNull(resultSet.getString( "stat_chk_for_dupl_yn" ),"N")  ;
						record[61] = checkForNull(resultSet.getString( "consent_stage" ),"")  ;
						record[62] = checkForNull(resultSet.getString( "explanatory_text" ),"")  ;
						record[63] = checkForNull(resultSet.getString( "auto_report_yn" ),"N")  ;

						record[64] = checkForNull(resultSet.getString( "num_of_consent_req_bo" ),"0")  ;
						record[65] = checkForNull(resultSet.getString( "num_of_consent_req_br" ),"0")  ;
						record[66] = checkForNull(resultSet.getString( "clin_cmts_reqd_yn" ),"N")  ;

						record[67] = checkForNull(resultSet.getString( "can_authorise_yn" ),"N")  ;
						record[68] = checkForNull(resultSet.getString( "short_desc" ),"")  ;

						record[69] = checkForNull(resultSet.getString( "OR_OPERATIONAL_MODULE_YN" ),"")  ;
						record[70] = checkForNull(resultSet.getString( "ORD_SKIP_AUTH_IND" ),"")  ; 
						record[71] = checkForNull(resultSet.getString( "BARCODE_REQD_YN" ),"N")  ;//IN063816
						record[72] = checkForNull(resultSet.getString( "prn_regd_ord" ),"")  ;//IN065942
						record[73] = checkForNull(resultSet.getString( "INSTRN_CONTENT_TYPE" ),"T")  ;//IN064543
						record[74] = checkForNull(resultSet.getString( "fpp_yn" ),"")  ;//IN068314
						record[75] = checkForNull(resultSet.getString( "fpp_category" ),"")  ;//IN068314
						PlaceOrder.add(record) ;
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
			return PlaceOrder;
		}
//IN058388-IN058669 Ends

	// To Populate the Order Type in the Place Order Tab
	public ArrayList getPlaceOrderType(String order_catalog_code) throws Exception {
 		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList PlaceOrderType	= new ArrayList() ;
		//String  str					= null;
		try{
				/*PlaceOrderType.add(order_catalog_code); //Parameters passed
				String[] defVal		= {def_val} ;
				// In the Query, Make Sure the first value be the code and the second value be the Description
 				str					= getListOptions(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_TYPE"), PlaceOrderType, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----Select-----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;", defVal );
				// Nullifying the objects
				PlaceOrderType	= null;
				defVal			= null;
				return str;*/
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_TYPE"));
				pstmt.setString(1,language_id);
				pstmt.setString(2, checkForNull(order_catalog_code.trim(),""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						PlaceOrderType.add(record) ;
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
			return PlaceOrderType;
	}	 // End of the getPlaceOrderType

// To Populate the Frequency in the Place Order Tab
	public ArrayList getPlaceOrderFrequency(String catalog_code,String schd_from,String durn_type,String category,String order_type,String def_freq) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		if(durn_type==null)
		{
			durn_type = "";
		}
		String sql = "";
		if(catalog_code == null || catalog_code.equals("null")) 
			catalog_code = "";

		ArrayList PlaceOrderFrequency = new ArrayList() ;
		int setcount = 0;
		try{
				connection	= getConnection();
				if(category.equals("PH") && order_type.equals("MS") && def_freq.equals(""))
				{
					sql = "SELECT a.freq_code, a.freq_desc, '' interval_durn_type,'' interval_value,'' repeat_value, '' repeat_durn_type,'' scheduled_yn,'' freq_nature  FROM am_frequency_lang_vw a, or_frequency_scope b WHERE a.freq_code = b.freq_code AND a.freq_nature = 'C' AND b.order_category = 'PH' AND ROWNUM < 2 AND a.language_id = ?";
				}
				else
				{
					sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_FREQUENCY");
					if(!catalog_code.equals(""))
					{
							sql = sql.replace("##FILTER2##"," exists (SELECT 1 FROM OR_FREQ_CATALOG_SCOPE b,or_frequency_scope c WHERE b.freq_code = a.freq_code and b.freq_code = c.freq_code and c.freq_scope_yn = 'Y' AND  order_catalog_code =?) AND ");
					}
					else
					{
						if(!category.equals(""))
						{
							sql = sql.replace("##FILTER2##"," exists (select 1 from or_frequency_scope where freq_code = a.freq_Code and order_category='"+category+"' AND FREQ_SCOPE_YN = 'Y') and  ");
						}
						else
						{
							sql = sql.replace("##FILTER2##"," ");
						}
					}
					
					if(schd_from.equalsIgnoreCase("header")&&!durn_type.equals(""))
					{
						sql = sql.replace("##FILTER##"," and interval_durn_type =? and freq_nature not in('O','P') ");
					}
					else
					{
						sql = sql.replace("##FILTER##"," ");
					}
				}

				pstmt		= connection.prepareStatement(sql);

				if(category.equals("PH") && order_type.equals("MS") && def_freq.equals(""))
				{
					pstmt.setString(++setcount, language_id);
				}
				else
				{
					pstmt.setString(++setcount, language_id);
					if(!catalog_code.equals(""))
					{
						pstmt.setString(++setcount, checkForNull(catalog_code.trim(),""));
					}
					if(schd_from.equalsIgnoreCase("header")&&!durn_type.equals(""))
					{
						pstmt.setString(++setcount, checkForNull(durn_type.trim(),""));
					}
				}

				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[3];
						record[0] = checkForNull(resultSet.getString( "freq_code" ),"") + "~~" + checkForNull(resultSet.getString( "interval_durn_type" ),"") + "~~" + checkForNull(resultSet.getString( "interval_value" ),"") + "~~" + checkForNull(resultSet.getString( "repeat_value" ),"") +  "~~" + checkForNull(resultSet.getString( "repeat_durn_type" ),"") + "~~" + checkForNull(resultSet.getString( "scheduled_yn" ),"")+ "~~" + checkForNull(resultSet.getString( "freq_nature" ),"");
						record[1] = checkForNull(resultSet.getString( "freq_desc" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "freq_code" ),"");
						PlaceOrderFrequency.add(record) ;
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
			return PlaceOrderFrequency;
	}	 // End of the getPlaceOrderFrequency

	// To Populate the Duration in the Place Order Tab
	public ArrayList getPlaceOrderDuration() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PlaceOrderDuration = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_DURATION"));
				pstmt.setString(1, language_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "durn_type" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "durn_desc" ),"")  ;
						PlaceOrderDuration.add(record) ;
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
			return PlaceOrderDuration;
	}	 // End of the getPlaceOrderDuration

// To get the Date from the Param for the validation to be done in the Place Order
	public ArrayList getDate(String entered_date) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList ParamDate = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_DATE"));
				pstmt.setString(1,entered_date);
				pstmt.setString(2,entered_date);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "future_order_date" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "past_order_date" ),"")  ;
						ParamDate.add(record) ;
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
			return ParamDate;
	}	 // End of the getDate

// To get the Preps Instruction and the Dept Instructions in the Place Order
	public HashMap getPreps(String order_catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String pat_preps_or_instrns_txt 		= "";
		String pat_preps_or_instrns_ind 		= "";
		HashMap InstructionsMap = new HashMap();
		try{
				connection	= getConnection();
				//IN64543, starts
				/*
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_PREPS"));
					pstmt.setString(1, language_id);
					pstmt.setString(2, checkForNull(order_catalog_code.trim(),""));
					//pstmt.setString(3, checkForNull(preps_code.trim(),""));
				*/				
				if("T".equals(getInstrnContentType(order_catalog_code)))
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_PREPS"));
					pstmt.setString(1, language_id);
					pstmt.setString(2, checkForNull(order_catalog_code.trim(),""));
					//pstmt.setString(3, checkForNull(preps_code.trim(),""));
				}
				else
				{
					pstmt		= connection.prepareStatement("SELECT pat_preps_or_instrns_ind,pat_preps_or_instrns_free_fmt pat_preps_or_instrns_txt FROM OR_ORDER_CATALOG_PREPS_INSTRN WHERE order_catalog_code = ?");
					pstmt.setString(1, checkForNull(order_catalog_code.trim(),""));
				}
				//IN64543, ends
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						pat_preps_or_instrns_txt	= checkForNull(resultSet.getString( "pat_preps_or_instrns_txt" ),"")  ;
						pat_preps_or_instrns_ind	= checkForNull(resultSet.getString( "pat_preps_or_instrns_ind" ),"")  ;
						InstructionsMap.put(pat_preps_or_instrns_ind,pat_preps_or_instrns_txt);
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
			return InstructionsMap;
	}	 // End of the getPreps

	// To get the Age in the Place Order when the  PAT_INSTRN_AGE_SEX_YN = 'Y'
	public ArrayList getAgePreps() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList AgePreps			= new ArrayList();
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_PAT_INSTN"));
				pstmt.setString(1, getPatientId());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())	//Only One Record it will return
					{
						record 	  = new String[2];
						record[0] = checkForNull(resultSet.getString( "pat_age_in_days" ),"0")  ;
						record[1] = checkForNull(resultSet.getString( "sex" ),"N")  ;
						AgePreps.add(record) ;
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
			return AgePreps;
	}	 // End of the getAgePreps

	// To get the Preps Instruction and the Dept Instructions in the Place Order when the PAT_INSTRN_AGE_SEX_YN ="N"
	public String getPrepsInstructions(String order_catalog_code,int age_in_days,String sex) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String preps_instrn 		= "";
		try{
				connection	= getConnection();
				//IN64543, starts
				/*
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_PAT_YN_INSTRN"));
				pstmt.setString(1, checkForNull(order_catalog_code.trim(),""));
				pstmt.setString(2, "IM");
				pstmt.setString(3, language_id);
				pstmt.setInt(4, age_in_days);
				pstmt.setString(5, checkForNull(sex.trim(),"N"));
				*/
				if("T".equals(getInstrnContentType(order_catalog_code)))
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_PAT_YN_INSTRN"));
					pstmt.setString(1, checkForNull(order_catalog_code.trim(),""));
					pstmt.setString(2, "IM");
					pstmt.setString(3, language_id);
					pstmt.setInt(4, age_in_days);
					pstmt.setString(5, checkForNull(sex.trim(),"N"));
				}
				else
				{
					pstmt		= connection.prepareStatement("SELECT pat_preps_or_instrns_free_fmt pat_preps_or_instrns_txt FROM OR_ORDER_CATALOG_PREPS_INSTRN WHERE order_catalog_code = ? AND pat_preps_or_instrns_ind =? and ( ? BETWEEN calc_min_age_in_days AND calc_max_age_in_days) AND sex_spec_ind in (?,'N')");
					pstmt.setString(1, checkForNull(order_catalog_code.trim(),""));
					pstmt.setString(2, "IM");
					pstmt.setInt(3, age_in_days);
					pstmt.setString(4, checkForNull(sex.trim(),"N"));
					
				}
				//pstmt.setString(6, checkForNull(sex.trim(),"N"));
				//pstmt.setString(7, checkForNull(sex.trim(),"N"));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						preps_instrn	= checkForNull(resultSet.getString( "pat_preps_or_instrns_txt" ),"")  ;
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
			return preps_instrn;
	}	 // End of the getPrepsInstructions

	// To get the Authorization Required Y/N or Cosign Required Y/N or Special Approval Y/N to display the Hyperlink
	// Parameter is passed as order_category and the column Name (Ex:- auth_yn for Authorization required,cosign_yn for Cosign Required, ord_spl_appr_reqd_yn for Special Approval)
	public String getAccessReqd(String order_category,String column_name) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String access_reqd	 		= "";
		try{
				connection	= getConnection();
				if(column_name.equalsIgnoreCase("auth_yn")) //Authorized Reqd
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_AUTH_REQD"));
				}
				else if(column_name.equalsIgnoreCase("cosign_yn")) // Cosign Reqd
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_COSIGN_REQD"));
				}
				else // For Special Approval
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_SPECIAL_APPROVAL_REQD"));
				}
				pstmt.setString(1, checkForNull(order_category.trim(),""));
				pstmt.setString(2, getPractitionerId() );	//pstmt.setString(2, getAttendPractitionerId() );
				pstmt.setString(3, getResponsibilityId());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						access_reqd	= checkForNull(resultSet.getString(1),"")  ;
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
			return access_reqd;
	}	 // End of the getAccessReqd

	// Getting the Format_id and the Mandatory yn for the Header
	public String getFormatIdHdr(String order_category,String order_types_comb, String sex, String dob) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql					= "";

		String format_id_mand 		= "N";
		String format_id			= "";
		try{
			 if(order_types_comb!=null && !order_types_comb.equals(""))
			 {
				connection	= getConnection();
  			   // It is second parameter
				sql 		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_HDR_FORMAT_ID");
				int  count 	= sql.lastIndexOf("?"); // Second parameter
				sql  		= sql.substring(0,count) + order_types_comb.trim() + sql.substring(count+1)  ;
				pstmt		= connection.prepareStatement(sql);
				pstmt.setString(1, checkForNull(order_category.trim(),""));
				pstmt.setString(2, checkForNull(sex,""));
				pstmt.setString(3, checkForNull(sex,""));
				pstmt.setString(4, checkForNull(dob,""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						format_id		= checkForNull(resultSet.getString("format_id"),"")  ;
						if(!format_id.equals(""))
						{
							format_id_mand	= format_id.substring(0,1); //take only the first record
						}
						if(format_id_mand.equals("Y"))
							break;  //  Then come out of the loop, and display the mandatory gif
					}
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
			return format_id;
	}	 // End of the getFormatIdHdr

	// To get the FormatId's for the Order Type in the Header Level
	// To Populate the Order Format in the Place Order Tab
	public ArrayList getOrderTypeFormatID(String order_category,String order_types_comb) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String sql					= "";
		ArrayList OrderTypeFormat	= new ArrayList() ;
		try
		{
			connection	= getConnection();
			sql 		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_FORMAT_IDS");
			int  count 	= sql.lastIndexOf("?"); // Second parameter
			sql  		= sql.substring(0,count) + order_types_comb.trim() + sql.substring(count+1)  ;
			pstmt		= connection.prepareStatement(sql);
			pstmt.setString(1, language_id);
			pstmt.setString(2, checkForNull(order_category.trim(),""));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				String[] record = null;
				while(resultSet.next())
				{
					record 	  = new String[3];
					record[0] = checkForNull(resultSet.getString( "format_id" ),"")  ;
					record[1] = checkForNull(resultSet.getString( "order_type_code" ),"");
					record[2] = checkForNull(resultSet.getString( "short_desc" ),"");
					OrderTypeFormat.add(record) ;
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
		return OrderTypeFormat;
	}

	// To Populate the Order Format in the Place Order Tab
	public ArrayList getOrderFormat(String format_id,String order_category,String order_id,String called_from,String line_num,String priority, String sex, String dob,String login_facility_id,String catalog_code,String order_type_code,String patient_id) throws Exception 
	{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		PreparedStatement pstmt1 	    = null;
		PreparedStatement pstmt_format 	= null;
		ResultSet resultSet1 			= null;
		PreparedStatement pstmt2 	    = null;//IN068553
		ResultSet resultSet2 			= null;//IN068553
		ResultSet resultSet_format 		= null;
		String nurse_collect_yn			= "N";
		String attending_practitioner	= "";//IN068553
		String mobile_num               = "";//IN068553
		ArrayList OrderFormat			= new ArrayList() ;
		StringTokenizer stFormatID					  = null;
		String date_of_birth_time 		= getPatientBirthDateTime(patient_id);		
		if(format_id==null) format_id				  = "";
		if(order_category==null) order_category		  = "";
		if(order_id==null) order_id					  = "";
		if(called_from==null) called_from			  = "";
		if(line_num==null) line_num					  = "";
		if(priority==null) priority					  = "";
		if(sex==null) sex							  = "";
		if(dob==null) dob							  = "";
		if(login_facility_id==null) login_facility_id = "";
		if(catalog_code==null) catalog_code           = "";
		if(order_type_code==null) order_type_code     = "";
		
		try
		{
				connection			= getConnection();
				if(format_id.equals(""))
				{
					if(!catalog_code.equals("") && !order_type_code.equals(""))	 //IN29181 
					{
						pstmt_format = connection.prepareStatement("select or_get_format_id(?,?,?) format_id from dual");
						pstmt_format.setString(1,order_category);
						pstmt_format.setString(2,order_type_code);
						pstmt_format.setString(3,catalog_code);
						resultSet_format	= pstmt_format.executeQuery() ;
						if ( resultSet_format != null )
						{
							while(resultSet_format.next())
							{
								format_id = resultSet_format.getString("format_id")==null?"":resultSet_format.getString("format_id");
							}
						}
						if((!(format_id.equals(""))) && (format_id.length()>0) )
						{
							if(format_id.indexOf("~")!=-1)
							{
								stFormatID 	= new StringTokenizer(format_id,"~");
								while(stFormatID.hasMoreTokens())
								{
									 stFormatID.nextToken();
									format_id 				= stFormatID.nextToken();
								}
							}
						}
					}
				}
				
				closeResultSet(resultSet_format);
				closeStatement(pstmt_format);

				pstmt1				 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_NURSE_COLLECT"));
				pstmt2				 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_FORMAT_FIELDS"));//IN068553

				if(order_id.trim().equals("") && (!format_id.equals(""))) // For New Orders
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SELECT"));
					//pstmt.setString(1, language_id);
					pstmt.setString(1, checkForNull(format_id.trim(),""));
					pstmt.setString(2, checkForNull(order_category.trim(),""));
					pstmt.setString(3, checkForNull(sex.trim(),""));
					pstmt.setString(4, checkForNull(sex.trim(),""));
					pstmt.setString(5, checkForNull(date_of_birth_time,""));
					pstmt.setString(6, checkForNull(date_of_birth_time,""));
					pstmt.setString(7, checkForNull(date_of_birth_time,""));
					pstmt.setString(8, checkForNull(date_of_birth_time,""));
					pstmt.setString(9, checkForNull(date_of_birth_time,""));
				}
				else if(called_from.trim().equals("HEADER")) // For Amend Header
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_SELECT"));
					pstmt.setString(1, checkForNull(order_id.trim(),""));
					pstmt.setString(2, checkForNull(order_category.trim(),""));
					//pstmt.setString(3, language_id);
				}
				else if( (!order_id.trim().equals("")) && (!line_num.trim().equals("")) )			// For Amend Lines
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_DTL_SELECT"));
					//pstmt.setString(1, language_id);
					pstmt.setString(1, checkForNull(order_id.trim(),""));
					if(line_num.equals("null"))
						line_num = "";
					pstmt.setString(2, checkForNull(line_num.trim(),""));
					pstmt.setString(3, checkForNull(order_category.trim(),""));
				}
				if((order_id.trim().equals("") && (!format_id.equals("")))||(called_from.trim().equals("HEADER"))||((!order_id.trim().equals("")) && (!line_num.trim().equals(""))))
				{
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record = null;
						while(resultSet.next())
						{
							record 	  = new String[14];
							record[0] = checkForNull(resultSet.getString( "field_mnemonic" ),"")  ;
							record[1] = checkForNull(resultSet.getString( "seq_num" ),"0");
							record[2] = checkForNull(resultSet.getString( "label_text" ),"")  ;
						if((!order_id.trim().equals("")) && (!line_num.trim().equals(""))  && ( record[0].equalsIgnoreCase("NURSE_COLLECT_YN") || record[0].equalsIgnoreCase("SPECIMEN_TYPE"))) // for Amend Mode Make it disabled for the nurse_collect and specimen_collected
							record[3] = "D"; // Make it Disabled
						else
							record[3] = checkForNull(resultSet.getString( "accept_option" ),"")  ;

							if(order_category.equalsIgnoreCase("LB") && record[0].equalsIgnoreCase("NURSE_COLLECT_YN")) // for NurseCollect
							{
								String loc_type = getLocationType(); // added  for IN038117
								if(loc_type.equalsIgnoreCase("E")) {
									loc_type = "C";
								}
								pstmt1.setString(1, login_facility_id);
							//	pstmt1.setString(2, getLocationType()); Commented for IN038117
								pstmt1.setString(2, loc_type); // added  for IN038117
								pstmt1.setString(3, getLocationCode());
								pstmt1.setString(4, checkForNull(priority,""));
								resultSet1	= pstmt1.executeQuery() ;
								if ( resultSet1 != null )
								{
									while(resultSet1.next()) // only one record
									{
										nurse_collect_yn = 	checkForNull(resultSet1.getString( "nurse_collect_yn" ),"N")  ;
									}
								}
								record[4] = nurse_collect_yn;
							}
							//IN068553 starts
							else if (record[0].equalsIgnoreCase("ATTDPRACT")) // for Attending Practitioner
							{
								pstmt2.setString(1,language_id);
			                    pstmt2.setString(2,patient_id);
			                    pstmt2.setString(3,encounter_id);
			                    pstmt2.setString(4,login_facility_id);
								resultSet2	= pstmt2.executeQuery() ;
								
								if ( resultSet2 != null )
								{
									while(resultSet2.next()) // only one record
									{
										attending_practitioner = resultSet2.getString("attending_practitioner")==null?"":resultSet2.getString("attending_practitioner");
									}
								}
								record[4] = attending_practitioner;
							}
							else if( record[0].equalsIgnoreCase("ATTPRAMOBILENO")) // for Attending Practitioner
							{
								pstmt2.setString(1,language_id);
			                    pstmt2.setString(2,patient_id);
			                    pstmt2.setString(3,encounter_id);
			                    pstmt2.setString(4,login_facility_id);
								resultSet2	= pstmt2.executeQuery() ;
								
								if ( resultSet2 != null )
								{
									while(resultSet2.next()) // only one record
									{
										mobile_num = resultSet2.getString("mobile_num")==null?"":resultSet2.getString("mobile_num");
									}
								}
							
								record[4] = mobile_num;
							}
							//IN068553 ends
							else
							{
								record[4] = checkForNull(resultSet.getString( "dflt_value" ),"")  ;
								if(record[4].equals(""))
								{
									if((resultSet.getString( "field_type").equalsIgnoreCase("N"))||(resultSet.getString( "field_type").equalsIgnoreCase("I")))
									{
										Map<String, String>  discreetMesaure = getDiscreetMeasure(record[0],patient_id,sex,dob);
										if(discreetMesaure != null)
										{
											record[4] = discreetMesaure.get("DLFT_VALUE")==null?"":discreetMesaure.get("DLFT_VALUE");
										}
									}
									else if((resultSet.getString( "field_type").equalsIgnoreCase("V")))
									{
										Map<String, String>  ClinicalEvent = getClinicalEvent(record[0],patient_id);
										if(ClinicalEvent != null)
										{
											record[4] = ClinicalEvent.get("DLFT_VALUE")==null?"":ClinicalEvent.get("DLFT_VALUE");
										}
									}
								}
							}

							record[5] = checkForNull(resultSet.getString( "field_type" ),"")  ;
							record[6] = checkForNull(resultSet.getString( "min_num_value" ),"")  ;
							record[7] = checkForNull(resultSet.getString( "max_num_value" ),"")  ;
							record[8] = checkForNull(resultSet.getString( "order_field_value" ),"")  ;
							record[9] = checkForNull(resultSet.getString( "help_text" ),"")  ;
							record[10] = checkForNull(resultSet.getString( "discr_msr_id" ),"")  ;
							record[11] = checkForNull(resultSet.getString( "dependency_yn" ),"N")  ;
							record[12] = checkForNull(resultSet.getString( "single_or_multi" ),"")  ;
							record[13] = checkForNull(resultSet.getString( "discr_msr_uom" ),"")  ;

							OrderFormat.add(record) ;
						}
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
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;//IN068553
				closeStatement( pstmt2 ) ;//IN068553
				closeConnection(connection);
			}
			return OrderFormat;
	}	 // End of the getOrderFormat

	 public ArrayList getOrderFormatAnaesthesiaList() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Anaesthesia = new ArrayList() ;
        try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_FORMAT_ANAESTHESIA_SELECT") ) ;
				pstmt.setString(1, language_id);
				resultSet = pstmt.executeQuery() ;
				String[] record = null;
				if( resultSet != null) {
					while(resultSet.next() ) {
					record		 = new String[2];
					record[0]	 = resultSet.getString( "code" )  ;
					record[1]	 = resultSet.getString( "short_desc" )  ;

					Anaesthesia.add(record) ;
				}
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return Anaesthesia;
	} // End of the OrderFormatAnaesthesiaList

	// Dynamic population of the list box(Study Location) (From the Order Format)  on click of Mobile_required_yn
	public ArrayList getStudyLocation(String order_category,String contr_msr_panel_id,String performing_facility_id, String mobile_required_yn) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  rd_install_yn		= "N";
		ArrayList OrderFormatList = new ArrayList() ;

		try{
				connection			= getConnection();
				rd_install_yn		= checkForNull(getFacilityModuleInstallYn("RD"),"N"); // Call a method to get the Radialogy is installed or not
				if(((order_category.trim()).equalsIgnoreCase("RD")) && rd_install_yn.equalsIgnoreCase("Y"))    // For Study Location
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_INSTAL_STUDY_LOC"));
					pstmt.setString(1, language_id);
					pstmt.setString(2, checkForNull(contr_msr_panel_id.trim(),""));
					pstmt.setString(3, getSex());
					pstmt.setString(4, getSex());
					pstmt.setString(5, checkForNull(performing_facility_id,""));
					pstmt.setString(6, checkForNull(mobile_required_yn,"N")); //MOBILE_CLINIC_YN

					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record = null;
						while(resultSet.next())
						{
							record 	  = new String[4];
							record[0] = checkForNull(resultSet.getString( "clinic_code" ),"")  ;
							record[1] = checkForNull(resultSet.getString( "long_desc" ),"");
							record[2] = "N"; 			// Default Value 'N'
							record[3] = rd_install_yn; // RD is installed
							OrderFormatList.add(record) ;
						}
					}
				} // End of STUDY_LOC --> RD
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return OrderFormatList;
	} // End of getStudyLocation

	// To check whether the module has been installed or not, if installed it return as 'Y' otherwise 'N'
	public String getModuleInstallYn(String module_id) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String module_install_yn	= "N";
	try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
			pstmt.setString(1, checkForNull(module_id.trim(),""));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					module_install_yn = checkForNull(resultSet.getString( "install_yn" ),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return module_install_yn;
	} // End of getModuleInstallYn

	// To check whether the module has been installed or not, sm_modules_facility.operational_yn(Difft table referred)  if installed it return as 'Y' otherwise 'N'
		public String getFacilityModuleInstallYn(String module_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String module_install_yn	= "N";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt.setString(1, module_id);
				pstmt.setString(2, getLoginFacilityId()); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					while(resultSet.next())
					{
						module_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
					}
				}	// if there is no record, then also it should return as 'N'
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return module_install_yn;
	} // End of getFacilityModuleInstallYn

	// To get the Description for the order_catalog_dc and order_catalog_ad
	public String getOrderCatalogDesc(String catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String CatalogCodeDesc		= "";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_CATALOG_DESC"));
				pstmt.setString(1, checkForNull(catalog_code.trim(),""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // One record  for the order_catalog_code
				{
					while(resultSet.next())
					{
						CatalogCodeDesc = checkForNull(resultSet.getString( "catalog_desc" ),"")  ;
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
			return CatalogCodeDesc;
	}	 // End of the getOrderCatalogDesc

	// Do the Duplicate Check If any of the catalog_code(test_code) selected is Suspended
		private boolean validateSuspendedCheck() throws Exception {
			Connection connection 		= null;
			CallableStatement cstmt 	= null;
			String labchk="";
			boolean result 				= false;
			String status				= "N";
			String sql					= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_SUSPENDED_CHECK");
		try{
				connection			= getConnection();
				cstmt 				= connection.prepareCall("{ "+sql+" }");
				for(int i=0;i<count_chk_records;i++)
				{
					labchk=getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),login_facility_id);//added on 7/9/2007 for lb_instal_yn logic by uma
					//if(!result  && (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))changed on 7/9/2007 for lb_instal_yn logic by uma
					if(!result  && (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))
					{
						cstmt.clearParameters();
						cstmt.setString(1, checkForNull((String)hashValues.get("performing_facility_id"+i),""));
						cstmt.setString(2, checkForNull((String)hashValues.get("catalog_code"+i),""));
						cstmt.registerOutParameter( 3,  Types.VARCHAR ) ;

						cstmt.execute();
                    	status 		 = checkForNull(cstmt.getString(3),"");
	                   	if(status.equals("N") || status.equals("D"))
                    	{
							result   = true;   // Atleast one item is suspened it will come out.
							hashValues.put("susp_message",checkForNull((String)hashValues.get("cat_desc"+i),""));
						}
					} //End of lb_instal_yn
				} // End of for Loop
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeStatement( cstmt ) ;
				closeConnection(connection);
		   }

		if(result)	//If there are duplicate checks return it as false
			return false;
		else
			return true;
	} // End of the validateSuspendedCheck

	// Do the Duplicate Check(For Panels duplication alone),
	// If it is more than One record, If lab is installed and order-category is 'LB'
	// then the panels duplication is fired, i.e to see if two panels have the same code
	private boolean validateSamePanelDuplCheck() throws Exception {

			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			int dupl_count 				= 0;
			String short_desc			= "";//  order_catalog_code = "";
			String sql					= "",  str			      = "";
			StringBuffer sb				= new StringBuffer();
			StringBuffer sbRadialogy	= new StringBuffer();
			String labchk="";
			int total_count				= 0;
	try{
			connection		= getConnection();
			total_count		= count_chk_records + amend_total_count;
			if(total_count > 1)
			{
				for(int k=0;k<amend_total_count;k++)		// Amend Orders
				{

					labchk=getmoduleRL((String)hashValues.get("amend_catalog_code"+k),(String)hashValues.get("amend_order_category"+k),(String)hashValues.get("amend_order_type"+k),login_facility_id);//added on 7/9/2007 instead of lb_instal_yn by uma
					//if( ( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+k),"").equalsIgnoreCase("LB")) ) )changed on 7/9/2007 for lb_instal_yn by uma
				if( ( (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (checkForNull((String)hashValues.get("amend_order_category"+k),"").equalsIgnoreCase("LB")) ) )
					{
						if(!checkForNull((String)hashValues.get("amend_catalog_code"+k),"").equals(""))
						{
							sb.append("'"+checkForNull((String)hashValues.get("amend_catalog_code"+k),"")+ "',");
						}
					} // End of lb_instal_yn for Amend Orders
					else if( (checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+k),"").equalsIgnoreCase("RD")) )
					{
						if(!checkForNull((String)hashValues.get("amend_catalog_code"+k),"").equals(""))
						{
							sbRadialogy.append("'"+checkForNull((String)hashValues.get("amend_catalog_code"+k),"")+ "',");
						}
					} // End of rd_install_yn
				}
 				for(int i=0;i<count_chk_records;i++)	// For New Orders
				{
					labchk=getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),login_facility_id);//added on 7/9/2007 for lb_instal_yn logic by uma
					//if( ( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"").equalsIgnoreCase("LB")) ) )changed on 7/9/2007 for lb_instal_yn logic by uma
				if( ( (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (checkForNull((String)hashValues.get("order_category"+i),"").equalsIgnoreCase("LB")) ) )
					{
						if(!checkForNull((String)hashValues.get("catalog_code"+i),"").equals(""))
						{
							sb.append("'"+checkForNull((String)hashValues.get("catalog_code"+i),"")+ "',");
						}
					} // End of lb_instal_yn
					else if( (checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"").equalsIgnoreCase("RD")) )
					{
						if(!checkForNull((String)hashValues.get("catalog_code"+i),"").equals(""))
						{
							sbRadialogy.append("'"+checkForNull((String)hashValues.get("catalog_code"+i),"")+ "',");
						}
					} // End of rd_install_yn
			    } // End of for
			 	str =  sb.toString();
				if(str.length() > 0) // FOR LAB
				{
					str 			= str.substring(0, str.length()-1);
					sql 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_SAME_PANEL_CHECK_VALIDATON");
					// Since could not setString in the In operator , find the ? place holder and replace it with the values
					int count 		= sql.lastIndexOf("?");
					// Pass the already build string (consisting the catalog_code, which is used in the place order screen)
					sql  			= sql.substring(0,count) + str.trim() + sql.substring(count+1)  ;
					pstmt			= connection.prepareStatement(sql);
					resultSet		= pstmt.executeQuery() ;
					if ( resultSet != null && resultSet.next())    // check only the first record
					{   // Only one record
				        dupl_count 	= resultSet.getInt("count");
						short_desc 	= ((String)resultSet.getString( "short_desc" )); // Take the last one for the display
					} // End of if resultSet
					try{ // Close the statements
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
					   }catch(Exception e){
							e.printStackTrace();
					   }
				} // End of str.length()
				if(dupl_count==0)
				{
					str	= "";
					str =  sbRadialogy.toString(); // For Radialogy
					if(str.length() > 0)
					{
						str 			= str.substring(0, str.length()-1);
						sql 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_SAME_PANEL_CHECK_VALIDATON");
						// Since could not setString in the In operator , find the ? place holder and replace it with the values
						int count 		= sql.lastIndexOf("?");
						// Pass the already build string (consisting the catalog_code, which is used in the place order screen)
						sql  			= sql.substring(0,count) + str.trim() + sql.substring(count+1)  ;
						pstmt			= connection.prepareStatement(sql);
						resultSet		= pstmt.executeQuery() ;
						if ( resultSet != null && resultSet.next())    // check only the first record
						{   // Only one record
				    	    dupl_count 	= resultSet.getInt("count");
							short_desc 	= ((String)resultSet.getString( "short_desc" )); // Take the last one for the display
						} // End of if resultSet
					} // End of str.length()
				} // End of dupl_count
			} // End of count_chk_records > 1
		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		sb.setLength(0);  // Clearing the string buffer
		sbRadialogy.setLength(0); // Clearing the string buffer
		if(dupl_count > 0 ) //If there are duplicate checks return it as false
		{
			hashValues.put("dupl_message",checkForNull(short_desc,""));
	 		return false;
	    }
	     else return true;
	} // End of the validateSamePanelDuplCheck

    // Do the Duplicate Check(Panels) If any of the catalog_code(test_code) selected is in Panel also
	private boolean validatePanelDuplCheck() throws Exception {

			Connection connection 		= null;
			PreparedStatement pstmt 	= null;  PreparedStatement pstmt_rd = null;
			ResultSet resultSet 		= null;
			boolean result 				= false;
			String labchk="";
			ArrayList DuplCheck			= new ArrayList();
		try{
				connection				= getConnection();
				pstmt					= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
				pstmt_rd				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));
				// Amend Orders
				for(int j=0;j<amend_total_count;j++)		// Amend Orders
				{
						labchk=getmoduleRL((String)hashValues.get("amend_catalog_code"+j),(String)hashValues.get("amend_order_category"+j),(String)hashValues.get("amend_order_type"+j),login_facility_id);

					//if( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")))changed on 7/9/2007 for lb_instal_yn logic by uma
				if( (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) &&  (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")))
					{	//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
						pstmt.setString(1, checkForNull((String)hashValues.get("amend_catalog_code"+j),""));
						resultSet	= pstmt.executeQuery() ;
					}
					else if( (checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )
					{	//pstmt_rd		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));
						pstmt_rd.setString(1, checkForNull((String)hashValues.get("amend_catalog_code"+j),""));
						resultSet	= pstmt_rd.executeQuery() ;
					}
					//if( (( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) )changed on 7/9/2007 for lb_instal_yn logic by uma
					if( (( (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) )
					if ((    ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("amend_order_category"+j),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("amend_order_catalog_nature"+j),"N").equalsIgnoreCase("P")) )
					{//pstmt.setString(1, checkForNull((String)hashValues.get("amend_catalog_code"+j),""));
						//resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )    // One record
						{
							while(resultSet.next())
							{
								DuplCheck.add((String)resultSet.getString( "order_catalog_code" )); //Add the codes to the arraylist
							} // End of while
						} // End of if resultSet
 					} //End of lb_instal_yn || rd_install_yn
						closeResultSet( resultSet ) ;
				} // End of for loop in Amend Orders

				for(int i=0;i<count_chk_records;i++)	// New Orders
				{
					labchk=getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),login_facility_id);//added on 7/9/2007 for lb_instal_yn logic by uma
					//if( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))//changed on 7/9/2007 for lb_instal_yn by uma
				if(  (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))
					{	// Already pstmt created pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
						pstmt.setString(1, checkForNull((String)hashValues.get("catalog_code"+i),""));
						resultSet	= pstmt.executeQuery() ;
					}
					else if( (checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )
					{	// Already pstmt_rd created	 pstmt_rd		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));
						pstmt_rd.setString(1, checkForNull((String)hashValues.get("catalog_code"+i),""));
						resultSet	= pstmt_rd.executeQuery() ;
					}
					//if( (( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )changed on 7/9/2007 for lb_instal_yn logic by uma
					if( (( (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )
					{	//pstmt.setString(1, checkForNull((String)hashValues.get("catalog_code"+i),""));
						//resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )    // One record
						{
							while(resultSet.next())
							{
								DuplCheck.add((String)resultSet.getString( "order_catalog_code" )); //Add the codes to the arraylist
							} // End of while
						} // End of if resultSet
 					} //End of lb_instal_yn || rd_install_yn
					closeResultSet( resultSet ) ;
				} // End of for Loop
				if((count_chk_records > 0 || amend_total_count > 0) && DuplCheck!=null && DuplCheck.size() > 0)
				{
					for(int l=0;l<count_chk_records;l++) // For total records (Amend Orders)
					{
						if(!result)
						{
							// check if the code is present
							result	= (DuplCheck.contains( checkForNull((String)hashValues.get("amend_catalog_code"+l),"")) ) ; // Returns true if it is present
							hashValues.put("dupl_message",checkForNull((String)hashValues.get("amend_cat_desc"+l),""));
						}
					} // End of k --> count_chk_records;k++)
					if(!result)
					{
						for(int k=0;k<count_chk_records;k++) // For total records (New 	Orders)
						{
							if(!result)
							{
								// check if the code is present
								result	= (DuplCheck.contains( checkForNull((String)hashValues.get("catalog_code"+k),"")) ) ; // Returns true if it is present
								hashValues.put("dupl_message",checkForNull((String)hashValues.get("cat_desc"+k),""));
						}
						} // End of k --> count_chk_records;k++)
			  	 }	 // End of if result
			   }	 // End of count_chk_records || amend_total_count
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_rd ) ;
				closeConnection(connection);
				DuplCheck= null;
		   }
		 	if(result)	//If there are duplicate checks return it as false
				return false;
			else
				return true;
	} // End of the validatePanelDuplCheck

	// Do the Duplicate Check Here for the test codes and panels (group codes)
	/*Modified by Uma on 1/21/2010 for IN017231 for multi patient orders duplicate check*/
	private boolean validateDuplCheck() throws Exception 
	{
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		PreparedStatement pstmt 	= null;PreparedStatement pstmt_rd 	= null;
		ResultSet resultSet 		= null;
		String sql					= ""  , pat_id = "";
		String record[]				= null;
		String catalog_type		=	"";
		ArrayList multi_patient		= null;
		String labchk="";
		int count_alert				= 0;int count_error	= 0;
		int count_records			= 0;int count_patient = 1;  // By Default one patient
		ArrayList pat_catalogs = new ArrayList();
		int total_dupl_count_records = 0;
		int dup_cat_count = 0;
		
		try
		{
			connection					= getConnection();

			sql 						= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_CHECK_VALIDATON");
			cstmt 						= connection.prepareCall("{ CALL "+sql+" }");
			pstmt						= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_PANEL_CHECK_VALIDATON"));
			pstmt_rd					= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_DUPL_PANEL_CHECK_VALIDATION"));

	// For patient it has to be done
			multi_patient				= getMultiPatientDetails();
			if(multi_patient!=null && multi_patient.size() > 0)
				count_patient				= multi_patient.size();
				pat_id						= checkForNull((String)hashValues.get("patient_id"),"");
			for(int k=0; k<count_patient; k++)   // For the Patients (atleast one) Selected
			{
				if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
				{
					record					= (String[]) multi_patient.get(k);
					pat_id					= checkForNull(record[0],""); //patient_id
					/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
					pat_catalogs.clear();
					dup_cat_count = 0;
					/*Ends Here*/
				}
				for(int i=0;i<count_chk_records;i++)
				{
					//p_test_date_time_behind= "";test_date_time_ahead	 = "";ordered_pract_behind   = "";
					//ordered_pract_ahead    = "";order_status_behind	 = "";order_status_ahead	 = "";
					//end_date_time_behind   = "";end_date_time_ahead    = "";
					//catalog_desc_ahead	 = "";catalog_desc_behind	 = "";
					vb_status				 = ""; va_status			 = "";
					if(checkForNull((String)hashValues.get("chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y"))
					{
						if( (checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("R") &&  checkForNull((String)hashValues.get("routine_chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y"))  || (checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("U") &&  checkForNull((String)hashValues.get("urgent_chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y")) || (checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("S") &&  checkForNull((String)hashValues.get("stat_chk_for_dupl_yn"+i),"N").equalsIgnoreCase("Y")) )
						{
							//cstmt.setString(1, checkForNull((String)hashValues.get("patient_id"),""));
							cstmt.clearParameters();
							cstmt.setString(1, checkForNull(pat_id,""));
							cstmt.setString(2, checkForNull((String)hashValues.get("catalog_code"+i),""));
							cstmt.setString(3, checkForNull((String)hashValues.get("chk_for_dupl_behind_action"+i),""));
							cstmt.setString(4, checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""));
							cstmt.setString(5, checkForNull((String)hashValues.get("start_date_time"+i),"")); //if date is reqd. in query put as (to_date(?,"dd/mm/yyyy hh24:mi"))
							cstmt.setInt(6, Integer.parseInt(checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),"0")));
							cstmt.setString(7, checkForNull((String)hashValues.get("chk_for_dupl_status"+i),""));
							cstmt.setString(8, checkForNull((String)hashValues.get("chk_for_dupl_ahead_action"+i),""));
							cstmt.setInt(9, Integer.parseInt(checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),"0")));
							cstmt.setString(10, checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""));
							cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 16,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;
							cstmt.setString( 23, checkForNull((String)hashValues.get("activity_type"+i),""));
							cstmt.execute();
							//p_test_date_time_behind 	= cstmt.getString(11);
							vb_status 		  			= cstmt.getString(12);
							/*catalog_desc_behind  		= cstmt.getString(13);ordered_pract_behind  		= cstmt.getString(14);
							order_status_behind 		= cstmt.getString(15);end_date_time_behind 		= cstmt.getString(16);*/
							va_status 					= cstmt.getString(17);
							/*catalog_desc_ahead  		= cstmt.getString(18);ordered_pract_ahead 		= cstmt.getString(19);
							order_status_ahead   		= cstmt.getString(20);end_date_time_ahead  		= cstmt.getString(21);
							test_date_time_ahead		= cstmt.getString(22);*/
							// the above values r commented, no need to get from the procedure, can fire from the query and get it
							if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB"))
							{
								hashValues.put("reject_dupl_catalog_code"+count_error,checkForNull((String)hashValues.get("catalog_code"+i),""));
								count_error++;
								catalog_type = "R";
							}
							else if(va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
							{
								count_alert++;
								catalog_type = "W";
							}
							else
							{
								catalog_type = "";
							}
							/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
							if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB")||va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
							{
								String catalog_codes = checkForNull((String)hashValues.get("catalog_code"+i),"");
								//hashValues.put("dupl_catalog_code"+count_records, checkForNull((String)hashValues.get("catalog_code"+i),""));		
								catalog_codes = catalog_codes+"##"+catalog_type;
								if(multi_patient!=null && multi_patient.size() > 0)
								{
									if(catalog_codes!=null)
									{
										hashValues.put(pat_id+dup_cat_count,catalog_codes);
										dup_cat_count++;
									}								
								}
								total_dupl_count_records++;
								hashValues.put("dupl_catalog_code"+total_dupl_count_records,checkForNull((String)hashValues.get("catalog_code"+i),""));							hashValues.put("dupl_catalog_desc"+total_dupl_count_records,checkForNull((String)hashValues.get("cat_desc"+i),""));
								hashValues.put("va_status"+total_dupl_count_records, checkForNull(va_status,"N"));
								hashValues.put("vb_status"+total_dupl_count_records, checkForNull(vb_status,"N"));
								hashValues.put("patient_id"+total_dupl_count_records, checkForNull(pat_id,""));
								hashValues.put("activity_type"+total_dupl_count_records, checkForNull((String)hashValues.get("activity_type"+i),""));
								hashValues.put("chk_for_dupl_behind_unit"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""));
								hashValues.put("chk_for_dupl_behind_period"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),""));
								hashValues.put("chk_for_dupl_ahead_unit"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""));
								hashValues.put("chk_for_dupl_ahead_period"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),""));
								hashValues.put("chk_for_dupl_status"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_status"+i),""));
								hashValues.put("check_for_dupl_level"+total_dupl_count_records, checkForNull((String)hashValues.get("check_for_dupl_level"+i),""));
								hashValues.put("test_date_time"+total_dupl_count_records, checkForNull((String)hashValues.get("start_date_time"+i),""));
								/*hashValues.put("p_test_date_time_behind"+count_records,checkForNull(p_test_date_time_behind,""));
								hashValues.put("catalog_desc_behind"+count_records,checkForNull(catalog_desc_behind,""));
								hashValues.put("ordered_pract_behind"+count_records,checkForNull(ordered_pract_behind,""));
								hashValues.put("order_status_behind"+count_records,checkForNull(order_status_behind,""));
								hashValues.put("end_date_time_behind"+count_records,checkForNull(end_date_time_behind,""));
								hashValues.put("catalog_desc_ahead"+count_records,checkForNull(catalog_desc_ahead,""));
								hashValues.put("ordered_pract_ahead"+count_records,checkForNull(ordered_pract_ahead,""));
								hashValues.put("order_status_ahead"+count_records,checkForNull(order_status_ahead,""));
								hashValues.put("end_date_time_ahead"+count_records,checkForNull(end_date_time_ahead,""));
								hashValues.put("test_date_time_ahead"+count_records,checkForNull(test_date_time_ahead,""));
								*/
							}// End of if dupChk
							count_records++;
						} // End of if routine
					} // End of	chk_for_dupl_yn ="Y"
					labchk=getmoduleRL((String)hashValues.get("catalog_code"+i),(String)hashValues.get("order_category"+i),(String)hashValues.get("order_type"+i),login_facility_id);//added on 7/9/2007 instead of lb_instal_yn logic
					//if( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))changed on 7/9/2007 for lb_instal_yn logic by uma
					if( (checkForNull(labchk,"").equalsIgnoreCase("IBARL")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")))
					{
						pstmt.setString(1, checkForNull((String)hashValues.get("catalog_code"+i),""));
						resultSet	= pstmt.executeQuery() ;
					}
					else if( (checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) &&  (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")))
					{
						pstmt_rd.setString(1, checkForNull((String)hashValues.get("catalog_code"+i),""));
						resultSet	= pstmt_rd.executeQuery() ;
					}
					//if( (( (checkForNull((String)hashValues.get("lb_instal_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )changed on 7/9/2007 for lb_instal_yn logic by uma
					if( (( ( checkForNull(labchk,"").equalsIgnoreCase("IBARL"))  && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("LB")) )  || ((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )) && (checkForNull((String)hashValues.get("order_catalog_nature"+i),"N").equalsIgnoreCase("P")) )
					{
						if (resultSet != null )
						{
							while(resultSet.next())
							{
								// Call the procedure that many times for the test code in panels for Lab || Rad.
								if(checkForNull((String)resultSet.getString( "chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y"))
								{
									if( (checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("R") && checkForNull((String)resultSet.getString( "routine_chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y")) || (checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("U") && checkForNull((String)resultSet.getString( "urgent_chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y")) || (checkForNull((String)hashValues.get("priority"+i),"").equalsIgnoreCase("S") && checkForNull((String)resultSet.getString( "stat_chk_for_dupl_yn" ),"N").equalsIgnoreCase("Y")) )
									{
										//Already Declared outside the loop
										//sql 		= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_DUPL_CHECK_VALIDATON");
										//cstmt 		= connection.prepareCall("{ CALL "+sql+" }");
										//cstmt.setString(1, checkForNull((String)hashValues.get("patient_id"),""));
										cstmt.clearParameters();
										cstmt.setString(1, checkForNull(pat_id,""));
										cstmt.setString(2, checkForNull((String)resultSet.getString( "order_catalog_code" ),""));
										cstmt.setString(3, checkForNull((String)resultSet.getString("chk_for_dupl_behind_action"),""));
										cstmt.setString(4, checkForNull((String)resultSet.getString("chk_for_dupl_behind_unit"),""));
										cstmt.setString(5, checkForNull((String)hashValues.get("start_date_time"+i),"")); //if date is reqd. in query put as (to_date(?,"dd/mm/yyyy hh24:mi"))
										cstmt.setInt(6, Integer.parseInt(checkForNull((String)resultSet.getString("chk_for_dupl_behind_period"),"0")));
										cstmt.setString(7, checkForNull((String)resultSet.getString("chk_for_dupl_status"),""));
										cstmt.setString(8, checkForNull((String)resultSet.getString("chk_for_dupl_behind_action"),""));
										cstmt.setInt(9, Integer.parseInt(checkForNull((String)resultSet.getString("chk_for_dupl_ahead_period"),"0")));
										cstmt.setString(10, checkForNull((String)resultSet.getString("chk_for_dupl_ahead_unit"),""));
										cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 13,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 14,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 15,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 16,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 17,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 18,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 19,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 20,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 21,  Types.VARCHAR ) ;
										cstmt.registerOutParameter( 22,  Types.VARCHAR ) ;
										//cstmt.setString( 23, checkForNull((String)resultSet.getString("activity_type"),""));
										cstmt.setString( 23, checkForNull((String)hashValues.get("activity_type"+i),""));
										cstmt.execute();
										//p_test_date_time_behind 	= cstmt.getString(11);
										vb_status 		  			= cstmt.getString(12);
										/*catalog_desc_behind  		= cstmt.getString(13);ordered_pract_behind  		= cstmt.getString(14);
										order_status_behind 		= cstmt.getString(15);end_date_time_behind 		= cstmt.getString(16);*/
										va_status 					= cstmt.getString(17);
										/*catalog_desc_ahead  		= cstmt.getString(18);ordered_pract_ahead 		= cstmt.getString(19);
										order_status_ahead   		= cstmt.getString(20);end_date_time_ahead  		= cstmt.getString(21);
										test_date_time_ahead		= cstmt.getString(22);*/
										if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB"))
											count_error++;
										else if(va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
											count_alert++;									
										/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
										if(va_status.equalsIgnoreCase("EA") || vb_status.equalsIgnoreCase("EB")||va_status.equalsIgnoreCase("WA") || vb_status.equalsIgnoreCase("WB"))
										{
											String catalog_codes = checkForNull((String)hashValues.get("catalog_code"+i),"");
											//hashValues.put("dupl_catalog_code"+count_records, checkForNull((String)hashValues.get("catalog_code"+i),""));
											hashValues.put("dupl_catalog_code"+count_records,catalog_codes);
											if(multi_patient!=null && multi_patient.size() > 0)
											{
												if(catalog_codes!=null)
												{
													hashValues.put(pat_id+dup_cat_count,catalog_codes);
													dup_cat_count++;
												}
											}
											total_dupl_count_records++;
										//}
										/*Ends Here*/
											hashValues.put("va_status"+total_dupl_count_records,checkForNull(va_status,"N"));
											hashValues.put("vb_status"+total_dupl_count_records,checkForNull(vb_status,"N"));
											hashValues.put("patient_id"+total_dupl_count_records, checkForNull(pat_id,""));
											hashValues.put("activity_type"+total_dupl_count_records, checkForNull((String)hashValues.get("activity_type"+i),""));
											hashValues.put("chk_for_dupl_behind_unit"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_behind_unit"+i),""));
											hashValues.put("chk_for_dupl_behind_period"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_behind_period"+i),""));
											hashValues.put("chk_for_dupl_ahead_unit"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_ahead_unit"+i),""));
											hashValues.put("chk_for_dupl_ahead_period"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_ahead_period"+i),""));
											hashValues.put("chk_for_dupl_status"+total_dupl_count_records, checkForNull((String)hashValues.get("chk_for_dupl_status"+i),""));
											hashValues.put("check_for_dupl_level"+total_dupl_count_records, checkForNull((String)hashValues.get("check_for_dupl_level"+i),""));
											hashValues.put("test_date_time"+total_dupl_count_records, checkForNull((String)hashValues.get("start_date_time"+i),""));	/*hashValues.put("p_test_date_time_behind"+count_records,checkForNull(p_test_date_time_behind,""));
											hashValues.put("catalog_desc_behind"+count_records,checkForNull(catalog_desc_behind,""));
											hashValues.put("ordered_pract_behind"+count_records,checkForNull(ordered_pract_behind,""));
											hashValues.put("order_status_behind"+count_records,checkForNull(order_status_behind,""));
											hashValues.put("end_date_time_behind"+count_records,checkForNull(end_date_time_behind,""));
											hashValues.put("catalog_desc_ahead"+count_records,checkForNull(catalog_desc_ahead,""));
											hashValues.put("ordered_pract_ahead"+count_records,checkForNull(ordered_pract_ahead,""));
											hashValues.put("order_status_ahead"+count_records,checkForNull(order_status_ahead,""));
											hashValues.put("end_date_time_ahead"+count_records,checkForNull(end_date_time_ahead,""));
											hashValues.put("test_date_time_ahead"+count_records,checkForNull(test_date_time_ahead,"")); */
											count_records++;
										}// End of if dupChk
									}// End of if routine
								} // End of	chk_for_dupl_yn ="Y"
							} // End of while
						} // End of if resultSet
						closeResultSet( resultSet ) ;
					} //End of lb_instal_yn || rd_install_yn
				} // End of for Loop
				/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
				if(multi_patient!=null && multi_patient.size() > 0)
				{
					hashValues.put(pat_id,dup_cat_count);
				}
				/*Ends Here*/
			} // End of patient for loop
			hashValues.put("dupl_count_alert",String.valueOf(count_alert));
			hashValues.put("dupl_count_error",String.valueOf(count_error));
			hashValues.put("total_dupl_count_records",String.valueOf(total_dupl_count_records));
			/*Added by Uma on 1/5/2010 for IN017231 PMG20089-CRF-0830*/
			if(multi_patient!=null && multi_patient.size() > 0)
				hashValues.put("called_from_multi", "MULTI_PATIENT_ORDERS");
			else
				hashValues.put("called_from_multi", "");
			hashValues.put("count_patient", count_patient);
			hashValues.put("count_chk_records", count_chk_records);
			/*Ends Here*/
		}
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeStatement( cstmt ) ;
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt_rd ) ;
			closeConnection(connection);
	   }
		if(count_error > 0 || count_alert > 0)	//If there are duplicate checks return it as false
			return false;
		else
			return true;
	} // End of the validateDuplCheck
	/*Ends Here*/

	// Do the Exam Conflicts, If any of the catalog_code(exam_code) has conflict and display and alert and continue
	// For Radialogy
	private boolean validateExamConflicts() throws Exception {
		Connection connection 		= null;
		CallableStatement cstmt 	= null;
		String status				= "", conflict_exam 	= "", conflict_exam_desc = "";
		String reason				= "", exam_date_value	 = "";
		String pat_id				= "", conflict_type		= "";
		String sql					= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_EXAM_CONFLICT");
		int count_patient			= 1; // By Default one patient
		String record[]				= null;
		ArrayList multi_patient		= null;
		java.sql.Date exam_date		= null;
		java.text.SimpleDateFormat dtSystemFormat 		= new java.text.SimpleDateFormat("dd/MM/yyyy k:mm");
		int count_records			= 0; int  conflict_records = 0;
		try{
				connection				= getConnection();
				cstmt 					= connection.prepareCall("{ "+sql+" }");

				multi_patient			= getMultiPatientDetails();
				if(multi_patient!=null && multi_patient.size() > 0)
					count_patient		= multi_patient.size();
				pat_id					= checkForNull((String)hashValues.get("patient_id"),"");
				for(int k=0; k<count_patient; k++)   // For the Patients (atleast one) Selected
				{
					if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
					{
						record			= (String[]) multi_patient.get(k);
						pat_id			= checkForNull(record[0],""); //patient_id
					}
					for(int i=0;i<count_chk_records;i++)
					{
						if( (checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )
						{
							cstmt.clearParameters();
							cstmt.setString(1, checkForNull((String)hashValues.get("contr_msr_panel_id"+i),""));
							cstmt.setString(2, checkForNull(pat_id,""));
							cstmt.setString(3, checkForNull((String)hashValues.get("start_date_time"+i),""));
							cstmt.registerOutParameter( 4,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 7,  Types.DATE ) ;
							cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;
							cstmt.registerOutParameter( 9,  Types.VARCHAR ) ;

							cstmt.execute();
			            	status 		 		= checkForNull(cstmt.getString(4),"");	//P_STAT
				        	conflict_exam 		= checkForNull(cstmt.getString(5),"");	//P_CONFLICT_EXM
					    	conflict_exam_desc 	= checkForNull(cstmt.getString(6),"");	//P_CONF_EXM_DESC
							exam_date 			= cstmt.getDate(7);  // Date9P_EXM_DONE)
                    		reason 				= checkForNull(cstmt.getString(8),""); //Reason
							conflict_type		= checkForNull(cstmt.getString(9),""); //Conflict Type
							if(exam_date!=null)
								exam_date_value	 = dtSystemFormat.format(exam_date);
 							if(!status.equals("") && !status.equals("N"))
							{
								if(!conflict_type.equals("S")) // if S, then should be stopped ortherwise can proceed
									conflict_records++;   // that logic will be taken care in the jsp
 								hashValues.put("status"+count_records,checkForNull(status,""));
								hashValues.put("conflict_exam"+count_records,checkForNull(conflict_exam,""));
								hashValues.put("conflict_exam_desc"+count_records,checkForNull(conflict_exam_desc,""));
								hashValues.put("conflict_exam_date"+count_records,exam_date_value);
								hashValues.put("conflict_reason"+count_records,reason);

								count_records++;
							}
						} //End of rd_install_yn
					} // End of for Loop i
				} // End of for loop k (pat)
				hashValues.put("total_dupl_count_records","");
				hashValues.put("conflict_exam_count_records",String.valueOf(count_records));
				hashValues.put("conflict_records",String.valueOf(conflict_records));
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeStatement( cstmt ) ;
				closeConnection(connection);
		   }
	 	if(count_records > 0)	//If there are duplicate checks return it as false
			return false;
		else
			return true;
	} // End of the validateExamConflicts

	// If appt_reqd_yn for the catalog  and category is Radialogy and radialogy module
	// has been installed, then check for the patient if any appoitment if there,
	// then display the appointment in the Modal window
	private boolean validateAppointment() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;	PreparedStatement pstmt_rd_appt = null;
		ResultSet resultSet 		= null;
		//boolean result 			= false;
		boolean appt_reqd			= false;
		String  rd_appt				= "";
		int count_records			= 0;
		String record[]				= null;
		ArrayList multi_patient		= null;
		int count_patient			= 1; // By Default one patient
		String pat_id				= "";
		try{
				connection			= getConnection();
				multi_patient		= getMultiPatientDetails();
				if(multi_patient!=null && multi_patient.size() > 0)
					count_patient	= multi_patient.size();
				pat_id				= checkForNull((String)hashValues.get("patient_id"),"");
				for(int j=0;j<amend_total_count;j++)		// Amend Orders
				{
					if( (checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("appt_reqd_yn"+j),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+j),"CS").equalsIgnoreCase("RD")) )
					{
						appt_reqd = true;
						break;  // If atleast one item has appt_reqd, then come out of the loop
					}
				} // End of for loop in Amend Orders
				if(!appt_reqd)
				{
					for(int i=0;i<count_chk_records;i++)	// New Orders
					{
						 if((checkForNull((String)hashValues.get("rd_install_yn"),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("appt_reqd_yn"+i),"N").equalsIgnoreCase("Y")) && (checkForNull((String)hashValues.get("order_category"+i),"CS").equalsIgnoreCase("RD")) )
						 {
							appt_reqd = true;
							break;  // If atleast one item has appt_reqd, then come out of 	the loop
						 }
			  	   }
		  	   } // End of if appt_reqd
			   if(appt_reqd)
			   {
				    pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_APPT_REQD"));
					pstmt_rd_appt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_RD_APPT_DETAILS"));

					for(int k=0; k<count_patient; k++)   // For the Patients (atleast one) Selected
					{
						if(multi_patient!=null && multi_patient.size() > 0) // Only it is for Multi Patients
						{
							record	= (String[]) multi_patient.get(k);
							pat_id	= checkForNull(record[0],""); //patient_id
						}
						// Amend Orders
						pstmt.clearParameters();
		  				pstmt.setString(1, checkForNull(pat_id,""));//pstmt.setString(1, checkForNull((String)hashValues.get("patient_id"),""));
						pstmt.setString(2, checkForNull(pat_id,""));
						resultSet	= pstmt.executeQuery() ;
						if ( resultSet != null )    // One record
						{
							while(resultSet.next())
							{
								// Take the last one for the display
								rd_appt		= checkForNull( ((String)resultSet.getString(1)), "");
							} // End of while
						} // End of if resultSet
						closeResultSet( resultSet ) ;
						if(rd_appt.equals("X")) // Do the query to display all the records
						{
 							 pstmt_rd_appt.clearParameters();
							 pstmt_rd_appt.setString(1, checkForNull(pat_id,""));
							 pstmt_rd_appt.setString(2, checkForNull(pat_id,""));
							 resultSet		= pstmt_rd_appt.executeQuery() ;
							 if ( resultSet != null )
							 {
								while(resultSet.next())
								{
									hashValues.put("appt_module_id"+count_records, checkForNull( ((String)resultSet.getString("module_id")), "") );
									hashValues.put("appt_facility_name"+count_records, checkForNull( ((String)resultSet.getString("facility_name")), "") );
									hashValues.put("appt_ref_no"+count_records, checkForNull( ((String)resultSet.getString("appt_ref_no")), "") );
									hashValues.put("appt_date"+count_records, checkForNull( ((String)resultSet.getString("appt_date")), "") );
									hashValues.put("clinic_desc"+count_records, checkForNull( ((String)resultSet.getString("clinic_desc")), "") );
									hashValues.put("appt_start_time"+count_records, checkForNull( ((String)resultSet.getString("appt_start_time")), "") );
									hashValues.put("appt_end_time"+count_records, checkForNull( ((String)resultSet.getString("appt_end_time")), "") );
									count_records++;
								} // End of while
							} // End of if resultSet
							closeResultSet( resultSet ) ;
						}  // End of rd_appt.equals("X")
					} // End of for k (Patient)
			   } // End of if appt_reqd
			   hashValues.put("appt_count_records",String.valueOf(count_records));
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt_rd_appt ) ;
				closeConnection(connection);
		   }
		 	if(rd_appt.equals("X") && count_records>0)	//If there are Appointments for the Patient then display the modal window
		 	{
				hashValues.put("rd_appt", rd_appt );
				return false;
			}
			else
				return true;
	}

	// To get the Description for the Nationality and the patient_name
	public ArrayList getNationality(String patient_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//String nationality			= "", patient_name = "";  //IN058811 commented for Nationalid
		String nationality			= "", patient_name = "" ,national_id = ""; //IN058811
		ArrayList Nationality		= new ArrayList();
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_NATIONALITY_SELECT"));
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, patient_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // One record  for the nationality & patient_name
				{
					while(resultSet.next())
					{
						nationality  = checkForNull(resultSet.getString( "short_name" ),"");
						patient_name = checkForNull(resultSet.getString( "patient_name" ),"");
						national_id	 = checkForNull(resultSet.getString( "national_id_no" ),"");  //IN058811
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
			Nationality.add(nationality);
			Nationality.add(patient_name);
			Nationality.add(national_id);  //IN058811
			return Nationality;
	}	 // End of the getNationality

	// To get the Description for the Location_name
	public ArrayList getLocationName(String location_type,String location_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String location_name		= "";
		String source_type		= "";
		ArrayList location_dtls=new ArrayList();
		try{
				connection	= getConnection();
				location_type = checkForNull(location_type,"");
				location_code = checkForNull(location_code,"");
				if(!location_type.equals(""))
				{
					if(location_type.equalsIgnoreCase("N")) {
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_NURSING_LOCN_NAME_SELECT"));
					} else if(location_type.equalsIgnoreCase("C")) {
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_CLINIC_LOCN_NAME_SELECT"));
					} else {
						pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_DAY_CLINIC_LOCN_NAME_SELECT"));
					}
					pstmt.setString(1, language_id);
					pstmt.setString(2, login_facility_id);
					pstmt.setString(3, location_code);
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )    // One record  for the Location_name
					{
						while(resultSet.next())
						{
							location_name = checkForNull(resultSet.getString( "locn_name" ),"")  ;
							source_type = checkForNull(resultSet.getString( "source_type" ),"")  ;
							location_dtls.add(location_name);
							location_dtls.add(source_type);
						}
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
			return location_dtls;
	}	 // End of the getLocationName


	// For the Place Order Set, default values
	public ArrayList getPlaceOrderSetDefault(String order_catalog_code,String orderSetCode) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PlaceOrderSetDefault = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_SET_DEFAULT"));
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, checkForNull(order_catalog_code.trim(),""));
				//pstmt.setString(3, getPatientClass());
				pstmt.setString(4, orderSetCode);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )			// Only one record per code
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[11];
						record[0] = checkForNull(resultSet.getString( "freq_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "durn_value" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "durn_type" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "max_durn_value" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "max_durn_type" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "chk_for_max_durn_action" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "prompt_msg" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "item_narration" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "qty_value" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "qty_uom" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						PlaceOrderSetDefault.add(record) ;
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
			return PlaceOrderSetDefault;
	}	 // End of the getPlaceOrderSetDefault


		// For the Place Order, default values for the Copy Order Function
	public ArrayList getCopyPlaceOrderDefault(String order_id, String order_line_no) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PlaceOrderDefault = new ArrayList() ;
		try{
				connection	= getConnection();
				//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LINE_PLACE_DEFAULT"));
				//Modified by Uma on 1/29/2010 for IN018695*/
				pstmt		=connection.prepareStatement("SELECT freq_code, durn_value,durn_type, null max_durn_value, null max_durn_type, null chk_for_max_durn_action,  null prompt_msg, item_narration,qty_value, qty_unit qty_uom,am_get_desc.am_uom(qty_unit,?,2) short_desc FROM or_order_line WHERE ORDER_ID=? AND ORDER_LINE_NUM= nvl(?,order_line_num) AND ROWNUM <=1");
				/*Added by Uma on 1/29/2010 for IN018695*/
				pstmt.setString(1, language_id);				
				pstmt.setString(2, checkForNull(order_id,""));
				pstmt.setString(3, checkForNull(order_line_no,""));
				/*Ends Here*/
				
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )			// Only one record per code
				{
					String[] record = null;
					while(resultSet.next())
					{
						//Modified by Uma on 1/29/2010 for IN018695*/
						record 	  = new String[11];
						/*Ends Here*/
						record[0] = checkForNull(resultSet.getString( "freq_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "durn_value" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "durn_type" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "max_durn_value" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "max_durn_type" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "chk_for_max_durn_action" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "prompt_msg" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "item_narration" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "qty_value" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "qty_uom" ),"")  ;
						/*Added by Uma on 1/29/2010 for IN018695*/
						record[10] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						/*Ends Here*/
						PlaceOrderDefault.add(record) ;
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
			return PlaceOrderDefault;
	}	 // End of the getCopyPlaceOrderDefault


	/* For Amend/Review order, This  method is called, To get the catalog_code,order_category and order_type_code
	 * then set it in the bean
	 */
	public void setAmendCode(String key,String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String catalog_code			= "";
		String order_category		= "", order_type_code	= "";
		HashMap hashEntry			= new HashMap();
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_CODE_SELECT"));
				pstmt.setString(1, order_id);
				pstmt.setString(2, order_line_num);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						catalog_code = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						order_category = checkForNull(resultSet.getString( "order_category" ),"")  ;
						order_type_code = checkForNull(resultSet.getString( "order_type_code" ),"")  ;
						// Putting into a temporary hashtable, then pushing into the bean
						hashEntry.put("ck"+catalog_code,"Y");
						hashEntry.put("h1"+order_category,order_category) ;
						hashEntry.put("h2"+order_type_code,order_type_code) ;
					}
					// Call the setCheckedEntries method in the orderEntryRecordBean to set the values
					boolean statusVal = orderEntryRecordBean.setCheckedEntries(key, hashEntry);
					if(statusVal)	// Since order_category will be same for all, take the last one
					{
                        setOrderCategoryValue(order_category);
						setAmendOrderType(order_type_code);  // Since order_type_code will be same for all, take the last one
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
	}	 // End of the setAmendCode

   /* For COPY order, This  method is called, To get the catalog_code,order_category and order_type_code
	* then set it in the bean
	*/
	public String setCopyCode(String key, ArrayList CopyOrderDetails) throws Exception {
	String[] record			= null ;
	HashMap hashEntry		= new HashMap();
	HashMap copyOrderDetails= new HashMap();

	String order_id			= null ,	order_line_no	= "";
	String catalog_code		= null ,	order_category	= "";
	String order_type_code	= null ;
	StringBuffer sb			= new StringBuffer();
	String str				= null ;
	try{
		if(CopyOrderDetails!=null)
		{
			for(int i=0;i<CopyOrderDetails.size();i++)
			{
				record 		= (String[])CopyOrderDetails.get(i);
				// ArrayList Values (order_id, order_line_no, catalog_code, order_category, order_type_code)
				order_id		= record[0];
				order_line_no	= record[1];
				catalog_code	= record[2];
				order_category  = record[3];
				order_type_code = record[4];
				sb.append("ck"+catalog_code+",");
				// Add it to the Hash Map here  (For Main Bean)
				hashEntry.put("ck"+catalog_code,"Y");
				hashEntry.put("h1"+catalog_code,order_category);
				hashEntry.put("h2"+catalog_code,order_type_code);
				// Add it in a HashMap and store it to be used for Copy Orders
				copyOrderDetails.put("order_id"+catalog_code , order_id);
				copyOrderDetails.put("order_line_no"+catalog_code , order_line_no);
			} // End of for
			str = sb.toString() ;
			if(str.length() > 0)
				str = str.substring(0, str.length()-1);
		} // End of CopyOrderDetails
		// Call the setCheckedEntries method in the orderEntryRecordBean to set the values
		//boolean statusVal = orderEntryRecordBean.setCheckedEntries(key, hashEntry);
		orderEntryRecordBean.setCheckedEntries(key, hashEntry);
		setCatalogCodes(str); // Call this method to set the catalog code into the bean
		setCopyOrderIDDetails(copyOrderDetails); // Call this method to set the hash map which contains the order_id and order_line_no into the bean
	 }catch ( Exception e )	{

		e.printStackTrace() ;
		throw e ;
	}
	sb.setLength(0);  // Clearing the string buffer
	return str;
 } // End of setCopyCode

	// Query to paint the record for the Amend/Review order in the Place Order Screen
	public ArrayList getAmendPlaceOrdersResult(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList AmendPlaceOrder = new ArrayList() ;
		try{
				connection	= getConnection();
				//pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_PLACE_SELECT"));				
				//IN063816 starts
				//pstmt		= connection.prepareStatement("SELECT a.order_id order_id,order_line_num,a.order_catalog_code  order_catalog_code,a.order_type_code order_type_code, a.order_category order_category ,a.ord_date_time ord_date_time,a.priority  priority,a.ord_auth_reqd_yn ord_auth_reqd_yn,a.ord_appr_reqd_yn ord_appr_reqd_yn ,a.ord_cosign_reqd_yn ord_cosign_reqd_yn , TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,a.qty_value qty_value,a.qty_unit qty_unit,am_get_desc.am_uom(a.qty_unit,?,2) short_desc,a.freq_code freq_code,a.durn_value durn_value ,a.durn_type durn_type,a.item_narration item_narration,end_date_time,a.order_qty order_qty ,a.cont_order_ind cont_order_ind,a.ord_pract_id ord_pract_id,order_line_status ,a.ord_consent_reqd_yn  ord_consent_reqd_yn,b.qty_uom qty_uom,nvl(am_get_desc.am_practitioner (g.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (g.ord_pract_id,?,'1'))  practitioner_name , OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(c.ORDER_CATALOG_CODE,c.CATALOG_SYNONYM_TYPE,?,'1') catalog_synonym,a.result_auth_reqd_yn result_auth_reqd_yn,InitCap(OR_GET_DESC.OR_ORDER_TYPE(e.order_type_code,?,'2'))  order_type_desc, /*or_performing_facility_id(?,?,?,a.order_category,a.order_type_code,a.order_catalog_code)*/ g.performing_facility_id performing_facility_id,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,OR_GET_FORMAT_ID(a.order_category,a.order_type_code,a.order_catalog_code) format_id_mandatory,b.contr_msr_panel_id contr_msr_panel_id,b.contr_mod_id contr_mod_id, g.performing_deptloc_code performing_deptloc_code,a.order_catalog_nature order_catalog_nature,a.bill_yn bill_yn ,b.qty_reqd_yn qty_reqd_yn,b.chk_for_dupl_yn chk_for_dupl_yn,b.chk_for_dupl_status chk_for_dupl_status,b.activity_type activity_type,b.check_for_dupl_level check_for_dupl_level, b.chk_for_dupl_ahead_action chk_for_dupl_ahead_action,b.chk_for_dupl_ahead_period chk_for_dupl_ahead_period,b.chk_for_dupl_ahead_unit chk_for_dupl_ahead_unit,b.chk_for_dupl_behind_action chk_for_dupl_behind_action, b.chk_for_dupl_behind_period chk_for_dupl_behind_period,b.chk_for_dupl_behind_unit chk_for_dupl_behind_unit,b.result_applicable_yn result_applicable_yn,b.bill_yn bill_yn,b.appt_reqd_yn appt_reqd_yn, a.appt_ref_num appt_ref_num,to_char(a.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time, b.cont_order_yn cont_order_yn,b.chart_result_type chart_result_type,a.result_auth_reqd_yn result_auth_reqd_yn, 'N' complete_on_order_yn, 'N' ord_spl_appr_reqd_yn,b.stat_appt_reqd_yn  stat_appt_reqd_yn,b.urgent_appt_reqd_yn urgent_appt_reqd_yn,b.routine_appt_reqd_yn  routine_appt_reqd_yn, b.routine_chk_for_dupl_yn routine_chk_for_dupl_yn, b.urgent_chk_for_dupl_yn urgent_chk_for_dupl_yn, b.stat_chk_for_dupl_yn stat_chk_for_dupl_yn,b.consent_stage consent_stage,b.explanatory_text explanatory_text,b.auto_report_yn auto_report_yn, a.num_of_consent_req_bo num_of_consent_req_bo, a.num_of_consent_req_br num_of_consent_req_br,g.order_set_id order_set_id,a.order_set_line_num order_set_line_num,b.clin_cmts_reqd_yn clin_cmts_reqd_yn, a.future_order_yn future_order_yn,OR_GET_PRIV_APPL_YN(?,?,'AU',a.order_catalog_code,?) can_authorise_yn,a.future_order_charge_later_yn  future_order_charge_later_yn,OR_OPERATIONAL_MODULE (? ,b.order_category,b.result_applicable_yn,b.contr_mod_id,b.contr_msr_panel_id,b.discr_msr_panel_id,b.complete_on_order_yn,b.order_catalog_code,b.order_type_code,b.order_catalog_nature) OR_OPERATIONAL_MODULE_YN,b.freq_applicable_yn freq_applicable_yn,a.rep_group_ref rep_group_ref,g.trn_group_ref trn_group_ref FROM or_order_line a, or_order_catalog b,or_order_catalog_synonym c,or_order_catalog_by_ptcl d ,or_order_type e, or_order g WHERE a.order_id = ? AND a.order_id = g.order_id AND  a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code AND a.order_type_code = e.order_type_code AND  catalog_synonym_type  = OR_GET_SYNONYM_TYPE(CASE WHEN g.ord_pract_id IN (SELECT practitioner_id  FROM am_practitioner) THEN (SELECT pract_type FROM am_practitioner  WHERE practitioner_id = g.ord_pract_id) ELSE (SELECT pract_type FROM am_ext_practitioner  WHERE practitioner_id = g.ord_pract_id) END,a.order_catalog_code) AND d.patient_class = OR_PATIENT_FOR_REVIEW_SETTING( ?,a.order_catalog_code) AND order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type='99')");
				//pstmt		= connection.prepareStatement("SELECT a.order_id order_id,order_line_num,a.order_catalog_code  order_catalog_code,a.order_type_code order_type_code, a.order_category order_category ,a.ord_date_time ord_date_time,a.priority  priority,a.ord_auth_reqd_yn ord_auth_reqd_yn,a.ord_appr_reqd_yn ord_appr_reqd_yn ,a.ord_cosign_reqd_yn ord_cosign_reqd_yn , TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,a.qty_value qty_value,a.qty_unit qty_unit,am_get_desc.am_uom(a.qty_unit,?,2) short_desc,a.freq_code freq_code,a.durn_value durn_value ,a.durn_type durn_type,a.item_narration item_narration,end_date_time,a.order_qty order_qty ,a.cont_order_ind cont_order_ind,a.ord_pract_id ord_pract_id,order_line_status ,a.ord_consent_reqd_yn  ord_consent_reqd_yn,b.qty_uom qty_uom,nvl(am_get_desc.am_practitioner (g.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (g.ord_pract_id,?,'1'))  practitioner_name , OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(c.ORDER_CATALOG_CODE,c.CATALOG_SYNONYM_TYPE,?,'1') catalog_synonym,a.result_auth_reqd_yn result_auth_reqd_yn,InitCap(OR_GET_DESC.OR_ORDER_TYPE(e.order_type_code,?,'2'))  order_type_desc, /*or_performing_facility_id(?,?,?,a.order_category,a.order_type_code,a.order_catalog_code)*/ g.performing_facility_id performing_facility_id,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,OR_GET_FORMAT_ID(a.order_category,a.order_type_code,a.order_catalog_code) format_id_mandatory,b.contr_msr_panel_id contr_msr_panel_id,b.contr_mod_id contr_mod_id, g.performing_deptloc_code performing_deptloc_code,a.order_catalog_nature order_catalog_nature,a.bill_yn bill_yn ,b.qty_reqd_yn qty_reqd_yn,b.chk_for_dupl_yn chk_for_dupl_yn,b.chk_for_dupl_status chk_for_dupl_status,b.activity_type activity_type,b.check_for_dupl_level check_for_dupl_level, b.chk_for_dupl_ahead_action chk_for_dupl_ahead_action,b.chk_for_dupl_ahead_period chk_for_dupl_ahead_period,b.chk_for_dupl_ahead_unit chk_for_dupl_ahead_unit,b.chk_for_dupl_behind_action chk_for_dupl_behind_action, b.chk_for_dupl_behind_period chk_for_dupl_behind_period,b.chk_for_dupl_behind_unit chk_for_dupl_behind_unit,b.result_applicable_yn result_applicable_yn,b.bill_yn bill_yn,b.appt_reqd_yn appt_reqd_yn, a.appt_ref_num appt_ref_num,to_char(a.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time, b.cont_order_yn cont_order_yn,b.chart_result_type chart_result_type,a.result_auth_reqd_yn result_auth_reqd_yn, 'N' complete_on_order_yn, 'N' ord_spl_appr_reqd_yn,b.stat_appt_reqd_yn  stat_appt_reqd_yn,b.urgent_appt_reqd_yn urgent_appt_reqd_yn,b.routine_appt_reqd_yn  routine_appt_reqd_yn, b.routine_chk_for_dupl_yn routine_chk_for_dupl_yn, b.urgent_chk_for_dupl_yn urgent_chk_for_dupl_yn, b.stat_chk_for_dupl_yn stat_chk_for_dupl_yn,b.consent_stage consent_stage,b.explanatory_text explanatory_text,b.auto_report_yn auto_report_yn, a.num_of_consent_req_bo num_of_consent_req_bo, a.num_of_consent_req_br num_of_consent_req_br,g.order_set_id order_set_id,a.order_set_line_num order_set_line_num,b.clin_cmts_reqd_yn clin_cmts_reqd_yn, a.future_order_yn future_order_yn,OR_GET_PRIV_APPL_YN(?,?,'AU',a.order_catalog_code,?) can_authorise_yn,a.future_order_charge_later_yn  future_order_charge_later_yn,OR_OPERATIONAL_MODULE (? ,b.order_category,b.result_applicable_yn,b.contr_mod_id,b.contr_msr_panel_id,b.discr_msr_panel_id,b.complete_on_order_yn,b.order_catalog_code,b.order_type_code,b.order_catalog_nature) OR_OPERATIONAL_MODULE_YN,b.freq_applicable_yn freq_applicable_yn,a.rep_group_ref rep_group_ref,g.trn_group_ref trn_group_ref,a.barcode_appl FROM or_order_line a, or_order_catalog b,or_order_catalog_synonym c,or_order_catalog_by_ptcl d ,or_order_type e, or_order g WHERE a.order_id = ? AND a.order_id = g.order_id AND  a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code AND a.order_type_code = e.order_type_code AND  catalog_synonym_type  = OR_GET_SYNONYM_TYPE(CASE WHEN g.ord_pract_id IN (SELECT practitioner_id  FROM am_practitioner) THEN (SELECT pract_type FROM am_practitioner  WHERE practitioner_id = g.ord_pract_id) ELSE (SELECT pract_type FROM am_ext_practitioner  WHERE practitioner_id = g.ord_pract_id) END,a.order_catalog_code) AND d.patient_class = OR_PATIENT_FOR_REVIEW_SETTING( ?,a.order_catalog_code) AND order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type='99')");
				//pstmt		= connection.prepareStatement("SELECT a.order_id order_id,order_line_num,a.order_catalog_code  order_catalog_code,a.order_type_code order_type_code, a.order_category order_category ,a.ord_date_time ord_date_time,a.priority  priority,a.ord_auth_reqd_yn ord_auth_reqd_yn,a.ord_appr_reqd_yn ord_appr_reqd_yn ,a.ord_cosign_reqd_yn ord_cosign_reqd_yn , TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,a.qty_value qty_value,a.qty_unit qty_unit,am_get_desc.am_uom(a.qty_unit,?,2) short_desc,a.freq_code freq_code,a.durn_value durn_value ,a.durn_type durn_type,a.item_narration item_narration,end_date_time,a.order_qty order_qty ,a.cont_order_ind cont_order_ind,a.ord_pract_id ord_pract_id,order_line_status ,a.ord_consent_reqd_yn  ord_consent_reqd_yn,b.qty_uom qty_uom,nvl(am_get_desc.am_practitioner (g.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (g.ord_pract_id,?,'1'))  practitioner_name , OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(c.ORDER_CATALOG_CODE,c.CATALOG_SYNONYM_TYPE,?,'1') catalog_synonym,a.result_auth_reqd_yn result_auth_reqd_yn,InitCap(OR_GET_DESC.OR_ORDER_TYPE(e.order_type_code,?,'2'))  order_type_desc, /*or_performing_facility_id(?,?,?,a.order_category,a.order_type_code,a.order_catalog_code)*/ g.performing_facility_id performing_facility_id,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,OR_GET_FORMAT_ID(a.order_category,a.order_type_code,a.order_catalog_code) format_id_mandatory,b.contr_msr_panel_id contr_msr_panel_id,b.contr_mod_id contr_mod_id, g.performing_deptloc_code performing_deptloc_code,a.order_catalog_nature order_catalog_nature,a.bill_yn bill_yn ,b.qty_reqd_yn qty_reqd_yn,b.chk_for_dupl_yn chk_for_dupl_yn,b.chk_for_dupl_status chk_for_dupl_status,b.activity_type activity_type,b.check_for_dupl_level check_for_dupl_level, b.chk_for_dupl_ahead_action chk_for_dupl_ahead_action,b.chk_for_dupl_ahead_period chk_for_dupl_ahead_period,b.chk_for_dupl_ahead_unit chk_for_dupl_ahead_unit,b.chk_for_dupl_behind_action chk_for_dupl_behind_action, b.chk_for_dupl_behind_period chk_for_dupl_behind_period,b.chk_for_dupl_behind_unit chk_for_dupl_behind_unit,b.result_applicable_yn result_applicable_yn,b.bill_yn bill_yn,b.appt_reqd_yn appt_reqd_yn, a.appt_ref_num appt_ref_num,to_char(a.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time, b.cont_order_yn cont_order_yn,b.chart_result_type chart_result_type,a.result_auth_reqd_yn result_auth_reqd_yn, 'N' complete_on_order_yn, 'N' ord_spl_appr_reqd_yn,b.stat_appt_reqd_yn  stat_appt_reqd_yn,b.urgent_appt_reqd_yn urgent_appt_reqd_yn,b.routine_appt_reqd_yn  routine_appt_reqd_yn, b.routine_chk_for_dupl_yn routine_chk_for_dupl_yn, b.urgent_chk_for_dupl_yn urgent_chk_for_dupl_yn, b.stat_chk_for_dupl_yn stat_chk_for_dupl_yn,b.consent_stage consent_stage,b.explanatory_text explanatory_text,b.auto_report_yn auto_report_yn, a.num_of_consent_req_bo num_of_consent_req_bo, a.num_of_consent_req_br num_of_consent_req_br,g.order_set_id order_set_id,a.order_set_line_num order_set_line_num,b.clin_cmts_reqd_yn clin_cmts_reqd_yn, a.future_order_yn future_order_yn,OR_GET_PRIV_APPL_YN(?,?,'AU',a.order_catalog_code,?) can_authorise_yn,a.future_order_charge_later_yn  future_order_charge_later_yn,OR_OPERATIONAL_MODULE (? ,b.order_category,b.result_applicable_yn,b.contr_mod_id,b.contr_msr_panel_id,b.discr_msr_panel_id,b.complete_on_order_yn,b.order_catalog_code,b.order_type_code,b.order_catalog_nature) OR_OPERATIONAL_MODULE_YN,b.freq_applicable_yn freq_applicable_yn,a.rep_group_ref rep_group_ref,g.trn_group_ref trn_group_ref,a.barcode_appl,nvl(a.instruction_type,'T')instruction_type,item_narration_free_fmt FROM or_order_line a, or_order_catalog b,or_order_catalog_synonym c,or_order_catalog_by_ptcl d ,or_order_type e, or_order g WHERE a.order_id = ? AND a.order_id = g.order_id AND  a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code AND a.order_type_code = e.order_type_code AND  catalog_synonym_type  = OR_GET_SYNONYM_TYPE(CASE WHEN g.ord_pract_id IN (SELECT practitioner_id  FROM am_practitioner) THEN (SELECT pract_type FROM am_practitioner  WHERE practitioner_id = g.ord_pract_id) ELSE (SELECT pract_type FROM am_ext_practitioner  WHERE practitioner_id = g.ord_pract_id) END,a.order_catalog_code) AND d.patient_class = OR_PATIENT_FOR_REVIEW_SETTING( ?,a.order_catalog_code) AND order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type='99')");//IN068314
				//pstmt		= connection.prepareStatement("SELECT a.order_id order_id,order_line_num,a.order_catalog_code  order_catalog_code,a.order_type_code order_type_code, a.order_category order_category ,a.ord_date_time ord_date_time,a.priority  priority,a.ord_auth_reqd_yn ord_auth_reqd_yn,a.ord_appr_reqd_yn ord_appr_reqd_yn ,a.ord_cosign_reqd_yn ord_cosign_reqd_yn , TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,a.qty_value qty_value,a.qty_unit qty_unit,am_get_desc.am_uom(a.qty_unit,?,2) short_desc,a.freq_code freq_code,a.durn_value durn_value ,a.durn_type durn_type,a.item_narration item_narration,end_date_time,a.order_qty order_qty ,a.cont_order_ind cont_order_ind,a.ord_pract_id ord_pract_id,order_line_status ,a.ord_consent_reqd_yn  ord_consent_reqd_yn,b.qty_uom qty_uom,nvl(am_get_desc.am_practitioner (g.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (g.ord_pract_id,?,'1'))  practitioner_name , OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(c.ORDER_CATALOG_CODE,c.CATALOG_SYNONYM_TYPE,?,'1') catalog_synonym,a.result_auth_reqd_yn result_auth_reqd_yn,InitCap(OR_GET_DESC.OR_ORDER_TYPE(e.order_type_code,?,'2'))  order_type_desc, /*or_performing_facility_id(?,?,?,a.order_category,a.order_type_code,a.order_catalog_code)*/ g.performing_facility_id performing_facility_id,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,OR_GET_FORMAT_ID(a.order_category,a.order_type_code,a.order_catalog_code) format_id_mandatory,b.contr_msr_panel_id contr_msr_panel_id,b.contr_mod_id contr_mod_id, g.performing_deptloc_code performing_deptloc_code,a.order_catalog_nature order_catalog_nature,a.bill_yn bill_yn ,b.qty_reqd_yn qty_reqd_yn,b.chk_for_dupl_yn chk_for_dupl_yn,b.chk_for_dupl_status chk_for_dupl_status,b.activity_type activity_type,b.check_for_dupl_level check_for_dupl_level, b.chk_for_dupl_ahead_action chk_for_dupl_ahead_action,b.chk_for_dupl_ahead_period chk_for_dupl_ahead_period,b.chk_for_dupl_ahead_unit chk_for_dupl_ahead_unit,b.chk_for_dupl_behind_action chk_for_dupl_behind_action, b.chk_for_dupl_behind_period chk_for_dupl_behind_period,b.chk_for_dupl_behind_unit chk_for_dupl_behind_unit,b.result_applicable_yn result_applicable_yn,b.bill_yn bill_yn,b.appt_reqd_yn appt_reqd_yn, a.appt_ref_num appt_ref_num,to_char(a.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time, b.cont_order_yn cont_order_yn,b.chart_result_type chart_result_type,a.result_auth_reqd_yn result_auth_reqd_yn, 'N' complete_on_order_yn, 'N' ord_spl_appr_reqd_yn,b.stat_appt_reqd_yn  stat_appt_reqd_yn,b.urgent_appt_reqd_yn urgent_appt_reqd_yn,b.routine_appt_reqd_yn  routine_appt_reqd_yn, b.routine_chk_for_dupl_yn routine_chk_for_dupl_yn, b.urgent_chk_for_dupl_yn urgent_chk_for_dupl_yn, b.stat_chk_for_dupl_yn stat_chk_for_dupl_yn,b.consent_stage consent_stage,b.explanatory_text explanatory_text,b.auto_report_yn auto_report_yn, a.num_of_consent_req_bo num_of_consent_req_bo, a.num_of_consent_req_br num_of_consent_req_br,g.order_set_id order_set_id,a.order_set_line_num order_set_line_num,b.clin_cmts_reqd_yn clin_cmts_reqd_yn, a.future_order_yn future_order_yn,OR_GET_PRIV_APPL_YN(?,?,'AU',a.order_catalog_code,?) can_authorise_yn,a.future_order_charge_later_yn  future_order_charge_later_yn,OR_OPERATIONAL_MODULE (? ,b.order_category,b.result_applicable_yn,b.contr_mod_id,b.contr_msr_panel_id,b.discr_msr_panel_id,b.complete_on_order_yn,b.order_catalog_code,b.order_type_code,b.order_catalog_nature) OR_OPERATIONAL_MODULE_YN,b.freq_applicable_yn freq_applicable_yn,a.rep_group_ref rep_group_ref,g.trn_group_ref trn_group_ref,a.barcode_appl,nvl(a.instruction_type,'T')instruction_type,item_narration_free_fmt,a.fpp_yn, a.fpp_category FROM or_order_line a, or_order_catalog b,or_order_catalog_synonym c,or_order_catalog_by_ptcl d ,or_order_type e, or_order g WHERE a.order_id = ? AND a.order_id = g.order_id AND  a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code AND a.order_type_code = e.order_type_code AND  catalog_synonym_type  = OR_GET_SYNONYM_TYPE(CASE WHEN g.ord_pract_id IN (SELECT practitioner_id  FROM am_practitioner) THEN (SELECT pract_type FROM am_practitioner  WHERE practitioner_id = g.ord_pract_id) ELSE (SELECT pract_type FROM am_ext_practitioner  WHERE practitioner_id = g.ord_pract_id) END,a.order_catalog_code) AND d.patient_class = OR_PATIENT_FOR_REVIEW_SETTING( ?,a.order_catalog_code) AND order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type='99')");//IN068314//14699
				//IN063816 ends
				pstmt		= connection.prepareStatement("SELECT a.order_id order_id,order_line_num,a.order_catalog_code  order_catalog_code,a.order_type_code order_type_code, a.order_category order_category ,a.ord_date_time ord_date_time,a.priority  priority,a.ord_auth_reqd_yn ord_auth_reqd_yn,a.ord_appr_reqd_yn ord_appr_reqd_yn ,a.ord_cosign_reqd_yn ord_cosign_reqd_yn , TO_CHAR(start_date_time,'dd/mm/yyyy hh24:mi') start_date_time,a.qty_value qty_value,a.qty_unit qty_unit,am_get_desc.am_uom(a.qty_unit,?,2) short_desc,a.freq_code freq_code,a.durn_value durn_value ,a.durn_type durn_type,a.item_narration item_narration,end_date_time,a.order_qty order_qty ,a.cont_order_ind cont_order_ind,a.ord_pract_id ord_pract_id,order_line_status ,a.ord_consent_reqd_yn  ord_consent_reqd_yn,b.qty_uom qty_uom,nvl(am_get_desc.am_practitioner (g.ord_pract_id,?,'1'), am_get_desc.am_ext_practitioner (g.ord_pract_id,?,'1'))  practitioner_name , OR_GET_DESC.OR_CATALOG_SYNONYM_LANG(c.ORDER_CATALOG_CODE,c.CATALOG_SYNONYM_TYPE,?,'1') catalog_synonym,a.result_auth_reqd_yn result_auth_reqd_yn,InitCap(OR_GET_DESC.OR_ORDER_TYPE(e.order_type_code,?,'2'))  order_type_desc, /*or_performing_facility_id(?,?,?,a.order_category,a.order_type_code,a.order_catalog_code)*/ g.performing_facility_id performing_facility_id,b.pat_instrn_age_sex_yn pat_instrn_age_sex_yn,OR_GET_FORMAT_ID(a.order_category,a.order_type_code,a.order_catalog_code) format_id_mandatory,b.contr_msr_panel_id contr_msr_panel_id,b.contr_mod_id contr_mod_id, g.performing_deptloc_code performing_deptloc_code,a.order_catalog_nature order_catalog_nature,a.bill_yn bill_yn ,b.qty_reqd_yn qty_reqd_yn,b.chk_for_dupl_yn chk_for_dupl_yn,b.chk_for_dupl_status chk_for_dupl_status,b.activity_type activity_type,b.check_for_dupl_level check_for_dupl_level, b.chk_for_dupl_ahead_action chk_for_dupl_ahead_action,b.chk_for_dupl_ahead_period chk_for_dupl_ahead_period,b.chk_for_dupl_ahead_unit chk_for_dupl_ahead_unit,b.chk_for_dupl_behind_action chk_for_dupl_behind_action, b.chk_for_dupl_behind_period chk_for_dupl_behind_period,b.chk_for_dupl_behind_unit chk_for_dupl_behind_unit,b.result_applicable_yn result_applicable_yn,b.bill_yn bill_yn,b.appt_reqd_yn appt_reqd_yn, a.appt_ref_num appt_ref_num,to_char(a.appt_date_time,'dd/mm/yyyy hh24:mi') appt_date_time, b.cont_order_yn cont_order_yn,b.chart_result_type chart_result_type,a.result_auth_reqd_yn result_auth_reqd_yn, 'N' complete_on_order_yn, a.ORD_APPR_REQD_YN ord_spl_appr_reqd_yn,b.stat_appt_reqd_yn  stat_appt_reqd_yn,b.urgent_appt_reqd_yn urgent_appt_reqd_yn,b.routine_appt_reqd_yn  routine_appt_reqd_yn, b.routine_chk_for_dupl_yn routine_chk_for_dupl_yn, b.urgent_chk_for_dupl_yn urgent_chk_for_dupl_yn, b.stat_chk_for_dupl_yn stat_chk_for_dupl_yn,b.consent_stage consent_stage,b.explanatory_text explanatory_text,b.auto_report_yn auto_report_yn, a.num_of_consent_req_bo num_of_consent_req_bo, a.num_of_consent_req_br num_of_consent_req_br,g.order_set_id order_set_id,a.order_set_line_num order_set_line_num,b.clin_cmts_reqd_yn clin_cmts_reqd_yn, a.future_order_yn future_order_yn,OR_GET_PRIV_APPL_YN(?,?,'AU',a.order_catalog_code,?) can_authorise_yn,a.future_order_charge_later_yn  future_order_charge_later_yn,OR_OPERATIONAL_MODULE (? ,b.order_category,b.result_applicable_yn,b.contr_mod_id,b.contr_msr_panel_id,b.discr_msr_panel_id,b.complete_on_order_yn,b.order_catalog_code,b.order_type_code,b.order_catalog_nature) OR_OPERATIONAL_MODULE_YN,b.freq_applicable_yn freq_applicable_yn,a.rep_group_ref rep_group_ref,g.trn_group_ref trn_group_ref,a.barcode_appl,nvl(a.instruction_type,'T')instruction_type,item_narration_free_fmt,a.fpp_yn, a.fpp_category FROM or_order_line a, or_order_catalog b,or_order_catalog_synonym c,or_order_catalog_by_ptcl d ,or_order_type e, or_order g WHERE a.order_id = ? AND a.order_id = g.order_id AND  a.order_catalog_code = b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code AND a.order_type_code = e.order_type_code AND  catalog_synonym_type  = OR_GET_SYNONYM_TYPE(CASE WHEN g.ord_pract_id IN (SELECT practitioner_id  FROM am_practitioner) THEN (SELECT pract_type FROM am_practitioner  WHERE practitioner_id = g.ord_pract_id) ELSE (SELECT pract_type FROM am_ext_practitioner  WHERE practitioner_id = g.ord_pract_id) END,a.order_catalog_code) AND d.patient_class = OR_PATIENT_FOR_REVIEW_SETTING( ?,a.order_catalog_code) AND order_line_status NOT IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type='99')");//IN068314//14699
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, language_id);
				pstmt.setString(4, language_id);
				pstmt.setString(5, language_id);
			//	pstmt.setString(5, login_facility_id);
			//	pstmt.setString(6, getLocationType());	// source_type
			//	pstmt.setString(7, getLocationCode());  // source_code
				/*Added by Uma on 8/25/2009 for PMG20089 - CRF 641*/
				pstmt.setString(6 , getLoginById());		//P_LOGIN_PRACTITIONER_ID
				pstmt.setString(7 , getResponsibilityId());		//P_RESP_ID
				pstmt.setString(8 , getAuthorisationOrOrderingYn("AUT"));		//P_PRIV_APPL_YN
				/* End Here*/
				pstmt.setString(9, login_facility_id);//Added by Uma on 4/10/2010 for performance tuning
				pstmt.setString(10, order_id.trim());
				pstmt.setString(11, getPatientClass());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						//record 	  = new String[78];//IN063816
						//record 	  = new String[79];//IN063816	
						record 	  = new String[82];//IN064543		//IN068314		
						record[0] = checkForNull(resultSet.getString( "order_id" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "order_line_num" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_type_code"),"")  ;
						record[4] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "ord_date_time" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "priority" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "ord_auth_reqd_yn" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "ord_appr_reqd_yn" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "ord_cosign_reqd_yn" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "start_date_time" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "qty_value" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "qty_unit" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "freq_code" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "durn_value" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "durn_type" ),"")  ;
						record[16] = checkForNull(resultSet.getString( "item_narration" ),"")  ;
						record[17] = checkForNull(resultSet.getString( "end_date_time" ),"")  ;
						record[18] = checkForNull(resultSet.getString( "order_qty" ),"")  ;
						record[19] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;
						record[20] = checkForNull(resultSet.getString( "ord_pract_id" ),"")  ;
						record[21] = checkForNull(resultSet.getString( "order_line_status" ),"")  ;
						record[22] = checkForNull(resultSet.getString( "ord_consent_reqd_yn" ),"")  ;
						record[23] = checkForNull(resultSet.getString( "practitioner_name" ),"")  ;
						record[24] = checkForNull(resultSet.getString( "catalog_synonym" ),"")  ;
						record[25] = checkForNull(resultSet.getString( "result_auth_reqd_yn" ),"")  ;
						record[26] = checkForNull(resultSet.getString( "order_type_desc" ),"")  ;
						record[27] = checkForNull(resultSet.getString( "performing_facility_id" ),"")  ;
						record[28] = checkForNull(resultSet.getString( "pat_instrn_age_sex_yn" ),"")  ;
						record[29] = checkForNull(resultSet.getString( "format_id_mandatory" ),"")  ;
						record[30] = checkForNull(resultSet.getString( "contr_msr_panel_id" ),"")  ;
						record[31] = checkForNull(resultSet.getString( "performing_deptloc_code" ),"")  ;
						record[32] = checkForNull(resultSet.getString( "order_catalog_nature" ),"")  ;
						record[33] = checkForNull(resultSet.getString( "bill_yn" ),"")  ;
						record[34] = checkForNull(resultSet.getString( "qty_reqd_yn" ),"N")  ;
						record[35] = checkForNull(resultSet.getString( "qty_uom" ),"")  ;
						record[36] = checkForNull(resultSet.getString( "chk_for_dupl_yn" ),"N")  ;
						record[37] = checkForNull(resultSet.getString( "chk_for_dupl_status" ),"")  ;
						record[38] = checkForNull(resultSet.getString( "activity_type" ),"")  ;
						record[39] = checkForNull(resultSet.getString( "check_for_dupl_level" ),"")  ;
						record[40] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_action" ),"") ;
						record[41] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_period" ),"")  ;
						record[42] = checkForNull(resultSet.getString( "chk_for_dupl_ahead_unit" ),"")  ;
						record[43] = checkForNull(resultSet.getString( "chk_for_dupl_behind_action" ),"")  ;
						record[44] = checkForNull(resultSet.getString( "chk_for_dupl_behind_period" ),"") ;
						record[45] = checkForNull(resultSet.getString( "chk_for_dupl_behind_unit" ),"")  ;
						record[46] = checkForNull(resultSet.getString( "result_applicable_yn" ),"N")  ;
						record[47] = checkForNull(resultSet.getString( "bill_yn" ),"N")  ;
						record[48] = checkForNull(resultSet.getString( "appt_reqd_yn" ),"N")  ;
						record[49] = checkForNull(resultSet.getString( "result_auth_reqd_yn" ),"")  ;
						record[50] = checkForNull(resultSet.getString( "cont_order_yn" ),"")  ;
						record[51] = checkForNull(resultSet.getString( "complete_on_order_yn" ),"N")  ;
						record[52] = checkForNull(resultSet.getString( "ord_spl_appr_reqd_yn" ),"N")  ;
						record[53] = checkForNull(resultSet.getString( "chart_result_type" ),"D")  ;
						record[54] = checkForNull(resultSet.getString( "appt_ref_num" ),"")  ;
						record[55] = checkForNull(resultSet.getString( "appt_date_time" ),"")  ;
						record[56] = checkForNull(resultSet.getString( "routine_appt_reqd_yn" ),"N")  ;
						record[57] = checkForNull(resultSet.getString( "stat_appt_reqd_yn" ),"N")  ;
						record[58] = checkForNull(resultSet.getString( "urgent_appt_reqd_yn" ),"N")  ;
						record[59] = checkForNull(resultSet.getString( "contr_mod_id" ),"")  ;
						record[60] = checkForNull(resultSet.getString( "routine_chk_for_dupl_yn" ),"N")  ;
						record[61] = checkForNull(resultSet.getString( "urgent_chk_for_dupl_yn" ),"N")  ;
						record[62] = checkForNull(resultSet.getString( "stat_chk_for_dupl_yn" ),"N")  ;
						record[63] = checkForNull(resultSet.getString( "consent_stage" ),"")  ;
						record[64] = checkForNull(resultSet.getString( "explanatory_text" ),"")  ;
						record[65] = checkForNull(resultSet.getString( "auto_report_yn" ),"N")  ;
						//added on 08/05/07
						record[66] = checkForNull(resultSet.getString( "num_of_consent_req_bo" ),"0")  ;
						record[67] = checkForNull(resultSet.getString( "num_of_consent_req_br" ),"0")  ;
						record[68] = checkForNull(resultSet.getString( "order_set_id"),"")  ;
						record[69] = checkForNull(resultSet.getString( "order_set_line_num"),"")  ;
						record[70] = checkForNull(resultSet.getString( "clin_cmts_reqd_yn"),"")  ;
						record[71] = checkForNull(resultSet.getString( "future_order_yn"),"")  ;
						record[72] = checkForNull(resultSet.getString( "can_authorise_yn"),"")  ;
						record[73] = checkForNull(resultSet.getString( "short_desc"),"")  ;
						//upto here
						record[74] = checkForNull(resultSet.getString( "OR_OPERATIONAL_MODULE_YN"),"")  ;//Added by Uma on 4/10/2010 for performance tuning
						record[75] = checkForNull(resultSet.getString( "freq_applicable_yn"),"")  ;
						record[76] = checkForNull(resultSet.getString( "rep_group_ref"),"")  ;
						record[77] = checkForNull(resultSet.getString( "trn_group_ref"),"")  ;
						record[78] = checkForNull(resultSet.getString( "barcode_appl"),"N")  ;//IN063816
						record[79] = checkForNull(resultSet.getString( "instruction_type"),"T");//IN64543
						//IN64543, starts
						if("E".equals(record[79]))
						record[16] = resultSet.getString( "item_narration_free_fmt");
						//IN64543, ends		
						//IN068314 Starts
						record[80] = resultSet.getString( "fpp_yn");
						record[81] = resultSet.getString( "fpp_category");
						//IN068314 Ends
						AmendPlaceOrder.add(record) ;

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
			return AmendPlaceOrder;
	}	 // End of the getAmendPlaceOrdersResult

	// Get the Specimen type and Nurse Collect if lab is installed.
	public ArrayList getSpecimenNurseValue(String order_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
	    ArrayList SpecimenNurseValue= new ArrayList() ;
		try
		{			
			connection	= getConnection();
			pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_PLACE_SPECIMEN_NURSE_SELECT"));
			pstmt.setString(1, order_id.trim());
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				String[] record = null;
				while(resultSet.next())
				{
					record 	  = new String[2];

					record[0] = checkForNull(resultSet.getString( "specimen_type" ),"")  ;
					record[1] = checkForNull(resultSet.getString( "specimen_collect_yn" ),"N")  ;
					SpecimenNurseValue.add(record) ;
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
		return SpecimenNurseValue;
    }

	// To get the Preps in the Line Level in the Amend Order(Place Order Screen)
	public String getAmendPreps(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String preps_instrn			= "";
		String order_line_fld_value_ins_type = "";//IN64543
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PREP_DATA"));
				pstmt.setString(1, order_id);
				pstmt.setString(2, order_line_num);
				pstmt.setString(3, order_id);//IN64543
				pstmt.setString(4, order_line_num);//IN64543
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // One record  for the Preps.
				{
					while(resultSet.next())
					{
						//IN64543, starts
						//preps_instrn = checkForNull(resultSet.getString( "order_line_field_value" ),"");
						order_line_fld_value_ins_type = checkForNull(resultSet.getString( "order_line_fld_value_ins_type" ),"T");
						if("T".equals(order_line_fld_value_ins_type))
							preps_instrn = checkForNull(resultSet.getString( "order_line_field_value" ),"");
						else
							preps_instrn = checkForNull(resultSet.getString( "order_line_fld_value_free_fmt" ),"");
						//IN64543, ends
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
			return preps_instrn;
	}	 // End of the getAmendPreps

	// To get the Depts in the Line Level in the Amend Order
	public String getAmendDepts(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String depts_instrn			= "";
		String order_line_fld_value_ins_type = "";//IN64543
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_DEPT_SELECT"));
				pstmt.setString(1, order_id);
				pstmt.setString(2, order_line_num);
				pstmt.setString(3, order_id);//IN64543
				pstmt.setString(4, order_line_num);//IN64543
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // One record  for the Preps.
				{
					while(resultSet.next())
					{
						//IN64543, starts
						//depts_instrn = checkForNull(resultSet.getString( "order_line_field_value" ),"")  ;
						order_line_fld_value_ins_type = checkForNull(resultSet.getString( "order_line_fld_value_ins_type" ),"T");
						if("T".equals(order_line_fld_value_ins_type))
							depts_instrn = checkForNull(resultSet.getString( "order_line_field_value" ),"")  ;
						else
							depts_instrn = checkForNull(resultSet.getString( "order_line_fld_value_free_fmt" ),"")  ;
						//IN64543, ends
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
			return depts_instrn;
}	 // End of the getAmendDepts

	// To get the Patient Instruction in the Line Level in the Amend Order / COPY Order
	public String getAmendPatientInstrn(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String depts_instrn			= "";
		String order_line_fld_value_ins_type = "";//IN64543
		
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_PAT_INSTN_DATA"));
				pstmt.setString(1, order_id);
				pstmt.setString(2, order_line_num);
				pstmt.setString(3, order_id);//IN64543
				pstmt.setString(4, order_line_num);//IN64543
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // One record  for the Preps.
				{
					while(resultSet.next())
					{
						//IN64543, starts
						//depts_instrn = checkForNull(resultSet.getString( "order_line_field_value" ),"");
						order_line_fld_value_ins_type = checkForNull(resultSet.getString( "order_line_fld_value_ins_type" ),"T");
						if("T".equals(order_line_fld_value_ins_type))
							depts_instrn = checkForNull(resultSet.getString( "order_line_field_value" ),"");
						else
							depts_instrn = checkForNull(resultSet.getString( "order_line_fld_value_free_fmt" ),"");		
						//IN64543, ends
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
				return depts_instrn;
}	 // End of the getAmendPatientInstrn


// For the Amend Order the records to be displayed in the Header Modified by Uma on 3/12/2010 for IN019169
public ArrayList getAmendPlaceOrderHeader(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList AmendPlaceOrderHdr= new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_PLACE_HEADER"));
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);
				pstmt.setString(3, order_id.trim());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[11];

						record[0] = checkForNull(resultSet.getString( "ord_pract_id" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "priority" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "ord_date_Time" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "practitioner_name"),"")  ;
						record[4] = checkForNull(resultSet.getString( "ordering_facility_id"),"")  ;
						record[5] = checkForNull(resultSet.getString( "encounter_id"),"")  ;
						record[6] = checkForNull(resultSet.getString( "patient_class"),"")  ;
						record[7] = checkForNull(resultSet.getString( "episode_id"),"")  ;
						record[8] = checkForNull(resultSet.getString( "episode_visit_num"),"")  ;
						record[9] = checkForNull(resultSet.getString( "source_type"),"")  ;
						record[10] = checkForNull(resultSet.getString( "source_code"),"")  ;
						AmendPlaceOrderHdr.add(record) ;
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
			return AmendPlaceOrderHdr;
	}	 // End of the getAmendPlaceOrderHeader

	// To get the Amend Clincial Comments,when cmts is clicked in the Place Order header(Amend Function)
	public StringBuffer getAmendComments(String order_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;//String comments = "";
		Clob clob 					= null;
		//java.io.BufferedReader bufferedReader =null;
		StringBuffer clinical_comments = new StringBuffer();
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_AMEND_PLACE_HEADER_CMTS") ) ;
				pstmt.setString(1, (String)order_id.trim());
				resultSet = pstmt.executeQuery() ;
				if( resultSet != null)    // Only one record per order_id
				{
					while(resultSet.next() )
					{
						clinical_comments = new StringBuffer();
						// To get the Data from the Clob
					   	//java.io.InputStream datas = resultSet.getAsciiStream("order_comment");
					   	clob = resultSet.getClob(1);
					   /*	if(clob!=null && (clob.length()>0))
					   	{
					   		bufferedReader = new java.io.BufferedReader(clob.getCharacterStream());
					   		while((comments=bufferedReader.readLine()) != null)	clinical_comments.append(comments+"\n");
							if(clinical_comments!=null && clinical_comments.length()!=0) // Remove the last character
								clinical_comments.delete(clinical_comments.length()-1,clinical_comments.length());*/

							/* int c;
					   	   while ((c = datas.read ()) != -1)
					   	   clinical_comments.append((char)c);
					   	  */

					   /*	}//if(clob!=null) clob.close();
					   	 clob=null;
					   	 bufferedReader.close();*/

						if( (clob!=null) && (clob.length()>0) ){
							clinical_comments.append( clob.getSubString( 1, ((int)clob.length()) ) ) ;
						}
						clob=null;
					}
				}
			} catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			}
			return clinical_comments;
	} // End of getAmendComments

	// Get the count for the Header/Details if already recorded, or take the format_id and get the values(i.e it is for the first time)
	public int getFormatAmendCount(String order_id,String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		int total					= 0;
		try{
				connection	= getConnection();
				if(checkForNull(order_line_num,"").equals("")) // Then For the Header
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_HDR_COUNT"));
					pstmt.setString(1, order_id.trim());
				}
				else
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_FORMAT_AMEND_LINE_COUNT"));
					pstmt.setString(1, order_id.trim());
					pstmt.setString(2, order_line_num.trim());
				}
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
	}	 // End of the getFormatAmendCount
	// ******************************End of Amend*******************************************
  	// To populate the Panels from the Image Frame
	public ArrayList getImagePanels(String order_type_code,String order_category,String image_id,String hot_spot_id, String activity_type,String priv_applicability_yn) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList ImagePanels		= new ArrayList() ;
		String sql = "";
		int reccount = 0;
		Boolean is_ss_order_catlg_fac_wise = isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
		String ss_order_catlg_fac_wise_yn =  is_ss_order_catlg_fac_wise?"Y":"N";//IN068370,IN068373
		try{
				connection	= getConnection();
					sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_IMAGE_ALL_PANELS_POPULATE");
					//pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_IMAGE_ALL_PANELS_POPULATE"));
			if (priv_applicability_yn.equalsIgnoreCase("Y")) {				
				sql =sql.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
				sql =sql.replace("##FILTERPRIV##"," OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");

			} else if (priv_applicability_yn.equalsIgnoreCase("N")) {
				sql = sql.replace("##FILTERCAT##","");
				sql =sql.replace("##FILTERPRIV##","  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn,");

			} else {
				sql = sql.replace("##FILTERCAT##", "");
				sql = sql.replace("##FILTERPRIV##", " 'Y' priv_yn, ");
			}
			// IN068370,IN068373, starts
			if ("Y".equals(ss_order_catlg_fac_wise_yn)) {
				sql = sql.replace("##GLOBALANDLOCAL##"," AND  EXISTS (SELECT 1 FROM OR_ORDER_CATALOG_BY_FACILITY d WHERE d.ORDER_CATALOG_CODE=A.ORDER_CATALOG_CODE AND d.APPLICABLE_FACILITY_ID = ?) ");
			} else {
				sql = sql.replace("##GLOBALANDLOCAL##", "");
			}
			// IN068370,IN068373, end.
			//IN068314 Starts
			if(isfppapplicable){
				if("Y".equals(getFpp_patient_yn())){
					sql = sql.replace("##FILTERFPP##"," AND a.FPP_YN = 'Y' ");
				}else{
					sql = sql.replace("##FILTERFPP##"," AND (a.FPP_YN IS NULL OR a.FPP_YN = 'N') ");
				}
			}
			else{
				sql = sql.replace("##FILTERFPP##","");
			}
			//IN068314 Ends
					pstmt		= connection.prepareStatement(sql);

			pstmt.setString(++reccount, getPractitionerType());
			pstmt.setString(++reccount, language_id);
			pstmt.setString(++reccount, language_id);			


					if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N")))
					{
						pstmt.setString(++reccount , getPractitionerId());		//P_PRACTITIONER_ID
						pstmt.setString(++reccount , getResponsibilityId());		//P_RESP_ID
						pstmt.setString(++reccount , getPrivilegeApplicability());		//P_PRIV_APPL_YN
					}
			pstmt.setString(++reccount, language_id);
			/*
			 * Added by Uma on 8/22/2009 for PMG20089 pstmt.setString(7,
			 * language_id); pstmt.setString(7, language_id); pstmt.setString(7,
			 * language_id);
			 */
			// IN068370,IN068373, starts
			if ("Y".equals(ss_order_catlg_fac_wise_yn))
				pstmt.setString(++reccount, getLoginFacilityId());
			// IN068370,IN068373, end.
					pstmt.setString(++reccount,  getPractitionerType());
					pstmt.setString(++reccount, checkForNull(order_category,""));
					pstmt.setString(++reccount, getPatientClass());
					pstmt.setString(++reccount, getPatientId());
					pstmt.setString(++reccount, getSex());
					pstmt.setString(++reccount, getDob());
					pstmt.setString(++reccount, getPatientClass());
					pstmt.setString(++reccount, getLoginFacilityId());
					pstmt.setString(++reccount, getEncounterId());
					pstmt.setString(++reccount, getPatientClass());
					pstmt.setString(++reccount, getVisitAdmDate());
					pstmt.setString(++reccount, getDischargeDateTime());
					pstmt.setString(++reccount, checkForNull(order_category,""));
					pstmt.setString(++reccount, checkForNull(image_id,""));
					pstmt.setString(++reccount, checkForNull(hot_spot_id,""));
					//pstmt.setString(++reccount, getLoginFacilityId());Commented by Uma on 4/10/2010 for performance tuning
					pstmt.setString(++reccount, checkForNull(order_type_code,""));
					pstmt.setString(++reccount, checkForNull(activity_type,""));
			if (priv_applicability_yn.equalsIgnoreCase("Y")) {
				pstmt.setString(++reccount, getPractitionerId()); // P_PRACTITIONER_ID
				pstmt.setString(++reccount, getResponsibilityId()); // P_RESP_ID
				pstmt.setString(++reccount, getPrivilegeApplicability()); // P_PRIV_APPL_YN				
			}
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[18];
						record[0] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "catalog_synonym" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_category"),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_type_code"),"")  ;
						record[4] = checkForNull(resultSet.getString( "ord_auth_reqd_yn"),"")  ;
						record[5] = checkForNull(resultSet.getString( "ord_cosign_reqd_yn"),"")  ;
						record[6] = checkForNull(resultSet.getString( "ord_spl_appr_reqd_yn"),"")  ;
						record[7] = checkForNull(resultSet.getString( "chart_result_type"),"")  ;
						record[8] = checkForNull(resultSet.getString( "discr_msr_panel_id"),"")  ;
						record[9] = checkForNull(resultSet.getString( "contr_mod_id"),"")  ;
						record[10] = checkForNull(resultSet.getString( "contr_msr_panel_id"),"")  ;
						record[11] = checkForNull(resultSet.getString( "prompt_alert_yn"),"")  ;
						record[12] = checkForNull(resultSet.getString( "prompt_alert_msg"),"")  ;
						record[13] = checkForNull(resultSet.getString( "order_catalog_nature"),"")  ;
						//record[14] = checkForNull(resultSet.getString( "enable_yn"),"")  ;
						record[14] = checkForNull(resultSet.getString( "priv_yn"),"")  ;
						record[15] = checkForNull(resultSet.getString( "explanatory_text"),"")  ;
						record[16] = checkForNull(resultSet.getString( "INVOKE_INSTRN_WINDOW_YN"),"")  ;//IN064543
						record[17] = checkForNull(resultSet.getString( "INSTRN_CONTENT_TYPE"),"")  ;//IN064543
 						ImagePanels.add(record) ;
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
			return ImagePanels;
	}	 // End of the getImagePanels

// For the Painting of the Order Sets in the Place Order
	public ArrayList getPlaceOrderCareSetsCount(String order_catalog_code,String facility_id,String encounter_id,String patient_class,String admission_date,String discharge_date_time,String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList CareSets			= new ArrayList() ;
		//IN037091 starts
		String admission_date1		= "";
		//String admission_date1 = admission_date.substring(0,16);//IN033892
		admission_date = checkForNull(admission_date,"");
		if(admission_date.length() >= 16)
		admission_date1 = admission_date.substring(0,16);
		else
		admission_date1 = admission_date;
		//IN037091 ends
		
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_SET_GROUP_COUNT"));
				pstmt.setString(1,  checkForNull(order_catalog_code,""));
				pstmt.setString(2,  checkForNull(facility_id,""));
				pstmt.setString(3,  checkForNull(encounter_id,""));
				pstmt.setString(4,  checkForNull(patient_class,""));
				//pstmt.setString(5,  checkForNull(admission_date,""));//IN033892
				pstmt.setString(5,  checkForNull(admission_date1,""));//IN033892
				pstmt.setString(6,  checkForNull(discharge_date_time,""));
				pstmt.setString(7,  language_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[3];
						record[0] = checkForNull(resultSet.getString( "count" ),"0")  ;
						record[1] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_category_desc" ),"")  ;
						CareSets.add(record) ;
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
			return CareSets;
	}	 // End of the getPlaceOrderCareSetsCount

	// For the Painting of the Order Sets in the Place Order
	public ArrayList getPlaceOrderCareSets(String order_catalog_code,String order_category,String time_frame) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList CareSets			= new ArrayList() ;
		String careSetSql = "";
		try{
				connection	= getConnection();
				careSetSql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_ORDER_SET_SELECT");
				if(time_frame.equalsIgnoreCase("M"))
				{
					careSetSql = careSetSql.replace("&&ORDERBY##", " ORDER BY CEIL (decode(a.rel_start_date_time,0,1,a.rel_start_date_time)/24),ORDER_SET_SEQ_NUM");
				}
				else if((time_frame.equalsIgnoreCase("C"))||((time_frame.equalsIgnoreCase("T"))))
				{
					careSetSql = careSetSql.replace("&&ORDERBY##", " ORDER BY decode(?,'T',to_char(a.rel_start_date_time),'C',order_category_desc),a.rel_start_date_time,ORDER_SET_SEQ_NUM");
				}
				else
				{
					careSetSql = careSetSql.replace("&&ORDERBY##", " ORDER BY decode('C','T',to_char(a.rel_start_date_time),'C',order_category_desc),a.rel_start_date_time,ORDER_SET_SEQ_NUM");
				}
				pstmt		= connection.prepareStatement(careSetSql);
					pstmt.setString(1, language_id);
					pstmt.setString(2,  checkForNull(order_catalog_code,""));
					pstmt.setString(3,  checkForNull(order_category,""));
					if((time_frame.equalsIgnoreCase("C"))||((time_frame.equalsIgnoreCase("T"))))
					{
					pstmt.setString(4,  checkForNull(time_frame,""));
				}
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[12];
						record[0] = checkForNull(resultSet.getString( "order_category_desc" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "order_category"),"")  ;
						record[4] = checkForNull(resultSet.getString( "order_type_code"),"")  ;
						record[5] = checkForNull(resultSet.getString( "reqd_or_opt_ind"),"")  ;
						record[6] = checkForNull(resultSet.getString( "freq_code"),"")  ;
						record[7] = checkForNull(resultSet.getString( "qty_unit"),"")  ;
						record[8] = checkForNull(resultSet.getString( "durn_value"),"")  ;
						record[9] = checkForNull(resultSet.getString( "durn_type"),"")  ;
						record[10] = checkForNull(resultSet.getString( "rel_start_date_time"),"")  ;
						record[11] = checkForNull(resultSet.getString( "start_time"),"")  ;
						CareSets.add(record) ;
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
			return CareSets;
	}	 // End of the getPlaceOrderCareSets
	// *********************************** Till Here *******************************
	// *********************************** Care Sets Tab ****************************
	public ArrayList getCareSets(String order_category,String diagnosis_code,String diagnosis_code_scheme,  String activity_type,String order_type_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList CareSetList		= new ArrayList() ;
		String priv_applicability_yn = "";
		priv_applicability_yn = (String)getPrivilegeApplicability();
		String sql = "";
		Boolean is_ss_order_catlg_fac_wise = isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
		String ss_order_catlg_fac_wise_yn =  is_ss_order_catlg_fac_wise?"Y":"N";//IN068370,IN068373
		try{
				connection	= getConnection();
			if(diagnosis_code.equals("")){
				// IN068370,IN068373 Start.
				//sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_SELECT");
				if ("Y".equals(ss_order_catlg_fac_wise_yn))
					sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_SELECT_GLOBALANDLOCAL");
				else
					sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_SELECT");
				// IN068370,IN068373 end.
			} else {
				// IN068370,IN068373 Start.
				//sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_DIAG_SELECT");
				if ("Y".equals(ss_order_catlg_fac_wise_yn))
					sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_DIAG_SELECT_GLOBALANDLOCAL");
				else
					sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CARE_SET_DIAG_SELECT");
				// IN068370,IN068373 End.
			}
			if (priv_applicability_yn.equalsIgnoreCase("Y")) {
					sql = sql.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)"); 
					sql = sql.replace("##FILTERSET##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_set_code,?)");//IN061906
			} else {
				sql = sql.replace("##FILTERCAT##", " ");
				sql = sql.replace("##FILTERSET##", " ");// IN061906
			}
			//IN068314 Starts
			if(isfppapplicable){
			if("Y".equals(getFpp_patient_yn())){
				sql = sql.replace("##FILTERFPP##"," AND a.FPP_YN = 'Y' ");
			}else{
				sql = sql.replace("##FILTERFPP##"," AND (a.FPP_YN IS NULL OR a.FPP_YN = 'N') ");
			}
			}
			else{
				sql = sql.replace("##FILTERFPP##","");
			}
			//IN068314 Ends
			pstmt = connection.prepareStatement(sql);
			int i = 1;
			if (diagnosis_code.equals("")) // Direct Population, if diagnosis is
											// not there
			{
				pstmt.setString(i++, getPractitionerType());
				pstmt.setString(i++, language_id);
				// IN068370,IN068373 Start.
				if ("Y".equals(ss_order_catlg_fac_wise_yn))
					pstmt.setString(i++, login_facility_id);
				// IN068370,IN068373 End.
				pstmt.setString(i++, getPractitionerId());
				pstmt.setString(i++, getServiceCode());
				pstmt.setString(i++, login_facility_id);
				pstmt.setString(i++, getLocationType());
				pstmt.setString(i++, getLocationCode());
				pstmt.setString(i++, checkForNull(diagnosis_code_scheme, "")); // It will be null
				pstmt.setString(i++, checkForNull(diagnosis_code, "")); // It will be null
				pstmt.setString(i++, checkForNull(order_category, ""));
				pstmt.setString(i++, getPatientClass());
				pstmt.setString(i++, getPatientId());
				pstmt.setString(i++, getSex());// IN063686
				pstmt.setString(i++, getDob());// IN063686
				pstmt.setString(i++, activity_type);
				pstmt.setString(i++, order_type_code);

				// IN063686 starts				
				if (priv_applicability_yn.equalsIgnoreCase("Y")) {
					pstmt.setString(i++, getPractitionerId()); // P_PRACTITIONER_ID
					pstmt.setString(i++, getResponsibilityId()); // P_RESP_ID
					pstmt.setString(i++, priv_applicability_yn); // P_PRIV_APPL_YN					
				}
				// IN063686 ends
			} else // If Diagnosis is there
			{
				pstmt.setString(i++, language_id);
				// IN068370,IN068373 Start.
				if ("Y".equals(ss_order_catlg_fac_wise_yn))
					pstmt.setString(i++, login_facility_id);
				// IN068370,IN068373 End.
				pstmt.setString(i++, checkForNull(order_category, ""));
				pstmt.setString(i++, checkForNull(diagnosis_code_scheme, ""));
				pstmt.setString(i++, checkForNull(diagnosis_code, ""));
				pstmt.setString(i++, getPractitionerType());
				pstmt.setString(i++, getPatientClass());
				pstmt.setString(i++, getPatientId());
				pstmt.setString(i++, getSex()); // IN063686
				pstmt.setString(i++, getDob()); // IN063686
				pstmt.setString(i++, activity_type);
				pstmt.setString(i++, order_type_code);
				// IN063686 starts				
				if (priv_applicability_yn.equalsIgnoreCase("Y")) {
					pstmt.setString(i++, getPractitionerId()); // P_PRACTITIONER_ID
					pstmt.setString(i++, getResponsibilityId()); // P_RESP_ID
					pstmt.setString(i++, priv_applicability_yn); // P_PRIV_APPL_YN
				}
				// IN063686 ends
				}
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  =	new String[3];
						record[0] = checkForNull(resultSet.getString( "order_catalog_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "order_category" ),"")  ;
						CareSetList.add(record) ;
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
			return CareSetList;
	}	 // End of the getCareSets

 	// 	When Diagnosis All is selected, call the function(Care Set Tab)
	public String[] getDiagCode() throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String[] 	  diag_code		= new String[2];
		try
		{
			connection = getConnection();
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
			closeConnection(connection);
		}
		return diag_code;
	} // End of getDiagCode

	// This Method is used to get the Diagnosis Description for display purpose in CareSet Tab
	public String getDiagnosisDesc(String orderable_text_id) throws Exception{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String 	  diag_desc			= "";
		try
		{
			connection = getConnection();
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
			closeConnection(connection);
		}
		return diag_desc;
	} // End of getDiagnosisDesc

	// Method is used to get the Session Id
	public String getSessionId() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String session_id			= "";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME"));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						session_id = checkForNull(resultSet.getString( "session_id" ),"")  ;
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
			return session_id;
	} // End of getSessionId

 	// Returns the facility_name
	public String getPerformingFacilityName(String facility) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String facility_name		= "";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FACILITY_NAME"));

				pstmt.setString(1, checkForNull(facility,""));
				pstmt.setString(2, language_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						facility_name = checkForNull(resultSet.getString( "facility_name" ),"")  ;
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
			return facility_name;
	} // End of getPerfomingFacilityName

 // Method to get the Default Sysdate
 public String getSysDate() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String sys_date			= "";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME"));
		    resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the date
			{
				while(resultSet.next())
				{
					sys_date = checkForNull(resultSet.getString( "sys_date_time" ),"")  ;
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
 		return sys_date;
 } // End of getSysdate

 // Method to call the Billing Interface is there or not (Place Order Tab)
 public String getBillingInterfaceYn() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String billing_interface_yn= "N";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PRINT_LOCATION"));
			pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					billing_interface_yn = checkForNull(resultSet.getString( "bl_module_yn" ),"N")  ;
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
 		return billing_interface_yn;
 } // End of getBillingInterfaceYn


 // Method to get the Billing Info on load of the First Screen.....(Before Addnl. Search)
 public ArrayList getBillChargeDetails(String quantity,String catalog_code,String start_date_time) throws Exception {
 	Connection connection 		= null;
 	CallableStatement cstmt 	= null;
 	ArrayList BillChargeInfo	= new ArrayList() ;
 	String[]  billing_details	= new String[25];
 	try{
 			connection	= getConnection();

 			cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_GET_CHARGE_DETAILS")+" }");
 			cstmt.setString(1, login_facility_id);  					 // FACILITY_ID
 			cstmt.setString(2, getEncounterId());  			  	   	     // ENCOUNTER_ID
 			cstmt.setString(3, getPatientClass()); 				         // PATIENT_CLASS
 			cstmt.setInt(4, Integer.parseInt(checkForNull(quantity,"0"))); 	 // Quantity from Place Order Screen
 			cstmt.setString(5, null); 						 		     // CHARGE_AMT
 			cstmt.setString(6, catalog_code); 					 		 // CATALOG_CODE
 			cstmt.setString(7, start_date_time); 				 		 // START_DATE_TIME

 			cstmt.registerOutParameter( 8,  Types.VARCHAR ) ;			 // DAY_TYPE_CODE
 			cstmt.registerOutParameter( 9,  Types.VARCHAR ) ;			 // DAY_TYPE_DESC
 			cstmt.registerOutParameter( 10,  Types.VARCHAR ) ;			 // TIME_TYPE_CODE
 			cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;			 // TIME_TYPE_DESC
 			cstmt.registerOutParameter( 12,  Types.NUMERIC ) ;			 // BASE_QTY
 			cstmt.registerOutParameter( 13,  Types.NUMERIC ) ;			 // BASE_RATE
 			cstmt.registerOutParameter( 14,  Types.NUMERIC ) ;			 // ADDL_FACTOR
 			cstmt.registerOutParameter( 15,  Types.NUMERIC ) ;			 // BASE_CHARGE_AMT
 			cstmt.registerOutParameter( 16,  Types.NUMERIC ) ;			 // GROSS_CHARGE_AMT
 			cstmt.registerOutParameter( 17,  Types.NUMERIC ) ;			 // DISC_AMT
 			cstmt.registerOutParameter( 18,  Types.NUMERIC ) ;			 // NET_CHARGE_AMT
 			cstmt.registerOutParameter( 19,  Types.NUMERIC ) ;			 // DISC_PERC
 			cstmt.registerOutParameter( 20,  Types.NUMERIC ) ;			 // PAT_GROSS_CHARGE_AMT
 			cstmt.registerOutParameter( 21,  Types.NUMERIC ) ;			 // PAT_DISC_AMT
 			cstmt.registerOutParameter( 22,  Types.NUMERIC ) ;			 // PAT_NET_CHARGE_AMT
 			cstmt.registerOutParameter( 23,  Types.NUMERIC ) ;			 // CUST_GROSS_CHARGE_AMT
 			cstmt.registerOutParameter( 24,  Types.NUMERIC ) ;			 // CUST_DISC_AMT
 			cstmt.registerOutParameter( 25,  Types.NUMERIC ) ;			 // CUST_NET_CHARGE_AMT

 			cstmt.registerOutParameter( 26,  Types.VARCHAR ) ;			 // SPLIT_IND
 			cstmt.registerOutParameter( 27,  Types.NUMERIC ) ;			 // CURR_AVAILED
 			cstmt.registerOutParameter( 28,  Types.VARCHAR ) ;			 // CREDIT_AUTH_REF
 			cstmt.registerOutParameter( 29,  Types.VARCHAR ) ;			 // ERROR_TEXT
 			cstmt.registerOutParameter( 30,  Types.VARCHAR ) ;			 // P_SERV_PANEL_IND
 			cstmt.registerOutParameter( 31,  Types.VARCHAR ) ;			 // P_SERV_PANEL_CODE
 			cstmt.registerOutParameter( 32,  Types.VARCHAR ) ;			 // P_SERVICE_PANEL_NAME
			cstmt.setString(33, getPatientId()); 				 		 // P_PATIENT_ID

 			cstmt.execute();
 			billing_details[0]  = checkForNull(cstmt.getString(8),"");
 			billing_details[1]  = checkForNull(cstmt.getString(9),"");
 			billing_details[2]  = checkForNull(cstmt.getString(10),"");
 			billing_details[3]  = checkForNull(cstmt.getString(11),"");
 			billing_details[4]  = checkForNull(String.valueOf(cstmt.getDouble(12)),"");
 			billing_details[5]  = checkForNull(String.valueOf(cstmt.getDouble(13)),"");
 			billing_details[6]  = checkForNull(String.valueOf(cstmt.getDouble(14)),"");
 			billing_details[7]  = checkForNull(String.valueOf(cstmt.getDouble(15)),"");
 			billing_details[8]  = checkForNull(String.valueOf(cstmt.getDouble(16)),"");
 			billing_details[9]  = checkForNull(String.valueOf(cstmt.getDouble(17)),"");
 			billing_details[10] = checkForNull(String.valueOf(cstmt.getDouble(18)),"");
 			billing_details[11] = checkForNull(String.valueOf(cstmt.getDouble(19)),"");
 			billing_details[12] = checkForNull(String.valueOf(cstmt.getDouble(20)),"");
 			billing_details[13] = checkForNull(String.valueOf(cstmt.getDouble(21)),"");
 			billing_details[14] = checkForNull(String.valueOf(cstmt.getDouble(22)),"");
 			billing_details[15] = checkForNull(String.valueOf(cstmt.getDouble(23)),"");
 			billing_details[16] = checkForNull(String.valueOf(cstmt.getDouble(24)),"");
 			billing_details[17] = checkForNull(String.valueOf(cstmt.getDouble(25)),"");
 			billing_details[18] = checkForNull(cstmt.getString(26),"");
 			billing_details[19] = checkForNull(String.valueOf(cstmt.getDouble(27)),"");
 			billing_details[20] = checkForNull(cstmt.getString(28),"");
 			billing_details[21] = checkForNull(cstmt.getString(29),"");
 			billing_details[22] = checkForNull(cstmt.getString(30),"");
 			billing_details[23] = checkForNull(cstmt.getString(31),"");
 			billing_details[24] = checkForNull(cstmt.getString(32),"");

 			BillChargeInfo.add(billing_details) ;
 	   }
 	   catch ( Exception e )	{

 			e.printStackTrace() ;
 		throw e ;
 		} finally {
 			closeStatement( cstmt);
 			closeConnection(connection);
  	}
  	return BillChargeInfo;
 } // End of getBillChargeDetails

/*  // Method to get the Billing Info on load of the First Screen.....(Before Addnl. Search)
 public ArrayList getBillChargeDetails(String quantity,String catalog_code,String start_date_time,String language_id) throws Exception {
 	Connection connection 		= null;
 	CallableStatement cstmt 	= null;
 	ArrayList BillChargeInfo	= new ArrayList() ;
 	String[]  billing_details	= new String[16];
 	try{
 			connection	= getConnection();

 			cstmt = connection.prepareCall("{ "+OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BILL_GET_CHARGE_DETAILS")+" }");
 			cstmt.setString(1, login_facility_id);  					 // FACILITY_ID
 			cstmt.setString(2, getEncounterId());  			  	   	     // ENCOUNTER_ID
 			cstmt.setString(3, getPatientClass()); 				         // PATIENT_CLASS
 			cstmt.setString(4, getPatientId()); 				         // PATIENT_ID
 			cstmt.setInt(5, Integer.parseInt(checkForNull(quantity,"0"))); 	 // Quantity from Place Order Screen
 			cstmt.setString(6, catalog_code); 					 		 // CATALOG_CODE
 			cstmt.setString(7, start_date_time); 				 		 // START_DATE_TIME
 			cstmt.setString(8, getPractitionerId()); 				     // PRACTITIONER_ID
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

			HashMap setBills_dtls = new HashMap();

			setBills_dtls.put("charged_yn"       , billing_details[1]);
			setBills_dtls.put("total_payable"    , billing_details[2]);
			setBills_dtls.put("patient_payable"  , billing_details[3]);
			setBills_dtls.put("quantity"         , quantity);
			setBills_dtls.put("rate"             , billing_details[5]);
			setBills_dtls.put("incl_excl_action" , billing_details[4]);
			setBills_dtls.put("patient_paid_amt" , billing_details[6]);
			setBills_dtls.put("bl_panel_str"     , billing_details[0]);
			setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
			setBills_dtls.put("serv_panel_code"  , billing_details[11]);
			setBills_dtls.put("p_episode_type"	 , billing_details[13]);
			setBills_dtls.put("p_episode_id"	 , billing_details[14]);
			setBills_dtls.put("p_visit_id"		 , billing_details[15]);

			orderEntryBillBean.setOrderBillDtls(getPatientId()+getEncounterId()+catalog_code, setBills_dtls);
			BillChargeInfo.add(billing_details) ;

 	   }
 	   catch ( Exception e )	{

 			e.printStackTrace() ;
 		throw e ;
 		} finally {
 			closeStatement( cstmt);
 			closeConnection(connection);
  	}
  	return BillChargeInfo;
 } // End of getBillChargeDetails  */

 // Based upon the Ordering rule set up for the Patient Class, Can place order (Tab) or not. Modified by Uma on 12/7/2010 for IN025324
 	public String getOrderingRuleYn(String order_category) throws Exception {
 	Connection connection 		= null;
 	PreparedStatement pstmt 	= null;
 	ResultSet resultSet 		= null;
 	String ordering_rule_yn	= "N";
 	try{
 			connection	= getConnection();
 			pstmt		= connection.prepareStatement("SELECT OR_GET_ACCESS_RULE (?,?,?,?,?,?) FROM DUAL"); //OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDERING_RULE"));
 			pstmt.setString(1, login_facility_id);
 			pstmt.setString(2, getEncounterId());
 			pstmt.setString(3, checkForNull(order_category,""));
 			pstmt.setString(4, getPatientClass());
 			pstmt.setString(5, getVisitAdmDate());
 			pstmt.setString(6, getDischargeDateTime());
 			resultSet	= pstmt.executeQuery() ;
 			if ( resultSet != null )    // Only one record for the ordering_rule_yn
 			{
 				while(resultSet.next())
 				{
 					ordering_rule_yn = checkForNull(resultSet.getString(1),"N")  ;
 				}
 			}	// if there is no record, then also it should return as 'N'
 		}catch ( Exception e )	{

 			e.printStackTrace() ;
 			throw e ;
 		} finally {
 			closeResultSet( resultSet ) ;
 			closeStatement( pstmt ) ;
 			closeConnection(connection);
 		}
 		return ordering_rule_yn;
} // End of getOrderingRuleYn

// To make Mandatory or not for Specimen Type if lab is installed
	public String getSpecimenMandYn(String catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		String  specimen_reqd_yn	= "O"; // It will be Optional
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_SPECIMEN_MAND"));
				pstmt.setString(1, catalog_code );
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						specimen_reqd_yn = checkForNull(resultSet.getString( "specimen_reqd_yn" ),"O")  ;
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
			return specimen_reqd_yn;
	}	 // End of the getSpecimenMandYn

// If ot installed and order_category is OT , this method is called to get appl_right_left flag
public String getOTApplRightLeft(String catalog_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  appl_right_left		= "N";
		try{
				connection			= getConnection();
				pstmt				= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_OT_INSTAL_OPER_SIDE_APPL"));
				pstmt.setString(1, catalog_code );
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						appl_right_left = checkForNull(resultSet.getString( "appl_right_left_flag" ),"N")  ;
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
			return appl_right_left;
}	 // End of the getOTApplRightLeft

	// To Populate the Performing Dept Location in Place Order
	public ArrayList getPerformingDeptLocation(String performing_fid, String order_catalog_code,String order_category, String order_type_code, String rd_install) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String labchk="";
		//String priority="",drug_class="";
		ArrayList PeformingDeptLocation = new ArrayList() ;
		try{
				connection	= getConnection();
				//if(order_category.equals("LB") && checkForNull(lb_install,"").equals("Y")) // for Laboratory and Lab Installed: changed on 7/9/2007 for lb_instal_yn by uma
				labchk=getmoduleRL(order_catalog_code,order_category,order_type_code,login_facility_id);
				if((order_category.equals("LB"))&& (checkForNull(labchk,"").equalsIgnoreCase("IBARL"))) // for Laboratory and Lab Installed
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN_LB"));
					pstmt.setString(1, checkForNull(performing_fid,""));
					pstmt.setString(2, checkForNull(order_catalog_code,""));
				}
				else if(order_category.equals("RD") && checkForNull(rd_install,"").equals("Y")) // for Radiology and RD Installed
				{
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN_RD")); 
					pstmt.setString(1, checkForNull(performing_fid,""));
					pstmt.setString(2, checkForNull(order_catalog_code,""));
				}
				else
				{
					//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN"));//IN31901
					pstmt		= connection.prepareStatement("SELECT a.performing_deptloc_code code, OR_GET_DESC.OR_PERFORMING_DEPTLOC(b. performing_facility_id, b.performing_deptloc_type,b. performing_deptloc_code,?,'2') short_desc ,default_yn default_yn FROM or_orderables_for_deptloc a ,or_performing_deptloc b WHERE a.performing_facility_id = ?  AND a.performing_deptloc_type = decode(?,'LB','L','RD','R','RX','I','PC','P','TR','T','MI','M','OT','O') AND a.order_catalog_code = ? AND a.performing_facility_id = b.performing_facility_id AND a.performing_deptloc_type =  b.performing_deptloc_type  AND a.performing_deptloc_code =  b.performing_deptloc_code AND B.EFF_STATUS ='E'");//IN31901
					pstmt.setString(1, language_id);
                    pstmt.setString(2, checkForNull(performing_fid,""));
					pstmt.setString(3, checkForNull(order_category,""));
					pstmt.setString(4, checkForNull(order_catalog_code,""));
				}
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[3];
						record[0] = checkForNull(resultSet.getString( "code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "default_yn" ),"")  ;
						PeformingDeptLocation.add(record) ;
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
			return PeformingDeptLocation;
	}	 // End of the getPerfomingDeptLocation

	/* To check if the patient which is going to place an order is deceased_yn , not applicable for MultiPatient Orders
	Modified by Uma on 2/4/2010 for IN017231 CRF 830 to get the patient id*/
	public String[] getDeceasedPatientYn(String patient_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		//String  deceased_yn			= "N";
		//String  patient_name			= "";
		String[] record			= null;

		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PATIENT_DECEASED"));
				pstmt.setString(1, patient_id );
 				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						record 		= new String[2];
						record[0] = checkForNull(resultSet.getString( "deceased_yn" ),"O")  ;
						record[1] = checkForNull(resultSet.getString( "pat_name" ),"")  ;
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
			return record;
	}	 // End of the getDeceasedPatientYn

	// If the patient is deceased and MO installed, then get the count if the patient is there in MO_MORTUARY_REGN
	public int getMortuaryRegnCount(String patient_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		int	count					= 0;
		try{
				connection			= getConnection();
				pstmt				= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_PATIENT_MO_MORTUARY_REGN_SELECT"));
				pstmt.setString(1, patient_id );
				resultSet			= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())	//Only One Record it will return
					{
						count =  resultSet.getInt(1)  ;
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
			return count;
	}	 // End of the getMortuaryRegnCount

 // Method called here to set the consolidated catalog code, on press of the Place Order Tab
	public void setCatalogCodes(String check_box_value) throws Exception
	{
		try{
				ArrayList arrCheckBoxVal= new ArrayList();
				StringTokenizer  stArr	= new StringTokenizer(check_box_value,",");
				while(stArr.hasMoreTokens())
				{
					arrCheckBoxVal.add(stArr.nextToken());
				}
				// call the  setOrderFormats method to store the codes in the order selected as the arraylist in the bean
				orderEntryRecordBean.setOrderFormats("CK_CODE", ("CK_CODE_0"),arrCheckBoxVal);
				// Till here
				String key			= (getPatientId()+getEncounterId());  // Unique key to keep the Value in the Bean
		   		// Call the below method from the bean to check if any previous values are there in the bean
		   		// If any records are there, then fetch them and put it in the hashmap,
				// so that u can checked the existing entries (already)
   				java.util.HashMap previousValues = (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
				if(arrCheckBoxVal!=null && arrCheckBoxVal.size()==0 && previousValues!=null)
				{
					setRefreshYn("Y"); //No catalog codes are there and insertion/updation has done to refresh the screen
				}
			}
			catch(Exception e)
			{

				e.printStackTrace() ;
			}
	} //End of setCatalogCodes

	// Method called to set the Amend Schedule Frequencies if present for that Frequency code
	public boolean setAmendScheduleFrequency(String order_id,String line_num,String key,int row_value) throws Exception{
		key							= "AmendSchedule"+key;
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap hashMap				= new HashMap();
		String duration_type		= "";
		//String field_value			= "";
		int repeat					= 0;
		//int i						= 1;
		boolean status 				= false;
  		try
  		{
  			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_SCHD_DTL"));
			pstmt.setString(1, checkForNull(order_id,""));
			pstmt.setString(2, checkForNull(line_num,""));
			resultSet = pstmt.executeQuery();

			ArrayList arr_list	= new ArrayList();
			ArrayList day_list	= new ArrayList();
			ArrayList day_names	= new ArrayList();
			ArrayList time_list	= new ArrayList();
			ArrayList dose_list	= new ArrayList();
			//HashMap currRec =  new 	HashMap();

			if(resultSet!=null)
			{
				while (resultSet.next())
				{
					day_list.add(checkForNull(resultSet.getString("order_line_freq_day"),""));
					time_list.add(checkForNull(resultSet.getString("order_line_field_value"),""));
					dose_list.add(checkForNull(resultSet.getString("order_line_dose_qty_value"),""));
					day_names.add("");
					repeat++;
					hashMap.put("durationType",duration_type);
					hashMap.put("start_date_time","");
					hashMap.put("repeat",repeat);
					hashMap.put("end_date_time","");
					arr_list.add(hashMap);
					arr_list.add(day_list);
					arr_list.add(day_names);
					arr_list.add(time_list);
					arr_list.add(dose_list);
					// Set it into the bean with unique code
					orderEntryRecordBean.setOrderFormats(key, 	(key+"_"+row_value),	arr_list);
					//duration_type 		= checkForNull(resultSet.getString("order_line_field_level"),""); // since for all records it will have same value "D" || "H"
			/*		field_value			= checkForNull(resultSet.getString("order_line_field_value"),"");
					//If it is Days
					if(field_value.equalsIgnoreCase("Y") || field_value.equalsIgnoreCase("N"))
					{
						duration_type	= "W"; // If it comes in, then it is a week.
						hashMap.put("daySM_display"+i,String.valueOf(i)); // Text/Legend
						if(field_value.equalsIgnoreCase("Y"))
							hashMap.put("daySM"+i,"Y"); // values
						else
							hashMap.put("daySM"+i,"N"); // values
						i++; // increment the count
					}
					// For Hours to be taken
					if(!field_value.equalsIgnoreCase("") &&  !field_value.equalsIgnoreCase("Y") && !field_value.equalsIgnoreCase("N"))
					{
					 	hashMap.put("displayHrs"+repeat,(checkForNull(resultSet.getString("order_line_label_text"),"")));
						hashMap.put("time"+repeat,field_value); // Values
						repeat++;
					}*/
				} // End of while
			} // End of if resultSet
			status = true;
  		}
  		catch(Exception e)
  		{

  			e.printStackTrace() ;
  			status = false;
		}finally
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return status;
    } // End of setAmendScheduleFrequency
	// *********************************** Till Here ********************************

	// Method to call the On Line Printing
	// A bean is called internally which will call the on line print routine
	public void callOnLinePrinting(Hashtable print_values, Hashtable print_specimen_values, HttpServletRequest request , HttpServletResponse response) throws Exception {
		//, Hashtable stored_print_values,
 		//OnLinePrinting online_print = new OnLinePrinting(request,response);
		OnLinePrinting online_print = new OnLinePrinting();
		//OnLinePrinting online_print = new OnLinePrinting();
		// one parameter is to print the order form , another paramater is to print the consent forms
		print_values.put("trn_group_ref",getTrnGroupRefId());
		online_print.callOrderEntryPrint(print_values, print_specimen_values, request,response);//Pass the Hashtable print_values (Stored in generateUniqueIds() )
		//,stored_print_values ,
 	} // End of callOnLinePrinting

	// Method called after (insertion/updation) to remove the values from the bean
	private void removeBeanValues() throws Exception {
		String key						= (getPatientId()+getEncounterId());  // Unique key to keep the Value in the Bean
		String removable_catalog_code = "";
 		// Remove the consolidated order_catalog_code
		ArrayList arrCheckCatalog = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
		//String called_from=(String)hashValues.get("called_from");
		//if(called_from.equalsIgnoreCase("OH")){}else{
 		if(arrCheckCatalog!=null)
		{
			int index				  = 0;
			if(care_set_count < 1) // For All Orders
			{
				for(int i=0;i<total_count;i++)
				{
					removable_catalog_code	  = "ck"+((String)hashValues.get("removable_catalog_code"+i));
					if(arrCheckCatalog.contains(removable_catalog_code))  // If true, get the index in the arraylist and then remove that item
					{
						 index			  =	arrCheckCatalog.indexOf(removable_catalog_code);
					}
  					if(index!=-1) // If found
					{
						/*Added by Uma on 2/19/2010 for IN017231*/
						if(arrCheckCatalog.size()>=index)
						{
							if(arrCheckCatalog.contains(removable_catalog_code))  // If true, get the index in the arraylist and then remove that item
							{
								if(((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
									arrCheckCatalog.remove(index);  //Remove the catalog_code from the Array List
							}
						}
						/*Ends Here Uma on 2/19/2010 for IN017231*/
					}
				}	// End of i
 			}
			else // For Care Set Orders
			{
				
				removable_catalog_code	  = "ck"+((String)hashValues.get("care_set_catalog_code"));
				
				if(arrCheckCatalog.contains(removable_catalog_code))  // If true, get the index in the arraylist and then remove that item
				{
					 index			  =	arrCheckCatalog.indexOf(removable_catalog_code);
					
				}
				if(index!=-1) // If found
				{
					if(((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
					{
						arrCheckCatalog.remove(index);  //Remove the catalog_code from the Array List
						
					}
				}
			}
 			if(arrCheckCatalog.size() > 0){
				
				orderEntryRecordBean.setOrderFormats("CK_CODE", ("CK_CODE_0"),arrCheckCatalog); // Again setting into the bean after removing the values, because if Lab Order has been placed, user can place some other order too
				
			}
			else
			{
				setRefreshYn("Y"); //No catalog codes are there and insertion/updation has			done to refresh the screen
					
			}
 		}	 // Till here removal consolidated catalog codes
	//}

		// Removal of each catalog code individually and its respective items.
 		java.util.HashMap previousValues = (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
 		if(previousValues!=null && previousValues.size() > 0)
		{
			String checkedKey = "";
 			for(int i= 0;i<total_count;i++)
		 	{
		 		checkedKey 			  = "";
		 		if(care_set_count < 1) // For All Orders
					checkedKey		  = ((String)hashValues.get("removable_catalog_code"+i));
				else // For Care Set Orders
					checkedKey		  = ((String)hashValues.get("care_set_catalog_code"));
					
   			 	orderEntryRecordBean.removeCheckedEntries(key,"ck"+checkedKey);
			 	orderEntryRecordBean.removeCheckedEntries(key,"h1"+checkedKey);
			 	orderEntryRecordBean.removeCheckedEntries(key,"h2"+checkedKey);
			 	
				orderEntryBillBean.removeOrderBillDtls(key+checkedKey);
 		 	}
//IN067246 starts
 			if(chkOrderCatalogCode.indexOf("~")!=-1)
 			{
				String[] catloglist=chkOrderCatalogCode.split("~");
				int size=catloglist.length;
 				
 				for(int i= 0;i<size;i++)
 				{
 					String removecatlog=catloglist[i];
 					orderEntryRecordBean.removeCheckedEntries(key,"ck"+removecatlog);
 					orderEntryRecordBean.removeCheckedEntries(key,"h1"+removecatlog);
 					orderEntryRecordBean.removeCheckedEntries(key,"h2"+removecatlog);
 					orderEntryBillBean.removeOrderBillDtls(key+removecatlog);
 					ArrayList arrCheckBoxVal = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
 					if(arrCheckBoxVal.contains("ck"+removecatlog)){
 						System.out.println("contains");
 						arrCheckBoxVal.remove("ck"+removecatlog);
 						orderEntryRecordBean.setOrderFormats("CK_CODE", ("CK_CODE_0"),arrCheckBoxVal);
 					}
 				}
 			} 				
//IN067246 starts
		 	// IF records are there for the Amend Order, remove them
		 	for(int j=0;j<amend_total_count;j++)
		 	{
		 		checkedKey 	= ((String)hashValues.get("removable_amend_catalog_code"+j));
				orderEntryRecordBean.removeCheckedEntries(key,"ck"+checkedKey);
				orderEntryRecordBean.removeCheckedEntries(key,"h1"+checkedKey);
		 		orderEntryRecordBean.removeCheckedEntries(key,"h2"+checkedKey);

				orderEntryBillBean.removeOrderBillDtls(((String)hashValues.get("removable_bill_amend_catalog_code"+j)));
		 	}
		} // End of if previousValues(Till here removal of individual items)

		// For Header Order Formats
		removeHeaderOrderFormat();  //REmoval from the Bean for the order format values
		ArrayList arrSeq_num= new java.util.ArrayList();
		int new_seq_num 		= 0;
		ArrayList arr_list	 = new ArrayList();
		String catalog_code 	 = "";
		// For Line Level Order Format Removal & for Schedule Frequency Removal
		for(int i=0;i<total_count;i++)
		{	// For Line Level Order Format Removal
			catalog_code = ((String)hashValues.get("removable_catalog_code"+i));
  			arrSeq_num	 = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, catalog_code+"_0");
			if(arrSeq_num!= null && arrSeq_num.size() >0)
			{
				for(int j=0;j<arrSeq_num.size();j++)
				{
					new_seq_num		= Integer.parseInt((String)arrSeq_num.get(j)); //((Integer)arrSeq_num.get(j)).intValue();
					//orderEntryRecordBean.removeOrderFormats(catalog_code, catalog_code+"_0");
					orderEntryRecordBean.removeOrderFormats(catalog_code, catalog_code+new_seq_num);
				}
				// Removing the arrSeqNo from the Bean
				orderEntryRecordBean.removeOrderFormats(catalog_code, catalog_code+"_0");
			}
			// Till here For Order Formats
			// For Line Level Schedule Frequency Removal
			arr_list	 = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+i); // It will return ArrayList
			if(arr_list!= null && arr_list.size() >0)
			{
				// Removing the arrSeqNo from the Bean
				orderEntryRecordBean.removeOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+i);
			}
			// Till here for Schedule Frequency
		} // End of for
		// For removal of lines

		// To remove the order_catalog_code from the bean when the amend is there
		for(int i=0;i<amend_total_count;i++)
		{
			catalog_code = "AMEND"+((String)hashValues.get("removable_amend_catalog_code"+i));
			arrSeq_num	 = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, catalog_code+"_"+i);
			if(arrSeq_num!= null && arrSeq_num.size() >0)
			{
				for(int j=0;j<arrSeq_num.size();j++)
				{
					new_seq_num		= Integer.parseInt((String)arrSeq_num.get(j));//((Integer)arrSeq_num.get(j)).intValue();
					orderEntryRecordBean.removeOrderFormats(catalog_code, catalog_code+"_"+"0");
					orderEntryRecordBean.removeOrderFormats(catalog_code, catalog_code+new_seq_num);
				}
				// Removing the arrSeqNo from the Bean
				orderEntryRecordBean.removeOrderFormats(catalog_code, catalog_code+"_"+i);
			}
		}	// End of for i Loop
 		// Just for checking if it has removed or not(Remove these lines of codes later)
		/*for(int i=0;i<total_count;i++)
		{
			arrSeq_num	 		= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(catalog_code, catalog_code+"_"+i);
 			
			arr_hash_map		= (java.util.HashMap)orderEntryRecordBean.getOrderFormats("Schedule"+catalog_code, "Schedule"+catalog_code+"_"+i); // It will return hashmap
			
		}
		*/
		// Till here(Remove till here)
 	} // End of removeBeanValues

	// Method called after (insertion/updation) to remove the values from the bean for the Order format Header Level
	private void removeHeaderOrderFormat() throws Exception {
	    ArrayList arrSeq_num		= new java.util.ArrayList();
	    ArrayList orderFormatTypes 	= new java.util.ArrayList();
		int new_seq_num 				= 0;
		String catalog_code 		= "",  ind_catalog_code = "", order_type_code = "";
		catalog_code				= (checkForNull(((String)hashValues.get("order_category")),""));

		String[] order_type_records = null;
		try {
				orderFormatTypes	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE"+order_category, "0");
				if(orderFormatTypes!= null && orderFormatTypes.size() >0 && care_set_count < 1)  // For Other Orders
				{
					for(int i=0;i<orderFormatTypes.size();i++)	// Only one loop for line level
					{
						ind_catalog_code  			= "";
						order_type_records 			= (String[])orderFormatTypes.get(i);
							 order_type_code		= order_type_records[1]; // Take only the order type code
						ind_catalog_code  			= order_type_code+catalog_code;
	   		    		arrSeq_num		  			= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_catalog_code+"_"+"0");
		   		    	if(arrSeq_num != null && arrSeq_num.size() > 0)
	   			    	{
	   			   			for(int k=0;k<arrSeq_num.size();k++)
							{
								new_seq_num		= Integer.parseInt((String)arrSeq_num.get(k));//((Integer)arrSeq_num.get(k)).intValue();
								orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_catalog_code+new_seq_num);
								//orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_catalog_code+"_"+"0");
							}// Removing the arrSeqNo from the Bean
							orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_catalog_code+"_"+"0");
		   		    	}
		   		   } // End of i
				orderEntryRecordBean.removeOrderFormats("ORDER_TYPE"+order_category, "0");
			}
			else	// For Care Set Orders
			{
				if(care_set_count > 0)
				{
					for(int j=0;j<care_set_count;j++)
					{
						ind_catalog_code  	= "";
    	    			catalog_code 		= ((String)hashValues.get("care_set_order_category"+j));
				    	orderFormatTypes	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("ORDER_TYPE_CARE_SET"+catalog_code, "0");
		   		    	if(orderFormatTypes!=null && orderFormatTypes.size()>0 && care_set_count > 0)
		   		    	{
	   			   			for(int k=0;k<orderFormatTypes.size();k++)
							{
								order_type_records 			= (String[])orderFormatTypes.get(k);
										order_type_code		= order_type_records[1]; // Take only the order type code
        				  		ind_catalog_code			= "ORDER_SET"+order_type_code+catalog_code;
						  		arrSeq_num					= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_catalog_code+"_"+"0");
						  		if(arrSeq_num!=null && arrSeq_num.size()>0)
		  		   		    	{
		  		   		    		for(int i=0;i<arrSeq_num.size();i++)
						  			{
										new_seq_num		= Integer.parseInt((String)arrSeq_num.get(i)); //((Integer)arrSeq_num.get(i)).intValue();
										orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_catalog_code+new_seq_num);
    	  				   			} // end of  for i
    	  				   			orderEntryRecordBean.removeOrderFormats(ind_catalog_code, ind_catalog_code+"_"+"0");
								} //End of arrSeqNum
					   		} // End of k
					   	orderEntryRecordBean.removeOrderFormats("ORDER_TYPE_CARE_SET"+catalog_code, "0");
					} // End of  arrSeq_num
              	}  // end of j
           	} // end of if
		}	// End of else care set orders
	 }catch(Exception e)
	 {

	 	e.printStackTrace();
	 }
  }    // End of Method removeHeaderOrderFormat

// For Rapid Orders
	public HashMap rapidOrders(String comment) throws Exception {
		ArrayList arrCheckBoxVal	= (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE", ("CK_CODE_0"));
		String key	= (getPatientId()+getEncounterId());  // Unique key to keep the Value in the Bean
		java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
		StringBuffer order_type_catalog = new StringBuffer();
		StringBuffer order_catalog_code	= new StringBuffer();
		String order_category			= null;
		ArrayList PlaceOrderItems		= null;
		HashMap hashmap					= new HashMap();
		HashMap temp_order_cat_hashmap	= new HashMap();
		String entryValue				= null;
		String[] records				= null;
		String keyItems[]				= null;
		int counter						= 0;
		try{
				if(arrCheckBoxVal!=null && previousValues!=null)
				{
					order_type_catalog.append(getOrderTypeCatalog(previousValues)); // Order_category
					//order_catalog_code.append(getOrderCatalogCode(previousValues, ""));//IN042045
					order_catalog_code.append(getOrderCatalogCode(previousValues, "",""));//IN042045
					if(order_type_catalog.length() > 0 && order_catalog_code.length() > 0 )
					{

						for(int i=0;i<arrCheckBoxVal.size();i++)
						{	// For the ArrayList, the size will be same
							entryValue	= (String)arrCheckBoxVal.get(i);
							keyItems	= orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
							if(keyItems[0]!=null && keyItems[0].equals("ck"))     // If it is a Check Box
							{
								if(!temp_order_cat_hashmap.containsKey(checkForNull((String)previousValues.get("h1"+keyItems[1]),"")))
								{
									temp_order_cat_hashmap.put(checkForNull((String)previousValues.get("h1"+keyItems[1]),""), checkForNull((String)previousValues.get("h1"+keyItems[1]),""));// Code and value will be Order Category
									order_category = checkForNull((String)previousValues.get("h1"+keyItems[1]),"");
									PlaceOrderItems 		= getPlaceOrdersResult(checkForNull(order_type_catalog.toString(),"'1||1','1'"),checkForNull(order_category,""),checkForNull(order_catalog_code.toString(),"''"), ""); //Last parmater needed only for Preview --> value will be "PREVIEW"
									if(PlaceOrderItems!=null)
									{
										for(int count=0; count<PlaceOrderItems.size(); count++)
										{
											records = (String[])PlaceOrderItems.get(count);
											hashmap.put("order_catalog_code"+counter, records[0]);
											hashmap.put("catalog_synonym"+counter, records[1]);
											hashmap.put("order_catalog_nature"+counter, records[2]);
											hashmap.put("order_category"+counter, records[3]);
											hashmap.put("order_type_code"+counter, records[4]);
											hashmap.put("performing_facility_id"+counter, 	records[5]);
											counter++;
										} // End of For Loop arrCheckBoxVal
									} // End of PlaceOrderItems
								  } // End of !temp
							    } // End of !chk
							} // End of  for
					}
				}  // arrCheckBoxVal
					hashmap.put("total_records",String.valueOf(counter));
					hashmap.put("patient_id",getPatientId());
					hashmap.put("encounter_id",getEncounterId());
					hashmap.put("patient_class",getPatientClass());
					hashmap.put("location_type",getLocationType());
					hashmap.put("location_code",getLocationCode());
					hashmap.put("ordering_practitioner",getPractitionerId());
					if(comment!=null && comment.indexOf("\"")!=-1)
						comment= comment.replace('"','\n');
					hashmap.put("comment",comment);
				}catch ( Exception e )	{

					e.printStackTrace() ;
					throw e ;
				}
				order_type_catalog.setLength(0);  // Clearing the string buffer
				order_catalog_code.setLength(0);  // Clearing the string buffer
				return hashmap;
	}

public HashMap insertRapidOrders(HashMap hashmap, TreeMap treemap){
 // boolean result             = false;
  StringBuffer tmpBuff        = new StringBuffer();
  HashMap map				  = new HashMap() ;
  java.util.Properties  properties   = getProperties();

  map.put( "result", new Boolean( false ) ) ;
  HashMap tabdata           = new HashMap() ;
  try{
	    if(hashmap!=null && treemap!=null)
		{
	        tabdata.put( "treemap",treemap) ;
		    tabdata.put( "login_by_id",login_by_id ) ;
			tabdata.put( "login_at_ws_no",login_at_ws_no ) ;
	        tabdata.put( "login_facility_id",login_facility_id ) ;
			tabdata.put( "properties",properties ) ;

		    tabdata.put( "hashmap",hashmap);
		}
     }catch(Exception e)
     {
		e.printStackTrace();
     }
	HashMap sqlMap = new HashMap() ;
    try{
		    sqlMap.put( "SQL_OR_RAPID_ORDER_HDR_INSERT", OrRepository.getOrKeyValue("SQL_OR_RAPID_ORDER_HDR_INSERT") );
			sqlMap.put( "SQL_OR_RAPID_ORDER_LINE_INSERT", OrRepository.getOrKeyValue("SQL_OR_RAPID_ORDER_LINE_INSERT") );
			sqlMap.put( "SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT", OrRepository.getOrKeyValue("SQL_ORDER_ENTRY_OR_ORDER_LINE_NUM_SELECT") );
       }catch(Exception e){
		   e.printStackTrace();
		}
//    OROrderEntryHome home = null ; //    OROrderEntryRemote remote = null ;
   try{
/*			InitialContext context = new InitialContext() ;
	        Object object = context.lookup( OrRepository.getOrKeyValue("OR_ORDER_ENTRY_JNDI") ) ;
	        home  = (OROrderEntryHome) PortableRemoteObject.narrow( object, OROrderEntryHome.class ) ;
			remote  = home.create() ;
	        map    = remote.insert( tabdata, sqlMap ) ;
*/
			ORRapidOrdersManager remote = new ORRapidOrdersManager();
			map = remote.insert(tabdata, sqlMap ) ;
	        //String str = ((String)map.get("traceVal"));
  	        //tmpBuff.append("BEAN FROM EJB"+str);
	        if((((String)map.get( "message")).trim()).equalsIgnoreCase("RECORD_INSERTED"))
	        {
				// Call a method removeBeanValues () from the bean to remove the values (catalog_codes,etc..)
          		map.put("message",(String)map.get( "message"));
        	}
       } catch(Exception e) {
	        map.put( "message", e.getMessage() ) ;
	        e.printStackTrace() ;
      }
	  //finally {  //try {   //		if( remote != null ) remote.remove() ;
      //  } catch( Exception ee ) {     
      //    map.put( "message", ee.getMessage() ) ;    //  }  //}
    map.put("traceVal", (String)tmpBuff.toString());
	tmpBuff.setLength(0);  // Clearing the string buffer
    return map ;
 }//end of insertRapidOrders

 // Build a string and give with appending the seq_no
 public String splitGroupingOrders (int grouping_seq_no) throws Exception {
	 String split_grouping	= "";
	 split_grouping			= String.valueOf(grouping_seq_no);
	 if(split_grouping.length()==1)
		split_grouping = split_grouping+"00";
	 else if(split_grouping.length()==2)
	    split_grouping = split_grouping+"0";
	return split_grouping;
} // End of splitGroupingOrders

//Start - Commented by Jyothi on 15/12/2009 to fix IN015497, since it is not returning the PH dispence location

/*public ArrayList getPerformDeptLocation1(String performing_fid, String order_catalog_code,String priority, String order_type, String drug_class) throws Exception {
		Connection connection 		= null;
		CallableStatement cstmt		= null;
		ArrayList PeformingDeptLocation = new ArrayList() ;
		try{
				connection	= getConnection();
				cstmt = connection.prepareCall(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN_PH"));
				cstmt.setString(1,  checkForNull(order_catalog_code,""));// P_ORDER_CATALOG
				cstmt.setString(2,  checkForNull(performing_fid,"")); // P_ORDERING_FACILITY
				cstmt.setString(3,  getLocationType() ); // Source Type
				cstmt.setString(4,  getLocationCode() ); // Source Code
				cstmt.setString(5,  checkForNull(priority,"R"));	// P_PRIORITY
				cstmt.setString(6,  "N");							//
				cstmt.setString(7,  order_type);	// P_ORDER_TYPE
				cstmt.setString(8,  drug_class);	// P_DRUG_CLASS
				cstmt.setString(9,  getPatientClass());
				cstmt.setString(10,  language_id);
				cstmt.registerOutParameter( 11,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 12,  Types.VARCHAR ) ;
				cstmt.execute();
				String[] record = null;
				record 	  = new String[2];
				record[0] = checkForNull(cstmt.getString(11),"");
				record[1] = checkForNull(cstmt.getString(12),"");
				PeformingDeptLocation.add(record) ;
			}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				closeStatement( cstmt ) ;
				closeConnection(connection);
			}
			return PeformingDeptLocation;
	}*/	 // End of the getPerfomingDeptLocation
//  End - Commented by Jyothi.

	public ArrayList getPerformDeptLocation1(String performing_fid, String order_catalog_code,String priority, String order_type, String drug_class) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList PeformingDeptLocation = new ArrayList() ;
		String[] record = new String[2];
		String disp_locn = "";
		try
		{
			connection	= getConnection();

			pstmt = connection.prepareStatement("SELECT PH_DISP_STOCK_LOCN(?,?,?,?,?,?,?,?,?,?,?,'M') DISP_LOCN from dual");
			pstmt.setString(1,getLocationType());
			pstmt.setString(2,getLocationCode());
			pstmt.setString(3,checkForNull(performing_fid,""));
			pstmt.setString(4,checkForNull(performing_fid,""));
			//pstmt.setString(5,""); //drug_class//11766
			pstmt.setString(5,drug_class); //drug_class//11766
			pstmt.setString(6,checkForNull(order_catalog_code,""));
			pstmt.setString(7,order_type);
			pstmt.setString(8,getPatientClass());
			pstmt.setString(9,"N");
			pstmt.setString(10,checkForNull(priority,"R"));
			pstmt.setString(11,language_id);
			
			resultSet = pstmt.executeQuery() ;
						
			if(resultSet != null && resultSet.next())
			{
				disp_locn = resultSet.getString("DISP_LOCN");
				if(disp_locn!=null && !disp_locn.equals(""))
				{
					if(disp_locn.indexOf("|")>0)
					{
						record[0] = disp_locn.substring(0,disp_locn.indexOf("|"));
						record[1] = disp_locn.substring(disp_locn.indexOf("|")+1);
					}
				}
			}
			
			PeformingDeptLocation.add(record) ;
		}
		catch ( Exception e )
		{

			e.printStackTrace() ;
			throw e ;
		}
		finally
		{
			closeStatement(pstmt);
			closeResultSet(resultSet);
			closeConnection(connection);
		}
		return PeformingDeptLocation;
	}

	public String getStatus(String order_id,String order_type_code) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		//String sql					= OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_STATUS_CHK") ;
		//String sql					= "";
		String perform_yn			= "";
		try{
			connection	= getConnection();
			//sql					= "select or_order_status_popupmenu ( ?, ? , ? )  perform_yn from dual";
			pstmt		= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_STATUS_CHK")) ;
			pstmt.setString(1, "EXISTING_ORDER1");
			pstmt.setString(2, order_id);
			pstmt.setString(3, order_type_code);

			resultSet	= pstmt.executeQuery() ;
			while(resultSet != null && resultSet.next()) {
				perform_yn = checkForNull(resultSet.getString( "perform_yn" ),"") ;
			}

		}catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
			return perform_yn;
	}

public String getapplicability(String catalogcode) throws Exception
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String applicability	= "N";
		try
		  {
			connection  = getConnection();
			
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_RD_EXAM"));
			//pstmt=connection.prepareStatement("SELECT nvl(CONTRAST_APPLICABILITY,'N') FROM RD_EXAMS WHERE ORDER_CATALOG_CODE = 'CTCHEST'");
			pstmt.setString(1,(String)catalogcode);

			rs	  =pstmt.executeQuery();
		
			while(rs != null && rs.next())
			{
				applicability = rs.getString("CONTRAST_APPLICABILITY");
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return applicability;

}
// added on 08/05/07 by Hari

public HashMap getConsent(String catalog_code) throws Exception
	{
		HashMap consent = null;
		try
		{
			OrderEntryQueryBean orderEntryQueryBean 	= new eOR.OrderEntryQueryBean();
			consent = (HashMap)orderEntryQueryBean.getConsentDtl(getProperties(), catalog_code);
			orderEntryQueryBean = null;
		}
		catch ( Exception e )
		{

			e.printStackTrace() ;
			throw e ;
		}
		return consent;
	}

	public String getForceStatus(String pract_type,String categorycode) throws Exception
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String fstatus="";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("OR_GET_FORCED_STATUS"));
			pstmt.setString(1,pract_type);
			pstmt.setString(2,categorycode);
			rs	  =pstmt.executeQuery();

			if(rs!=null && rs.next())
			{
				fstatus = checkForNull(rs.getString("FORCE_AUTH_YN"),"N");
				fstatus = fstatus+":"+checkForNull(rs.getString("FORCE_COSIGN_YN"),"N");
			}
			else
			  {
				fstatus="N:N";
			  }
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally {

			closeConnection(connection);
		}
		return fstatus;

}

public String getOrderTypeDesc(String order_type_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String order_type_desc= "";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_TYPE_DESC") ) ;
				pstmt.setString(1,checkForNull(language_id,""));
				pstmt.setString(2,checkForNull(order_type_code,""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						order_type_desc = checkForNull(resultSet.getString( "description" ), "" );
					}
				}
				return order_type_desc; // Only one record per
			}catch ( Exception e )	{

					e.printStackTrace() ;
					return null;
			} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
			}
	}	 // End of the getOrderTypeDesc

	public ArrayList getDiagScheme() throws Exception
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			ArrayList DiagScheme = new ArrayList() ;
			try{
					connection	= getConnection();
 					pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDER_SET_DIAG_SCHEME") ) ;

					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record	= null;
						while(resultSet.next())
						{
							record 	  = new String[2];
							record[0] = resultSet.getString( "code" )  ;
							record[1] = resultSet.getString( "description" )  ;
							DiagScheme.add(record) ;
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
				return DiagScheme;
	}

	public String getTermDesc(String term_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String term_desc= "";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDER_SET_TERM_DESC") ) ;
				pstmt.setString(1,checkForNull(term_code,""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						term_desc = checkForNull(resultSet.getString( "description" ), "" );
					}
				}
				return term_desc; // Only one record per
			}catch ( Exception e )	{

					e.printStackTrace() ;
					return null;
			} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
			}
	}
	public String getCheckPlaceOthYN(String practitioner_id,String responsibility_id,String practitioner_type) throws Exception
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String CheckPlaceOthYN="";
		if(practitioner_id==null || practitioner_id.equals(" ")) practitioner_id = "";
		if(responsibility_id==null || responsibility_id.equals(" ")) responsibility_id = "";
		if(practitioner_type==null || practitioner_type.equals(" ")) practitioner_type = "";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CHECK_PLACE_OTH_YN"));
			pstmt.setString(1,(String)practitioner_id);
			pstmt.setString(2,(String)responsibility_id);
			pstmt.setString(3,(String)practitioner_type);

			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				CheckPlaceOthYN = rs.getString("or_check_place_oth_yn");
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return CheckPlaceOthYN;

}

public ArrayList getCheckForceAuthSplty(String practitioner_id,String catalog_code,String encounter_id,String  facility_id,String order_category,String Splty_code,String pract_auth_yn) throws Exception
{
		Connection connection	= null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt_splty = null;
		ResultSet rs_splty			= null;
		ArrayList authSplty										= new ArrayList() ;
		String[]  auth_splty_details							= new String[3];

		if(practitioner_id==null || practitioner_id.equals(" ")) practitioner_id = "";
		if(catalog_code==null || catalog_code.equals(" ")) catalog_code = "";
		if(encounter_id==null || encounter_id.equals(" ")) encounter_id = "";
		if(facility_id==null || facility_id.equals(" ")) facility_id = "";
		if(order_category==null || order_category.equals(" ")) order_category = "";
		if(Splty_code==null || Splty_code.equals(" ")) Splty_code = "";
		if(pract_auth_yn==null || pract_auth_yn.equals(" ")) pract_auth_yn = "";
		if(pract_auth_yn.equalsIgnoreCase("X"))
			pract_auth_yn="Y";
		else
			pract_auth_yn="N";

		try
		  {
				connection  = getConnection();
				cstmt = connection.prepareCall("{ "+OrRepositoryExt.getOrKeyValue("SQL_OR_CHECK_SPLTY_FORCE_AUTH")+" }");
				cstmt.setString(1, (String)practitioner_id.trim());
				cstmt.setString(2, (String)Splty_code.trim());
				cstmt.setString(3, (String)catalog_code.trim());
				cstmt.setString(4, (String)pract_auth_yn.trim());
				cstmt.registerOutParameter( 5,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;
				cstmt.registerOutParameter( 7,  Types.VARCHAR ) ;
				cstmt.execute();
				auth_splty_details[0]  = checkForNull(cstmt.getString(5),"");
				auth_splty_details[1]  = checkForNull(cstmt.getString(6),"");
				auth_splty_details[2]  = checkForNull(cstmt.getString(7),"");
				authSplty.add(auth_splty_details);

		}
		catch(Exception e)
		{
				e.printStackTrace() ;
				throw e ;

		}finally
		{

			closeResultSet( rs_splty ) ;
			closeStatement( cstmt);
			closeStatement( pstmt_splty ) ;
			closeConnection(connection);
		}

		return authSplty;

	}
	public String[] getOrderSetBillDetails(String catalog_code) throws Exception
	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String[] record			= null;

		try
		{
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ORDER_SET_BILL_DETAILS"));
			pstmt.setString(1,catalog_code);

			rs	  =pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				record 	  = new String[5];//IN072524
				record[0] = rs.getString("order_set_desc");
				record[1] = rs.getString("bill_yn");
				record[2] = rs.getString("charge_yn");
				record[3] = rs.getString("fpp_yn");//IN072524
				record[4] = rs.getString("fpp_category");//IN072524
				
			}
		}
		catch(Exception e)
		{			
			e.printStackTrace() ;
		}
		finally
		{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return record;
	}

public String getEmailCatalogDesc(String order_catalog_code) throws Exception
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String CatalogDesc="";
		if(order_catalog_code==null || order_catalog_code.equals(" ")) order_catalog_code = "";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL_CATALOG_DESC"));
			pstmt.setString(1,checkForNull(language_id,""));
			pstmt.setString(2,(String)order_catalog_code);

			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				CatalogDesc = rs.getString("order_catalog_desc")==null?"":rs.getString("order_catalog_desc");
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return CatalogDesc;

}

public String getFutureChkYN(String startdate,String futuredate) throws Exception
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String FutureChkYN="";
		if(startdate==null || startdate.equals(" ")) startdate = "";
		if(futuredate==null || futuredate.equals(" ")) futuredate = "";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FUTURE_ORDER_CHK"));

			pstmt.setString(1,checkForNull(startdate,""));
			pstmt.setString(2,checkForNull(futuredate,""));

			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				FutureChkYN = rs.getString("status")==null?"":rs.getString("status");
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				//throw e ;
				}finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return FutureChkYN;

}
public String getDiscountAllowedYN() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String discount_allowed_yn= "N";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_ADHOC_DISCOUNT_ALLOWED"));
			pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					discount_allowed_yn = checkForNull(resultSet.getString("allow_yn"),"N")  ;
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
 		return discount_allowed_yn;
 } // End of getDiscountAllowedYN
	public ArrayList getEmailDetails(String report_id) throws Exception
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			ArrayList EmailDetails = new ArrayList() ;
			try{
					connection	= getConnection();
 					pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_DETAILS") ) ;
					pstmt.setString(1,report_id);

					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record	= null;
						while(resultSet.next())
						{
							record 	  = new String[3];
							record[0] = resultSet.getString("event_name")  ;
							record[1] = resultSet.getString("event_desc")  ;
							record[2] = resultSet.getString("event_hdr")  ;
							EmailDetails.add(record) ;
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
				return EmailDetails;
	}//end of getEmailDetails

	public String[] getEmailDataDetails(String facility_id) throws Exception
	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String[] record			= null;
		int cnt=0;

		try
		{

			connection  = getConnection();
			String EmailDataDetails="";
			if(getPatientClass().equalsIgnoreCase("XT"))
			{
				EmailDataDetails=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_EXT_DATA_DETAILS");
			}
			else
			{
				EmailDataDetails=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_EMAIL_DISPLAY_DATA_DETAILS");
			}

			pstmt = connection.prepareStatement(EmailDataDetails);
			if(getPatientClass().equalsIgnoreCase("XT"))
			{
				pstmt.setString(++cnt,checkForNull(getPatientId(),""));
			}
			else
			{
				pstmt.setString(++cnt,language_id);
				pstmt.setString(++cnt,checkForNull(getPatientClass(),""));
				pstmt.setString(++cnt,checkForNull(facility_id,""));
				pstmt.setString(++cnt,language_id);
				pstmt.setString(++cnt,checkForNull(facility_id,""));
				pstmt.setString(++cnt,language_id);
				pstmt.setString(++cnt,checkForNull(getPatientClass(),""));
				pstmt.setString(++cnt,checkForNull(facility_id,""));
				pstmt.setString(++cnt,checkForNull(getLocationCode(),""));
				pstmt.setString(++cnt,language_id);
				pstmt.setString(++cnt,checkForNull(facility_id,""));
				pstmt.setString(++cnt,checkForNull(getLocationCode(),""));
				pstmt.setString(++cnt,language_id);
				pstmt.setString(++cnt,checkForNull(getEncounterId(),""));
				pstmt.setString(++cnt,checkForNull(getPatientId(),""));
				pstmt.setString(++cnt,checkForNull(getLoginFacilityId(),""));
			}


			rs	  =pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				record 	  = new String[8];
				record[0] = rs.getString("speciality_desc");
				record[1] = rs.getString("mail_id");
				record[2] = rs.getString("patient_name");
				record[3] = rs.getString("national_id_no");
				record[4] = rs.getString("visit_date");
				record[5] = rs.getString("assign_care_locn_type");
				record[6] = rs.getString("LOCATION_DESCRIPTION");
				record[7] = rs.getString("ORDERING_LOCATION");
			}
		}
		catch(Exception e)
		{			
			e.printStackTrace() ;
		}
		finally
		{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return record;
	}


private String buildEmailDetails() throws Exception
{
		String report_id="EMPATINS";
		ArrayList EmailDetails=(ArrayList)getEmailDetails(report_id);
		String[] EmailDataDetails=getEmailDataDetails(login_facility_id);
		String dateString=getSysDate();
	 	String[] email_record					= null;
		StringBuffer sbEmail		= new StringBuffer();
		sbEmail.append("<html><table  width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">");
		String locale = properties.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
		java.util.ResourceBundle mp_labels = java.util.ResourceBundle.getBundle( "eMP.resources.Labels",loc);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		int count_display=1;
		int header=0;
		int display_dtls=0;
		for(int i=0; i<EmailDetails.size(); i++)
		{
				email_record = (String[])EmailDetails.get(i);
				if(email_record[0].equals(email_record[2]))
				{
					if(email_record[0].equals("PAT_DTL"))
					{
							count_display=1;

							sbEmail.append("<tr><td class=\"label\" colspan=\"4\"><font size=\"2\"><b>"+common_labels.getString("Common.PatientDetails.label")+"</b></font></td>");
							header++;

						}
						else if(email_record[0].equals("ENC_ID"))
						{
							if(count_display>1)
								sbEmail.append("</tr>");
							count_display=1;

							sbEmail.append("<tr><td class=\"label\" colspan=\"4\"><font size=\"2\"><b>"+common_labels.getString("Common.encounterid.label")+"</b></font></td>");
							header++;
						}
						else if(email_record[0].equals("ORD_DTL"))
						{
							if(count_display>1)
								sbEmail.append("</tr>");
							count_display=1;

							sbEmail.append("<tr><td class=\"label\" colspan=\"4\"><font size=\"2\"><b>"+or_labels.getString("eOR.OrderDetails.label")+"</b></font></td>");
							header++;
						}
					}
					else
					{
						count_display++;
						if(count_display%2==0)
						{
							if(header==0&&display_dtls==0)
							{
								sbEmail.append("<tr>");
								display_dtls++;
							}
							else
							{
								sbEmail.append("</tr><tr>");
							}
						}

						if(email_record[0].equals("PAT_NAME"))
						{

							sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.name.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)EmailDataDetails[2],"")+"</B></td>");

						}
						else if(email_record[0].equals("PAT_AGE"))
						{

							sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.age.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)getAge(),"")+"</B></td>");

						}
						else if(email_record[0].equals("PAT_SEX"))
						{
							String sex=checkForNull((String)getSex(),"");
							if (sex.equalsIgnoreCase("M"))
								sex=common_labels.getString("Common.male.label");
							else if(sex.equalsIgnoreCase("F"))
								sex=common_labels.getString("Common.female.label");

							sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.Sex.label")+"</td><td class=\"label\" width=\"25%\"><B>"+sex+"</B></td>");

						}
						else if(email_record[0].equals("PAT_ID"))
						{

							sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.patientId.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)getPatientId(),"")+"</B></td>");

						}
						else if(email_record[0].equals("PAT_NATIONAL_ID"))
						{

							sbEmail.append("<td class=\"label\" width=\"25%\">"+mp_labels.getString("eMP.NationalID.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)EmailDataDetails[3],"")+"</B></td>");

						}
						else if(email_record[0].equals("ENC_SPLTY"))
						{

								sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.speciality.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)EmailDataDetails[0],"")+"</B></td>");

							}
							else if(email_record[0].equals("ENC_LOCATION"))
							{
								String enc_location_type=checkForNull((String)EmailDataDetails[5],"");
								if(enc_location_type.equalsIgnoreCase("C"))
								{
									enc_location_type=common_labels.getString("Common.clinic.label");
								}
								else if(enc_location_type.equalsIgnoreCase("N"))
								{
									enc_location_type=common_labels.getString("Common.nursingUnit.label");
								}else if(enc_location_type.equalsIgnoreCase("R"))
								{
									enc_location_type=common_labels.getString("Common.referral.label");
								}
								else if(enc_location_type.equalsIgnoreCase("D"))
								{
									enc_location_type=common_labels.getString("Common.daycare.label");
								}
								String enc_location=enc_location_type+"/"+checkForNull((String)EmailDataDetails[6],"");

								sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.Location.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull(enc_location,"")+"</B></td>");

							}
							else if(email_record[0].equals("ENC_ATTEND_PRAC"))
							{

								sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.AttendingPractitioner.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)getAttendPractitionerName(),"")+"</B></td>");

							}
							else if(email_record[0].equals("ENC_VISIT_DATE"))
							{

								sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.VisitDate.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)dateString,"")+"</B></td>");

							}
							else if(email_record[0].equals("ORD_NO"))
							{

								sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.OrderNo.label")+"</td><td class=\"label\" width=\"25%\"><B>##ORDERID##</B></td>");

							}
							else if(email_record[0].equals("ORD_LOC"))
							{
								String location_type=checkForNull((String)getLocationType(),"");
								if(location_type.equalsIgnoreCase("C"))
								{
									location_type=common_labels.getString("Common.clinic.label");
								}
								else if(location_type.equalsIgnoreCase("N"))
								{
									location_type=common_labels.getString("Common.nursingUnit.label");
								}else if(location_type.equalsIgnoreCase("R"))
								{
									location_type=common_labels.getString("Common.referral.label");
								}
								else if(location_type.equalsIgnoreCase("D"))
								{
									location_type=common_labels.getString("Common.daycare.label");
								}

								String ordering_location=location_type+"/"+checkForNull((String)EmailDataDetails[7],"");

									sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.Location.label")+"</td><td class=\"label\" width=\"25%\"><B>"+ordering_location+"</B></td>");

								}
								else if(email_record[0].equals("ORD_DATE"))
								{

									sbEmail.append("<td class=\"label\" width=\"25%\">"+common_labels.getString("Common.OrderDate.label")+"</td><td class=\"label\" width=\"25%\"><B>"+checkForNull((String)dateString,"")+"</B></td>");
								}
							}

					}

				email_record = null;
				sbEmail.append("</tr></table>");

		return sbEmail.toString();
	} // End of buildEmailDetails Method
	/* Added by Uma for Multiple PerformingFacility Support*/
	public ArrayList getPerformingLocation(String order_category,String order_type_code,String order_catalog_code) throws Exception
	{
		String	ordering_source_type = getLocationType();	// source_type
		String ordering_source_code = getLocationCode();  // source_code
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String condition = "";
		int record_exists = 0;
		if(ordering_source_type.equals("E")) //IN045719 - condition added to handle location type is 'E'
			ordering_source_type = "C";
		ArrayList PeformingFacility = new ArrayList() ;
		try
		{
				connection	= getConnection();
				String performing_locn = "select  facility_id,facility_name from sm_facility_param_lang_vw where facility_id in (select performing_facility_id from or_order_facility_cross_ref where order_category = ?  and 	order_type_code =?	and order_catalog_code =? and ordering_facility_id =? and ordering_source_type  = ? and ordering_source_code = ?) and language_id=?";
				String multi_perform_facility_id = "select or_multi_perform_facility_id(?,?,?,?,?,?) condn from dual";
				pstmt		= connection.prepareStatement(multi_perform_facility_id);
				pstmt.setString(1, checkForNull(login_facility_id,""));
				pstmt.setString(2, checkForNull(order_category,""));
				pstmt.setString(3, checkForNull(order_type_code,""));
				pstmt.setString(4, checkForNull(order_catalog_code,""));
				pstmt.setString(5, checkForNull(ordering_source_type,""));
				pstmt.setString(6, checkForNull(ordering_source_code,""));
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						condition = checkForNull(resultSet.getString("condn"),"");
					}
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				String param[] = new String[6];
				if(condition.indexOf("|")!=-1)
				{
					StringTokenizer stktok =new StringTokenizer(condition,"|");
					int i=0;
					while(stktok.hasMoreTokens())
					{
						param[i] = stktok.nextToken();
						i++;
					}
				}
				if(condition.indexOf("|")!=-1)
				{
					pstmt		= connection.prepareStatement(performing_locn);
					pstmt.setString(1,param[0]);
					pstmt.setString(2,param[1]);
					pstmt.setString(3,param[2]);
					pstmt.setString(4,param[3]);
					pstmt.setString(5,param[4]);
					pstmt.setString(6,param[5]);
					pstmt.setString(7,language_id);
					resultSet	= pstmt.executeQuery() ;
					if(resultSet != null)
					{
						String record[] = null;
						while(resultSet.next())
						{
							record 	  = new String[2];
							record[0] = checkForNull(resultSet.getString( "facility_id" ),"")  ;
							record[1] = checkForNull(resultSet.getString( "facility_name" ),"");
							PeformingFacility.add(record) ;
							record_exists++;
						}
					}
				}
				if(record_exists==0)
				{
					String record[] = null;
					record 	  = new String[2];
					String performing_fac = getPerformingFacilityName(login_facility_id);
					record[0] = login_facility_id;
					record[1] = performing_fac;
					PeformingFacility.add(record);
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
			return PeformingFacility;
	}	 // End of the getPeformingFacility
	/*End*/

	/*
		Added by Kishore kumar N, on Aug-05-09,
		for the CRF 640-OR.

		Return 'Y' if the date and time is greaterthan or equal to date and time as defined in the order rule.
			   'N' if the date and time is lessthan to date and time as defined in the order rule.
	*/
	private String getFutureOderYn(String catalogCode, String ptClass, String placeOrderDt)throws Exception
	{
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rst = null;
		int futureSetupDateExists = 1;
		
		if (catalogCode != null && !catalogCode.equals("") && ptClass != null &&
			!ptClass.equals("") && placeOrderDt != null && !placeOrderDt.equals(""))
		{
			try
			{
				String futurOderYnQry  = OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FUTURE_DATE");
				String sql = " select future_order_period,floor_to_start_day_yn from or_param_by_category_ptcl 								where order_category=(SELECT order_category FROM or_order_catalog WHERE order_catalog_code = ?) and patient_class=?";
				String future_order_period = "0";
				String floor_to_start_day_yn = "N";
				con = ConnectionManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, catalogCode);
				pstmt.setString(2, ptClass);
				rst = pstmt.executeQuery();

				if(rst != null && rst.next())
				{
					future_order_period = rst.getString("future_order_period")==null?"0":rst.getString("future_order_period");
					floor_to_start_day_yn = rst.getString("floor_to_start_day_yn")==null?"N":rst.getString("floor_to_start_day_yn");
				}

				int future_order_period_range = Integer.parseInt(future_order_period);

				if((floor_to_start_day_yn.equalsIgnoreCase("Y"))||((future_order_period_range)>0))
				{
					futureSetupDateExists = 1;
				}
				else
				{
					futureSetupDateExists = 0;
				}

				pst = con.prepareStatement(futurOderYnQry);
				pst.setString(1, catalogCode);
				pst.setString(2, ptClass);
				rs = pst.executeQuery();
				String futureORDate = "";
				String Round_Off_yn = "";
				String Current_Date = "";
				
				if(rs != null && rs.next())
				{
					futureORDate = rs.getString("future_order_date");
					Round_Off_yn = rs.getString("round_off_yn");
					Current_Date = rs.getString("current_date");
				}

				if(futureORDate != null && !futureORDate.equals(""))
				{

					if(Round_Off_yn.equalsIgnoreCase("Y"))
					{
						String Currentdateforfloor=Current_Date.substring(0,10);
						String Futuredateforfloor=futureORDate.substring(0,10);
						if(!(DateUtils.isAfter(Currentdateforfloor,Futuredateforfloor,"DMY","en")))
						{
							futureORDate = futureORDate.substring(0,11)+"00:00";
						}
					}

					if(placeOrderDt.equals(futureORDate))
					{
						if(futureSetupDateExists>0)
						{
							return "Y";
						}
						else
						{
							return "N";
						}
					}
					else
					{
						if(DateUtils.isAfter(placeOrderDt, futureORDate, "DMYHM","en"))
						{
							return "Y";
						}
						else
						{
							return "N";
						}
					}
				}
				else
				{
					if(DateUtils.isAfterNow (placeOrderDt,"DMYHM",language_id))
					{
						return "Y";
					}
					else
					{
						return "N";
					}

				}
			}
			catch (Exception e)
			{

				e.printStackTrace() ;
				throw e ;
			}
			finally
			{
				closeResultSet(rs) ;
				closeStatement(pst) ;
				closeConnection(con);
			}
		}

		return "N";
	}
	/*
		ends here.
	*/
/*Added by Uma on 8/19/2009 for IN013420*/
	public void clearTempOrderSet(String key)
	{
		if(temp_values.containsKey(key))
		temp_values.remove(key);
	}
	/*End*/

	/*
		Added by Uma, on 8/21/2009 PMGCRF20089641.

		Returns 'Y' if the Ordering Practitioner has been assigned atleast one privilege and if the Ordering privilege is applicable at the enterprise level.
	*/
	/*public String getPrivForPractYN()throws Exception
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String priv_applicable_for_pract = "N";
		String practitioner_id = "";
		practitioner_id = (String)getPractitionerId();

		if(practitioner_id != null && !practitioner_id.equals(""))
		{
			try
			{
				if(((String)getPrivilegeApplicability()).equalsIgnoreCase("Y"))
				{
					connection = ConnectionManager.getConnection();
					pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_PRIV_FOR_PRACT"));
					pstmt.setString(1,"P");
					pstmt.setString(2,practitioner_id);
					pstmt.setString(3,"ORD");
					rs = pstmt.executeQuery();
					if(rs != null && rs.next())
					{
						priv_applicable_for_pract = rs.getString("priv_applicable")==null?"N":rs.getString("priv_applicable");
					}
				}
				else
				{
					priv_applicable_for_pract = "Y";
				}
			}
			catch (Exception e)
			{

				e.printStackTrace() ;
				throw e ;
			}
			finally
			{
				closeResultSet(rs) ;
				closeStatement(pstmt) ;
				closeConnection(connection);
			}
		}

		return priv_applicable_for_pract;
	}*/

	public Map<String, String> getDiscreetMeasure(String fieldMnemonic, String patientId, String sex, String dob)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try
		{
			//String sql = "SELECT num_digits_max, num_digits_min, num_digits_dec, min_value, max_value, CASE WHEN NVL(ref_range_type,'S') = 'S'THEN (SELECT num_dflt_result FROM am_discr_msr_ref_rng_num WHERE discr_msr_id = am_discr_msr.discr_msr_id) ELSE (SELECT num_dflt_result FROM am_discr_msr_ref_rng_num WHERE discr_msr_id = AM_DISCR_MSR.discr_msr_id AND patient_sex = B.sex AND date_of_birth <= DECODE (start_age_units, 'D', TRUNC (SYSDATE) - start_age, 'M', ADD_MONTHS (TRUNC (SYSDATE), -1 * start_age ), 'Y', ADD_MONTHS (TRUNC (SYSDATE), -12 * start_age )) AND (date_of_birth >= DECODE (end_age_units, 'D', TRUNC (SYSDATE) - end_age, 'M', ADD_MONTHS (TRUNC (SYSDATE), -1 * end_age ), 'Y', ADD_MONTHS (TRUNC (SYSDATE), -12 * end_age) ) ) ) END num_dflt_result FROM am_discr_msr, MP_PATIENT B WHERE B.PATIENT_ID= ? AND discr_msr_id = (SELECT discr_msr_id FROM or_order_field WHERE field_mnemonic = ? AND field_type = 'M')";

			con = getConnection();
			pst = con.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_FORMAT_DISCRETE"));
			//pst = con.prepareStatement(sql);
			pst.setString(1, sex);
			pst.setString(2, dob);
			pst.setString(3, fieldMnemonic);
			rs = pst.executeQuery() ;
			Map<String, String> dmMap = new HashMap<String, String>();
			while(rs.next())
			{
				dmMap.put("NUM_DIGITS_MAX", rs.getString(1));
				dmMap.put("NUM_DIGITS_MIN", rs.getString(2));
				dmMap.put("NUM_DIGITS_DEC", rs.getString(3));
				dmMap.put("MIN_VALUE", rs.getString(4));
				dmMap.put("MAX_VALUE", rs.getString(5));
				dmMap.put("DLFT_VALUE", rs.getString(6));
			}
			if (rs != null)
			{
				rs.close();
			}
			if (pst != null)
			{
				pst.close();
			}

			return dmMap.size()>0?dmMap:null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null)
				{
					con.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		return null;
	}
	public Map<String, String> getClinicalEvent(String fieldMnemonic, String patientId)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			con = getConnection();
			pst = con.prepareStatement("select nvl(to_char(result_num),RESULT_STR)||' As on'||to_char(EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_VALUE FROM cr_encounter_detail where patient_id=? and hist_rec_type in ('LBIN','PTCR') AND EVENT_CODE=? and EVENT_DATE=(SELECT MAX(EVENT_DATE) FROM  cr_encounter_detail where patient_id=? and hist_rec_type in ('LBIN','PTCR') AND EVENT_CODE=? ) and rownum=1");
			pst.setString(1, patientId);
			pst.setString(2, fieldMnemonic);
			pst.setString(3, patientId);
			pst.setString(4, fieldMnemonic);
			rs = pst.executeQuery() ;
			Map<String, String> dmMap = new HashMap<String, String>();
			while(rs.next())
			{
				dmMap.put("DLFT_VALUE", rs.getString("EVENT_VALUE"));
			}
			if (rs != null)
			{
				rs.close();
			}
			if (pst != null)
			{
				pst.close();
			}
			return dmMap.size()>0?dmMap:null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (con != null)
				{
					con.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	/*
		ends here.
	*/

	// For the Place Order, default values
	public ArrayList getPlaceOrderDefault(String order_catalog_code) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList PlaceOrderDefault = new ArrayList() ;
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PLACE_DEFAULT"));			
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);//added by Ambiga.M for 18146 on 2/4/2010(2)
				pstmt.setString(3, checkForNull(order_catalog_code.trim(),""));
				pstmt.setString(4, getPatientClass());
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )			// Only one record per code
				{
					String[] record = null;
					while(resultSet.next())
					{
						record 	  = new String[11];
						record[0] = checkForNull(resultSet.getString( "freq_code" ),"")  ;
						record[1] = checkForNull(resultSet.getString( "durn_value" ),"")  ;
						record[2] = checkForNull(resultSet.getString( "durn_type" ),"")  ;
						record[3] = checkForNull(resultSet.getString( "max_durn_value" ),"")  ;
						record[4] = checkForNull(resultSet.getString( "max_durn_type" ),"")  ;
						record[5] = checkForNull(resultSet.getString( "chk_for_max_durn_action" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "prompt_msg" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "item_narration" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "qty_value" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "qty_uom" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "short_desc" ),"")  ;
						PlaceOrderDefault.add(record) ;
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
			return PlaceOrderDefault;
	}	 // End of the getPlaceOrderDefault
	/*
		Added by Uma, on 8/21/2009 PMGCRF20089641.

		Returns 'N' if the Authorisation is required for the Order and if the privilege Group is not set for the catalog.
	*/
	public String getAuthorisationRights(String p_catalog_code,String p_priv_appl_yn)throws Exception
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String priv_applicable_for_pract_auth = "N";
		if(p_catalog_code != null && !p_catalog_code.equals(""))
		{
			try
			{
					connection = ConnectionManager.getConnection();
					pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PLACE_ORDER_PRIV_FOR_PRACT_AUTH"));
					pstmt.setString(1,p_catalog_code);
					pstmt.setString(2,p_priv_appl_yn);
					rs = pstmt.executeQuery();
					if(rs != null && rs.next())
					{
						priv_applicable_for_pract_auth = rs.getString("auth_rights_yn")==null?"N":rs.getString("auth_rights_yn");
					}				
			}
			catch (Exception e)
			{

				e.printStackTrace() ;
				throw e ;
			}
			finally
			{
				closeResultSet(rs) ;
				closeStatement(pstmt) ;
				closeConnection(connection);
			}
		}
		

		return priv_applicable_for_pract_auth;
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
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("OR_GET_INTERFACED_APPL"));
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
	/*Added By Uma on 10/15/2009 for SRR20056-195*/
	public void callOnLineCancelPrinting(Hashtable print_values,HttpServletRequest request , HttpServletResponse response) throws Exception 
	{
		//, Hashtable stored_print_values,
 		//OnLinePrinting online_print = new OnLinePrinting(request,response);
		OnLinePrinting online_print = new OnLinePrinting();
		//OnLinePrinting online_print = new OnLinePrinting();
		// one parameter is to print the order form , another paramater is to print the consent forms
		online_print.callCancelOrderPrint(print_values,request,response);//Pass the Hashtable print_values (Stored in generateUniqueIds() )
		//,stored_print_values ,
 	} // End of callOnLinePrinting
	/*Ends Here*/
	/*Added by Uma on 23/10/2008 for External Order Settlement issue*/
	public String[] getInvStlmtScrExtOrdYN() throws Exception 
	{
		 Connection connection 		= null;
		 PreparedStatement pstmt 	= null;
		 ResultSet resultSet 		= null;
		 String[] paramValues = new String[4] ;
		 String inv_stlmt_scr_ext_ord_yn= "N";
		 String inv_stlmt_scr_op_ord_yn= "N";
		 String inv_stlmt_scr_em_ord_yn= "N";
		 String settlement_scope= "B";
		 try 
		{
			connection	= getConnection();
			pstmt		= connection.prepareStatement("select nvl(INV_STLMT_SCR_EXT_ORD_YN,'N') inv_stlmt_scr_ext_ord_yn,nvl(INV_STLMT_SCR_OP_ORD_YN,'N') inv_stlmt_scr_op_ord_yn,nvl(INV_STLMT_SCR_EM_ORD_YN,'N') inv_stlmt_scr_em_ord_yn,nvl(settlement_scope,'B') settlement_scope from or_param_by_facility where operating_facility_id=?");
			pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					inv_stlmt_scr_ext_ord_yn = checkForNull(resultSet.getString( "inv_stlmt_scr_ext_ord_yn" ),"N")  ;
					inv_stlmt_scr_op_ord_yn = checkForNull(resultSet.getString( "inv_stlmt_scr_op_ord_yn" ),"N")  ;
					inv_stlmt_scr_em_ord_yn = checkForNull(resultSet.getString( "inv_stlmt_scr_em_ord_yn" ),"N")  ;
					settlement_scope = checkForNull(resultSet.getString( "settlement_scope" ),"B")  ;
				}
			}	// if there is no record, then also it should return as 'N'
			paramValues[0] = inv_stlmt_scr_ext_ord_yn;
			paramValues[1] = inv_stlmt_scr_op_ord_yn;
			paramValues[2] = inv_stlmt_scr_em_ord_yn;
			paramValues[3] = settlement_scope;
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
		return paramValues;
	  } // End of getBillingInterfaceYn

		public String getValidUser() throws Exception 
		{
				Connection connection 		= null;
				CallableStatement cstmt_valid_user 	= null;
				String stlmt_episode_type = "R";
				String billing_valid_user = "";
				try 
				{
				connection	= getConnection();
				String sql = OrRepositoryExt.getOrKeyValue("SQL_OR_BL_USER_CHECK_FOR_CASH_COUNTER");
				cstmt_valid_user = connection.prepareCall("{ "+sql+" }");  
				cstmt_valid_user.setString(1,login_facility_id);
				cstmt_valid_user.setString(2,checkForNull(stlmt_episode_type,""));
				cstmt_valid_user.setString(3,login_by_id);
				cstmt_valid_user.setString(4,login_at_ws_no);
				cstmt_valid_user.registerOutParameter(5, Types.VARCHAR ); //"P_CASH_COUNTER_CODE"
				cstmt_valid_user.registerOutParameter(6, Types.VARCHAR ); //"P_CASHIER_SHIFT"
				cstmt_valid_user.registerOutParameter(7, Types.VARCHAR ); //"P_SYS_MESSAGE_ID"				
				cstmt_valid_user.execute();
				billing_valid_user = checkForNull((String)cstmt_valid_user.getString(7),"");
				} 
				 catch ( Exception e )	
				{

					e.printStackTrace() ;
					throw e ;
				 } 
				 finally 
				{
					closeStatement( cstmt_valid_user);
					closeConnection(connection);
				}
				return billing_valid_user;
			}
			/*External Orders Ends Here*/
			/*Added by Uma on 12/1/2009 for CRF IN03477*/
			public String decodeLocal(String objVal)
			{
				String locale = properties.getProperty("LOCALE");
				locale = (locale == null || locale.equals(""))?"en":locale;

				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
				java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
				String returntext="";
				if(objVal.trim().equalsIgnoreCase(""))
				{
					return	"";
				}

				//Duration Type
				if(objVal.trim().equalsIgnoreCase("M"))		
				{
					returntext=common_labels.getString("Common.Minute(s).label");
					return	returntext;
				}
				if(objVal.trim().equalsIgnoreCase("H"))
				{
					returntext=common_labels.getString("Common.Hour(s).label");
					return	returntext;
				}
				if(objVal.trim().equalsIgnoreCase("D"))
				{
					returntext=or_labels.getString("eOR.Day(s).label");
					return	returntext;
				}
				if(objVal.trim().equalsIgnoreCase("W"))
				{
					returntext=or_labels.getString("eOR.Week(s).label");
					return	returntext;
					
				}
				if(objVal.trim().equalsIgnoreCase("L"))
				{
					returntext=or_labels.getString("eOR.Month(s).label");
					return	returntext;
					
				}
				if(objVal.trim().equalsIgnoreCase("Y"))
				{
					returntext=or_labels.getString("eOR.Year(s).label");
					return	returntext;
					
				}
				else
				return "";
	}
	public String getDurationType(String freq_code) throws Exception 
	{
			Connection connection 		= null;
			ResultSet resultSet 	= null;
			PreparedStatement pstmt 	= null;
			String duration_type = "";
			if(freq_code==null)freq_code="";
			try 
			{
				connection	= getConnection();				
				pstmt		= connection.prepareStatement("select interval_durn_type from am_frequency where freq_code=?");
				pstmt.setString(1, freq_code); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					while(resultSet.next())
					{
						duration_type = checkForNull(resultSet.getString( "interval_durn_type" ),"D")  ;
					}
				}	// if there is no record, then also it should return as 'N'
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
			return duration_type;
		}

		public String getPractitionerLocale(String pract_id) throws Exception
	    {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet		  rs    = null;
			String    practitioner_name = "";

			try
			{
				con = getConnection();
				String sql = "select nvl(am_get_desc.am_practitioner(?,?,'1'),am_get_desc.am_ext_practitioner(?,?,'1')) practitioner_name from dual";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1 , pract_id);
				pstmt.setString(2 , language_id);
				pstmt.setString(3 , pract_id);
				pstmt.setString(4 , language_id);
				rs = pstmt.executeQuery();
				
				while(rs.next() && rs!=null)
				{
					practitioner_name = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
				}
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			finally 
			{
				closeResultSet( rs);
				closeStatement( pstmt);
				closeConnection(con);
			}
			return practitioner_name;
	    }

		public ArrayList getScheduleFrequency(String order_id, String order_line_num) throws Exception
		{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList arr_list	= new ArrayList();
			int repeat = 0;
			String uom_code = "";

			try 
			{
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

				while( resultSet.next() ) 
				{
					day_list.add(checkForNull(resultSet.getString("order_line_freq_day"),""));
					time_list.add(checkForNull(resultSet.getString("order_line_field_value"),""));
					dose_list.add(checkForNull(resultSet.getString("order_line_dose_qty_value"),""));
					uom_code = (checkForNull(resultSet.getString("order_line_dose_qty_unit"),""));
					day_names.add("");
					repeat++;
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
			} 
			catch ( Exception e )	
			{
				e.printStackTrace() ;
			}
			finally 
			{
				try
				{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection) ;
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
			}

			return arr_list;
		}

		public boolean compareArrayList(ArrayList oldSchdFrequency,ArrayList newSchdFrequency,String oldFreqCode,String newFreqCode) throws Exception
		{
			boolean diff = false;
			try
			{
				if(oldFreqCode.equals(newFreqCode)) 
				{
					if( newSchdFrequency!=null)
					{
						if(newSchdFrequency.size()>1)
						{
							if((oldSchdFrequency!=null && newSchdFrequency!=null) && (oldSchdFrequency.size()==( newSchdFrequency.size())))
							{
								for(int y=1;y<((oldSchdFrequency.size())-1);y++)
								{
									if(!(oldSchdFrequency.get(y)).equals((newSchdFrequency.get(y))))
									{
										diff = true;
										break;
									}
									
								}
							}
							else if((oldSchdFrequency.size())!=( newSchdFrequency.size()))
							{
								diff = true;
							}
							else if((oldSchdFrequency!=null && newSchdFrequency==null) || (oldSchdFrequency==null && newSchdFrequency!=null))
							{
								diff = true;
							}
						}
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return diff;
		}
	
	//--[IN029071] - Start
	public String getDischargeAdvDateTime(String patient_id, String encounter_id) throws Exception 
	{
			Connection connection 		= null;
			ResultSet resultSet 	= null;
			PreparedStatement pstmt 	= null;
			String discharge_adv_date_time = null;
			try 
			{
				connection	= getConnection();				
				pstmt		= connection.prepareStatement("select to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') DIS_ADV_DAT_TIM from ip_discharge_advice where patient_id=? and encounter_id=? and dis_adv_status != '9'"); //--[IN029647]
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
		}
// --[IN029071] - End
//IN029143 Starts
	public String validateUserPIN(String user_id, String pin_no)
	{
		String result			= "N";
		String db_user_name		= null ;
		String db_pin_no		= null ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		
		try
		{
			connection = getConnection() ;
			//pstmt = connection.prepareStatement("SELECT APPL_USER_NAME,UPPER(APP_PASSWORD.DECRYPT(PIN_NO)) PIN_NO FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID)=UPPER(?)") ;
			pstmt = connection.prepareStatement("SELECT UPPER(APP_PASSWORD.DECRYPT(PIN_NO)) PIN_NO FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID)=UPPER(?)") ;
			pstmt.setString(1,user_id);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{
				//db_user_name = resultSet.getString("APPL_USER_NAME");
				db_pin_no = resultSet.getString("PIN_NO");
			}
			
			db_user_name=db_user_name==null?"":db_user_name;
			db_user_name=db_user_name.equalsIgnoreCase("null")?"":db_user_name;
			/*if(db_user_name.equalsIgnoreCase(user_id))
				result="Y";
			else
				result="N";*/
			db_pin_no=db_pin_no==null?"E":db_pin_no;
			db_pin_no=db_pin_no.equalsIgnoreCase("null")?"E":db_pin_no;
			if(db_pin_no.equalsIgnoreCase(pin_no))
				result="Y";
			else if(db_pin_no.equalsIgnoreCase("E"))//IN030711
				result="E";//IN030711
			else
				result="N";
		}
		catch ( Exception e )
		{
			e.printStackTrace() ;
		}
		finally 
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{}
		}
		return result;
	}
	public String securePINyn(String order_category)
	{
		String result			= "NA";
		String SecurePINReq		= null ;
		
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		
		try
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT SECURE_PIN_REQUIRED FROM or_order_category where order_category=?") ;
			pstmt.setString(1,order_category);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{
				SecurePINReq = resultSet.getString(1);
				
			}
			if(SecurePINReq.equalsIgnoreCase("AL"))
				result="AL";
			else if(SecurePINReq.equalsIgnoreCase("ML"))
				result="ML";
			else if(SecurePINReq.equalsIgnoreCase("MO"))
				result="MO";
			else if(SecurePINReq.equalsIgnoreCase("AO"))
				result="AO";
			else
				result="NA";
			
		}
		catch ( Exception e )
		{
			e.printStackTrace() ;
		}
		finally 
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{}
		}
		
		return result;
	}
	public String validatePIN(String user_id, String pin_no,String user_name)
	{
		
		String result			= "N";
		String db_user_name		= null ;
		String db_pin_no		= null ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		
		try
		{
			connection = getConnection() ;
			//pstmt = connection.prepareStatement("SELECT APPL_USER_NAME,UPPER(APP_PASSWORD.DECRYPT(PIN_NO)) PIN_NO FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID)=UPPER(?)") ;
			//pstmt = connection.prepareStatement("SELECT UPPER(APP_PASSWORD.DECRYPT(PIN_NO)) PIN_NO FROM SM_APPL_USER WHERE UPPER(APPL_USER_ID)=UPPER(?)") ;
			//pstmt = connection.prepareStatement("SELECT APPL_USER_NAME,UPPER(APP_PASSWORD.DECRYPT(PIN_NO)) PIN_NO FROM SM_APPL_USER WHERE UPPER(APPL_USER_NAME)=UPPER(?)") ;
			//pstmt = connection.prepareStatement("SELECT APPL_USER_NAME, UPPER(APP_PASSWORD.DECRYPT(PIN_NO)) PIN_NO FROM SM_APPL_USER AU, AM_PRACTITIONER AP WHERE FUNC_ROLE_ID = PRACTITIONER_ID AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?)") ;//IN030797
			pstmt = connection.prepareStatement("SELECT APPL_USER_NAME, UPPER(APP_PASSWORD.DECRYPT(PIN_NO)) PIN_NO FROM SM_APPL_USER AU, AM_PRACTITIONER AP WHERE FUNC_ROLE_ID = PRACTITIONER_ID AND UPPER(PRACTITIONER_ID) = UPPER(?)") ;//IN039001
			//pstmt.setString(1,user_name);//IN039001
			pstmt.setString(1,user_id);//IN039001
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{
				db_user_name = resultSet.getString("APPL_USER_NAME");
				
				db_pin_no = resultSet.getString("PIN_NO");
				
			}
			
			db_user_name=db_user_name==null?"":db_user_name;
			db_user_name=db_user_name.equalsIgnoreCase("null")?"":db_user_name;
			if(db_user_name.equalsIgnoreCase(user_id))
				result="Y";
			else
				result="N";
			db_pin_no=db_pin_no==null?"E":db_pin_no;//IN030711
			db_pin_no=db_pin_no.equalsIgnoreCase("null")?"E":db_pin_no;//IN030711
			if(db_pin_no.equalsIgnoreCase(pin_no))
				result="Y";
			else if(db_pin_no.equalsIgnoreCase("E"))//IN030711
				result="E";//IN030711
			else
				result="N";
		}
		catch ( Exception e )
		{
			e.printStackTrace() ;
		}
		finally 
		{
			try
			{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{}
		}
		return result;
	}
//IN029143 Ends
//IN030563 Starts
public String getLoginUserName(String user_id)
	{
		String practitioner_name		= "" ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		
		try
		{
			connection = getConnection() ;			
			//pstmt = connection.prepareStatement("SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?") ;
			pstmt = connection.prepareStatement("SELECT PRACTITIONER_NAME FROM SM_APPL_USER AU, AM_PRACTITIONER AP WHERE FUNC_ROLE_ID = PRACTITIONER_ID AND APPL_USER_ID = ?") ;//IN030797
			pstmt.setString(1,user_id);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{
				practitioner_name = resultSet.getString("PRACTITIONER_NAME");
				
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
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es)
			{}
		}
		return practitioner_name;
	}
	//IN030563 Ends
	// added by LK for CRF-0885 IN031304 on 29-11-2012
public String getOaIntegrationKey()
{
	String rd_oa_integration_key = "";
	Connection con	= null ;
	PreparedStatement pst = null ;
	ResultSet rs = null;
	try
	{
		con = getConnection() ;
		pst = con.prepareStatement(OrRepository.getOrKeyValue("SQL_OA_INEGRATION_PARAM_SELECT"));
		rs = pst.executeQuery() ;
		while (rs.next())
		{
			rd_oa_integration_key = rs.getString(1);
		}
	}
	catch( Exception e )
	{
		e.printStackTrace() ;
	}
	finally
	{
		try
		{
			closeResultSet(rs);
			closeStatement(pst);
			closeConnection(con);
		} catch (Exception ee)
		{
				ee.printStackTrace() ;
		}
	}
	return rd_oa_integration_key;
}
// created for IN035929 - START
public String getBillingInterfaceShowYn() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String show_bill_info_yn= "N";
	 String sqlQry = "Select disp_bl_dtl_yn from OR_PARAM_BY_FACILITY where operating_facility_id = ? ";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( sqlQry);
			pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
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
 //[IN038776] Start.
 public String getScreeningServicesYN(String facility_id,String patient_id,String ca_patient_class,String encounter_id,String ca_patient_visit_id) throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String screen_services_yn= "N";
	 String sqlQry = "Select DISP_SCR_PROGRM_YN from OR_PARAM_BY_FACILITY where operating_facility_id = ? ";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( sqlQry);
			pstmt.setString(1, getLoginFacilityId()); // pass the facility_id
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				if(resultSet.next())
				{
					screen_services_yn = checkForNull(resultSet.getString( "DISP_SCR_PROGRM_YN" ),"N")  ;
				}
			}	// if there is no record, then also it should return as 'N'			
			if("Y".equals(screen_services_yn)){
				if(resultSet!=null)resultSet.close();
				if(pstmt!=null)pstmt.close();
				pstmt		= connection.prepareStatement( "select blinstransactions.get_screening_plcy_enabled_yn(?,?,?,?,?) BL_SCREEN_SEVICES_YN from dual");
				pstmt.setString(1, facility_id); // pass the facility_id
				pstmt.setString(2, patient_id); //  patient_id
				pstmt.setString(3, ca_patient_class); //  ca_patient_class
				pstmt.setString(4, encounter_id);
				pstmt.setString(5, ca_patient_visit_id);
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					if(resultSet.next())
					{
						screen_services_yn = checkForNull(resultSet.getString( "BL_SCREEN_SEVICES_YN" ),"N")  ;
					}
				}
			}
			
	 	} catch ( Exception e )	{
			screen_services_yn = "N";//IN044542
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return screen_services_yn;
 }
 //[IN038776] End.
 //IN038787 Start.
 public String getOrderDisplayVerticalYN() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String orderDisplayVerticalYN= "N";
	 String sqlQry = "SELECT CTLOG_DISP_VERTICAL_YN FROM OR_PARAM";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( sqlQry);
			
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    
			{
				if(resultSet.next())
				{
					orderDisplayVerticalYN = checkForNull(resultSet.getString( "CTLOG_DISP_VERTICAL_YN" ),"N")  ;
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
 		return orderDisplayVerticalYN;
 }
 //IN038787 End.
 // added for IN024984 - START
	String key_catalog_code;
	String dupe_code_remarks;
	HashMap dupeReasonHashMap;
	public HashMap getDupeReasonHashMap() {
		return dupeReasonHashMap;
	}
	//IN062607 Starts
	public String getTempDupeReason() {
		return dup_temp_code_remarks;
	}
	//IN062607 Ends
	public void setDupeReasonHashMap(HashMap dupeReasonHashMap) {
		this.dupeReasonHashMap = dupeReasonHashMap;
	}
	public HashMap setDupeCodeRemarks(String a_catalog_code, String a_dupe_remarks) throws Exception
	{
		key_catalog_code = a_catalog_code;
		dupe_code_remarks = a_dupe_remarks;
		if(dupeReasonHashMap == null) {
			dupeReasonHashMap = new HashMap();
		}
		if(key_catalog_code != null && !"".equals(key_catalog_code)) {
			if(dupeReasonHashMap.containsKey(key_catalog_code)){
				dupeReasonHashMap.remove(key_catalog_code);
			}
			dupeReasonHashMap.put(key_catalog_code, dupe_code_remarks);
		}
		return dupeReasonHashMap;
	}
	//IN062607 Starts
	public  void setTempDupeCodeRemarks(String a_temp_dupe_remarks) throws Exception
	{
		this.dup_temp_code_remarks = a_temp_dupe_remarks;
	}
	//IN062607 ends
		
	public HashMap isDupeMandatoryHashMap(ArrayList dupeCatalogList) throws Exception {
		HashMap madatoryHashMap = null;
		StringBuffer dupeCodes = new StringBuffer();
		if(null!=dupeCatalogList && dupeCatalogList.size() > 0)//Fix for suspended orders
		{//Fix for suspended orders
		dupeCodes.append(" SELECT ORDER_CATALOG_CODE, DUP_REASON_REQD_YN FROM OR_ORDER_CATALOG WHERE ORDER_CATALOG_CODE IN ( ");
		if(dupeCatalogList != null) 
		{
			for(int i=0; i<dupeCatalogList.size();i++) 
			{
				dupeCodes.append("?");
				if(i != (dupeCatalogList.size()-1))
					dupeCodes.append(",");
			}
		}
		dupeCodes.append(" )");	
			
		madatoryHashMap = new HashMap();
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		try 
		{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( dupeCodes.toString());
			for(int i=1; i<=dupeCatalogList.size();i++) 
			{
				pstmt.setString(i, (String)dupeCatalogList.get(i-1));
			}
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next())
			{
				madatoryHashMap.put(resultSet.getString("ORDER_CATALOG_CODE"),  resultSet.getString("DUP_REASON_REQD_YN"));
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
	}//Fix for suspended orders
		return madatoryHashMap;
	}
 // IN047637 - Start
 public boolean isDupeReasonExists(String dupeKey) throws Exception {
	boolean isReasonExists = false;
	String dupeText = "";
	if(dupeKey != null && !"".equals(dupeKey)) {
		if(dupeReasonHashMap != null) {
			if(dupeReasonHashMap.containsKey(dupeKey)){
				dupeText = (String)dupeReasonHashMap.get(dupeKey);
				if(dupeText.length() != 0) {
					isReasonExists = true;
				}
			}
		}	
	}
	return isReasonExists;
 }
 // IN047637 - End
 // IN024984 - END
 //IN042962-Start
 public String getPrintOptionInd(String facility_id,String order_type_code,String ca_patient_class,String performing_location_code) throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String print_oprtion= "S";
	 String sqlQry = "SELECT PRINT_ORD_SHT_RULE_IND FROM or_order_type_routing WHERE order_type_code = ? AND patient_class IN (?, '*A') AND NVL(performing_deptloc_code,'!') IN ('!',?)AND ROWNUM<=1 ";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( sqlQry);
			pstmt.setString(1, order_type_code); 
			pstmt.setString(2, ca_patient_class);
			pstmt.setString(3, performing_location_code);

			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    
			{
				if(resultSet.next())
				{
					print_oprtion = checkForNull(resultSet.getString( "PRINT_ORD_SHT_RULE_IND" ),"S")  ;
				}
			}
	 	} catch ( Exception e )	{
	 		print_oprtion = "S";
			e.printStackTrace() ;
			throw e ;
	 	} finally {
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
 		}
 		return print_oprtion;
 }
 //IN042962 - End
 //IN050607 Starts
 public String getDischargeDateTime(String patient_id, String encounter_id) throws Exception 
	{
			Connection connection 		= null;
			ResultSet resultSet 	= null;
			PreparedStatement pstmt 	= null;
			String discharge_date_time = null;
			try 
			{
				connection	= getConnection();				
				pstmt		= connection.prepareStatement("select to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') DISCHARGE_DATE_TIME from pr_encounter where patient_id=? and encounter_id=? "); 
				pstmt.setString(1, patient_id); 
				pstmt.setString(2, encounter_id); 
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null ) 
				{
					while(resultSet.next())
					{
						discharge_date_time = checkForNull(resultSet.getString( "DISCHARGE_DATE_TIME" ),"")  ;
						
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
				closeResultSet( resultSet);
				closeStatement( pstmt);
				closeConnection(connection);
			}
			return discharge_date_time;
		}
		//IN050607 Ends
//ML-MMOH-CRF-0508.1 [IN062319] - Start
 public String getMultiSelectListItemMandatYN() throws Exception {
	 Connection connection 		= null;
	 PreparedStatement pstmt 	= null;
	 ResultSet resultSet 		= null;
	 String ord_formt_multi_list_mand_yn= "N";
	 String sqlQry = "SELECT ORD_FORMT_MULTI_LIST_MAND_YN FROM OR_PARAM WHERE MODULE_ID = 'OR' ";
	 try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( sqlQry);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				if(resultSet.next())
				{
					ord_formt_multi_list_mand_yn = checkForNull(resultSet.getString( "ord_formt_multi_list_mand_yn" ),"N")  ;
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
 		return ord_formt_multi_list_mand_yn;
 }
//ML-MMOH-CRF-0508.1 [IN062319] - End
 //ML-MMOH-SCF-0653 - Start
public String getPatientBirthDateTime(String patient_id) throws Exception 
{
		Connection connection 		= null;
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		String date_of_birth_time = "";
		try 
		{
			connection	= getConnection();				
			pstmt		= connection.prepareStatement("select to_char(date_of_birth,'dd/mm/yyyy HH24:MI') date_of_birth_time from mp_patient where  patient_id = ?"); 
			pstmt.setString(1, patient_id); 
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null ) 
			{
				while(resultSet.next())
				{
					date_of_birth_time = checkForNull(resultSet.getString( "date_of_birth_time" ),"")  ;
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
			closeResultSet( resultSet);
			closeStatement( pstmt);
			closeConnection(connection);
		}
		return date_of_birth_time;
	}
 //ML-MMOH-SCF-0653 - End
	//IN063816 starts
	public String onlinePrintingForBarcode(Hashtable print_barcode_values,HttpServletRequest request, HttpServletResponse response)
	{
		String report_id = "ORPOBCLA",barcode_to_be_executed="";
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		//IN064614 starts
		boolean result = false;
		String facility_id, patient_id,order_id,module_id,language_id, barcode_reqd_yn,order_catalog_code;
    	String order_line_num;
    	language_id = properties.getProperty("LOCALE");
		//IN065264 starts
    	//String str_barcode_count_records =  checkForNull(print_barcode_values.get("barcode_count_records").toString(),"0");
		String str_barcode_count_records = "0";
		
		if(print_barcode_values!=null && print_barcode_values.get("barcode_count_records") != null)
		{
			str_barcode_count_records =  checkForNull(print_barcode_values.get("barcode_count_records").toString(),"0");
		}
		//IN065264 ends
    	int barcode_count_records = Integer.parseInt(str_barcode_count_records);
    	//IN064614 ends
		
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
								//IN064614 starts
								result = onlineReports.add( report1) ;
								ReportOutput = "1";
								//IN064614 ends
							}
							catch(Exception e)
							{
								e.printStackTrace();
								ReportOutput = "0";
							}
					
		        		}
		        	}
					//IN064614 starts
		        	if(barcode_count_records>0)
		        	{
		        		if(result && "1".equals(ReportOutput))
		        			barcode_to_be_executed = onlineReports.execute( request, response );
		        	}
					//IN064614 ends
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	        }
    	return ReportOutput;
	}
	//IN063816 ends
	
	//IN64543, starts
	public void setInstrnContentType(String catalog_code, String instrn_content_type)
	{
		instrnContentType.put(catalog_code,instrn_content_type);		
	}
	
	public String getInstrnContentType(String catalog_code)
	{
		return instrnContentType.get(catalog_code);
	}
	//IN64543, ends
	
	//IN68475, starts
	public String getAmendComments(String order_id, String order_line_num)throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String comments = "";
		String order_line_fld_value_ins_type = "";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_COMMENTS_DATA"));

			pstmt.setString(1, order_id);
			pstmt.setString(2, order_line_num);
			resultSet = pstmt.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					order_line_fld_value_ins_type = checkForNull(resultSet.getString("INSTRUCTION_TYPE"),"T");
					
					if ("T".equals(order_line_fld_value_ins_type))
						comments = checkForNull(resultSet.getString("ITEM_NARRATION"),"");
					else
						comments = checkForNull(resultSet.getString("ITEM_NARRATION_FREE_FMT"),"");
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
	//IN68475, ends
//IN063719 start	
		public boolean activeEncounterCheck(String patientId,String encounter_id){
		Connection connection 		= null;
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		Boolean activeCheck = false;
		int cnt = 0;
		try 
		{
			connection	= getConnection();				
			pstmt		= connection.prepareStatement("SELECT ENCOUNTER_ID result FROM PR_ENCOUNTER WHERE ADT_STATUS IN ('00','01') AND PATIENT_ID=?"); 
			pstmt.setString(1, patientId); 
			resultSet	= pstmt.executeQuery() ;
			String result = "";
			if ( resultSet != null ) 
			{
				while(resultSet.next())
				{
					result = checkForNull(resultSet.getString( "result" ),"");
				}
			}
			if("".equals(result)){
				
			}else if(!(encounter_id.equals(result))){
				cnt++;
			}
			if(cnt>0){
				activeCheck = true;
			}
			else{
				activeCheck = false;
			}
		
		}catch(Exception e)
    	{
    		e.printStackTrace();
        }finally{
        	try{
        		if ( resultSet != null ) 
        			resultSet.close();
        		if ( connection != null ) 
        			connection.close();
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return activeCheck;
	}
	public String getRestrictAEEncFlag(){
		Connection connection 		= null;
		ResultSet resultSet 	= null;
		PreparedStatement pstmt 	= null;
		String restrictAEEncFlag = "";
		try 
		{
			connection	= getConnection();				
			pstmt		= connection.prepareStatement("select ORD_REST_OPEN_AE_OP_ENC_YN from or_param"); 
			resultSet	= pstmt.executeQuery() ;
			String result = "";
			if ( resultSet != null ) 
			{
				while(resultSet.next())
				{
					result = checkForNull(resultSet.getString( "ORD_REST_OPEN_AE_OP_ENC_YN" ),"");
				}
			}
			restrictAEEncFlag = result;
		}catch(Exception e)
    	{
    		e.printStackTrace();
        }finally{
        	try{
        		if ( resultSet != null ) 
        			resultSet.close();
        		if ( connection != null ) 
        			connection.close();
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return restrictAEEncFlag;
	}//IN063719 end

	
		//IN068553 Starts	
	public static JSONArray getfieldmnemonic(String language_id, String patient_id, String encounter_id,String login_facility_id) throws Exception{
		Connection con			= null;
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONArray arrJSON		= new JSONArray();
		String attending_practitioner = "";
		String mobile_num = "";

		try{

			String sqlQuery = "SELECT am_get_desc.am_practitioner (a.attend_practitioner_id, ?, 1 ) attending_practitioner, b.mobile_num FROM pr_encounter a, am_practitioner b WHERE a.attend_practitioner_id = b.practitioner_id AND a.patient_id = ? AND a.encounter_id = ? AND a.facility_id =?";
			
			con = ConnectionManager.getConnection();
			pstmt= con.prepareStatement(sqlQuery);
			pstmt.setString(1,language_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,encounter_id);
			pstmt.setString(4,login_facility_id);
			rset= pstmt.executeQuery();
			
			while(rset!=null && rset.next()){
				JSONObject jsonObj	= new JSONObject();
				attending_practitioner = rset.getString("attending_practitioner")==null?"":rset.getString("attending_practitioner");
				mobile_num = rset.getString("mobile_num")==null?"":rset.getString("mobile_num");

				jsonObj.put("attending_practitioner",attending_practitioner);
				jsonObj.put("mobile_num",mobile_num);
				
				arrJSON.add(jsonObj);
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
        		if ( rset != null ) 
        			rset.close();
				if ( pstmt != null ) 
        			pstmt.close();
        		if ( con != null ) 
        			con.close();
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return arrJSON;
	}
	//IN068553 Ends
//IN071260 Starts
	public ArrayList<String> chkDrugInteractionForLB(String order_catalog_code,String order_date_time){
		ArrayList<String> interactiondrugCodes = new ArrayList<String>();
		Connection con			= null;
		PreparedStatement psmt = null; 
		ResultSet rset 			= null;
		//String interYN ="N";//51003
		//IN072627
		if(!"en".equals(getLanguageId()))
		{
			order_date_time = DateUtils.convertDate(order_date_time,"DMYHM",getLanguageId(),"en");
		}
	    //IN072627
		ArrayList<OrderDrugInteractionVO> drugs = new ArrayList<OrderDrugInteractionVO>();
		OrderDrugInteractionVO drugInteractionVO = null;
		//ArrayList<ArrayList<String>> drugList =  new ArrayList<ArrayList<String>>();//51003
	//	ArrayList<OrderDrugInteractionVOer = null;//51003
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select INTR_CODE1,start_date_time,end_date_time,INTR_CODE2,INTR_RESTRT_YN,INTR_REMARKS,drugdesc from ( ");
		stringBuilder.append(" select distinct di.INTR_CODE1,o.start_date_time,o.end_date_time, ");
		stringBuilder.append(" di.INTR_CODE2,di.INTR_RESTRT_YN,di.INTR_REMARKS ,(SELECT GENERIC_NAME FROM PH_GENERIC_NAME WHERE GENERIC_ID=pd.generic_id) drugdesc ");//IN073562
		stringBuilder.append(" from or_order_line o,ph_drug_interaction di,or_order od, ph_drug pd WHERE ");
		stringBuilder.append("  od.order_id = o.order_id AND  di.INTR_TYPE2 = 'L'  AND  di.INTR_TYPE1 = 'G' AND  o.order_catalog_code = pd.DRUG_CODE ");
		stringBuilder.append(" AND  pd.GENERIC_ID =di.INTR_CODE1  AND NVL(di.EFF_STATUS,'D') = 'E' AND DI.INTR_CODE2 = ? ");
		stringBuilder.append("  AND o.order_line_status not in('CN','DC') ");//IN072668
		stringBuilder.append("  AND od.patient_id =? and od.encounter_id =?  and TO_DATE(?,'DD/MM/yyyy HH24:MI') BETWEEN o.START_DATE_TIME AND o.END_DATE_TIME ");
		stringBuilder.append(" UNION ALL  ");
		stringBuilder.append(" select distinct di.INTR_CODE1,o.start_date_time,o.end_date_time, ");
		stringBuilder.append(" di.INTR_CODE2,di.INTR_RESTRT_YN,di.INTR_REMARKS ,O.CATALOG_DESC drugdesc  ");
		stringBuilder.append(" from or_order_line o,ph_drug_interaction di,or_order od  ");
		stringBuilder.append(" WHERE o.order_catalog_code = di.INTR_CODE1 and od.order_id = o.order_id and  di.INTR_TYPE2 = ?  AND  di.INTR_TYPE1 = 'D'  AND di.INTR_CODE2 = ?  ");
		stringBuilder.append(" AND NVL(di.EFF_STATUS,'D') = 'E'  ");
		stringBuilder.append("  AND o.order_line_status not in('CN','DC') ");//IN072668
		stringBuilder.append(" AND od.patient_id =? and od.encounter_id =?  ");
		stringBuilder.append(" and TO_DATE(?,'DD/MM/yyyy HH24:MI') BETWEEN o.START_DATE_TIME AND o.END_DATE_TIME  ");
		stringBuilder.append(" ) order by INTR_CODE1 ");
		String interactionCode = "";//IN072654
		
		try {
			con = ConnectionManager.getConnection();
			psmt=con.prepareStatement(stringBuilder.toString());
				psmt.setString(1, order_catalog_code);
				psmt.setString(2,patient_id);
				psmt.setString(3, encounter_id);
				psmt.setString(4, order_date_time);
				psmt.setString(5,"L");
				psmt.setString(6, order_catalog_code);
				psmt.setString(7, patient_id);
				psmt.setString(8, encounter_id);
				psmt.setString(9, order_date_time);
				rset = psmt.executeQuery();
				while(rset.next())
				{ 
					if(!interactionCode.equals(rset.getString("INTR_CODE1"))){//IN072654
					interactionCode = rset.getString("INTR_CODE1");//IN072654
					drugInteractionVO = new OrderDrugInteractionVO();
				
					drugInteractionVO.setDrugCode(interactionCode);//IN072654
					drugInteractionVO.setDrugStartDate(rset.getString("start_date_time"));
					drugInteractionVO.setDrugDesc(rset.getString("drugdesc"));
					drugInteractionVO.setDrugEndDate(rset.getString("end_date_time"));
					drugInteractionVO.setDrugRestrictYN(rset.getString("INTR_RESTRT_YN"));
					drugInteractionVO.setDrugRemarks(rset.getString("INTR_REMARKS"));
					if(null!= rset.getString("INTR_RESTRT_YN") && "Y".equals(rset.getString("INTR_RESTRT_YN"))){
						druginteractionYN.put(order_catalog_code, "R");
					}
					
						drugs.add(drugInteractionVO);
					}//IN072654
					
				}
				if(null!=rset)
					rset.close();
				if(null!=drugs && drugs.size() >0){
					druginteractionDtl.put(order_catalog_code, drugs);
				}
			
		} catch (Exception e) {
			// TODO: handle exception
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
		return interactiondrugCodes;
	}
//IN071260 Ends
	
	//IN068314 Starts
	public String getFPPPatientYN(String facility_id,String episode_type,String encid) throws Exception{
		Connection connection 		= null;
		
		try{
				connection	= ConnectionManager.getConnection(properties) ;

				String sqlQry = "BEGIN ? :=  blcommon.FPP_PATIENT_YN(?,?,?,?); end;";
				OracleCallableStatement cstmt = (OracleCallableStatement)connection.prepareCall(sqlQry);
				
				cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
				cstmt.setString(2,facility_id);
				cstmt.setString(3,episode_type);
				cstmt.setString(4, encid);
				cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
				
				cstmt.execute() ;
			
				fpp_patient_yn 	  = cstmt.getString( 1 )  ;
				setFpp_patient_yn(fpp_patient_yn);
				
		}catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
			} finally {
				
				
				if(connection!=null) ConnectionManager.returnConnection(connection, properties);
			}
		return fpp_patient_yn;
	}
	//IN068314 Ends
	
	//IN072654 Starts
		public boolean chkDrugInteractionForLBAmend(String order_catalog_code,String order_id, String order_line_no){
			//ArrayList<String> interactiondrugCodes = new ArrayList<String>();//51003
			Connection con			= null;
			PreparedStatement psmt = null; 
			ResultSet rset 			= null;
	//		String interYN ="N";//51003
			boolean amendoverRemarks = false;
		
			ArrayList<OrderDrugInteractionVO> drugs = new ArrayList<OrderDrugInteractionVO>();
			OrderDrugInteractionVO drugInteractionVO = null;
	//		ArrayList<ArrayList<String>> drugList =  new ArrayList<ArrayList<String>>();//51003
			//ArrayList<OrderDrugInteractionVO> interDrugsforLBOrder = null;//51003
			StringBuilder stringBuilder = new StringBuilder();
			String interactionCode = "";//IN072654
			//IN073562 Starts
			stringBuilder.append(" select distinct drug_interaction_code,start_date_time,end_date_time,intr_code2,intr_restrt_yn,intr_remarks,drugdesc,OVERRIDE_REASON,INTERACTION_STATUS from ( ");
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
			stringBuilder.append("  FROM or_order_line o, ph_drug_interaction di, or_order od, ph_drug pd,or_order_drug_interaction ord ");
			stringBuilder.append(" WHERE o.order_catalog_code = di.intr_code1 and  od.order_id = o.order_id AND di.intr_type2 = 'L' AND di.intr_type1 = 'D' ");
			stringBuilder.append(" AND NVL (di.eff_status, 'D') = 'E' AND di.intr_code2 = ? AND ORD.DRUG_INTERACTION_CODE = DI.INTR_CODE1  and ORD.order_catalog_code=?   ");
			stringBuilder.append(" AND ORD.ORDER_ID = ?  AND ORD.ORDER_LINE_NUM = ? AND o.order_line_status NOT IN ('CN', 'DC')   AND od.patient_id = ? ");
			stringBuilder.append(" AND od.encounter_id = ?  AND ord.ADDED_DATE BETWEEN o.start_date_time AND o.end_date_time ");
			stringBuilder.append(" ) order by drug_interaction_code ");
				//IN073562 Ends
			
			
			try {
				con = ConnectionManager.getConnection();
				psmt=con.prepareStatement(stringBuilder.toString());
				//IN073562 Starts
				psmt.setString(1,order_catalog_code);
				psmt.setString(2,order_catalog_code);
				psmt.setString(3, order_id);
				psmt.setString(4,order_line_no);
				psmt.setString(5,patient_id);
				psmt.setString(6,encounter_id);
				psmt.setString(7,order_catalog_code);
				psmt.setString(8,order_catalog_code);
				psmt.setString(9, order_id);
				psmt.setString(10,order_line_no);
				psmt.setString(11,patient_id);
				psmt.setString(12,encounter_id);
				//IN073562 Ends	
					rset = psmt.executeQuery();
					while(rset.next())
					{ 
						
						if(!interactionCode.equals(rset.getString("DRUG_INTERACTION_CODE"))){//IN072654
							interactionCode = rset.getString("DRUG_INTERACTION_CODE");//IN072654
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
						}	//IN072654
					}
					if(null!=rset)
						rset.close();
					if(null!=drugs && drugs.size() >0){
						druginteractionDtl.put(order_catalog_code, drugs);
						amendoverRemarks = true;
					}
				
			} catch (Exception e) {
				// TODO: handle exception
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
			return amendoverRemarks;
		}
	//IN072654 Ends
}//end of class
