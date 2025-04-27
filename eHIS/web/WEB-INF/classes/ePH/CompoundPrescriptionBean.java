/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ePH.Common.*;
import eCommon.Common.*;
import oracle.sql.*;
import eOR.*;
import java.text.DecimalFormat;

public class CompoundPrescriptionBean extends PhAdapter implements Serializable {
	private String order_date			= "";
	private String DreugIndicationRemarks				= null ;
	private String patient_class		= "";
	private String patient_id			= "";
	private String encounter_id			= "";
	private String drugCodes			= "";
	private String freqNature			= "";
	private String repeat_value			= "";
	private String int_value			= "";
	private String order_status			= "10";
	private String orderID				= "";
	private String packSize				= "";
	private String stock_uom			= "";
	private String AmendOrderRemarks	= "";
	private String order_type_flag      = ""; 

    private String ORDER_CATALOG_CODE	= "";
	private	String CATALOG_DESC			= "";
	private	String START_DATE_TIME		= "";
	private	String END_DATE_TIME		= "";
	private	String START_DATE			= "";
	private	String END_DATE				= "";

	private	String DURN_VALUE			= "";
	private	String DURN_TYPE			= "";
	private	String QTY_VALUE			= "";
	private	String QTY_UNIT				= "";
	private	String ORDER_LINE_NUM		= "";
	private	String freq_code			= "";
	private	String DOSAGE				= "";

	private int srlNo					= 0;
	private int presc_mode				= 0;
	private ArrayList diagText			= new ArrayList(12);
	private ArrayList drugDetails		= new ArrayList();
	private ArrayList DrugRemarks		= new ArrayList();
	private HashMap scheduleFrequency	= new HashMap();
	private ArrayList presDetails		= new ArrayList();
	private ArrayList amendDetails		= new ArrayList();
	private ArrayList amendDrugCodes	= new ArrayList();
	private HashMap AmendAllergyRemarks	= new HashMap();
	private HashMap AmendDoseRemarks	= new HashMap();
	private HashMap AmendRxRemarks		= new HashMap();
	private String license				= "";

	private String or_mode				= "";
	private ArrayList drug_stock_dtls	= new ArrayList();
	private String locn_type			= "";
	private String locn_code			= "";
	private String pract_id				= "";
	private String order_priority		= "";
	private String height				= "";
	private String height_uom			= "";
	private String weight				= "";
	private String weight_uom			= "";
	private String bsa					= "";
	private String bmi					= "";
	private String allergic_yn			= "";
	private String ivprep				= "";

	private String ext_db_interface_yn	= "N";
	private String drug_db_product_id   = "";
    private String ext_dosage_chk_yn	= "N";
	   

	private HashMap curr_drug_dtls		 = new HashMap();
	private ArrayList existing_iv_orders = new ArrayList();
	private ArrayList orderSetValues	 = new ArrayList();
	private String Drg_Trade_Codes_Arr[];
	private String buildMAR_yn		= "";
	private String trn_group_ref		= "";
	private String tokens_generated_yn		= "";
	private String age_group				=	"";

	public void setAgeGroup(String age_group) {
		this.age_group	=	age_group;
	}

	public String getAgeGroup() {
		return this.age_group;
	}

	public void setTrnGroupRef(String trn_group_ref){
		this.trn_group_ref = trn_group_ref;
	}
	public String getTrnGroupRef(){
		return trn_group_ref;
	}
	public void setTokensGeneratedYN(String tokens_generated_yn){
		this.tokens_generated_yn = tokens_generated_yn;
	}
	public String getTokensGeneratedYN(){
		return tokens_generated_yn;
	}

	public void setDrgTradeCodesArray(String Drg_Trade_Codes){
		this.Drg_Trade_Codes_Arr = Drg_Trade_Codes.split(",");
	}
		
	public void setOrderSetValues(ArrayList orderSetValues){
		this.orderSetValues = orderSetValues;
	}

	public ArrayList getOrderSetValues(){
		return this.orderSetValues;
	}

	public void setAllExistingIVOrders(ArrayList exstngIVOrders){
		this.existing_iv_orders = exstngIVOrders;
	}

	public ArrayList getAllExistingIVOrders(){
		return this.existing_iv_orders;
	}


	public void setORDER_CATALOG_CODE(String ORDER_CATALOG_CODE){
		this.ORDER_CATALOG_CODE = ORDER_CATALOG_CODE;
	}

	public String getORDER_CATALOG_CODE(){
		return this.ORDER_CATALOG_CODE;
	}
	public void setCATALOG_DESC(String CATALOG_DESC){
		this.CATALOG_DESC = CATALOG_DESC;
	}

	public String getCATALOG_DESC(){
		return this.CATALOG_DESC;
	}
	public void setSTART_DATE_TIME(String START_DATE_TIME){
		this.START_DATE_TIME = START_DATE_TIME;
	}

	public String getSTART_DATE_TIME(){
		return this.START_DATE_TIME;
	}
	
	public void setEND_DATE_TIME(String END_DATE_TIME){
		this.END_DATE_TIME = END_DATE_TIME;
	}

	public String getEND_DATE_TIME(){
		return this.END_DATE_TIME;
	}


	public void setDURN_VALUE(String DURN_VALUE){
		this.DURN_VALUE = DURN_VALUE;
	}

	public String getDURN_VALUE(){
		return this.DURN_VALUE;
	}
	public void setDURN_TYPE(String DURN_TYPE){
		this.DURN_TYPE = DURN_TYPE;
	}

	public String getDURN_TYPE(){
		return this.DURN_TYPE;
	}

   public void setOrder_type_flag(String order_type_flag){
		this.order_type_flag = order_type_flag;
	}


	public String getOrder_type_flag(){
		return this.order_type_flag;
	}

	public void setSTART_DATE(String START_DATE){
		this.START_DATE = START_DATE;
	}

	public String getSTART_DATE(){
		return this.START_DATE;
	}
	
	public void setEND_DATE(String END_DATE){
		this.END_DATE = END_DATE;
	}

	public String getEND_DATE(){
		return this.END_DATE;
	}


	public void setQTY_VALUE(String QTY_VALUE){
		this.QTY_VALUE = QTY_VALUE;
	}

	public String getQTY_VALUE(){
		return this.QTY_VALUE;
	}
	public void setQTY_UNIT(String QTY_UNIT){
		this.QTY_UNIT = QTY_UNIT;
	}

	public String getQTY_UNIT(){
		return this.QTY_UNIT;
	}

	public void setDOSAGE(String DOSAGE){
		this.DOSAGE = DOSAGE;
	}

	public String getDOSAGE(){
		return this.DOSAGE;

	}
	public void setORDER_LINE_NUM(String ORDER_LINE_NUM){
		this.ORDER_LINE_NUM = ORDER_LINE_NUM;
	}

	public String getORDER_LINE_NUM(){
		return this.ORDER_LINE_NUM;
	}
	//Added for  ML-BRU-CRF-072[Inc:29938]  start
	public void setDreugIndicationRemarks(String DreugIndicationRemarks)	{
	
		this.DreugIndicationRemarks	=DreugIndicationRemarks;
		
	}
	
	public String getDreugIndicationRemarks()	{
		return this.DreugIndicationRemarks;
		
	}
	//Added for  ML-BRU-CRF-072[Inc:29938]  End

	public CompoundPrescriptionBean() {
        try {
			int i=0;
			while (i < 12) {
				diagText.add("");
				i++;
			}
            doCommon();
        }catch(Exception e) {}
	}
	
	public String getOrMode(){
		return this.or_mode;
	}

	public void setCurrDrugDetails(HashMap curr_drug_dtls) {
		this.curr_drug_dtls	=	curr_drug_dtls;
	}

	public HashMap getCurrDrugDetails() {
		return this.curr_drug_dtls;
	}

	public void setOrMode(String or_mode){
		this.or_mode = or_mode;
	}

	public void setLocationType(String locn_type) {
		this.locn_type	=	locn_type;
	}

	public void setPriority(String order_priority) {
		this.order_priority	=	order_priority;
	}
	
	public void setBSA(String bsa) {
		this.bsa	=	bsa;
	}

	public String getBSA() {
		return this.bsa;
	}

	public void setBMI(String bmi) {
		this.bmi	=	bmi;
	}

	public String getBMI() {
		return this.bmi;
	}


	public void setAllergic(String allergic_yn) {
		this.allergic_yn	=	allergic_yn;
	}

	public String getAllergic() {
		return this.allergic_yn;
	}

	public String getPriority() {
		return this.order_priority;
	}

	public String getLocationType() {
		return this.locn_type;
	}

	public void setLocationCode(String locn_code) {
		this.locn_code	=	locn_code;
	}

	public String getLocationCode() {
		return this.locn_code;
	}

	public void setPractionerID(String pract_id) {
		this.pract_id	=	pract_id;
	}

	public String getPractitionerID(){
		return this.pract_id;
	}

	public String getAmendOrderRemarks(){
		return this.AmendOrderRemarks;
	}

	public void setAmendRemarks(String remarks)	{
		this.AmendOrderRemarks=remarks;
	}

	public void setDiagText(ArrayList diagText) {
		this.diagText = new ArrayList();
		this.diagText = diagText;
	}

	public ArrayList getDiagText() {
		return this.diagText;
	}

	public String getLicense() {
		return (String)(PhLicenceRights.getKey());
	}

	public ArrayList getamendDrugCodes() {
		return this.amendDrugCodes;
	}

	public ArrayList getpresDetails() {
		return this.presDetails;
	}

	public void setAmendAllergyRemarks(String srl_no,String remarks) {
		this.AmendAllergyRemarks.put(srl_no,remarks);
	}

	public void setAmendDoseRemarks(String srl_no,String remarks) {
		this.AmendDoseRemarks.put(srl_no,remarks);
	}

	public void setAmendRxRemarks(String srl_no,String remarks) {
		this.AmendRxRemarks.put(srl_no,remarks);
	}

	public HashMap getAmendAllergyRemarks() {
		return this.AmendAllergyRemarks;
	}

	public HashMap getAmendDoseRemarks() {
		return this.AmendDoseRemarks;
	}

	public HashMap getAmendRxRemarks() {
		return this.AmendRxRemarks;
	}

	public void setHeight(String height) {
		this.height	=	height;
	}

	public String getHeight() {
		return this.height;
	}
	
	public void setHeightUOM(String height_uom) {
		this.height_uom	=	height_uom;
	}

	public String getHeightUOM() {
		return this.height_uom;
	}
	
	public void setWeightUOM(String weight_uom) {
		this.weight_uom	=	weight_uom;
	}

	public String getWeightUOM() {
		return this.weight_uom;
	}

	public void setWeight(String weight) {
		this.weight	=	weight;
	}

	public String getWeight() {
		return this.weight_uom;
	}

	private void doCommon() throws Exception {
	}

	
	public void setFREQ_CODE(String freq_code){
		this.freq_code = freq_code;
	}
	public String getFREQ_CODE(){
		return this.freq_code;
	}

	public void setExternalDrugDataBaseInterface_yn(String ext_db_interface_yn){
		this.ext_db_interface_yn = ext_db_interface_yn;
	}
	public String getExternalDrugDataBaseInterface_yn(){
		return this.ext_db_interface_yn;

	}
    public void setDrug_DB_Product_id(String drug_db_product_id){
		this.drug_db_product_id = drug_db_product_id;
	}
	public String getDrug_DB_Product_id(){
		return this.drug_db_product_id;

	}
	public void setExternalDosageYN(String ext_dosage_chk_yn){
		this.ext_dosage_chk_yn = ext_dosage_chk_yn;
	}
	public String getExternalDosageYN(){
		return this.ext_dosage_chk_yn;
	}

	public void setIVPrep(String ivprep){
		this.ivprep	=	ivprep;
	}

	public String getIVPrep(){
		return this.ivprep;
	}

	public void clear() {

		super.clear();
		order_date			= "";
		patient_class		= "";
		patient_id			= "";
		encounter_id		= "";
		drugCodes			= "";
		freqNature			= "";
		repeat_value		= "";
		int_value			= "";
		order_status		= "10";
		orderID				= "";
		packSize			= "";
		stock_uom			= "";
		DreugIndicationRemarks = "";
		srlNo				= 0;
		presc_mode			= 0;
		diagText			= new ArrayList(12);
		drugDetails			= new ArrayList();
		DrugRemarks			= new ArrayList();
		scheduleFrequency	= new HashMap();
		presDetails			= new ArrayList();
		amendDetails		= new ArrayList();
		amendDrugCodes		= new ArrayList();
		or_mode				= "";
		drug_stock_dtls		= new ArrayList();	
		height				= "";
		weight				= "";
		order_priority		= "";
		curr_drug_dtls		= new HashMap();
		orderSetValues		= new ArrayList();
		tokens_generated_yn = "";
		trn_group_ref		= "";
		orderID		= "";
		ivprep		= "";
	}

	public void setDrugRemarks(ArrayList drugremarks) {
		this.DrugRemarks = drugremarks;
	}

	public ArrayList getDrugRemarks() {
		return this.DrugRemarks;
	}

	private void setPackSize(String packSize) {
		this.packSize = packSize;
	}

	
	private String getPackSize() {
		return this.packSize;
	}

	private void setStockUOM(String stock_uom) {
		this.stock_uom = stock_uom;
	}

	private String getStockUOM() {
		return this.stock_uom;
	}

	public int getPrescMode() {
		return this.presc_mode;
	}

	public void setPrescMode(int presc_mode) {
		this.presc_mode = presc_mode;
	}

	public void genDrugRemarks(ArrayList drugremarks) {
		this.DrugRemarks = drugremarks;
	}

	public void setFrequencyNature(String freqNature) {
		this.freqNature = freqNature;
	}

	public void setRepeatValue(String repeat_value) {
		this.repeat_value = repeat_value;
	}

	public void setIntervalValue(String int_value) {
		this.int_value = int_value;
	}

	public void setOrderStatus(String order_status) {
		this.order_status = order_status;
	}

	public void setPatId(String patient_id) {
		this.patient_id = patient_id;
	}

	public void setEncId(String encounter_id) {
		this.encounter_id = encounter_id;
	}

	public void setPatientClass(String patient_class) {
		this.patient_class = patient_class;
	}

	public ArrayList getDrugStockDtls() {
		return this.drug_stock_dtls;
	}
    
	public void setDrugCodes(String drugCodes) {
		this.drugCodes = this.drugCodes +  drugCodes;
	}

	public void removeDrugCode(String drug_code) {
	
		String avlDrugCodes	= getDrugCodes();
		StringTokenizer st = new StringTokenizer(avlDrugCodes, ",");
		String newDrugCodes = "";
		while (st.hasMoreTokens()) {
			String thisToken = st.nextToken();
			if (!(thisToken.equals(drug_code))) {
				newDrugCodes = newDrugCodes + thisToken + ",";
			}
		}
		this.drugCodes = "";
		setDrugCodes(newDrugCodes);
	}

	public ArrayList getDrugDetails() {
		return this.drugDetails;
	}

	public String getPatId() {
		return this.patient_id;
	}

	public String getEncId() {
		return this.encounter_id;
	}

	public String getOrderStatus() {
		return this.order_status;
	}

	public void setOrderDate(String order_date) {		
		this.order_date = order_date;
	}

	public String getOrderDate() {
		return this.order_date;
	}

	public String getPatientClass() {
		return this.patient_class;
	}

	public String getDrugCodes() {
		return this.drugCodes;
	}

	public String getFrequencyNature() {
		return this.freqNature;
	}

	public String getRepeatValue() {
		return this.repeat_value;
	}

	public String getIntervalValue() {
		return this.int_value;
	}

	private String checkNullResult(String inputString, String defaultValue) {
		return (inputString==null) ? defaultValue : inputString;
	}

	public void removeDrugFromList(int srlNo, String drug_code) {
		removeDrugCode(drug_code);
		ArrayList temp = getDrugDetails();

		temp.remove(srlNo);
		temp.add(srlNo, new HashMap());
		this.drugDetails = temp;
	}

	public boolean doPrinting(Object request,Object response, String locn_code, String patient_class) {
		String order_id		= getOrderID();
		String facility_id	= getLoginFacilityId();
		String iv_prep		= getIVPrep();

		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports();
		ecis.utils.OnlineReport report2			= new ecis.utils.OnlineReport(facility_id, "PH", "PHPRDPRESIVCONT");
		report2.addParameter("p_facility_id", facility_id);
		report2.addParameter("p_iv_prep_yn", iv_prep);
		report2.addParameter("p_module_id", "PH");
		report2.addParameter("p_report_id","PHPRDPRESIVCONT");
		report2.addParameter("p_order_id", order_id);
		report2.addParameter("p_order_id1",order_id);
		report2.addParameter("p_locncode", locn_code);
		report2.addParameter("p_patclass", patient_class);
		report2.addParameter("p_user_name", login_by_id);
		report2.addParameter("p_language_id", getLanguageId());
		report2.addParameter("p_patient_id", getPatId());//code added for SKR-SCF-0915[IN046734]
		onlineReports.add(report2);
		//String ReportOutput = 
		onlineReports.execute((HttpServletRequest)request, (HttpServletResponse)response);
		
		return true;
	}

	public String getOrderID() {
		return this.orderID;
	}
	
	public void setOrderID(String order_id){
		this.orderID = order_id;
	}

	public String getBuildMAR_yn() {
		return this.buildMAR_yn;
	}
	
	public void setBuildMAR_yn(String buildMAR_yn){
		this.buildMAR_yn = buildMAR_yn;
	}

