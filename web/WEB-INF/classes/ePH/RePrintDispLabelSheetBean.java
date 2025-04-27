/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 
 23/04/2021      TFS-17292         Prabha		 23/04/2021     Manickavasagam J          SKR-SCF-1594
 ******************************************************************************/
 //saved on 02.11.2005
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;

public class RePrintDispLabelSheetBean extends PhAdapter implements Serializable {
	ArrayList alDrugDispList = new ArrayList();
	ArrayList alOrdersList = new ArrayList();
	HashMap<String, ArrayList> seq_no_no_of_copies=new HashMap<String, ArrayList>();// Added for SKR-SCF-1041[IN051887] start // <String, Integer> changed to <String, ArrayList> for ML-BRU-SCF-1414 [IN:050645] 

	public HashMap<String, ArrayList> getSeq_no_no_of_copies() {
		return seq_no_no_of_copies;
	}
	public void clearSeq_no_no_of_copies(){
		seq_no_no_of_copies.clear();
	}
	public void setSeq_no_no_of_copies(String seq_no, ArrayList alDispList) {
		seq_no_no_of_copies.put(seq_no, alDispList);
	}// Added for SKR-SCF-1041[IN051887] end

	public RePrintDispLabelSheetBean() {
		try {
			doCommon();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */ 
	public void clear() {
		alOrdersList = new ArrayList();
		alDrugDispList = new ArrayList();
		super.clear() ;
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
	}

	public HashMap modify() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put("flag","0");
		return map;
	}
	public ArrayList getOrdersList( ){
		return this.alOrdersList;
	}
	public void setOrdersList(ArrayList alOrdersList){
		this.alOrdersList= alOrdersList;
	}
	public void setDrugDispList(ArrayList alDrugDispList){
		this.alDrugDispList= alDrugDispList;
	}
	public ArrayList getDrugDispList( ){
		return this.alDrugDispList;
	}
	/********** getPatientIDLength()  starts**********/
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
		}catch(Exception e){
				pat_txt_length	=e.toString();
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
		return pat_txt_length;	
	} //Ends

