/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 *****************************************************************************
 ---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
14/05/2019		IN070323		Devindra R B						            SKR-SCF-1199 [IN:070323]
10/11/2020		IN7695		 Manickavasagam J  10/11/2020	 Manickavasagam J   SKR-SCF-1463
22/07/2021      TFS-20589    Prabha            22/07/2021    Manickavasagam J   SKR-SCF-1614

 */
 //saved on 08/11/2005
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.ReleaseBatches.*;

public class ReleaseBatchesBean extends PhAdapter implements Serializable {

	protected ArrayList all_records = new ArrayList();
	protected HashMap record_status	= new HashMap();
	protected HashMap record_statusFirst	= new HashMap();
	protected HashMap reason_codes	= new HashMap();
	protected HashMap order_and_ord_facility	= new HashMap();
	protected String bl_interface_yn	= null;
	protected String sys_date=null;
	protected String bl_installed_yn=null;
	protected String paid_status=null;
	protected String disp_locn_code="";
	protected String batches	= "";
	private String sPrevAdmixOrderID= "";	// Added for SRR20056-SCF-7734 ICN 28022
	private String sPrevAdmixReasonCode= "";	// Added for SRR20056-SCF-7734 ICN 28022
	private String sPrevAdmixWorkSheetId= "";	// Added for SRR20056-SCF-7734 ICN 28022
	private String incompleteAdmixFoundPrev= "";	// Added for SRR20056-SCF-7734 ICN 28022
	private String disp_bill_stage= "";	// Added for SRR20056-SCF-7639 ICN027720
	private String disp_bill_stage_op= "";	// Added for SRR20056-SCF-7639 ICN027720
	private String pat_paid_yn_for_zero_bill= "";//Added for SKR-SCF-0979 [IN:048119]

	public ReleaseBatchesBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void setDisp_locn_code(String disp_locn_code) {
		this.disp_locn_code	=	disp_locn_code;
	}	
	public String getDisp_locn_code() {
		return this.disp_locn_code;
	}

	public void setPrevAdmixOrderID(String sPrevAdmixOrderID) {// Added for SRR20056-SCF-7734 ICN 28022 - Start
		this.sPrevAdmixOrderID	=	sPrevAdmixOrderID;
	}	
	public String getPrevAdmixOrderID() {
		return this.sPrevAdmixOrderID;
	}
	public void setPrevAdmixReasonCode(String sPrevAdmixReasonCode) {
		this.sPrevAdmixReasonCode	=	sPrevAdmixReasonCode;
	}	
	public String getPrevAdmixReasonCode() {
		return this.sPrevAdmixReasonCode;
	}
	public void setPrevAdmixWorkSheetId(String sPrevAdmixWorkSheetId) {
		this.sPrevAdmixWorkSheetId	=	sPrevAdmixWorkSheetId;
	}	
	public String getPrevAdmixWorkSheetId() {
		return this.sPrevAdmixWorkSheetId;
	}
	public void setIncompleteAdmixFoundPrev(String incompleteAdmixFoundPrev) {
		this.incompleteAdmixFoundPrev	=	incompleteAdmixFoundPrev;
	}	
	public String getIncompleteAdmixFoundPrev() {
		return this.incompleteAdmixFoundPrev;
	}// Added for SRR20056-SCF-7734 ICN 28022 - End

	public void setDispBillStageOP(String disp_bill_stage_op){// added for SRR20056-SCF-7639 ICN027720 - Start
		this.disp_bill_stage_op = disp_bill_stage_op;
	}
	public String getDispBillStageOP(){
		return this.disp_bill_stage_op;
	}
	public void setDispBillStage(String disp_bill_stage){
		this.disp_bill_stage = disp_bill_stage;
	}
	public String getDispBillStage(){
		return this.disp_bill_stage;
	} //added for SRR20056-SCF-7639 ICN027720 - End

	public void setPatPaidYNForZeroBill(String pat_paid_yn_for_zero_bill){ //Added for SKR-SCF-0979 [IN:048119] -start
		this.pat_paid_yn_for_zero_bill = pat_paid_yn_for_zero_bill;
	}
	public String getPatPaidYNForZeroBill(){
		return this.pat_paid_yn_for_zero_bill;
	} //Added for SKR-SCF-0979 [IN:048119] - End

	public void clear() {
		super.clear() ;
		all_records		=	new ArrayList();
		record_status	=	new HashMap();
		reason_codes	=	new HashMap();
		record_statusFirst	=	new HashMap();
		order_and_ord_facility	=	new HashMap();
		sPrevAdmixOrderID= "";	// Added for SRR20056-SCF-7734 ICN 28022
		sPrevAdmixReasonCode= "";	// Added for SRR20056-SCF-7734 ICN 28022
		sPrevAdmixWorkSheetId= "";	// Added for SRR20056-SCF-7734 ICN 28022
		incompleteAdmixFoundPrev= "";	// Added for SRR20056-SCF-7734 ICN 28022
	}

	private void doCommon() throws Exception {
	}

	public HashMap getRecordStatus() {
		return this.record_status;
	}

	public HashMap getRsnCodes() {
		return this.reason_codes;
	}
	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "in modify.." ) ;
		map.put( "flag", "0" ) ;