	public void setOrderID() {

		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37"));
			pstmt.setString(1, "PH");
			pstmt.setString(2, getPatientClass());
			pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
			resultSet	= pstmt.executeQuery();
			if(resultSet.next()) {
				this.orderID = resultSet.getString("order_id");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

	public ArrayList getFrequency(){
		Connection connection	= null;
        PreparedStatement psmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();
		try {
			connection	= getConnection();
			psmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT14"));
			psmt.setString(1, getLanguageId());
			resultSet	= psmt.executeQuery();
			if(resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(psmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return frequency;
	}

	public ArrayList getEqvlUOM(String uom_code, String base_uom) {
		Connection connection	= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet		= null;
		ArrayList eqvlUOM		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT4"));
			pstmt.setString(1, uom_code.trim());
			pstmt.setString(2, base_uom.trim());
			pstmt.setString(3, base_uom.trim());
			pstmt.setString(4, uom_code.trim());
			pstmt.setString(5, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				eqvlUOM.add(resultSet.getString("EQVL_UOM_CODE"));
				eqvlUOM.add(resultSet.getString("SHORT_DESC"));
				eqvlUOM.add(resultSet.getString("EQVL_VALUE"));
			}
		}
		catch (Exception e) {
			eqvlUOM.add(e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return eqvlUOM;
	}

	public boolean getScheduledFreqYN(String freq_code) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		boolean sched_yn		= false;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT7"));
			pstmt.setString(1, freq_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				setRepeatValue(checkNullResult(resultSet.getString("REPEAT_VALUE"), "1"));
				setIntervalValue(checkNullResult(resultSet.getString("INTERVAL_VALUE"), "1"));
				setFrequencyNature(resultSet.getString("FREQ_NATURE"));
				if (resultSet.getString("SCHEDULED_YN").equals("Y"))
					sched_yn = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return sched_yn;
	}

	public ArrayList populateDurnValues() {
		Connection connection	= null;
        CallableStatement cstmt	= null;
        ResultSet resultSet		= null;
		ArrayList durnList		= new ArrayList();

		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call PH_IVFREQ(?,?,?,?)}");
			cstmt.setString(1, getFrequencyNature());
		
			cstmt.setString(2, getIntervalValue());
			
			cstmt.setString(3, getPatientClass());
			
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			String durn_list	= cstmt.getString(4);
			
			if(durn_list==null)
				durn_list	=	"";
			StringTokenizer st	= new StringTokenizer(durn_list, "|");
			while(st.hasMoreTokens()) {
				durnList.add(st.nextToken());
			}
		}
		catch (Exception e) {
			durnList.add(e.toString());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return durnList;
	}

	public String getLocationDesc(String patient_class,String locn_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String locn_desc		=	"";

		try {
			connection	= getConnection();

			if(patient_class.equals("IP"))
				pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT41"));
			else if (patient_class.equals("OP"))
				pstmt	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT42"));

			pstmt.setString(1, getLoginFacilityId());
			pstmt.setString(2, locn_code);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
				locn_desc = checkNullResult(resultSet.getString("LONG_DESC"), "-");
			}
		}
		catch(Exception e) {
			locn_desc = e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return locn_desc;
	}

	public ArrayList getPatientDetails(String patient_id) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList pat_details	= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43"));
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();
			if (resultSet.next()) {
				pat_details.add(checkNullResult(resultSet.getString("PATIENT_NAME"), "-"));
				pat_details.add(checkNullResult(resultSet.getString("SEX"), "-"));
				pat_details.add(checkNullResult(resultSet.getString("AGE"), "-"));
			}
			else {
				pat_details.add("-");
				pat_details.add("-");
				pat_details.add("-");
			}
		}
		catch(Exception e) {
			pat_details.add(e.toString());
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return pat_details;
	}
	public HashMap getPatientDetails(String patient_id,String drug_code)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	patient_name	=	"";
		String	sex				=	"";
		String	age				=	"";
		HashMap	 pat_details	=	new HashMap();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT43A") ) ;
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				patient_name	=	resultSet.getString("PATIENT_NAME");
				sex				=	resultSet.getString("SEX");
				age				=	resultSet.getString("AGE");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}
			pat_details.put("patient_name",patient_name);
			pat_details.put("sex",sex);
			pat_details.put("age",age);

			age	=	age.trim();
			//sex	=	sex.substring(0,1);
			
			pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
			pstmt.setString(1,sex);
			pstmt.setString(2,age);
			pstmt.setString(3,drug_code);
			resultSet	= pstmt.executeQuery();
			
			while(resultSet!=null && resultSet.next() ) {
				age_group	=	resultSet.getString("AGE_GROUP_CODE");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}

			setAgeGroup(age_group);

		}
		catch(Exception e){
			pat_details.put("error",e.toString());
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
		return pat_details;
	}

	public ArrayList populateFrequencyValues() {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT5"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return frequency;
	}

	public ArrayList loadContFreq() {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT5A"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return frequency;

	}

	public String getOrderType(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		String order_catalog_code	= "";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT6"));
			pstmt.setString(1, drug_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				order_catalog_code = checkNullResult(resultSet.getString("ORDER_TYPE_CODE"), "");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return order_catalog_code;
	}

	public String populateEndDate(String start_date, String durn_value, String durn_type) {
		Connection connection		= null;
        CallableStatement cstmt		= null;
        ResultSet resultSet			= null;
		String end_date				= "";
      /*---9/24/2004---*/
		if(getOrder_type_flag().equals("Existing")){
            setSTART_DATE_TIME(start_date);
         }
		
	/*------9/24/2004----*/
		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call ph_iv_ret_end_date(?,?,?,?)}");
			cstmt.setString(1, start_date);
			cstmt.setInt(2, Integer.parseInt(durn_value));
			cstmt.setString(3, durn_type);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			end_date	= cstmt.getString(4);
		}
		catch (Exception e) {
			end_date = e.toString();
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return end_date;
	}

	public String getFormatId(String order_category,String order_type_code,String order_catalog_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String format_id		=	"";

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT46"));
			pstmt.setString(1, order_category);
			pstmt.setString(2, order_type_code);
			pstmt.setString(3, order_catalog_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				format_id	=	resultSet.getString("FORMAT_ID");
			}
		}
		catch(Exception e) {
			format_id = e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return format_id;
	}

	public ArrayList getPresValues(String form_code,String route_code,String order_catalog_code) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String remarks_code		= "";
		String remarks_desc		= "";
		ArrayList pres_values	= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT48"));
			pstmt.setString(1,order_catalog_code);
			pstmt.setString(2,form_code);
			pstmt.setString(3,route_code);
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				remarks_code = resultSet.getString("REMARK_CODE");
				remarks_desc = resultSet.getString("REMARK_DESC");

				pres_values.add(remarks_code);
				pres_values.add(remarks_desc);
			}

			if(pres_values.size() == 0)	{
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT49"));
				pstmt.setString(1, getLanguageId());
				resultSet	= pstmt.executeQuery();

				while (resultSet.next()) {
					remarks_code = resultSet.getString("REMARK_CODE");
					remarks_desc = resultSet.getString("REMARK_DESC");
					pres_values.add(remarks_code);
					pres_values.add(remarks_desc);
				}
			}
		}
		catch(Exception e) {
			pres_values.add(e.toString());
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return pres_values;
	}

	public HashMap freqValidate(String freq_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String freq_value			= "";
		String freq_nature			= "";
		String interval_value		= "";
		String repeat_value			= "";
		String schedule_yn			= "";
		String repeat_durn_type		= "";
		HashMap freqValues			= new HashMap();
		try{
		connection					= getConnection() ;

		sql_query					= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A");
		pstmt						= null;
		resultSet					= null;
		pstmt						= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,freq_code);
		pstmt.setString(2, getLanguageId());
		resultSet					= pstmt.executeQuery();
		if(resultSet!=null && resultSet.next()){
			repeat_value		= resultSet.getString("REPEAT_VALUE");
			interval_value		= resultSet.getString("INTERVAL_VALUE");
			freq_nature			= resultSet.getString("FREQ_NATURE");
			freq_value			= resultSet.getString("FREQ_VALUE");
			schedule_yn			= resultSet.getString("SCHEDULED_YN");
			repeat_durn_type	= resultSet.getString("REPEAT_DURN_TYPE");

		}

		freqValues.put("freq_nature",freq_nature);
		freqValues.put("interval_value",interval_value);
		freqValues.put("repeat_value",repeat_value);
		freqValues.put("schedule_yn",schedule_yn);
		freqValues.put("repeat_durn_type",repeat_durn_type);

		if(freq_nature.equals("O")){
			freqValues.put("freq_value","1");
			freqValues.put("repeat_durn_type","D");
			freqValues.put("interval_value","1");
			freqValues.put("repeat_value","1");
		}
		else{
			freqValues.put("freq_value",freq_value);
		}

	    }
		catch ( Exception e ) {
				freqValues.put("error",e);
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
		return freqValues;
	}

