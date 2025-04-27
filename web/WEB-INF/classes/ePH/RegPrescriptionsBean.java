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
//import javax.rmi.* ;
//import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.RegPrescriptions.*;
import java.text.DecimalFormat;
import eXH.*; // added for Bru-HIMS-CRF-076 [IN029942]

public class RegPrescriptionsBean extends PhAdapter implements Serializable {

	protected String disp_locations			= "";
	protected String disp_locn_code			= "";
	protected String token_series_code		= "";
	protected String patient_id				= "";
	protected String pat_coll_med			= "";
	protected String collector_name			= "";
	protected String collector_nationality	= "";
	protected String collector_gender		= "";
	protected String selectedOrders			= "";
	protected String encounter_id			= "";
	protected String generatetokenyn        = "";
    protected String token_no				= "";
	protected Hashtable hashMultiple		= null;
	protected Hashtable prescriptionDetails = null;
	protected ArrayList arrListdrugClass	= null;
	private HashMap trade_codes				= new HashMap();
	private HashMap bl_override_det			= new HashMap();
	private HashMap stock_uom_det				= new HashMap();//ML-BRU-SCF-1798

    protected String from_date	= "";//add this for SRR20056-SCF-7807[28329]
	protected String to_date	= "";//add this for SRR20056-SCF-7807[28329]
	protected String patient_arrived = ""; //Added for Bru-HIMS-CRF-142 [IN:030195]
	protected String generate_actual_token_yn = ""; //Added for Bru-HIMS-CRF-142 [IN:030195]
    protected String defTokenSeries	=	"";
    protected HashMap patientPayable =	null; //added for Bru-HIMS-CRF-094 [IN:029959]
    protected HashMap hmPrescriptionDetails =	null; //added for Bru-HIMS-CRF-094 [IN:029959]
    protected String dispExpOrders = "Y";
    protected String autoCallReRoute_yn = "N";
    protected ArrayList registeredDetails = null;
    protected ArrayList printDetails = null;
	protected String sys_date = "";
	private String disp_before_start_date_yn="";//Added for COMMON-ICN-0120 [40745]
	private String disp_before_no_of_days="";//Added for COMMON-ICN-0120 [40745]
	private String disp_beyond_earliest_start_yn="";//Added for COMMON-ICN-0120 [40745]
	private String disp_beyond_no_of_days="";//Added for COMMON-ICN-0120 [40745]
	private String excl_ord_locn_dispense_yn="";//Added for ML-MMOH-CRF-2085

	public RegPrescriptionsBean() {
		try {
			prescriptionDetails= new Hashtable();		
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	String debug="0";
	/* Over-ridden Adapter methods start here */

	public void clear() {
		super.clear() ;
	}

	// Set methods start from here
	public void setDispLocations(String disp_locations){
		this.disp_locations = disp_locations;
	}
	public void setDispLocnCode(String disp_locn_code){
		this.disp_locn_code = disp_locn_code;
	}
	public String getDispLocnCode(){
		return this.disp_locn_code ;
	}
	public void setTokenSeriesCode(String token_series_code){
		this.token_series_code = token_series_code;
	}
	public void setPatientID(String patient_id){
		this.patient_id = patient_id;
	}
	public String getPatientID() {
		return this.patient_id;
    }
	public void setPatCollMed(String pat_coll_med){
		this.pat_coll_med = pat_coll_med;
	}
	public void setCollectorName(String collector_name){
		this.collector_name = collector_name;
	}
	public void setCollectorNationality(String collector_nationality){
		this.collector_nationality = collector_nationality;
	}
	public void setCollectorGender(String collector_gender){
		this.collector_gender	=	collector_gender;
	}
	public void setSelectedOrders(String selectedOrders){
		this.selectedOrders	=	selectedOrders;
	}
	public void setEncounterId(String encounter_id){
		this.encounter_id =  encounter_id;
	}
    public void setGenerateTokenYN(String generatetokenyn){
		this.generatetokenyn =  generatetokenyn;
	}
    public void settokenNo(String token_no){
		this.token_no =  token_no;
	}

	public void setFromDate(String from_date){ //add this for SRR20056-SCF-7807[28329]
		this.from_date = from_date;
	}
	public void setToDate(String to_date){  //add this for SRR20056-SCF-7807[28329]
		this.to_date = to_date;
	}
	public void setPatPrescriptionDetails(HashMap hmPrescriptionDetails){//added for Bru-HIMS-CRF-094 [IN:029959]
		if(this.hmPrescriptionDetails!=null)
			this.hmPrescriptionDetails.clear();
		this.hmPrescriptionDetails =  hmPrescriptionDetails;
	}
	public void setPatientPayable(String patient_id,String spatientPayable){ //added for Bru-HIMS-CRF-094 [IN:029959]
		if(this.patientPayable ==null)
			this.patientPayable = new HashMap();
		this.patientPayable.put(patient_id, spatientPayable);
	}
	//Added for Bru-HIMS-CRF-142 [IN:030195] -Start
	public void setPatientArrived(String patient_arrived){
		this.patient_arrived =  patient_arrived;
	}
	public void setGenerateActualToken(String generate_actual_token_yn){
		this.generate_actual_token_yn = generate_actual_token_yn;
	}
	//Added for Bru-HIMS-CRF-142 [IN:030195] -END
	public void setDisp_before_start_date_yn(String disp_before_start_date_yn) {
		this.disp_before_start_date_yn = disp_before_start_date_yn;
	}//Added for COMMON-ICN-0120 [40745]
	public void setDisp_before_no_of_days(String disp_before_no_of_days) {
		this.disp_before_no_of_days = disp_before_no_of_days;
	}//Added for COMMON-ICN-0120 [40745]
	public void setDisp_beyond_earliest_start_yn(String disp_beyond_earliest_start_yn) {
		this.disp_beyond_earliest_start_yn = disp_beyond_earliest_start_yn;
	}//Added for COMMON-ICN-0120 [40745]
	public void setDisp_beyond_no_of_days(String disp_beyond_no_of_days) {
		this.disp_beyond_no_of_days = disp_beyond_no_of_days;
	}//Added for COMMON-ICN-0120 [40745]
	public void setExclOrdLocnDispenseYN(String excl_ord_locn_dispense_yn) {
		this.excl_ord_locn_dispense_yn = excl_ord_locn_dispense_yn;
	}//Added for ML-MMOH-CRF-2085
	// Set methods ends here

	// Get methods start here
	public HashMap getPatPrescriptionDetails(){ //added for Bru-HIMS-CRF-094 [IN:029959]
		return this.hmPrescriptionDetails;
	}
	public String getPatientPayable(String patient_id){ //added for Bru-HIMS-CRF-094 [IN:029959]
		if(this.patientPayable!=null && patientPayable.containsKey(patient_id))
			return (String)(this.patientPayable.get(patient_id));
		else
			return null;
	}	
	public void clearPatientPayable(){ //added for Bru-HIMS-CRF-094 [IN:029959]
		if(this.patientPayable !=null)
			this.patientPayable.clear();
	}
	public HashMap getPatientPayable(){ //added for Bru-HIMS-CRF-094 [IN:029959]
			return this.patientPayable;
	}	
	public String getDebug(){
		return this.debug;
	}	
	public String getDispLocations(){
		return this.disp_locations;
	}

	public String gettrade_codes(String order_id,String order_line_num,String drug_code){	
        String trade_code="";
		if(trade_codes.containsKey(order_id+order_line_num+drug_code)){
            trade_code=(String)trade_codes.get(order_id+order_line_num+drug_code);
		}
		return trade_code;
	}

	public HashMap getbl_override_det(String order_id,String order_line_num,String drug_code){	
        HashMap tmp=new HashMap();
		if(bl_override_det.containsKey(order_id+order_line_num+drug_code)){
            tmp=(HashMap)bl_override_det.get(order_id+order_line_num+drug_code);
		}
		return tmp;
	}

	public String getStockUom(String order_id,String order_line_num,String drug_code){//ML-BRU-SCF-1798	
        String stock_uom = "";
		if(stock_uom_det.containsKey(order_id+order_line_num+drug_code)){
            stock_uom=(String)stock_uom_det.get(order_id+order_line_num+drug_code);
		}
		return stock_uom;
	}

	public String getFromDate(){ //add this for SRR20056-SCF-7807[28329]
		return this.from_date;
	}
	public String getToDate(){ //add this for SRR20056-SCF-7807[28329]
		return this.to_date;
	}
     public void setDefaultTokenSeries(String defTokenSeries) {
		this.defTokenSeries = defTokenSeries;
	}
	public String getDefaultTokenSeries() {
		return this.defTokenSeries;
	}
     public void setAutoCallReRouteYN(String autoCallReRoute_yn) {
		this.autoCallReRoute_yn = autoCallReRoute_yn;
	}
	public String getAutoCallReRouteYN() {
		return this.autoCallReRoute_yn;
	}
	
	public void setRegisteredOrders(ArrayList registeredDetails){//Added for ML-BRU-SCF-1199 [IN:045703]
		this.registeredDetails=registeredDetails;
	}

	public ArrayList getRegisteredOrders(){
		return this.registeredDetails;
	}
	
	public void setPrintResultDetails(ArrayList printDetails){
		this.printDetails = printDetails;
	}
	public ArrayList getPrintResultDetails(){
		return this.printDetails;
	}//Added for ML-BRU-SCF-1199 [IN:045703]--end
	
	public String getDisp_before_start_date_yn() {
		return disp_before_start_date_yn;
	}//Added for COMMON-ICN-0120 [40745]
	public String getDisp_before_no_of_days() {
		return disp_before_no_of_days;
	}//Added for COMMON-ICN-0120 [40745]
	public String getDisp_beyond_earliest_start_yn() {
		return disp_beyond_earliest_start_yn;
	}//Added for COMMON-ICN-0120 [40745]
	public String getDisp_beyond_no_of_days() {
		return disp_beyond_no_of_days;
	}//Added for COMMON-ICN-0120 [40745]
	public String getExclOrdLocnDispenseYN() {
		return excl_ord_locn_dispense_yn;
	}//Added for ML-MMOH-CRF-2085
	// Get methods ends here

	public String getDispExpOrders() {//Added for ML-BRU-SCF-0987 [IN:042737]
		return dispExpOrders;
	}
	public void setDispExpOrders(String dispExpOrders) {//Added for ML-BRU-SCF-0987 [IN:042737]
		this.dispExpOrders = dispExpOrders;
	}
	private void doCommon() throws Exception {
	}

	/* Over-ridden Adapter methods end here */

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}
	// setAll method to set all the values
	public void setAll(Hashtable recordSet){
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		hashMultiple = (Hashtable)recordSet.clone();
		/* 
			if the DOM object is having no_of_records element(i.e., Issue Token is not applicable) then
				On click of register...we have to UPDATE OR_ORDER,OR_ORDER_LINE tables 
			else
				On click of register...we have to UPDATE OR_ORDER,OR_ORDER_LINE,PH_TOKEN_SERIES tables and to INSERT INTO
				PH_DISP_QUEUE,PH_ORD_FOR_DISP_QUEUE
				Insert or Update PH_DISP_QUEUE_SUMM table
		*/

		if (recordSet.containsKey("no_of_records")){
			hashMultiple = (Hashtable)recordSet.clone();
		}
		else{
			if(recordSet.containsKey("disp_locn_code"))
				setDispLocnCode((String)recordSet.get("disp_locn_code")) ;
			if(recordSet.containsKey("token_series_code"))
				setTokenSeriesCode((String)recordSet.get("token_series_code")) ;
			if(recordSet.containsKey("patient_id"))
				setPatientID((String)recordSet.get("patient_id")) ;
			if (recordSet.containsKey("encounter_id")){
				setEncounterId((String)recordSet.get("encounter_id"));
			}
            if (recordSet.containsKey("gen_token_yn")){
				setGenerateTokenYN((String)recordSet.get("gen_token_yn"));
			}
			 if (recordSet.containsKey("token_no")){
				settokenNo((String)recordSet.get("token_no"));
			}
			if (recordSet.containsKey("pat_coll_med")){
				if (recordSet.get("pat_coll_med")!=null ){
					if (((String)recordSet.get("pat_coll_med")).equals("E")){
						setPatCollMed("Y");
						setCollectorName((String)recordSet.get("patient_name"));
						setCollectorNationality((String)recordSet.get("nationality"));
						setCollectorGender((String)recordSet.get("gender"));
						setTokenSeriesCode((String)recordSet.get("token_series_code_for_patient")) ;
					}
					else{
						setPatCollMed("N");
						setCollectorName((String)recordSet.get("med_pat_name"));
						setCollectorNationality((String)recordSet.get("med_pat_nationality"));
						setCollectorGender((String)recordSet.get("med_pat_gender"));						
					}
				}
				else{
					setPatCollMed("N");
					setCollectorName((String)recordSet.get("med_pat_name"));
					setCollectorNationality((String)recordSet.get("med_pat_nationality"));
					setCollectorGender((String)recordSet.get("med_pat_gender"));
				}
			}
			if (recordSet.containsKey("orders_selected")){
				setSelectedOrders((String)recordSet.get("orders_selected"));
			}
			
			if (recordSet.containsKey("patient_arrived")){	//Added for Bru-HIMS-CRF-142 [IN:030195] - start
	 			if(recordSet.get("patient_arrived").equals("")) 
					setPatientArrived("N");
				else
					setPatientArrived((String)recordSet.get("patient_arrived"));
			}
            if(recordSet.containsKey("generate_actual_token_yn")){
	            if(recordSet.get("generate_actual_token_yn").equals(""))
	                setGenerateActualToken("N");
	           else
	                setGenerateActualToken((String)recordSet.get("generate_actual_token_yn"));
				
			}//Added for Bru-HIMS-CRF-142 [IN:030195] - END
		}
	}

	public HashMap modify() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;

//		RegPrescriptionsHome   home=null;
//		RegPrescriptionsRemote remote=null;
		try{
			sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT8",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT8"));
			sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER_LINE",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_UPDATE_OR_ORDER_LINE"));
			if (hashMultiple.containsKey("no_of_orders")){
				tabData.put("identity","register");
			}
			else{
				StringTokenizer st= new StringTokenizer(selectedOrders,",");
				String no_of_selected_orders = st.countTokens()+"";
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_UPDATE_TOKEN_SERIES"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_SELECT15",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT15"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_SELECT14",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT14"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_UPDATE_DISP_QUEUE_SUMM"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE_SUMM"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_INSERT_ORD_FOR_DISP_QUEUE"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_SELECT24",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT24"));
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_SELECT25","SELECT MAX(TMP_TOKEN_SERIAL_NO)+1 TEMP_TOKEN_SERIES_NO FROM PH_DISP_QUEUE  WHERE FACILITY_ID = ? AND DISP_LOCN_CODE = ? AND QUEUE_DATE = TRUNC(SYSDATE) AND QUEUE_SHIFT = '*ALL' AND TOKEN_SERIES_CODE = ? ");	//Added for Bru-HIMS-CRF-142 [IN:030195]
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE1",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE1"));	//Added for Bru-HIMS-CRF-142 [IN:030195]
				sqlMap.put("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE2",PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_INSERT_DISP_QUEUE2"));	//Added for Bru-HIMS-CRF-142 [IN:030195]
				
				tabData.put("identity","issuetoken");
				tabData.put("disp_locn_code",disp_locn_code);
				tabData.put("token_series_code",token_series_code);
				tabData.put("patient_id",patient_id);
				tabData.put("pat_coll_med",pat_coll_med);
				tabData.put("collector_name",java.net.URLDecoder.decode(collector_name,"UTF-8"));
				tabData.put("collector_nationality",collector_nationality);
				tabData.put("token_series_desc",getTokenSeriesDesc(disp_locn_code,token_series_code));
				tabData.put("language_id",getLanguageId());
				tabData.put("patient_arrived",patient_arrived);	//Added for Bru-HIMS-CRF-142 [IN:030195]
				tabData.put("generate_actual_token_yn",generate_actual_token_yn);	//Added for Bru-HIMS-CRF-142 [IN:030195]

				if (collector_gender.equals("Male")){
					collector_gender="M";
				}
				else if (collector_gender.equals("Female")){
					collector_gender="F";
				}
				else if(collector_gender.equals("Both")){
					collector_gender="B";
				}
				tabData.put("collector_gender",collector_gender);
				tabData.put("no_of_selected_orders",no_of_selected_orders);
				tabData.put("encounter_id",encounter_id);
				tabData.put("generatetoken_yn",generatetokenyn);
				if(generatetokenyn.equals("N")){
					tabData.put("token_no",token_no);
				}		   
			}
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",prescriptionDetails);

			tabData.put("login_by_id", login_by_id ) ;
			tabData.put("login_at_ws_no", login_at_ws_no ) ;
			tabData.put("login_facility_id", login_facility_id ) ;
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_REG_PRESCRIPTIONS") ) ;

			home  = (RegPrescriptionsHome) PortableRemoteObject.narrow( object, RegPrescriptionsHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.modify( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_REG_PRESCRIPTIONS" ),RegPrescriptionsHome.class,getLocalEJB());
			Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] =new Object[2];
			argArray[0]= tabData;
			argArray[1]=sqlMap;

			Class  paramArray[] = new Class[2];
			paramArray[0]= tabData.getClass();
			paramArray[1] = sqlMap.getClass();
				
			HashMap result  = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				prescriptionDetails= new Hashtable();
				map.put( "result", new Boolean( true ) ) ;
				String msg = (String) result.get( "msgid" );
				StringTokenizer st = new StringTokenizer(msg,"&");
				String msg1 = "",msg2="";
				if(st.hasMoreTokens()){
					msg1 = st.nextToken();
				}
				if(st.hasMoreTokens()){
					msg2 = st.nextToken();
				}
				map.put( "message", getMessage(getLanguageId(),msg1,"PH"));
				map.put("flag",msg2);
			}
			else{
				//prescriptionDetails= new Hashtable();
				map.put( "message", (String) result.get( "msgid" )) ;
				map.put("flag","0");
			}
		}//try
		catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}//catch