	public ArrayList getPatientDetails(String patientid){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		 ArrayList result		= new ArrayList();
        try {
            connection = getConnection() ;

			String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT8") ;
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patientid);
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("PATIENT_NAME"));
				result.add(resultSet.getString("SEX"));
				result.add(resultSet.getString("AGE"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
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
	
	//public ArrayList getDispNos(String stage, String patient_id, String disp_date,String source_type, String source_code) {
	public ArrayList getDispNos(String stage, String patient_id, String disp_date,String patient_class,String report_type) { //modified for GHL-CRF-0627.2
		ArrayList disp_nos		= new ArrayList() ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		StringBuffer SQL = new StringBuffer();
		//Added for SKR-SCF-1594
		String locale = getLanguageId();
		if(!locale.equals("en")){
			disp_date = com.ehis.util.DateUtils.convertDate(disp_date, "DMY",locale,"en");
		}
		//Added for SKR-SCF-159
			String sql_append=""; //Added for GHL-CRF-0627.2
		String sql_append1=""; //Added for GHL-CRF-0627.2
		try {
			connection = getConnection() ;
	boolean site_report_type = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISP_SHEET_CHECK");// added for ML-MMOH-CRF-0468
			if(site_report_type){
				if(report_type.equals("S")){  //Added for GHL-CRF-0627.2
				sql_append=" ,PR_ENCOUNTER C";
				sql_append1=" C.PATIENT_CLASS =? AND B.PATIENT_ID = C.PATIENT_ID AND B.ENCOUNTER_ID = C.ENCOUNTER_ID ";
			}else{
				sql_append1=" B.PATIENT_CLASS =? ";
			}  //Added for GHL-CRF-0627.2
			}
      else{	
      sql_append1=" B.PATIENT_CLASS =? ";
      sql_append="";
      }
			if(!stage.equals("D")){
				SQL.append("SELECT DISP_TMP_NO DISP_NO,B.IV_PREP_YN FROM PH_DISP_HDR_TMP A , OR_ORDER B "+sql_append+" WHERE A.ORDER_ID = B.ORDER_ID AND A.FACILITY_ID=? and "+sql_append1+"  AND b.iv_prep_yn IS NULL ");  //Added for GHL-CRF-0627.2
				if(!disp_date.equals(""))
					SQL.append(" AND TRUNC(A.RECORD_DATE_TIME)=TO_DATE('"+disp_date+"','DD/MM/YYYY') ");
			}
			else{
				SQL.append("SELECT A.DISP_NO, B.IV_PREP_YN FROM PH_DISP_HDR A , OR_ORDER B "+sql_append+" WHERE A.ORDER_ID = B.ORDER_ID AND A.FACILITY_ID=? and "+sql_append1+" AND  b.iv_prep_yn IS NULL "); //Added for GHL-CRF-0627.2
				if(!disp_date.equals(""))
					SQL.append(" AND A.DISP_DATE_TIME=TO_DATE('"+disp_date+"','DD/MM/YYYY') ");  //SKR-SCF-1666
					//SQL.append(" AND TRUNC(A.DISP_DATE_TIME)=TO_DATE('"+disp_date+"','DD/MM/YYYY') ");  //SKR-SCF-1666
			}
			if(!patient_id.equals(""))
				SQL.append("AND A.PATIENT_ID= '"+patient_id+"' ");
			/*if( !source_type.equals("")){
				if( source_type.equals("C")){
					SQL.append(" AND decode(b.source_type, null, 'X', b.source_type) IN ('C', 'E','X') ");
					if( !source_code.equals(""))
						SQL.append(" AND B.source_code ='"+source_code+"' ");
				}
				else if(source_type.equals("N")){
					SQL.append(" AND B.source_type in ('N','D') ");
					if( !source_code.equals(""))
						SQL.append(" AND B.source_code='"+source_code+"' ");
				}
			}*/

			SQL.append(" AND a.patient_id=b.patient_id ");
			if(stage.equals("D"))
				SQL.append(" and a.disp_no between '0' and '999999999999999999999999999' ");
			SQL.append(" ORDER BY DISP_NO ");
			System.err.println("getDispNo==>" + SQL);  //Added for GHL-CRF-0627.2
			System.err.println("login_facility_id==>" + login_facility_id);
			System.err.println("patient_class==>" + patient_class);
			pstmt = connection.prepareStatement(SQL.toString()) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,patient_class);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next()) {
				disp_nos.add(checkForNull(resultSet.getString( "DISP_NO" )))  ;
				disp_nos.add(checkForNull(resultSet.getString( "IV_PREP_YN" )))  ;
			}
		}
		catch ( Exception e ) {
			System.err.println("getDispNos====SQL===>"+SQL);
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
		System.err.println("disp_nos==>" + disp_nos); 
		return disp_nos;
	}

	//public ArrayList getResult(String patient_id,String source_type, String source_code,String disp_stage,String disp_date,String disp_no){		  
	public ArrayList getResult(String patient_id,String patient_class,String disp_stage,String disp_date,String disp_no,String report_type){  //modified for GHL-CRF-0627.2		   
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
        alOrdersList =new ArrayList();
		ArrayList alDrugDispList	=new ArrayList(); 

		StringBuffer sql= new StringBuffer();
		clear();
		String sql_append="";  //Added for GHL-CRF-0627.2
		String sql_append1="";  //Added for GHL-CRF-0627.2
		String sql_append2="";  //Added for GHL-CRF-0627.2
		try {
			connection = getConnection() ;

			boolean site_report_type = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISP_SHEET_CHECK");// added for ML-MMOH-CRF-0468
			if(site_report_type){
			if(report_type.equals("S")){  //Added for GHL-CRF-0627.2
				sql_append=" pr_encounter g, ";
				sql_append1=" AND g.encounter_id = c.encounter_id AND g.patient_id = c.patient_id ";
				sql_append2=" AND g.patient_class=? ";
			}else{
				sql_append2=" AND c.patient_class=? ";
			}  //Added for GHL-CRF-0627.2
      }
      else{
      	sql_append2=" AND c.patient_class=? ";
        sql_append1="";
        sql_append="";
      }
			if(disp_stage.equals("D")){
				sql.append("SELECT f.patient_id, a.disp_no, a.srl_no, a.order_id, a.order_line_no, a.disp_drug_code, b.drug_desc, TO_CHAR (f.dispensed_date_time, 'dd/mm/yyyy hh24:mi') disp_date_time, (select practitioner_name from am_practitioner_lang_vw where practitioner_id=c.ord_pract_id and language_id=b.language_id) practitioner_name, ph_order_source (c.source_code, c.patient_class, c.ordering_facility_id, c.source_type, b.language_id ) SOURCE, dl.short_desc disp_locn, (SELECT DECODE(?,'en',patient_name,nvl(PATIENT_NAME_LOC_LANG,patient_name))  FROM mp_patient WHERE patient_id = c.patient_id) patient_name FROM ph_disp_dtl a, ph_drug_lang_vw b, or_order c, ph_disp_hdr f,"+sql_append+" ph_disp_locn_lang_vw dl WHERE a.disp_drug_code = b.drug_code AND a.disp_no = f.disp_no AND f.order_id = c.order_id AND f.patient_id = c.patient_id AND order_category = 'PH' AND dl.disp_locn_code = f.disp_locn_code AND dl.language_id = b.language_id AND a.facility_id = dl.FACILITY_Id and a.facility_id=f.facility_id AND a.disp_locn_code=f.disp_locn_code AND F.FACILITY_ID=? "+sql_append2+" and c.iv_prep_yn IS NULL ");// language conversion in patient name for SKR-SCF-1005[IN048684] //modified for GHL-CRF-0627 //commented a.order_id = c.order_id and added f.order_id = c.order_id and remove a.facility_id=? and add f.facility_id = ? for SKR-SCF-1666               
				if(!disp_date.equals(""))
					sql.append("  AND f.DISP_DATE_TIME  = TO_DATE(?,'DD/MM/RRRR') "); //SKR-SCF-1666 
					//sql.append("  AND TO_DATE(f.DISP_DATE_TIME,'DD/MM/RRRR') = TO_DATE(?,'DD/MM/RRRR') ");  //SKR-SCF-1666 
				if( !disp_no.equals(""))
					sql.append(" AND a.disp_no=? ");
			}
			else{
				sql.append("SELECT f.patient_id, a.disp_tmp_no disp_no, a.DTL_SERIAL_NUM srl_no, a.order_id, a.order_line_no, a.disp_drug_code, b.drug_desc, TO_CHAR (f.RECORD_DATE_TIME, 'dd/mm/yyyy hh24:mi') DISP_DATE_TIME, (select practitioner_name from am_practitioner_lang_vw where practitioner_id=c.ord_pract_id and language_id=b.language_id) practitioner_name, ph_order_source (c.source_code, c.patient_class, c.ordering_facility_id, c.source_type, b.language_id ) SOURCE, dl.short_desc disp_locn, (SELECT DECODE(?,'en',patient_name,nvl(PATIENT_NAME_LOC_LANG,patient_name))  FROM mp_patient WHERE patient_id = c.patient_id) patient_name FROM ph_disp_dtl_tmp a, ph_drug_lang_vw b, or_order c, ph_disp_hdr_tmp f,"+sql_append+" ph_disp_locn_lang_vw dl WHERE a.disp_drug_code = b.drug_code AND a.disp_tmp_no = f.disp_tmp_no AND a.order_id = c.order_id AND order_category = 'PH' and dl.disp_locn_code = f.DISP_LOCN_CODE AND dl.language_id = b.language_id AND a.facility_id = dl.FACILITY_Id and a.facility_id=f.facility_id AND  a.disp_locn_code=f.disp_locn_code and A.FACILITY_ID=? "+sql_append2+" and c.iv_prep_yn IS NULL ");// language conversion in patient name for SKR-SCF-1005[IN048684] //modified for GHL-CRF-0627
				if(!disp_date.equals(""))
					sql.append("  AND TO_DATE(f.RECORD_DATE_TIME,'DD/MM/RRRR') = TO_DATE(?,'DD/MM/RRRR') ");
				if( !disp_no.equals(""))
					sql.append(" AND a.disp_tmp_no=? ");
			}
			if(!patient_id.equals(""))
				sql.append("  AND c.patient_id = ? ");
			/*if( !source_type.equals("")){
				if( source_type.equals("C")){
					sql.append(" AND decode(c.source_type, null, 'X', c.source_type) IN ('C', 'E','X') ");
					if( !source_code.equals(""))
						sql.append(" AND c.source_code =? ");
				}
				else if(source_type.equals("N")){
					sql.append(" AND c.source_type in ('N','D') ");
					if( !source_code.equals(""))
						sql.append(" AND c.source_code=? ");
				}
			}*/
			sql.append("  AND b.language_id = ? "+sql_append1+" "); //modified for GHL-CRF-0627
			if(disp_stage.equals("D"))
				sql.append(" AND a.srl_no LIKE '%' ");
			else
				sql.append(" AND a.DTL_SERIAL_NUM LIKE '%' ");
			sql.append(" ORDER BY SOURCE, patient_id, disp_no desc, order_id, drug_desc ");
			System.err.println("sql==>" + sql);
			pstmt = connection.prepareStatement(sql.toString());
			int icount=1;
			pstmt.setString(icount++,getLanguageId());//added for SCF-1005[IN048684]
			pstmt.setString(icount++,login_facility_id);
			pstmt.setString(icount++,patient_class);
			if(!disp_date.equals(""))
				pstmt.setString(icount++,disp_date);
			if(!disp_no.equals(""))
				pstmt.setString(icount++,disp_no.trim());
			if(!patient_id.equals(""))
				pstmt.setString(icount++,patient_id.trim());
			//if( !source_code.equals(""))
			//	pstmt.setString(icount++,source_code.trim());
			pstmt.setString(icount++,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next()) {
				alOrdersList.add(checkForNull(resultSet.getString("patient_id"),"")); //0
				alOrdersList.add(checkForNull(resultSet.getString("patient_name"),"")); //1
				alOrdersList.add(checkForNull(resultSet.getString("disp_no"),""));
				alOrdersList.add(checkForNull(resultSet.getString("srl_no"),""));
				alOrdersList.add(checkForNull(resultSet.getString("order_id"),""));
				alOrdersList.add(checkForNull(resultSet.getString("order_line_no"),""));//5
				alOrdersList.add(checkForNull(resultSet.getString("disp_drug_code"),""));//6
				alOrdersList.add(checkForNull(resultSet.getString("drug_desc"),""));
				alOrdersList.add(checkForNull(resultSet.getString("DISP_DATE_TIME"),""));
				alOrdersList.add(checkForNull(resultSet.getString("SOURCE"),""));
				alOrdersList.add(checkForNull(resultSet.getString("disp_locn"),""));//10
				alOrdersList.add(checkForNull(resultSet.getString("practitioner_name"),""));//11

				alDrugDispList.add(checkForNull(resultSet.getString("disp_no"),""));
				alDrugDispList.add(checkForNull(resultSet.getString("srl_no"),""));
				alDrugDispList.add("Y");
				alDrugDispList.add(checkForNull(resultSet.getString("patient_id"),""));//Added for Bru-HIMS-CRF-417 [IN045565]
				alDrugDispList.add("1");//Added for Bru-HIMS-CRF-417 [IN045565]
			}
			setDrugDispList(alDrugDispList);
		}
		catch ( Exception e ) {
			System.err.println("getResult====sql===>"+sql);
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
		return alOrdersList;
	}

	//public String updatePrintSeqNo(String stage, String called_from, ArrayList alDispList){    //Commented for ML-BRU-SCF-1414 [IN:050645] 
	public boolean updatePrintSeqNo(String stage, String called_from, HashMap<String, ArrayList> grp_nof_copies_seq_no){    //added for ML-BRU-SCF-1414 [IN:050645] 
		Connection connection   = null ;
		PreparedStatement pstmt_update = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
        ArrayList alDrugDispList =null, alDispList = null;
		String sql_update= "", sql_seq="", pint_seq_no="";
		int indexCount=4;
		boolean blRecUpdated = false; //added for ML-BRU-SCF-1414 [IN:050645] 
		/*int indexCount=5; //commented for ML-BRU-SCF-1414 [IN:050645] 
		if(called_from.equals("P") && alDispList!=null){
			alDrugDispList =alDispList;
			indexCount = 3;
		}
		else
			alDrugDispList =getDrugDispList();*/
		try {
			if(stage.equals("D")){
				sql_update=PhRepository.getPhKeyValue("SQL_PH_UPDATE_OFFLINE_PRINT_SEQ_NO");
				sql_seq=PhRepository.getPhKeyValue("SQL_PH_SELECT_OFFLINE_PRINT_SEQ_NO");
			}
			else{
				sql_update=PhRepository.getPhKeyValue("SQL_PH_UPDATE_TMP_OFFLINE_PRINT_SEQ_NO");
				sql_seq=PhRepository.getPhKeyValue("SQL_PH_SELECT_TMP_OFFLINE_PRINT_SEQ_NO");
			}
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sql_seq);
			pstmt_update = connection.prepareStatement( sql_update) ; //added for for ML-BRU-SCF-1414 [IN:050645] -start
			for(String no_of_copies:grp_nof_copies_seq_no.keySet()){
				alDispList = new ArrayList();
				alDrugDispList = grp_nof_copies_seq_no.get(no_of_copies); //added for for ML-BRU-SCF-1414 [IN:050645]  -end
				resultSet = pstmt.executeQuery() ;
				if (resultSet!=null &&  resultSet.next() ) {
					pint_seq_no = resultSet.getString("PRINT_SEQ_NO");
				}
				//closeStatement(pstmt); //commented for ML-BRU-SCF-1414 [IN:050645] 
				closeResultSet( resultSet ) ;
		
				for(int i=0; i<alDrugDispList.size();i+=indexCount){//Increase Size from 3 To 5 for Bru-HIMS-CRF-417 [IN045565]
					if(((String)alDrugDispList.get(i+2)).equals("Y")){
						pstmt_update.setString(1,pint_seq_no);
						pstmt_update.setString(2,(String)alDrugDispList.get(i));
						pstmt_update.setString(3,(String)alDrugDispList.get(i+1));
						pstmt_update.setString(4,login_facility_id);
						pstmt_update.addBatch();
						alDispList.add(Integer.parseInt(no_of_copies)); //Added for for ML-BRU-SCF-1414 [IN:050645] -start
						alDispList.add((String)alDrugDispList.get(i));
						alDispList.add((String)alDrugDispList.get(i+1));
						alDispList.add((String)alDrugDispList.get(i+3)); //added for for ML-BRU-SCF-1414 [IN:050645]  -end
					}
				}
				if(alDispList.size()>0)//if condition added for ML-BRU-SCF-1414 [IN:050645] 
					setSeq_no_no_of_copies(pint_seq_no,alDispList);// Added for SKR-SCF-1041[IN051887]
			}
			int[] resultUpdate= pstmt_update.executeBatch();
			for (int i=0;i<resultUpdate.length ;i++ ){ //added for for ML-BRU-SCF-1414 [IN:050645] 
				if(resultUpdate[i]<0  && resultUpdate[i] != -2 ){
					blRecUpdated=false;
					break;
				}
				else{
					blRecUpdated=true;
				}
			}
			if(blRecUpdated) //if condition and else block added for ML-BRU-SCF-1414 [IN:050645] 
				connection.commit();
			else{
				connection.rollback();
				clearSeq_no_no_of_copies();
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeStatement( pstmt ) ;
				closeStatement(pstmt_update);
				closeResultSet( resultSet ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return blRecUpdated;
	}
   // Added For ML-BRU-SCF-0538 [IN:036179] - Start
   public String getSMLOcalLanguageID(){
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String language_id			        = "";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LANGUAGE_ID from sm_language where PRIMARY_LANG_YN ='N' and EFF_STATUS='E' and rownum<2") ;			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				language_id = checkForNull(resultSet.getString("LANGUAGE_ID"));
			}
		}
		catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
				}catch(Exception es){es.printStackTrace();}
		}
		return language_id;
	}

	public ArrayList getLangNameAndId(String langID){
        Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList landNameAndId			    = new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LANGUAGE_ID,SHORT_NAME from sm_language where LANGUAGE_ID =?") ;
            pstmt.setString(1,langID);			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				landNameAndId.add(checkForNull(resultSet.getString("LANGUAGE_ID")));
				landNameAndId.add(checkForNull(resultSet.getString("SHORT_NAME")));
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
		return landNameAndId;
   }
    //Added For ML-BRU-SCF-0538 [IN:036179] - End
//added for SKR-SCF-1314 - start
	public ArrayList getDispNoAgainstPrintSeqNo(String printSeqNo){
	 Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList dispNo			    = new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement("SELECT DISP_TMP_NO from ph_disp_dtl_tmp where OFFLINE_PRINT_SEQ_NO = ?") ;
            pstmt.setString(1,printSeqNo);			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				dispNo.add(checkForNull(resultSet.getString("disp_tmp_no")));
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
		return dispNo;
	}
//added for SKR-SCF-1314 - end
}