//		ReleaseBatchesHome   home=null;
//		ReleaseBatchesRemote remote=null;

		try {
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties());
			tabData.put( "facility_id", login_facility_id.trim() );
			tabData.put( "login_by_id", login_by_id.trim() );
			tabData.put( "login_at_ws_no",login_at_ws_no.trim());
			tabData.put( "all_records",all_records);
			tabData.put( "record_status",record_status);
			tabData.put( "rsn_type_code",reason_codes);
			tabData.put( "LanguageId",getLanguageId());
			//tabData.put( "DispBillingStage",getDispBillingStage());
			tabData.put( "ORDER_AND_ORD_FACILITY",this.order_and_ord_facility);
			tabData.put( "batches",batches);

	//System.err.println("==tabData====="+tabData);	
			HashMap sqlMap = new HashMap() ;
			sqlMap.put("SQL_PH_RELEASE_BATCHES_DELETE1",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_DELETE1"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_DELETE2",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_DELETE2"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_DELETE3",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_DELETE3"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_UPDATE1",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_UPDATE1"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_UPDATE2",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_UPDATE2"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT2",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT2"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT4",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT4"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT5",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT5"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT6",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT6"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT7",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT7"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_SELECT8",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT8"));
			sqlMap.put("SQL_PH_RELEASE_BATCHES_INSERT1",PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_INSERT1"));
			sqlMap.put("SQL_PH_DISP_LABEL_DELETE",PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_DELETE")); // Added for Bru-HIMS-CRF-414 [IN:045554]
			sqlMap.put("SQL_PH_MED_PLAN_DELETE",PhRepository.getPhKeyValue("SQL_PH_DISP_LABEL_DELETE")); //Added for Bru-HIMS-CRF-072.1[IN 049144]
			sqlMap.put("SQL_PH_MED_PLAN_SELECT_ID",PhRepository.getPhKeyValue("SQL_PH_MED_PLAN_SELECT_ID")); //Added for Bru-HIMS-CRF-072.1[IN 049144]
			sqlMap.put("SQL_PH_MED_PLAN_SELECT_CURR_DRUG",PhRepository.getPhKeyValue("SQL_PH_MED_PLAN_SELECT_CURR_DRUG")); //Added for Bru-HIMS-CRF-072.1[IN 049144]
			sqlMap.put("SQL_PH_MED_PLAN_DELETE_ALL",PhRepository.getPhKeyValue("SQL_PH_MED_PLAN_DELETE_ALL")); //Added for Bru-HIMS-CRF-072.1[IN 049144]

/*		InitialContext context = new InitialContext() ;
		Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_RELEASE_BATCHES") ) ;

		home  = (ReleaseBatchesHome) PortableRemoteObject.narrow( object, ReleaseBatchesHome.class ) ;
		remote = home.create() ;

		HashMap result = remote.modify( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_RELEASE_BATCHES" ),ReleaseBatchesHome.class,getLocalEJB());

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
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
			}
			else{
				map.put( "message",(String) result.get( "msgid" ) ) ;
				map.put("flag","0");
			}
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return map;
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
		}
		catch(Exception e){
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
	}

	public ArrayList getBatchDetails(String order_id, String order_line_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList batch_details	=	new ArrayList();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RELEASE_BATCHES_SELECT3") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				batch_details.add(checkForNull(resultSet.getString("ITEM_CODE")));
				batch_details.add(checkForNull(resultSet.getString("BATCH_ID")));
				batch_details.add(checkForNull(resultSet.getString("EXPIRY_DATE")));
				batch_details.add(checkForNull(resultSet.getString("STORE_CODE")));
			}						
		}
		catch(Exception e){
				batch_details.add(e.toString());
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
		return batch_details;	
	}

	public ArrayList getDispLocns(String locale) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList dispLocns = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_WS_TS_SELECT_DISP_LOCN" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2,locale);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				dispLocns.add(resultSet.getString("DISP_LOCN_CODE"));
				dispLocns.add(resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
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
		return dispLocns;
	}

	public ArrayList getAllocatedRecords(String dt_from, String dt_to, String disp_locn,String from,String to, String pat_id, String batches,String durg_code,String locale,String paid_status_p,String bl_installed_yn_p){
        this.batches	= batches;
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		PreparedStatement pstmt_drug_count		=	null ; //Added for SRR20056-SCF-7734 ICN 28022
		ResultSet resultSet			=	null ;   
		ResultSet resultSet_drug_count			=	null ;   //Added for SRR20056-SCF-7734 ICN 28022
		ResultSet resultSet_2		=	null ;

		String prevnextlink			= "";
		int query_result_size		= 10;
		int start		= 0 ;
		int end			= 0 ;
		String drug_count = "1";	//Added for SRR20056-SCF-7734 ICN 28022
		sys_date		=getTodaysDate();

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

	     if ( to == null || to.equals(""))
		   end =query_result_size;
		 else
		   end = Integer.parseInt( to ) ;
		 
		 bl_installed_yn=bl_installed_yn_p;	
		 paid_status=paid_status_p;

		long count=0;
		long i = 0;

		String	patient_id						=	"";
		String	patient_name					=	"";
		String	disp_tmp_no						=	"";
		String	short_desc						=	"";
		String	disp_qty						=	"";
		String	record_date_time				=	"";
		String	added_by_id						=	"";
		String  doc_no							=	"";
		String  order_id						=	"";
		String  order_line_no					=	"";
		String append_qry						=	"";
		String doc_srl_no						=   "";
		String sal_trn_type						=	"";//patient class
		String encounter_id						=	"";
		String drg_disp_code					=	"";
		String drg_qty							=	"";
		String bl_override_excl_incl_ind		=	"";
		String bl_incl_excl_override_reason_code=	"";
		String pat_paid_flag					=	"";
		String pat_net_charge_amt				=	"";
		String doc_type							=	"";
		String paid_yn                          =   "";
		String ordering_facility_id             =   "";
		String pat_paid_amt						=   "";
		String ord_pat_class					=   "";
		String disp_uom="";//added for ML-BRU-SCF-1803.1
		//boolean full_discount_paid_flag__at_release_yn = false; // Added for SKR-SCF-1199 removed for skr-scf-1199
		
		ArrayList result			=	new ArrayList();
		//	all_records					=   new ArrayList(); //reassigned // commented for ML-BRU-SCF-0603 [IN:036245]
		try{
			setDisp_locn_code(disp_locn);
			getDispBillingStageDtl();
			connection			= getConnection() ;
		//	full_discount_paid_flag__at_release_yn = CommonBean.isSiteSpecific(connection, "PH", "DISCOUNT_PAID_FLAG_YN"); // Added for SKR-SCF-1199 removed for skr-scf-1199

			if(batches.equals("A")) {
				//Removed DESC order for the queries--- Added order by to_number(C.DISP_TMP_NO)==on 20/10/2010 for incident num:24007==By Sandhya
				append_qry	=	" AND TO_DATE(C.MODIFIED_DATE,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR') AND G.ORDER_LINE_STATUS IN('AL','IP') ORDER BY DISP_TMP_NO,C.MODIFIED_DATE, a.order_id, d.order_line_no";
			}
			else if(batches.equals("D")) {
				append_qry	=	" AND TO_DATE(C.MODIFIED_DATE,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR') AND G.ORDER_LINE_STATUS IN('DC') ORDER BY DISP_TMP_NO,C.MODIFIED_DATE, a.order_id, d.order_line_no  "; //A.MODIFIED_DATE to C.MODIFIED_DATE for SKR-SCF-1463
			} 
			else if(batches.equals("H")) {
				append_qry	=	" AND TO_DATE(C.MODIFIED_DATE,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR') AND G.ORDER_LINE_STATUS ='HC' ORDER BY DISP_TMP_NO, C.MODIFIED_DATE, a.order_id, d.order_line_no  "; // removed "and RESULT_LINE_STATUS in ('IP','AL')" for SRR20056-SCF-7582, SRR20056-SCF-7212.1, Incident No. 028146  //A.MODIFIED_DATE to C.MODIFIED_DATE for SKR-SCF-1463
			}
			else {
				append_qry	=	" AND TO_DATE(C.MODIFIED_DATE,'DD/MM/RRRR') BETWEEN TO_DATE(?,'DD/MM/RRRR') AND TO_DATE(?,'DD/MM/RRRR') AND G.ORDER_LINE_STATUS IN('AL','IP','DC') ORDER BY DISP_TMP_NO,C.MODIFIED_DATE, a.order_id, d.order_line_no ";

			}
           // pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_RELEASE_BATCHES_SELECT1")+append_qry) ;
		   //Modified Query By Naveen for getting ADDED-ID as Applusername,Patient name in thai for incident num:25007 on 19/Nov/2010
            //pstmt = connection.prepareStatement( "SELECT A.PERFORMING_DEPTLOC_CODE,A.ORDER_ID,D.ORDER_LINE_NO,to_number(C.DISP_TMP_NO) DISP_TMP_NO, d.DTL_SERIAL_NUM, C.FACILITY_ID DISP_FACILITY_ID, C.DOC_NO,C.DOC_TYPE,A.PATIENT_ID,nvl(decode(?,'en',B.PATIENT_NAME,b.PATIENT_NAME_LOC_LANG),b.patient_name)PATIENT_NAME,H.DRUG_DESC SHORT_DESC,D.DISP_QTY,D.DISP_UOM_CODE,D.BMS_QTY,TO_CHAR(C.RECORD_DATE_TIME,'DD/MM/YYYY') RECORD_DATE_TIME,(select APPL_USER_NAME from sm_appl_user_lang_vw where APPL_USER_ID=D.ADDED_BY_ID and language_id =?)ADDED_BY_ID, D.DISP_DRUG_CODE, D.DOC_SRL_NO ,A.ENCOUNTER_ID  ENCOUNTER_ID,a.ORDERING_FACILITY_ID ORDERING_FACILITY_ID, c.WORKSHEET_ID WORKSHEET_ID, a.iv_prep_yn iv_prep_yn, C.PATIENT_CLASS PATIENT_CLASS FROM OR_ORDER A,MP_PATIENT B,PH_DISP_HDR_TMP C,PH_DISP_DTL_TMP D,OR_ORDER_LINE G, PH_DRUG_LANG_VW H WHERE A.PATIENT_ID   = B.PATIENT_ID AND A.PATIENT_ID   = C.PATIENT_ID AND B.PATIENT_ID   = C.PATIENT_ID AND C.ORDER_ID     = D.ORDER_ID AND C.ORDER_ID     = A.ORDER_ID  AND G.ORDER_ID= D.ORDER_ID AND G.ORDER_LINE_NUM=D.ORDER_LINE_NO  and   C.ORDER_ID     = G.ORDER_ID AND A.ORDER_ID     = G.ORDER_ID  AND C.FACILITY_ID  = D.FACILITY_ID AND C.DISP_LOCN_CODE  = D.DISP_LOCN_CODE AND C.DISP_TMP_NO = D.DISP_TMP_NO AND D.DISP_DRUG_CODE = H.DRUG_CODE  and A.PERFORMING_DEPTLOC_CODE=? AND A.PATIENT_ID=NVL(?,A.PATIENT_ID)  AND D.DISP_DRUG_CODE = NVL(?,D.DISP_DRUG_CODE) AND H.LANGUAGE_ID = ? "+append_qry) ; //(select count(*) from ph_disp_drug_batch_tmp  where order_id =d.order_id  and order_line_num  =d.order_line_no)>0 and AND d.DISP_QTY >0 -- removed from SQL for ML-BRU-SCF-0674 [IN:037567]
			//, c.WORKSHEET_ID WORKSHEET_ID, a.iv_prep_yn iv_prep_yn added and nvl(IV_PREP_YN,'X') not in ('2','4','6','8','0') Commented for SRR20056-SCF-7734 ICN 28022
			StringBuilder sbSql = new StringBuilder("SELECT A.PERFORMING_DEPTLOC_CODE,A.ORDER_ID,D.ORDER_LINE_NO,to_number(C.DISP_TMP_NO) DISP_TMP_NO, d.DTL_SERIAL_NUM, C.FACILITY_ID DISP_FACILITY_ID, C.DOC_NO,C.DOC_TYPE,A.PATIENT_ID,nvl(decode(?,'en',B.PATIENT_NAME,b.PATIENT_NAME_LOC_LANG),b.patient_name)PATIENT_NAME,H.DRUG_DESC SHORT_DESC,D.DISP_QTY,D.DISP_UOM_CODE,D.BMS_QTY,TO_CHAR(C.RECORD_DATE_TIME,'DD/MM/YYYY') RECORD_DATE_TIME,(select APPL_USER_NAME from sm_appl_user_lang_vw where APPL_USER_ID=D.ADDED_BY_ID and language_id =?)ADDED_BY_ID, D.DISP_DRUG_CODE, D.DOC_SRL_NO ,A.ENCOUNTER_ID  ENCOUNTER_ID,a.ORDERING_FACILITY_ID ORDERING_FACILITY_ID, c.WORKSHEET_ID WORKSHEET_ID, a.iv_prep_yn iv_prep_yn, C.PATIENT_CLASS PATIENT_CLASS,a.source_code source_code FROM OR_ORDER A,MP_PATIENT B,PH_DISP_HDR_TMP C,PH_DISP_DTL_TMP D,OR_ORDER_LINE G, PH_DRUG_LANG_VW H WHERE A.PATIENT_ID   = B.PATIENT_ID AND A.PATIENT_ID   = C.PATIENT_ID AND B.PATIENT_ID   = C.PATIENT_ID AND C.ORDER_ID     = D.ORDER_ID AND C.ORDER_ID     = A.ORDER_ID  AND G.ORDER_ID= D.ORDER_ID AND G.ORDER_LINE_NUM=D.ORDER_LINE_NO  and   C.ORDER_ID     = G.ORDER_ID AND A.ORDER_ID     = G.ORDER_ID  AND C.FACILITY_ID  = D.FACILITY_ID AND C.DISP_LOCN_CODE  = D.DISP_LOCN_CODE AND C.DISP_TMP_NO = D.DISP_TMP_NO AND D.DISP_DRUG_CODE = H.DRUG_CODE  and A.PERFORMING_DEPTLOC_CODE=? "); //added Source_code for SKR-SCF-1614
			if(pat_id!=null && !pat_id.equals(""))
				sbSql.append(" AND A.PATIENT_ID=? ");
			if(durg_code!=null && !durg_code.equals(""))
				sbSql.append(" AND D.DISP_DRUG_CODE = ? ");
			sbSql.append(" AND H.LANGUAGE_ID = ? ");
			sbSql.append(append_qry);

			pstmt = connection.prepareStatement(sbSql.toString());
			//System.out.println("==>disp_locn==>"+disp_locn+"==>pat_id==>"+pat_id+"==>durg_code==>"+durg_code+"==locale=="+locale+"==dt_from=="+dt_from+"==dt_to=="+dt_to+"==append_qry=="+append_qry);
			int k=0;
			pstmt.setString(++k,locale);
			pstmt.setString(++k,locale);
			pstmt.setString(++k,disp_locn);
			if(pat_id!=null && !pat_id.equals(""))
				pstmt.setString(++k,pat_id);
			if(durg_code!=null && !durg_code.equals(""))
				pstmt.setString(++k,durg_code);
			pstmt.setString(++k,locale);
			pstmt.setString(++k,dt_from);
			pstmt.setString(++k,dt_to);

			resultSet	= pstmt.executeQuery();
			result.add("link");
			pstmt_drug_count = connection.prepareStatement("SELECT Count(*) NO_OF_DRUGS FROM OR_ORDER_LINE WHERE order_id =?" ) ;  //Added for SRR20056-SCF-7734 ICN 28022

			while( resultSet != null && resultSet.next() && i <= end+1 ) {
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else 
					i++;
				count++ ;
			
				if(i<=end) {
					order_id				=	checkForNull(resultSet.getString("ORDER_ID"));
					//Added for SRR20056-SCF-7734 ICN 28022 - Start
					pstmt_drug_count.setString(1,order_id);
					resultSet_drug_count = pstmt_drug_count.executeQuery();
					if(resultSet_drug_count!=null && resultSet_drug_count.next())
						drug_count = resultSet_drug_count.getString("NO_OF_DRUGS");

					if(drug_count==null || drug_count.equals(""))
						drug_count="1";
					closeResultSet(resultSet_drug_count);
					//Added for SRR20056-SCF-7734 ICN 28022 - End
					order_line_no			=	checkForNull(resultSet.getString("ORDER_LINE_NO"));
					patient_id				=	checkForNull(resultSet.getString("PATIENT_ID"));
					patient_name			=	checkForNull(resultSet.getString("PATIENT_NAME"));
					disp_tmp_no				=	checkForNull(resultSet.getString("DISP_TMP_NO"));
					doc_no					=	checkForNull(resultSet.getString("DOC_NO"));
					short_desc				=	checkForNull(resultSet.getString("SHORT_DESC"));
					disp_qty				=	checkForNull(resultSet.getString("DISP_QTY")) +" "+ checkForNull(resultSet.getString("DISP_UOM_CODE"));
					record_date_time		=	checkForNull(resultSet.getString("RECORD_DATE_TIME"));
					added_by_id				=	checkForNull(resultSet.getString("ADDED_BY_ID"));
					doc_srl_no				=	checkForNull(resultSet.getString("DOC_SRL_NO"));
					doc_type				=	checkForNull(resultSet.getString("DOC_TYPE"));
					ordering_facility_id	=	checkForNull(resultSet.getString("ORDERING_FACILITY_ID"));
					disp_uom=checkForNull(resultSet.getString("DISP_UOM_CODE"));//ADDED FOR ML-BRU-SCF-1803.1
					order_and_ord_facility.put(order_id,ordering_facility_id);

					if(bl_installed_yn.equals("Y")){
						HashMap chrg_dtl=	new HashMap();
						encounter_id	=	checkForNull(resultSet.getString("ENCOUNTER_ID"));
						sal_trn_type	=	getEncounterPatientClass(encounter_id,ordering_facility_id, patient_id); //patient_id added for [IN:035667] 
						drg_qty			=	checkForNull(resultSet.getString("DISP_QTY"));
						drg_disp_code	=	checkForNull(resultSet.getString("DISP_DRUG_CODE"));
						 // Added for ML-BRU-SCF-1803.1 - Start
					
						HashMap IssueUOMAndBaseUOM	=	(HashMap)new DispMedicationAllStages().getStoreDfltIssueUOMAndBaseUOM(disp_locn,drg_disp_code);
						
						String issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"); 
						
						if(issue_uom!= disp_uom){
							
							drg_qty =(int) (Double.parseDouble(drg_qty)* new DispMedicationAllStages().getEqulValue (drg_disp_code, issue_uom, disp_uom))+"";
						}
						// Added for ML-BRU-SCF-1803.1 - End
						
						//trade;batchid,exp_date,bin_loc,req_qty 
						chrg_dtl=callItemChargeDtls(patient_id,encounter_id,sal_trn_type,drg_disp_code,Integer.parseInt(drg_qty),this.getBatchString(order_id,order_line_no),sys_date,disp_locn,bl_override_excl_incl_ind,bl_incl_excl_override_reason_code,doc_type,doc_no,doc_srl_no,ordering_facility_id,order_id,order_line_no);//order_id,order_line_no added for MMS-DM-CRF-0126.1
						pat_paid_flag			=	(String)chrg_dtl.get("pat_paid_flag");
						pat_paid_amt			=	(String)chrg_dtl.get("pat_paid_amt");
						pat_net_charge_amt			=	(String)chrg_dtl.get("pat_net_charge_amt");
						if(pat_paid_flag.equals("0")||pat_paid_flag.equals("1")||pat_paid_flag.equals("2")){
							 paid_yn   ="Y";
							//if(pat_paid_flag.equals("0")&&pat_paid_amt.equals("0")||pat_paid_amt.equals("0.0")){
							//if(pat_paid_amt.equals("")|| Float.parseFloat(pat_paid_amt)==0){ //if block is added for ML-BRU-SCF-0269 
							if(getPatPaidYNForZeroBill().equals("Y")){
								if(((pat_paid_amt.equals("")|| Float.parseFloat(pat_paid_amt)==0) && (pat_net_charge_amt.equals("")|| Float.parseFloat(pat_net_charge_amt)==0))){ //Added for ML-BRU-SCF-1187 [IN:045600] // !full_discount_paid_flag__at_release_yn Added for SKR-SCF-1199//!full_discount_paid_flag__at_release_yn && removed for skr-scf-1199
									paid_yn   ="N";
								}
								else if(!pat_paid_amt.equals("") && Float.parseFloat(pat_paid_amt)!=0 && !pat_net_charge_amt.equals("") && Float.parseFloat(pat_net_charge_amt)!=0){  //if bloack added for SKR-LIVE-Supprt INT05
								//else if(((pat_paid_amt.equals("")|| Float.parseFloat(pat_paid_amt)==0) && (pat_net_charge_amt.equals("")|| Float.parseFloat(pat_net_charge_amt)==0)) ||(Float.parseFloat(pat_paid_amt)!=0 && Float.parseFloat(pat_net_charge_amt)!=0)){  //if bloack added for SKR-LIVE-Supprt INT05
									paid_yn   ="Y";
								}
							}
							/*else if(pat_paid_amt.equals("")|| Float.parseFloat(pat_paid_amt)==0){//else if block is added for ML-BRU-SCF-0269
								paid_yn   ="N";
							}*/
						}
						else{
							 paid_yn   ="N";   
						}
						
						if(paid_status.equals("A")){
							result.add(order_id); 
							result.add(order_line_no);
							result.add(patient_id);
							result.add(patient_name);
							result.add(disp_tmp_no);
							result.add(doc_no);
							result.add(short_desc);
							result.add(disp_qty);
							result.add(record_date_time);
							result.add(added_by_id);
							result.add(doc_srl_no);
							result.add(checkForNull(resultSet.getString("WORKSHEET_ID"))); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(checkForNull(resultSet.getString("IV_PREP_YN"))); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(drug_count); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(paid_yn);
							result.add(checkForNull(resultSet.getString("DISP_QTY"))); //Added for ML-BRU-SCF-0674 [IN:037567]
							result.add(checkForNull(resultSet.getString("BMS_QTY")));//Added for ML-BRU-SCF-0674 [IN:037567]
						}
						else if(paid_status.equals("P") && (paid_yn.equals("Y"))){
							result.add(order_id); 
							result.add(order_line_no);
							result.add(patient_id);
							result.add(patient_name);
							result.add(disp_tmp_no);
							result.add(doc_no);
							result.add(short_desc);
							result.add(disp_qty);
							result.add(record_date_time);
							result.add(added_by_id);
							result.add(doc_srl_no);
							result.add(checkForNull(resultSet.getString("WORKSHEET_ID"))); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(checkForNull(resultSet.getString("IV_PREP_YN"))); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(drug_count); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(paid_yn);
							result.add(checkForNull(resultSet.getString("DISP_QTY"))); //Added for ML-BRU-SCF-0674 [IN:037567]
							result.add(checkForNull(resultSet.getString("BMS_QTY")));//Added for ML-BRU-SCF-0674 [IN:037567]
						}
						else if(paid_status.equals("U") && (paid_yn.equals("N"))){
							result.add(order_id); 
							result.add(order_line_no);
							result.add(patient_id);
							result.add(patient_name);
							result.add(disp_tmp_no);
							result.add(doc_no);
							result.add(short_desc);
							result.add(disp_qty);
							result.add(record_date_time);
							result.add(added_by_id);
							result.add(doc_srl_no);
							result.add(checkForNull(resultSet.getString("WORKSHEET_ID"))); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(checkForNull(resultSet.getString("IV_PREP_YN"))); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(drug_count); //Added for SRR20056-SCF-7734 ICN 28022
							result.add(paid_yn);
							result.add(checkForNull(resultSet.getString("DISP_QTY"))); //Added for ML-BRU-SCF-0674 [IN:037567]
							result.add(checkForNull(resultSet.getString("BMS_QTY")));//Added for ML-BRU-SCF-0674 [IN:037567]
						}

					}
					else{
						result.add(order_id); 
						result.add(order_line_no);
						result.add(patient_id);
						result.add(patient_name);
						result.add(disp_tmp_no);
						result.add(doc_no);
						result.add(short_desc);
						result.add(disp_qty);
						result.add(record_date_time);
						result.add(added_by_id);
						result.add(doc_srl_no);
						result.add(checkForNull(resultSet.getString("WORKSHEET_ID"))); //Added for SRR20056-SCF-7734 ICN 28022
						result.add(checkForNull(resultSet.getString("IV_PREP_YN"))); //Added for SRR20056-SCF-7734 ICN 28022
						result.add(drug_count); //Added for SRR20056-SCF-7734 ICN 28022
						result.add(pat_paid_flag);
						result.add(checkForNull(resultSet.getString("DISP_QTY"))); //Added for ML-BRU-SCF-0674 [IN:037567]
						result.add(checkForNull(resultSet.getString("BMS_QTY"))); //Added for ML-BRU-SCF-0674 [IN:037567]
						result.add("N");
					}
				}
			}			

			if( start != 1 )
				prevnextlink = prevnextlink + "<td align='right'><a href=\"javascript:storeCheckedRecords();javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','prevnext')\">Previous&nbsp;&nbsp;</a>" ;
			
			if( count > 10 ){
				prevnextlink = prevnextlink + "<td align='right'><a href=\"javascript:storeCheckedRecords();javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','prevnext')\">Next</a>" ;
			}
			
			if(result!=null)	{
				result.set(0,prevnextlink);
			}

			if(record_status.size()==0) {
				resultSet_2	= pstmt.executeQuery(); 
             	while(resultSet_2!=null && resultSet_2.next()) {
					record_status.put(checkForNull(resultSet_2.getString("ORDER_ID"))+checkForNull(resultSet_2.getString("ORDER_LINE_NO"))+checkForNull(resultSet_2.getString("DOC_SRL_NO")),"N");
					all_records.add(checkForNull(resultSet_2.getString("ORDER_ID")));
					all_records.add(checkForNull(resultSet_2.getString("ORDER_LINE_NO")));
					all_records.add(checkForNull(resultSet_2.getString("DOC_NO")));
					all_records.add(checkForNull(resultSet_2.getString("DOC_TYPE")));
					all_records.add(checkForNull(resultSet_2.getString("DISP_DRUG_CODE")));
					all_records.add(checkForNull(resultSet_2.getString("DOC_SRL_NO")));
					ord_pat_class = checkForNull(resultSet_2.getString("PATIENT_CLASS"));
					if(ord_pat_class!=null && ord_pat_class.equals("OP")){
						all_records.add(getDispBillStageOP());
					}
					else{
						all_records.add(getDispBillStage());
					}
					all_records.add(checkForNull(resultSet_2.getString("DISP_QTY"))); //Added for ML-BRU-SCF-0674 [IN:037567]
					all_records.add(checkForNull(resultSet_2.getString("BMS_QTY"))); //Added for ML-BRU-SCF-0674 [IN:037567]
					all_records.add(checkForNull(resultSet_2.getString("DISP_TMP_NO"))); // Added for Bru-HIMS-CRF-414 [IN:045554] //9
					all_records.add(checkForNull(resultSet_2.getString("DTL_SERIAL_NUM"))); // Added for Bru-HIMS-CRF-414 [IN:045554] //10
					all_records.add(checkForNull(resultSet_2.getString("DISP_FACILITY_ID"))); // Added for Bru-HIMS-CRF-414 [IN:045554] //11
					
					all_records.add(checkForNull(resultSet_2.getString("ENCOUNTER_ID")));//Added for SKR-SCF-1614 //12
					all_records.add(checkForNull(resultSet_2.getString("PATIENT_CLASS")));//Added for SKR-SCF-1614 //13
					all_records.add(checkForNull(resultSet_2.getString("PATIENT_ID")));//Added for SKR-SCF-1614 //14
					all_records.add(checkForNull(resultSet_2.getString("SOURCE_CODE")));//Added for SKR-SCF-1614 //15
				}
			}
		}
		catch(Exception e){
				//System.err.println(e);
				e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet(resultSet_2);
				closeStatement( pstmt ) ;
				closeStatement( pstmt_drug_count ) ;
				closeResultSet( resultSet_drug_count ) ;
				closeConnection( connection );
			}
			catch(Exception es){		
				es.printStackTrace();
			}
		}
		return result;	
	}