/*		finally{
			try{
				if( remote != null )
					remote.remove() ;
			}//try
			catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
				map.put("flag","0");
				map.put("flag",debug);
	
			}//catch
		}//finally	*/	  
		return map;
	}

//	This method will check whether screen has to be displayed or not
	public ArrayList checkForTheDisplay(String facility_id)throws Exception{
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        PreparedStatement pstmt1 = null ;
		PreparedStatement pstmt2 = null ;

		ResultSet resultSet = null,resultSet1=null,resultSet2=null ;
        try {
            connection = getConnection() ;
		//	check whether the logged-in user is a pharmacist
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT1") ) ;
			pstmt.setString(1,login_by_id.trim());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				if(!resultSet.getString("PRACT_TYPE").equals("PH")){
					result.add("NO DISPLAY-1");
					return result;
				}
            }
			else{
				result.add("NO DISPLAY-1");
				return result;
			}
            closeResultSet(resultSet);
            closeStatement(pstmt);

		//  check whether OR module is installed or not
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT2") ) ;
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				if(resultSet.getInt("count")==0){
					result.add("NO DISPLAY-2");
					return result;
				}
            }
			else{
				result.add("NO DISPLAY-2");
				return result;
			}

			closeResultSet(resultSet);
            closeStatement(pstmt);

			String disp_locn_code="";
		//  check whether logged-in machine workstation no. maps with the ws_no in PH_WS_NO_FOR_DISP_LOCN
			String disp_locn_details="";
			boolean blncheck=false;
			boolean blnrightscheck=false;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT3") ) ;
			pstmt1 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT4") ) ;
			pstmt2 = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT5") ) ;
						
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,login_at_ws_no.trim());
            resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {

//				pstmt = connection.prepareStatement( //PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT4") ) ;
				pstmt1.setString(1,facility_id.trim());
				pstmt1.setString(2,(resultSet.getString("DISP_LOCN_CODE")).trim());
				pstmt1.setString(3, getLanguageId());
				resultSet1 = pstmt1.executeQuery() ;
				if ( resultSet1 != null && resultSet1.next() ) {
//					debug+="inside if";
					disp_locn_code =resultSet.getString("DISP_LOCN_CODE");
					if (!resultSet1.getString("DISP_REGN_REQD_YN").equals("N")){
//						debug+="inside if if";
						blncheck=true;
						pstmt2.setString(1,facility_id.trim());
			    		pstmt2.setString(2,(resultSet.getString("DISP_LOCN_CODE")).trim());
						pstmt2.setString(3,login_by_id.trim());
						resultSet2 = pstmt2.executeQuery();
						if (resultSet2!=null && resultSet2.next()){
							if ((resultSet2.getString("ACK_YN")).equals("Y")){
								blnrightscheck = true;
//								debug+="inside if if if";
								String disp_code = resultSet1.getString("DISP_LOCN_CODE");
								String disp_desc = resultSet1.getString("SHORT_DESC");
								disp_locn_details =disp_locn_details + (disp_code + ","+disp_desc +",");
							}
						}
						 closeResultSet(resultSet2);
					}
    			}
			   	closeResultSet(resultSet1);
           }
            closeResultSet(resultSet);

			if ((disp_locn_code.trim()).equals("")){
				result.add("NO DISPLAY-3");
				return result;
			}
			else if (blncheck==false){
				result.add("NO DISPLAY-4");
				return result;
			}
			else if(blnrightscheck==false){
				result.add("NO DISPLAY-5");
				return result;
			}
			else{
				result.add(disp_locn_details);
				setDispLocations(disp_locn_details);
				return result;
			}
		//  DISP_LOCN_CODE can be 1 or more.Go to the respective disp locn in PH_DISP_LOCN table and check disp_regn_reqd_yn is 'Y' or 'N'  and check the dispense rights table ....

        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet1 ) ;
				closeResultSet( resultSet2 ) ;
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
	}

	// This method is used to display the Patient Id's based on the query criteria.
	public ArrayList getDataForThePatientFrame(String patient_id,String order_id,String priority,String order_status,String order_date_from,String order_date_to,String disp_locn_code,String ord_loc_type,String ord_locn_code)throws Exception{
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		StringBuffer stbAppend = new StringBuffer();
		String source_codetype="";//Added For IN[5935]
		String excl_ord_locn_dispense_yn = getExclOrdLocnDispenseYN();//Added for ML-MMOH-CRF-2085
        try {
			getSysdate();
			patient_id		=  patient_id==null	? "" : patient_id ;
			order_id		=  order_id==null? "" : order_id ;
			priority		=  priority==null? "" : priority ;
			order_date_from	=  order_date_from==null? sys_date : order_date_from ;
			order_date_to	=  order_date_to==null? sys_date : order_date_to ;
			setPatientID(patient_id) ;
			/*  This is formed dynamically depending status...
				A -->  All Prescriptions
				P -->  Pending Prescriptions
				B -->  BMS Prescriptions
				R -->  Refill Prescriptions
				D -->  Discharge Medication
				E -->  Expired Prescription	*/
			if(!priority.equals(""))
				stbAppend.append(" AND B.PRIORITY= ? ");
			if(!patient_id.equals(""))
				stbAppend.append(" AND A.PATIENT_ID = ? ");
			if(!order_id.equals(""))
				stbAppend.append(" AND A.ORDER_ID= ? ");

			if (order_status.equals("A")){
				//strAppend	= " AND C.ORDER_STATUS_TYPE IN ('10','56') ";
				//Removed AND A.CHILD_ORDER_YN!='Y' for the incident num:24630,24732 When Order status=All(A) ,Discharge Medication(D) on 29/OCT/2010===By Sandhya
				stbAppend.append(" AND ((B.START_DATE_TIME  BETWEEN TO_DATE(?,'DD/MM/RRRR')AND TO_DATE(?,'DD/MM/RRRR') + 0.99999) OR (TO_DATE(C.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR')))  AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE in('10','56','94')) "); 
				//AND( B.END_DATE_TIME >= TRUNC(SYSDATE) 	 OR (TO_DATE(C.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR'))OR(B.END_DATE_TIME >= TRUNC(SYSDATE) AND A.DISCHARGE_IND='D' )) "; // commented for KAUH-SCF-0064 [IN:034839] && A.ORD_DATE_TIME
			}
			else if (order_status.equals("P")){
				stbAppend.append(" AND B.START_DATE_TIME  BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') + 0.99999  AND A.CHILD_ORDER_YN!='Y' AND B.END_DATE_TIME >= TRUNC(SYSDATE)  AND B.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58') AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE in( '10','94')) "); //A.DISCHARGE_IND='D' removed for Bru-HIMS-CRF-090 [IN:34114] from ==> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58' OR A.DISCHARGE_IND='D') &&  A.ORD_DATE_TIME
			}
			else if (order_status.equals("B")){
				//strAppend	= " AND C.NEXT_COLLECTION_DATE  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR') + 0.99999 AND A.CHILD_ORDER_YN!='Y' AND B.END_DATE_TIME >= TRUNC(SYSDATE)  AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '56') AND TO_DATE(C.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR') ";
				stbAppend.append(" AND C.NEXT_COLLECTION_DATE  BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') + 0.99999  AND B.END_DATE_TIME >= TRUNC(SYSDATE)  AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '56') AND TO_DATE(C.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') AND  A.ORD_DATE_TIME  BETWEEN sysdate-720 and sysdate+365 ");
			}
			else if (order_status.equals("R")){
				//strAppend	= "AND  A.ORD_DATE_TIME  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR') + 0.99999 AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE A.CHILD_ORDER_YN='Y' AND ORDER_STATUS_TYPE = '10')  ";
				stbAppend.append("AND  B.START_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY')  AND TO_DATE(?,'DD/MM/YYYY') + 0.99999 AND A.CHILD_ORDER_YN='Y' AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '10')  ");
     			 // SRR20056-SCF-7476, Incident No.27526 , condition added 	A.CHILD_ORDER_YN='Y' and removed a.discharge_ind!='D' as discharge orders should appear  && code 'A.ORD_DATE_TIME' is replaced by 'B.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			}
			else if (order_status.equals("D")){
				stbAppend.append( "AND B.START_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') + 0.99999 AND A.DISCHARGE_IND='D' AND A.CHILD_ORDER_YN!='Y' AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE  (ORDER_STATUS_TYPE = '10' OR ORDER_STATUS_TYPE = '56'))  ");
				// SRR20056-SCF-7476, Incident No.27526 , condition added in the main from sub query A.CHILD_ORDER_YN='Y' && code 'A.ORD_DATE_TIME' is replaced by 'B.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			}
			else if (order_status.equals("E")){
				stbAppend.append( "AND B.START_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') + 0.99999 AND B.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58') AND A.ORDER_STATUS IN ('OS','DP') AND B.END_DATE_TIME < TRUNC(SYSDATE) AND  TRUNC(SYSDATE) <= TRUNC(B.END_DATE_TIME)+E.DISP_BEYOND_NO_OF_DAYS "); // code 'A.ORD_DATE_TIME' is replaced by 'B.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			} 
			else if(order_status.equals("XT")) {
				//strAppend	= "AND  A.ORD_DATE_TIME  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR') + 0.99999 AND A.CHILD_ORDER_YN!='Y' AND B.END_DATE_TIME >= TRUNC(SYSDATE)  AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '10' or ORDER_STATUS_TYPE = '56') ";
				stbAppend.append( "AND  B.START_DATE_TIME   BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') + 0.99999  AND B.END_DATE_TIME >= TRUNC(SYSDATE)  AND B.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '10' or ORDER_STATUS_TYPE = '56') "); // code 'A.ORD_DATE_TIME' is replaced by 'B.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			}
			if(getDispExpOrders().equals("N")){//Added for ML-BRU-SCF-0987 [IN:042737]
				//  stbAppend.append("AND TRUNC (B.END_DATE_TIME) >= TRUNC (SYSDATE)" ); 
				stbAppend.append("AND B.END_DATE_TIME >= SYSDATE " ); // modified for ML-BRU-SCF-2279
			}

			if(order_status.equals("XT")) {
				stbAppend.append( " AND A.PATIENT_CLASS='XT' ");
			}
			else if(order_status.equals("A")) {
				stbAppend.append(" AND A.PATIENT_CLASS in('XT','OP','EM')  ");			
			} 
			else {
				stbAppend.append(" AND A.PATIENT_CLASS in('OP','EM')  ");		
			}
		
			if(!order_status.equals("XT")) {
				if(ord_loc_type.equals("C")) //if block added for ML-BRU-SCF-0324
					ord_loc_type = "'C', 'E'";
					/*Below code  added for ML-BRU-SCF-0356[IN034602]--Start*/
				else if(ord_loc_type.equals("N")) 
					ord_loc_type = "'"+ord_loc_type+"'";
				else if(ord_loc_type.equals("")){
			    //	ord_loc_type =    "'C','E','N'"; ////Commented for ML-MMOH-SCF-0605
					ord_loc_type = "";//Added for ML-MMOH-SCF-0605
				}
				else
					ord_loc_type = "'"+ord_loc_type+"'";
				//ADDED  for ML-MMOH-SCF-0605
				if(ord_loc_type.equals("")) {
					stbAppend.append("AND NVL(A.SOURCE_code,'X') = NVL(?,NVL(A.SOURCE_CODE,'X'))  "); 
				}
				else{
				stbAppend.append(" AND NVL(A.SOURCE_type,'X') in  ( "+ord_loc_type+" )  AND NVL(A.SOURCE_code,'X') = NVL(?,NVL(A.SOURCE_CODE,'X'))  "); // AND NVL(A.SOURCE_type,'X') = NVL (decode(a.patient_class,'XT','',?), changed to  AND NVL(A.SOURCE_type,'X') in NVL (decode(a.patient_class,'XT','',?),  --- NVL (decode(a.patient_class,'XT','', "+ord_loc_type+" )  for ML-BRU-SCF-0324 ---- , NVL (a.source_type, 'X') Removed for ML-BRU-SCF-0356[IN034602]
				}
				//ADDED for ML-MMOH-SCF-0605.1
						
			}else if(order_status.equals("XT"))//added for IN[5972] start
			{
				stbAppend.append("AND NVL(A.SOURCE_code,'X') = NVL(?,NVL(A.SOURCE_CODE,'X')) ");//added for IN[5972]  
			}//end for IN 5972
			
			if(excl_ord_locn_dispense_yn.equals("Y"))//Added for ML-MMOH-CRF-2085
				stbAppend.append( "	GROUP BY A.PATIENT_ID,G.PATIENT_NAME,g.patient_name_loc_lang,G.SEX, F.COUNTRY_CODE,F.LONG_DESC, G.DATE_OF_BIRTH ORDER BY A.PATIENT_ID");// A.PATIENT_CLASS, A.ENCOUNTER_ID removed for ML-MMOH-CRF-2085
			else
				stbAppend.append( "	GROUP BY A.PATIENT_ID,G.PATIENT_NAME,g.patient_name_loc_lang,G.SEX, F.COUNTRY_CODE,F.LONG_DESC,G.DATE_OF_BIRTH,A.PATIENT_CLASS, A.ENCOUNTER_ID ORDER BY A.PATIENT_ID");//code ', A.ENCOUNTER_ID ORDER BY A.PATIENT_ID' added for JD-CRF-0156[IN041737]
			connection = getConnection() ;
			System.out.println(" 706===========>RegPrescriptionsBean.java "+PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT7") + stbAppend.toString());
			
			if(excl_ord_locn_dispense_yn.equals("Y"))//Added for ML-MMOH-CRF-2085
				pstmt = connection.prepareStatement( "SELECT A.PATIENT_ID,nvl( decode(?,'en',g.patient_name, g.patient_name_loc_lang),g.patient_name)patient_name ,DECODE(G.SEX,'M','male','F','female','U','unknown')SEX,G.SEX GENDER, F.COUNTRY_CODE,F.LONG_DESC NATIONALITY_DESC,	 COUNT(DISTINCT B.ORDER_ID) TOTAL_PRES,GET_AGE(G.DATE_OF_BIRTH) AGE FROM OR_ORDER A, OR_ORDER_LINE B,OR_ORDER_LINE_PH C,PH_FACILITY_PARAM E,MP_PATIENT G,MP_COUNTRY_LANG_VW F WHERE A.ORDERING_FACILITY_ID=E.FACILITY_ID AND G.PATIENT_ID = A.PATIENT_ID AND A.ORDER_ID = B.ORDER_ID AND A.ORDER_ID=C.ORDER_ID AND B.ORDER_ID=C.ORDER_ID AND B.ORDER_LINE_NUM=C.ORDER_LINE_NUM AND G.NATIONALITY_CODE = F.COUNTRY_CODE(+) AND PH_CHECK_ORD_DATE_DISPENSING(B.START_DATE_TIME,B.END_DATE_TIME,?,?,?,?,?)=1  AND A.ORDER_CATEGORY='PH' AND A.PERFORMING_DEPTLOC_CODE=? AND A.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS) AND F.LANGUAGE_ID(+) = ? " + stbAppend.toString() ) ; // removed encounter_id for ML-MMOH-CRF-2085
			else
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT7") + stbAppend.toString() ) ;
			
			int count=1;
			if(order_status.equals("B")|| order_status.equals("A")){
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,login_facility_id.trim());  
				pstmt.setString(count++,getDisp_before_start_date_yn());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,getDisp_before_no_of_days());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,getDisp_beyond_earliest_start_yn());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,getDisp_beyond_no_of_days());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,disp_locn_code.trim());
				//pstmt.setString(6,disp_locn_code.trim());
				pstmt.setString(count++,getLanguageId());
				if(!priority.equals(""))
					pstmt.setString(count++,priority.trim());
				if(!patient_id.equals(""))
					pstmt.setString(count++,patient_id.trim());
				if(!order_id.equals(""))
					pstmt.setString(count++,order_id.trim());
				pstmt.setString(count++,order_date_from.trim());
				pstmt.setString(count++,order_date_to.trim());
				if (order_status.equals("A")){
					pstmt.setString(count++,order_date_from.trim());
					pstmt.setString(count++,order_date_to.trim());
					pstmt.setString(count++,ord_locn_code.trim());
				}
				else{
					pstmt.setString(count++,order_date_from.trim());
					pstmt.setString(count++,order_date_to.trim());
					pstmt.setString(count++,ord_locn_code.trim());
				}
				//pstmt.setString(12,ord_loc_type.trim()); //Commented for ML-BRU-SCF-0324
			} 
			else {
				pstmt.setString(count++,getLanguageId());
				pstmt.setString(count++,login_facility_id.trim());
				pstmt.setString(count++,getDisp_before_start_date_yn());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,getDisp_before_no_of_days());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,getDisp_beyond_earliest_start_yn());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,getDisp_beyond_no_of_days());//Added for COMMON-ICN-0120 [40745]
				pstmt.setString(count++,disp_locn_code.trim());
				//pstmt.setString(6,disp_locn_code.trim());
				pstmt.setString(count++,getLanguageId());
				if(!priority.equals(""))
					pstmt.setString(count++,priority.trim());
				if(!patient_id.equals(""))
					pstmt.setString(count++,patient_id.trim());
				if(!order_id.equals(""))
					pstmt.setString(count++,order_id.trim());
				pstmt.setString(count++,order_date_from.trim());
				pstmt.setString(count++,order_date_to.trim());
				if(!order_status.equals("XT")) {
					//pstmt.setString(10,ord_loc_type.trim());  //Commented for ML-BRU-SCF-0324
					pstmt.setString(count++,ord_locn_code.trim());
				}else{//added for IN[5935]
					
					pstmt.setString(count++,source_codetype);
				}//end IN[5935]
			}

            resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("PATIENT_ID"));
				result.add(checkForNull(resultSet.getString("PATIENT_NAME")));
				result.add(checkForNull(resultSet.getString("AGE")));
				result.add(checkForNull(resultSet.getString("SEX")));
				result.add(checkForNull(resultSet.getString("NATIONALITY_DESC")));
				result.add(checkForNull(resultSet.getString("TOTAL_PRES")));
				result.add("");
				result.add(checkForNull(resultSet.getString("COUNTRY_CODE")));
				result.add(checkForNull(resultSet.getString("GENDER")));
				if(excl_ord_locn_dispense_yn.equals("Y")){//Added for ML-MMOH-CRF-2085
					result.add("");
					result.add("");
				}
				else{
					result.add(checkForNull(resultSet.getString("PATIENT_CLASS")));//code added for JD-CRF-0156[IN041737]
					result.add(checkForNull(resultSet.getString("ENCOUNTER_ID")));//code added for JD-CRF-0156[IN041737]
				}
            }
			closeResultSet(resultSet);
            closeStatement(pstmt);
		}
        catch ( Exception e ) {
            System.err.println( "Param vaules strAppend" +stbAppend+ " patient_id="+ patient_id+" order_id="+order_id+" priority="+priority+" order_status="+order_status+" order_date_from="+ order_date_from+" order_date_to="+ order_date_to+" disp_locn_code="+disp_locn_code+" ord_loc_type="+ ord_loc_type+ " ord_locn_code="+ord_locn_code) ;
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace() ;
			}
        }
		return result;
	}
	
	/* 
		This function will return an ArrayList which contains DISP_AUTH_REQD_DRUG_YN, DISP_NARCOTIC_YN, DISP_CONTROLLED_DRUG_YN Based on the Dispense Location Code ,login facility-id and login user-id
	*/
	public ArrayList buildDrugRelatedSQL(String disp_locn_code){
		ArrayList result = new ArrayList();
		String general_drug		= "";
		String narcotic_drug	= "";
		String controlled_drug	= "";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT16") ) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,disp_locn_code.trim());
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				general_drug	=	resultSet.getString("DISP_AUTH_REQD_DRUG_YN"); 
				narcotic_drug	=	resultSet.getString("DISP_NARCOTIC_YN"); 
				controlled_drug =	resultSet.getString("DISP_CONTROLLED_DRUG_YN"); 
			}
			closeResultSet( resultSet ) ;
            closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			  try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { System.out.println(es); }
		}
		
		if (general_drug.equals("Y")){
			result.add("G");
		}
		if (narcotic_drug.equals("Y")){
			result.add("N");
		}
		if (controlled_drug.equals("Y")){
			result.add("C");
		}
		arrListdrugClass = result;
		return result;
	}

	/*	The following function is used to display the orders based on the patient_id and query criteria	*/
	public ArrayList getDataForTheFooter(String patient_id,String order_id,String priority,String order_status,String order_date_from,String order_date_to,String disp_locn_code,String encounter_id)throws Exception{ //encounter_id added for SKR-SCF-1273.1
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		StringBuffer strAppend = new StringBuffer();
		boolean multi_facility_reg_app = false;//ML-BRU-SCF-2061
        try {
			if (priority==null){
				priority="";
			}
			/*	This is formed dynamically depending status...
				A -->  All Prescriptions
				P -->  Pending Prescriptions
				B -->  BMS Prescriptions
				R -->  Refill Prescriptions
				D -->  Discharge Medication	*/
			order_date_from	=  order_date_from==null? sys_date : order_date_from ;
			order_date_to	=  order_date_to==null? sys_date : order_date_to ;
			if(priority!=null && !priority.equals(""))
				strAppend.append(" AND A.PRIORITY= ? ");
			if(order_id!=null && !order_id.equals(""))
				strAppend.append(" AND A.ORDER_ID= ? ");

			if (order_status.equals("P")){
				strAppend.append(" AND  TO_DATE(G.START_DATE_TIME,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') AND A.CHILD_ORDER_YN!='Y' AND G.END_DATE_TIME >= SYSDATE AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58') AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE in( '10','94')) "); // A.DISCHARGE_IND='D' removed for Bru-HIMS-CRF-090 [IN:34114] from ==> (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58' OR A.DISCHARGE_IND='D')  &&  // code 'A.ORD_DATE_TIME' is replaced by 'G.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564] trunc is removed for ML-MMOH-SCF-0524 [IN062015] ML-BRU-SCF-1700 
			}
			else if (order_status.equals("B")){
				//strAppend	= " AND TO_DATE(I.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR') AND A.CHILD_ORDER_YN!='Y' AND G.END_DATE_TIME >= TRUNC(SYSDATE) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58' OR A.DISCHARGE_IND='D') AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '56')  ";
				//strAppend	= " AND TO_DATE(I.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR') AND A.CHILD_ORDER_YN!='Y' AND G.END_DATE_TIME >= TRUNC(SYSDATE) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58' ) AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '56')  ";
				strAppend.append(" AND TO_DATE(I.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR')  AND G.END_DATE_TIME >= TRUNC(SYSDATE) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58' ) AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '56')  ");
			}
			else if (order_status.equals("R")){
				strAppend.append(" AND  TO_DATE(G.START_DATE_TIME ,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR')AND A.CHILD_ORDER_YN='Y' AND  G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58') AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '10')  ");
			}
			else if (order_status.equals("D")){
				strAppend.append( " AND  TO_DATE(G.START_DATE_TIME,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR')AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58') AND A.CHILD_ORDER_YN!='Y' AND  A.DISCHARGE_IND='D' AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE  (ORDER_STATUS_TYPE = '10' OR ORDER_STATUS_TYPE = '56'))  ");// code 'A.ORD_DATE_TIME' is replaced by 'G.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			}
			else if (order_status.equals("E")){
				strAppend.append( " AND  TO_DATE(G.START_DATE_TIME,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR')   AND TO_DATE(?,'DD/MM/RRRR')AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58') AND A.ORDER_STATUS IN ('OS','DP') AND G.END_DATE_TIME< TRUNC(SYSDATE) AND  SYSDATE <= TRUNC(G.END_DATE_TIME)+H.DISP_BEYOND_NO_OF_DAYS ");// code 'A.ORD_DATE_TIME' is replaced by 'G.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			}
			else if (order_status.equals("XT")){
				//strAppend	= " AND  TO_DATE(A.ORD_DATE_TIME,'DD/MM/RRRR')  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR')AND A.CHILD_ORDER_YN!='Y' AND G.END_DATE_TIME >= TRUNC(SYSDATE) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58' OR A.DISCHARGE_IND='D') AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '10' OR ORDER_STATUS_TYPE = '56') ";
				strAppend.append(" AND  TO_DATE(G.START_DATE_TIME,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') AND G.END_DATE_TIME >= TRUNC(SYSDATE) AND G.ORDER_LINE_STATUS NOT IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '58' OR A.DISCHARGE_IND='D') AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE = '10' OR ORDER_STATUS_TYPE = '56') ");// code 'A.ORD_DATE_TIME' is replaced by 'G.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			}
			else if(order_status.equals("A")){

				//strAppend	= " AND  TO_DATE(A.ORD_DATE_TIME,'DD/MM/RRRR') BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR')AND A.CHILD_ORDER_YN!='Y' AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE in ('56','10','94'))and( (G.END_DATE_TIME >= TRUNC(SYSDATE))or( TO_DATE(I.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR'))or(G.END_DATE_TIME >= TRUNC(SYSDATE)and A.DISCHARGE_IND='D' ))";
				//Removed AND A.CHILD_ORDER_YN!='Y' condition for the incidentnum:24640 on 22/Oct/2010
				strAppend.append( " AND ( TO_DATE(G.START_DATE_TIME,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR') or( TO_DATE(I.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(?,'DD/MM/RRRR')  AND TO_DATE(?,'DD/MM/RRRR'))) AND G.ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE in ('56','10','94'))"); //and( (G.END_DATE_TIME >= TRUNC(SYSDATE))or( TO_DATE(I.NEXT_COLLECTION_DATE,'DD/MM/RRRR')  BETWEEN TO_DATE(NVL(?,'01-01-2000'),'DD/MM/RRRR')  AND TO_DATE(NVL(?,'01-01-3000'),'DD/MM/RRRR'))or(G.END_DATE_TIME >= TRUNC(SYSDATE)and A.DISCHARGE_IND='D' )) // commented for KAUH-SCF-0064 [IN:034839] && // code 'A.ORD_DATE_TIME' is replaced by 'G.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564]
			}

			connection = getConnection() ;
			multi_facility_reg_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","MULTI_FACILITY_REG_APP"); // added for ML-BRU-SCF-2061

			if(encounter_id!=null && !encounter_id.equals("") && !multi_facility_reg_app){ //encounter_id added for SKR-SCF-1273.1
			strAppend.append("AND A.ENCOUNTER_ID=?");
			}

			if(getDispExpOrders().equals("N"))//Added for ML-BRU-SCF-0987 [IN:042737]
				strAppend.append( " AND TRUNC (G.END_DATE_TIME) >= TRUNC (SYSDATE) ") ;
			if(order_status.equals("XT")) {
				strAppend.append( " AND A.PATIENT_CLASS='XT' ");
			}
			else if(order_status.equals("A")){
				strAppend.append(" AND A.PATIENT_CLASS in('OP','EM','XT') ");			
			} 
			else {
				strAppend.append( " AND A.PATIENT_CLASS in('OP','EM') ");		
			}

			/*	Based on the drug class, form the condition which should be appended
				to the Query.	*/

			strAppend.append(" GROUP BY A.ORDER_ID,A.PRIORITY,A.ORDER_TYPE_CODE,A.SOURCE_CODE,B.SHORT_DESC,G.START_DATE_TIME,A.PATIENT_CLASS,A.PERFORMING_FACILITY_ID, A.SOURCE_TYPE, A.ORD_PRACT_ID ,E.PRACTITIONER_NAME, G.ORDER_LINE_STATUS, A.CHILD_ORDER_YN,A.DISCHARGE_IND,A.ENCOUNTER_ID,B.LANGUAGE_ID,a.ordering_facility_id ORDER BY G.START_DATE_TIME ASC");// code 'A.ORD_DATE_TIME' is replaced by 'G.START_DATE_TIME' for Bru-HIMS-CRF-418[IN045564] DESC CHANGED TO ASC FOR ML-MMOH-SCF-0524[IN062015] ML-BRU-SCF-1700
			//connection = getConnection() ;
			
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT6")+strAppend.toString() );
			int count=1;
			pstmt.setString(count++,patient_id.trim());
			pstmt.setString(count++,login_facility_id.trim());
			pstmt.setString(count++,getDisp_before_start_date_yn());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(count++,getDisp_before_no_of_days());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(count++,getDisp_beyond_earliest_start_yn());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(count++,getDisp_beyond_no_of_days());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(count++,disp_locn_code.trim());
			//pstmt.setString(6,disp_locn_code.trim());
			pstmt.setString(count++,getLanguageId());
			if(priority!=null && !priority.equals(""))
				pstmt.setString(count++,priority.trim());
			if(order_id!=null && !order_id.equals(""))
				pstmt.setString(count++,order_id.trim());
			pstmt.setString(count++,order_date_from.trim());
			pstmt.setString(count++,order_date_to.trim());
			
           if (order_status.equals("A")){
				pstmt.setString(count++,order_date_from.trim());
				pstmt.setString(count++,order_date_to.trim());
			} // commented for KAUH-SCF-0064 [IN:034839]
			if(encounter_id!=null && !encounter_id.equals("") && !multi_facility_reg_app){ //encounter_id added for SKR-SCF-1273.1
				pstmt.setString(count++,encounter_id.trim());
			}

            resultSet = pstmt.executeQuery() ;
            ArrayList chkDuplicate = new ArrayList(); //added for ML-BRU-SCF-0414[IN035053]
            while ( resultSet != null && resultSet.next() ) {			    
				if( !(chkDuplicate.contains(resultSet.getString("ORDER_ID"))) ){ //if condition added for ML-BRU-SCF-0414[IN035053]	   
				    chkDuplicate.add(resultSet.getString("ORDER_ID")); //added for ML-BRU-SCF-0414[IN035053]
					result.add(resultSet.getString("PRIORITY")); //0
					result.add(resultSet.getString("ORDER_TYPE_CODE"));
					result.add(resultSet.getString("ORDER_TYPE_DESC"));
					result.add(resultSet.getString("ORDER_ID"));
					result.add(resultSet.getString("START_DATE_TIME"));//code 'ORD_DATE_TIME' replaced by START_DATE_TIME for Bru-HIMS-CRF-418[IN045564] 
					result.add(resultSet.getString("SOURCE_DESC"));
					result.add(resultSet.getString("ORD_PRACT_ID"));
					result.add(resultSet.getString("PRACTITIONER_NAME"));
					result.add(resultSet.getString("ORDER_LINE_STATUS"));
					result.add(resultSet.getString("CHILD_ORDER_YN"));
					result.add(checkForNull(resultSet.getString("DISCHARGE_IND")));	//10
					result.add(resultSet.getString("ENCOUNTER_ID"));
				}		
			}
			closeResultSet( resultSet ) ;
            closeStatement( pstmt ) ;
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
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return result;
	}

	/*	This function is used to display the order_line details based on order_id,login facility_id and drug class	*/
	public ArrayList getDrugDosageDetails(String order_id,String disp_locn_code)throws Exception{
		String ivprechk = "";
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		ArrayList  arrListDrug = null;
		HashMap temp = new HashMap();
		StringBuffer strAppend = new StringBuffer();
		if (arrListdrugClass == null){
			arrListDrug = buildDrugRelatedSQL(disp_locn_code);
		}
		else{
			arrListDrug = arrListdrugClass;
		}
		strAppend.append(" AND ( ");
		int k=1;
		for (int i=0;i<arrListDrug.size();i++){
			if (i==0){
				strAppend.append(" H.DRUG_CLASS = '"+(String)arrListDrug.get(i)+"' ");
			}
			else{
				strAppend.append(" OR H.DRUG_CLASS = '"+(String)arrListDrug.get(i)+"' ");;
			}
			k++;
		}
		strAppend.append( " ) ");
		if (k==1){
			strAppend.delete(0, strAppend.length());
		}
		if(getDispExpOrders().equals("N"))//ML-BRU-SCF-0987.1 [IN:045161] 
			strAppend.append( " AND TRUNC (A.END_DATE_TIME) >= TRUNC (SYSDATE) " );
	
        try {
			connection = getConnection() ; 
            String  ext_prod_id ="";

		  // pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT9")+ strDrugRelatedSQL ) ;
			pstmt = connection.prepareStatement( "SELECT /*+ Index(a or_order_line_i22) */ a.order_line_num, a.order_catalog_code, a.catalog_desc, b.drug_desc || (select decode(short_name,null,null,' ('||substr(short_name,1,20)||')') from am_trade_name_lang_vw k where k.trade_id = j.trade_code and k.language_id = c.language_id) drug_desc, DECODE (INSTR (a.qty_value, '.'),0, TO_CHAR (a.qty_value),RTRIM (TO_CHAR (a.qty_value, '9999999990.00000000'),'0')) qty_value, a.qty_unit, c.short_desc qty_unit_desc, d.freq_desc, a.durn_value, e.durn_desc, a.order_line_status,i.iv_prep_yn,ph_get_ext_prod_drug_code(b.drug_code,?)EXTERNAL_PRODUCT_ID,NVL(ph_calculatebalance(a.order_id,a.order_line_num),A.ORDER_QTY)   BMS_QTY ,j.trade_code trade_code,b.IN_FORMULARY_YN IN_FORMULARY_YN,j.BL_INCL_EXCL_OVERRIDE_VALUE, j.BL_INCL_EXCL_OVERRIDE_REASON ,i.ORDERING_FACILITY_ID ORDERING_FACILITY_ID,b.drug_yn drug_yn, J.TAPERED_YN,a.ORDER_UOM, J.TAPER_ORDER_ID,decode(b.Drug_yn,'N','',k.ROUTE_DESC)ROUTE_DESC,k.ROUTE_COLOR FROM or_order_line a,ph_drug_lang_vw b,am_uom_lang_vw c,am_frequency_lang_vw d,am_duration_type_lang_vw e,ph_facility_param f,or_order_status_code_lang_vw g,ph_order_type_for_drug_class h, or_order i,or_order_line_ph j,ph_route_lang_vw k WHERE g.order_status_type IN ('10', '56', '25','94')AND a.order_type_code = h.order_type_code(+) AND a.order_id = i.order_id AND a.order_line_status = g.order_status_code AND a.order_catalog_code = b.drug_code(+) AND a.order_id = ? AND a.qty_unit = c.uom_code AND a.freq_code = d.freq_code  AND a.durn_type = e.durn_type  AND f.facility_id = ?   AND ph_check_ord_date_dispensing (a.start_date_time, a.end_date_time, ?,?,?,?,?) > 0 AND k.route_code=a.route_code  AND c.language_id = d.language_id AND c.language_id = e.language_id AND c.language_id = e.language_id AND c.language_id = g.language_id AND c.language_id = ? AND b.language_id(+) = ? and b.language_id = k.language_id and j.order_id = a.order_id and j.order_line_num = a.order_line_num  "+ strAppend.toString() ) ;// added decode(b.Drug_yn,'N','',k.ROUTE_DESC)ROUTE_DESC,k.ROUTE_COLOR,,ph_route_lang_vw k,and b.language_id = k.language_id and j.order_id = a.order_id and j.order_line_num = a.order_line_num for CRF RUT-CRF-0034.1[IN:037389]//Modify PH_CHECK_ORD_DATE_DISPENSING for COMMON-ICN-0120 [40745] 
//order_uom added for ML-BRU-SCF-1798
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,order_id.trim());
			pstmt.setString(3,login_facility_id.trim());
			pstmt.setString(4,login_facility_id.trim());
			pstmt.setString(5,getDisp_before_start_date_yn());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(6,getDisp_before_no_of_days());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(7,getDisp_beyond_earliest_start_yn());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(8,getDisp_beyond_no_of_days());//Added for COMMON-ICN-0120 [40745]
			pstmt.setString(9, getLanguageId());
			pstmt.setString(10, getLanguageId());
		    resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("ORDER_CATALOG_CODE"));	//0
				ivprechk = resultSet.getString("iv_prep_yn")== null?"":resultSet.getString("iv_prep_yn");
			
				if(ivprechk.equals("8"))
					result.add(resultSet.getString("CATALOG_DESC"));
				else
					result.add(resultSet.getString("DRUG_DESC"));
				result.add(resultSet.getString("QTY_VALUE"));
				result.add(resultSet.getString("QTY_UNIT"));
				result.add(resultSet.getString("QTY_UNIT_DESC"));				
				result.add(resultSet.getString("FREQ_DESC"));
				result.add(resultSet.getString("DURN_VALUE"));
				result.add(resultSet.getString("DURN_DESC"));
				result.add(resultSet.getString("ORDER_LINE_NUM"));
				result.add(order_id);
				result.add(resultSet.getString("ORDER_LINE_STATUS")); //10
                ext_prod_id=checkForNull(resultSet.getString("EXTERNAL_PRODUCT_ID"));
				if(ext_prod_id.equals("")){
                     ext_prod_id="N";
				}
               
				result.add(ext_prod_id);
				result.add(checkForNull(resultSet.getString("BMS_QTY"),"N"));
				result.add(checkForNull(resultSet.getString("IN_FORMULARY_YN"),"N"));
				result.add(checkForNull(resultSet.getString("drug_yn"),""));
				result.add(checkForNull(resultSet.getString("TAPERED_YN"),"N"));
				result.add(checkForNull(resultSet.getString("TAPER_ORDER_ID"),"N"));
				result.add(checkForNull(resultSet.getString("ROUTE_DESC")));// added for CRF RUT-CRF-0034.1[IN:037389] 
				result.add(checkForNull(resultSet.getString("ROUTE_COLOR"),"DEFAULT"));// added for CRF RUT-CRF-0034.1[IN:037389]  //18
				trade_codes.put(order_id+resultSet.getString("ORDER_LINE_NUM")+resultSet.getString("ORDER_CATALOG_CODE"),checkForNull(resultSet.getString("trade_code")));
				temp = new HashMap();
				temp.put("BL_INCL_EXCL_OVERRIDE_VALUE",checkForNull(resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE")));
				temp.put("BL_INCL_EXCL_OVERRIDE_REASON",checkForNull(resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON")));
				temp.put("ORDERING_FACILITY_ID",checkForNull(resultSet.getString("ORDERING_FACILITY_ID")));
				bl_override_det.put(order_id+resultSet.getString("ORDER_LINE_NUM")+resultSet.getString("ORDER_CATALOG_CODE"),temp);
				stock_uom_det.put(order_id+resultSet.getString("ORDER_LINE_NUM")+resultSet.getString("ORDER_CATALOG_CODE"),checkForNull(resultSet.getString("ORDER_UOM")));//added for ML-BRU-SCF-1798
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return result;
	}

	/*
		This function is used to get the Country Code and Description							
	*/
	public ArrayList getNationalityDetails()throws Exception{
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT11") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("COUNTRY_CODE"));
				result.add(resultSet.getString("SHORT_NAME"));
			}
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
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
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return result;
	}

	/*
		This function is used to know 
			1. whether Token to be issued on Registration or not.
			2. If Token to be issued then to know whether prescription should be printed or not.
	*/
	public ArrayList getPrintRelatedInfo(String disp_locn_code,String facility_id)throws Exception{
		ArrayList result = new ArrayList();

		if (disp_locn_code==null){
			disp_locn_code = "";
		}
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT12") ) ;
			pstmt.setString(1,disp_locn_code.trim());
			pstmt.setString(2,login_facility_id.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("PRINT_PRES_ON_REGN_YN"));
				result.add(resultSet.getString("ISSUE_TOKEN_ON_REGN_YN"));
			}
			if (result.size()==0){
				result.add("N");
				result.add("N");
			}
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
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
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		return result;
	}
	

	/*
		This function is used get the Token Series Code , Description based on 
		patient_id,dispense location code,gender and nationality
	*/
	public ArrayList getTokenDetails(String patient_id,String disp_locn_code,String gender,String nationality)throws Exception{

		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		String default_token_yn="", defTokenSeries="";

		if (gender.equals("Male")){
			gender="M";
		}
		else if (gender.equals("Female")){
			gender="F";
		}
		else if(gender.equals("Both")){
			gender="B";
		}
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT10") ) ;
			pstmt.setString(1,login_at_ws_no.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,login_facility_id.trim());
			pstmt.setString(4,patient_id.trim());
			pstmt.setString(5,patient_id.trim());		
			pstmt.setString(6,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("TOKEN_SERIES_CODE"));
				result.add(resultSet.getString("DESCRIPTION"));
				result.add(resultSet.getString("NEXT_SERIAL_NO"));
				default_token_yn = checkForNull(resultSet.getString("DEFAULT_TOKEN_YN"));
				if(default_token_yn.equals("Y"))
					defTokenSeries = resultSet.getString("TOKEN_SERIES_CODE");
			}
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
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
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		setDefaultTokenSeries(defTokenSeries);
		return result;
	}
	

	/*
		This function is used get the Token Series Code , Description (non-patient is collecting the medication)based on 
		dispense location code,gender and nationality
	*/
	public ArrayList getTokenDetails(String disp_locn_code,String gender,String nationality)throws Exception{

		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;

		if (gender.equals("Male")){
			gender="M";
		}
		else if (gender.equals("Female")){
			gender="F";
		}
		else if(gender.equals("Both")){
			gender="B";
		}
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT17") ) ;
			pstmt.setString(1,login_at_ws_no.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,login_facility_id.trim());
			pstmt.setString(4,gender.trim());
			pstmt.setString(5,nationality.trim());	
			pstmt.setString(6,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("TOKEN_SERIES_CODE"));
				result.add(resultSet.getString("DESCRIPTION"));
				result.add(resultSet.getString("NEXT_SERIAL_NO"));
			}
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
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
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return result;
	}

	/*
		This function is used to get the health card number of the patient
	*/
	public ArrayList getNationalityHealthCardNo(String patient_id) throws Exception{
	
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT13") ) ;
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("NAT_ID_NO"));
				result.add(resultSet.getString("HEALTH_CARD_NO"));
							}
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
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
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		return result;
	}

// get the token series description
	public String getTokenSeriesDesc(String disp_locn_code, String token_series_code) throws Exception{
	
		String result			= "";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT18") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			pstmt.setString(4,getLanguageId());
		    resultSet = pstmt.executeQuery() ;

            if ( resultSet != null && resultSet.next() ) {
				result	=	resultSet.getString("DESCRIPTION");
			}
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
        } catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		return result;
	}

	/*
		This function is used to store the Prescription Details..
		Prescription format will be  ORDER_ID:ORDER_LINE,Y,ORDER_LINE,N.....
	*/
	public Hashtable storePrescriptionDetails(String prescription){
		StringTokenizer stOrder = new StringTokenizer(prescription,",");
		ArrayList selectedDrugs = new ArrayList();
		String order_id, order_line_num, order_line_select;
		StringTokenizer stOrderLine = null;
		while (stOrder.hasMoreTokens()){
			order_id = stOrder.nextToken();
			stOrderLine = new StringTokenizer(stOrder.nextToken(),":");
			while (stOrderLine.hasMoreTokens()){
				order_line_num = stOrderLine.nextToken();
				order_line_select = (stOrderLine.nextToken()).trim();
				if ((order_line_select).equals("Y")){
					selectedDrugs.add(order_line_num);
				}
			}
			prescriptionDetails.put(order_id,selectedDrugs);
		}
		return prescriptionDetails;
	}

	/*
		This function is used to store the Order Details.
		Order format  ORDER_ID:Y,ORDER_ID,N......
	*/
	public Hashtable storeOrderDetails(String orders){
		ArrayList selectedDrugs = new ArrayList();
		StringTokenizer stOrder = new StringTokenizer(orders,",");
		while (stOrder.hasMoreTokens()){
			StringTokenizer st = new StringTokenizer(stOrder.nextToken(),":");
			while (st.hasMoreTokens()){
				String order_id = st.nextToken();
				String select   = st.nextToken();
				if (!prescriptionDetails.containsKey(order_id)&&(((select).trim()).equals("Y"))){
					selectedDrugs.add("*ALL");
					prescriptionDetails.put(order_id,selectedDrugs);
				}
				else if (prescriptionDetails.containsKey(order_id) && (((select).trim()).equals("N"))){
					prescriptionDetails.remove(order_id);
				}
			}
		}
		return prescriptionDetails;
	}
	public Hashtable getPrescriptionDetails(){
		return prescriptionDetails;
	}
	public void clearPrescriptionDetails(){
		prescriptionDetails = new Hashtable();
	}

	public String getPatientIDLength(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}		
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
			pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}

	public String getTodaysDate(){
		Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		String today_date		=	"";

		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT25") ) ;
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				today_date	=	resultSet.getString("TODAY");				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return today_date;
	}

    public void getFromToDate(String facility_id){ // Change return type String to void and function name getToDate to getFromToDate for SRR20056-SCF-7807[28329]
		Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		String to_date			= "";
	 	String from_date		= ""; //add this variable for SRR20056-SCF-7807[28329]

		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT20") ) ;
			pstmt.setString(1,facility_id);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				//Comment and add following lines for SRR20056-SCF-7807[28329]
			    // to_date	=	resultSet.getString("SYS_DATE_TIME");
				from_date	=	resultSet.getString("FROM_DATE");
				to_date		=	resultSet.getString("TO_DATE");
				setFromDate(from_date);
				setToDate(to_date);				
				setDispExpOrders(checkForNull(resultSet.getString("DISP_EXPIRIED_ORDERS"),"Y")); //Added for ML-BRU-SCF-0987 [IN:042737]
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		// return to_date;  //Comment this lines for SRR20056-SCF-7807[28329]
	}

