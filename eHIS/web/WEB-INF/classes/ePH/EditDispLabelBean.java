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
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;


public class EditDispLabelBean extends PhAdapter implements Serializable {

	private String sFunctionId	= "" ;
	private String source			= "" ;
	private String user_name		= "";
	protected String appl_user_id	= "";
	private String password			= "";
	private String disp_locn_code = "";
	private String allow_edit_disp_label = "N";//Added for Bru-HIMS-CRF-414 [IN045554] 
	private String editableLabelLangId = "";//Added for Bru-HIMS-CRF-414 [IN045554] 
	private boolean labelExists = false;//Added for Bru-HIMS-CRF-414 [IN045554] 

	public EditDispLabelBean(){
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void doCommon() throws Exception {
	}

	public void setSFunctionId(String sFunctionId){
		if(sFunctionId != null)
			this.sFunctionId	=	sFunctionId;
		else
			sFunctionId		= "";
	}

	public String getSFunctionId(){
		return this.sFunctionId;
	}

	public String getSource(){
		return this.source;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getUserName(){
		return this.user_name;
	}

	public void setUserName(String user_name){
		this.user_name = user_name;
	}

	//To set and get the password
	public String getPassword(){
		return this.password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setApplPassword(String appl_user_id) {
		this.appl_user_id	=	appl_user_id;
	}

	public String getApplPassword(){
		return this.appl_user_id;
	}

	public void setDispLocnCode(String disp_locn_code){
		this.disp_locn_code = disp_locn_code;
	}

	public String getDispLocnCode(){
		return this.disp_locn_code;
	}
	public String getAllowEditDispLabel() { //Added for Bru-HIMS-CRF-414 [IN045554] -start
		return allow_edit_disp_label;
	}
	public void setAllowEditDispLabel(String allow_edit_disp_label) {
		this.allow_edit_disp_label = allow_edit_disp_label;
	} 
	public String getEditableLabelLangId() {
		return editableLabelLangId;
	}
	public void SetEditableLabelLangId(String editableLabelLangId) {
		this.editableLabelLangId = editableLabelLangId;
	} 
	public boolean getLabelExists() {
		return labelExists;
	}
	public void setLabelExists(boolean labelExists) {
		this.labelExists = labelExists;
	} //Added for Bru-HIMS-CRF-414 [IN045554]  [IN045177] end 

	public String getLocalInstr(String instr,String lang_id){	//This function add for SRR20056-SCF-6260[Incident No.25586]
		Connection oConnection			    = null;
		ResultSet oResultSet				= null;
		PreparedStatement oPrepStatement	= null;
		String sLabelTextID					= instr;
		String sLocalLabelText				= "";
		try {
			oConnection	= getConnection() ;/*
			oPrepStatement	= oConnection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EDIT_LABEL_TEXT_ID_SELECT"));

			oPrepStatement.setString(1,instr);
			oResultSet	= oPrepStatement.executeQuery();

			if(oResultSet!=null && oResultSet.next())
			{
				sLabelTextID	= oResultSet.getString("LABEL_TEXT_ID");
				
			}
			else
			{
				 sLocalLabelText = instr;
				 return sLocalLabelText;
			}
			closeResultSet( oResultSet ) ;
			closeStatement( oPrepStatement ) ;
*/
			oPrepStatement	= oConnection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EDIT_LABEL_TEXT_SELECT"));
			
			oPrepStatement.setString(1,sLabelTextID);
			oPrepStatement.setString(2,lang_id);
			oResultSet	= oPrepStatement.executeQuery();

			if(oResultSet!=null && oResultSet.next()){
				sLocalLabelText	= oResultSet.getString("LABEL_TEXT_1");
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPrepStatement ) ;
				closeConnection( oConnection ); 
			}catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
		return sLocalLabelText;
	}

	public ArrayList checkToProceed(String facility_id){
		ArrayList result		= new ArrayList();
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		try {
			connection = getConnection() ;
			boolean proceed			= false;
			String disp_locn_code	= "";
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT31") ) ;
			pstmt.setString(1,login_by_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ){
				setUserName(resultSet.getString("APPL_USER_NAME"));
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			//// Get the logged in user password
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT81")) ;
			pstmt.setString(1,login_by_id);			
			resultSet	= pstmt.executeQuery() ;

			if (resultSet.next()){
				setApplPassword(resultSet.getString("PIN_NO"));			
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

			//			CHECK WHETHER LOGGED-IN USER IS PHARMACIST OR NOT.

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT1") ) ;
			pstmt.setString(1,login_by_id.trim());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ) {
				proceed	= true ;
			}
			else{
				result.add("NO DISPLAY-1");
				return result;
			}

//			CHECK WHETHER OR MODULE IS INSTALLED OR NOT.

			if (proceed){
				proceed = false ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT2") ) ;
				resultSet = pstmt.executeQuery() ;

				if ( resultSet.next() ){
					proceed = true ;
				}
				else{
					result.add("NO DISPLAY-2");
					return result;
				}
			}

//			CHECK WHETHER LOGGED-IN WORKSTATION NO. MAPS WITH THE WS_NO IN PH_WS_NO_FOR_DISP_LOCN
			if (proceed){
				proceed = false ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT3") ) ;

				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,login_at_ws_no.trim());
				resultSet = pstmt.executeQuery() ;

				if (resultSet.next()) {
					disp_locn_code = disp_locn_code + " AND (A.DISP_LOCN_CODE = '" + resultSet.getString("DISP_LOCN_CODE") + "' OR ";
					while ( resultSet.next() ){
						disp_locn_code = disp_locn_code + "A.DISP_LOCN_CODE = '";
						disp_locn_code = disp_locn_code + resultSet.getString("DISP_LOCN_CODE") + "' OR ";
					}
					disp_locn_code = disp_locn_code.substring(0, disp_locn_code.length()-4);
					disp_locn_code = disp_locn_code + ") ORDER BY 1";
					proceed = true ;
				}
				else{
					result.add("NO DISPLAY-3");
					return result;
				}
			}

//			CHECK WHETHER EDIT DISPENSE LABEL PARAMETER IS CHECKED IN PH PARAMETER FOR FACILITY

			if (proceed){
				proceed = false ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				pstmt = connection.prepareStatement("Select EDIT_DISP_LABEL_AFTER_DEL from ph_facility_param where facility_id = ?" ) ;
				pstmt.setString(1,facility_id.trim());
				resultSet = pstmt.executeQuery() ;
				if(resultSet.next())
				if ( resultSet.getString("EDIT_DISP_LABEL_AFTER_DEL").equals("Y")) {
					proceed = true ;
				}
				else{
					result.add("NO DISPLAY-4");
					return result;
				}
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
		 result.add("DISPLAY");
		 return result;
	}

	public ArrayList getDispLocs(String facility_id){
		ArrayList result		= new ArrayList();
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT DISTINCT A.DISP_LOCN_CODE CODE,B.SHORT_DESC  FROM PH_WS_NO_FOR_DISP_LOCN A,  PH_DISP_LOCN_LANG_VW B WHERE A.DISP_LOCN_CODE = B.DISP_LOCN_CODE AND A.FACILITY_ID=? AND A.WS_NO=? and language_id =? ORDER BY SHORT_DESC") ;
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,login_at_ws_no.trim());
			pstmt.setString(3,getLanguageId());

			resultSet = pstmt.executeQuery() ;	
			while(resultSet.next()){
				result.add(resultSet.getString("CODE"));
				result.add(resultSet.getString("SHORT_DESC"));
			}

		}
		catch ( Exception e ){
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
		return result;
	}
		
	public boolean validateThePassword()throws Exception{
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		try{
			connection	= getConnection() ;
		    pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT27") ) ;
			pstmt.setString(1,login_by_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				if((resultSet.getString("PASSWORD")).equals(getPassword().trim())){
					return true;
				}
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
				System.err.println("Error::"+es);
			}
		}
		return false;
	}

//getting system date
	public String getSysdate(){
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
				sys_date	=	resultSet.getString("SYS_DATE");
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
		return sys_date;
	}

//To get the length of patient_id
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
		}
		catch(Exception e){
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

	public ArrayList getDispenseDetails(String patient_id, String dispense_no, String dispense_date, String facility_id){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList result		= new ArrayList();
		String sql ="";
		try{
			connection			= getConnection() ;
			//sql = "select a.patient_id, patient_name, disp_no, to_char(a.DISPENSED_DATE_TIME,'dd/mm/yyyy hh24:mi') DISP_DATE_TIME from ph_disp_hdr a,mp_patient b where a.patient_id=b.patient_id and a.disp_no = nvl(?,a.disp_no) and a.patient_id = nvl(?,a.patient_id) and a.DISP_DATE_TIME = nvl(to_date(?,'dd/mm/yyyy'),a.DISP_DATE_TIME) and facility_id=? and disp_locn_code = ?";
			//	sql="SELECT a.patient_id, disp_no, patient_name,to_char(a.DISPENSED_DATE_TIME,'dd/mm/yyyy hh24:mi')DISPENSED_DATE_TIME,to_char(a.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi')ORD_DATE_TIME,c.SHORT_NAME pract_name,a.order_id order_id  FROM ph_disp_hdr a, mp_patient b,am_practitioner_lang_vw c WHERE a.patient_id = b.patient_id  and  a.PRES_PHYSICIAN_ID =c.PRACTITIONER_ID and c.language_id =?  AND a.disp_no = NVL (?, a.disp_no)  AND a.patient_id = NVL (?, a.patient_id) AND a.disp_date_time = NVL (to_date(?,'dd/mm/yyyy'), a.disp_date_time) AND facility_id = ?  AND disp_locn_code = ?";
			//sql="SELECT a.patient_id, disp_no, patient_name,to_char(a.DISPENSED_DATE_TIME,'dd/mm/yyyy hh24:mi')DISPENSED_DATE_TIME,to_char(a.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi')ORD_DATE_TIME,c.SHORT_NAME pract_name,a.order_id order_id, d.iv_prep_yn  FROM ph_disp_hdr a, mp_patient b,am_practitioner_lang_vw c, or_order d WHERE a.patient_id = b.patient_id  and a.order_id=d.order_id and nvl(d.iv_prep_yn,'X') not in('2','4','6','7','8','0') and  a.PRES_PHYSICIAN_ID =c.PRACTITIONER_ID AND a.facility_id = ? AND a.disp_locn_code = ?  ";
			//Modified Above Query  for getting Patient name in to thai regarding incident num:25474 on 15/DEC/2010==By Sandhya
			sql="SELECT a.patient_id, a.disp_no, a.PATIENT_CLASS, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG), b.patient_name)patient_name, to_char(a.DISPENSED_DATE_TIME,'dd/mm/yyyy hh24:mi') DISPENSED_DATE_TIME, to_char(a.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi')ORD_DATE_TIME,c.PRACTITIONER_NAME pract_name,a.order_id order_id, d.iv_prep_yn  FROM ph_disp_hdr a, mp_patient b,am_practitioner_lang_vw c, or_order d WHERE a.patient_id = b.patient_id  and a.order_id=d.order_id and nvl(d.iv_prep_yn,'X') not in('2','4','6','7','8','0') and  a.PRES_PHYSICIAN_ID =c.PRACTITIONER_ID AND a.facility_id = ? AND a.disp_locn_code = ?  ";   

			if(dispense_date!=null && !(dispense_date.equals("")))
				sql=sql+"AND a.disp_date_time = TO_DATE (?, 'dd/mm/yyyy')";
			if(patient_id!=null && !(patient_id.equals("")))
				sql=sql+"AND a.patient_id =? ";
			if(dispense_no!=null && !(dispense_no.equals("")))
				sql=sql+"AND a.disp_no =? ";
			sql=sql+"AND c.language_id = ? order by disp_no, a.DISPENSED_DATE_TIME desc"; //ADDed order by disp no for the incident num:26097==By Sandhya ===31/Jan/2011
			pstmt				= connection.prepareStatement(sql) ;
			int pstmtcount=1;				
			pstmt.setString(pstmtcount,language_id);
			pstmt.setString(++pstmtcount,facility_id.trim());
			pstmt.setString(++pstmtcount,getDispLocnCode());
			if(dispense_date!=null && !(dispense_date.equals("")))
				pstmt.setString(++pstmtcount,dispense_date);
			if(patient_id!=null && !(patient_id.equals("")))
				pstmt.setString(++pstmtcount,patient_id);
			if(dispense_no!=null && !(dispense_no.equals("")))
				pstmt.setString(++pstmtcount,dispense_no);
			pstmt.setString(++pstmtcount,language_id);
			resultSet	= pstmt.executeQuery(); 

			while( resultSet.next() ){
				result.add(checkForNull(resultSet.getString("PATIENT_ID")));
				result.add(checkForNull(resultSet.getString("PATIENT_NAME")));
				result.add(checkForNull(resultSet.getString("DISP_NO")));
				result.add(checkForNull(resultSet.getString("DISPENSED_DATE_TIME")));
				result.add(checkForNull(resultSet.getString("ORD_DATE_TIME")));
				result.add(checkForNull(resultSet.getString("PRACT_NAME")));
				result.add(checkForNull(resultSet.getString("order_id")));
				result.add(checkForNull(resultSet.getString("iv_prep_yn")));
				result.add(checkForNull(resultSet.getString("PATIENT_CLASS"))); //Added for Bru-HIMS-CRF-414 [IN:045554]
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

	public ArrayList getEditDetails(String dispense_no) throws Exception{
		ArrayList result = new ArrayList();
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null;

		try {
			connection = getConnection() ;
			String sql = "select DISP_NO, SRL_NO, a.ORDER_ID, a.ORDER_LINE_NO, LABEL_CAU_INSTRN1_ENG, LABEL_SPL_INSTRN1_ENG, LABEL_PAT_INSTRN1_ENG, LABEL_CAU_INSTRN1_LOC, LABEL_SPL_INSTRN1_LOC, LABEL_PAT_INSTRN1_LOC,ORDER_QTY, ORDER_UOM,(select  to_char(EXPIRY_DATE,'dd/mm/yyyy') from ph_disp_drug_batch where  DISP_NO=a.disp_no and  SRL_NO=a.SRL_NO and rownum<2) exp_date,c.short_desc drug_desc,c.item_code drug_code, pres_remark_code,a.disp_qty,a.stk_uom_code, a.drug_indication from ph_disp_dtl a,or_order_line b,mm_item_lang_vw c where a.order_id= b.order_id and a.ORDER_LINE_NO =ORDER_LINE_NUM and a.disp_no =? and a.disp_drug_code = c.item_code and language_id =? order by srl_no";  // a.drug_indication Added For ML-BRU-CRF-072[Inc:29938]
			//replace b.order_catalog_code with a.disp_drug_code and added newly a.disp_qty,a.stk_uom_code added for ML-BRU-SCF-0179 [IN:032578]
			 pstmt = connection.prepareStatement( sql ) ;
	
			pstmt.setString(1,dispense_no);
			pstmt.setString(2,getLanguageId());			
			resultSet = pstmt.executeQuery() ;

			while( resultSet.next() ){
				result.add(checkForNull(resultSet.getString("DISP_NO")));
				result.add(checkForNull(resultSet.getString("SRL_NO")));
				result.add(checkForNull(resultSet.getString("ORDER_ID")));
				result.add(checkForNull(resultSet.getString("ORDER_LINE_NO")));
				result.add(checkForNull(resultSet.getString("LABEL_CAU_INSTRN1_ENG")));
				result.add(checkForNull(resultSet.getString("LABEL_SPL_INSTRN1_ENG")));
				result.add(checkForNull(resultSet.getString("LABEL_PAT_INSTRN1_ENG")));
				result.add(checkForNull(resultSet.getString("LABEL_CAU_INSTRN1_LOC")));
				result.add(checkForNull(resultSet.getString("LABEL_SPL_INSTRN1_LOC")));
				result.add(checkForNull(resultSet.getString("LABEL_PAT_INSTRN1_LOC")));
				result.add(checkForNull(resultSet.getString("ORDER_QTY")));
				result.add(checkForNull(resultSet.getString("ORDER_UOM")));
				result.add(checkForNull(resultSet.getString("EXP_DATE")));
				result.add(checkForNull(resultSet.getString("DRUG_DESC")));
				result.add(checkForNull(resultSet.getString("DRUG_CODE")));
				result.add(checkForNull(resultSet.getString("PRES_REMARK_CODE")));
				result.add(checkForNull(resultSet.getString("disp_qty"))); // newly added for ML-BRU-SCF-0179 [IN:032578]
				result.add(checkForNull(resultSet.getString("stk_uom_code")));// newly added for ML-BRU-SCF-0179 [IN:032578]
				result.add(checkForNull(resultSet.getString("DRUG_INDICATION")));//Added For ML-BRU-CRF-072[Inc:29938]
			}
		} 
		catch ( Exception e ){
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

	public HashMap loadLabels(){
		HashMap labels			  = new HashMap();		
		ArrayList caution		  = new ArrayList();
		ArrayList spl_instruction = new ArrayList();
		ArrayList spl_instruction2 = new ArrayList();

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;        
		HashMap data = null;
		
		try{
		connection			= getConnection() ;
		/*********** Initialize the values for Caution***************/
		pstmt		= null;
		resultSet	= null;
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT8") ) ;
		pstmt.setString(1,getLanguageId());
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			data=new HashMap();
			data.put( "label_text_id",resultSet.getString( "label_text_id" ) ) ;
			data.put( "label_text_1",resultSet.getString( "label_text_1" ) ) ;
			data.put( "label_text_2",resultSet.getString( "label_text_2" ) ) ;
			caution.add(data);
		}
		closeStatement(pstmt);
		closeResultSet(resultSet);
		
		/*********** Initialize the values for Special Instruction***************/
		pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9") ) ;
		pstmt.setString(1,getLanguageId());
		resultSet	= pstmt.executeQuery();
		while ( resultSet != null && resultSet.next() ) {
			data=new HashMap();
			data.put( "label_text_id",resultSet.getString( "label_text_id" ) ) ;
			data.put( "label_text_1",resultSet.getString( "label_text_1" ) ) ;
			spl_instruction.add(data);
		}
		closeStatement(pstmt);
		closeResultSet(resultSet);

	// Added by Senthil kumar J on 15/4/2004
	/*********** Initialize the values for Special Instruction2***************/
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT9A") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				data=new HashMap();
				data.put( "label_text_id",resultSet.getString( "LABEL_TEXT_ID" ) ) ;
				data.put( "label_text_2",resultSet.getString( "LABEL_TEXT_2" ) ) ;
				spl_instruction2.add(data);
			}
	//  ended...	
		} 
		catch ( Exception e )	{
			labels.put( "erorr :",e.toString());
			try{
				e.printStackTrace() ;
				throw e ;
			}
			catch(Exception es){
				es.printStackTrace();
			}
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
		labels.put( "caution",caution );
		labels.put( "spl_instruction",spl_instruction );
		labels.put( "spl_instruction2",spl_instruction2 );
		return labels;
	}

	public ArrayList getPrescriptionRemarks(String drug_code) { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	pres_remark		=	new ArrayList() ;

		try{       
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT158"));
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			resultSet	        = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {               
				pres_remark.add(resultSet.getString("REMARK_CODE"));
				pres_remark.add(resultSet.getString("REMARK_DESC"));
				pres_remark.add(resultSet.getString("DEFAULT_REMARK_YN"));
			}
		}
		catch(Exception e){
				System.err.println(e);
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
		return pres_remark;	
	}	

	public String getPrescriptionRemark(String order_id,String order_line_num) { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		String pres_remark_code     =   "";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT160"));
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,getLanguageId());//Added for ICN:34205
			resultSet	        = pstmt.executeQuery();
			
			if( resultSet != null && resultSet.next() ) {
				pres_remark_code= resultSet.getString("ORDER_LINE_FIELD_VALUE")==null?"":resultSet.getString("ORDER_LINE_FIELD_VALUE");			
							
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
		return pres_remark_code;	
	}	

	public boolean modify(ArrayList edit_details) throws Exception{
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		PreparedStatement pstmt_insert		=	null ;
		String dispense_no = (String) edit_details.get(0);
		String allow_edit_disp_label = getAllowEditDispLabel();  //Added for Bru-HIMS-CRF-414 [IN045554] -start
		PreparedStatement pstmt_disp_label_select_count	= null;
		PreparedStatement pstmtDispLabelInsert	= null;
		PreparedStatement pstmtDispLabelUpdate	= null;
		ResultSet  rsLablCount=null ;
		int[] ph_disp_dtl_update;
		boolean success = false;
		try{
			connection			= getConnection() ;
			//removed LABEL_BMS_REMARKS_ENG for ML-MMOH-SCF-2167
			String sql_modify ="Update ph_disp_dtl set LABEL_CAU_INSTRN1_ENG =?, LABEL_SPL_INSTRN1_ENG = ?, LABEL_PAT_INSTRN1_ENG =?, LABEL_CAU_INSTRN1_LOC =?, LABEL_SPL_INSTRN1_LOC =?, LABEL_PAT_INSTRN1_LOC = ?, PRES_REMARK_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE= SYSDATE, MODIFIED_AT_WS_NO = ?, DRUG_INDICATION=?,MODIFIED_FACILITY_ID = ? where disp_no = ? and  srl_no = ?";// DRUG_INDICATION=? Added For ML-BRU-CRF-072[Inc:29938]//added for LABEL_BMS_REMARKS_ENG=? removed for ml-mmoh-scf-2167 jd-crf-0221
			pstmt				= connection.prepareStatement(sql_modify);
			int m=0;
			if(allow_edit_disp_label.equals("Y")){
			//	String facility_id = (String) edit_details.get(2);  Removed for IN063877
			//	String editableLabelLangId = (String) edit_details.get(3);  Removed for IN063877
				pstmt_disp_label_select_count	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_SELECT_COUNT") );
				pstmtDispLabelInsert	= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_INSERT")) ;
				pstmtDispLabelUpdate	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_EDIT_LABEL_UPDATE") );
				int icount = 1, iLblCount=0, updateCount=0, insertCount=0 ;
				for(int i=4; i < edit_details.size(); i+=8){
					iLblCount =0;
					pstmt_disp_label_select_count.setString(1,(String)edit_details.get(2));
					pstmt_disp_label_select_count.setString(2, dispense_no);
					pstmt_disp_label_select_count.setString(3, (String)edit_details.get(i)); 
					pstmt_disp_label_select_count.setString(4,(String)edit_details.get(3));
					rsLablCount = pstmt_disp_label_select_count.executeQuery();
					if(rsLablCount!=null && rsLablCount.next()){
						iLblCount = rsLablCount.getInt("LBLCOUNT");
					}
					closeResultSet( rsLablCount ) ;//common-icn-0029
					if(iLblCount>0){
						icount=1;
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(i+1));
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(i+2));
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(i+3));
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(i+6));
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(i+7));
						pstmtDispLabelUpdate.setString(icount++,login_by_id);
						pstmtDispLabelUpdate.setString(icount++,login_at_ws_no);
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(2));
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(2));
						pstmtDispLabelUpdate.setString(icount++, dispense_no);
						pstmtDispLabelUpdate.setString(icount++, (String)edit_details.get(i));
						pstmtDispLabelUpdate.setString(icount++,(String)edit_details.get(3));
						pstmtDispLabelUpdate.addBatch();
						updateCount++;
					}
					else{
						icount=1;
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(2));
						pstmtDispLabelInsert.setString(icount++, dispense_no);
						pstmtDispLabelInsert.setString(icount++, (String)edit_details.get(i));
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(3));
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(i+4));
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(i+5));
						pstmtDispLabelInsert.setString(icount++, (String)edit_details.get(i+1));
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(i+2));
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(i+3));
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(i+6));
						pstmtDispLabelInsert.setString(icount++,(String)edit_details .get(i+7));
						pstmtDispLabelInsert.setString(icount++,login_by_id);
						pstmtDispLabelInsert.setString(icount++,login_at_ws_no);
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(2));
						pstmtDispLabelInsert.setString(icount++,login_by_id);
						pstmtDispLabelInsert.setString(icount++,login_at_ws_no);
						pstmtDispLabelInsert.setString(icount++,(String)edit_details.get(2));
						pstmtDispLabelInsert.addBatch();
						insertCount++;
					}
				}
				if(insertCount>0){
					int[] resultInsert=pstmtDispLabelInsert.executeBatch();
					for (int k=0;k<resultInsert.length ;k++ ){
						success = true;
						if(resultInsert[k]<0  && resultInsert[k] != -2 ){
							pstmtDispLabelInsert.cancel();
							connection.rollback();
							success = false;
							throw new Exception("Insert Dispense Label failed");
						}		
					}
				}
				if(updateCount>0){
					int[] resultUpdate=pstmtDispLabelUpdate.executeBatch();
					for (int k=0;k<resultUpdate.length ;k++ ){
						success = true;
						if(resultUpdate[k]<0  && resultUpdate[k] != -2 ){
							pstmtDispLabelUpdate.cancel();
							connection.rollback();
							success = false;
							throw new Exception("Update Dispense Label failed");
						}		
					}
				}
			}
			else{
				for(int j=2; j < edit_details.size(); j=j+10){ //j=j+9 instead of j=j+8 Added For ML-BRU-CRF-072[Inc:29938] 9 changed 10
					m++;
					pstmt.setString(1,(String) edit_details.get(j));
					pstmt.setString(2,(String) edit_details.get(j+1));
					pstmt.setString(3,(String) edit_details.get(j+2));
					pstmt.setString(4,(String) edit_details.get(j+3));
					pstmt.setString(5,(String) edit_details.get(j+4));
					pstmt.setString(6,(String) edit_details.get(j+5));
					pstmt.setString(7,(String) edit_details.get(j+6));

					pstmt.setString(8,login_by_id);
					pstmt.setString(9,login_at_ws_no);
					pstmt.setString(10,(String) edit_details.get(j+7));//Added For ML-BRU-CRF-072[Inc:29938]
					pstmt.setString(11,login_facility_id);
					//pstmt.setString(10,(String) edit_details.get(j+9));//Added Forjd-crf-0221//REMOVED NOT USED  ML-MMOH-SCF-2167
					
					pstmt.setString(12,dispense_no);
					pstmt.setString(13,(String) edit_details.get(j+8));//m+""
					pstmt.addBatch();
				}
				ph_disp_dtl_update = pstmt.executeBatch() ;
				for (int i=0;i<ph_disp_dtl_update.length ;i++ ){
					// A number greater than or equal to zero  indicates success
					// A number -2 indicates that command is successful but number of rows updated is unknow
					// If it won't satisfy any of the above cancel the statement and throw an exception
					if(ph_disp_dtl_update[i]<0  && ph_disp_dtl_update[i] != -2 ){
						pstmt.cancel();
						connection.rollback();
						throw new Exception("Update PH_DISP_DTL failed");
					}	
					else{
						success = true;
					}
				}
			}
			if(success){
				success = false;
				pstmt_insert = connection.prepareStatement("Insert into PH_EDIT_LABEL_AUDIT_LOG( DISP_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO) values (?,?,SYSDATE,?)");
				pstmt_insert.setString(1, dispense_no);
				pstmt_insert.setString(2, login_by_id);
				pstmt_insert.setString(3, login_at_ws_no);
				int ph_audit_trail = pstmt_insert.executeUpdate();					 
				if(ph_audit_trail == 1)
					success = true;
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
			throw new Exception(e.toString());
		}
		finally{
			try{
				connection.commit();
                closeStatement( pstmt ) ;
				closeStatement( pstmt_insert );
                closeConnection( connection );
				closeResultSet( rsLablCount ) ;
				closeStatement( pstmt_disp_label_select_count ) ;
				closeStatement( pstmtDispLabelInsert ) ;
				closeStatement( pstmtDispLabelUpdate ) ;
			}
			catch(Exception e) {
				e.printStackTrace() ;
			}
		}
		return success;
	}

	public ArrayList getAuditTrailDatails(String dispense_no) { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	audit_trail		=	new ArrayList() ;

		try{       
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement("SELECT TO_CHAR (MODIFIED_DATE, 'dd/mm/yyyy hh24:mi') MODIFIED_DATE, MODIFIED_BY_ID,MODIFIED_AT_WS_NO FROM PH_EDIT_LABEL_AUDIT_LOG WHERE DISP_NO = ? ORDER BY MODIFIED_DATE DESC");
			pstmt.setString(1,dispense_no);
			resultSet	        = pstmt.executeQuery();
			while( resultSet != null && resultSet.next() ) {               
				audit_trail.add(resultSet.getString("MODIFIED_DATE"));
				audit_trail.add(resultSet.getString("MODIFIED_BY_ID"));
				audit_trail.add(resultSet.getString("MODIFIED_AT_WS_NO"));
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
		return audit_trail;	
	}	

	public String getPatientClass(String dispense_no){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	=	"";
		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT PATIENT_CLASS FROM PH_DISP_HDR WHERE DISP_NO=?") ;
			pstmt.setString(1,dispense_no);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				patient_class		=		resultSet.getString("PATIENT_CLASS");
			}
		}
		catch ( Exception e ){
			System.err.println( e ) ;
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
		return patient_class;
	}

	public ArrayList getOrderLineFieldValues(String order_id) {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList order_line_field_values	= new ArrayList();	

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT138")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				order_line_field_values.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));	
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
		return order_line_field_values;
   }

   public ArrayList getPatientDetails1(String id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2") ) ;
			pstmt.setString(1,id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					records.add(resultSet.getString("PATIENT_NAME"));
					records.add(resultSet.getString("AGE"));
					records.add(resultSet.getString("GENDER"));
					records.add(resultSet.getString("DATE_OF_BIRTH"));
			}
		}catch(Exception e){
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

	public void getEditLabelDefltValues() throws Exception{//Added for Bru-HIMS-CRF-414 [IN045554]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String crit_field_id = "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_EDIT_LABEL_EDITABLE_SELECT") ) ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){
					crit_field_id = checkForNull(resultSet.getString("CRIT_FIELD_ID"));
					if(crit_field_id.equals("ALLOW_EDIT_DISP_LABEL"))
						setAllowEditDispLabel(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
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
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		}
	}

	public ArrayList getEditableDetails(String dispense_no, String language_id, String facility_id) throws Exception{ //Added for Bru-HIMS-CRF-414 [IN045554]
		ArrayList result = new ArrayList();
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null;
		setLabelExists(true);
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EDIT_LABEL_DTL_TMP_SELECT") ) ;
			pstmt.setString(1,language_id);			
			pstmt.setString(2,dispense_no);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,language_id);			
			 resultSet = pstmt.executeQuery() ;
			while( resultSet.next() ){
				result.add(checkForNull(resultSet.getString("DISP_NO"))); //0
				result.add(checkForNull(resultSet.getString("SRL_NO")));
				result.add(checkForNull(resultSet.getString("ORDER_ID")));
				result.add(checkForNull(resultSet.getString("ORDER_LINE_NO")));
				result.add(checkForNull(resultSet.getString("disp_qty")));
				result.add(checkForNull(resultSet.getString("DISP_UOM_CODE"))); //5
				result.add(checkForNull(resultSet.getString("PRES_DRUG_CODE")));
				result.add(checkForNull(resultSet.getString("DRUG_CODE")));
				result.add(checkForNull(resultSet.getString("DRUG_DESC")));
				result.add(checkForNull(resultSet.getString("DOSAGE_DTL")));
				if(checkForNull(resultSet.getString("NO_OF_COPIES")).equals("")){
					if(checkForNull(resultSet.getString("PRINT_LABEL_BASED_ON_QTY_YN")).equals("N"))
						result.add("1"); //10
					else
						result.add(checkForNull(resultSet.getString("disp_qty")));//10
				}
				else
					result.add(checkForNull(resultSet.getString("NO_OF_COPIES"))); //10
				result.add(checkForNull(resultSet.getString("INSTRUCTION")));
			}
			closeResultSet( resultSet );//common-icn-0029
			closeStatement( pstmt ) ; //common-icn-0029
			
			if(result.size()==0){
				setLabelExists(false);
				StringBuilder instructions = new StringBuilder();
				String cau_instructions	="", spl_instructions	="", how_to_take_text	="";
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EDIT_LABEL_DTL_SELECT") ) ;

				pstmt.setString(1,language_id);			
				pstmt.setString(2,login_facility_id);
				pstmt.setString(3,language_id);
				pstmt.setString(4,language_id);
				pstmt.setString(5,language_id);
				pstmt.setString(6,dispense_no);
				pstmt.setString(7,facility_id);
				resultSet = pstmt.executeQuery() ;

				while( resultSet.next() ){
					result.add(checkForNull(resultSet.getString("DISP_NO"))); //0
					result.add(checkForNull(resultSet.getString("SRL_NO")));
					result.add(checkForNull(resultSet.getString("ORDER_ID")));
					result.add(checkForNull(resultSet.getString("ORDER_LINE_NO")));
					result.add(checkForNull(resultSet.getString("disp_qty")));
					result.add(checkForNull(resultSet.getString("DISP_UOM_CODE"))); //5
					result.add(checkForNull(resultSet.getString("PRES_DRUG_CODE")));
					result.add(checkForNull(resultSet.getString("DRUG_CODE")));
					result.add(checkForNull(resultSet.getString("DRUG_DESC")));
					result.add(checkForNull(resultSet.getString("DOSAGE_DTL")));
					if(checkForNull(resultSet.getString("PRINT_LABEL_BASED_ON_QTY_YN")).equals("N"))
						result.add("1"); //10
					else
						result.add(checkForNull(resultSet.getString("disp_qty")));//10
					instructions.delete(0, instructions.length());
					if(language_id.equals("en"))
						how_to_take_text	=checkForNull(resultSet.getString("LABEL_PAT_INSTRN1_ENG"));
					else
						how_to_take_text	=checkForNull(resultSet.getString("LABEL_PAT_INSTRN1_LOC"));
					cau_instructions	=checkForNull(resultSet.getString("LABEL_CAU_INSTRN"));
					spl_instructions	=checkForNull(resultSet.getString("LABEL_SPL_INSTRN"));
					if(!how_to_take_text.equals(""))
						instructions.append(how_to_take_text);
					if(!cau_instructions.equals("")){
						if(instructions.length()>0)
							instructions.append(" "+cau_instructions);
						else
							instructions.append(cau_instructions);
					}
					if(!spl_instructions.equals("")){
						if(instructions.length()>0)
							instructions.append(" "+spl_instructions);
						else
							instructions.append(spl_instructions);
					}
					if(instructions.length()>270)
						result.add((instructions.toString()).substring(0,270)); //11
					else
						result.add(instructions.toString()); //11
				}
			}
		} 
		catch ( Exception e ){
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
}
