/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 *****************************************************************************
 *----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
 
26/07/2019      IN:070451       B Haribabu          27/07/2019      Manickam                 ML-MMOH-CRF-1408
---------------------------------------------------------------------------------------------------------------------------------------------------------
 */ 
package ePH ;  
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import oracle.sql.*;

public class PrescriptionBean extends PhAdapter implements Serializable {
	private String locale;
	private HashMap statFreq = new HashMap(); // Added for Performance
	private Hashtable durnDesc = new Hashtable(); // Added for Performance
	//Added for IN:070451 start
	private String weight="";
	private float bsa;
	public HashMap suppDrugMap =new HashMap();//Added for TH-KW-CRF-0007
	public ArrayList suppDrugList = new ArrayList();//Added for TH-KW-CRF-0007
	PrescriptionBean_1 presBean_1 =null;
	public void setPresBean_1(PrescriptionBean_1 presBean_1) {
		this.presBean_1 = presBean_1;
	}
	public void setWeight(String weight) {
		this.weight = weight;
		System.out.println("weight"+weight);
	}
	public String getWeight() {
		return weight;
	}
	public void setBsa(float bsa) {
		this.bsa =bsa; 
		System.out.println("bsa"+bsa);
	}
	public double getBsa() {
		return bsa;
	}
	//Added for IN:070451 end
	public PrescriptionBean() {
        try {
            doCommon();
        }
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void doCommon() throws Exception {
	}
	//Addeed for ml-mmoh-crf-0863 start
		String disp_locn_code="";    

		public String getDisp_locn_code() {
			return disp_locn_code;
		}
		public void setDisp_locn_code(String disp_locn_code) {
			this.disp_locn_code = disp_locn_code;
		}
			String  order_ststus="";
			public String getOrder_ststus() {
			return order_ststus;
			}
			public void setOrder_ststus(String order_ststus) {
			this.order_ststus = order_ststus;
			}
		//Addeed for ml-mmoh-crf-0863 end
//added start for performance
	public void setStatFreqs(ArrayList stat_freq){
			this.statFreq.put("statFreq",stat_freq);
	}
	public ArrayList getStatFreq(){
		ArrayList stat_freq = new ArrayList();
		if(statFreq.containsKey("statFreq"))
			 stat_freq= (ArrayList)durnDesc.get("statFreq");
	    return stat_freq;
	}
	public void setDurnDesc(Hashtable durn_desc_value){
		this.durnDesc.put("durnDesc",durn_desc_value);
	}
	public Hashtable getDurnDesc(){
		Hashtable durn_desc = new Hashtable();
		if(durnDesc.containsKey("durnDesc"))
			 durn_desc= (Hashtable)durnDesc.get("durnDesc");
		return durn_desc;
	}
	public void clear() {//Added for TH-KW-CRF-0007
			super.clear() ;
			 suppDrugMap =new HashMap();//Added for TH-KW-CRF-0007
	         suppDrugList = new ArrayList();//Added for TH-KW-CRF-0007
		}
//added end for performance
	public HashMap loadHeaderHtWtValues(String facility_id,String patient_id,String encounter_id,String patient_class){//finding the Height/Weight/uom Values
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap HeaderHtWtValues	= new HashMap();
		int		i	=	0;
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT2");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,patient_id);
			//pstmt.setString(3,patient_class);//COMMENTED FOR SKR-SCF-1243
			resultSet			= pstmt.executeQuery();

			while(resultSet!=null && resultSet.next() && i<2) {
				if(((String)resultSet.getString("FIELD_OR_TEMPLATE_MNEMONIC")).equals("HEIGHT") && (!HeaderHtWtValues.containsKey("HEIGHT"))) {
					HeaderHtWtValues.put("HEIGHT",(String)resultSet.getString("DISCR_MSR_RESULT_NUM"));
					HeaderHtWtValues.put("HEIGHT_UOM",(String)resultSet.getString("DISCR_MSR_RESULT_NUM_UOM"));
					HeaderHtWtValues.put("OBSERV_DT",(String)resultSet.getString("TEST_OBSERV_DT_TM"));
					i++; //moved inside if and else for ML-BRU-SCF-0127
				} 
				else if( ((String)resultSet.getString("FIELD_OR_TEMPLATE_MNEMONIC")).equals("WEIGHT") && (!HeaderHtWtValues.containsKey("WEIGHT"))){
					HeaderHtWtValues.put("WEIGHT",(String)resultSet.getString("DISCR_MSR_RESULT_NUM"));
					HeaderHtWtValues.put("WEIGHT_UOM",(String)resultSet.getString("DISCR_MSR_RESULT_NUM_UOM"));
					HeaderHtWtValues.put("OBSERV_DT",(String)resultSet.getString("TEST_OBSERV_DT_TM"));
					i++;  //moved inside if and else for ML-BRU-SCF-0127
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
		return HeaderHtWtValues;
	}

	public float loadBSA(String height,String weight){//finding the BSA Value
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		float bsa					= 0f;
		try{
			connection		= getConnection() ;
			sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3");
			pstmt			= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,height);
			pstmt.setString(2,weight);
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				bsa = resultSet.getFloat(1);
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
		return bsa;
	}

	public String getVisitDate(double encounter_id,String facility_id){//getting VisitDate
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		String visit_date="";
		try{
			connection          = getConnection() ;
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT7");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setDouble(1,encounter_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				visit_date = resultSet.getString("VISIT_DATE_TIME");
			}
		 }
		 catch ( Exception e ) {
			visit_date =visit_date+"excep :"+e;
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
		return visit_date;
	}

	public HashMap getHgtWgtDtls(String patient_id){//getting data for min/max value of discrete mesure fields HEIGHT & WEIGHT
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap discr_values		= new HashMap();
		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT101");
			int index	 =	sql_query.lastIndexOf('?');
			sql_query = sql_query.substring(0,index)+"'HEIGHT','WEIGHT'"+sql_query.substring(index+1);
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null ){
				while(resultSet.next()){
					String discr_msr = (String)resultSet.getString("discr_msr_id");
					if(discr_msr.equals("HEIGHT")){
						discr_values.put("HEIGHT_MIN_VALUE",checkForNull(resultSet.getString("min_value")));
						discr_values.put("HEIGHT_MAX_VALUE",checkForNull(resultSet.getString("max_value")));
						discr_values.put("HEIGHT_MIN_DIGITS",checkForNull(resultSet.getString("min_digits"),"0"));
						discr_values.put("HEIGHT_MAX_DIGITS",checkForNull(resultSet.getString("max_digits"), "6"));
						discr_values.put("HEIGHT_DEC_DIGITS",checkForNull(resultSet.getString("dec_digits"),"2"));
					}
					if(discr_msr.equals("WEIGHT")){
						discr_values.put("WEIGHT_MIN_VALUE",checkForNull(resultSet.getString("min_value")));
						discr_values.put("WEIGHT_MAX_VALUE",checkForNull(resultSet.getString("max_value")));
						discr_values.put("WEIGHT_MIN_DIGITS",checkForNull(resultSet.getString("min_digits"),"0"));
						discr_values.put("WEIGHT_MAX_DIGITS",checkForNull(resultSet.getString("max_digits"),"6"));
						discr_values.put("WEIGHT_DEC_DIGITS",checkForNull(resultSet.getString("dec_digits"),"2"));
					}
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
		return discr_values;
	}

	public HashMap getBackDate(String sys_date){//getting back date for order date/time
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap BackDates 			= new HashMap();
		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT5A");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,sys_date);
			pstmt.setString(2,sys_date);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				BackDates.put("FUTURE_DATE",(resultSet.getString("FUTURE_DATE")) );
				BackDates.put("BACK_DATE",(resultSet.getString("BACK_DATE")) );
			}
		}
		catch ( Exception e ) {
			BackDates.put("error",e);
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
		return BackDates;
	}

	public ArrayList getFromToDates(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		ArrayList fm_to_dates		= new ArrayList();
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54A");
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,login_facility_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				fm_to_dates.add(resultSet.getString("BACK_DATE"));
				fm_to_dates.add(resultSet.getString("SYS_DATE"));
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
		return fm_to_dates;
	}

	public String getSysdate(){//getting system date
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sys_date				= "";

		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString(1);
			}
		}
		catch ( Exception e ) {
			sys_date= sys_date+e.toString();
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
		return sys_date;
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
				es.printStackTrace() ;
			}
		}
		return pre_sch_yn;
	}

	public HashMap populateOrderType(String patient_class){//pouplating the order_type list in Header part.
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		String presel_order_category_yn="";
		String presel_order_type_code_yn="";
		HashMap OrderType			= new HashMap();
		ArrayList OrderTypeCode		= new ArrayList();
		ArrayList OrderTypeDesc		= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection				= getConnection() ;
			sql_query				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9B");
			pstmt					= connection.prepareStatement(sql_query) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){

				presel_order_category_yn= resultSet.getString("presel_order_category_yn")==null ? "N":resultSet.getString("presel_order_category_yn");
				presel_order_type_code_yn= resultSet.getString("presel_order_type_code_yn")==null ? "N":resultSet.getString("presel_order_type_code_yn");
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}

			if(presel_order_category_yn.equals("Y") && presel_order_type_code_yn.equals("Y")){
				sql_query				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT9");
				pstmt					= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,patient_class);
				resultSet				= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					OrderType.put("ORDER_TYPE_CODE_YN",resultSet.getString("PRESELECT_ORDER_TYPE_CODE_YN"));
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
			else{
				OrderType.put("ORDER_TYPE_CODE_YN","N");
			}