	public String populateEndDate(String freq_nature, String start_date, String durn_value, String repeat_durn_type) {
		Connection connection	= null;
		PreparedStatement pstmt = null;
        ResultSet resultSet		= null;
		String end_date			= "";

		try {
			connection = getConnection();
			if (freq_nature.equals("O")) {
				connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7A"));
			} 
			else {
				connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7AA"));
			}

			pstmt.setString(1,repeat_durn_type);
			pstmt.setString(2,start_date);
			pstmt.setString(3,durn_value);
			pstmt.setString(4,repeat_durn_type);
			pstmt.setString(5,start_date);
			pstmt.setString(6,durn_value);
			pstmt.setString(7,repeat_durn_type);
			pstmt.setString(8,start_date);
			pstmt.setString(9,durn_value);
			resultSet = pstmt.executeQuery();

			if(resultSet.next()) {
				end_date=resultSet.getString("END_DATE");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return end_date;
	}

	public ArrayList getPatientActiveOrders(String patient_id,String patient_class,String order_date,int take_home) {
		Connection connection		= null;
		PreparedStatement pstmt		= null;
		ResultSet resultSet			= null;
		String start_date			= "";
		String end_date				= "";
		String drug_desc			= "";
		String strength				= "";
		String split_dose_prev		= "";
		String strength_uom_desc	= "";
		String form_desc			= "";
		String practitioner_name	= "";
		String facility_name		= "";
		String diag_text			= "";
		String location				= "";
		String order_id				= "";
		String order_line_no		= "";
		String freq_code			= "";
		String freq_desc			= "";
		String allergy_reason		= "";
		String dosage_reason		= "";
		String duplicate_reason		= "";
		String append_qry			= "";

		ArrayList activeOrders		= new ArrayList();
		HashMap	record				= null;

		try {
			connection	= getConnection();

			if(patient_class.equals("IP") ||take_home>0) {
				append_qry	=	" ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
			} else {
				append_qry	=	" AND NVL(A.TOT_ISSUED_QTY, 0)-NVL(A.RETURNED_QTY,0)!=0 ORDER BY A.END_DATE DESC,A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
			}

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT51")+append_qry);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4, getLanguageId());
			pstmt.setString(5, getLanguageId());

			resultSet	= pstmt.executeQuery();

			while (resultSet != null && resultSet.next()) {
				record	=	new HashMap();
				start_date			= resultSet.getString("START_DATE");
				end_date			= resultSet.getString("END_DATE");
				drug_desc			= resultSet.getString("DRUG_DESC");
				strength			= resultSet.getString("STRENGTH");
				split_dose_prev		= resultSet.getString("SPLIT_DOSE_PREVIEW");
				strength_uom_desc	= resultSet.getString("STRENGTH_UOM");
				form_desc			= resultSet.getString("FORM_CODE");
				practitioner_name	= resultSet.getString("PRACTITIONER_NAME");
				facility_name		= resultSet.getString("FACILITY_NAME");
				diag_text			= resultSet.getString("DIAG_TEXT");
				location			= resultSet.getString("LOCATION");
				order_id			= resultSet.getString("ORIG_ORDER_ID");
				order_line_no		= resultSet.getString("ORIG_ORDER_LINE_NO");
				freq_code			= resultSet.getString("FREQ_CODE");
				freq_desc			= resultSet.getString("FREQ_DESC");
				allergy_reason		= resultSet.getString("ALLERGY_OVERRIDE_REASON");
				dosage_reason		= resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON");
				duplicate_reason	= resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON");

//				com.ehis.util.DateUtils.convertDate((String)orderDetails.get("ORD_DATE"),"DMYHM",getLanguageId(),"en")
				if(!getLanguageId().equals("en")){
					record.put("start_date",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",getLanguageId()));
					record.put("end_date",com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",getLanguageId()));
				}else{	   
					record.put("start_date",start_date);
					record.put("end_date",end_date);
				}
				record.put("drug_desc",drug_desc);
				record.put("strength",strength);
				record.put("strength_uom_desc",strength_uom_desc);
				record.put("form_desc",form_desc);
				record.put("practitioner_name",practitioner_name);
				record.put("location",location);
				record.put("facility_name",facility_name);
				record.put("diag_text",diag_text);
				record.put("split_dose_prev",split_dose_prev);
				record.put("order_id",order_id);
				record.put("order_line_no",order_line_no);
				record.put("freq_code",freq_code);
				record.put("freq_desc",freq_desc);
				record.put("allergy_reason",allergy_reason);
				record.put("dosage_reason",dosage_reason);
				record.put("duplicate_reason",duplicate_reason);
				activeOrders.add(record);
			}
		}
		catch(Exception e) {
			activeOrders.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return activeOrders;
	}

	// stock uom
	public String getStockUOM(String drug_code)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String stock_uom		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT82"));
			pstmt.setString(1, drug_code);
			pstmt.setString(2, getLanguageId());
			pstmt.setString(3, getLanguageId());
			pstmt.setString(4, getLanguageId());
			pstmt.setString(5, getLanguageId());
			pstmt.setString(6, getLanguageId());

			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				stock_uom	=	resultSet.getString("STOCK_UOM_DESC");
			}
		} catch(Exception e) {
			stock_uom=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ }
		}
		return stock_uom;
	}

	public void setDrugDetails(String drugList, String pract_id, String resp_id) {

		setDrugCodes(drugList);

		String start_date	= "";
			
		if(getOrder_type_flag().equals("Existing"))
			 start_date	= getSTART_DATE_TIME();
		else
			 start_date	= getOrderDate(); 

		String patientClass = getPatientClass();
		HashMap	tmp_hash	= new HashMap();
		String tmp_code		= "";
		String trade_code	= "";
		String trade_name	= "";
		int trade_count		= 0;
		StringTokenizer st	= new StringTokenizer(drugList, ",");

		Connection connection			 = null;
		PreparedStatement pstmt			 = null;
		ResultSet resultSet				 = null;
		CallableStatement cstmt			 = null;
		boolean			found			 = false;
		String durn_value				 = "";
		String durn_type				 = "";
		String freq_code				 = "";
		String repeat_durn_type			 = "";
		String schedule_yn				 = "";
		String calc_dosg_by_freq_durn_yn = "";
		String strength_value			 = "";
		String qty_value				 = "";
		String qty_desc_code			 = "";
		String pres_base_uom			 = "";
		String strength_uom				 = "";
		String dosage_type				 = "";
		String repeat_value				 = "";
		String order_type_code			 = "";
		String generic_id				 = "";
		String sDrugCode				 = "";
		String sQtyValue				 = "";
		String sQtyUom					 = "";
		String sDurnValue				 = "";
		String sDurnType				 = "";
		String sFreqCode				 = "";
		String sReqRopt					 = "";
		String ext_prod_id               = "";
		String calc_dflt_dosage_by_htwt = "";
		boolean call_external_checks	 = false;
		HashMap DrugDetails			= new HashMap();

		while (st.hasMoreTokens()) {
			
			String drugCode = st.nextToken();

			found			=	false;
			if(Drg_Trade_Codes_Arr != null){
				if(trade_count < Drg_Trade_Codes_Arr.length){
					trade_code = Drg_Trade_Codes_Arr[trade_count];
					trade_name = Drg_Trade_Codes_Arr[trade_count++];
				}
				else{
					trade_code = "";
					trade_name = "";
				}
			}
			for(int i=0; i<drugDetails.size(); i++) {
				tmp_hash	=	(HashMap)drugDetails.get(i);
				tmp_code	=	checkForNull((String)tmp_hash.get("DRUG_CODE"));
				if(tmp_code.equals(drugCode)){
					found	=	true;
					break;
				}
			}
			if(found)
				break;
			srlNo++;
			DrugDetails			= new HashMap();
			try {
				connection	= getConnection();

				if(orderSetValues.size() >0 ){
					for(int i=0; i<orderSetValues.size(); i=i+8){
						if(orderSetValues.get(i).equals(drugCode)){
							sDrugCode		 = (String)orderSetValues.get(i);
							sQtyValue		 = (String)orderSetValues.get(i+1);
							sQtyUom			 = (String)orderSetValues.get(i+2);
							sFreqCode		 = (String)orderSetValues.get(i+3);
							sDurnValue		 = (String)orderSetValues.get(i+4);
							sDurnType		 = (String)orderSetValues.get(i+5);
							sReqRopt		 = (String)orderSetValues.get(i+6);
						}
					}
				}
				DrugDetails.put("REQD_OR_OPT_IND",sReqRopt);
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT1A"));
				pstmt.setString(1, drugCode);
				pstmt.setString(2, login_facility_id);
				pstmt.setString(3, drugCode);
				pstmt.setString(4, trade_code);
				pstmt.setString(5, trade_code);
				pstmt.setString(6, getLanguageId());
				/*pstmt.setString(7, getLanguageId());
				pstmt.setString(8, getLanguageId());
				pstmt.setString(9, getLanguageId());
				pstmt.setString(10, getLanguageId());*/ //commented for ph_drug_vw_lang_vw - language issue
				resultSet	= pstmt.executeQuery();

				if(resultSet.next()) {
					DrugDetails.put("SRL_NO",srlNo+"");
					DrugDetails.put("AMEND_YN", "N");
					DrugDetails.put("rowVal",srlNo+"");
					DrugDetails.put("DRUG_CODE", (resultSet.getString("DRUG_CODE")==null ? "":resultSet.getString("DRUG_CODE")));
					DrugDetails.put("ITEM_CODE", (resultSet.getString("ITEM_CODE")==null ? "":resultSet.getString("ITEM_CODE")));
					
					ext_prod_id	=	resultSet.getString("EXTERNAL_PRODUCT_ID")==null ? "":resultSet.getString("EXTERNAL_PRODUCT_ID");
					
					DrugDetails.put("EXTERNAL_PRODUCT_ID", ext_prod_id);
					DrugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
					DrugDetails.put("PATIENT_CLASS", patientClass);
					DrugDetails.put("DRUG_DESC",(resultSet.getString("DRUG_DESC")==null ? "":resultSet.getString("DRUG_DESC")));
					DrugDetails.put("IN_FORMULARY_YN",(resultSet.getString("IN_FORMULARY_YN")==null ? "":resultSet.getString("IN_FORMULARY_YN")));
					DrugDetails.put("GENERIC_ID",(resultSet.getString("GENERIC_ID")==null ? "":resultSet.getString("GENERIC_ID")));
					generic_id = resultSet.getString("GENERIC_ID");
					DrugDetails.put("GENERIC_NAME",(resultSet.getString("GENERIC_NAME")==null ? "":resultSet.getString("GENERIC_NAME")));
					DrugDetails.put("FORM_CODE",(resultSet.getString("FORM_CODE")==null ? "":resultSet.getString("FORM_CODE")));
					DrugDetails.put("FORM_DESC",(resultSet.getString("FORM_DESC")==null ? "":resultSet.getString("FORM_DESC")));
					DrugDetails.put("ROUTE_CODE",(resultSet.getString("ROUTE_CODE")==null ? "":resultSet.getString("ROUTE_CODE")));
					DrugDetails.put("ROUTE_DESC",(resultSet.getString("ROUTE_DESC")==null ? "":resultSet.getString("ROUTE_DESC")));
					DrugDetails.put("PRES_BASE_UOM",(resultSet.getString("PRES_BASE_UOM")==null ? "":resultSet.getString("PRES_BASE_UOM")));
					DrugDetails.put("PRES_BASE_UOM_DESC",(resultSet.getString("PRES_BASE_UOM_DESC")==null ? "":resultSet.getString("PRES_BASE_UOM_DESC")));
					DrugDetails.put("ACT_STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
					DrugDetails.put("STRENGTH_VALUE",(resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE")));
					DrugDetails.put("STRENGTH_UOM",(resultSet.getString("STRENGTH_UOM")==null ? "":resultSet.getString("STRENGTH_UOM")));
					DrugDetails.put("STRENGTH_UOM_DESC",(resultSet.getString("STRENGTH_UOM_DESC")==null ? "":resultSet.getString("STRENGTH_UOM_DESC")));
					DrugDetails.put("STRENGTH_PER_PRES_UOM",(resultSet.getString("STRENGTH_PER_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_PRES_UOM")));
					DrugDetails.put("STRENGTH_PER_VALUE_PRES_UOM",(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null ? "":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")));
					DrugDetails.put("CONTENT_IN_PRES_BASE_UOM",(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null ? "":resultSet.getString("CONTENT_IN_PRES_BASE_UOM")));					
					DrugDetails.put("STOCK_UOM",(resultSet.getString("STOCK_UOM")==null ? "":resultSet.getString("STOCK_UOM")));					
					DrugDetails.put("STOCK_UOM_DESC",(resultSet.getString("STOCK_UOM_DESC")==null ? "":resultSet.getString("STOCK_UOM_DESC")));
					DrugDetails.put("PRES_CATG_CODE",(resultSet.getString("PRES_CATG_CODE")==null ? "":resultSet.getString("PRES_CATG_CODE")));
					DrugDetails.put("TRADE_CODE",(resultSet.getString("TRADE_CODE")==null ? "":resultSet.getString("TRADE_CODE")));
					DrugDetails.put("TRADE_NAME",(resultSet.getString("TRADE_NAME")==null ? "":resultSet.getString("TRADE_NAME")));
					DrugDetails.put("CALC_DOSG_BY_FREQ_DURN_YN",(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")));
					DrugDetails.put("DRUG_INDICATION",(resultSet.getString("DRUG_INDICATION")==null ? "":resultSet.getString("DRUG_INDICATION")));
					DrugDetails.put("FRACT_DOSE_APPL_YN",(resultSet.getString("FRACT_DOSE_APPL_YN")==null ? "":resultSet.getString("FRACT_DOSE_APPL_YN")));
					DrugDetails.put("FRACT_DOSE_ROUND_UP_YN",(resultSet.getString("FRACT_DOSE_ROUND_UP_YN")==null ? "":resultSet.getString("FRACT_DOSE_ROUND_UP_YN")));
					calc_dflt_dosage_by_htwt	= (resultSet.getString("CALC_DEF_DOSAGE_YN")==null ? "":resultSet.getString("CALC_DEF_DOSAGE_YN"));	
					calc_dosg_by_freq_durn_yn = resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN");
					strength_value			  = resultSet.getString("STRENGTH_VALUE")==null ? "0":resultSet.getString("STRENGTH_VALUE");
					strength_value			  = strength_value.trim();
					pres_base_uom			  = resultSet.getString("PRES_BASE_UOM");
					strength_uom			  = resultSet.getString("STRENGTH_UOM");

				}

				if(resultSet != null) {closeResultSet(resultSet);}
				if(pstmt	 != null) {closeStatement(pstmt);}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2A"));
				pstmt.setString(1, drugCode);
				pstmt.setString(2, getLanguageId());
				pstmt.setString(3, getLanguageId());
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ORDER_CATALOG_CODE",(resultSet.getString("ORDER_CATALOG_CODE")==null ? "":resultSet.getString("ORDER_CATALOG_CODE")));
					DrugDetails.put("SHORT_DESC",(resultSet.getString("SHORT_DESC")==null ? "":resultSet.getString("SHORT_DESC")));
					DrugDetails.put("ORDER_TYPE_CODE",(resultSet.getString("ORDER_TYPE_CODE")==null ? "":resultSet.getString("ORDER_TYPE_CODE")));
					order_type_code = resultSet.getString("ORDER_TYPE_CODE");
					DrugDetails.put("SECURITY_LEVEL",(resultSet.getString("SECURITY_LEVEL")==null ? "":resultSet.getString("SECURITY_LEVEL")));
					DrugDetails.put("QTY_UOM",(resultSet.getString("QTY_UOM")==null ? "":resultSet.getString("QTY_UOM")));
//					split_dose_yn	= resultSet.getString("SPLIT_DOSE_YN")==null ? "N":resultSet.getString("SPLIT_DOSE_YN");
					DrugDetails.put("SPLIT_DOSE_YN",(resultSet.getString("SPLIT_DOSE_YN")==null ? "N":resultSet.getString("SPLIT_DOSE_YN")));
					DrugDetails.put("SPLIT_DOSE","N");
					DrugDetails.put("TAPER_DOSE_YN",(resultSet.getString("TAPER_DOSE_YN")==null ? "":resultSet.getString("TAPER_DOSE_YN")));
					DrugDetails.put("BILL_YN",(resultSet.getString("BILL_YN")==null ? "":resultSet.getString("BILL_YN")));
					DrugDetails.put("QTY_REQD_YN",(resultSet.getString("QTY_REQD_YN")==null ? "N":resultSet.getString("QTY_REQD_YN")));
					DrugDetails.put("REFILL_CONT_ORDER_YN",(resultSet.getString("REFILL_CONT_ORDER_YN")==null ? "N":resultSet.getString("REFILL_CONT_ORDER_YN")));
					DrugDetails.put("CONSENT_REQD_YN",(resultSet.getString("CONSENT_REQD_YN")==null ? "N":resultSet.getString("CONSENT_REQD_YN")));
					DrugDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")));
					DrugDetails.put("CHART_RESULT_TYPE",(resultSet.getString("CHART_RESULT_TYPE")==null ? "N":resultSet.getString("CHART_RESULT_TYPE")));
					DrugDetails.put("RESULT_AUTH_REQD_YN",(resultSet.getString("RESULT_AUTH_REQD_YN")==null ? "N":resultSet.getString("RESULT_AUTH_REQD_YN")));
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				if(DrugDetails.get("CONSENT_REQD_YN").equals("Y")){
					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_CONSENT_DETAILS")) ;
					pstmt.setString(1,drugCode);
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						DrugDetails.put("CONSENT_STAGE",(resultSet.getString("CONSENT_STAGE")==null ?"":resultSet.getString("CONSENT_STAGE")) );
						if(resultSet.getString("CONSENT_STAGE")!=null && resultSet.getString("CONSENT_STAGE").equals("R"))
							DrugDetails.put("CONSENT_STATUS","P" );
						else
							DrugDetails.put("CONSENT_STATUS","");
						DrugDetails.put("NUM_OF_CONSENT_REQ_BO",(resultSet.getString("NUM_OF_CONSENT_REQ_BO")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BO")) );
						DrugDetails.put("NUM_OF_CONSENT_REQ_BR",(resultSet.getString("NUM_OF_CONSENT_REQ_BR")==null?"":resultSet.getString("NUM_OF_CONSENT_REQ_BR")) );

					}
					try{
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				}
				else{
					DrugDetails.put("CONSENT_STAGE","");
					DrugDetails.put("CONSENT_STATUS","");
					DrugDetails.put("NUM_OF_CONSENT_REQ_BO","");
					DrugDetails.put("NUM_OF_CONSENT_REQ_BR","");
				}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10C"));
				pstmt.setString(1, order_type_code);
				pstmt.setString(2, getLanguageId());
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("ORDER_TYPE_DESC",resultSet.getString("SHORT_DESC"));
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				if(!getOrder_type_flag().equals("Existing")){
					DrugDetails.put("ORD_AUTH_REQD_YN","");
					DrugDetails.put("ORD_SPL_APPR_REQD_YN","");
					DrugDetails.put("ORD_COSIGN_REQD_YN","");
					DrugDetails.put("ORD_AUTHORIZED_YN","" );
					DrugDetails.put("ORD_APPROVED_YN","");
					DrugDetails.put("ORD_COSIGNED_YN","");
					DrugDetails.put("ORD_AUTHORIZED_PREV_YN","");
					//Code added for the CRF "PMG20089-CRF-0084"  Id:  3897 on 18-Sep-2008
					pstmt				= connection.prepareStatement("select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?") ;
					pstmt.setString(1,login_facility_id);
					pstmt.setString(2,getEncId());
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						DrugDetails.put("PAT_SPECIALTY_CODE",(resultSet.getString("SPECIALTY_CODE")==null ? "":resultSet.getString("SPECIALTY_CODE")) );
					}
					try{
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}

					cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString( 1, drugCode);
					cstmt.setString( 2, patientClass);
					cstmt.setString( 3, getLanguageId());
					cstmt.setString( 4, resp_id);
					cstmt.setString( 5, pract_id);
					cstmt.setString( 6, "");
					cstmt.setString( 7, "PH");
					cstmt.registerOutParameter(8, Types.VARCHAR );
					cstmt.registerOutParameter(9, Types.VARCHAR );
					cstmt.registerOutParameter(10, Types.VARCHAR );
					cstmt.registerOutParameter(11, Types.VARCHAR );
					cstmt.registerOutParameter(12, Types.VARCHAR );
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.setString( 14, (String)DrugDetails.get("PAT_SPECIALTY_CODE"));
					cstmt.registerOutParameter(14, Types.VARCHAR );
					cstmt.setString( 15, patient_id);// Added for Bru-HIMS-CRF-385 [IN:041644]
					cstmt.setString( 16, getOrderDate());// Added for Bru-HIMS-CRF-385 [IN:041644]
					cstmt.setString( 17, getPriority());// Added for HSA-CRF-0150 [IN:048467]
					cstmt.registerOutParameter(18, Types.VARCHAR ); // ML-MMOH-CRF-1823 US008- 43528 
					cstmt.execute() ;
			
					DrugDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(8)==null ? "":cstmt.getString(8)));
					DrugDetails.put("ORD_SPL_APPR_REQD_YN",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
					DrugDetails.put("ORD_COSIGN_REQD_YN",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
					DrugDetails.put("ORD_AUTHORIZED_PREV_YN",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
					DrugDetails.put("ORD_APPROVED_YN",(cstmt.getString(12)==null ? "":cstmt.getString(12)) );
					DrugDetails.put("ORD_COSIGNED_YN",(cstmt.getString(13)==null ? "":cstmt.getString(13)) );
					DrugDetails.put("ORD_AUTHORIZED_YN",(String)DrugDetails.get("ORD_AUTHORIZED_PREV_YN"));
					try{
						closeStatement( cstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
					
				/*	cstmt=connection.prepareCall("{call OR_CHECK_SPLTY_FORCE_AUTH(?,?,?,?,?,?,?)}");
					cstmt.setString(1,pract_id);
					cstmt.setString(2,(String)DrugDetails.get("PAT_SPECIALTY_CODE"));
					cstmt.setString(3,drugCode);
					cstmt.setString(4,(String)DrugDetails.get("ORD_AUTHORIZED_PREV_YN"));
					cstmt.registerOutParameter(5, Types.VARCHAR ); //P_FORCE_AUTH_yn
					cstmt.registerOutParameter(6, Types.VARCHAR ); //P_SPECIALITY_CODE
					cstmt.registerOutParameter(7, Types.VARCHAR ); //P_ALLOW_AUTH_YN 
					cstmt.execute();
			
					DrugDetails.put("ORD_AUTH_REQD_YN",(cstmt.getString(5)==null ? "":cstmt.getString(5)));
					DrugDetails.put("CATALOG_SPLTY_CODE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
					DrugDetails.put("ORD_AUTHORIZED_YN",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );

					try{
						closeStatement( cstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}*/
				}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A"));
				pstmt.setString(1, drugCode);
				pstmt.setString(2, patientClass);
				pstmt.setString(3, getLanguageId());
				resultSet	= pstmt.executeQuery();
				
				if(resultSet!=null && resultSet.next()) {
				
					DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")));
					//DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")));
					//DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")));
					//DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")));
					DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")));
					DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")));
					DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")));
					DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
					DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("MAX_DURN_TYPE")));
					DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")));
					DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")));
					DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")));
					durn_value	= resultSet.getString("DURN_VALUE");
					freq_code	= resultSet.getString("FREQ_CODE");
					durn_type	= resultSet.getString("DURN_TYPE");
					qty_value	= resultSet.getString("QTY_VALUE");

				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				if(!DrugDetails.containsKey("ACT_PATIENT_CLASS")) {

					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A")) ;
					pstmt.setString(1,drugCode);
					pstmt.setString(2,"*A");
					pstmt.setString(3, getLanguageId());
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						DrugDetails.put("ACT_PATIENT_CLASS",(resultSet.getString("PATIENT_CLASS")==null ? "":resultSet.getString("PATIENT_CLASS")) );
						//DrugDetails.put("ORD_AUTH_REQD_YN",(resultSet.getString("ORD_AUTH_REQD_YN")==null ? "N":resultSet.getString("ORD_AUTH_REQD_YN")) );
						//DrugDetails.put("ORD_SPL_APPR_REQD_YN",(resultSet.getString("ORD_SPL_APPR_REQD_YN")==null ? "N":resultSet.getString("ORD_SPL_APPR_REQD_YN")) );
						//DrugDetails.put("ORD_COSIGN_REQD_YN",(resultSet.getString("ORD_COSIGN_REQD_YN")==null ? "N":resultSet.getString("ORD_COSIGN_REQD_YN")) );

						DrugDetails.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")) );
						DrugDetails.put("TAB_QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );
						//DrugDetails.put("QTY_UOM",(resultSet.getString("QTY_UOM")==null ? "":resultSet.getString("QTY_UOM")) );
						DrugDetails.put("FREQ_CODE",(resultSet.getString("FREQ_CODE")==null ? "":resultSet.getString("FREQ_CODE")) );
						DrugDetails.put("DURN_VALUE",(resultSet.getString("DURN_VALUE")==null ? "":resultSet.getString("DURN_VALUE")) );
						DrugDetails.put("DURN_TYPE",(resultSet.getString("DURN_TYPE")==null ? "":resultSet.getString("DURN_TYPE")) );
						DrugDetails.put("CHK_FOR_MAX_DURN_ACTION",(resultSet.getString("CHK_FOR_MAX_DURN_ACTION")==null ? "":resultSet.getString("CHK_FOR_MAX_DURN_ACTION")) );
						DrugDetails.put("PROMPT_MSG",(resultSet.getString("PROMPT_MSG")==null ? "":resultSet.getString("PROMPT_MSG")) );
						DrugDetails.put("MAX_DURN_VALUE",(resultSet.getString("MAX_DURN_VALUE")==null ? "":resultSet.getString("MAX_DURN_VALUE")) );
						durn_value		= resultSet.getString("DURN_VALUE");
						freq_code		= resultSet.getString("FREQ_CODE");
						durn_type		= resultSet.getString("DURN_TYPE");
						qty_value		= resultSet.getString("QTY_VALUE");
					}

				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				if(sDrugCode.equals(drugCode)){
					qty_value		= sQtyValue;
					freq_code		= sFreqCode;
					durn_value		= sDurnValue;
					durn_type		= sDurnType;
				}

				pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT4A"));
				pstmt.setString(1,drugCode);
				pstmt.setString(2,getPatId());
				pstmt.setString(3,getLanguageId());  //Added for RUT-SCF-0191.1 [IN:037367]- start
				pstmt.setString(4,drugCode);
				pstmt.setString(5,getPatId()); //Added for RUT-SCF-0191.1 [IN:037367]- end
				int rec_count	=0;
				resultSet		= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					rec_count=resultSet.getInt(1);
				}

				if(rec_count>0) {
					DrugDetails.put("ALLERGY_YN","Y");
				} 
				else {
					DrugDetails.put("ALLERGY_YN","N");
				}
			   			   
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A"));
				pstmt.setString(1, start_date);
				pstmt.setString(2, start_date);
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					if(!getLanguageId().equals("en")){
						DrugDetails.put("FUTURE_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("FUTURE_DATE")),"DMYHM",getLanguageId(),"en"));
						DrugDetails.put("BACK_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("BACK_DATE")),"DMYHM",getLanguageId(),"en"));
					}
					else{
						DrugDetails.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")));
						DrugDetails.put("BACK_DATE",(resultSet.getString("BACK_DATE")));
					}
				}

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A"));
				if(getOrder_type_flag().equals("amend")||getOrder_type_flag().equals("Existing")){
                      freq_code=getFREQ_CODE(); 
				}
				
	  		    pstmt.setString(1, freq_code);
				pstmt.setString(2, getLanguageId());
     			resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("REPEAT_VALUE",(resultSet.getString("REPEAT_VALUE")));
					DrugDetails.put("INTERVAL_VALUE",(resultSet.getString("INTERVAL_VALUE")));
					DrugDetails.put("FREQ_NATURE",(resultSet.getString("FREQ_NATURE")));
					DrugDetails.put("FREQ_VALUE",(resultSet.getString("FREQ_VALUE")));
					DrugDetails.put("FREQ_DESC",(resultSet.getString("FREQ_DESC")));
					DrugDetails.put("SCHEDULED_YN",(resultSet.getString("SCHEDULED_YN")));
					DrugDetails.put("REPEAT_DURN_TYPE",(resultSet.getString("REPEAT_DURN_TYPE")));
					repeat_durn_type=resultSet.getString("REPEAT_DURN_TYPE");
					schedule_yn=resultSet.getString("SCHEDULED_YN");
					repeat_value=checkNullResult(resultSet.getString("REPEAT_VALUE"), "1");
				}
				
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7A"));
				pstmt.setString(1, repeat_durn_type);
				pstmt.setString(2, start_date);
				pstmt.setString(3, durn_value);
				pstmt.setString(4, repeat_durn_type);
				pstmt.setString(5, start_date);
				pstmt.setString(6, durn_value);
				pstmt.setString(7, repeat_durn_type);
				pstmt.setString(8, start_date);
				pstmt.setString(9, durn_value);
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
				    if(!getLanguageId().equals("en"))
						DrugDetails.put("END_DATE",com.ehis.util.DateUtils.convertDate((resultSet.getString("END_DATE")),"DMYHM",getLanguageId(),"en"));
					else
						DrugDetails.put("END_DATE",(resultSet.getString("END_DATE")));
				}

			    if(!getLanguageId().equals("en"))
					DrugDetails.put("START_DATE",com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",getLanguageId(),"en"));
				else
					DrugDetails.put("START_DATE",start_date);

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A"));
				pstmt.setString(1, durn_type);
				pstmt.setString(2, getLanguageId());
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("DURN_DESC",(resultSet.getString("DURN_DESC")));
					DrugDetails.put("OR_DURN_DESC",(resultSet.getString("DURN_DESC")));
				}

//				if(sDrugCode.equals(drugCode)){
//							DrugDetails.put("DOSAGE_TYPE","Q");
//							DrugDetails.put("ORI_DOSAGE_TYPE","Q");
//							dosage_type="Q";
//				} else {

				if(calc_dosg_by_freq_durn_yn==null || calc_dosg_by_freq_durn_yn.equals("N")) {
					DrugDetails.put("DOSAGE_TYPE","A");
					DrugDetails.put("ORI_DOSAGE_TYPE","A");
					dosage_type="A";
				} 
				else {
					if(strength_value.equals("0")) {
						DrugDetails.put("DOSAGE_TYPE","Q");
						DrugDetails.put("ORI_DOSAGE_TYPE","Q");
						dosage_type="Q";
					} 
					else {
						DrugDetails.put("DOSAGE_TYPE","S");
						DrugDetails.put("ORI_DOSAGE_TYPE","S");
						dosage_type="S";
					}
				}
				String proc_qty_value="";
				if(sDrugCode.equals(drugCode)){
					DrugDetails.put("QTY_VALUE",qty_value);
					DrugDetails.put("QTY_DESC_CODE","");
					DrugDetails.put("QTY_UOM",sQtyUom);
					qty_desc_code=sQtyUom;
					proc_qty_value=qty_value;
				}
				else {
					//if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
					if(!((String)DrugDetails.get("DOSAGE_TYPE")).equals("S")){
						DrugDetails.put("QTY_VALUE",qty_value);
						DrugDetails.put("QTY_DESC_CODE","");
						qty_desc_code=pres_base_uom;
						proc_qty_value=qty_value;
					}
					else {
						DrugDetails.put("QTY_VALUE",strength_value);
						DrugDetails.put("QTY_DESC_CODE","");
						proc_qty_value=strength_value;
						qty_desc_code=strength_uom;
					}
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9A"));
				pstmt.setString(1, qty_desc_code);
				pstmt.setString(2, getLanguageId());
				resultSet	= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("QTY_DESC",(resultSet.getString("SHORT_DESC")));
					DrugDetails.put("OR_QTY_DESC",(resultSet.getString("SHORT_DESC")));
				}

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT14A"));
				pstmt.setString(1, login_facility_id);
				resultSet			= pstmt.executeQuery();

				if(resultSet!=null && resultSet.next()) {
					DrugDetails.put("REFILL_YN",(resultSet.getString("REFILL_YN")==null ? "N":resultSet.getString("REFILL_YN")));
					DrugDetails.put("MAX_REFILLS_FOR_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_REFILLS_FOR_PRES")));
					DrugDetails.put("MAX_DURN_FOR_REFILL_PRES",(resultSet.getString("MAX_REFILLS_FOR_PRES")==null ? "0":resultSet.getString("MAX_DURN_FOR_REFILL_PRES")));
				}

				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}

/*=============================================*/	

			//code for checking whether fdb checks are applicapable or not.
				 if(ext_db_interface_yn.equals("Y") && !ext_prod_id.equals("")){
					call_external_checks =true;
				 }
				 else{
					call_external_checks =false;  
				 } 
/*
       PERFORM_EXTERNAL_DATABASE_CHECKS   will indicate whether  module shiuld perform External checks(FDB)or module checks
         external checks
		 ===============
		 1.duplicate
		 2.drug interaction
		 3.contra-indication
		 
		 internal checks
		 ===============
		 1.duplictae check
		 2.overdose check
*/

    // code written to check whether fdb checks to be performed or PH module checks should be performed
				if(!call_external_checks ) {
					DrugDetails.put("PERFORM_EXTERNAL_DATABASE_CHECKS","N");
				}
				else{				
					DrugDetails.put("PERFORM_EXTERNAL_DATABASE_CHECKS","Y"); 
				}	 
				//DrugDetails.put("EXTERNAL_OVERRIDE_REASON","");

				DrugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_CONTRA_OVERRIDE_REASON","");
				DrugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON","");

				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","N");
				DrugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN","N");
	//ends here   
	/*=============================================*/			
				HashMap pat_dtls	=	getPatientDetails(patient_id,drugCode);
				String	age			=	(String)pat_dtls.get("age");
				String sex			=	((String)pat_dtls.get("sex"));
				age	=	age.trim();
				//sex	=	sex.substring(0,1);
				
				pstmt	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT80A") ) ;
				pstmt.setString(1,sex);
				pstmt.setString(2,age);
				pstmt.setString(3,drugCode);
				resultSet	= pstmt.executeQuery();
				
				while(resultSet!=null && resultSet.next() ) {
					age_group	=	resultSet.getString("AGE_GROUP_CODE");
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				if(calc_dflt_dosage_by_htwt.trim().equals("Y") && !age_group.equals("")) {
			
					String sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
					pstmt				= connection.prepareStatement(sql_query) ;
					pstmt.setString(1,drugCode);
					pstmt.setString(2,age_group);
					resultSet			= pstmt.executeQuery();

					if(resultSet!=null && resultSet.next()) {
									
						DrugDetails.put("RECOMM_YN","Y");
						DrugDetails.put("CALC_BY_IND",(resultSet.getString("CALC_BY_IND")));
						DrugDetails.put("DOSAGE_STD",(resultSet.getString("DOSAGE_STD")));
						DrugDetails.put("DOSAGE_UNIT",(resultSet.getString("DOSAGE_UNIT")));
						DrugDetails.put("RECOMM_DOSAGE_BY",(resultSet.getString("LIMIT_IND")));
					} 
					else {
						DrugDetails.put("RECOMM_YN","N");
						DrugDetails.put("CALC_BY_IND","");
						DrugDetails.put("DOSAGE_STD","");
						DrugDetails.put("DOSAGE_UNIT","");
						DrugDetails.put("RECOMM_DOSAGE_BY","");
					}
					try{
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
					}
					catch(Exception es){
						es.printStackTrace() ;
					}
				} 
				else {
					DrugDetails.put("CALC_BY_IND","");
					DrugDetails.put("RECOMM_YN","N");
					DrugDetails.put("DOSAGE_STD","");
					DrugDetails.put("DOSAGE_UNIT","");
				}				
			//call max dosage limit proc
				if(call_external_checks){

					cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit(?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString(1, drugCode);
					cstmt.setString(2, patient_id);
					cstmt.setString(3, proc_qty_value);
					cstmt.setString(4, "1");
					cstmt.setString(5, dosage_type);
					cstmt.registerOutParameter(6, Types.VARCHAR);
					cstmt.registerOutParameter(7, Types.VARCHAR);
					cstmt.registerOutParameter(8, Types.VARCHAR);
					cstmt.registerOutParameter(9, Types.VARCHAR);
					cstmt.registerOutParameter(10, Types.VARCHAR);
					cstmt.registerOutParameter(11, Types.VARCHAR);
					cstmt.registerOutParameter(12, Types.VARCHAR);
					cstmt.execute();
	//				String daily_dose		= "";
	//				String unit_dose		= "";
	//				String min_daily_dose	= "";
	//				String min_unit_dose	= "";
					String limit_ind		= cstmt.getString(8);
	//				String mono_graph		= "";
	//				String dosage_unit		= "";
					DrugDetails.put("LIMIT_IND",limit_ind);

					DrugDetails.put("DAILY_DOSE",(cstmt.getString(6)==null ? "0":cstmt.getString(6)));
					DrugDetails.put("UNIT_DOSE",(cstmt.getString(7)==null ? "0":cstmt.getString(7)));
					DrugDetails.put("MONO_GRAPH","");
					DrugDetails.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "0":cstmt.getString(10)));
					DrugDetails.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "0":cstmt.getString(11)));
					DrugDetails.put("DOSAGE_UNIT", (cstmt.getString(12)==null ? "":cstmt.getString(12)));
					if(limit_ind!=null && limit_ind.equals("N")) {
						DrugDetails.put("MONO_GRAPH", (cstmt.getString(9)==null ? "":cstmt.getString(9)));
					}
				}
				else {
					DrugDetails.put("LIMIT_IND","Y"); 
				}

                if(!call_external_checks){
					int count_rx	= 0;
					pstmt			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13"));
					pstmt.setString(1, getPatId());
					pstmt.setString(2, generic_id);
					pstmt.setString(3, (String)DrugDetails.get("START_DATE"));// Changed for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(4, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(5, (String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(6, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(7, (String)DrugDetails.get("START_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					pstmt.setString(8, (String)DrugDetails.get("END_DATE"));// Added for ML-BRU-SCF-0811 [IN:039394]
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next())
						count_rx=resultSet.getInt(1);

					if(resultSet != null)
						closeResultSet(resultSet);
					if(pstmt	 != null) 
						closeStatement(pstmt);

					if(count_rx>0) {
						DrugDetails.put("CURRENT_RX","Y");
					} 
					else {
						DrugDetails.put("CURRENT_RX","N");
					}
				//calucalte total_qty
				}
				else{
                   DrugDetails.put("CURRENT_RX","N");
				}

				if(dosage_type.equals("A")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals("")))) {
						total_qty=Float.parseFloat(qty_value);
					}
					DrugDetails.put("TOT_STRENGTH","0");
					DrugDetails.put("TOT_STRENGTH_UOM","");
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					DrugDetails.put("PRES_QTY_VALUE",qty_value);
					DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
				} 
				else if (dosage_type.equals("Q")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
						total_qty=Float.parseFloat(qty_value);
					}
					//get the conversion factor
					if(strength_value==null || strength_value.equals("0") || strength_value.equals("")) {
						DrugDetails.put("TOT_STRENGTH","0");
						DrugDetails.put("TOT_STRENGTH_UOM","");
						DrugDetails.put("EQUAL_VALUE","");
					}
					else {
						String equal_value=(String)getConvFactor(strength_uom,qty_desc_code);
						float tot_strength=0.0f;
						if(equal_value!=null && !(equal_value.equals(""))) {
							tot_strength=total_qty*Integer.parseInt(equal_value);
						}

						DrugDetails.put("EQUAL_VALUE", equal_value);
						DrugDetails.put("TOT_STRENGTH",String.valueOf(tot_strength));
						DrugDetails.put("TOT_STRENGTH_UOM",strength_uom);
					}
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					DrugDetails.put("STRENGTH_VALUE","0");
					DrugDetails.put("STRENGTH_UOM","");
					DrugDetails.put("PRES_QTY_VALUE",qty_value);
					DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
				}
				else if (dosage_type.equals("S")) {
					float total_qty=0.0f;
					if((qty_value!=null && !(qty_value.equals(""))) && (durn_value!=null && !(durn_value.equals(""))) && (repeat_value!=null && !(repeat_value.equals(""))) ) {
						total_qty=Float.parseFloat(qty_value);
					}
					DrugDetails.put("TOT_STRENGTH",String.valueOf(total_qty));
					DrugDetails.put("TOT_STRENGTH_UOM",qty_desc_code);
					DrugDetails.put("DISPENSED_QTY",String.valueOf(total_qty));
					DrugDetails.put("DISPENSED_UOM",qty_desc_code);
					DrugDetails.put("BMS_QTY",String.valueOf(total_qty));
					DrugDetails.put("BMS_STRENGTH","");
					DrugDetails.put("PRES_QTY_VALUE",qty_value);
					DrugDetails.put("PRES_QTY_UOM",qty_desc_code);
				}

				DrugDetails.put("REFILL_START_DATE","");
				DrugDetails.put("REFILL_END_DATE","");
				DrugDetails.put("AUTH_YN","N");
				DrugDetails.put("APPROVAL_YN","N");
				DrugDetails.put("COSIGN_YN","N");
				DrugDetails.put("ORD_AUTHORIZED_YN","N");
				DrugDetails.put("ORD_APPROVED_YN","N");
				DrugDetails.put("ORD_COSIGNED_YN","N");
				DrugDetails.put("ALLOW_REFILL","N");
				DrugDetails.put("NO_REFILL","0");
				DrugDetails.put("ADMIN_TIME","");
				DrugDetails.put("ADMIN_QTY","");
				DrugDetails.put("RECORD_GEN","");
				DrugDetails.put("ALLERGY_OVERRIDE","N");
				DrugDetails.put("DOSE_OVERRIDE","N");
				DrugDetails.put("CURRENTRX_OVERRIDE","N");
				DrugDetails.put("ALLERGY_REMARKS","");
				DrugDetails.put("DOSE_REMARKS","");
				DrugDetails.put("CURRENTRX_REMARKS","");
				DrugDetails.put("TAPPERED_OVER","N");
				DrugDetails.put("DFLT_QTY_UOM","");

				if((!dosage_type.equals("A")) &&  schedule_yn.equals("Y"))
					DrugDetails.put("SCH_OVER_YN","Y");
				else 
					DrugDetails.put("SCH_OVER_YN","N");

				float ext_qty=0;
				int ext_repeat_value=0;
				int ext_durn=0;
				if(qty_value!=null && !qty_value.equals(""))
					ext_qty=Float.parseFloat(qty_value);
				if(repeat_value!=null && !repeat_value.equals(""))
					ext_repeat_value=Integer.parseInt(repeat_value);
				if(durn_value!=null && !durn_value.equals(""))
					ext_durn=Integer.parseInt(durn_value);
				float total_qty_value=ext_qty*ext_repeat_value*ext_durn;
				DrugDetails.put("TOTAL_QTY_VALUE",""+total_qty_value);
			}
			catch(Exception e) {
				DrugDetails.put("error",e);
				e.printStackTrace();
			}
			finally {
				try {
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeStatement(cstmt);
					closeConnection(connection);
				}
				catch(Exception es){
					es.printStackTrace();
				}
			}

			this.setCurrDrugDetails(DrugDetails);
			drugDetails.add(DrugDetails);
		}
	}