/*===code for getting max serial_no================*/
	public String getmaxSerialnum(String patient_id,String token_series_code,String disp_locn_code,String facility_id){
		Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		String token_serial_no		=	"";

		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT19") ) ;

			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,"*ALL");
			pstmt.setString(4,token_series_code);

            resultSet	= pstmt.executeQuery() ;

			if (resultSet.next()){
				token_serial_no	=	resultSet.getString("TOKEN_SERIAL_NO");				
			}
			 closeResultSet( resultSet ) ;
             closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return token_serial_no;
	}
	public String getHealthCardNo() throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String healthcard_no		= "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT22")) ;
        	pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				healthcard_no = checkForNull(resultSet.getString("alt_id1_desc"));
				
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return healthcard_no;
	}

	public String getNationID() throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String national_id		= "";
		try {
            connection	= getConnection() ;
           pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT21")) ;
	       pstmt.setString(1,getLanguageId());
		  //  pstmt		= connection.prepareStatement( "SELECT NAT_ID_PROMPT FROM MP_PARAM") ;
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				national_id = checkForNull(resultSet.getString("NAT_ID_PROMPT"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return national_id;
	}
//Method to get the Drug Description

	public String getDrugDescription(String drug_code) throws Exception{
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String drug_desc		= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_TAPER_DRUG_DTLS_1")) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				drug_desc = checkForNull(resultSet.getString("DRUG_DESC"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return drug_desc;
	}
//Method to get the TaperDrug Details

	 public ArrayList getTaperDrugDetails(String patient_id,String drug_code, String order_id){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;		
		HashMap record					= null;		
		ArrayList TaperDrugDetails		= new ArrayList();
		try{
			connection = getConnection();
			pstmt	  = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_TAPER_DRUG_DTLS_2")) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,patient_id);
			pstmt.setString(4,drug_code);
			pstmt.setString(5,order_id);
			//pstmt.setString(6,order_id);
			pstmt.setString(6,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				record = new HashMap();
				record.put("DOSAGE",resultSet.getString("DOSAGE"));				
				record.put("DOSAGE_UOM",resultSet.getString("DOSAGE_UOM"));
				record.put("FREQ_DESC",resultSet.getString("FREQ_DESC"));
				record.put("START_DATE",resultSet.getString("START_DATE"));
				record.put("END_DATE",resultSet.getString("END_DATE"));				
				TaperDrugDetails.add(record);			   
			}       
		}
		catch(Exception e){
			TaperDrugDetails.add(e.toString());
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

		return TaperDrugDetails;
	}
	public ArrayList getGenerateTokenYN(String disp_locn_code,String token_series_code) throws Exception{ //String changed to ArrayList for  Bru-HIMS-CRF-076 [IN029942]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList genTokenDtls	= new ArrayList();
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT23")) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,token_series_code);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				genTokenDtls.add(checkForNull(resultSet.getString("GEN_TOKEN_YN")));
				genTokenDtls.add(checkForNull(resultSet.getString("QMS_REQUIRED_YN"))); //added for  Bru-HIMS-CRF-076 [IN029942]
				genTokenDtls.add(checkForNull(resultSet.getString("QMS_EDIT_TOKEN_YN"))); //added for  Bru-HIMS-CRF-076 [IN029942]
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return genTokenDtls;
	}

	public String getPendngOrderCnt(String patient_id){
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
		String pndng_order_cnt	= "";
        try {
			connection = getConnection() ;
		    //pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT156") ) ;
           pstmt = connection.prepareStatement("SELECT COUNT(*) POCNT FROM OR_ORDER A WHERE PATIENT_ID = ? /* AND ORDER_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('00','03','05'))*/ AND EXISTS (SELECT ORDER_ID FROM OR_ORDER_LINE WHERE ORDER_ID =A.ORDER_ID AND ORDER_LINE_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN ('00','03','05')) AND END_DATE_TIME >= SYSDATE)"); //OR_ORDER_STATUS_CODE part of SQL Commented for HSA-CRF-0136 [IN:048412]- [IN:049363]
			pstmt.setString(1,patient_id);
			//pstmt.setString(2,disp_locn);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				pndng_order_cnt = resultSet.getString("POCNT") == null ? "":resultSet.getString("POCNT");
			}
		}
        catch ( Exception e ) {
            e.printStackTrace() ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return pndng_order_cnt;
	}

	public HashMap getBillingDetails(String locale,String order_id, String order_line_no){
        Connection connection				 = null ;
        PreparedStatement pstmt				 = null ;
        ResultSet resultSet					 = null ;
		PreparedStatement pstmt1			 = null ;
        ResultSet resultSet1				 = null ;
		String  bl_incl_excl_override_value  ="" ;
		String	bl_incl_excl_override_reason_code ="" ;
		String	bl_incl_excl_override_desc   ="" ;
		HashMap Pres_Billing_det             = new HashMap();
        try {
			connection = getConnection() ;
		    pstmt  = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT162") ) ;
			pstmt1	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_AMEND_PRESCRIPTION_BL_ACTION_DESC_SELECT") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
		    resultSet = pstmt.executeQuery() ;
            if(resultSet.next()){
				bl_incl_excl_override_value  = resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE") == null ? "":resultSet.getString("BL_INCL_EXCL_OVERRIDE_VALUE");

				bl_incl_excl_override_reason_code = resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON") == null ? "":resultSet.getString("BL_INCL_EXCL_OVERRIDE_REASON");		
				if(!bl_incl_excl_override_reason_code.equals("")){
					pstmt1.setString(1,locale);
					pstmt1.setString(2,bl_incl_excl_override_reason_code);
					resultSet1		= pstmt1.executeQuery();
					
					 if(resultSet1.next()){
						bl_incl_excl_override_desc = resultSet1.getString("ACTION_REASON_DESC")==null?"":resultSet1.getString("ACTION_REASON_DESC");
					}
					try{
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt1 ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				}

				Pres_Billing_det.put("PRES_BL_INCL_EXCL_OVERRIDE_VALUE",bl_incl_excl_override_value);
				Pres_Billing_det.put("PRES_BL_INCL_EXCL_OVERRIDE_REASON_CODE",bl_incl_excl_override_reason_code);
				Pres_Billing_det.put("PRES_BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_incl_excl_override_desc);
			}
		}
        catch ( Exception e ) {
            e.printStackTrace() ;
            
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
				 closeResultSet( resultSet1 ) ;
                closeStatement( pstmt1 ) ;
                closeConnection( connection );
            }
            catch(Exception es) { es.printStackTrace();}
        }
		return Pres_Billing_det;
	}

	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,int item_qty,String batch_str,String sysdate,String store_code,String bl_override_excl_incl_ind,String bl_incl_excl_override_reason_code,String order_id,String order_line_no,String disp_stage,String OrderingFacility,String dischargeIND)throws Exception{
			
		Connection connection				= null;
		CallableStatement callableStatement = null;
		HashMap message						= new HashMap();
		PreparedStatement pstmt1			= null;
        ResultSet resultSet					= null;
		String total_charge_amt				= "";
		String patient_payable_amt			= "";
		String grosschargeamt				= "";
		PreparedStatement pstmt				= null;
		ResultSet rsDecimalPlace			= null;
		int decimal_place					= 0;
		String decimalFormatString			= "#0";
		String doc_no						= "";   
		String doc_type						= "";  
		String doc_srl_no					= "";
//		String disp_billing_stage           ="";  Removed for IN063877
			 encounter_id =checkForNull(encounter_id);
	    if(encounter_id.equals("null")||encounter_id ==null)
			    encounter_id="";

		if(sal_trn_type.equals(""))
			sal_trn_type="R";
		//System.err.println("==login_facility_id===="+login_facility_id+"==patient_id====="+patient_id+"===encounter_id======"+encounter_id+"===sal_trn_type====="+sal_trn_type+"===="+item_code+"===item_qty===="+item_qty+"==batch_str===="+batch_str+"===store_code===="+store_code+"==bl_override_excl_incl_ind==="+bl_override_excl_incl_ind+"===bl_incl_excl_override_reason_code=="+bl_incl_excl_override_reason_code+"==sysdate====="+sysdate+"==OrderingFacility===="+OrderingFacility);

		try{
			connection = getConnection();           
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, OrderingFacility+"|"+login_facility_id);
			callableStatement.setString(2, patient_id);
			callableStatement.setString(3, "PH");
			callableStatement.setString(4, encounter_id);
			callableStatement.setString(5, sal_trn_type);
			callableStatement.setString(6, sysdate);
			callableStatement.setString(7, item_code);
			callableStatement.setString(8, store_code);
			callableStatement.setInt(9,item_qty);
			callableStatement.setString(10, batch_str);
			callableStatement.registerOutParameter(11, Types.VARCHAR);
			callableStatement.registerOutParameter(12, Types.VARCHAR);
			callableStatement.registerOutParameter(13, Types.VARCHAR);
			callableStatement.registerOutParameter(14, Types.VARCHAR);
			callableStatement.registerOutParameter(15, Types.FLOAT);
			callableStatement.registerOutParameter(16, Types.FLOAT);
			callableStatement.registerOutParameter(17, Types.FLOAT);
			callableStatement.registerOutParameter(18, Types.FLOAT);
			callableStatement.registerOutParameter(19, Types.FLOAT);
			callableStatement.registerOutParameter(20, Types.FLOAT);
			callableStatement.registerOutParameter(21, Types.FLOAT);
			callableStatement.registerOutParameter(22, Types.FLOAT);
			callableStatement.registerOutParameter(23, Types.FLOAT);
			callableStatement.registerOutParameter(24, Types.FLOAT);
			callableStatement.registerOutParameter(25, Types.FLOAT);
			callableStatement.registerOutParameter(26, Types.FLOAT);
			callableStatement.registerOutParameter(27, Types.FLOAT);
			callableStatement.registerOutParameter(28, Types.FLOAT);
			callableStatement.registerOutParameter(29, Types.VARCHAR);
			callableStatement.registerOutParameter(30, Types.FLOAT);
			callableStatement.registerOutParameter(31, Types.VARCHAR);
			callableStatement.registerOutParameter(32, Types.VARCHAR);
			callableStatement.registerOutParameter(33, Types.VARCHAR);
			callableStatement.registerOutParameter(34, Types.VARCHAR);
			callableStatement.registerOutParameter(35, Types.VARCHAR);
			callableStatement.registerOutParameter(36, Types.VARCHAR);
			callableStatement.registerOutParameter(37, Types.VARCHAR);
			callableStatement.registerOutParameter(38, Types.VARCHAR);
			if(bl_override_excl_incl_ind.equals("")){
				callableStatement.setString(39, "");
			    callableStatement.setString(40, "");
			}
			else{
				callableStatement.setString(39, bl_override_excl_incl_ind);
			    callableStatement.setString(40, bl_incl_excl_override_reason_code);
			}

			callableStatement.setString(41, "N"); //Internal Adjestment
			callableStatement.setString(42, doc_type);
			callableStatement.setString(43, doc_no);
			callableStatement.setString(44, doc_srl_no);
			callableStatement.setString(45, dischargeIND);
			callableStatement.registerOutParameter(46, Types.VARCHAR); //added for JD-CRF-0170.1 [IN:040204]
			callableStatement.setString(47,order_id);//added for CRF-126.1
			callableStatement.setString(48, order_line_no);//added for CRF-126.1
System.err.println("RegPrescriptionsBean.java===1848===order_id======>"+order_id+"==order_line_no==>"+order_line_no);
			callableStatement.execute();
			
			//message.put("daytypecode" , checkForNull((String)callableStatement.getString(11)));
			//message.put("daytypedesc" , checkForNull((String)callableStatement.getString(12)));
			//message.put("timetypecode" , checkForNull((String)callableStatement.getString(13)));
			//message.put("timetypedesc" , checkForNull((String)callableStatement.getString(14)));
			//message.put("baseqty" , callableStatement.getFloat(15)+"");			
			//message.put("baserate" , callableStatement.getString(16)+"");
			//message.put("addlfactor" ,callableStatement.getString(17)+"");
			grosschargeamt        = callableStatement.getString(19);
			//message.put("discountamt" , callableStatement.getString(20)+"");
			total_charge_amt      = callableStatement.getString(21);
			//message.put("discountper" , callableStatement.getString(22)+"");
			//message.put("patgrosschargeamt" , callableStatement.getString(23)+"");
			//message.put("patdiscamt" , callableStatement.getString(24)+"");
			patient_payable_amt   = checkForNull(callableStatement.getString(25),"0");
			//message.put("custgrosschargeamt" , callableStatement.getString(26)+"");
			//message.put("custdiscamt" , callableStatement.getString(27)+"");
			//message.put("custnewamt" , callableStatement.getString(28)+"");			
			//message.put("insind" , checkForNull((String)callableStatement.getString(29)));
			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));
			message.put("excl_incl_ind" , checkForNull((String)callableStatement.getString(35),""));
			message.put("approval_reqd_yn" , checkForNull((String)callableStatement.getString(36),"N"));
			message.put("override_allowed_yn" , checkForNull((String)callableStatement.getString(37),""));
			message.put("pat_paid_amt" , checkForNull((String)callableStatement.getString(38)));
			message.put("pat_paid_flag" , checkForNull((String)callableStatement.getString(30)));

          /*If p_payment_flag  = 0 then 
              Fully paid                                      -- Allow dispense
            Elsif p_payment_flag   = 1 then
                Adjustement/Exemption/Written of service        -- Allow Dispense
            Elsif p_payment_flag   =2 then
               Agreement done for Installment                  -- Allow Dispanse
            Elsif p_payment_flag   =3 then
               Partial Payment done.                           -- Donot Allow Dispense as agreed by Vinod...
            End if;*/
            pstmt = connection.prepareStatement("SELECT BLCORE.GET_DECIMAL_PLACE(?) decimal_place FROM dual");
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet(rsDecimalPlace);

			if(decimal_place > 0)
				decimalFormatString = decimalFormatString+".";

			for(int i=1;i<=decimal_place;i++){
				decimalFormatString = decimalFormatString+"0";
			}

			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
				message.put("patnetamt" ,patient_payable_amt+"");
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
				message.put("netchargeamt" ,total_charge_amt+"");
			}

			if(grosschargeamt!=null && !grosschargeamt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				grosschargeamt = dfTest.format(Double.parseDouble(grosschargeamt));
				message.put("grosschargeamt" ,grosschargeamt+"");
			}
			//System.err.println("==message===="+message);
			message.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
			message.put("BATCH_STRING",batch_str);
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			try{
				closeStatement(callableStatement);
				closeConnection(connection);
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return message;
	}

	public ArrayList getLockResult(String patient_id,String disp_locn_code,String disp_stage,String login_user)throws Exception{
		Connection connection	    = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		    = null;
		ArrayList LockResult = new ArrayList();
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement(" SELECT COUNT(*) COUNT_PATIENT,USER_ID FROM PH_LOCK_DISP_RECORDS WHERE PATIENT_ID=? and DISP_LOCN_CODE=? and STAGE_ID=? and user_id<>? GROUP BY USER_ID") ;
			pstmt.setString(1, patient_id.trim());
			pstmt.setString(2, disp_locn_code);
			pstmt.setString(3, disp_stage);
			pstmt.setString(4, login_user);
			
			resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				HashMap rec		=	new HashMap();
				String count_patient,user_id;
				count_patient	=	resultSet.getString("COUNT_PATIENT");
				user_id	    	=	resultSet.getString("USER_ID");
				rec.put("count_patient",count_patient);
				rec.put("user_id",user_id);
				LockResult.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return LockResult;		
	}

   public String getLockStatus(String patient_id,String disp_locn_code,String disp_stage)throws Exception{
		Connection connection	    = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		    = null;
		String Lock_status="";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement(" SELECT COUNT(*) COUNT_PATIENT FROM PH_LOCK_DISP_RECORDS WHERE PATIENT_ID=? and DISP_LOCN_CODE=? and STAGE_ID=?") ;
			pstmt.setString(1, patient_id.trim());
			pstmt.setString(2, disp_locn_code);
			pstmt.setString(3, disp_stage);
			
			resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				Lock_status =resultSet.getString("COUNT_PATIENT");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return Lock_status;		
	}

   public String getLockStatusOnLoad(String patient_id,String disp_locn_code,String disp_stage,String login_user)throws Exception{
		Connection connection	    = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		    = null;
		String Lock_status="";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement(" SELECT COUNT(*) COUNT_PATIENT FROM PH_LOCK_DISP_RECORDS WHERE PATIENT_ID=? and DISP_LOCN_CODE=? and STAGE_ID=? and user_id<>?") ;
			pstmt.setString(1, patient_id.trim());
			pstmt.setString(2, disp_locn_code);
			pstmt.setString(3, disp_stage);
			pstmt.setString(4, login_user);
			
			resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				Lock_status =resultSet.getString("COUNT_PATIENT");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return Lock_status;		
	}

   public ArrayList getAccessRightStatus(String patient_id,String disp_locn_code,String disp_stage)throws Exception{
		Connection connection	    = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		    = null;
		ArrayList AccessRightStatus = new ArrayList();
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT USER_ID,TO_CHAR(LOCKED_DATE_TIME,'DD/MM/YYYY HH24:MI') LOCKED_DATE_TIME FROM PH_LOCK_DISP_RECORDS WHERE PATIENT_ID=? and DISP_LOCN_CODE=? and STAGE_ID=?");
			pstmt.setString(1, patient_id.trim());
			pstmt.setString(2, disp_locn_code);
			pstmt.setString(3, disp_stage);
			
			resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				HashMap rec		=	new HashMap();
				String user_id,locked_date_time;
				user_id					=	resultSet.getString("USER_ID");
				locked_date_time		=	resultSet.getString("LOCKED_DATE_TIME");
				rec.put("user_id",user_id);
				rec.put("locked_date_time",locked_date_time);
				AccessRightStatus.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return AccessRightStatus;		
	}

	 public String getLockStatus1(String login_user,String patient_id,String disp_locn_code,String disp_stage,String patient_id_status)throws Exception{
		Connection connection	    = null;
		CallableStatement cstmt =null;
		ResultSet resultSet		    = null;
		String Lock_status="";
		try {
			connection	= getConnection() ;
			cstmt=connection.prepareCall("{call PH_DISP_TRAN_LOCK_STATUS(?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, login_user.trim());
			cstmt.setString(2, patient_id.trim());
			cstmt.setString(3, disp_locn_code);
			cstmt.setString(4, disp_stage);
			cstmt.setString(5, login_user);
			cstmt.setString(6, login_at_ws_no);
			cstmt.setString(7, patient_id_status);
			cstmt.setString(8, "N");
			cstmt.registerOutParameter(9,Types.VARCHAR);
			cstmt.execute();
			Lock_status = cstmt.getString(9);
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( cstmt ) ;
			closeConnection( connection ); 
		}
		return Lock_status;		
	}

    public String getAllowdisprecordlock(String facility_id)throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		String allow_disp_record_lock_yn = "";
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			pstmt		= connection.prepareStatement("SELECT DECODE(ALLOW_DISP_RECORD_LOCK_YN,NULL,'N',ALLOW_DISP_RECORD_LOCK_YN) ALLOW_DISP_RECORD_LOCK_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?");
			pstmt.setString(1,facility_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				allow_disp_record_lock_yn   = resultSet.getString("ALLOW_DISP_RECORD_LOCK_YN");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return allow_disp_record_lock_yn;		
	}	

	public String getUnLockRecordsYN(String login_user,String disp_locn_code)throws Exception{
		Connection connection	    = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		    = null;
		String unlock_all_records_yn="";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT UNLOCK_ALL_RECORDS_YN FROM PH_DISP_RIGHTS WHERE APPL_USER_ID=? AND DISP_LOCN_CODE=?") ;
			pstmt.setString(1, login_user.trim());
			pstmt.setString(2, disp_locn_code);
			resultSet = pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
				unlock_all_records_yn =resultSet.getString("UNLOCK_ALL_RECORDS_YN");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return unlock_all_records_yn;		
	}

	public String getEncounterPatientClass(String encounter_id,String ordering_facility_id, String patient_id) throws Exception{ //patient_id added for [IN:035667] 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	= "";
		try {
            encounter_id =checkForNull(encounter_id);
			 if(encounter_id.equals("null")||encounter_id ==null)
			    encounter_id="";
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1")) ;
			
			pstmt.setString(1,ordering_facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,patient_id); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				patient_class = checkForNull(resultSet.getString("ENC_PATIENT_CLASS"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return patient_class;
	}

	// added for Bru-HIMS-CRF-076 [IN029942] -start
	public String[] genQMSToken(String disp_locn_code,String token_series_code, String encounter_id, String session_id) throws Exception{
		String  customer_id="",  pract_id="";  //ext_queue_id="", errText="", Removed for IN063877

		customer_id = getCustomerID();
		pract_id = getPractID(encounter_id);
		String QMSResult[] = null;
		try {
			QueueManager ext_interface = new QueueManager();
			HashMap<String,String> additionalParams=new HashMap<String,String>();
			additionalParams.put("siteID",customer_id);
			additionalParams.put("loggedUser",login_by_id);
			additionalParams.put("clientMachine",login_at_ws_no);
			additionalParams.put("facilityID",login_facility_id);
			additionalParams.put("sessionID",session_id);//session_id
			additionalParams.put("patientID", patient_id); //Added for ML-BRU-SCF-0786 [IN:039204]
			additionalParams.put("encounterID",encounter_id);//Added for ML-BRU-SCF-0786 [IN:039204]

			//String extRoomNum=p_locn_code+"|"+room_num;
			try{
				//System.err.println("RegPrescriptnionsBean genQMSToken Parameters passed to the QMS external interface for Mark Arrival disp_locn_code="+disp_locn_code+" token_series_code="+token_series_code+" Practitioner ID : "+pract_id+"Audit Parameters : "+additionalParams.toString());
				QMSResult = ext_interface.issueTicket(disp_locn_code,token_series_code,pract_id,additionalParams);
				//System.err.println("QMSResult================>"+QMSResult.toString());
			}
			catch(Exception e){
				e.printStackTrace();
				if(QMSResult == null){
					QMSResult = new String[3];
					QMSResult[0] = "1";
					QMSResult[1] = null;
					QMSResult[2] = getMessage(getLanguageId(),"EXT_QUEUE_NO_CONTACT", "OP");
				}
			}	
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		return QMSResult;
	}

	public String getCustomerID()throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String customer_id			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE SITE_ID = 'DS'");
			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				customer_id = rsCustomerID.getString("CUSTOMER_ID")==null?"":rsCustomerID.getString("CUSTOMER_ID");
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return customer_id;
	}
	public String getPractID( String encounter_id)throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rsPractID		= null;
		String pract_id			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("select PRACTITIONER_ID from PR_ENCOUNTER_PRACT where OPERATING_FACILITY_ID =? and ENCOUNTER_ID = ?");
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, encounter_id);
			rsPractID = pstmt.executeQuery();
			if(rsPractID.next()){
				pract_id = rsPractID.getString("PRACTITIONER_ID")==null?"":rsPractID.getString("PRACTITIONER_ID");
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsPractID ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return pract_id;
	}

	// added for Bru-HIMS-CRF-076 [IN029942] -end
	//Added for Bru-HIMS-CRF-142 [IN:030195] - Start
	/*This function is used to get the Patient Arrival Details	*/
	public ArrayList getPatientArrivalDet(String facility_id,String disp_locn_code)throws Exception{
		ArrayList result = new ArrayList();
        Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT26") ) ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				result.add(resultSet.getString("MARK_PATIENT_ARRIVE_YN"));
				result.add(resultSet.getString("GENERATE_ACTUAL_TOKEN_YN"));
				result.add(resultSet.getString("PRINT_TOKEN_ON_LABEL_YN"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
            catch(Exception es) {
	            es.printStackTrace() ;
			}
        }
		return result;
	}

	//below method added for Bru-HIMS-CRF-142 [IN:030195]
	public ArrayList getPatientMode(String patient_id,String order_date_from,String order_date_to) throws Exception {
		ArrayList resultmode		= new ArrayList();
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT27") ) ;
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,order_date_from.trim());
			pstmt.setString(3,order_date_to.trim());
		    resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
				resultmode.add(checkForNull(resultSet.getString("PAT_MODE")));
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch(Exception e){
			resultmode.add(e.toString()); 
			e.printStackTrace();
			throw e ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}		
		}
		return resultmode;	
	}

	//To get dummy token No
	public String getTempTokenSeriesNo(String facility_id,String disp_locn_code,String token_series_code){

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String temp_token_series_no="";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT MAX(TMP_TOKEN_SERIAL_NO)+1 TEMP_TOKEN_SERIES_NO FROM PH_DISP_QUEUE  WHERE FACILITY_ID = ? AND DISP_LOCN_CODE = ? AND QUEUE_DATE = TRUNC(SYSDATE) AND QUEUE_SHIFT = '*ALL' AND TOKEN_SERIES_CODE = ? " );
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,token_series_code.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				 temp_token_series_no=resultSet.getString("TEMP_TOKEN_SERIES_NO") == null?"" :resultSet.getString("TEMP_TOKEN_SERIES_NO");
				if(temp_token_series_no.equals(""))
					temp_token_series_no	=	"900000";
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return temp_token_series_no;
	}

	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date_time				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT5");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date_time=resultSet.getString("SYS_DATE_TIME");
				this.sys_date=resultSet.getString("SYS_DATE");
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
		return sys_date_time;
	}
	
	// Method to get Patient Name, Age, Sex, Nationality, Nationality Desc
	public ArrayList getPatientDetails(String patient_id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT28") ) ;
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
				records.add(resultSet.getString("NATIONALITY"));
				records.add(resultSet.getString("NATIONALITY_CODE"));
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch(Exception e){
			records.add(e.toString()); 
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}		
		}
		return records;	
	}

	//Method to get the Result Page for Mark Patient Arrival function
	public ArrayList getPatientOrderDet(String patient_id,String order_date_from,String order_date_to,String token_no){
		ArrayList patresult			= new ArrayList();
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT29") ) ;
			pstmt.setString(1,patient_id.trim());		
			pstmt.setString(2,order_date_from.trim());		
			pstmt.setString(3,order_date_to.trim());		
			pstmt.setString(4,token_no.trim());

		    resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next() ) {
				patresult.add(checkForNull(resultSet.getString("TOKEN_SERIAL_NO")));
				patresult.add(checkForNull(resultSet.getString("QUEUE_DATE")));
				patresult.add(checkForNull(resultSet.getString("ORDER_ID")));
				patresult.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));
				patresult.add(checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));
				patresult.add(checkForNull(resultSet.getString("DRUG_DESC")));
				patresult.add(checkForNull(resultSet.getString("DISP_LOCN_NAME")));
				patresult.add(checkForNull(resultSet.getString("STORAGE_LOCN_DESC")));
				patresult.add(checkForNull(resultSet.getString("ORDER_STATUS")));
				patresult.add(checkForNull(resultSet.getString("TOKEN_STATUS")));
				patresult.add(checkForNull(resultSet.getString("TOKEN_SERIES_CODE")));
				patresult.add(checkForNull(resultSet.getString("DISP_LOCN_CODE")));
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch(Exception e){
			patresult.add(e.toString());
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}		
		}
		return patresult;	
	}

	public HashMap updateOrdDispQ(ArrayList arrayl) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;

		Connection connection					= null ;
		PreparedStatement pstmt_insert		= null ;
		try {
			connection	= getConnection() ;
            pstmt_insert = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_UPD_ORD_FOR_DISP_QUEUE") ) ;

			for(int i=0;i<arrayl.size();i+=13){
				pstmt_insert.setString(1,(String)arrayl.get(i+11));
				pstmt_insert.setString(2,login_facility_id.trim());
				pstmt_insert.setString(3,(String)arrayl.get(i+12));
				pstmt_insert.setString(4,(String)arrayl.get(i+7));
				pstmt_insert.setString(5,(String)arrayl.get(i+5));
				pstmt_insert.setString(6,(String)arrayl.get(i+6));
				pstmt_insert.setString(7,(String)arrayl.get(i+8));
				pstmt_insert.addBatch() ;
			}
			int[] result1=pstmt_insert.executeBatch();
			for ( int k=0;k<result1.length ;k++ ){
				if(result1[k]<0  && result1[k] != -2 ){
					pstmt_insert.cancel();
					connection.rollback();
					map.put( "result", new Boolean( false) ) ;
					map.put( "msgid", "Exception Occured During Insert Process!!!") ;
					return map;
				}
			}
			map.put( "result", new Boolean( true) ) ;
			map.put( "msgid", "RECORD_UPDATED") ;
			connection.commit();
		}//end of try
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Exception in EJB over here: " +e) ;
				}
		finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeConnection( connection );
			}
			catch ( Exception fe ) {
				fe.printStackTrace() ;
			}
		}
		return map ;
	}

	//Method to get actual token no if Generate Actual Token is checked
		public String getActualToken(String patient_id){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	actualtoken		=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_REG_PRESCRIPTIONS_SELECT30") ) ;
			pstmt.setString(1,patient_id.trim());		
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				actualtoken	=	checkForNull(resultSet.getString("TOKEN_SERIAL_NO"));
			}			
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
			actualtoken	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return actualtoken;	
	}

	public ArrayList getTokenNo(String disp_locn_code,String patient_id, String token_series,String token_no) throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		CallableStatement cstmt = null ;
		ArrayList tokennostatus	 =new ArrayList();
		String generated_token_no		=	"";
		String error_msg	=	"";
		try{
			connection	= getConnection() ;
			cstmt=connection.prepareCall("{call PH_TOKEN_FOR_ARRIVAL_UNALLOC (?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, login_facility_id.trim());
			cstmt.setString( 2, disp_locn_code.trim());
			cstmt.setString( 3, patient_id.trim());
			cstmt.setString( 4, token_series.trim());
			cstmt.setString( 5, token_no.trim());
			cstmt.setString( 6, login_by_id.trim());
			cstmt.setString( 7, login_at_ws_no.trim());
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.execute() ;
		
			generated_token_no	=	(String)(cstmt.getString(8));
			error_msg	=	(String)(cstmt.getString(9));

			if((generated_token_no == null)||(generated_token_no.trim().equals(""))) {
				if(error_msg!=null){
				tokennostatus.add(error_msg);
				}
			}
			else{
				tokennostatus.add(generated_token_no);
				tokennostatus.add(getMessage(getLanguageId(),"RECORD_MODIFIED", "PH"));
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( cstmt ) ;
			closeConnection( connection ); 
		}
		return tokennostatus;
	}//Added for Bru-HIMS-CRF-142 [IN:030195] -End
	
	public boolean toDisplayFinancialDtl(String disp_locn_code){	 //code added for JD-CRF-0156[IN041737] --Start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String finacial_detail	= "",bill_interface="";
		boolean display_financial_dtl = false;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_FINANCE_BILL_DTL")) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,login_by_id.trim());
			pstmt.setString(3,disp_locn_code);		
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				finacial_detail = checkForNull(resultSet.getString("CURR_ENC_FINANCIAL_DTL_YN"));
				bill_interface = checkForNull(resultSet.getString("BL_INTERFACE_YN"));
			}
			if(finacial_detail.equals("Y") && bill_interface.equals("Y") )
				display_financial_dtl = true;	
		}
		catch ( Exception e ) {
			e.printStackTrace() ;   
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		} 
		return display_financial_dtl;
	}
	
	public boolean getPolicyExp(String encounter_id,String patient_class,String patient_id) {        	
        	CallableStatement callableStatement = null;
        	Connection connection = null;
        	try{        		
    			connection = getConnection();
    			callableStatement	= connection.prepareCall("{ call or_bl_patient_check (?,?,?,?,?,?) }");
    			callableStatement.setString(1, login_facility_id.trim());
    			callableStatement.setString(2, encounter_id);
    			callableStatement.setString(3, patient_class);
    			callableStatement.registerOutParameter(4, Types.VARCHAR);
    			callableStatement.registerOutParameter(5, Types.VARCHAR);
    			callableStatement.setString(6, patient_id);	
				callableStatement.execute();
    			if(!checkForNull(callableStatement.getString(4)).equals("")){
	    			return false;
    			}
    		}
    		catch(Exception exception){
    			exception.printStackTrace();
    		}
    		finally{
    			try{
    				closeStatement(callableStatement);
    				closeConnection(connection);
    			}catch(Exception e){
    			}
    		}
        	return true; 
    }//code added for JD-CRF-0156[IN041737] --End

	public void setAutoCallReRoute(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        String sql_query="";
		ResultSet resultSet = null;
		String autoCallReRoute_yn = "N";
		try{
			connection = getConnection() ;
			sql_query      = "select crit_field_val,crit_field_id from PH_DISP_MEDN_DFLT where function_id =? and facility_id = decode(?, facility_id, facility_id,'*A')  and crit_field_id =?";
			pstmt		   = connection.prepareStatement(sql_query) ;
			pstmt.setString(1,"REG_PRESCRIPTION");
			pstmt.setString(2,getLoginFacilityId());
			pstmt.setString(3,"REROUTE_AUTOCALL");

			resultSet	= pstmt.executeQuery();
			while(resultSet!= null && resultSet.next()) {
				autoCallReRoute_yn = checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N");
			}
			setAutoCallReRouteYN(autoCallReRoute_yn);
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		finally {
           	try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
	}
	public ArrayList getEpisodeDetails( String patient_id){  //code added for JD-CRF-0156[IN041737]
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList encounter_details = new ArrayList();
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_ENCOUNTER_DTL"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				if(resultSet.next()){
					encounter_details.add(resultSet.getString("ENCOUNTER_ID"));					
					encounter_details.add(resultSet.getString("EPISODE_ID"));					
					encounter_details.add(resultSet.getString("PATIENT_CLASS"));				
				}
			}  
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}		
		return encounter_details;
	}//code added for JD-CRF-0156[IN041737] --End