			sql_query				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT10");
			pstmt					= connection.prepareStatement(sql_query) ;
			pstmt.setString(1, locale);
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				OrderTypeCode.add(resultSet.getString("ORDER_TYPE_CODE"));
				OrderTypeDesc.add(resultSet.getString("SHORT_DESC"));
			}
			OrderType.put("OrderTypeCode",OrderTypeCode);
			OrderType.put("OrderTypeDesc",OrderTypeDesc);
		 }
		 catch ( Exception e ) {
				OrderType.put("error",e);
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
		return OrderType;
	}

	public boolean duplicateRecord(String dup_start_date,String dup_end_date,String drug_start_date,String drug_end_date) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		boolean	result			=	false;
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_SELECT5") ) ;
			pstmt.setString(1,drug_start_date);
			pstmt.setString(2,dup_start_date);
			pstmt.setString(3,dup_end_date);
			pstmt.setString(4,drug_end_date);
			pstmt.setString(5,dup_start_date);
			pstmt.setString(6,dup_end_date);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				result	=	((resultSet.getInt("COUNT"))>0);
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
				es.printStackTrace() ;
			}
		}
		return result;	
	}

	public String getLineNo(String order_id, String drug_code) {
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	line_no			=	"";
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_SELECT3") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,drug_code);

			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					line_no	=	resultSet.getString("ORDER_LINE_NUM");
			}						
		}
		catch(Exception e){
			line_no	=(e.toString());
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
		return line_no;	
	}

	public ArrayList loadQtyDetails(String form_code){
		ArrayList	qty_values  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;
			pstmt		= connection.prepareStatement("SELECT a.short_desc, a.uom_code, b.dflt_uom_yn qty_uom_yn FROM am_uom_lang_vw a, ph_uom_for_form b WHERE a.uom_code = b.uom_code AND b.form_code = ? AND a.qty_uom_yn = 'Y' AND a.language_id = ? UNION SELECT (select b.short_desc from am_uom_lang_vw b where b.uom_code=a.uom_code and b.language_id=?) short_desc, c.uom_code, c.dflt_uom_yn FROM am_uom_eqvl a, ph_uom_for_form c WHERE a.uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND a.eqvl_uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND c.uom_code = a.uom_code AND c.form_code = ? UNION SELECT (select b.short_desc from am_uom_lang_vw b where b.uom_code=a.eqvl_uom_code and b.language_id=?) short_desc , c.uom_code, c.dflt_uom_yn FROM am_uom_eqvl a, ph_uom_for_form c WHERE a.uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND a.eqvl_uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND c.uom_code = a.eqvl_uom_code AND c.form_code = ?" ) ;//added for performance issue MMS
			pstmt.setString(1,form_code);
			pstmt.setString(2,locale);		
			pstmt.setString(3,locale);		//added for performance issue MMS
			pstmt.setString(4,form_code);
			pstmt.setString(5,form_code);
			pstmt.setString(6,form_code);//added for performance issue MMS
			pstmt.setString(7,locale);		
			pstmt.setString(8,form_code);
			pstmt.setString(9,form_code);		
			pstmt.setString(10,form_code);		//added for performance issue MMS
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				qty_values.add(resultSet.getString("UOM_CODE"));
				qty_values.add(resultSet.getString("SHORT_DESC"));
				qty_values.add(resultSet.getString("QTY_UOM_YN"));
			}
		}
		catch(Exception e){
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
		return qty_values;
	}

	public Hashtable loadDurnDesc(){
		Hashtable	durn_values  = new Hashtable();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13A") ) ;
			pstmt.setString(1, locale);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				durn_values.put(resultSet.getString("DURN_TYPE"),resultSet.getString("DURN_DESC"));
			}
			setDurnDesc(durn_values);//added for performance ML-MMOH-SCF-0684
		}
		catch(Exception e){
			durn_values.put("Exception",e.toString());
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){ 
				durn_values.put("Exception",es.toString());
				es.printStackTrace();
			}
		}
		return durn_values;
	}

	public HashMap freqValidate(String freq_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String freq_nature= "", freq_value="";
		HashMap freqValues			= new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection					= getConnection() ;
			pstmt						= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT6A")) ;
			pstmt.setString(1,freq_code);
			pstmt.setString(2,locale);
			resultSet					= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				freq_nature			= resultSet.getString("FREQ_NATURE");
				freq_value			= resultSet.getString("FREQ_VALUE");
				freqValues.put("freq_nature",freq_nature);
				freqValues.put("interval_value",resultSet.getString("INTERVAL_VALUE"));
				freqValues.put("repeat_value",resultSet.getString("REPEAT_VALUE"));
				freqValues.put("schedule_yn",resultSet.getString("SCHEDULED_YN"));
				freqValues.put("repeat_durn_type",resultSet.getString("REPEAT_DURN_TYPE"));
			}

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
				es.printStackTrace() ;
			}
		}
		return freqValues;
	}

	public HashMap populateRefillDetail(String end_date,String durn_value,String repeat_durn_type,String refill_value){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String str_refil_startdate="";
		String str_refil_enddate="";
		ArrayList refill_start_date	= new ArrayList();
		ArrayList refill_end_date	= new ArrayList();
		HashMap RefillDetail=new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection = getConnection() ;
			//sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT30");
			sql_query        = "SELECT TO_CHAR ((CASE  WHEN 'D' = ? AND ROWNUM = 1 THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440) WHEN 'D' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (TO_NUMBER (?)) * (ROWNUM - 1) + 0  WHEN 'W' = ? AND ROWNUM = 1   THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440)  WHEN 'W' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + ((TO_NUMBER (?) * 7)) * (ROWNUM - 1) + 0 WHEN 'L' = ? AND ROWNUM = 1  THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440)  WHEN 'L' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + ((TO_NUMBER (?) * 30)) * (ROWNUM - 1) + 0 WHEN 'Y' = ? AND ROWNUM = 1 THEN (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1/1440)  WHEN 'Y' = ? AND ROWNUM > 1  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440))  + ((TO_NUMBER (?) * 365)) * (ROWNUM - 1) + 0 WHEN 'M' = ? AND ROWNUM = 1 THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1 / 1440) WHEN 'M' = ? AND ROWNUM > 1 THEN (  TO_DATE (?, 'dd/mm/yyyy hh24:mi') + (ROWNUM * 1 / 1440)) + ((TO_NUMBER (?)/(24*60))) * (ROWNUM - 1) + 0 WHEN 'H' = ? AND ROWNUM = 1 THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')) + (1 * ROWNUM * 1 / 1440) WHEN 'H' = ? AND ROWNUM > 1 THEN   (  TO_DATE (?, 'dd/mm/yyyy hh24:mi') + (ROWNUM * 1 / 1440)) + ((TO_NUMBER (?)/24)) * (ROWNUM - 1) + 0  END), 'dd/mm/yyyy hh24:mi' ) start_date,  TO_CHAR ((CASE WHEN 'D' = ?  THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + ((TO_NUMBER (?)) * ROWNUM) WHEN 'W' = ? THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (((TO_NUMBER (?) * 7)) * ROWNUM)  WHEN 'L' = ? THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (((TO_NUMBER (?) * 30)) * ROWNUM) WHEN 'Y' = ? THEN   (TO_DATE (?, 'dd/mm/yyyy hh24:mi')+(ROWNUM * 1/1440)) + (((TO_NUMBER (?) * 365)) * ROWNUM) WHEN 'M' = ? THEN   (  TO_DATE (?, 'dd/mm/yyyy hh24:mi') + (ROWNUM * 1 / 1440) ) + (((TO_NUMBER (?)/(24*60))) * ROWNUM) WHEN 'H' = ? THEN   (  TO_DATE (?, 'dd/mm/yyyy hh24:mi')+ (ROWNUM * 1 / 1440))+ (((TO_NUMBER (?)/24)) * ROWNUM) END), 'dd/mm/yyyy hh24:mi') end_date  FROM sm_function  WHERE ROWNUM <= TO_NUMBER (?)";
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,repeat_durn_type);
			pstmt.setString(2,end_date);
			pstmt.setString(3,repeat_durn_type);
			pstmt.setString(4,end_date);
			pstmt.setString(5,durn_value);
			pstmt.setString(6,repeat_durn_type);
			pstmt.setString(7,end_date);
			pstmt.setString(8,repeat_durn_type);
			pstmt.setString(9,end_date);
			pstmt.setString(10,durn_value);
			pstmt.setString(11,repeat_durn_type);
			pstmt.setString(12,end_date);
			pstmt.setString(13,repeat_durn_type);
			pstmt.setString(14,end_date);
			pstmt.setString(15,durn_value);
			pstmt.setString(16,repeat_durn_type);
			pstmt.setString(17,end_date);
			pstmt.setString(18,repeat_durn_type);
			pstmt.setString(19,end_date);
			pstmt.setString(20,durn_value);
			pstmt.setString(21,repeat_durn_type);
			pstmt.setString(22,end_date);
			pstmt.setString(23,repeat_durn_type);
			pstmt.setString(24,end_date);
			pstmt.setString(25,durn_value);
			pstmt.setString(26,repeat_durn_type);
			pstmt.setString(27,end_date);
			pstmt.setString(28,repeat_durn_type);
			pstmt.setString(29,end_date);
			pstmt.setString(30,durn_value);
			pstmt.setString(31,repeat_durn_type);
			pstmt.setString(32,end_date);
			pstmt.setString(33,durn_value);
			pstmt.setString(34,repeat_durn_type);
			pstmt.setString(35,end_date);
			pstmt.setString(36,durn_value);
			pstmt.setString(37,repeat_durn_type);
			pstmt.setString(38,end_date);
			pstmt.setString(39,durn_value);
			pstmt.setString(40,repeat_durn_type);
			pstmt.setString(41,end_date);
			pstmt.setString(42,durn_value);
			pstmt.setString(43,repeat_durn_type);
			pstmt.setString(44,end_date);
			pstmt.setString(45,durn_value);
			pstmt.setString(46,repeat_durn_type);
			pstmt.setString(47,end_date);
			pstmt.setString(48,durn_value);
			pstmt.setString(49,refill_value);
			
			resultSet= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				str_refil_startdate = resultSet.getString("START_DATE");
				str_refil_enddate = resultSet.getString("END_DATE");
				if(!locale.equals("en")){
					str_refil_startdate = com.ehis.util.DateUtils.convertDate(str_refil_startdate, "DMYHM","en",locale);
					str_refil_enddate =	com.ehis.util.DateUtils.convertDate(str_refil_enddate, "DMYHM","en",locale);
				}
				refill_start_date.add(str_refil_startdate);
				refill_end_date.add(str_refil_enddate);
			}
			RefillDetail.put("refill_start_date",refill_start_date);
			RefillDetail.put("refill_end_date",refill_end_date);
		}
		catch ( Exception e ) {
			RefillDetail.put("error",e);
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
		return RefillDetail;
	}

	public String getFormatId(String order_category,String order_type_code,String order_catalog_code){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String format_id		=	"";
		try{
			connection			= getConnection() ;
			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT46");
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,order_category);
			pstmt.setString(2,order_type_code);
			pstmt.setString(3,order_catalog_code);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				format_id	=	resultSet.getString("FORMAT_ID");
			}
		}
		catch(Exception e){
			format_id	=e.toString();
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
		return format_id;
	}

	public HashMap populateRefillDates(String end_date,String durn_value,String repeat_durn_type,String refill_value){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String refill_start_date	= "";
		String refill_end_date	= "";
		HashMap RefillDetail=new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT39");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,repeat_durn_type);
			pstmt.setString(2,end_date);
			pstmt.setString(3,repeat_durn_type);
			pstmt.setString(4,end_date);
			pstmt.setString(5,repeat_durn_type);
			pstmt.setString(6,end_date);
			pstmt.setString(7,repeat_durn_type);
			pstmt.setString(8,end_date);
			pstmt.setString(9,durn_value);
			pstmt.setString(10,refill_value);
			pstmt.setString(11,repeat_durn_type);
			pstmt.setString(12,end_date);
			pstmt.setString(13,durn_value);
			pstmt.setString(14,refill_value);
			pstmt.setString(15,repeat_durn_type);
			pstmt.setString(16,end_date);
			pstmt.setString(17,durn_value);
			pstmt.setString(18,refill_value);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				refill_start_date=resultSet.getString("START_DATE");
				refill_end_date=resultSet.getString("END_DATE");
			}
			if(!locale.equals("en")){
				refill_start_date = com.ehis.util.DateUtils.convertDate(refill_start_date, "DMYHM","en",locale);
				refill_end_date =	com.ehis.util.DateUtils.convertDate(refill_end_date, "DMYHM","en",locale);
			}
			RefillDetail.put("refill_st_date",refill_start_date);
			RefillDetail.put("refill_en_date",refill_end_date);
		}
		catch ( Exception e ) {
			RefillDetail.put("error",e);
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
		return RefillDetail;
	}

	public ArrayList getPresValues(String form_code,String route_code,String order_catalog_code)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String remarks_code			=	"";
		String remarks_desc			=	"";
		ArrayList pres_values	= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT48");
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,order_catalog_code);
			pstmt.setString(2,form_code);
			pstmt.setString(3,route_code);
			pstmt.setString(4,locale);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				remarks_code	=	resultSet.getString("REMARK_CODE");
				remarks_desc	=	resultSet.getString("REMARK_DESC");
				pres_values.add(remarks_code);
				pres_values.add(remarks_desc);
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(pres_values.size() == 0)	{
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT49");
				pstmt				= connection.prepareStatement(sql_str) ;
				pstmt.setString(1,locale);
				resultSet	= pstmt.executeQuery();
				while ( resultSet != null && resultSet.next() ) {
					remarks_code	=	resultSet.getString("REMARK_CODE");
					remarks_desc	=	resultSet.getString("REMARK_DESC");
					pres_values.add(remarks_code);
					pres_values.add(remarks_desc);
				}
			}
		}
		catch(Exception e){
			pres_values.add(e.toString());
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
		return pres_values;
	}

	public HashMap getAuthorizationReqd(String resp_id,String pract_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap authValues = new HashMap();
 		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next()){
				 authValues.put("auth_yn",(resultSet.getString("AUTH_YN")==null ? "N":resultSet.getString("AUTH_YN")) );
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50A"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next()){
				authValues.put("spl_appr_yn",(resultSet.getString("SPL_APPR_YN")==null ? "N":resultSet.getString("SPL_APPR_YN")) );
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT50B"));
			pstmt.setString(1,pract_id);
			pstmt.setString(2,resp_id);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next()){
			  authValues.put("cosign_yn",(resultSet.getString("COSIGN_YN")==null ? "N":resultSet.getString("COSIGN_YN")) );
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return authValues;
	}// End of the getAuthorizationReqd
	
	public HashMap populateDateParams(String sys_date){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		String future_date			="";
		String back_date			="";
		String start_date			="";
		HashMap DateParams=new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,sys_date);
			pstmt.setString(2,sys_date);
			resultSet			= pstmt.executeQuery();
			 if(resultSet!=null && resultSet.next()){
				future_date=resultSet.getString("FUTURE_DATE");
				back_date=resultSet.getString("BACK_DATE");
				if(!locale.equals("en")){
					future_date =com.ehis.util.DateUtils.convertDate(future_date, "DMYHM","en",locale);
					back_date = com.ehis.util.DateUtils.convertDate(back_date, "DMYHM","en",locale);
				}
			}
			DateParams.put("start_date",start_date);
			DateParams.put("future_date",future_date);
			DateParams.put("back_date",back_date);
	    }
		catch ( Exception e ) {
			DateParams.put("error",e);
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
		return DateParams;
	}

	public String getPrescriptionRemarks(String remark_code){
		String remarks ="";
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRES_REMARKS")) ;
			pstmt.setString(1,remark_code);
			pstmt.setString(2,locale);
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
				es.printStackTrace() ;
			}
		}
		return remarks.trim();
	}

	public HashMap validateDuration(String drug_code,String patient_class){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap durnValues			= new HashMap();
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,patient_class);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				durnValues.put("max_durn_value",resultSet.getString("MAX_DURN_VALUE"));
				durnValues.put("chk_for_max_durn_action",resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
				durnValues.put("prompt_msg",resultSet.getString("PROMPT_MSG"));
				durnValues.put("max_durn_type",resultSet.getString("MAX_DURN_TYPE"));
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
			if(!durnValues.containsKey("max_durn_value")) {
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drug_code);
				pstmt.setString(2,"*A");
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					durnValues.put("max_durn_value",resultSet.getString("MAX_DURN_VALUE"));
					durnValues.put("chk_for_max_durn_action",resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
					durnValues.put("prompt_msg",resultSet.getString("PROMPT_MSG"));
					durnValues.put("max_durn_type",resultSet.getString("MAX_DURN_TYPE"));
				}
			}
		}
		catch ( Exception e ) {
			durnValues.put("error",e);
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
		return durnValues;
	}
	public ArrayList loadStatFreqs(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList stat_freq			= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection		= getConnection() ;
			sql_query       = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT96");
			pstmt			= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,locale);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()) {
				stat_freq.add(resultSet.getString("FREQ_CODE"));
				stat_freq.add(resultSet.getString("FREQ_DESC"));				
			}
			setStatFreqs(stat_freq);// Added for Performance ML-MMOH-SCF-0684
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
		return stat_freq;
	}

	public HashMap populateTaperDates(String end_date,String durn_value,String repeat_durn_type){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap DateParams=new HashMap();
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT38");//Query modified for IN22425  --01/06/2010-- priya
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,end_date);
			pstmt.setString(2,repeat_durn_type);
			pstmt.setString(3,end_date);
			pstmt.setString(4,durn_value);
			pstmt.setString(5,repeat_durn_type);
			pstmt.setString(6,end_date);
			pstmt.setString(7,durn_value);
			pstmt.setString(8,repeat_durn_type);
			pstmt.setString(9,end_date);
			pstmt.setString(10,durn_value);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				DateParams.put("taper_start_date",resultSet.getString("START_DATE"));
				DateParams.put("taper_end_date",resultSet.getString("END_DATE"));
			}
	    }
		catch ( Exception e ) {
			DateParams.put("error",e);
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
		return DateParams;
	}

	public String getLocationDesc(String patient_class,String locn_code)	{
		if(!patient_class.equals("IP")) {
			patient_class	=	"OP";
		}
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str			=	"";
		String locn_desc		=	"";
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			if(patient_class.equals("IP"))
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT41");
			else if (patient_class.equals("OP") )
				sql_str			=	PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT42");
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,locn_code);
			pstmt.setString(3,locale);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				locn_desc	=	resultSet.getString("LONG_DESC");
			}
		}
		catch(Exception e){
			locn_desc	=e.toString();
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
		return locn_desc;
	}
	
	public HashMap chkMaxDosageLimit(String drugCode,String patient_id,String qty_value,String dosage_type,String repeat_value){
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        PreparedStatement pstmt =null;//Added for IN:070451
        ResultSet resultSet         = null ;
        ResultSet resultSet1         = null ;//Added for IN:070451
		HashMap dosage_dtl			= new HashMap();
//Added for IN:070451 start
		System.err.println("weight>>>>>"+getWeight());
		System.err.println("bsa>>>>"+getBsa());
		HashMap pat_dtls	=	presBean_1.getPatientDetails(patient_id,drugCode);
		String age_group			=	(String)pat_dtls.get("age_group")==null?"":(String)pat_dtls.get("age_group"); //Modified for GHL-SCF-1614
		System.err.println("age_group>>>>"+age_group);
		String factor;
		String calc_by_ind="";
		if(!age_group.equals("")) {
			try{
			String sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT81");
			connection = getConnection() ;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,age_group);
			resultSet1			= pstmt.executeQuery();
			if(resultSet1!=null && resultSet1.next()) {
				 calc_by_ind =(resultSet1.getString("CALC_BY_IND"));
				System.out.println("calc_by_ind >>"+calc_by_ind);
			} 
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try{
					closeResultSet( resultSet1 ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es){
					es.printStackTrace() ;
				}
			}
		}
		if(calc_by_ind.equalsIgnoreCase("W")){
			if(!weight.equals(""))
				factor =weight;
			else
				factor ="1";
		}
		else if(calc_by_ind.equalsIgnoreCase("B")){
			if(bsa!=0.0f)
				factor =String.valueOf(bsa);
			else
				factor ="1";
			
			 System.out.println("bsa"+bsa);
		}
		else{
			factor = "1";
		}
		//Added for IN:070451 end
		try{
			connection = getConnection() ;
			cstmt=connection.prepareCall("{call PH_PKG_BASE.PH_DrugDoseInLimit1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");//Modified for IN:070451
			cstmt.setString( 1, drugCode);
			cstmt.setString( 2, patient_id);
			cstmt.setString( 3, qty_value);
			cstmt.setString( 4, repeat_value);
			cstmt.setString( 5, dosage_type);
			cstmt.registerOutParameter(6, Types.VARCHAR );
			cstmt.registerOutParameter(7, Types.VARCHAR );
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.VARCHAR );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			//Added for IN:070451 start
			cstmt.registerOutParameter(13, Types.VARCHAR );
			cstmt.registerOutParameter(14, Types.VARCHAR );
			cstmt.registerOutParameter(15, Types.VARCHAR );
			cstmt.registerOutParameter(16, Types.VARCHAR );
			cstmt.setString(17, factor );
			//Added for IN:070451 end
			cstmt.execute() ;

			String limit_ind	= cstmt.getString( 8 );
			//&& !(calc_by_ind.equalsIgnoreCase("W"))
		/*	if(bsa==0.0 && !(calc_by_ind.equalsIgnoreCase("A")) && !(calc_by_ind.equalsIgnoreCase("W"))){//modified for ml-mmoh-crf-1914
				dosage_dtl.put("LIMIT_IND","Y");
				}
			else if( (weight =="" && (calc_by_ind.equalsIgnoreCase("W")))){//modified for ml-mmoh-crf-1914
				dosage_dtl.put("LIMIT_IND","Y");
				}
			
				else{
					dosage_dtl.put("LIMIT_IND",limit_ind);
				}*/
			
			if(calc_by_ind.equalsIgnoreCase("W") && weight !="" )
			{
				dosage_dtl.put("LIMIT_IND",limit_ind);
			}

			else if(calc_by_ind.equalsIgnoreCase("B") && bsa !=0.0){
				dosage_dtl.put("LIMIT_IND",limit_ind);
			}

			else if(calc_by_ind.equalsIgnoreCase("A")){
				dosage_dtl.put("LIMIT_IND",limit_ind);
			}

			else{
				dosage_dtl.put("LIMIT_IND","Y");
			}
			dosage_dtl.put("DAILY_DOSE",(cstmt.getString(6)==null ? "":cstmt.getString(6)) );
			dosage_dtl.put("UNIT_DOSE",(cstmt.getString(7)==null ? "":cstmt.getString(7)) );
			dosage_dtl.put("MONO_GRAPH","" );
			dosage_dtl.put("MIN_DAILY_DOSE",(cstmt.getString(10)==null ? "":cstmt.getString(10)) );
			dosage_dtl.put("MIN_UNIT_DOSE",(cstmt.getString(11)==null ? "":cstmt.getString(11)) );
			//Added for IN:070451 start
			dosage_dtl.put("MAX_DAILY_CEELING_DOSE",cstmt.getString(13)==null ? "":cstmt.getString(13));
			dosage_dtl.put("MIN_DAILY_CEELING_DOSE",cstmt.getString(14)==null ? "":cstmt.getString(14));
			dosage_dtl.put("MAX_UNIT_CEELING_DOSE",cstmt.getString(15)==null ? "":cstmt.getString(15));
			dosage_dtl.put("MIN_UNIT_CEELING_DOSE",cstmt.getString(16)==null ? "":cstmt.getString(16));
			//Added for IN:070451 end
				dosage_dtl.put("DOSAGE_UNIT",cstmt.getString(12));
			if(limit_ind!=null && limit_ind.equals("N")){
				dosage_dtl.put("MONO_GRAPH",(cstmt.getString(9)==null ? "":cstmt.getString(9)) );
			}
		 }
		 catch ( Exception e ) {
			dosage_dtl.put("error",e);
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return dosage_dtl;
	}

	public ArrayList getFreqDet(String order_id,String order_line_no){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		ArrayList freq_det			=	new ArrayList();
		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT61");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				freq_det.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));
				freq_det.add(resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE"));
				freq_det.add(resultSet.getString("ORDER_LINE_DOSE_QTY_UNIT"));
				freq_det.add(resultSet.getString("ORDER_LINE_FREQ_DAY"));
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
		return freq_det;
	}

	public boolean compareDates(String sys_date_time,String end_date_time) throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		boolean	 is_less		  = false;
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MEDICATION_COMPARE_DATES_A")) ;
			pstmt.setString(1,sys_date_time);
			pstmt.setString(2,end_date_time);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("DATEVALUE")==1){
					is_less =true;
				}				
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
		return is_less;
	}

	public ArrayList getPrnRemarkForDrug(String drugCode)throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		ArrayList prnRemarks = new ArrayList();
		HashMap temp = new HashMap();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT A.REASON_CODE,A.DEFAULT_REASON_YN, B.REASON_DESC, B.REMARKS FROM PH_PRN_REMARK_FOR_DRUG A, PH_MEDN_TRN_REASON_LANG_vw B WHERE A.REASON_CODE=B.REASON_CODE AND A.DRUG_CODE=? AND LANGUAGE_ID=? and b.eff_status ='E'") ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null){
				while(resultSet.next()){
					temp = new HashMap();
					temp.put("REASON_CODE",resultSet.getString("REASON_CODE"))	;			
					temp.put("REASON_DESC",resultSet.getString("REASON_DESC"))	;	
					temp.put("REMARKS",resultSet.getString("REMARKS"))	;	
					temp.put("DEFAULT_REASON_YN",resultSet.getString("DEFAULT_REASON_YN"))	;
					prnRemarks.add(temp);
				}
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
		return prnRemarks;
	}

	public String getDecimalFormatString(){//function will be called  from Header_a page if Billing is installed.
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet rsDecimalPlace		  = null;
		int decimal_place  = 0;
		String bl_decimalFormatString = "#0";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_BLCORE_GET_DECIMAL_PLACE"));
			pstmt.setString(1,login_facility_id);
			rsDecimalPlace = pstmt.executeQuery();
			if(rsDecimalPlace.next())
				decimal_place = rsDecimalPlace.getInt("decimal_place");
			if(decimal_place > 0)
				bl_decimalFormatString = bl_decimalFormatString+".";
			for(int i=1;i<=decimal_place;i++){
				bl_decimalFormatString = bl_decimalFormatString+"0";
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( rsDecimalPlace ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}	
		return bl_decimalFormatString;
	}

	public HashMap getIVLegends() {	
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;
		HashMap iv_legends			= new HashMap();
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement("SELECT IV_DRUG_FLUID_CONTINUOUS_LG iv_drug_fluid_continuous, IV_DRUG_FLUID_INTERMITTENT_LG IV_DRUG_FLUID_INTERMITTENT, IV_WITHOUT_ADDITIVES_LG from ph_param_lang_vw ph_param WHERE language_id = ?" ) ;
			pstmt.setString(1,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
			while(resultSet.next() ) {
                iv_legends.put("IVA",resultSet.getString("iv_drug_fluid_continuous"));
                iv_legends.put("IVI",resultSet.getString("IV_DRUG_FLUID_INTERMITTENT"));
				iv_legends.put("IVWA",resultSet.getString("IV_WITHOUT_ADDITIVES_LG"));
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
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return iv_legends;
	}

	public String getDrugYN(String code) {	
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;
		String drug_yn = "";

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement("SELECT DRUG_YN from ph_drug_lang_vw ph_drug where drug_code = ? and language_id = ?" ) ;
			pstmt.setString(1,code);
			pstmt.setString(2,getLanguageId());
		    resultSet = pstmt.executeQuery() ;
	         while(resultSet.next() ) {
                 drug_yn = resultSet.getString("DRUG_YN");
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
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return drug_yn;
	}

	/*public String getStockUOM(String drug_code)	{// stock uom
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String stock_uom="";
		locale= getLanguageId()==null?"en":getLanguageId();
		try {
			connection			= getConnection();
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT82"));
			pstmt.setString(1, drug_code);
			pstmt.setString(2, locale);
			pstmt.setString(3, locale);
			pstmt.setString(4, locale);
			pstmt.setString(5, locale);
			pstmt.setString(5, locale);
			resultSet	= pstmt.executeQuery();
			if (resultSet != null && resultSet.next()) {
				stock_uom	=	resultSet.getString("STOCK_UOM_DESC");
			}
		} 
		catch(Exception e) {
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
	}*/ //commented b'z not used

	public String getOrderUnit(String dosage_type, String order_qty, String drug_code) {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String order_uom="";
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT64")) ;
			pstmt.setString(1,dosage_type);
			pstmt.setString(2,order_qty);
			pstmt.setString(3,order_qty);
			pstmt.setString(4,drug_code);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			pstmt.setString(8,locale);
			pstmt.setString(9,locale);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
					order_uom	=	(String)resultSet.getString("STOCK_UOM_DESC");
			}
		}
		catch(Exception e){
			order_uom=e.toString();
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
		return order_uom;
	}

	public String getOrderUnitCode(String dosage_type, String order_qty, String drug_code) {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String order_uom="";
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT64")) ;
			pstmt.setString(1,dosage_type);
			pstmt.setString(2,order_qty);
			pstmt.setString(3,order_qty);
			pstmt.setString(4,drug_code);
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			pstmt.setString(7,locale);
			pstmt.setString(8,locale);
			pstmt.setString(9,locale);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
					order_uom	=	(String)resultSet.getString("stock_uom");
			}
		}
		catch(Exception e){
				order_uom=e.toString();
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
		return order_uom;
	}

	public boolean checkDuplicate(ArrayList orderlist, HashMap data) {
		String start_date		=	(String)data.get("START_DATE");
		String end_date			=	(String)data.get("END_DATE");
		String drug_code		=	(String)data.get("DRUG_CODE");
		boolean duplicate		=	false;
		String tmp_start_date	=	"";
		String tmp_end_date		=	"";
		String tmp_drug_code	=	"";
		for(int i=0; i<orderlist.size(); i++) {
			ArrayList order_dtl	=	(ArrayList)orderlist.get(i);
			for(int j=0; j<order_dtl.size(); j++) {
				HashMap record	=	(HashMap)order_dtl.get(j);
				tmp_start_date	=	(String)record.get("START_DATE");
				tmp_end_date	=	(String)record.get("END_DATE");
				tmp_drug_code	=	(String)record.get("DRUG_CODE");

				if(tmp_start_date.equals(start_date) && tmp_end_date.equals(end_date) && tmp_drug_code.equals(drug_code)) {
					duplicate		=	true;
					break;
				}
			}
		}
		return duplicate;
	}

	public boolean checkDuplicate(String patient_id, String generic_id, String start_date)	{
		Connection connection	=  null ;
		PreparedStatement pstmt =  null ;
		ResultSet resultSet		=  null ;
		String sql_query		=  null ;
		int count_rx			=	0;
		boolean duplicate_yn	=	false;
		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,generic_id);
			pstmt.setString(3,start_date);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				count_rx	=	resultSet.getInt(1);
			}
			if(count_rx>0){
				duplicate_yn	=	true;
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
		return duplicate_yn;
	}

	public boolean checkDuplicateDrug(String patient_id, String generic_id,String start_date,String end_date, String freq_code, String trn_group_ref){//trn_group_ref Added for MMS_BETA_0052 [IN:046303]
		Connection connection         = null ;
        PreparedStatement pstmt       = null ;
        ResultSet resultSet           = null ;
		int count_rx				= 0;
		boolean result				=	false;
		try{
			connection				= getConnection() ;
			if(trn_group_ref==null || trn_group_ref.equals("")){ //if condition and else block added for //Added for MMS_BETA_0052 [IN:046303]
				pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13C")) ;
				pstmt.setString(1,patient_id);
				pstmt.setString(2,start_date);
				pstmt.setString(3,end_date);	// Changed for ML-BRU-SCF-0811 [IN:039394] 
				pstmt.setString(4,start_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(5,end_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(6,start_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(7,end_date);// Added for ML-BRU-SCF-0811 [IN:039394]
				pstmt.setString(8,freq_code);	
				pstmt.setString(9,generic_id);
			}
			else{ //Added for MMS_BETA_0052 [IN:046303]
				pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13D")) ;
				pstmt.setString(1,patient_id);
				pstmt.setString(2,start_date);
				pstmt.setString(3,end_date);
				pstmt.setString(4,start_date);
				pstmt.setString(5,end_date);
				pstmt.setString(6,start_date);
				pstmt.setString(7,end_date);
				pstmt.setString(8,freq_code);	
				pstmt.setString(9,generic_id);
				pstmt.setString(10,trn_group_ref);
			}
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				count_rx=resultSet.getInt(1);
			}
			if(count_rx>0){
				result	=	true;
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
		return result;
	}

	public ArrayList getRoutes(String form_code)	{
		Connection connection	=  null ;
		PreparedStatement pstmt =  null ;
		ResultSet resultSet		=  null ;
		ArrayList routes		=  new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT65")) ;
			pstmt.setString(1,form_code);
			pstmt.setString(2, locale);
			resultSet	= pstmt.executeQuery();

			while ( resultSet != null && resultSet.next() ) {
				routes.add(checkForNull(resultSet.getString("ROUTE_CODE")));
				routes.add(checkForNull(resultSet.getString("ROUTE_DESC")));
				routes.add(checkForNull(resultSet.getString("ROUTE_COLOR")));
			}
		}
		catch(Exception e){
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
		return routes;
	}

	public ArrayList getTrades(String drug_code)	{
		Connection connection	=  null ;
		PreparedStatement pstmt =  null ;
		ResultSet resultSet		=  null ;
		ArrayList trades		=  new ArrayList();
		String trade_code,sql_str;
		String trade_name		=  null;
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection			= getConnection() ;
			sql_str				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_DRUG_TRADES_SELECT");
			pstmt				= connection.prepareStatement(sql_str) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2, locale);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				trade_code	=	resultSet.getString("TRADE_ID");
				trade_name	=	resultSet.getString("TRADE_NAME");
				if(trade_code != null){
					trades.add(trade_code);
					trades.add(trade_name);
				}
			}
		}
		catch(Exception e){
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
		return trades;
	}

	public HashMap maxDurnValidation(String drug_code,String patient_class){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap durnValues			= new HashMap();
		try{
			connection = getConnection() ;
//			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT23A");
			sql_query        = "SELECT CHK_FOR_MAX_DURN_ACTION,PROMPT_MSG,MAX_DURN_VALUE,MAX_DURN_TYPE FROM OR_ORDER_CATALOG_BY_PTCL WHERE  ORDER_CATALOG_CODE=? AND PATIENT_CLASS=?";
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,patient_class);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				durnValues.put("MAX_DURN_VALUE",resultSet.getString("MAX_DURN_VALUE"));
				durnValues.put("CHK_FOR_MAX_DURN_ACTION",resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
				durnValues.put("PROMPT_MSG",resultSet.getString("PROMPT_MSG"));
				durnValues.put("MAX_DURN_TYPE",resultSet.getString("MAX_DURN_TYPE"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			if(!durnValues.containsKey("MAX_DURN_VALUE")) {
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,drug_code);
				pstmt.setString(2,"*A");
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					durnValues.put("MAX_DURN_VALUE",resultSet.getString("MAX_DURN_VALUE"));
					durnValues.put("CHK_FOR_MAX_DURN_ACTION",resultSet.getString("CHK_FOR_MAX_DURN_ACTION"));
					durnValues.put("PROMPT_MSG",resultSet.getString("PROMPT_MSG"));
					durnValues.put("MAX_DURN_TYPE",resultSet.getString("MAX_DURN_TYPE")); //added for IN18769 -03/02/2010- shyampriya
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
		return durnValues;
	}
	public String renewEndDate(String start_date,String durn_value,String repeat_durn_type) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String end_date				= "" ;
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_SELECT2")) ;
			pstmt.setString(1,start_date);
			pstmt.setString(2,durn_value);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				end_date	=	(checkForNull((String)resultSet.getString("END_DATE")));
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
		return end_date;
	}
	public String getActionText(String form_code, String route_code){ //Add this method for SKR-CRF-0006[IN029561]	
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String action_text			        = "";
		locale= getLanguageId()==null?"en":getLanguageId();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT ACTION_TEXT_LABEL FROM PH_ROUTE_FOR_FORM_LANG_VW WHERE FORM_CODE=? AND ROUTE_CODE=? and  LANGUAGE_ID=? ") ;
			
			pstmt.setString(1,form_code);
			pstmt.setString(2,route_code);
			pstmt.setString(3,locale);		

			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				action_text = checkForNull(resultSet.getString("ACTION_TEXT_LABEL"));
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
		return action_text;
	}

	public String getDurationType(String duration_type) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String durn_desc			= "";
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT8A")) ;
			pstmt.setString(1,duration_type);
			pstmt.setString(2,locale);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				durn_desc	=	(resultSet.getString("DURN_DESC"));
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
		return durn_desc;
	}

	public boolean checkAdministered(String patient_id, String encounter_id, String drug_code, String order_id) {		
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		boolean administered_yn		= false;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT71")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,drug_code);
			pstmt.setString(5,order_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				if(resultSet.getInt("COUNT") > 0 ) {
					administered_yn	=	true;
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
				es.printStackTrace();
			}
        }
		return administered_yn;
	}
	
	public ArrayList getHTWTUOM(String patient_id) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList ht_wt_uom		= new ArrayList(2);
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT79")) ;
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				ht_wt_uom.add(checkForNull(resultSet.getString("LABEL_TEXT")));				
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT87")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				if(ht_wt_uom.size()==0){
					ht_wt_uom.add(checkForNull(resultSet.getString("HEIGHT_UOM")));
					ht_wt_uom.add(checkForNull(resultSet.getString("WEIGHT_UOM")));
				}
				ht_wt_uom.add(checkForNull(resultSet.getString("HEIGHT")));
				ht_wt_uom.add(checkForNull(resultSet.getString("WEIGHT")));
				ht_wt_uom.add(checkForNull(resultSet.getString("ADDED_DATE")));				
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
		return ht_wt_uom;
	}

	public String getPractitionerType() {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String pract_type			= "";
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT22B")) ;
			pstmt.setString(1,login_by_id);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				pract_type	=	(checkForNull(resultSet.getString("PRACT_TYPE")));				
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
		return pract_type;
	}

	public ArrayList populateAllergyDetails(String generic_id,String patient_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        PreparedStatement pstmt1     = null ;
        ResultSet resultSet         = null ;
        ResultSet resultSet1         = null ;
		String sql_query			= "", allergy_alert_by="", generic_name="";
		ArrayList details			= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT58"); // a.adv_event_type = 'DA' changed as a.adv_event_type in ('DA','AD')RUT-SCF-0191.1 [IN:037367]
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,generic_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,generic_id);
			pstmt.setString(5,patient_id);
			pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_ATC_ALLERGY_GENERIC_NAME"));

			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				HashMap AllergyDetails		= new HashMap();	
				AllergyDetails.put("ALLERGY_TYPE_CODE",checkForNull(resultSet.getString("ALLERGY_TYPE_CODE")));
				AllergyDetails.put("ALLERGIC_INDICATIONS",checkForNull(resultSet.getString("ALLERGIC_INDICATIONS")));
				AllergyDetails.put("SEVERITY",checkForNull(resultSet.getString("SEVERITY")));
				AllergyDetails.put("REAC_DATE",checkForNull(resultSet.getString("REAC_DATE")));
				allergy_alert_by =checkForNull(resultSet.getString("ALLERGY_ALERT_BY"));// Added for RUT-CRF-0065.1 [IN:43255]-start
				AllergyDetails.put("ALLERGY_ALERT_BY",allergy_alert_by);
				AllergyDetails.put("CAUSATIVE_SUBSTANCE",checkForNull(resultSet.getString("CAUSATIVE_SUBSTANCE")));// Added for RUT-CRF-0065.1 [IN:43255]
				generic_name="";
				pstmt1.setString(1,generic_id);
				pstmt1.setString(2,locale);
				resultSet1			= pstmt1.executeQuery();
				if(resultSet1!=null && resultSet1.next())
					generic_name = checkForNull(resultSet1.getString("GENERIC_NAME"));
				AllergyDetails.put("GENERIC_NAME",generic_name);

				details.add(AllergyDetails);
			}
		}
		catch ( Exception e ) {
			details.add("Error"+e);
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
		return details;
	}

	public String getATCAllergyAlertGeneric(String patient_id,String generic_id){
		Connection connection       = null ;
        PreparedStatement pstmt1     = null ;
		ResultSet resultSet = null;
		String ATC_allergy="0", atc_allergy_alert_level="N";
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection = getConnection() ;
            String sql_query			= "SELECT atc_allergy_alert_level FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?"; 
			pstmt1				= connection.prepareStatement(sql_query) ;
			pstmt1.setString(1,login_facility_id);
			resultSet			= pstmt1.executeQuery();
			if(resultSet!=null && resultSet.next())
				atc_allergy_alert_level = checkForNull(resultSet.getString("atc_allergy_alert_level"),"N");
			closeResultSet( resultSet ) ;
			closeStatement( pstmt1 ) ;

			if(!atc_allergy_alert_level.equals("N")){
				pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ATC_LEVEL_ALLERGY_CHECK"));
				pstmt1.setString(1,patient_id);
				pstmt1.setString(2,generic_id);
				pstmt1.setString(3,atc_allergy_alert_level);
				resultSet			= pstmt1.executeQuery();
				if(resultSet!=null && resultSet.next())
					ATC_allergy = resultSet.getString("ATC_CHECK_EXISTS");
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				if(ATC_allergy!=null && !ATC_allergy.equals("0")){
					ATC_allergy= ATC_allergy.substring(ATC_allergy.indexOf('~')+1);
					pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_ATC_ALLERGY_GENERIC_NAME"));
					pstmt1.setString(1,generic_id);//ATC_allergy
					pstmt1.setString(2,locale);
					resultSet			= pstmt1.executeQuery();
					if(resultSet!=null && resultSet.next())
						ATC_allergy = ATC_allergy+"~"+resultSet.getString("GENERIC_NAME");
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		finally {
           	try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
        }
		return ATC_allergy;
	}

	public ArrayList getDuplicateDates(String patient_id,String drug_code, String start_date){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList duplicate_dates	= new ArrayList(2);
		String dupl_start_date			=	"";
		String dupl_end_date				=	"";
	
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_SELECT4")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,drug_code);
			pstmt.setString(3,start_date);

			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				dupl_start_date	=	checkForNull((String)resultSet.getString("START_DATE"));
				dupl_end_date	=	checkForNull((String)resultSet.getString("END_DATE"));
			}
			duplicate_dates.add(dupl_start_date);
			duplicate_dates.add(dupl_end_date);
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
		return duplicate_dates;
	}

	public String getNBPRequestAppl(String resp_pd, String rel_id, String encounter_id, String pat_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        String sql_query="";// MARDefaulting ="";  Removed for IN063877
		ResultSet resultSet = null;
		String NPBReqApplYN = "";
		try{
			connection = getConnection() ;
			sql_query      = "SELECT 'A' NBP_REQ_APPL  FROM ca_appl_task a, ca_option b WHERE a.option_id = b.option_id   AND 'A' =get_task_applicability (?, dflt_privilege_status, ?,?,?,?,?) AND a.base_module_id = 'PH' And a.APPL_TASK_ID = ?";
			pstmt		   = connection.prepareStatement(sql_query) ;
			pstmt.setString(1,"NBP_REQUEST"); //P_TASK_ID VARCHAR2,
			pstmt.setString(2, resp_pd); //P_RESP_ID
			pstmt.setString(3, rel_id); //P_PRACT_RELN_ID
			pstmt.setString(4,login_facility_id); //P_FACILITY_ID
			pstmt.setString(5, encounter_id); //P_ENCOUNTER_ID
			pstmt.setString(6, pat_id); //P_PATIENT_ID
			pstmt.setString(7,"NBP_REQUEST"); 
			resultSet	= pstmt.executeQuery();
			if(resultSet!= null && resultSet.next()) {
				NPBReqApplYN = resultSet.getString("NBP_REQ_APPL")==null?"N":resultSet.getString("NBP_REQ_APPL");
			}
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
		return NPBReqApplYN;	
	}

	public String getBilledYN(String orderId) {
		Connection connection = null;
		PreparedStatement pstmt		= null ;
		ResultSet resultSet			= null ;
		String bill_yn = "N";
		try{
			connection		= getConnection() ;
			pstmt = connection.prepareStatement("SELECT 'Y' FROM or_order_line b WHERE (b.order_id = ? or b.PARENT_ORDER_ID=?) AND b.BILL_YN ='Y' and rownum=1");
			pstmt.setString(1,orderId);
			pstmt.setString(2,orderId);
			resultSet = pstmt.executeQuery();
			if(resultSet.next())
				bill_yn = resultSet.getString(1)==null?"N":resultSet.getString(1);
		}
		catch(Exception e){
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
		return bill_yn;
	}//added for Bru-HIMS-CRF-265 [IN:032315] -- end
	
	public int getHomeLeaveYn(String encounter_id,String facility_id){//added for Bru-HIMS-CRF-093[29960] start
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		encounter_id = encounter_id.trim();
		int home_leave_count             = 0;
		try{
			connection = getConnection() ;
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_HOMELEAVE");
			pstmt				= connection.prepareStatement(sql_query) ;
			if(encounter_id == "" || encounter_id == null ||encounter_id.equals("DUMMYENCOUNTERID"))
				encounter_id = "0";
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				home_leave_count=resultSet.getInt(1);
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
		return home_leave_count;
	}

	public HashMap getHomeLeaveDates(String encounter_id,String facility_id){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		HashMap result			= new HashMap();
		String sql_query			= "";
//		String leave_from ="";  Removed for IN063877
//		String leave_to   ="";   Removed for IN063877
		
		encounter_id = encounter_id.trim();
		try{
			connection = getConnection() ;
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_HOMELEAVEDATES");
			pstmt				= connection.prepareStatement(sql_query) ;

			if(encounter_id == "" || encounter_id == null ||encounter_id.equals("DUMMYENCOUNTERID"))
				encounter_id = "0";
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				result.put("LEAVE_FR_DATE",resultSet.getString("LEAVE_FR_DATE"));
				result.put("LEAVE_TO_DATE",resultSet.getString("LEAVE_TO_DATE"));
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
		return result;
	}

	public boolean compareLeaveDates(String start_date,String end_date,String home_leave_fm,String home_leave_to) throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		boolean	result			=	false;
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_COMPARE_LEAVE_DATES")) ;
			pstmt.setString(1,start_date);
			pstmt.setString(2,home_leave_fm);
			pstmt.setString(3,home_leave_to);
			pstmt.setString(4,end_date);
			pstmt.setString(5,home_leave_fm);
			pstmt.setString(6,home_leave_to);
			pstmt.setString(7,home_leave_fm);
			pstmt.setString(8,start_date);
			pstmt.setString(9,end_date);
			pstmt.setString(10,home_leave_to);
			pstmt.setString(11,start_date);
			pstmt.setString(12,end_date);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("COUNT")>0){
					result =true;
				}				
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
		return result;
	}

	public int getHomeLeaveCHK(String sys_date,String leave_fm,String leave_to){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		int home_leave_chk             = 0;
		try{
			connection = getConnection() ;
			sql_query           = PhRepository.getPhKeyValue("SQL_PH_PRES_HOME_LEAVE_SELECT1");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,sys_date);
			pstmt.setString(2,leave_fm);
			pstmt.setString(3,leave_to);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				home_leave_chk=resultSet.getInt(1);
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
		return home_leave_chk;
	}//adding for Bru-HIMS-CRF-093[29960] -End

	public String getPregnencyYN(String patient_id){	// method added for RUT-CRF-0063 [IN:029601]
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		String  pregnency_yn		= "";
		try{
			connection		= getConnection() ;
			sql_query		= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_PREG_YN");
			pstmt			= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,getLoginFacilityId());
			resultSet		= pstmt.executeQuery();

			if(resultSet.next()){
				pregnency_yn = resultSet.getString(1);
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
		return pregnency_yn;
	}

   public String getLMPDate(String patient_id){
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet result		= null;
		String lmp_date			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("select to_char(LMP_DATE,'dd/mm/yyyy') LMP_DATE from CA_PATIENT_PREGN_DTLS where PATIENT_ID=? and PREGENANT_YN='Y' and PREGN_STATUS_IND='A'");
			pstmt.setString(1,patient_id);
			result = pstmt.executeQuery();
			if(result.next()){
				lmp_date = result.getString("LMP_DATE")==null?"":result.getString("LMP_DATE");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( result ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return lmp_date;
	}

	public double getCalPregStage(String start_date,String lmp_date){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		double preg_week =0.0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement("SELECT (TO_DATE(?,'dd/mm/yyyy hh24:mi')-TO_DATE(?,'DD/MM/YYYY'))/7 preg_week FROM DUAL") ; 
			pstmt.setString(1,start_date);
			pstmt.setString(2,lmp_date);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				preg_week=(resultSet.getFloat("preg_week"));
			}
		}
		catch(Exception es){
			es.printStackTrace();
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
		return preg_week;	
	}
	public String getTrimster(double preg_week){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String trimster ="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT_TRIMSTER")) ; 
			pstmt.setDouble(1,preg_week);
			pstmt.setDouble(2,preg_week);
			pstmt.setDouble(3,preg_week);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				trimster=(resultSet.getString("TRIMSTER"));
			}
		}
		catch(Exception es){
			es.printStackTrace();
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
		return trimster;	
	}//added for CRF RUT-CRF-0063[29601]--end
	public HashMap getPregDrugDetails(String drug_code,String trimester){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		HashMap preg_drug_details	= new HashMap();
		locale= getLanguageId()==null?"en":getLanguageId();
	
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_PREG_DRUG_DETAILS_SELECT")) ;
			pstmt.setString(1,drug_code);
			pstmt.setString(2,locale);

			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				if(trimester.equals("First Trimester")){
					preg_drug_details.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_FT")==null ? "":resultSet.getString("PREG_EFFECT_FT")));
					preg_drug_details.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_FT_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_FT_YN")));
					preg_drug_details.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE1")==null ? "":resultSet.getString("PREG_CATEGORY_CODE1")));
				}
				else if(trimester.equals("Second Trimester")){
					preg_drug_details.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_ST")==null ? "":resultSet.getString("PREG_EFFECT_ST")));
					preg_drug_details.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_ST_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_ST_YN")));
					preg_drug_details.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE2")==null ? "":resultSet.getString("PREG_CATEGORY_CODE2")));
				}
				else if(trimester.equals("Thrid Trimester")){
					preg_drug_details.put("PREG_EFFECT",(resultSet.getString("PREG_EFFECT_TT")==null ? "":resultSet.getString("PREG_EFFECT_TT")));
					preg_drug_details.put("PREG_WARN_REQ_YN",(resultSet.getString("PREG_WARN_REQ_TT_YN")==null ? "":resultSet.getString("PREG_WARN_REQ_TT_YN")));
					preg_drug_details.put("PREG_CATEGORY_CODE",(resultSet.getString("PREG_CATEGORY_CODE3")==null ? "":resultSet.getString("PREG_CATEGORY_CODE3")));
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
		return preg_drug_details;
	}

	/*Unusend methods moved from PrescriptionBean_1

	public boolean commentLinkReqd(String order_id) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		boolean link_reqd			= false ;
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT23")) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_id);

			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				if(resultSet.getInt("COUNT")>0){
					link_reqd	=	true;
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
		return link_reqd;
	}

	public ArrayList getFreqValues(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList result			= new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SLIDING_SCALE_SELECT3")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("FREQ_CODE"));
				result.add(resultSet.getString("FREQ_DESC"));
				result.add(resultSet.getString("FREQ_NATURE"));						
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
		return result;
	}	*/
	public String getSysDateTimeMSec(){//getting system date
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String SYS_DATE_TIME_MSEC				= "";

		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				SYS_DATE_TIME_MSEC = checkForNull(resultSet.getString("SYS_DATE_TIME_MSEC"));
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
		return SYS_DATE_TIME_MSEC;
	}

	public LinkedHashMap loadPrevHtWtValues(String facility_id,String patient_id,String encounter_id,String patient_class){ //Added for ML-MMOH-CRF-0346 [IN:057185]
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "", test_observ_dt_tm="",  prev_height="", prev_weight="", prev_heightUOM="", prev_weightUOM=""; //  prev_test_observ_dt_tm="", Removed for IN063877
		HashMap HeaderHtWtValues	= null;
		LinkedHashMap HeaderHtWtDtls	= new LinkedHashMap();
		int	i	=	0 ;
		boolean blEndLoop = false;
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PREV_HT_WT_RECORDS");
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,patient_class);
			resultSet			= pstmt.executeQuery();

			while(resultSet!=null && resultSet.next() && !blEndLoop) {
				test_observ_dt_tm = resultSet.getString("TEST_OBSERV_DT_TM");
				if(HeaderHtWtDtls.containsKey(test_observ_dt_tm)){
					HeaderHtWtValues = (HashMap)HeaderHtWtDtls.get(test_observ_dt_tm);
				}
				else{
					HeaderHtWtValues	= new HashMap();
					i++;
				}
				if(resultSet.getString("MNEMONIC").equals("HEIGHT") ) {
					HeaderHtWtValues.put("HEIGHT",(String)resultSet.getString("DISCR_MSR_RESULT_NUM"));
					HeaderHtWtValues.put("HEIGHT_UOM",(String)resultSet.getString("DISCR_MSR_RESULT_NUM_UOM"));
				} 
				else if( resultSet.getString("MNEMONIC").equals("WEIGHT") ){
					HeaderHtWtValues.put("WEIGHT",(String)resultSet.getString("DISCR_MSR_RESULT_NUM"));
					HeaderHtWtValues.put("WEIGHT_UOM",(String)resultSet.getString("DISCR_MSR_RESULT_NUM_UOM"));
				}
				if(i >4 && !HeaderHtWtDtls.containsKey(test_observ_dt_tm))
					blEndLoop = true;
				else
					HeaderHtWtDtls.put(test_observ_dt_tm, HeaderHtWtValues);
			}
			if(HeaderHtWtDtls.size()>0){
				ArrayList<String>  alKeys= new ArrayList<String>(HeaderHtWtDtls.keySet());
				for(int j = HeaderHtWtDtls.size()-1;j>=0; j-- ){
					HeaderHtWtValues = (HashMap)HeaderHtWtDtls.get((String)alKeys.get(j));
					if(HeaderHtWtValues.containsKey("HEIGHT")){
						prev_height=(String) HeaderHtWtValues.get("HEIGHT");
						prev_heightUOM=(String) HeaderHtWtValues.get("HEIGHT_UOM");
					}
					else{
						HeaderHtWtValues.put("HEIGHT", prev_height);
						HeaderHtWtValues.put("HEIGHT_UOM", prev_heightUOM);
					}
					if(HeaderHtWtValues.containsKey("WEIGHT")){
						prev_weight=(String) HeaderHtWtValues.get("WEIGHT");
						prev_weightUOM=(String) HeaderHtWtValues.get("WEIGHT_UOM");
					}
					else{
						HeaderHtWtValues.put("WEIGHT", prev_weight);
						HeaderHtWtValues.put("WEIGHT_UOM", prev_weightUOM);
					}
					HeaderHtWtDtls.put((String)alKeys.get(j), HeaderHtWtValues);
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
		return HeaderHtWtDtls;
	}
	
	public String getPreviousOrderStartDate(String patient_id, String generic_id,String start_date,String end_date, String freq_code){// Added for MO-CRF-20085.1 [IN057392] - Start 
		Connection connection         = null ;
        PreparedStatement pstmt       = null ;
        ResultSet resultSet           = null ;
		String result				=	"";
		try{
			connection				= getConnection() ;
				pstmt					= connection.prepareStatement("SELECT max(TO_CHAR(START_DATE,'DD/MM/YYYY HH24:MI')) START_DATE_TIME FROM  PH_PATIENT_DRUG_PROFILE A WHERE   PATIENT_ID =?  AND  (TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR TO_DATE(?,'DD/MM/YYYY HH24:MI') BETWEEN  START_DATE AND  END_DATE OR  START_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI') OR  END_DATE BETWEEN  TO_DATE(?,'DD/MM/YYYY HH24:MI') AND  TO_DATE(?,'DD/MM/YYYY HH24:MI')) AND DISCONT_DATE_TIME IS NULL AND ON_HOLD_DATE_TIME IS NULL AND  CANCEL_YN='N' AND   STOP_YN='N' AND 'O'!=(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE=?) AND GENERIC_ID=? ") ; 
				pstmt.setString(1,patient_id);
				pstmt.setString(2,start_date);
				pstmt.setString(3,end_date);	 
				pstmt.setString(4,start_date);
				pstmt.setString(5,end_date);
				pstmt.setString(6,start_date);
				pstmt.setString(7,end_date);
				pstmt.setString(8,freq_code);	
				pstmt.setString(9,generic_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				result=resultSet.getString("START_DATE_TIME");
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
		return result;
	} // Added for MO-CRF-20085.1 [IN057392] - End
	
	public boolean isSiteSpecific(String moduleId, String functionalityId){ //Added for MO-CRF-20103 [IN:055441] - Start
		boolean site=false;
	    Connection con	= null;  
        try{
        	con =			getConnection();		
        	site = eCommon.Common.CommonBean.isSiteSpecific(con,moduleId,functionalityId);	
		}
        catch(Exception e){
            e.printStackTrace();
        }
		finally{
			try{
			closeConnection(con);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return site;
   } //Added for MO-CRF-20103 [IN:055441] - End
	//added for ml-mmoh-crf-0863 start
	public String getAuthAmendPres(String disp_locn_code) {
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query=null;
		String auth_amend_pres_yn			= "";
		try{
			connection				= getConnection() ;
			
			sql_query= PhRepository.getPhKeyValue("SELECT_AUTH_AMEND_PRES") ;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1, login_facility_id) ;
			pstmt.setString(2, disp_locn_code) ;
			pstmt.setString(3, login_by_id) ;
			pstmt.setString(4, language_id);

			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null && resultSet.next()){
				auth_amend_pres_yn	=	resultSet.getString("AUTH_AMEND_PRES_YN");
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
		return auth_amend_pres_yn;
	}
	//added for ml-mmoh-crf-0863 end
	//added for ml-mmoh-crf-0978 start
	public String getUOMDesc (String uom_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String short_desc		= "";
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "select SHORT_DESC from am_uom_lang_vw where UOM_CODE=? and  LANGUAGE_ID=?") ;
			pstmt.setString(1,uom_code);
			pstmt.setString(2,language_id);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				short_desc = resultSet.getString("SHORT_DESC");				
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
		return short_desc;
	}
	//added for ml-mmoh-crf-0978 end
	public HashMap getHgtWgtDtlsDefault(String patient_id){ //added for ml-mmoh-0862
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sql_query			= "";
		HashMap discr_values		= new HashMap();
		try{
			connection			= getConnection() ;
			sql_query			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT101_default");
			//int index	 =	sql_query.lastIndexOf('?');
			//sql_query = sql_query.substring(0,index)+"'HEIGHT','WEIGHT'"+sql_query.substring(index+1);
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,patient_id);
			resultSet			= pstmt.executeQuery();
			int i=0;
			while ( resultSet != null && resultSet.next() ) {
				if(i==0)
				{	if(resultSet.getString(3).equalsIgnoreCase("height"))
						discr_values.put("HEIGHT",checkForNull(resultSet.getString(2),"cm"));
				else{
					discr_values.put("WEIGHT",checkForNull(resultSet.getString(2),"kg"));
				}
				}
				else if(i==1)
					
					{
					if(resultSet.getString(3).equalsIgnoreCase("weight"))
						discr_values.put("WEIGHT",checkForNull(resultSet.getString(2),"kg"));
					else{
						discr_values.put("HEIGHT",checkForNull(resultSet.getString(2),"cm"));
					}
					}
				i++;
			}
		}catch ( Exception e ) {
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
		return discr_values;
	}
	public int getSupportDrugCount(String drug_code){//Adding start for TH-KW-CRF-0007

		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		ArrayList supportDrugs		= new ArrayList();
		int supp_count              =0;
		ArrayList presDetails	    = (ArrayList) presBean_1.getpresDetails();
		HashMap drugDetails         =new HashMap();
		String  sel_drug_code ="";
		String supp_drug_code ="";
		boolean drug_found          = false;
            
		try{
			connection				= getConnection() ;
			String str_qry			= "SELECT SUPPORTIVE_DRUG_CODE FROM PH_SUPPORTIVE_DRUGS WHERE PARENT_DRUG_CODE =? ";
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,drug_code);
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
              for(int i=0;i<presDetails.size();i++){
				    drug_found          = false;
				   drugDetails = (HashMap)presDetails.get(i);
                   sel_drug_code = (String)drugDetails.get("DRUG_CODE");
                   supp_drug_code =(String)resultSet.getString("SUPPORTIVE_DRUG_CODE");
				   if(sel_drug_code.equals(supp_drug_code))
		     		    drug_found =true;
			   }
			   System.err.println("drug_found=="+drug_found+"supportDrugs=="+supportDrugs+"getSuppDrugList=="+getSuppDrugList()+"supp_drug_code=="+supp_drug_code);
			  if(!drug_found && !supportDrugs.contains(supp_drug_code) && !getSuppDrugList().contains(supp_drug_code)){
				       supportDrugs.add(resultSet.getString("SUPPORTIVE_DRUG_CODE"));
			       }
			  
			}
			supp_count = supportDrugs.size();
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
		return supp_count;
		 
	}
	public ArrayList getSupportdrugList(String drug_code)
	{
        Connection con			= null;  
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String  strength  ="";
		String strength_value="";
		ArrayList supDrugDetails = new ArrayList();
		ArrayList presDetails	    = (ArrayList) presBean_1.getpresDetails();
		HashMap drugDetails         =new HashMap();
		String  sel_drug_code ="";
		String supp_drug_code ="";
		boolean drug_found          = false;
		try{
		con = getConnection() ;
		pstmt				= con.prepareStatement("SELECT A.DRUG_CODE, A.DRUG_DESC, A.GENERIC_ID, C.GENERIC_NAME, A.FORM_CODE, B.FORM_DESC, A.PRES_BASE_UOM, D.SHORT_DESC, E.ROUTE_DESC, A.STRENGTH_PER_PRES_UOM,A.STRENGTH_UOM,A.STRENGTH_PER_VALUE_PRES_UOM FROM PH_DRUG A, PH_FORM B, PH_GENERIC_NAME C, AM_UOM D, PH_ROUTE E,ph_supportive_drugs S WHERE A.DRUG_CODE =S.SUPPORTIVE_DRUG_CODE AND A.FORM_CODE=B.FORM_CODE(+)  AND A.GENERIC_ID=C.GENERIC_ID(+) AND A.PRES_BASE_UOM=D.UOM_CODE (+) AND A.ROUTE_CODE =E.ROUTE_CODE(+) AND S.PARENT_DRUG_CODE =? AND A.DISCONTINUED_YN='N'");
		pstmt.setString(1,drug_code);
				resultSet	= pstmt.executeQuery();
				while  ( resultSet.next() ) {
					for(int i=0;i<presDetails.size();i++){
						  drug_found          = false;
				          drugDetails = (HashMap)presDetails.get(i);
                          sel_drug_code = (String)drugDetails.get("DRUG_CODE");
                          supp_drug_code =(String)resultSet.getString("DRUG_CODE");
				      if(sel_drug_code.equals(supp_drug_code))
		     		      drug_found =true;
					} 
					if(!drug_found && !supDrugDetails.contains(supp_drug_code) && !getSuppDrugList().contains(supp_drug_code)){	
						supDrugDetails.add(resultSet.getString( "DRUG_DESC"));
						supDrugDetails.add(resultSet.getString( "DRUG_CODE"));
						supDrugDetails.add(resultSet.getString( "GENERIC_NAME"));
						supDrugDetails.add(resultSet.getString( "FORM_DESC"));
						supDrugDetails.add(resultSet.getString( "ROUTE_DESC"));
					if (resultSet.getString("STRENGTH_PER_PRES_UOM")!=null && !(resultSet.getString("STRENGTH_PER_PRES_UOM")).equals("0") ){
						strength=resultSet.getString("STRENGTH_PER_PRES_UOM");
						
						if(strength!=null && !strength.equals("") && Float.parseFloat(strength) <1){
							strength = Float.parseFloat(strength)+"";
						}
						strength_value	= strength+" "+resultSet.getString("STRENGTH_UOM")+" / "+resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")+" "+resultSet.getString("SHORT_DESC");						
					}
					else {
                         strength_value="";
					}
					supDrugDetails.add(strength_value);
				}
		   }
	}
		catch(Exception e){
			e.printStackTrace() ;
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( con );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		
			return supDrugDetails;	
	}
	public void setSuppDrugMap(String parent_drug,ArrayList suppList){
		 if(!suppDrugMap.containsKey(parent_drug))
			 this.suppDrugMap.put(parent_drug,suppList);
	}
	public HashMap getSuppDrugMap(){
		 return suppDrugMap;
	}
	public ArrayList getSuppDrugList(){
		 return suppDrugList;
	}
	public void setSelSuppList(String parent_drug,String selected_drugs){
		StringTokenizer stSelDrugs = new StringTokenizer(selected_drugs,"~");
		ArrayList selSuppList = new ArrayList();
		String sel_supp_drug ="";
		while(stSelDrugs.hasMoreTokens()){
			sel_supp_drug = stSelDrugs.nextToken();
			selSuppList.add(sel_supp_drug);
			if(!getSuppDrugList().contains(sel_supp_drug))
			    suppDrugList.add(sel_supp_drug); 
		}
		 
		 setSuppDrugMap(parent_drug,selSuppList);
	}//Adding end for TH-KW-CRF-0007

	public String defaultDispLocnSelectAppl(){//Adding start for NMC-JD-SCF-0324
		Connection connection = null ;
		
		boolean default_disp_locn_select_appl		=false;
		String def_disp_locn_appl_yn ="N";
		try {
			connection = getConnection() ;
			default_disp_locn_select_appl = eCommon.Common.CommonBean.isSiteSpecific(connection,"PH","PH_DISP_LOCN_SELECT_APPL");
			if(default_disp_locn_select_appl)
				def_disp_locn_appl_yn ="Y";
			else
				def_disp_locn_appl_yn ="N";
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return def_disp_locn_appl_yn;
	}//Adding end for NMC-JD-SCF-0324
	
	//Added for ML-MMOH-CRF-2115 - start
	public String getTaperSeqNo(String order_id,int methodType){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String result		= "";
		try {
            connection	= getConnection() ;
            if(methodType == 1){
			pstmt		= connection.prepareStatement("select TAPER_SEQ_NO from or_order_line_ph where order_id= ?") ;
            }else if(methodType == 2){
            	pstmt		= connection.prepareStatement("SELECT COUNT(ol.TAPER_SEQ_NO) TAPER_SEQ_NO_COUNT FROM or_order_line_ph ol JOIN or_order o1 ON ol.order_id = o1.order_id WHERE o1.trn_group_ref = (SELECT trn_group_ref FROM or_order WHERE order_id = ? AND order_status != 'CN') AND o1.order_status != 'CN'") ;
            }
			pstmt.setString(1,order_id);
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				 if(methodType == 1){
					 result = resultSet.getString("TAPER_SEQ_NO");		
				 }else if(methodType == 2){
					 result = resultSet.getString("TAPER_SEQ_NO_COUNT");
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
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		System.err.println("result  "+result);
		return result;
	}
	//Added for ML-MMOH-CRF-2115 -end
	
}