	public String getConvFactor(String strength,String qty_uom)	{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String equl_value		= "";

		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53"));

			pstmt.setString(1, strength);
			pstmt.setString(2, qty_uom);
			pstmt.setString(3, strength);
			pstmt.setString(4, qty_uom);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				equl_value	=	resultSet.getString("EQVL_VALUE");
			}
		}
		catch(Exception e) {
			equl_value=e.toString();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ }
		}
		return equl_value;
	}

public ArrayList validateForStock(String patient_class){
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		ArrayList stock_params		= new ArrayList();
		String consider_stock		= null;
		String allow_without_stock  = null;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT15") );
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				if(patient_class.equals("IP")) {
					consider_stock		=		resultSet.getString("IP_CONSIDER_STOCK_PRES_YN");
					allow_without_stock  =		resultSet.getString("IP_PRES_WITHOUT_STOCK_YN");
				} else {
					consider_stock		=	resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN");
					allow_without_stock  = resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN");
				}
				stock_params.add(consider_stock);
				stock_params.add(allow_without_stock);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return stock_params;
	}

 public HashMap chkStockAvail(String item_code,String disp_code,String total_qty,String end_date){
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        ResultSet resultSet         = null ;

		HashMap stockValues			= new HashMap();
		
		try{
			connection = getConnection() ;
			cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, item_code);
			cstmt.setString( 2, disp_code);
			cstmt.setString( 3, total_qty);
			cstmt.setString( 4, "Y");
			cstmt.setString( 5, end_date);
			cstmt.setString( 6, "N");
			cstmt.setString( 7, "");
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.INTEGER );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			cstmt.registerOutParameter(13, Types.VARCHAR );
			cstmt.registerOutParameter(14, Types.VARCHAR );
			cstmt.registerOutParameter(15, Types.VARCHAR );
			cstmt.registerOutParameter(16, Types.VARCHAR );
			cstmt.registerOutParameter(17, Types.VARCHAR );
			cstmt.registerOutParameter(18, Types.VARCHAR );
			cstmt.registerOutParameter(19, Types.VARCHAR );
			cstmt.execute() ;
			stockValues.put("STOCK_AVAILABLE_YN",(String)(cstmt.getString(8)==null ? "Y":cstmt.getString(8)));
			stockValues.put("AVAILABLE_STOCK",(String.valueOf(cstmt.getInt(11))));
		}
		catch ( Exception e ) {
				stockValues.put("STOCK_AVAILABLE_YN","N");
				stockValues.put("AVAILABLE_STOCK","0");
		} finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
        }
		return stockValues;
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap();
		map.put("result", new Boolean(true ));
		map.put("message", "success..");

		return map;
	}

	public void clearscheduleFrequency(String code){
		if(scheduleFrequency.containsKey(code)) {
			scheduleFrequency.remove(code);
		}
	}

	public void resetscheduleFrequency() {
		this.scheduleFrequency = new HashMap();
	}

	public boolean setScheduleFrequencyStr(Hashtable ht) {

		try {

			String code 			= (String)ht.get("code");
			String duration_type 	= (String)ht.get("durationType");
			int repeat				= Integer.parseInt((String)ht.get("repeat"));
			String row_value		= (String)ht.get("row_value");
			scheduleFrequency		= new HashMap();
			ArrayList scheduleFrequencyDatas = new ArrayList();

			for(int j=1; j <= repeat; j++) {
		
				HashMap hashMap	= new HashMap();
				hashMap.put("admin_day_or_time","H");
				hashMap.put("duration_type",duration_type);
				hashMap.put("start_time_assign","");
				hashMap.put("repeat",String.valueOf(repeat));
				hashMap.put("row_value",row_value);
				hashMap.put("admin_time",(String)ht.get("time"+j));
				hashMap.put("admin_qty",(String)ht.get("qty"+j));
				scheduleFrequencyDatas.add(hashMap);
			}
			scheduleFrequency.put(code,scheduleFrequencyDatas); 
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
    
	public HashMap getscheduleFrequency() {
		return this.scheduleFrequency;
	}

	public ArrayList getScheduleFrequencyStr(String code, String row_value) {
		Object scheduleFrequencyDatasObj = scheduleFrequency.get(code);

		if(scheduleFrequencyDatasObj == null)
			return new ArrayList();
		else
			return (ArrayList)scheduleFrequencyDatasObj;
	}

	public String getPrescriptionRemarks(String remark_code){
		String remarks ="";
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRES_REMARKS")) ;
			pstmt.setString(1,remark_code);
			pstmt.setString(2, getLanguageId());
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				remarks = (String)resultSet.getString("REMARK_DESC");
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
		return remarks.trim();
    }

	public String checkPreScheduled(String freq_code) {
	
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String pre_sch_yn			= "";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT66")) ;
			pstmt.setString(1,freq_code);
			resultSet				= pstmt.executeQuery();

			if(resultSet!=null && resultSet.next()){
				pre_sch_yn	=	resultSet.getString("TOTAL");
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
		return pre_sch_yn;
	}

	public HashMap prepareCompoundRx() {
	 
		Connection connection					= null;
		CallableStatement cstmt_insert			= null;
		String priority				=  getPriority();
		String perf_locn_code		=	"";
		String perf_locn_type		=	"";
		String stock_result			=	"";

		HashMap tab_data					= new HashMap();
	//	int count							    =	0;  Removed for IN063877
		if(priority.equals("")) {
			priority			=	"R";
		}
		if(!getLanguageId().equals("en")){
			order_date = com.ehis.util.DateUtils.convertDate(order_date,"DMYHM",getLanguageId(),"en");				   
		}

		tab_data.put("drugDetails",drugDetails);
		tab_data.put("order_id",getOrderID());
		tab_data.put("priority",priority);
		tab_data.put("drugRemarks",getDrugRemarks());
		tab_data.put("scheduleFreq",getscheduleFrequency());
		tab_data.put("patient_id",getPatId());
		tab_data.put("encounter_id",getEncId());
		tab_data.put("patient_class",getPatientClass());
		tab_data.put("login_facility_id",login_facility_id);
		tab_data.put("location_type",getLocationType());
		tab_data.put("location_code",getLocationCode());
		tab_data.put("pract_id",getPractitionerID());
		tab_data.put("order_date",order_date);
		tab_data.put("login_by_id",login_by_id);		
		tab_data.put("login_at_ws_no",login_at_ws_no);	
		tab_data.put("buildMAR_yn",getBuildMAR_yn());
		tab_data.put("order_comment",getAmendOrderRemarks());	
		tab_data.put("height",getHeight());	
		tab_data.put("height_uom",getHeightUOM());	
		tab_data.put("weight",getWeight());	
		tab_data.put("weight_uom",getWeightUOM());	
		tab_data.put("bsa",getBSA());	
		tab_data.put("allergic_yn",getAllergic());	
		tab_data.put("bmi",getBMI());	
		tab_data.put("diagText",diagText);	
											 
		try {								  
			connection = getConnection();
		
			if(drugDetails.size() > 0) {

				if(license!=null && !license.equals("PHBASIC")) {
					cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
					cstmt_insert.setString(1, login_facility_id);
					cstmt_insert.setString(2, getLocationType());
					cstmt_insert.setString(3, getLocationCode());
					cstmt_insert.setString(4, "N");
					cstmt_insert.setString(5,priority);
					cstmt_insert.registerOutParameter(6, Types.VARCHAR);
					cstmt_insert.registerOutParameter(7, Types.VARCHAR);
					cstmt_insert.execute();
					perf_locn_code	= cstmt_insert.getString(6);
					perf_locn_type	= cstmt_insert.getString(7);
				} 
				else {
					perf_locn_code	= getLocationCode();
					perf_locn_type	= getLocationType();
				}

				stock_result		=	validateCompStock(getPatientClass(),perf_locn_code,drugDetails);

				tab_data.put("perf_locn_type",perf_locn_type);
				tab_data.put("perf_locn_code",perf_locn_code);
				tab_data.put("stock_result",stock_result);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeStatement(cstmt_insert);
				closeConnection(connection) ;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return tab_data;
	}

	public HashMap releaseCompoundRx() {
	 
		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "test");

		Connection connection					= null;
		PreparedStatement pstmt_insert			= null;
		PreparedStatement pstmt_select			= null;
		ResultSet         resultSet				= null;
		CallableStatement cstmt_insert			= null;
		PreparedStatement pstmt_clob			= null;
		PreparedStatement pstmt_workload		= null;
		PreparedStatement workload_insert       = null;	 
		PreparedStatement work_insert_month     = null;	 
		PreparedStatement work_insert_loc       = null; 
		PreparedStatement work_insert_loc_mon   = null;	 
	    ResultSet 		  resultSet_workload    = null;
		ArrayList drugRemarks                   = null;
		HashMap scheduleFreq					= null;
    	int count							    =	0;
		String order_id				= getOrderID();
		String order_type			=	"";
		String perf_locn_code		=	"";
		String perf_locn_type		=	"";
		String short_desc			=	"";
		String priority				=  getPriority();
		HashMap record				= null;
		String stock_result			=	"";
		String ord_consent_reqd_yn	=	"N";

		drugRemarks		= getDrugRemarks();
		scheduleFreq	= getscheduleFrequency();

		if(priority.equals("")) {
			priority			=	"R";
		}
	
		try {
		connection = getConnection();
		if(!getLanguageId().equals("en")){
			order_date = com.ehis.util.DateUtils.convertDate(order_date,"DMYHM",getLanguageId(),"en");				   
		}
		
		if(drugDetails.size() > 0) {

		if(license!=null && !license.equals("PHBASIC")) {
			cstmt_insert = connection.prepareCall("{call PH_RET_DISPLOCNIV(?,?,?,?,?,?,?)}");
			cstmt_insert.setString(1, login_facility_id);
			cstmt_insert.setString(2, getLocationType());
			cstmt_insert.setString(3, getLocationCode());
			cstmt_insert.setString(4, "N");
			cstmt_insert.setString(5,priority);
			cstmt_insert.registerOutParameter(6, Types.VARCHAR);
			cstmt_insert.registerOutParameter(7, Types.VARCHAR);
			cstmt_insert.execute();
			perf_locn_code	= cstmt_insert.getString(6);
			perf_locn_type	= cstmt_insert.getString(7);
		} 
		else {
			perf_locn_code	= getLocationCode();
			perf_locn_type	= getLocationType();
		}


		order_type	=	(String)((HashMap)drugDetails.get(0)).get("ORDER_TYPE_CODE");
		stock_result		=	validateCompStock(getPatientClass(),perf_locn_code,drugDetails);

		if(stock_result.equals("")) {
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT"));
			resultSet		= pstmt_select.executeQuery();

			if (resultSet.next()) {
				trn_group_ref = resultSet.getString("TRN_GROUP_REF");
			}
			try{
				closeStatement(pstmt_select);
				closeResultSet(resultSet);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			for(int i=0; i<drugDetails.size(); i++ ) {
				record		=	(HashMap)drugDetails.get(i);
				if (record.get("CONSENT_REQD_YN").toString().equals("Y")){
					ord_consent_reqd_yn = "Y";
					break;
				}
			}
  // OR_ORDER
			pstmt_insert	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_INSERT1"));
			pstmt_insert.setString(++count, order_id);				// ORDER_ID
			pstmt_insert.setString(++count, order_type);			// ORDER_TYPE_CODE
			pstmt_insert.setString(++count, "PH");					//ORDER_CATEGORY
			pstmt_insert.setString(++count, "PH");					//CONTR_SYS_ID
			pstmt_insert.setString(++count, getPatId());			//PATIENT_ID
			pstmt_insert.setString(++count, getPatientClass());			//PATIENT_CLASS
			pstmt_insert.setString(++count, login_facility_id);		//ORDERING_FACILITY_ID
			pstmt_insert.setString(++count, getEncId());			//ENCOUNTER_ID
			pstmt_insert.setString(++count, getEncId());			//EPISODE_ID
			pstmt_insert.setString(++count, "");					//EPISODE_VISIT_NUM
			pstmt_insert.setString(++count, getLocationType());			//SOURCE_TYPE
			pstmt_insert.setString(++count, getLocationCode());			//SOURCE_CODE
			pstmt_insert.setString(++count, "");					//DISCHARGE_IND
			pstmt_insert.setString(++count, order_date);			//ORD_DATE_TIME
			pstmt_insert.setString(++count, getPractitionerID());			//ORD_PRACT_ID
			pstmt_insert.setString(++count, priority);		//PRIORITY
			pstmt_insert.setString(++count, "N");				//ORD_AUTH_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_AUTH_LEVEL
			pstmt_insert.setString(++count, getPractitionerID());			//ORD_AUTH_BY_PRACT_ID
			pstmt_insert.setString(++count, order_date);			//ORD_AUTH_DATE_TIME
			pstmt_insert.setString(++count, "N");				//ORD_APPR_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_APPR_BY_USER_ID
			pstmt_insert.setString(++count, null);				//ORD_APPR_DATE_TIME
			pstmt_insert.setString(++count, "N");				//ORD_COSIGN_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_COSIGN_LEVEL
			pstmt_insert.setString(++count, "");					//ORD_COSIGN_BY_PRACT_ID
			pstmt_insert.setString(++count, null);				//ORD_COSIGN_DATE_TIME
			pstmt_insert.setString(++count, null);				//ORD_PRINT_DATE_TIME
			pstmt_insert.setString(++count, "N");				//BILL_YN
			pstmt_insert.setString(++count, "CO");				//CONT_ORDER_IND
			pstmt_insert.setString(++count, login_facility_id);	//PERFORMING_FACILITY_ID
			pstmt_insert.setString(++count, "PH");				//PERFORMING_SYS_ID
			pstmt_insert.setString(++count, perf_locn_type);		//PERFORMING_DEPTLOC_TYPE
			pstmt_insert.setString(++count, perf_locn_code);		//PERFORMING_DEPTLOC_CODE
			pstmt_insert.setString(++count, pract_id);			//PERFORMING_PRACT_ID
			pstmt_insert.setString(++count, "N");				//RESULT_AUTH_REQD_YN
			pstmt_insert.setString(++count, "N");				//CHILD_ORDER_YN
			pstmt_insert.setString(++count, "");					//PARENT_ORDER_ID
			pstmt_insert.setString(++count, "N");				//ORDER_SET_YN
			pstmt_insert.setString(++count, "");					//ORDER_SET_ID
			pstmt_insert.setString(++count, "6");					//IV_PREP_YN
			pstmt_insert.setString(++count, "");					//ORDER_FIELDS_DISPLAY_TEXT
			pstmt_insert.setString(++count, "OS");				//ORDER_STATUS
			pstmt_insert.setString(++count, "");					//RESULT_STATUS
			pstmt_insert.setString(++count, login_by_id);		//ADDED_BY_ID
			pstmt_insert.setString(++count, login_at_ws_no);		//ADDED_AT_WS_NO
			pstmt_insert.setString(++count, login_facility_id);	//ADDED_FACILITY_ID
			pstmt_insert.setString(++count, login_by_id);		//MODIFIED_BY_ID
			pstmt_insert.setString(++count, login_at_ws_no);		//MODIFIED_AT_WS_NO
			pstmt_insert.setString(++count, login_facility_id);	//MODIFIED_FACILITY_ID
			pstmt_insert.setString(++count, ord_consent_reqd_yn);				//ORD_CONSENT_REQD_YN
			pstmt_insert.setString(++count, "");					//ORD_CONSENT_BY_ID
			pstmt_insert.setString(++count, null);				//ORD_CONSENT_BY_DATE_TIME
			pstmt_insert.setString(++count, "");					//CAN_REASON
			pstmt_insert.setString(++count, trn_group_ref);					//trn_group_ref
			int result			= pstmt_insert.executeUpdate();

	//OR_ORDER_LINE
			if(result > 0){
				pstmt_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2A"));

				for(int i=0; i<drugDetails.size(); i++ ) {
						count		=	0;
						record		=	(HashMap)drugDetails.get(i);				

					if( ((String)record.get("SHORT_DESC")).length() > 39) {
						short_desc	=	((String)record.get("SHORT_DESC")).substring(0,39);
					} 
					else {
						short_desc	=	((String)record.get("SHORT_DESC"));
					}
					
					pstmt_insert.setString(++count, order_id);								// ORDER_ID
					pstmt_insert.setString(++count, (i+1)+"");									// ORDER_LINE_NUM
					pstmt_insert.setString(++count, (String)record.get("DRUG_CODE"));			//ORDER_CATALOG_CODE
					pstmt_insert.setString(++count, short_desc);								//CATALOG_DESC
					pstmt_insert.setString(++count, short_desc);								//CATALOG_SYNONYM
					pstmt_insert.setString(++count, "");										//ORDER_CATALOG_NATURE
					pstmt_insert.setString(++count, (String)record.get("ORDER_TYPE_CODE"));	//ORDER_TYPE_CODE
					pstmt_insert.setString(++count, "PH");									//ORDER_CATEGORY
					pstmt_insert.setString(++count, order_date);								//ORD_DATE_TIME
					pstmt_insert.setString(++count, priority);							//PRIORITY
					pstmt_insert.setString(++count, "N");									//ORD_AUTH_REQD_YN
					pstmt_insert.setString(++count, "");										//ORD_AUTH_REASON
					pstmt_insert.setString(++count, "N");									//ORD_APPR_REQD_YN
					pstmt_insert.setString(++count, "N");									//ORD_COSIGN_REQD_YN
					pstmt_insert.setString(++count, (String)record.get("START_DATE"));		//START_DATE_TIME
					pstmt_insert.setString(++count, (String)record.get("FORM_CODE"));		//FORM_CODE
					pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));		//ROUTE_CODE
					pstmt_insert.setString(++count, (String)record.get("DOSAGE_VALUE"));		// QTY_VALUE

					pstmt_insert.setString(++count,(String)record.get("DOSAGE_UOM") );			//QTY_UNIT
					pstmt_insert.setString(++count, (String)record.get("FREQ_CODE"));		//FREQ_CODE
					pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));		//DURN_VALUE
					pstmt_insert.setString(++count, (String)record.get("DURN_TYPE"));		//DURN_TYPE
					pstmt_insert.setString(++count, "");										//LINE_FIELDS_DISPLAY_TEXT
					pstmt_insert.setString(++count, "");									//ITEM_NARRATION				
					pstmt_insert.setString(++count, null);								//NEXT_SCHED_DATE
					pstmt_insert.setString(++count, (String)record.get("END_DATE"));		//END_DATE
					pstmt_insert.setString(++count, null);								//AUTO_STOP_DATE_TIME
					pstmt_insert.setString(++count, (String)record.get("ABSOL_QTY"));						//ORDER_QTY
					pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));	//ORDER_UOM
					pstmt_insert.setString(++count, "N");								//APPT_REQD_YN
					pstmt_insert.setString(++count, null);								//APPT_DATE_TIME
					pstmt_insert.setString(++count, "");				//APPT_REF_NUM
					pstmt_insert.setString(++count, "N");			//RESULT_APPLICABLE_YN
					pstmt_insert.setString(++count, "N");			//BILL_YN
					pstmt_insert.setString(++count, "N");			//BILLED_YN
					pstmt_insert.setString(++count, "CO");			//CONT_ORDER_IND
					pstmt_insert.setString(++count, "N");			//REFILL_SINGLE_CONT_ORDER_YN
					pstmt_insert.setString(++count, "");				//NUM_OF_REFILLS
					pstmt_insert.setString(++count, "N");			//CHILD_ORDER_YN
					pstmt_insert.setString(++count, "");				//PARENT_ORDER_ID
					pstmt_insert.setString(++count, "");				//PARENT_ORDER_LINE_NUM
					pstmt_insert.setString(++count, "");				//ORDER_SET_ID
					pstmt_insert.setString(++count, "");				//ORDER_SET_LINE_NUM
					pstmt_insert.setString(++count, getPractitionerID());		//ORD_PRACT_ID
					pstmt_insert.setString(++count, null);			//ORD_SET_DATE_TIME
					pstmt_insert.setString(++count, "");				//AMD_PRACT_ID
					pstmt_insert.setString(++count, null);			//AMD_DATE_TIME
					pstmt_insert.setString(++count, "");				//HOLD_PRACT_ID
					pstmt_insert.setString(++count, null);			//HOLD_DATE_TIME
					pstmt_insert.setString(++count, "");				//RESUME_PRACT_ID
					pstmt_insert.setString(++count, null);			//RESUME_DATE_TIME
					pstmt_insert.setString(++count, "");				//DISC_PRACT_ID		
					pstmt_insert.setString(++count, null);			//DISC_DATE_TIME
					pstmt_insert.setString(++count, "");				//CAN_PRACT_ID
					pstmt_insert.setString(++count, null);			//CAN_DATE_TIME
					pstmt_insert.setString(++count, "");				//ACCESSION_NUM
					pstmt_insert.setString(++count, "");				//ACCESSION_LINE_NUM
					pstmt_insert.setString(++count, "OS");			//ORDER_LINE_STATUS
					pstmt_insert.setString(++count, "");				//RESULT_LINE_STATUS
					pstmt_insert.setString(++count, login_by_id);	//ADDED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no); //ADDED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id); //ADDED_FACILITY_ID
					pstmt_insert.setString(++count, login_by_id);		//MODIFIED_BY_ID
					pstmt_insert.setString(++count, login_at_ws_no);		//MODIFIED_AT_WS_NO
					pstmt_insert.setString(++count, login_facility_id);	//MODIFIED_FACILITY_ID
					pstmt_insert.setString(++count, (String)record.get("CONSENT_REQD_YN"));				//ORD_CONSENT_REQD_YN
					pstmt_insert.setString(++count, "");					//CAN_LINE_REASON
					pstmt_insert.setString(++count, short_desc);			//CATALOG_SYNONYM_DC
					pstmt_insert.setString(++count, short_desc);			//CATALOG_SYNONYM_AD
					pstmt_insert.setString(++count, "N");				//RESULT_AUTH_REQD_YN
					pstmt_insert.setString(++count,(String)record.get("CONSENT_STAGE")); //ORD_CONSENT_STAGE
					pstmt_insert.setString(++count,(String)record.get("CONSENT_STATUS")); //ORD_CONSENT_STATUS
					pstmt_insert.setString(++count,(String)record.get("NUM_OF_CONSENT_REQ_BO")); //NUM_OF_CONSENT_REQ_BO
					pstmt_insert.setString(++count,(String)record.get("NUM_OF_CONSENT_REQ_BR")); //NUM_OF_CONSENT_REQ_BR
					pstmt_insert.addBatch();
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt_select ) ;
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
				int[] batch_result = pstmt_insert.executeBatch();
				for (int i=0;i<batch_result.length;i++ ) {
					if (batch_result[i]<0  && batch_result[i] != -2) {
						result = 0;
						pstmt_insert.cancel();
						throw new Exception("OR ORDER Line Failed");
					}
					else{
							result = 1;
					}
				}
			}

		//	OR_ORDER_COMMENT Insert
			if(result > 0){		
				String action_seq_num		= "";
				String order_comment		=	getAmendOrderRemarks();

				if(resultSet != null) {closeResultSet( resultSet );}

				pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_select.setString(1, order_id);
				resultSet		= pstmt_select.executeQuery();

				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}
				if(resultSet != null) {closeResultSet( resultSet );}
				if(pstmt_insert	!= null) {  closeStatement( pstmt_insert );}

				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_id);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result = pstmt_insert.executeUpdate();
	
				if(result>0){
				
					pstmt_clob		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,action_seq_num);
					ResultSet rset_clob =pstmt_clob.executeQuery();
					if(rset_clob!=null){
						while(rset_clob.next()){
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							bw.write(order_comment,0,order_comment.length());
							bw.flush();
							bw.close();
						}
					}
					if(rset_clob!=null){ closeResultSet( rset_clob );}
					if(pstmt_clob	!= null) {  closeStatement( pstmt_clob );}
				}
			}

		// OR_ORDER_LINE_PH
		if(result > 0){
			if(pstmt_insert	!= null) {  closeStatement( pstmt_insert );}
			pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT3A"));

			float total_strength		= 0.0f;
			for(int i=0; i<drugDetails.size(); i++ ) {
					count		=	0;
					record		=	(HashMap)drugDetails.get(i);	

				if(!((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
					total_strength		= (Float.parseFloat((String)record.get("STRENGTH_VALUE"))*Float.parseFloat((String)record.get("DURN_VALUE")));
				}
			
				pstmt_insert.setString(++count, order_id);							//ORDER_ID
				pstmt_insert.setString(++count, (i+1)+"");							//ORDER_LINE_NUM
				pstmt_insert.setString(++count, (String)record.get("GENERIC_ID"));	//GENERIC_ID
				pstmt_insert.setString(++count, (String)record.get("FORM_CODE"));		//FORM_CODE
				pstmt_insert.setString(++count, ""); //TRADE_CODE
				if(record.get("IN_FORMULARY_YN")!=null && !((String)record.get("IN_FORMULARY_YN")).equals("")){
					pstmt_insert.setString(++count, (String)record.get("IN_FORMULARY_YN"));
				}else{
					pstmt_insert.setString(++count, "N");											//FORMULARY_ITEM_YN
				}
				pstmt_insert.setString(++count, (String)record.get("DOSAGE_TYPE"));				//DOSAGE_TYPE
				pstmt_insert.setString(++count, "");											//SPLIT_DRUG_PREVIEW
				pstmt_insert.setString(++count, new Float(total_strength).intValue()+"");		//TOT_STRENGTH
				pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));					//TOT_STRENGTH_UOM
				pstmt_insert.setString(++count, "");			//INFUSE_OVER
				pstmt_insert.setString(++count, "");			//INFUSE_OVER_UNIT
				pstmt_insert.setString(++count, "");			//INFUSION_RATE
				pstmt_insert.setString(++count, "");			//INFUSION_VOL_STR_UNIT
				pstmt_insert.setString(++count, "");			//INFUSION_PER_UNIT
				pstmt_insert.setString(++count, "N");			//BROUGHT_BY_PATIENT_YN
				pstmt_insert.setString(++count, "N");			//CUR_DRUG_YN
				pstmt_insert.setString(++count, "N");			//REFILL_DRUG_YN
				pstmt_insert.setString(++count, "");					//DISPENSING_LOC_TYPE
				pstmt_insert.setString(++count, "");					//DISPENSING_LOC
				pstmt_insert.setString(++count, "");					//DISPENSING_STORE
				pstmt_insert.setString(++count, "");					//IP_FILL_PROCESS
				pstmt_insert.setString(++count, "");					//IP_FILL_PRD_AHEAD
				pstmt_insert.setString(++count, null);				//NEXT_FILL_DATE
				pstmt_insert.setString(++count, "");					//LAST_FILL_QTY
				pstmt_insert.setString(++count, "");					//DISPENSED_QTY
				pstmt_insert.setString(++count, (String)record.get("ABSOL_QTY"));			//BMS_QTY
				pstmt_insert.setString(++count, new Float(total_strength).intValue()+"");		//BMS_STRENGTH	
				pstmt_insert.setString(++count, login_by_id);
				pstmt_insert.setString(++count, login_at_ws_no);
				pstmt_insert.setString(++count, login_facility_id);
				pstmt_insert.setString(++count, login_by_id);
				pstmt_insert.setString(++count, login_at_ws_no);
				pstmt_insert.setString(++count, login_facility_id);
				pstmt_insert.setString(++count, "N");								//SPLIT_DOSE_YN
				pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));	//QTY_VALUE_SPLIT_DOSE
				pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));		//QTY_UNIT_SPLIT_DOSE
				pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE"));	//STRENGTH_VALUE
				pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));		//STRENGTH_UOM
				pstmt_insert.setString(++count, (String)record.get("ABSOL_QTY"));	//PRES_QTY_VALUE
				pstmt_insert.setString(++count, (String)record.get("PRES_BASE_UOM"));	//PRES_QTY_UOM
				pstmt_insert.setString(++count, (String)record.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON
				pstmt_insert.setString(++count, (String)record.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
				pstmt_insert.setString(++count, (String)record.get("CURRENTRX_REMARKS")); //DUPLICATE_DRUG_OVERRIDE_REASON
				pstmt_insert.setString(++count, ""); //TOT_INFUSION_OVER
				pstmt_insert.setString(++count, ""); //TOT_INFUSION_OVER_UNIT
				pstmt_insert.setString(++count, "");  //ADMIN_RATE
				pstmt_insert.setString(++count, "");  //CHANGED FLUID REMARKS 	
				pstmt_insert.setString(++count, (String)record.get("BL_INCL_EXCL_OVERRIDE_VALUE"));  //BL_INCL_EXCL_OVERRIDE_VALUE	
				pstmt_insert.setString(++count, (String)record.get("BL_INCL_EXCL_OVERRIDE_REASON"));  //BL_INCL_EXCL_OVERRIDE_REASON 	
				pstmt_insert.setString(++count, getBuildMAR_yn());  //BuildMAR_yn
				String DreugIndicationRemarks=this.getDreugIndicationRemarks();
				pstmt_insert.setString(++count,DreugIndicationRemarks);  //BuildMAR_yn
				pstmt_insert.setString(++count,DreugIndicationRemarks);  //BuildMAR_yn

				pstmt_insert.addBatch();
			}
			int[] batch_result = pstmt_insert.executeBatch();
			for (int i=0;i<batch_result.length;i++ ) {
				if (batch_result[i]<0  && batch_result[i] != -2) {
						result = 0;	
						pstmt_insert.cancel();
						throw new Exception("OR ORDER Line PH Failed");
				}else{
						result = 1;
				}
			}
			if(pstmt_insert	!= null) {  
				closeStatement( pstmt_insert );
			}
		}