//added for ML-BRU-SCF-1798 - start
	public String getStoreDfltBaseUOM(String store_code,String drug_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String base_uom			= "";
		try {
            connection	= getConnection() ;

			pstmt		= connection.prepareStatement("SELECT GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b, st_item c WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E' and b.EFF_STATUS='E' and a.item_code =b.item_code and a.item_code =c.item_code") ;
			pstmt.setString(1,store_code);
			pstmt.setString(2,drug_code);
            resultSet	= pstmt.executeQuery();
			if (resultSet.next()){
				base_uom =checkForNull(resultSet.getString("GEN_UOM_CODE"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
				}catch(Exception es){es.printStackTrace();}
		}
		return base_uom;
	}

	public float getEqulValue (String item_code,String uom_code,String equl_uom_code){
		if(uom_code!=null && equl_uom_code!=null && uom_code.equals(equl_uom_code)){
			return 1;
		}
		else{
			Connection connection	= null;
			PreparedStatement pstmt	= null;
			ResultSet resultSet		= null;	
			float eqvl_value		= 0f;

			try {
				connection	= getConnection() ;
			  
				pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE) EQVL_VALUE from MM_ITEM_UOM_DEFN where ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=? and EFF_STATUS = 'E' ") ;

				pstmt.setString(1,item_code);
				pstmt.setString(2,uom_code);
				pstmt.setString(3,equl_uom_code);
				resultSet	= pstmt.executeQuery() ;
				
				if (resultSet.next()){
					eqvl_value = resultSet.getFloat("EQVL_VALUE");		
				}
			}
			catch ( Exception e ) {
				e.printStackTrace() ;			
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection ); 
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}
			return eqvl_value;
		}
	}//added for ML-BRU-SCF-1798 - end
	public String getPrimaryBillingGroup(String patient_class,String encounter_id,String patient_id){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
		Connection connection = null;		
		PreparedStatement pstm_group_type = null;
		ResultSet resultSet = null;
		String sql = "";		
		String billing_group ="";		
	  try{
		  connection = getConnection();		  
		if(patient_class.length()>0)
			patient_class = patient_class.substring(0,1);
		 if(patient_class.equalsIgnoreCase("O") || patient_class.equalsIgnoreCase("E"))
			 sql = "SELECT short_desc FROM bl_blng_grp_lang_vw WHERE blng_grp_id IN ( SELECT blng_grp_id FROM bl_visit_fin_dtls WHERE operating_facility_id = ? AND episode_type = ? AND episode_id = ? AND language_id=?)";
		 else
		     sql =  "SELECT short_desc FROM bl_blng_grp_lang_vw WHERE blng_grp_id IN ( SELECT blng_grp_id FROM bl_episode_fin_dtls WHERE operating_facility_id = ? AND episode_type = ? AND episode_id = ? and language_id=?)";
		 pstm_group_type	= connection.prepareStatement(sql) ;
		 if(checkForNull(patient_class).equalsIgnoreCase("O") || patient_class.equalsIgnoreCase("E")){
			 pstm_group_type.setString(1,login_facility_id);
			 pstm_group_type.setString(2, patient_class);
			 pstm_group_type.setString(3, checkForNull(encounter_id.substring(0,encounter_id.length()-4)));
			 pstm_group_type.setString(4,getLanguageId());
		 }
		 else{
			 pstm_group_type.setString(1,login_facility_id);
			 pstm_group_type.setString(2, patient_class);
			 pstm_group_type.setString(3, checkForNull(encounter_id)); 
			 pstm_group_type.setString(4,getLanguageId());
		 }
		  resultSet    = pstm_group_type.executeQuery();
		  if(resultSet!=null && resultSet.next()) {
			  billing_group = resultSet.getString("SHORT_DESC");			 
			}
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
	  finally{
		  try{				
				closeResultSet( resultSet ) ;
				closeStatement( pstm_group_type ) ;
				closeConnection( connection );				
			}
			catch(Exception e){
				e.printStackTrace();
			}		   
		  return billing_group; 
	  }
	} // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
	public void setDispBeyondBeforeValues(){//Added for COMMON-ICN-0120 [40745]
        Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql = "";
	try{
				connection			= getConnection() ;
		 sql ="SELECT disp_before_start_date_yn, disp_before_no_of_days, disp_beyond_earliest_start_yn, disp_beyond_no_of_days FROM ph_facility_param WHERE facility_id = ?";
		 pstmt				= connection.prepareStatement(sql) ;
				pstmt.setString(1, login_facility_id.trim());
				System.err.println("login_facility_id=="+login_facility_id.trim());
				resultSet	= pstmt.executeQuery();
				if (resultSet!=null && resultSet.next()) {
					setDisp_before_start_date_yn(resultSet.getString("disp_before_start_date_yn")==null?"":resultSet.getString("disp_before_start_date_yn"));
					setDisp_before_no_of_days(resultSet.getString("disp_before_no_of_days")==null?"":resultSet.getString("disp_before_no_of_days"));
					setDisp_beyond_earliest_start_yn(resultSet.getString("disp_beyond_earliest_start_yn")==null?"":resultSet.getString("disp_beyond_earliest_start_yn"));
					setDisp_beyond_no_of_days(resultSet.getString("disp_beyond_no_of_days")==null?"":resultSet.getString("disp_beyond_no_of_days"));
					 System.err.println("disp_before_start_date_yn ==="+getDisp_before_start_date_yn()+"disp_before_no_of_days=="+getDisp_before_no_of_days()+"disp_beyond_earliest_start_yn==="+getDisp_beyond_earliest_start_yn()+"disp_beyond_no_of_days==="+getDisp_beyond_no_of_days());	 
				}
			}
			catch(Exception e){
				 e.printStackTrace();
			}
	 	    finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
					es.printStackTrace();
				}
			}
	}//Added for COMMON-ICN-0120 [40745]
	
	public void setExclOrdLocnDispenseYN(){//Added for ML-MMOH-CRF-2085
        Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String sql = "";
	try{
				connection			= getConnection() ;
		 sql ="SELECT excl_ord_locn_dispense_yn FROM ph_facility_param WHERE facility_id = ?";
		 pstmt				= connection.prepareStatement(sql) ;
				pstmt.setString(1, login_facility_id.trim());
				resultSet	= pstmt.executeQuery();
				if (resultSet!=null && resultSet.next()) {
					setExclOrdLocnDispenseYN(resultSet.getString("excl_ord_locn_dispense_yn")==null?"":resultSet.getString("excl_ord_locn_dispense_yn"));	 
				}
			}
			catch(Exception e){
				 e.printStackTrace();
			}
	 	    finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
					es.printStackTrace();
				}
			}
	}//Added for ML-MMOH-CRF-2085	
}