// getReasonCodes returns the reason codes and its description for the APPL_TRN_TYPE in RP,RO

	public ArrayList getReasonCodes(String locale) {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList reasonCodes	= new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REASON_CODES_SELECT4" )) ;
			pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				reasonCodes.add(resultSet.getString("APPL_TRN_TYPE"));
				reasonCodes.add(resultSet.getString("REASON_CODE"));
				reasonCodes.add(resultSet.getString("REASON_DESC"));
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
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return reasonCodes;
	}

	public String checkforbillinginterface()throws Exception{
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet			    = null;	
		bl_interface_yn					= "N";
		try{
        connection = getConnection() ;
		pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2")) ;
		pstmt_select.setString(1,login_facility_id);
		resultSet				= pstmt_select.executeQuery();
        if (resultSet.next() ) {
			bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
			if(bl_interface_yn==null){
                bl_interface_yn="N";
			}
	    }
		}catch(Exception exception){
			
			exception.printStackTrace();
			throw exception;
		}
		finally{
			    closeResultSet( resultSet ) ;
				closeStatement( pstmt_select ) ;
				closeConnection( connection );
		}
		return bl_interface_yn;
	}

	//system date function
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
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				System.err.println("Error::"+es);
			}
		}
		return today_date;
	}

	// getting patientclass
	public String getEncounterPatientClass(String encounter_id,String ordering_facility_id, String patient_id) throws Exception{ //patient_id added for [IN:035667] 
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String patient_class	= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1")) ;
			
			pstmt.setString(1,ordering_facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,patient_id); //added for [IN:035667] to avaoid duplicate encounter id with 11111 for EXT Prescription
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				patient_class = checkForNull(resultSet.getString("ENC_PATIENT_CLASS"));
			}
		}catch ( Exception e ) {
			System.err.println( e ) ;
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
		}
		return patient_class;
	}

	//billing
	public HashMap callItemChargeDtls(String patient_id,String encounter_id,String sal_trn_type,String item_code,int item_qty,String batch_str,String sysdate,String store_code,String bl_override_excl_incl_ind,String bl_incl_excl_override_reason_code,String doc_type,String doc_no,String doc_srl_no,String ordering_facility_id,String order_id,String order_line_no)throws Exception{ //MMS-DM-CRF-0126.2
			
		Connection connection				= null;
		CallableStatement callableStatement = null;
		HashMap message						= new HashMap();

		String total_charge_amt		="";
		String patient_payable_amt	="";
		String grosschargeamt		="";
		//CallableStatement cstmt   = null ;
		/*PreparedStatement pstmt   = null;
		ResultSet rsDecimalPlace    = null;
		int decimal_place	        = 0;
		String decimalFormatString  = "##";
		*/
		//System.err.println("==login_facility_id===="+login_facility_id+"==patient_id====="+patient_id+"===encounter_id======"+encounter_id+"===sal_trn_type====="+sal_trn_type+"===="+item_code+"===item_qty===="+item_qty+"==batch_str===="+batch_str+"===store_code===="+store_code+"==bl_override_excl_incl_ind==="+bl_override_excl_incl_ind+"===bl_incl_excl_override_reason_code=="+bl_incl_excl_override_reason_code+"==doc_type==="+doc_type+"=doc_no===="+doc_no+"==doc_srl_no===="+doc_srl_no);

		try{
			connection = getConnection();
			callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			callableStatement.setString(1, ordering_facility_id+"|"+login_facility_id);
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
			callableStatement.setString(45, "");//added for Regression-12.x-ALPHA-SS-Incident No.#40744
			callableStatement.registerOutParameter(46, Types.VARCHAR); //added for JD-CRF-0170.1 [IN:040204]
			callableStatement.setString(47,order_id); //MMS-DM-CRF-0126.2
			callableStatement.setString(48, order_line_no);//MMS-DM-CRF-0126.2
System.err.println("ReleaseBatchesBean.java====842==order_id======>"+order_id+"==order_line_no==>"+order_line_no);
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
			patient_payable_amt   = callableStatement.getString(25);
			//message.put("custgrosschargeamt" , callableStatement.getString(26)+"");
			//message.put("custdiscamt" , callableStatement.getString(27)+"");
			//message.put("custnewamt" , callableStatement.getString(28)+"");			
			//message.put("insind" , checkForNull((String)callableStatement.getString(29)));
			message.put("error_id" , checkForNull((String)callableStatement.getString(33)));
			message.put("error_msg" , checkForNull((String)callableStatement.getString(34)));
			message.put("excl_incl_ind" , checkForNull((String)callableStatement.getString(35),"E"));
			message.put("approval_reqd_yn" , checkForNull((String)callableStatement.getString(36),"N"));
			message.put("override_allowed_yn" , checkForNull((String)callableStatement.getString(37),""));
			message.put("pat_paid_amt" , checkForNull((String)callableStatement.getString(38))); 
			message.put("pat_paid_flag" , checkForNull((String)callableStatement.getString(30)));
			message.put("pat_net_charge_amt" , checkForNull((String)callableStatement.getString(25)));
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
		finally{
			closeStatement(callableStatement);
			closeConnection(connection);
		}
		return message;
	}//end paid billing details

	public void getDispBillingStageDtl()throws Exception{
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getDisp_locn_code().trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				setDispBillStage(resultSet.getString("DISP_BILL_STAGE")==null?"X":resultSet.getString("DISP_BILL_STAGE"));
				setDispBillStageOP(resultSet.getString("DISP_BILL_STAGE_OP")==null?"X":resultSet.getString("DISP_BILL_STAGE_OP"));
			}
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
            catch(Exception es) { es.printStackTrace();}
        }
	}