//OR_ORDER_LINE_FIELD_VALUES
		
		  if(result > 0){
	            boolean enter_loop = false;
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_insert.clearBatch();
				if(drugRemarks.size()>0) {
					int order_format_count	= 0;
					for (int i=0;i<drugRemarks.size();i++ ) {
						HashMap DrugValues = (HashMap)drugRemarks.get(i);

						String total_seq	= (String)DrugValues.get("order_format_count");
						order_format_count	= Integer.parseInt(total_seq);

						for(int k=0;k<order_format_count;k++) {
							enter_loop = true;
							pstmt_insert.setString(1, order_id);
							pstmt_insert.setString(2, "" + (i+1));
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, "" + (k+1));
							pstmt_insert.setString(5, (String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6, (String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7, (String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8, (String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9, "");
							pstmt_insert.setString(10, "");
							pstmt_insert.setString(11, (String)DrugValues.get("accept_option"+k));

							pstmt_insert.setString(12, login_by_id);
							pstmt_insert.setString(13, login_at_ws_no);
							pstmt_insert.setString(14, login_facility_id);
							pstmt_insert.setString(15, login_by_id);
							pstmt_insert.setString(16, login_at_ws_no);
							pstmt_insert.setString(17, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
					if(enter_loop) {
						int[] batch_result1 = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result1.length;i++ ) {
							if (batch_result1[i]<0  && batch_result1[i] != -2) {
								result=0;
								break;
							}
							else {
								result=1;
							}
						}
					} else {
						result=1;
					}
				} else {
					result=1;
				}
			if(pstmt_insert	!= null) {  
				closeStatement( pstmt_insert );
			}
		  }
//OR_ORDER_LINE_FIELD_VALUES
		if (result>0) {
				boolean freq_values_found	= false;
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
				ArrayList frequencyValues = new ArrayList();
                
				HashMap drugDetails1=new HashMap();
				drugDetails1 = (HashMap)drugDetails.get(0);
			      
				if (scheduleFreq.size()>0) {
					if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
					   	frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
			    	}

					if (frequencyValues.size()>0) {
						for(int n=0;n<frequencyValues.size();n++) {
							freq_values_found	= true;
							int seqNo			= 200;
							seqNo				= seqNo + n;

							HashMap data		= (HashMap)frequencyValues.get(n);
							String admin_time	= (String)data.get("admin_time");
							String admin_qty	= (String)data.get("admin_qty");
							String durn_desc	= (String)record.get("DOSAGE_UOM");
							pstmt_insert.setString(1, order_id);
							pstmt_insert.setString(2, "1");
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, seqNo + "");
							pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
							pstmt_insert.setString(6, "C");
							pstmt_insert.setString(7, "D");
							pstmt_insert.setString(8, admin_time);
							pstmt_insert.setString(9, admin_qty);
							pstmt_insert.setString(10, durn_desc);
							pstmt_insert.setString(11, "O");

							pstmt_insert.setString(12, login_by_id);
							pstmt_insert.setString(13, login_at_ws_no);
							pstmt_insert.setString(14, login_facility_id);
							pstmt_insert.setString(15, login_by_id);
							pstmt_insert.setString(16, login_at_ws_no);
							pstmt_insert.setString(17, login_facility_id);
							pstmt_insert.addBatch();
						}
					}

				if (freq_values_found) {
					int[] batch_result = pstmt_insert.executeBatch();
					for (int i=0;i<batch_result.length;i++ ) {
						if (batch_result[i]<0  && batch_result[i] != -2) {
							result=0;
							break;
						} else {
							result=1;
						}
					}
				} else {
					result=1;
				}
			if(pstmt_insert	!= null) {  closeStatement( pstmt_insert );}
			}

		// PH_PATIENT_DRUG_PROFILE 
		if(result > 0){

			pstmt_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4"));

			int srl_NO			= 0;
			String diag_text	= "";
			String perform_external_database_checks="";

			if(diagText.size()>0) {
				diag_text = (String)diagText.get(3)+"~"+(String)diagText.get(7)+"~"+(String)diagText.get(11);
			}
			
			
			pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55"));
			pstmt_select.setString(1, getPatId());						
			//pstmt_select.setString(2, login_facility_id);			
			resultSet		= pstmt_select.executeQuery();
			if(resultSet.next()) {
				srl_NO = resultSet.getInt("NEXT_SRL_NO");
			}
			if(resultSet != null) {closeResultSet( resultSet );}
			if(pstmt_select	!= null) {  closeStatement( pstmt_select );}

			for(int i=0; i<drugDetails.size(); i++ ) {
				record		=	(HashMap)drugDetails.get(i);		
				count		=	0;
				diag_text	= "";
				perform_external_database_checks	=(String)record.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
			
				if(i> 0) {
					++srl_NO;
				} 

				pstmt_insert.setString(++count, getPatId());				//PATIENT_ID
				pstmt_insert.setString(++count, srl_NO + "");				//SRL_NO
				pstmt_insert.setString(++count, login_facility_id);			//FACILITY_ID
				pstmt_insert.setString(++count, getEncId());				//ENCOUNTER_ID
				pstmt_insert.setString(++count, getPatientClass());				//PATIENT_CLASS
				pstmt_insert.setString(++count, getLocationType());					//LOCN_TYPE
				pstmt_insert.setString(++count, getLocationCode());					//LOCN_CODE
				pstmt_insert.setString(++count, "");						 // room_type
				pstmt_insert.setString(++count, "");						// room no
				pstmt_insert.setString(++count, "");						// bed no
				pstmt_insert.setString(++count, "");						// bed class
				pstmt_insert.setString(++count, "");						// bed type
				pstmt_insert.setString(++count, "");						// speciality code
				pstmt_insert.setString(++count, getPractitionerID());					// attend practioner
				pstmt_insert.setString(++count, getPractitionerID());					// pres practitioner
				pstmt_insert.setString(++count, (String)record.get("DRUG_CODE"));  //DRUG_CODE
				pstmt_insert.setString(++count, (String)record.get("GENERIC_ID"));  //GENERIC_ID
				pstmt_insert.setString(++count, (String)record.get("START_DATE"));		//START_DATE
				pstmt_insert.setString(++count, (String)record.get("END_DATE"));		//END_DATE
				pstmt_insert.setString(++count, "N");		//SPLIT_YN
				pstmt_insert.setString(++count, "N");		//TAPERED_YN
				if( !((String)record.get("STRENGTH_VALUE")).equals("") && !((String)record.get("STRENGTH_VALUE")).equals("0")) {
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_VALUE"));	//STRENGTH
					pstmt_insert.setString(++count, (String)record.get("STRENGTH_UOM"));		//STRENGTH_UOM_CODE
				} else {
					pstmt_insert.setString(++count, "");	//STRENGTH
					pstmt_insert.setString(++count, "");		//STRENGTH_UOM_CODE
				}
				pstmt_insert.setString(++count, (String)record.get("QTY_VALUE"));	//DOSAGE
				pstmt_insert.setString(++count, (String)record.get("QTY_UOM"));		//DOSAGE_UOM_CODE
				pstmt_insert.setString(++count, "");				//SPLIT_DOSE_PREVIEW
				pstmt_insert.setString(++count, (String)record.get("FREQ_CODE"));							//FREQ_CODE 
				pstmt_insert.setString(++count, (String)record.get("DURN_VALUE"));  //DURATION
				pstmt_insert.setString(++count, (String)record.get("ABSOL_QTY"));						//PRESCRIBED_QTY
				pstmt_insert.setString(++count, diag_text);  //DIAG_TEXT
				pstmt_insert.setString(++count, ""); // drug remarks				
				pstmt_insert.setString(++count, "6"); //IV_PREP_YN
				pstmt_insert.setString(++count, ""); //INFUSE_OVER
				pstmt_insert.setString(++count,"");
				pstmt_insert.setString(++count, ""); //INFUSION_RATE
				pstmt_insert.setString(++count, ""); //INFUSION_VOL_STR_UNIT
				pstmt_insert.setString(++count, "");  // infusion per unit			
				pstmt_insert.setString(++count, "N"); // amend_yn
				pstmt_insert.setString(++count, ""); // amend by id
				pstmt_insert.setString(++count, null); // amend_date
				pstmt_insert.setString(++count, "N");  // cancel yn
				pstmt_insert.setString(++count, "");  // cancel by id
				pstmt_insert.setString(++count, null); // cancel date
				pstmt_insert.setString(++count, "P"); //TRN_TYPE_IND 
				pstmt_insert.setString(++count, login_facility_id);
				pstmt_insert.setString(++count, order_id); // orig order id
				pstmt_insert.setString(++count, (i+1)+"");  // line no
				pstmt_insert.setString(++count, "");  // tot issued qty
				pstmt_insert.setString(++count, "N"); //BROUGHT_BY_PATIENT_YN
				pstmt_insert.setString(++count, null); //ON_HOLD_DATE_TIME
				pstmt_insert.setString(++count, ""); //ON_HOLD_BY_ID
				pstmt_insert.setString(++count, ""); //ON_HOLD_REASON_CODE 
				pstmt_insert.setString(++count, null); //DISCONT_DATE_TIME
				pstmt_insert.setString(++count, ""); //DISCONT_BY_ID 
				pstmt_insert.setString(++count, ""); //DISCONT_REASON_CODE
				pstmt_insert.setString(++count, "N"); //STOP_YN
				pstmt_insert.setString(++count, null); //STOP_DATE_TIME
				pstmt_insert.setString(++count, ""); //STOP_PRACTIONER_ID
				pstmt_insert.setString(++count, ""); //STOP_REMARKS
				pstmt_insert.setString(++count, login_by_id);
				pstmt_insert.setString(++count, login_at_ws_no);
				pstmt_insert.setString(++count, login_facility_id);
				pstmt_insert.setString(++count, login_by_id);
				pstmt_insert.setString(++count, login_at_ws_no);
				pstmt_insert.setString(++count, login_facility_id);
				pstmt_insert.setString(++count, (String)record.get("ROUTE_CODE"));  //ROUTE_CODE
				if(perform_external_database_checks.equals("N")){
					pstmt_insert.setString(++count, (String)record.get("ALLERGY_REMARKS")); //ALLERGY_OVERRIDE_REASON
					pstmt_insert.setString(++count, (String)record.get("DOSE_REMARKS")); //DOSAGE_LIMIT_OVERRIDE_REASON
				}else{
					if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(++count, (String)record.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
					}else{
							pstmt_insert.setString(++count, "");
					}
					
					if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(++count, (String)record.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
					}else{
							pstmt_insert.setString(++count, "");
					}

				}

				
				pstmt_insert.setString(++count, ""); //IV_INGREDIENTS
				pstmt_insert.setString(++count, (String)record.get("DURN_TYPE"));   //DURN_TYPE
				pstmt_insert.setString(++count, ""); //DISPENSED_DRUGS
				pstmt_insert.setString(++count, ""); //ALTERNATE_GENERIC_ID
				pstmt_insert.setString(++count, ""); //DISP_REMARKS 

				if(perform_external_database_checks.equals("N")){	
					pstmt_insert.setString(++count, (String)record.get("CURRENTRX_REMARKS")); //CURRENTRX_REMARKS 
				}else{
					if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(++count, (String)record.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
					}else{
							pstmt_insert.setString(++count, "");
					}
				}
				pstmt_insert.setString(++count, "N"); //REFILL_YN 
				pstmt_insert.setString(++count, (String)record.get("FORM_CODE")); //FORM_CODE
//DIAG_CODES
				if(diagText.size()>0) {
					pstmt_insert.setString(++count, (String)diagText.get(0));
					pstmt_insert.setString(++count, (String)diagText.get(1));
					pstmt_insert.setString(++count, (String)diagText.get(2));
					pstmt_insert.setString(++count, (String)diagText.get(4));
					pstmt_insert.setString(++count, (String)diagText.get(5));
					pstmt_insert.setString(++count, (String)diagText.get(6));
					pstmt_insert.setString(++count, (String)diagText.get(8));
					pstmt_insert.setString(++count, (String)diagText.get(9));
					pstmt_insert.setString(++count, (String)diagText.get(10));
				} else {
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
					pstmt_insert.setString(++count, "");
				}

				pstmt_insert.setString(++count, (String)record.get("DOSAGE_TYPE")); //PRESCRIBED_MODE
				pstmt_insert.setString(++count, height);
				pstmt_insert.setString(++count, height_uom);
				pstmt_insert.setString(++count, weight);
				pstmt_insert.setString(++count, weight_uom);
				pstmt_insert.setString(++count, bsa);
				pstmt_insert.setString(++count, allergic_yn);
				pstmt_insert.setString(++count, bmi);
				if(perform_external_database_checks.equals("N")){	
					pstmt_insert.setString(++count, ""); //EXTERNAL_INTERACTION_OVERRIDE_REASON 
				}else{
					if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(++count, (String)record.get("EXTERNAL_INTERACTION_OVERRIDE_REASON"));
					}else{
							pstmt_insert.setString(++count, "");
					}
				}
				if(perform_external_database_checks.equals("N")){	
					pstmt_insert.setString(++count, ""); //EXTERNAL_INTERACTION_OVERRIDE_REASON 
				}else{
					if(((String)record.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN")).equals("Y")){
							pstmt_insert.setString(++count, (String)record.get("EXTERNAL_CONTRA_OVERRIDE_REASON"));
					}else{
							pstmt_insert.setString(++count, "");
					}
				}
				pstmt_insert.setString(++count, (String)record.get("DRUG_DB_PRODUCT_ID"));


				pstmt_insert.addBatch();
			}
			int[] batch_result2 = pstmt_insert.executeBatch();
			for (int i=0;i<batch_result2.length; i++ ) {
				
				if (batch_result2[i]<0  && batch_result2[i] != -2) {
						result = 0;
						pstmt_insert.cancel();
						throw new Exception("Patient Drug Profile Failed");
				}else{
						result = 1;
				}
			}
		if(pstmt_insert	!= null) {  closeStatement( pstmt_insert );}
		}

// WORK LOAD STATUS
// ================
	
	if(result > 0){			
		String dly_count						 = "";
		String monthly_count					 = "";
		String dly_count_loc					 = "";
		String monthly_count_loc				 = "";

		int totalOrder	=	1;
			//orderDetails.size() + drugList.size();
		int totalDrugs	  =	1;
			totalDrugs	+= getDrugDetails().size();
		
		String patient_Class	= getPatientClass();
		String locationType		= getLocationType();
		String locationCode		= getLocationCode();
				
		pstmt_workload		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT72")) ;
		pstmt_workload.setString(1,getPractitionerID());
		pstmt_workload.setString(2,login_facility_id);
		pstmt_workload.setString(3,patient_Class);

		resultSet_workload  	= pstmt_workload.executeQuery() ;

		while (resultSet_workload.next()){
				dly_count		= (resultSet_workload.getString("DLYCOUNT")).trim();				
			}
		
		if(resultSet_workload != null) {closeResultSet( resultSet_workload );}
		if(pstmt_workload	!= null) {  closeStatement( pstmt_workload );}

		pstmt_workload		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT73")) ;
		pstmt_workload.setString(1,getPractitionerID());
		pstmt_workload.setString(2,login_facility_id);
		pstmt_workload.setString(3,patient_Class);

		resultSet_workload  	= pstmt_workload.executeQuery() ;
		while (resultSet_workload.next()){
			monthly_count			=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
		}
		if(resultSet_workload != null) {closeResultSet( resultSet_workload );}
		if(pstmt_workload	!= null) {  closeStatement( pstmt_workload );}

	
	if(dly_count.equals("0")){
			workload_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT9")) ;
			workload_insert.setString( 1, getPractitionerID());
			workload_insert.setString( 2, login_facility_id);
			workload_insert.setString( 3, patient_Class);
			workload_insert.setString( 4,String.valueOf(totalOrder));
			workload_insert.setString( 5,String.valueOf(totalDrugs));
			workload_insert.setString( 6, login_by_id);
			workload_insert.setString( 7, login_at_ws_no);
			workload_insert.setString( 8, login_facility_id);
			workload_insert.setString( 9, login_by_id);
			workload_insert.setString( 10, login_at_ws_no);
			workload_insert.setString( 11, login_facility_id);
			workload_insert.executeUpdate();
	} else {
			workload_insert		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY6")) ;
			workload_insert.setString( 1,String.valueOf(totalOrder));
			workload_insert.setString( 2,String.valueOf(totalDrugs));
			workload_insert.setString( 3, login_by_id);
			workload_insert.setString( 4, login_at_ws_no);
			workload_insert.setString( 5, login_facility_id);
			workload_insert.setString( 6, getPractitionerID());
			workload_insert.setString( 7, login_facility_id);
			workload_insert.setString( 8, patient_Class);
			workload_insert.executeUpdate();

	}
	
	
	if(monthly_count.equals("0")) {
			work_insert_month		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT10")) ;
			work_insert_month.setString( 1, getPractitionerID());
			work_insert_month.setString( 2, login_facility_id);
			work_insert_month.setString( 3, patient_Class);
			work_insert_month.setString( 4,String.valueOf(totalOrder));
			work_insert_month.setString( 5,String.valueOf(totalDrugs));
			work_insert_month.setString( 6, login_by_id);
			work_insert_month.setString( 7, login_at_ws_no);
			work_insert_month.setString( 8, login_facility_id);
			work_insert_month.setString( 9, login_by_id);
			work_insert_month.setString( 10, login_at_ws_no);
			work_insert_month.setString( 11, login_facility_id);
			work_insert_month.executeUpdate();
	} else {
			work_insert_month		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY7")) ;
			work_insert_month.setString( 1,String.valueOf(totalOrder));
			work_insert_month.setString( 2,String.valueOf(totalDrugs));
			work_insert_month.setString( 3, login_by_id);
			work_insert_month.setString( 4, login_at_ws_no);
			work_insert_month.setString( 5, login_facility_id);
			work_insert_month.setString( 6, getPractitionerID());
			work_insert_month.setString( 7, login_facility_id);
			work_insert_month.setString( 8, patient_Class);
			work_insert_month.executeUpdate();
	}

		pstmt_workload			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT74")) ;
	
		pstmt_workload.setString(1,locationType);
		pstmt_workload.setString(2,login_facility_id);
		pstmt_workload.setString(3,locationCode);
		resultSet_workload  	= pstmt_workload.executeQuery() ;

		while (resultSet_workload.next()){
				dly_count_loc	= (resultSet_workload.getString("DLYCOUNT")).trim();				
		}
		
		if(resultSet_workload != null) {closeResultSet( resultSet_workload );}
		if(pstmt_workload	!= null) {  closeStatement( pstmt_workload );}


		pstmt_workload			= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT75")) ;
		pstmt_workload.setString(1,locationType);
		pstmt_workload.setString(2,login_facility_id);
		pstmt_workload.setString(3,locationCode);

		resultSet_workload  	= pstmt_workload.executeQuery() ;
		while (resultSet_workload.next()){
				monthly_count_loc		=	(resultSet_workload.getString("MTHLYCOUNT")).trim();				
		}
		if(resultSet_workload != null) {closeResultSet( resultSet_workload );}
		if(pstmt_workload	!= null) {  closeStatement( pstmt_workload );}

	
		if(dly_count_loc.equals("0")) {
			work_insert_loc = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT11")) ;
			work_insert_loc.setString(1,login_facility_id);
			work_insert_loc.setString(2, locationType);
			work_insert_loc.setString(3, locationCode);
			work_insert_loc.setString(4,String.valueOf(totalOrder));
			work_insert_loc.setString(5,String.valueOf(totalDrugs));
			work_insert_loc.setString(6, login_by_id);
			work_insert_loc.setString(7, login_at_ws_no);
			work_insert_loc.setString(8, login_facility_id);
			work_insert_loc.setString(9, login_by_id);
			work_insert_loc.setString(10, login_at_ws_no);
			work_insert_loc.setString(11, login_facility_id);
			work_insert_loc.executeUpdate();
    	} else {
			work_insert_loc = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8")) ;
			work_insert_loc.setString(1,String.valueOf(totalOrder));
			work_insert_loc.setString(2,String.valueOf(totalDrugs));
			work_insert_loc.setString(3, login_by_id);
			work_insert_loc.setString(4, login_at_ws_no);
			work_insert_loc.setString(5, login_facility_id);
			work_insert_loc.setString(6, locationType);
			work_insert_loc.setString(7, login_facility_id);
			work_insert_loc.setString(8, locationCode);
			work_insert_loc.executeUpdate();
		}

		if(monthly_count_loc.equals("0")) {
			work_insert_loc_mon =  connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT12")) ;
			work_insert_loc_mon.setString(1,login_facility_id);
			work_insert_loc_mon.setString(2, locationType);
			work_insert_loc_mon.setString(3, locationCode);
			work_insert_loc_mon.setString(4,String.valueOf(totalOrder));
			work_insert_loc_mon.setString(5,String.valueOf(totalDrugs));
			work_insert_loc_mon.setString(6, login_by_id);
			work_insert_loc_mon.setString(7, login_at_ws_no);
			work_insert_loc_mon.setString(8, login_facility_id);
			work_insert_loc_mon.setString(9, login_by_id);
			work_insert_loc_mon.setString(10, login_at_ws_no);
			work_insert_loc_mon.setString(11, login_facility_id);
			work_insert_loc_mon.executeUpdate();
		} else {
			work_insert_loc_mon =  connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY9")) ;
			work_insert_loc_mon.setString(1,String.valueOf(totalOrder));
			work_insert_loc_mon.setString(2,String.valueOf(totalDrugs));
			work_insert_loc_mon.setString(3, login_by_id);
			work_insert_loc_mon.setString(4, login_at_ws_no);
			work_insert_loc_mon.setString(5, login_facility_id);
			work_insert_loc_mon.setString(6, locationType);
			work_insert_loc_mon.setString(7, login_facility_id);
			work_insert_loc_mon.setString(8, locationCode);
			work_insert_loc_mon.executeUpdate();
			
		}
	}
		result = 1;
		String auto_order_regn_err = "";
		String tokens_generated_yn = "";
		if (result>0) {
			if((getPatientClass().equals("OP") || getPatientClass().equals("EM")) && !trn_group_ref.equals("")){
				cstmt_insert=connection.prepareCall("{call ph_auto_order_regn(?,?,?,?,?,?)}");

				cstmt_insert.setString( 1, trn_group_ref);
				cstmt_insert.setString( 2, getPatId());
				cstmt_insert.setString( 3, login_facility_id);
				cstmt_insert.setString( 4, getEncId());
				cstmt_insert.registerOutParameter(5, Types.VARCHAR );
				cstmt_insert.registerOutParameter(6, Types.VARCHAR );
				cstmt_insert.execute() ;

				tokens_generated_yn = cstmt_insert.getString(5)==null ? "":cstmt_insert.getString(5);
				auto_order_regn_err = cstmt_insert.getString(6)==null ? "":cstmt_insert.getString(6);
				try{
					closeResultSet( resultSet ) ;
					closeStatement( cstmt_insert ) ;
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
		}
			//System.out.println("result2"+result);
			if (auto_order_regn_err.equals("")) {
				map.put("result", new Boolean(true));
				map.put("msgid", getMessage(getLanguageId(),"RECORD_INSERTED","PH"));
				setTrnGroupRef(trn_group_ref);
				setTokensGeneratedYN(tokens_generated_yn);
				connection.commit();
			}
			else {
				map.put("msgid", auto_order_regn_err);
				connection.rollback();
				//System.err.println("Exception in Work Load functions...");
			}
			
		}
		if(stock_result.equals("")) {
				map.put("result", new Boolean(true));
				map.put("message", getMessage(getLanguageId(),"RECORD_INSERTED","PH"));

				connection.commit();
			} else {
				map.put("result", new Boolean(false));
				map.put("message", getMessage(getLanguageId(),"INSUFFICIENT_STOCK","PH"));
				map.put("flag","INSUFFICIENT_STOCK");
			}
		}
		}catch(Exception e) {
			try {
				connection.rollback();
				throw new Exception(this + " : " + e.getMessage());
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
			map.put("msgid", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert	);
				closeStatement(cstmt_insert);
				closeStatement(pstmt_select);
				closeStatement(pstmt_workload);
				closeStatement(workload_insert);		 
				closeStatement(work_insert_month);		 
				closeStatement(work_insert_loc)	;	 
				closeStatement(work_insert_loc_mon);	 
				closeResultSet(resultSet_workload );
				closeConnection(connection) ;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return map;
	}

	public String validateCompStock(String patient_class, String perf_locn_code,ArrayList drugDetail) {
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet				= null;

		HashMap stock_dtls		= new HashMap();
		HashMap record			= null;
			drug_stock_dtls		= new ArrayList();
		String message			= "";
		String avl_qty			= "0";
		int order_qty			= 0;

		try {
			connection = getConnection() ;

		// Quantity is validated against parameter facility flags
			ArrayList stock_params	=	validateForStock(patient_class);
		
			if(stock_params.size()!=0 && ((String)stock_params.get(0)).equals("Y") && ((String)stock_params.get(1)).equals("N")){

				for(int i=0; i<drugDetail.size(); i++ ) {
				
					record		=	(HashMap)drugDetail.get(i);	
					order_qty	=	Integer.parseInt((String)record.get("ABSOL_QTY"));
					stock_dtls	=	chkStockAvail((String)record.get("DRUG_CODE"),perf_locn_code,order_qty+"",(String)record.get("END_DATE"));

					if(stock_dtls.size()!=0) {
						avl_qty	=	(String)stock_dtls.get("AVAILABLE_STOCK");
					}
					if( order_qty > Float.parseFloat(avl_qty)){
						message	=	"INSUFFICIENT_STOCK";
						drug_stock_dtls.add(((String)record.get("SHORT_DESC")));
						drug_stock_dtls.add("D");
						drug_stock_dtls.add(avl_qty);
						drug_stock_dtls.add(order_qty+"");
						drug_stock_dtls.add(getStockUOM((String)record.get("DRUG_CODE")));				
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet );
				closeStatement(pstmt_select);
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return message;
	}

// load frequency values of compound prescription
	 public ArrayList loadFrequency(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList freq_vals		= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_SELECT1") );
			pstmt.setString(1, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
					freq_vals.add(checkForNull(resultSet.getString("FREQ_CODE")));
					freq_vals.add(checkForNull(resultSet.getString("FREQ_DESC")));
			}
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return freq_vals;
	}

	public boolean checkSplit(ArrayList frequencyValues) {
	
		boolean found		=	false;
		boolean firstTime	=	true;
		String tmp			=	"";
		String admin_qty	=	null;
		HashMap data		=	null;

		if(frequencyValues!=null && frequencyValues.size()>0){				
			for(int n=0;n<frequencyValues.size();n++){
				data	=(HashMap)frequencyValues.get(n);
				admin_qty	= ((String)data.get("admin_qty")).trim();

				if(firstTime) {
					tmp			=	admin_qty;
					firstTime	=	false;
				} else if(!tmp.equals(admin_qty)) {
					found		=	true;
				}
			}
		}
		return found;
	}


	public String comp_date_time(String end_date,String order_id,String order_line_num){

		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String start_date			= "";
		String sys_date1			= "";
		int count=0;

		try{
			connection		= getConnection() ;
			String str_qry	= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT25");
			String str_qry1	= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT26");

			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,end_date.trim());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count=resultSet.getInt(1);
			}

			if(resultSet !=	null) {closeResultSet( resultSet );}
			if(pstmt	 !=	null) {closeStatement( pstmt ) ;}

			pstmt					= connection.prepareStatement(str_qry1) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				end_date	=	resultSet.getString("end_date");
				sys_date1=	resultSet.getString("curr_date");	
			}

			 if(count >=1){
					start_date = sys_date1;
			 }else {
				 start_date = end_date;
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
		return start_date;
	}

//getting HomeMecdicationYn
	public int getHomeMecdicationYn(String encounter_id,String facility_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		int rec_count=0;
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT11");
			pstmt				= null;
			resultSet			= null;
			pstmt				= connection.prepareStatement(sql_query) ;
			double enc_id=Double.parseDouble(encounter_id);
			pstmt.setDouble(1,enc_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				rec_count=resultSet.getInt(1);
			}
		}catch ( Exception e ) {
                e.printStackTrace() ;
		} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
         }

		return rec_count;
	}

	public ArrayList getFreqDet(String order_id,String order_line_no){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList freq_det			=	new ArrayList();
		String	field_value			=	"";
		String	qty_value			=	"";
		String	qty_unit			=	"";

		try{
		connection			= getConnection() ;
		sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT61");

		pstmt				= connection.prepareStatement(sql_query) ;
		pstmt.setString(1,order_id);
		pstmt.setString(2,order_line_no);

		resultSet			= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next())	{
			field_value		=	resultSet.getString("ORDER_LINE_FIELD_VALUE")==null?"":resultSet.getString("ORDER_LINE_FIELD_VALUE");
			qty_value		=	resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE")==null?"":resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE");
			qty_unit		=	resultSet.getString("ORDER_LINE_DOSE_QTY_UNIT")==null?"":resultSet.getString("ORDER_LINE_DOSE_QTY_UNIT");

			freq_det.add(field_value);
			freq_det.add(qty_value);
			freq_det.add(qty_unit);
		}

		}catch ( Exception e ) {
                e.printStackTrace() ;
         } finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){}
              }


		return freq_det;
	}

	/*=====12/29/2004==================================================*/
	public HashMap ChkAdMixture(){
		Connection connection		= null ;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String iv_admixture_appl_yn	= "";
		HashMap result				= new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt.setString(1,getLoginFacilityId());
			
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()) {
                 iv_admixture_appl_yn =resultSet.getString("IV_ADMIXTURE_APPL_YN");
			     result.put("IV_ADMIXTURE_APPL_YN",iv_admixture_appl_yn);
				 result.put("ALERT_PRACTITIONER_YN",resultSet.getString("ALERT_PRACTITIONER_YN"));
			}
		
            if(iv_admixture_appl_yn.equals("Y")) {
			  pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT92") );
			  pstmt.setString(1,getLoginFacilityId());
			  resultSet = pstmt.executeQuery() ;
			
			  if (resultSet != null && resultSet.next()){
				result.put("time_flag",resultSet.getString(1));
			  }
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}

	public HashMap getDrugDtls(String drug_code) {
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		HashMap drug_dtls	        = new HashMap();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT6C"));
			pstmt.setString(1, drug_code);
			resultSet	= pstmt.executeQuery();

			if (resultSet.next()) {
				drug_dtls.put("ORDER_TYPE_CODE",resultSet.getString("ORDER_TYPE_CODE"));
				drug_dtls.put("ROUTE_CODE",resultSet.getString("ROUTE_CODE"));
				drug_dtls.put("FORM_CODE",resultSet.getString("FORM_CODE"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return drug_dtls;
	}

	public ArrayList getCompDrugDtls(String order_id){
	    Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		HashMap drug_dtls	        = null;
		ArrayList comp_drugs        = new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_SELECT2"));

			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, order_id);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
                drug_dtls=new HashMap();
				drug_dtls.put("ORDER_CATALOG_CODE",resultSet.getString("ORDER_CATALOG_CODE"));
				drug_dtls.put("DRUG_DESC",resultSet.getString("CATALOG_DESC"));
				drug_dtls.put("FREQ_CODE",resultSet.getString("FREQ_CODE"));
				drug_dtls.put("QTY_VALUE",resultSet.getString("QTY_VALUE"));
				drug_dtls.put("QTY_UNIT",resultSet.getString("QTY_UNIT"));
				drug_dtls.put("DURN_VALUE",resultSet.getString("DURN_VALUE"));
				drug_dtls.put("ORDER_QTY",resultSet.getString("ORDER_QTY"));
				drug_dtls.put("ORDER_UOM",resultSet.getString("ORDER_UOM"));
				drug_dtls.put("ORDER_LINE_NUM",resultSet.getString("ORDER_LINE_NUM"));
				
				if(!getLanguageId().equals("en")){
					drug_dtls.put("START_DATE_TIME",com.ehis.util.DateUtils.convertDate(resultSet.getString("START_DATE_TIME"),"DMYHM","en",getLanguageId()));
					drug_dtls.put("END_DATE_TIME",com.ehis.util.DateUtils.convertDate(resultSet.getString("END_DATE_TIME"),"DMYHM","en",getLanguageId()));
				}
				else{	   
					drug_dtls.put("START_DATE_TIME",resultSet.getString("START_DATE_TIME"));
					drug_dtls.put("END_DATE_TIME",resultSet.getString("END_DATE_TIME"));
				}
				
				drug_dtls.put("FORM_DESC",resultSet.getString("FORM_DESC"));
				drug_dtls.put("STRENGTH_VALUE",resultSet.getString("STRENGTH_VALUE"));
				drug_dtls.put("STRENGTH_UOM",resultSet.getString("STRENGTH_UOM"));
				drug_dtls.put("REPEAT_VALUE",resultSet.getString("REPEAT_VALUE"));
				drug_dtls.put("EXTERNAL_PRODUCT_ID",checkForNull(resultSet.getString("EXTERNAL_PRODUCT_ID")));
				drug_dtls.put("ALLERGY_OVERRIDE_REASON",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));
				drug_dtls.put("DOSAGE_LIMIT_OVERRIDE_REASON",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
				drug_dtls.put("DUPLICATE_DRUG_OVERRIDE_REASON",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
				drug_dtls.put("INTERACTION_OVERRIDE_REASON",checkForNull(resultSet.getString("INTERACTION_OVERRIDE_REASON")));
				drug_dtls.put("CONTRAIND_OVERRIDE_REASON",checkForNull(resultSet.getString("CONTRAIND_OVERRIDE_REASON")));
				drug_dtls.put("BUILDMAR_YN",checkForNull(resultSet.getString("BUILD_MAR_YN")));
				drug_dtls.put("DRUG_INDICATION",checkForNull(resultSet.getString("DRUG_INDICATION")));

				comp_drugs.add(drug_dtls);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}

		return comp_drugs;
	}

	public HashMap getDrugReasons(String order_id,String order_line_num,String ext_prod_id) {
	   	Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet resultSet			= null;
		HashMap Drugdtls            = new HashMap(); 
		String  extDbInteface		= getExternalDrugDataBaseInterface_yn();
		if (ext_prod_id ==  null)
			ext_prod_id = "";
		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT5E"));
			pstmt.setString(1, order_id);
			pstmt.setString(2, order_line_num);
			resultSet	= pstmt.executeQuery();

			while(resultSet.next()) {
				if(extDbInteface.equals("Y") && !(ext_prod_id.equals(""))){
					Drugdtls.put("ALLERGY_OVERRIDE_REASON",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					Drugdtls.put("DOSAGE_LIMIT_OVERRIDE_REASON",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					Drugdtls.put("DUPLICATE_DRUG_OVERRIDE_REASON",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
					Drugdtls.put("INTERACTION_OVERRIDE_REASON",resultSet.getString("INTERACTION_OVERRIDE_REASON"));
					Drugdtls.put("CONTRAIND_OVERRIDE_REASON",resultSet.getString("CONTRAIND_OVERRIDE_REASON"));
				}
				else{
					Drugdtls.put("ALLERGY_OVERRIDE_REASON",resultSet.getString("ALLERGY_OVERRIDE_REASON"));
					Drugdtls.put("DOSAGE_LIMIT_OVERRIDE_REASON",resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
					Drugdtls.put("DUPLICATE_DRUG_OVERRIDE_REASON",resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return Drugdtls;
	}

// for ammendnig  remarks 

	public ArrayList getPrescribedRemarks(String orig_order_id,String orig_order_line_no) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ONCOLOGY_REGIMEN_AMEND_SELECT7") ) ;		

			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3, getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() )			{
				if((resultSet.getString("ORDER_LINE_FIELD_MNEMONIC")).equals("PRES_REMARKS")) {
					if(resultSet.getString("REMARK_DESC")!=null) {
						records.add(resultSet.getString("REMARK_DESC"));
					}
				} 
				else {
					if(resultSet.getString("ORDER_LINE_FIELD_VALUE")!=null) {
						records.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));
					}
				}
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}		
		return records;			
	}

	public HashMap releaseAmendCompoundRx(HashMap record){	

	    String order_id	 = (String)record.get("ORDER_ID");
		int noOfDrugs = Integer.parseInt((String)record.get("NO_OF_DRUGS"));

		HashMap map = new HashMap();
		map.put("result", new Boolean(false));
		map.put("flag", "");
		map.put("msgid", "");
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		PreparedStatement pstmt_select1	= null;
		PreparedStatement pstmt_select2	= null;
		PreparedStatement pstmt_select3	= null;

		PreparedStatement pstmt_insert	= null,pstmt_update_order_line_ph=null,pstmt_update_patient_drug_profile=null;
		PreparedStatement pstmt_update=null,pstmt_update_non_scheduled_drug	= null,pstmt_delete=null,pstmt_clob=null;
		CallableStatement cstmt_insert	= null;     
		ResultSet resultSet				= null;
		ArrayList drugDetails			= getDrugDetails();
		ArrayList drugRemarks			= getDrugRemarks();
		HashMap scheduleFreq			= getscheduleFrequency();

		try{
 //	OR_ORDER
			connection	= getConnection() ;
			pstmt_insert	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_AMEND_IVPRES__UPDATE1"));
			pstmt_insert.setString(1, "6");
			pstmt_insert.setString(2, "");
			pstmt_insert.setString(3, login_by_id);
			pstmt_insert.setString(4, login_at_ws_no);
			pstmt_insert.setString(5, login_facility_id);
			pstmt_insert.setString(6, order_id);
			int result=0;
			try{
			    result			= pstmt_insert.executeUpdate();
			}
			catch(Exception e){
				result=0;
				connection.rollback();
				e.printStackTrace();
			}

			if(pstmt_insert != null){ closeStatement(pstmt_insert); }

// OR_ORDER_LINE
		if (result>0){ 
				
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_AMEND1"));
				pstmt_insert.clearBatch();
				for(int j=1;j<=noOfDrugs;j++){

					pstmt_insert.setString(1, (String)record.get("DOSAGE"));        // QTY_VALUE
					pstmt_insert.setString(2, (String)record.get("FREQ_CODE"));  	// FREQ_CODE
					pstmt_insert.setString(3, (String)record.get("DURN_VALUE"));	// DURN_VALUE
					pstmt_insert.setString(4, (String)record.get("ORD_QTY"+j));	    // ORDER_QTY
					pstmt_insert.setString(5, (String)record.get("START_DATE"));	// START_DATE_TIME
					pstmt_insert.setString(6, (String)record.get("END_DATE"));		// END_DATE_TIME
					pstmt_insert.setString(7,  getPractitionerID());			    // AMD_PRACT_ID
					pstmt_insert.setString(8,  login_by_id);		                //MODIFIED_BY_ID
					pstmt_insert.setString(9,  login_at_ws_no);						//MODIFIED_AT_WS_NO
					pstmt_insert.setString(10, login_facility_id);					//MODIFIED_FACILITY_ID
					pstmt_insert.setString(11, (String)record.get("ORDER_ID"));	    // ORDER_ID
					pstmt_insert.setString(12, (j)+"");	    // ORDER_ID

					pstmt_insert.addBatch();
				}
				
			try{
				int[] batch_result = pstmt_insert.executeBatch();

				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						result = 0;
						connection.rollback();
						break;
					} else {
						result = 1;
					}
				}
				}catch(Exception e){
						result = 0;
					   e.printStackTrace();
				 }
			if(pstmt_insert != null){ closeStatement(pstmt_insert); }
		}

//OR_ORDER_LINE_PH
	   if (result>0) {
		   	
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_AMEND2"));
				pstmt_insert.clearBatch();
				for(int j=1;j<=noOfDrugs;j++){
                  
						pstmt_insert.setString(1, (String)record.get("ORD_QTY"+j)); //PRES_QTY_VALUE
						pstmt_insert.setString(2, login_by_id);
					    pstmt_insert.setString(3, login_at_ws_no);
					    pstmt_insert.setString(4, login_facility_id);
						pstmt_insert.setString(5, order_id);
						pstmt_insert.setString(6, (j)+"");
						pstmt_insert.addBatch();
					
				}
				try{
				int[] batch_result = pstmt_insert.executeBatch();

				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						result = 0;
						connection.rollback();
						break;
					}
					else {
						result = 1;
					}
				}
				}catch(Exception e){
			        e.printStackTrace();
			   }
			if(pstmt_insert != null){ closeStatement(pstmt_insert); }
	   }
	 
 
	//PH_PATIENT_DRUG_PROFILE

	if(result>0){
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_COMP_PRESCRIPTION_AMEND3"));

				//pstmt_insert =connection.prepareStatement("UPDATE PH_PATIENT_DRUG_PROFILE SET PRESCRIBED_QTY=?,FREQ_CODE=?,DURATION=?,DURN_TYPE=?,START_DATE=to_date(?, 'dd/mm/yyyy hh24:mi'),END_DATE=to_date(?, 'dd/mm/yyyy hh24:mi'),MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,DOSAGE_LIMIT_OVERRIDE_REASON=? WHERE ORIG_ORDER_ID=? AND ORIG_ORDER_LINE_NO=?");




				pstmt_insert.clearBatch();
				for(int j=1;j<=noOfDrugs;j++){
					pstmt_insert.setString(1, (String)record.get("ORD_QTY"+j)); //PRES_QTY_VALUE
					pstmt_insert.setString(2, (String)record.get("FREQ_CODE")); //FREQ_CODE
					pstmt_insert.setString(3, (String)record.get("DURN_VALUE"));//DURATION 
					pstmt_insert.setString(4, (String)record.get("DURN_TYPE"));//DURATION 
					pstmt_insert.setString(5, (String)record.get("START_DATE"));//START_DATE
					pstmt_insert.setString(6, (String)record.get("END_DATE"));//END_DATE
					pstmt_insert.setString(7, login_by_id);//MODIFIED_BY_ID
					pstmt_insert.setString(8, login_at_ws_no);//MODIFIED_AT_WS_NO
					pstmt_insert.setString(9, login_facility_id);//MODIFIED_FACILITY_ID
//dosage_limit_override_reason	=	(String)drug_dtls.get("DOSAGE_LIMIT_OVERRIDE_REASON");
					pstmt_insert.setString(10, (String)record.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"+j));
					pstmt_insert.setString(11, (String)record.get("ORDER_ID"));//ORG_ORDER_ID
					pstmt_insert.setString(12,(j)+""); 	

					pstmt_insert.addBatch();
					
				}
				try{
				int[] batch_result = pstmt_insert.executeBatch();

				for (int i=0;i<batch_result.length;i++) {
					if(batch_result[i] < 0  && batch_result[i] != -2 ) {
						result = 0;
						connection.rollback();
						break;
					} else {
						result = 1;
					}
				}
				}catch(Exception e){
						result = 0;
					   e.printStackTrace();
				}
			if(pstmt_insert != null){ closeStatement(pstmt_insert); }	
			}

 //OR_ORDER_COMMENT
if (result>0) {
	 			String action_seq_num		= "";

				pstmt_select	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56"));
				pstmt_select.setString(1, order_id);
				resultSet		= pstmt_select.executeQuery();

				if(resultSet.next()) {
					action_seq_num = resultSet.getString(1);
				}

				if(resultSet	!= null){ closeResultSet( resultSet ); }
				if(pstmt_select != null){ closeStatement(pstmt_select); }

				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5"));
				pstmt_insert.setString(1, order_id);
				pstmt_insert.setString(2, action_seq_num);
				pstmt_insert.setString(3, login_by_id);
				pstmt_insert.setString(4, login_at_ws_no);
				pstmt_insert.setString(5, login_facility_id);
				pstmt_insert.setString(6, login_by_id);
				pstmt_insert.setString(7, login_at_ws_no);
				pstmt_insert.setString(8, login_facility_id);
				result = pstmt_insert.executeUpdate();
				if(pstmt_insert != null){ closeStatement(pstmt_insert); }

				if(result>0){
				
					pstmt_clob		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57"));
					pstmt_clob.setString(1,order_id);
					pstmt_clob.setString(2,action_seq_num);

					ResultSet rset_clob =pstmt_clob.executeQuery();
					if(rset_clob!=null){
						while(rset_clob.next()){
							Clob clb 			= (Clob) rset_clob.getClob(1);
							BufferedWriter bw 	= new BufferedWriter(clb.setCharacterStream(0));
							//bw.write(order_comment,0,order_comment.length());
							bw.flush();
							bw.close();
						}
					}					
				if(rset_clob	!= null){ closeResultSet( rset_clob ); }
				if(pstmt_clob != null){ closeStatement(pstmt_clob); }
				}

		}

//OR_ORDER_LINE_FIELD_VALUES

			if (result>0) {

				pstmt_delete=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DELETE_FIELD_VALUES_A"));
				pstmt_delete.setString(1, order_id);
				try{
				    pstmt_delete.executeUpdate();
				}
				catch(Exception e){
			        e.printStackTrace();
				}
				if(pstmt_delete != null){ 
					closeStatement(pstmt_delete); 
				}

	            boolean enter_loop = false;
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));
				pstmt_insert.clearBatch();
				if(drugRemarks.size()>0) {
					int order_format_count	= 0;
					for (int i=0;i<drugRemarks.size();i++ ) {
						HashMap DrugValues = (HashMap)drugRemarks.get(i);

						String total_seq	= (String)DrugValues.get("order_format_count");
						order_format_count	= Integer.parseInt(total_seq);

						for(int k=0;k<order_format_count;k++) {
							enter_loop = true;
							pstmt_insert.setString(1, order_id);
							pstmt_insert.setString(2, "" + (i+1));
							pstmt_insert.setString(3, "S");
							pstmt_insert.setString(4, "" + (k+1));
							pstmt_insert.setString(5, (String)DrugValues.get("field_mnemonic"+k));
							pstmt_insert.setString(6, (String)DrugValues.get("field_type"+k));
							pstmt_insert.setString(7, (String)DrugValues.get("label_text"+k));
							pstmt_insert.setString(8, (String)DrugValues.get("field_values"+k));
							pstmt_insert.setString(9, "");
							pstmt_insert.setString(10, "");
							pstmt_insert.setString(11, (String)DrugValues.get("accept_option"+k));

							pstmt_insert.setString(12, login_by_id);
							pstmt_insert.setString(13, login_at_ws_no);
							pstmt_insert.setString(14, login_facility_id);
							pstmt_insert.setString(15, login_by_id);
							pstmt_insert.setString(16, login_at_ws_no);
							pstmt_insert.setString(17, login_facility_id);
							pstmt_insert.addBatch();
						}
					}
					if(enter_loop) {
						int[] batch_result1 = pstmt_insert.executeBatch();
						for (int i=0;i<batch_result1.length;i++ ) {
							if (batch_result1[i]<0  && batch_result1[i] != -2) {
								result=0;
								break;
							}
							else{
								result=1;
							}
						}
					} 
					else {
						result=1;
					}
				} 
				else {
					result=1;
				}
				if(pstmt_insert	!= null) {  
					closeStatement( pstmt_insert );
				}
		  }
// FREQUENCY VALUES ....
			if (result>0) {
				boolean freq_values_found	= false;
				pstmt_insert = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT7"));


				ArrayList frequencyValues = new ArrayList();

                HashMap drugDetails1=new HashMap();
                drugDetails1 = (HashMap)drugDetails.get(0);
			      
		        if (scheduleFreq.size()>0) {
					 if (scheduleFreq.containsKey((String)drugDetails1.get("DRUG_CODE")))
					   	frequencyValues = (ArrayList)scheduleFreq.get((String)drugDetails1.get("DRUG_CODE"));
			    }

				if (frequencyValues.size()>0) {
					for(int n=0;n<frequencyValues.size();n++) {
						freq_values_found	= true;
						int seqNo			= 200;
						seqNo				= seqNo + n;

						HashMap data		= (HashMap)frequencyValues.get(n);
						String admin_time	= (String)data.get("admin_time");
						String admin_qty	= (String)data.get("admin_qty");
						String durn_desc	= "";
             
						pstmt_insert.setString(1, order_id);
						pstmt_insert.setString(2, "1");
						pstmt_insert.setString(3, "S");
						pstmt_insert.setString(4, seqNo + "");
						pstmt_insert.setString(5, "SCHED_ADMIN_TIME");
						pstmt_insert.setString(6, "C");
						pstmt_insert.setString(7, "D");
						pstmt_insert.setString(8, admin_time);
						pstmt_insert.setString(9, admin_qty);
						pstmt_insert.setString(10, durn_desc);
						pstmt_insert.setString(11, "O");
						pstmt_insert.setString(12, login_by_id);
						pstmt_insert.setString(13, login_at_ws_no);
						pstmt_insert.setString(14, login_facility_id);
						pstmt_insert.setString(15, login_by_id);
						pstmt_insert.setString(16, login_at_ws_no);
						pstmt_insert.setString(17, login_facility_id);
						pstmt_insert.addBatch();
					}
				}

				if (freq_values_found) {
					try{
					int[] batch_result = pstmt_insert.executeBatch();
						

					for (int i=0;i<batch_result.length;i++ ) {
						if (batch_result[i]<0  && batch_result[i] != -2) {
							result=0;
							break;
						}
						else {
							result=1;
						}
					}
                    }catch(Exception e)  
					{
					 e.printStackTrace();
					}
				}
				else {
					result=1;
				}
				if(pstmt_insert != null){ closeStatement(pstmt_insert); }
			}
		map.put("result", new Boolean(true));
		map.put("msgid", "RECORD_INSERTED");
		connection.commit();
  
    }
		catch(Exception e) {
			try {
				connection.rollback();
		        e.printStackTrace();
			}
			catch (Exception ee) {
				map.put("msgid", ee.getMessage());
			}
			map.put("msgid", e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet );
				closeStatement(pstmt_insert);
				closeStatement(pstmt_select);
				closeStatement(pstmt_select1);
				closeStatement(pstmt_select2);
				closeStatement(pstmt_select3);
				closeStatement(cstmt_insert);				
				closeStatement(pstmt_update);
				closeStatement(pstmt_update_non_scheduled_drug);
				closeStatement(pstmt_delete);
				closeStatement(pstmt_clob);
				closeStatement(pstmt_update_order_line_ph);
				closeStatement(pstmt_update_patient_drug_profile);
				closeConnection( connection );
				
			}
			catch(Exception fe) {
				fe.printStackTrace();
			}
		}
		return map;
	}

// getOrderIdForTDMDtls(String patient_id,String drug_code) returns the latest order id for which TDM is registered.
	public String getOrderIdForTDMDtls(String patient_id,String drug_code)	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	order_id		= "";		
		
		try{
		connection			= getConnection() ;
		pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT100") ) ;
		pstmt.setString(1,patient_id);
		pstmt.setString(2,drug_code);
		resultSet	= pstmt.executeQuery();
		if ( resultSet != null && resultSet.next() ) {
				order_id	=	resultSet.getString("ORDER_ID");
				
		}
		
		}catch(Exception e){
				 e.printStackTrace() ;	
		}finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}catch(Exception es){
					 es.printStackTrace() ;
				}
			}
		return order_id;
	}

	public ArrayList getOrderDispenseLocation(String location_type,String location_code,String take_home_medication,String priority,String iv_prep_yn,String drug_code,String patient_id,String encounter_id ) {
		Connection connection	= null;
        CallableStatement cstmt	= null;
        ResultSet resultSet		= null;
		ArrayList disp_locn		= new ArrayList();

		try {
			connection	= getConnection();
			cstmt=connection.prepareCall("{call Ph_Ret_Spl_Ord_Disp_Locn(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			cstmt.setString(1, login_facility_id);
			cstmt.setString(2, location_type);
			cstmt.setString(3, location_code);
			cstmt.setString(4, take_home_medication);
			cstmt.setString(5, priority);
			cstmt.setString(6, iv_prep_yn);
			cstmt.setString(7, getLanguageId());
			
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.setString(12,""); // added for Bru-HIMS-CRF-347 [IN:037862]-- end
			cstmt.setString(13,patient_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.setString(14,encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
			cstmt.execute();

			disp_locn.add(cstmt.getString(8));
			disp_locn.add(cstmt.getString(9));
			disp_locn.add(cstmt.getString(10));
//			String durn_list	= cstmt.getString(4);
			
			/*if(durn_list==null)
				durn_list	=	"";
			StringTokenizer st	= new StringTokenizer(durn_list, "|");
			while(st.hasMoreTokens()) {
				durnList.add(st.nextToken());
			}*/
		}
		catch (Exception e) {
			disp_locn.add(e.toString());
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(cstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return disp_locn;
	}
//*********************** ends *********************

	public int getADRCount(String patient_id,String drug_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		int count					= 0;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT102")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,drug_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count = resultSet.getInt("count");			
			}
			
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace();
			}
        }
		return count;
	}

	public void setBillingDetail(HashMap drugDetails, String episode_type, String patient_id, String encounter_id, String drug_code, String ordered_qty,String take_home_medication){
		System.out.println("take_home_medication in CompoundPrescriptionBean==>>" +take_home_medication);
		Connection connection       = null ;
		CallableStatement cstmt = null ;
		PreparedStatement pstmt = null;
		ResultSet rsDecimalPlace= null;
		int decimal_place = 0;
		String decimalFormatString = "#0";
		String order_Date = getOrderDate()+":00";

		String item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
		String episode_id = "";
		String visit_id = "";
		String total_charge_amt ="";
		String patient_payable_amt = "";
		String approval_reqd_yn = "";
		String override_allowed_yn = "";
		String bl_included_IE = "";
		String error_code ="";		 
		String sys_message_id ="";	
		String error_text = "";
		String bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");
		String overriden_action_reason = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");

			//callin billing procedure
		try{
			connection = getConnection() ;
			if(encounter_id!= null && !encounter_id.equals("")){
				episode_id = encounter_id;
				if(episode_type.equals("O")||episode_type.equals("E")){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));
					visit_id = encounter_id.substring(encounter_id.length()-4);
				}
			}
//System.err.println("@@IVPRESCRIPTION GET_CHARGE_DTLS_MAT_ITEM Parameters login_facility_id="+login_facility_id+" episode_type="+episode_type+" PatientId="+patient_id+" episode_id="+episode_id+" visit_id="+visit_id+" item_code="+item_code+" Date="+ order_Date+" item_code="+item_code+" qty_served="+ordered_qty+" bl_incl_excl_override_value="+bl_incl_excl_override_value+" overriden_action_reason="+overriden_action_reason);
			cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?,?)}");
			cstmt.setString( 1, login_facility_id);
			cstmt.setString( 2, "PH");	//module id
			cstmt.setString( 3, "");	//
			cstmt.setString( 4, "");	//
			cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
			cstmt.setString( 6, patient_id); //patient_id
			cstmt.setString( 7, episode_id);  //episode_id
			cstmt.setString( 8, visit_id);  //p_visit_id  
			cstmt.setString( 9, null); //p_dummy1 - null
			cstmt.setString( 10, null); //p_dummy12 - null
			cstmt.setString( 11, "SAL"); //p_transaction_type
			cstmt.setString( 12, order_Date); //p_charge_date_time	--Service Data and time

			cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
			cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
			cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
			cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

			cstmt.setString( 17, item_code);  //p_item_code

			cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
			cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

			cstmt.setString( 20, "S");  //p_serv_panel_ind

			cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

			cstmt.setString( 22,ordered_qty );  //qty served
			cstmt.setString( 23, null);  //p_charge_amt  

			cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

			cstmt.setString( 25,null );  //p_store_code -- Store Code from where issued
			cstmt.setString( 26, null);  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
			cstmt.setString( 27,null );  //p_oth_disc_perc if any other manual discount is given from transaction
			cstmt.setString( 28, null);  //p_source_doc_ref		null for Sale
			cstmt.setString( 29,null );  //p_source_doc_ref_line	null for Sale

			cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
			cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
			cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
			cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
			cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
			cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
			cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
			cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
			cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
			cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
			cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
			cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
			cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
			cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
			cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
			cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
			cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
			cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

			cstmt.setString( 48,null );  //p_dummy4 (IN OUT )
			cstmt.setString( 49, null);  //p_batch_prices  (IN OUT )
			
			cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
			cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
			cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
			cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

			cstmt.setString( 54,bl_incl_excl_override_value );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
			cstmt.setString( 55, overriden_action_reason);  //p_overridden_action_reason		 --- Pass null or any value entered 

			cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
			cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
			cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text
			cstmt.setString( 59, take_home_medication);

			cstmt.execute() ;
			total_charge_amt		=cstmt.getString(36);
			patient_payable_amt		= cstmt.getString(40);
			bl_included_IE	= cstmt.getString(51)==null?"":cstmt.getString(51);             
			approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
			override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 

			error_code		= cstmt.getString(56);
			sys_message_id	= cstmt.getString(57);
			error_text		= cstmt.getString(58);