//Added By Naveen for the incident num:23123 on 4/Oct/2010
	public String getBatchString(String order_id, String order_line_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		StringBuffer batch_str	=   new StringBuffer();

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( "SELECT ITEM_CODE, BATCH_ID, to_char(EXPIRY_DATE,'dd/mm/yyyy') expiry_date, STORE_CODE, DISP_QTY, DISP_QTY_UOM,trade_id,BIN_LOCATION_CODE FROM PH_DISP_DRUG_BATCH_TMP WHERE ORDER_ID=? AND ORDER_LINE_NUM=?") ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
//trade;batchid,exp_date,bin_loc,req_qty 
				batch_str.append(resultSet.getString("trade_id")).append(";").append(resultSet.getString("BATCH_ID")).append(";").append(resultSet.getString("expiry_date")).append(";").append(resultSet.getString("BIN_LOCATION_CODE")).append(";").append(resultSet.getString("DISP_QTY")).append(";");
			}						
		}
		catch(Exception e){
				//batch_details.add(e.toString());
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
		return batch_str.toString();	
	}
	public void getDefltValues() { //Added for SKR-SCF-0979 [IN:048119]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String crit_field_id = "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT CRIT_FIELD_ID, CRIT_FIELD_VAL  FROM PH_DISP_MEDN_DFLT WHERE FACILITY_ID = DECODE (?, FACILITY_ID, FACILITY_ID, '*A')   AND CRIT_FIELD_ID IN('PAT_PAID_YN_FOR_ZERO_BILL') ") ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null){
				while(resultSet.next()){
					crit_field_id = checkForNull(resultSet.getString("CRIT_FIELD_ID"));
					if(crit_field_id.equals("PAT_PAID_YN_FOR_ZERO_BILL"))
						setPatPaidYNForZeroBill(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));
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
}