//System.err.println("@@GET_CHARGE_DTLS_MAT_ITEM Returns total_charge_amt="+total_charge_amt+" patient_payable_amt="+patient_payable_amt+" bl_included_IE="+bl_included_IE+" approval_reqd_yn="+approval_reqd_yn+" error_code="+error_code+" sys_message_id="+sys_message_id+" error_text="+error_text+" override_allowed_yn="+override_allowed_yn);
			closeStatement( cstmt ) ;

			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_BLCORE_GET_DECIMAL_PLACE"));
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			closeStatement( pstmt ) ;
			closeResultSet( rsDecimalPlace ) ;

			if(decimal_place > 0)
				decimalFormatString = decimalFormatString+".";

			for(int i=1;i<=decimal_place;i++){
				decimalFormatString = decimalFormatString+"0";
			}

			if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
			}
			if(total_charge_amt!=null && !total_charge_amt.equals("")){
				DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
				total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
			}
		}
		catch(Exception e){
			error_text = "Error in Proc";
			e.printStackTrace();
		}
		finally{
			try{
				closeStatement( cstmt ) ;
				closeStatement( pstmt ) ;
				closeResultSet( rsDecimalPlace ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}

		drugDetails.put("BL_CHARGE_AMT",total_charge_amt);
		drugDetails.put("BL_PATIENT_PAYABLE",patient_payable_amt);
		drugDetails.put("BL_INCL_EXCL_VALUE",bl_included_IE);
		drugDetails.put("BL_APPRVL_REQD_YN",approval_reqd_yn);
		drugDetails.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
		drugDetails.put("BL_ERROR_CODE",error_code);
		drugDetails.put("BL_SYS_MESSAGE_ID",sys_message_id);
		drugDetails.put("BL_ERROR_TEXT",error_text);
		drugDetails.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
		return;
	}
}
