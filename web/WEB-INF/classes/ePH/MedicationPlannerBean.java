/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.Serializable ;
import java.text.DecimalFormat;
import java.util.* ;
import java.sql.* ;

import javax.ejb.EJBException;
import ePH.Common.* ;
import eCommon.Common.* ;

public class MedicationPlannerBean extends PhAdapter implements Serializable {
	
	protected LinkedHashMap hsh_med_plan = new LinkedHashMap();
	protected LinkedHashMap hsh_med_plan_local = new LinkedHashMap();
	protected HashMap hsh_howtotake = new HashMap<String,String>();
	protected HashMap hsh_howtotake_local = new HashMap<String,String>();
	protected HashMap hsh_imp_note = new HashMap<String,String>();
	protected HashMap hsh_imp_note_local = new HashMap<String,String>();
	protected HashMap hsh_drug_desc = new HashMap<String,String>();
	protected HashMap hsh_drug_desc_local = new HashMap<String,String>();
	private String strTotal_gross_charge_amount="";
	private String strTotal_gross_amount=""; // Added for ML-BRU-CRF-0469 [IN:065426] - Start
	private String strTotal_charge_amount="";
	public String getStrTotal_gross_amount() {
		return strTotal_gross_amount;
	}

	public void setStrTotal_gross_amount(String strTotal_gross_amount) {
		this.strTotal_gross_amount = strTotal_gross_amount;
	}

	public String getstrTotal_charge_amount() {
		return strTotal_charge_amount;
	}

	public void setstrTotal_charge_amount(String strTotal_charge_amount) {
		this.strTotal_charge_amount = strTotal_charge_amount;
	}  // Added for ML-BRU-CRF-0469 [IN:065426] - End
	private String strCalledFrom="";
	private String strPrimaryLangID="";
	private String strLocalLangID="";
	private String strSiteName="";
	private String strFacility_DispLoc="";
	private String strSiteNameLocal="";
	private String strFacility_DispLocLocal="";
	private boolean medValuesChanged=false;
	protected ArrayList medOrderIds= new ArrayList();
	protected ArrayList<String> mediplan_seq_no  =new ArrayList<String>();
	protected ArrayList<String> mediplan_report_query  =new ArrayList<String>();
	DispMedicationBean disp_bean = null;
	DispMedicationAllStages all_stages =null;
	public MedicationPlannerBean() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */

	public void setModuleId(String module_id) {
		this.module_id	=	module_id;
	}

	public String getModuleId() {
		return this.module_id;
	}
	
	public void setObject(DispMedicationBean disp_bean) {
		this.disp_bean = disp_bean;
	}
	
	public void setObject(DispMedicationAllStages all_stages) {
		this.all_stages = all_stages;
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

	public void getHeaderDetails()throws Exception{// Added for Bru-HIMS-CRF-072.1[IN 049144] start
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String facility="",disp_loc="";
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement("select site_name,facility_name from SM_SITE_PARAM_LANG_VW a,SM_FACILITY_PARAM_LANG_VW b where a.language_id=? and b.language_id=? and b.facility_id=?");
			pstmt.setString(1,getStrPrimaryLangID());
			pstmt.setString(2,getStrPrimaryLangID());
			pstmt.setString(3,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet.next()){
				setStrSiteName(checkForNull(resultSet.getString("site_name")));
				facility = checkForNull(resultSet.getString("facility_name"));
			}
			pstmt		= connection.prepareStatement("select short_desc from ph_disp_locn_lang_vw where disp_locn_code=? and language_id=?");
			pstmt.setString(1,disp_bean.getDispLocnCode());
			pstmt.setString(2,getStrPrimaryLangID());
			resultSet			= pstmt.executeQuery();
			if(resultSet.next()){
				disp_loc = checkForNull(resultSet.getString("short_desc"));
			}
			setStrFacility_DispLoc(login_facility_id+" - "+disp_loc+" ("+facility+")");
			
			pstmt		= connection.prepareStatement("select site_name,facility_name from SM_SITE_PARAM_LANG_VW a,SM_FACILITY_PARAM_LANG_VW b where a.language_id=? and b.language_id=? and b.facility_id=?");
			pstmt.setString(1,getStrLocalLangID());
			pstmt.setString(2,getStrLocalLangID());
			pstmt.setString(3,login_facility_id);
			resultSet			= pstmt.executeQuery();
			if(resultSet.next()){
				setStrSiteNameLocal(checkForNull(resultSet.getString("site_name")));
				facility = checkForNull(resultSet.getString("facility_name"));
			}
			pstmt		= connection.prepareStatement("select short_desc from ph_disp_locn_lang_vw where disp_locn_code=? and language_id=?");
			pstmt.setString(1,disp_bean.getDispLocnCode());
			pstmt.setString(2,getStrLocalLangID());
			resultSet			= pstmt.executeQuery();
			if(resultSet.next()){
				disp_loc = checkForNull(resultSet.getString("short_desc"));
			}
			setStrFacility_DispLocLocal(login_facility_id+" - "+disp_loc+" ("+facility+")");
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
	}
	public void setMedPlan_DrugDetails(String orderid_lineno_drugcode,LinkedHashMap hshTemp){
			hsh_med_plan.put(orderid_lineno_drugcode,hshTemp);
	}
	public LinkedHashMap getMedPlan_DrugDetails(){
		return hsh_med_plan;
	}
	public void clearMedPlan_DrugDetails(){
		hsh_med_plan.clear();
	}
	public void setMedPlan_Local_DrugDetails(String orderid_lineno_drugcode,LinkedHashMap hshTemp){
		hsh_med_plan_local.put(orderid_lineno_drugcode,hshTemp);
	}
	public LinkedHashMap getMedPlan_Local_DrugDetails(){
		return hsh_med_plan_local;
	}
	public void clearMedPlan_Local_DrugDetails(){
		hsh_med_plan_local.clear();
	}
	public void setDrug_Howtotake(String orderid_lineno_drugcode,String text){
		if(!hsh_howtotake.containsKey(orderid_lineno_drugcode)){
			hsh_howtotake.put(orderid_lineno_drugcode,text);
		}
	}
	public String getDrug_Howtotake(String drugcode){
		return (String)hsh_howtotake.get(drugcode);
	}
	public void setDrug_Howtotake_Local(String orderid_lineno_drugcode,String text){
		if(!hsh_howtotake_local.containsKey(orderid_lineno_drugcode)){
			hsh_howtotake_local.put(orderid_lineno_drugcode,text);
		}
	}
	public String getDrug_Howtotake_Local(String drugcode){
		return (String)hsh_howtotake_local.get(drugcode);
	}
	public void setDrug_ImpNote(String drugcode,String text){
		if(!hsh_imp_note.containsKey(drugcode)){
			hsh_imp_note.put(drugcode,text);
		}
	}
	public String getDrug_ImpNote(String drugcode){
		return (String)hsh_imp_note.get(drugcode);
	}
	public void setDrug_ImpNote_Local(String drugcode,String text){
		if(!hsh_imp_note_local.containsKey(drugcode)){
			hsh_imp_note_local.put(drugcode,text);
		}
	}
	public String getDrug_ImpNote_Local(String drugcode){
		return (String)hsh_imp_note_local.get(drugcode);
	}
	public String getDrug_desc_local(String drugcode) {
		return (String)hsh_drug_desc_local.get(drugcode);
	}
	public void setDrug_desc_local(String drugcode,String drug_desc) {
		if(!hsh_drug_desc_local.containsKey(drugcode)){
			hsh_drug_desc_local.put(drugcode,drug_desc);
		}
	}
	public String getDrug_desc(String drugcode) {
		return (String)hsh_drug_desc.get(drugcode);
	}
	public void setDrug_desc(String drugcode,String drug_desc) {
		if(!hsh_drug_desc.containsKey(drugcode)){
			hsh_drug_desc.put(drugcode,drug_desc);
		}
	}
	public String getStrTotal_gross_charge_amount() {
		return strTotal_gross_charge_amount;
	}
	public void setStrTotal_gross_charge_amount(String strTotal_gross_charge_amount) {
		this.strTotal_gross_charge_amount = strTotal_gross_charge_amount;
	}
	public ArrayList getMedOrderIds() {
		return medOrderIds;
	}
	public void setMedOrderIds(ArrayList medOrderIds) {
		this.medOrderIds = medOrderIds;
	}
	public ArrayList getMediPlanSeqNo(){ 
		return mediplan_seq_no;
	}
	public void setMediPlanSeqNo(String seq_no){ 
		if(!mediplan_seq_no.contains(seq_no))
			mediplan_seq_no.add(seq_no);
	}
	public void clearMediPlanSeqNo(){ 
		mediplan_seq_no.clear();
	}
	public String getStrCalledFrom() {
		return strCalledFrom;
	}
	public void setStrCalledFrom(String strCalledFrom) {
		this.strCalledFrom = strCalledFrom;
	}
	public boolean isMedValuesChanged() {
		return medValuesChanged;
	}
	public void setMedValuesChanged(boolean medValuesChanged) {
		this.medValuesChanged = medValuesChanged;
	}
	public String getStrPrimaryLangID() {
		return strPrimaryLangID;
	}
	public void setStrPrimaryLangID(String strPrimaryLangID) {
		this.strPrimaryLangID = strPrimaryLangID;
	}
	public String getStrLocalLangID() {
		return strLocalLangID;
	}

	public void setStrLocalLangID(String strLocalLangID) {
		this.strLocalLangID = strLocalLangID;
	}
	public String getStrSiteName() {
		return strSiteName;
	}
	public void setStrSiteName(String strSiteName) {
		this.strSiteName = strSiteName;
	}
	public String getStrFacility_DispLoc() {
		return strFacility_DispLoc;
	}
	public void setStrFacility_DispLoc(String strFacility_DispLoc) {
		this.strFacility_DispLoc = strFacility_DispLoc;
	}

	public String getStrSiteNameLocal() {
		return strSiteNameLocal;
	}

	public void setStrSiteNameLocal(String strSiteNameLocal) {
		this.strSiteNameLocal = strSiteNameLocal;
	}

	public String getStrFacility_DispLocLocal() {
		return strFacility_DispLocLocal;
	}

	public void setStrFacility_DispLocLocal(String strFacility_DispLocLocal) {
		this.strFacility_DispLocLocal = strFacility_DispLocLocal;
	}

	public ArrayList<String> getMediplan_report_query() {
		return mediplan_report_query;
	}
	public void setMediplan_report_query(ArrayList<String> mediplan_report_query) {
		this.mediplan_report_query = mediplan_report_query;
	}
	public String[] getDoseDetails(String order_id,String order_line_no,String lang_id,String pres_drug_code,String disp_drug_code) throws Exception{
		Connection connection	= null ;
		CallableStatement cstmt	= null;
		String  strDose[] = new String[4];
		try{
			connection	= getConnection();
			cstmt=connection.prepareCall("{call ph_get_dosage_timings(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, login_facility_id);
			cstmt.setString(2, order_id);
			cstmt.setString(3, order_line_no);
			cstmt.setString(4, lang_id);
			cstmt.setString(5, pres_drug_code);
			cstmt.setString(6, disp_drug_code);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.execute();
			strDose[0]	= checkForNull(cstmt.getString(7));
			strDose[1]	= checkForNull(cstmt.getString(8));
			strDose[2]	= checkForNull(cstmt.getString(9));
			strDose[3]	= checkForNull(cstmt.getString(10));
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return strDose;
	}
	public int[] getCountActiveDrugs(String patient_id, String calledfrom) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		int count[] = {0,0,0,0,0};
		int i=0;
		StringBuilder sb = new StringBuilder(),medplanid= new StringBuilder();
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_ACTIVEORDER_COUNT"));
			pstmt.setString(++i,getLanguageId());
			pstmt.setString(++i,getLanguageId());
			pstmt.setString(++i,patient_id);
			pstmt.setString(++i,getLanguageId());
			pstmt.setString(++i,getLanguageId());
			pstmt.setString(++i,getLanguageId());
			pstmt.setString(++i,getLanguageId());
			pstmt.setString(++i,getLanguageId());
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				count[0] = resultSet.getInt("count");		
			}
			i=0;
			if(calledfrom.equals("Report")){
				sb = new StringBuilder(PhRepository.getPhKeyValue("SQL_SELECT_PH_MED_PLAN_COUNT_REPORT"));
				ArrayList<String> mediplan_report_query=getMediplan_report_query();
				if(mediplan_report_query.size()>0){
					if(!mediplan_report_query.get(5).equals(""))
						sb.append("AND ENCOUNTER_ID=?");
					pstmt = connection.prepareStatement(sb.toString());
					pstmt.setString(++i,login_facility_id);
					pstmt.setString(++i,patient_id);
					pstmt.setString(++i,mediplan_report_query.get(2));//Date from
					pstmt.setString(++i,mediplan_report_query.get(3));//Date to
					pstmt.setString(++i,mediplan_report_query.get(4));//Dispense Location
					pstmt.setString(++i,mediplan_report_query.get(1));//Plan id
					pstmt.setString(++i,getStrPrimaryLangID());
					if(!mediplan_report_query.get(5).equals(""))
						pstmt.setString(++i,mediplan_report_query.get(5));//Encounter id
					resultSet = pstmt.executeQuery();
					if(resultSet.next()){
						count[1] = resultSet.getInt("count");	
						count[2] = resultSet.getInt("maxid");
					}
					
					pstmt = connection.prepareStatement(sb.toString());
					pstmt.setString(++i,login_facility_id);
					pstmt.setString(++i,patient_id);
					pstmt.setString(++i,mediplan_report_query.get(2));//Date from
					pstmt.setString(++i,mediplan_report_query.get(3));//Date to
					pstmt.setString(++i,mediplan_report_query.get(4));//Dispense Location
					pstmt.setString(++i,mediplan_report_query.get(1));//Plan id
					pstmt.setString(++i,getStrLocalLangID());
					if(!mediplan_report_query.get(5).equals(""))
						pstmt.setString(++i,mediplan_report_query.get(5));//Encounter id
					resultSet = pstmt.executeQuery();
					if(resultSet.next()){
						count[3] = resultSet.getInt("count");
						count[4] = resultSet.getInt("maxid");// Added for [IN:051822]
					}
				}
			}
			else{
				sb = new StringBuilder(PhRepository.getPhKeyValue("SQL_SELECT_PH_MED_PLAN_COUNT"));
				ArrayList<String> arrtemp = (ArrayList)getMediPlanSeqNo();
				if(getMediPlanSeqNo().size()>0){
					for (String temp: arrtemp)
						medplanid.append("'"+temp+"',");
					sb.append(" AND MED_PLAN_ID NOT IN ("+medplanid.substring(0, medplanid.length()-1)+")");
				}
				pstmt = connection.prepareStatement(sb.toString());
				pstmt.setString(++i,login_facility_id);
				pstmt.setString(++i,patient_id);
				pstmt.setString(++i,getStrPrimaryLangID());
				resultSet = pstmt.executeQuery();
				if(resultSet.next()){
					count[1] = resultSet.getInt("count");	
					count[2] = resultSet.getInt("maxid");
				}
				i=0;
				pstmt = connection.prepareStatement(sb.toString());
				pstmt.setString(++i,login_facility_id);
				pstmt.setString(++i,patient_id);
				pstmt.setString(++i,getStrLocalLangID());
				resultSet = pstmt.executeQuery();
				if(resultSet.next()){
					count[3] = resultSet.getInt("count");
					count[4] = resultSet.getInt("maxid");// Added for [IN:051822]
				}
			}
		}
		catch ( Exception e ) {
			System.err.println("===SQL in getCountActiveDrugs=="+sb.toString());
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
		return count;
	}
	public void updateMediPlan(String patient_id,String mediplan_seq_no) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt_insert	= null,ps=null,pstmt_update=null,pstmt_update1=null ;
		ResultSet resultSet		= null,rs=null ;
		int count=0,rowcount=0;
		boolean boolmedplan=false,boolmedplanlocal=false;
		String strarrKey[] = new String[4];
		try{
			connection = getConnection() ;
			HashMap hshmedplan = getMedPlan_DrugDetails();
			HashMap hshmedplanlocal =  getMedPlan_Local_DrugDetails();
			HashMap hshTemp = new HashMap();
			Set <String> hshKeys = new HashSet<String>();
			Set <String> hshlocalKeys = new HashSet<String>();
			hshKeys = hshmedplan.keySet();
			hshlocalKeys = hshmedplanlocal.keySet();
			String disp_stage=disp_bean.getDispStage(),disp_no="",disp_srl_no="";
			if(disp_stage.equals("AS"))
				disp_stage="D";
			if(getStrCalledFrom().equals("Report"))
				disp_stage=getMediplan_report_query().get(6);
			pstmt_update	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_UPDATE"));
			pstmt_insert	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_INSERT"));
			pstmt_update1	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_UPDATE1"));
			if((hshKeys!=null && hshKeys.size()>0)||(hshlocalKeys!=null && hshlocalKeys.size()>0)){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplan = true;
					}
				}
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplanlocal = true;
					}
				}
			}
			if(boolmedplan){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){   
						count=0;
						strarrKey = key.split("_");
						ps	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_INSERT_CHECK"));
						ps.setString(1, mediplan_seq_no);
						ps.setString(2, strarrKey[3]);
						ps.setString(3, strarrKey[0]);
						ps.setString(4, strarrKey[1]);
						ps.setString(5, strarrKey[2]);
						rs = ps.executeQuery();
						if(rs.next())
							rowcount = rs.getInt(1);
						if(rowcount>0){
							pstmt_update.setString(++count, disp_stage);
							pstmt_update.setString(++count, (String)hshTemp.get("qty_issue"));
							pstmt_update.setString(++count, (String)hshTemp.get("howtotake"));
							pstmt_update.setString(++count, (String)hshTemp.get("impnote"));
							pstmt_update.setString(++count, (String)hshTemp.get("morning"));
							pstmt_update.setString(++count, (String)hshTemp.get("afternoon"));
							pstmt_update.setString(++count, (String)hshTemp.get("evening"));
							pstmt_update.setString(++count, (String)hshTemp.get("night"));
							pstmt_update.setString(++count, (String)hshTemp.get("chkdrug"));			
							pstmt_update.setString(++count, login_by_id);
							pstmt_update.setString(++count, login_at_ws_no);
							pstmt_update.setString(++count, login_facility_id);
							pstmt_update.setString(++count, patient_id);
							pstmt_update.setString(++count, mediplan_seq_no);
							pstmt_update.setString(++count, strarrKey[0]);
							pstmt_update.setString(++count, strarrKey[1]);
							pstmt_update.setString(++count, strarrKey[3]);
							pstmt_update.setString(++count, strarrKey[2]);
							pstmt_update.addBatch();
						}
						else{
							if(((String)hshTemp.get("curr_disp_yn")).equals("Y")){
								ps = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_DISP_NO")); 
								ps.setString(1, (String)hshTemp.get("order_id")); 
								ps.setString(2, (String)hshTemp.get("order_line_no")); 
								ps.setString(3, (String)hshTemp.get("order_id")); 
								ps.setString(4, (String)hshTemp.get("order_line_no"));
								rs= ps.executeQuery();
								if(rs.next()){
									disp_no = rs.getString("DISP_NO");
									disp_srl_no = rs.getString("DISP_SRL_NO");
								}
							}
							pstmt_insert.setString(++count, mediplan_seq_no);
							pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, disp_bean.getDispLocnCode());
							pstmt_insert.setString(++count, patient_id);
							pstmt_insert.setString(++count, disp_bean.getEncounterID());
							pstmt_insert.setString(++count, disp_stage);
							pstmt_insert.setString(++count, (String)hshTemp.get("order_id")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
							pstmt_insert.setString(++count, disp_no);
							pstmt_insert.setString(++count, disp_srl_no);
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
							pstmt_insert.setString(++count, (String)hshTemp.get("qty_issue"));
							pstmt_insert.setString(++count, (String)hshTemp.get("howtotake"));
							pstmt_insert.setString(++count, (String)hshTemp.get("impnote"));
							pstmt_insert.setString(++count, (String)hshTemp.get("morning"));
							pstmt_insert.setString(++count, (String)hshTemp.get("afternoon"));
							pstmt_insert.setString(++count, (String)hshTemp.get("evening"));
							pstmt_insert.setString(++count, (String)hshTemp.get("night"));
							pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
							pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);				
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.addBatch();
						}	
				   }
					else{// Reason : Insert 2 drugs in english , 2 drugs in local. Then uncheck 2 drugs from local, we have to update eff_status as D
						pstmt_update1.setString(1, (String)hshTemp.get("chkdrug"));			
						pstmt_update1.setString(2, login_by_id);
						pstmt_update1.setString(3, login_at_ws_no);
						pstmt_update1.setString(4, login_facility_id);
						pstmt_update1.setString(5, patient_id);
						pstmt_update1.setString(6, mediplan_seq_no);
						pstmt_update1.setString(7, strarrKey[0]);
						pstmt_update1.setString(8, strarrKey[1]);
						pstmt_update1.setString(9, strarrKey[3]);
						pstmt_update1.setString(10,strarrKey[2]);
						pstmt_update1.addBatch();
					}
				}
			}
			
			if(boolmedplanlocal){
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){           
						count=0;
						strarrKey = key.split("_");
						ps	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_INSERT_CHECK"));
						ps.setString(1, mediplan_seq_no);
						ps.setString(2, strarrKey[3]);
						ps.setString(3, strarrKey[0]);
						ps.setString(4, strarrKey[1]);
						ps.setString(5, strarrKey[2]);
						rs = ps.executeQuery();
						if(rs.next())
							rowcount = rs.getInt(1);
						if(rowcount>0){
							pstmt_update.setString(++count, disp_stage);
							pstmt_update.setString(++count, (String)hshTemp.get("qty_issuelocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("howtotakelocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("impnotelocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("morninglocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("afternoonlocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("eveninglocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("nightlocal"));
							pstmt_update.setString(++count, (String)hshTemp.get("chkdrug"));			
							pstmt_update.setString(++count, login_by_id);
							pstmt_update.setString(++count, login_at_ws_no);
							pstmt_update.setString(++count, login_facility_id);
							pstmt_update.setString(++count, patient_id);
							pstmt_update.setString(++count, mediplan_seq_no);
							pstmt_update.setString(++count, strarrKey[0]);
							pstmt_update.setString(++count, strarrKey[1]);
							pstmt_update.setString(++count, strarrKey[3]);
							pstmt_update.setString(++count, strarrKey[2]);
							pstmt_update.addBatch();
						}
						else{
							if(((String)hshTemp.get("curr_disp_yn")).equals("Y")){
								ps = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_DISP_NO")); 
								ps.setString(1, (String)hshTemp.get("order_id")); 
								ps.setString(2, (String)hshTemp.get("order_line_no")); 
								ps.setString(3, (String)hshTemp.get("order_id")); 
								ps.setString(4, (String)hshTemp.get("order_line_no"));
								rs= ps.executeQuery();
								if(rs.next()){
									disp_no = rs.getString("DISP_NO");
									disp_srl_no = rs.getString("DISP_SRL_NO");
								}
							}
							pstmt_insert.setString(++count, mediplan_seq_no);
							pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.setString(++count, disp_bean.getDispLocnCode());
							pstmt_insert.setString(++count, patient_id);
							pstmt_insert.setString(++count, disp_bean.getEncounterID());
							pstmt_insert.setString(++count, disp_stage);
							pstmt_insert.setString(++count, (String)hshTemp.get("order_id")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no")); 
							pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
							pstmt_insert.setString(++count, disp_no);
							pstmt_insert.setString(++count, disp_srl_no);
							pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
							pstmt_insert.setString(++count, (String)hshTemp.get("qty_issuelocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("howtotakelocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("impnotelocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("morninglocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("afternoonlocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("eveninglocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("nightlocal"));
							pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
							pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
							pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);				
							pstmt_insert.setString(++count, login_by_id);
							pstmt_insert.setString(++count, login_at_ws_no);
							pstmt_insert.setString(++count, login_facility_id);
							pstmt_insert.addBatch();
						}	
				   }
					else{
						pstmt_update1.setString(1, (String)hshTemp.get("chkdrug"));			
						pstmt_update1.setString(2, login_by_id);
						pstmt_update1.setString(3, login_at_ws_no);
						pstmt_update1.setString(4, login_facility_id);
						pstmt_update1.setString(5, patient_id);
						pstmt_update1.setString(6, mediplan_seq_no);
						pstmt_update1.setString(7, strarrKey[0]);
						pstmt_update1.setString(8, strarrKey[1]);
						pstmt_update1.setString(9, strarrKey[3]);
						pstmt_update1.setString(10,strarrKey[2]);
						pstmt_update1.addBatch();
					}
				}
			}
			if(pstmt_update!=null){
				int[] result=pstmt_update.executeBatch();
				for (int k=0;k<result.length ;k++ ){
					if(result[k]<0  && result[k] != -2 ){
						pstmt_update.cancel();
						connection.rollback();
						throw new EJBException("Error: Update Medication Plan Failed");
					}		
				}
			}
			if(pstmt_insert!=null){
				int[] result1=pstmt_insert.executeBatch();
				for (int k=0;k<result1.length ;k++ ){
					if(result1[k]<0  && result1[k] != -2 ){
						pstmt_insert.cancel();
						connection.rollback();
						throw new EJBException("Error: Insert Medication Plan Failed");
					}		
				}
			}
			if(pstmt_update1!=null){
				int[] result=pstmt_update1.executeBatch();
				for (int k=0;k<result.length ;k++ ){
					if(result[k]<0  && result[k] != -2 ){
						pstmt_update1.cancel();
						connection.rollback();
						throw new EJBException("Error: Update1 Medication Plan Failed");
					}		
				}
			}
			connection.commit();
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( rs ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_update1 ) ;
				closeStatement( ps ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}
	public void insertMediPlan(String patient_id) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt_insert	= null,pstmt=null ;
		ResultSet rs=null ;
		int count=0;String seq_no="",disp_no="",disp_srl_no="";
		boolean insertdone = false,boolmedplan=false,boolmedplanlocal=false;
		try{
			connection = getConnection() ;
			pstmt_insert	= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MEDICATION_PLAN_INSERT")); 
			String disp_stage=disp_bean.getDispStage();
			if(disp_stage.equals("AS"))
				disp_stage="D";
			HashMap hshmedplan = getMedPlan_DrugDetails();
			HashMap hshmedplanlocal = getMedPlan_Local_DrugDetails();
			HashMap hshTemp = new HashMap();
			Set <String> hshKeys = new HashSet<String>();
			Set <String> hshlocalKeys = new HashSet<String>();
			hshKeys = hshmedplan.keySet();
			hshlocalKeys = hshmedplanlocal.keySet();
			if((hshKeys!=null && hshKeys.size()>0)||(hshlocalKeys!=null && hshlocalKeys.size()>0)){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplan = true;
					}
				}
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){
						boolmedplanlocal = true;
					}
				}
			}
			if(boolmedplan || boolmedplanlocal)
				seq_no=getSequenceNo(PhRepository.getPhKeyValue("SQL_PH_MED_PLAN_ID_SEQ"));
			if(boolmedplan){
				for(String key:hshKeys){
					hshTemp = (HashMap)hshmedplan.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){           
						count=0;
						if(((String)hshTemp.get("curr_disp_yn")).equals("Y")){
							pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_DISP_NO")); 
							pstmt.setString(1, (String)hshTemp.get("order_id")); 
							pstmt.setString(2, (String)hshTemp.get("order_line_no")); 
							pstmt.setString(3, (String)hshTemp.get("order_id")); 
							pstmt.setString(4, (String)hshTemp.get("order_line_no"));
							rs= pstmt.executeQuery();
							if(rs.next()){
								disp_no = rs.getString("DISP_NO");
								disp_srl_no = rs.getString("DISP_SRL_NO");
							}
						}
						pstmt_insert.setString(++count, seq_no);
						pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
						pstmt_insert.setString(++count, login_facility_id);
						pstmt_insert.setString(++count, disp_bean.getDispLocnCode());
						pstmt_insert.setString(++count, patient_id);
						pstmt_insert.setString(++count, disp_bean.getEncounterID());
						pstmt_insert.setString(++count, disp_stage);
						pstmt_insert.setString(++count, (String)hshTemp.get("order_id")); 
						pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no")); 
						pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
						pstmt_insert.setString(++count, disp_no);
						pstmt_insert.setString(++count, disp_srl_no);
						pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
						pstmt_insert.setString(++count, (String)hshTemp.get("qty_issue"));
						pstmt_insert.setString(++count, (String)hshTemp.get("howtotake"));
						pstmt_insert.setString(++count, (String)hshTemp.get("impnote"));
						pstmt_insert.setString(++count, (String)hshTemp.get("morning"));
						pstmt_insert.setString(++count, (String)hshTemp.get("afternoon"));
						pstmt_insert.setString(++count, (String)hshTemp.get("evening"));
						pstmt_insert.setString(++count, (String)hshTemp.get("night"));
						pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
						pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
						pstmt_insert.setString(++count, login_by_id);
						pstmt_insert.setString(++count, login_at_ws_no);
						pstmt_insert.setString(++count, login_facility_id);				
						pstmt_insert.setString(++count, login_by_id);
						pstmt_insert.setString(++count, login_at_ws_no);
						pstmt_insert.setString(++count, login_facility_id);
						pstmt_insert.addBatch();
				   }
				}
			}
			if(boolmedplanlocal){
				for(String key:hshlocalKeys){
					hshTemp = (HashMap)hshmedplanlocal.get(key);
					if(((String)hshTemp.get("plan_recorded")).equals("Y")){           
						count=0;
						if(((String)hshTemp.get("curr_disp_yn")).equals("Y")){
							pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_DISP_NO")); 
							pstmt.setString(1, (String)hshTemp.get("order_id")); 
							pstmt.setString(2, (String)hshTemp.get("order_line_no")); 
							pstmt.setString(3, (String)hshTemp.get("order_id")); 
							pstmt.setString(4, (String)hshTemp.get("order_line_no"));
							rs= pstmt.executeQuery();
							if(rs.next()){
								disp_no = rs.getString("DISP_NO");
								disp_srl_no = rs.getString("DISP_SRL_NO");
							}
						}
						pstmt_insert.setString(++count, seq_no);
						pstmt_insert.setString(++count, (String)hshTemp.get("lang_id"));
						pstmt_insert.setString(++count, login_facility_id);
						pstmt_insert.setString(++count, disp_bean.getDispLocnCode());
						pstmt_insert.setString(++count, patient_id);
						pstmt_insert.setString(++count, disp_bean.getEncounterID());
						pstmt_insert.setString(++count, disp_stage);
						pstmt_insert.setString(++count, (String)hshTemp.get("order_id")); 
						pstmt_insert.setString(++count, (String)hshTemp.get("order_line_no")); 
						pstmt_insert.setString(++count, (String)hshTemp.get("pres_drug_code"));
						pstmt_insert.setString(++count, disp_no);
						pstmt_insert.setString(++count, disp_srl_no);
						pstmt_insert.setString(++count, (String)hshTemp.get("disp_drug_code"));
						pstmt_insert.setString(++count, (String)hshTemp.get("qty_issuelocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("howtotakelocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("impnotelocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("morninglocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("afternoonlocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("eveninglocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("nightlocal"));
						pstmt_insert.setString(++count, (String)hshTemp.get("curr_disp_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merge_yn"));
						pstmt_insert.setString(++count, (String)hshTemp.get("merged_med_plan_id"));
						pstmt_insert.setString(++count, (String)hshTemp.get("chkdrug"));
						pstmt_insert.setString(++count, login_by_id);
						pstmt_insert.setString(++count, login_at_ws_no);
						pstmt_insert.setString(++count, login_facility_id);				
						pstmt_insert.setString(++count, login_by_id);
						pstmt_insert.setString(++count, login_at_ws_no);
						pstmt_insert.setString(++count, login_facility_id);
						pstmt_insert.addBatch();
				   }
				}
			}
			int[] result=pstmt_insert.executeBatch();
			for (int k=0;k<result.length ;k++ ){
				if(result[k]<0  && result[k] != -2 ){
					pstmt_insert.cancel();
					connection.rollback();
					insertdone=false;
					break;
				}
				else 
					insertdone=true;
			} 
			connection.commit();
			if(insertdone)
				setMediPlanSeqNo(seq_no);
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( rs ) ;
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}
	public HashMap getMergeMediPlanDetails(String patient_id, String mediplanid,String calledfrom,String language_id) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet rs		= null ;
		HashMap hshmergeplan = new HashMap(),hshtmp = new HashMap(),drugdet=new HashMap();
		String key="";int i=0;
		try{
			connection = getConnection() ;
			if(calledfrom.equals("Report")){
				StringBuilder sb = new StringBuilder(PhRepository.getPhKeyValue("SQL_SELECT_PH_MED_PLAN_MERGE_REPORT"));
				ArrayList<String> mediplan_report_query=getMediplan_report_query();
				if(mediplan_report_query.size()>0){
					if(!mediplan_report_query.get(5).equals(""))
						sb.append("AND ENCOUNTER_ID=?");
					pstmt = connection.prepareStatement(sb.toString());
					pstmt.setString(++i,login_facility_id);
					pstmt.setString(++i,patient_id);
					pstmt.setString(++i,mediplan_report_query.get(2));//Date from
					pstmt.setString(++i,mediplan_report_query.get(3));//Date to
					pstmt.setString(++i,mediplan_report_query.get(4));//Dispense Location
					pstmt.setString(++i,mediplan_report_query.get(1));//Plan id
					pstmt.setString(++i,language_id);
					if(!mediplan_report_query.get(5).equals(""))
						pstmt.setString(++i,mediplan_report_query.get(5));//Encounter id
				}
			}
			else{
				pstmt	   = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_PH_MED_PLAN_MERGE"));
				pstmt.setString(++i,login_facility_id);
				pstmt.setString(++i,patient_id);
				pstmt.setString(++i,mediplanid);
				pstmt.setString(++i,language_id);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				hshtmp = new HashMap();
				drugdet = getDrugDesc(rs.getString("DISP_DRUG_CODE"), rs.getString("LANGUAGE_ID"),checkForNull(rs.getString("ORDER_ID")),checkForNull(rs.getString("ORDER_LINE_NUM")));
				key = rs.getString("ORDER_ID")+"_"+rs.getString("ORDER_LINE_NUM")+"_"+rs.getString("DISP_DRUG_CODE")+"_"+rs.getString("LANGUAGE_ID");
				hshtmp.put("drug_name",(String)drugdet.get("DRUG_DESC"));
				hshtmp.put("qty_issue",checkForNull(rs.getString("ISSUE_QTY_DTL")));
				hshtmp.put("qty_issuelocal",checkForNull(rs.getString("ISSUE_QTY_DTL")));
				hshtmp.put("merged_med_plan_id",checkForNull(rs.getString("MED_PLAN_ID")));
				hshtmp.put("pres_drug_code",checkForNull(rs.getString("PRES_DRUG_CODE")));
				hshtmp.put("disp_drug_code",checkForNull(rs.getString("DISP_DRUG_CODE")));
				hshtmp.put("order_id",checkForNull(rs.getString("ORDER_ID")));
				hshtmp.put("order_line_no",checkForNull(rs.getString("ORDER_LINE_NUM")));
				hshtmp.put("lang_id",checkForNull(rs.getString("LANGUAGE_ID")));
				hshtmp.put("morning",checkForNull(rs.getString("DOSE_MORNING")));
				hshtmp.put("afternoon",checkForNull(rs.getString("DOSE_AFTERNOON")));
				hshtmp.put("evening",checkForNull(rs.getString("DOSE_EVENING")));
				hshtmp.put("night",checkForNull(rs.getString("DOSE_NIGHT")));
				hshtmp.put("morninglocal",checkForNull(rs.getString("DOSE_MORNING")));
				hshtmp.put("afternoonlocal",checkForNull(rs.getString("DOSE_AFTERNOON")));
				hshtmp.put("eveninglocal",checkForNull(rs.getString("DOSE_EVENING")));
				hshtmp.put("nightlocal",checkForNull(rs.getString("DOSE_NIGHT")));
				hshtmp.put("impnote",checkForNull(rs.getString("IMPORTANT_NOTE")));
				hshtmp.put("impnotelocal",checkForNull(rs.getString("IMPORTANT_NOTE")));
				hshtmp.put("howtotake",checkForNull(rs.getString("HOW_TO_TAKE")));
				hshtmp.put("howtotakelocal",checkForNull(rs.getString("HOW_TO_TAKE")));
				hshtmp.put("disp_no",checkForNull(rs.getString("DISP_NO")));
				hshtmp.put("disp_srl_no",checkForNull(rs.getString("DISP_SRL_NO")));
				hshmergeplan.put(key, hshtmp);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return hshmergeplan;
	}
	public void setMediplanDetails(ArrayList orderIds, String patient_id) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet rs		= null ;
		StringBuilder sb=new StringBuilder();
		try{
			connection = getConnection() ;
			if(orderIds!=null && orderIds.size()>0){
				for(int i=0;i<orderIds.size();i++)
					sb.append("'"+orderIds.get(i)+"',");
				pstmt	   = connection.prepareStatement("SELECT DISP_TMP_NO,DTL_SERIAL_NUM FROM PH_DISP_DTL_TMP WHERE ORDER_ID ||'_'||ORDER_LINE_NO IN ("+sb.substring(0, sb.length()-1)+")");
				rs = pstmt.executeQuery();
				sb=new StringBuilder();
				while(rs.next()){
					sb.append("'"+rs.getString("DISP_TMP_NO")+"_"+rs.getString("DTL_SERIAL_NUM")+"',");
				}
				if(sb.length()>3){
					pstmt	   = connection.prepareStatement("SELECT DISTINCT(MED_PLAN_ID) FROM PH_MEDICATION_PLAN WHERE PATIENT_ID=? AND DISP_NO ||'_'||DISP_SRL_NO IN ("+sb.substring(0, sb.length()-1)+")");
					pstmt.setString(1,patient_id);
					rs = pstmt.executeQuery();
					sb=new StringBuilder();
					while(rs.next()){
						sb.append("'"+rs.getString("MED_PLAN_ID")+"',");
						setMediPlanSeqNo(rs.getString("MED_PLAN_ID"));
					}
					if(sb.length()>3){
						getDetailsBasedonMedPlanid(patient_id,sb);
					}
				}
					
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}
	public String getSequenceNo(String sql)throws Exception{
		String seq_no = "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( sql ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				seq_no = resultSet.getString("NEXTVAL");
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
		return seq_no;
	}
	public String[] getDispNumber(String order_id,String order_line_no) throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		String  strDisp[] = new String[2];
		try{
			connection	= getConnection();
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_DISP_NO")) ;
			pstmt.setString(1, order_id); 
			pstmt.setString(2, order_line_no); 
			pstmt.setString(3, order_id); 
			pstmt.setString(4, order_line_no);
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next()){
				strDisp[0] = resultSet.getString("DISP_NO");
				strDisp[1] = resultSet.getString("DISP_SRL_NO");
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
		return strDisp;
	}
	public ArrayList getDispLocation() {// Offline print
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT3" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocation.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocation.add( resultSet.getString( "SHORT_DESC" ) );
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
			es.printStackTrace() ;
			}
		}

		return displocation;
	}
	public String getPatientIDLength(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement("SELECT PATIENT_ID_LENGTH FROM MP_PARAM WHERE MODULE_ID='MP' ") ;
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
	}
	public ArrayList getMedPlanBasedOnQuery(String patient_id,String order_date_from,String order_date_to,String encounter_id,String disp_locn_code,String disp_locn_desc) throws Exception{
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;
		ArrayList arrResult = new ArrayList();
		int i=0;
		try{
			connection			= getConnection() ;
			String maxplanid="";
			StringBuilder sbQuery = new StringBuilder("SELECT MAX(max_id) max_id FROM (SELECT MAX(med_plan_id) max_id FROM ph_medication_plan mp, ph_disp_hdr dh WHERE mp.patient_id = ? AND mp.facility_id = ? AND mp.disp_locn_code = ? AND mp.disp_no IS NOT NULL AND mp.disp_no = dh.disp_no AND mp.facility_id = dh.facility_id AND dh.disp_date_time BETWEEN TO_DATE (?, 'DD/MM/RRRR') AND TO_DATE (?, 'DD/MM/RRRR')+ 0.99999 AND mp.eff_status = 'E' UNION ALL(SELECT MAX (med_plan_id) max_id FROM ph_medication_plan mp, ph_disp_hdr_tmp dh WHERE mp.patient_id = ? AND mp.facility_id = ? AND mp.disp_locn_code = ? AND mp.disp_no IS NOT NULL AND mp.disp_no = dh.disp_tmp_no AND mp.facility_id = dh.facility_id AND dh.record_date_time BETWEEN TO_DATE (?, 'DD/MM/RRRR') AND  TO_DATE (?, 'DD/MM/RRRR')+ 0.99999 AND mp.eff_status = 'E'))");
			if(!encounter_id.equals("") )
				sbQuery.append(" AND ENCOUNTER_ID=?");
			pstmt = connection.prepareStatement(sbQuery.toString()) ;
			pstmt.setString(++i,patient_id);
			pstmt.setString(++i,login_facility_id); 
			pstmt.setString(++i,disp_locn_code); 
			pstmt.setString(++i,order_date_from);
			pstmt.setString(++i,order_date_to);
			pstmt.setString(++i,patient_id);
			pstmt.setString(++i,login_facility_id); 
			pstmt.setString(++i,disp_locn_code); 
			pstmt.setString(++i,order_date_from);
			pstmt.setString(++i,order_date_to);
			if(!encounter_id.equals("") )
				pstmt.setString(6,encounter_id);
			resultSet	= pstmt.executeQuery(); 
			if(resultSet.next() ) {
				maxplanid= checkForNull(resultSet.getString("MAX_ID"));
			}
			if(!maxplanid.equals("")){
				arrResult.add(patient_id);
				arrResult.add(disp_bean.getPatient_name(patient_id,getLanguageId()));
				arrResult.add(disp_locn_desc);
				arrResult.add(maxplanid);

				pstmt = connection.prepareStatement("SELECT ENCOUNTER_ID,STAGE_IND FROM PH_MEDICATION_PLAN WHERE MED_PLAN_ID=? AND ROWNUM<2") ;
				pstmt.setString(1,maxplanid);
				resultSet	= pstmt.executeQuery(); 
				if(resultSet.next()){
					arrResult.add(resultSet.getString("ENCOUNTER_ID"));
					arrResult.add(resultSet.getString("STAGE_IND"));
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
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return arrResult;
	}
	public void getDetailsBasedonMedPlanid(String patient_id,StringBuilder sb)throws Exception{
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet rs		= null ;
		try{
			LinkedHashMap<String,String> hshmap = new LinkedHashMap<String,String>(),hshtempmap = new LinkedHashMap<String,String>();
			HashMap<String,String> drugdet = new HashMap<String,String>();
			HashMap<String,Object> hshCompare=new HashMap<String,Object>();
			String loc_lang_id = getStrLocalLangID(),primary_lang_id = getStrPrimaryLangID(),lang_id="",order_id="",order_line_no="",drug_code="";
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement("select MED_PLAN_ID,LANGUAGE_ID,FACILITY_ID,DISP_LOCN_CODE,PATIENT_ID,ENCOUNTER_ID,STAGE_IND,ORDER_ID,ORDER_LINE_NUM,PRES_DRUG_CODE,DISP_NO,DISP_SRL_NO,DISP_DRUG_CODE,ISSUE_QTY_DTL,HOW_TO_TAKE,IMPORTANT_NOTE,DOSE_MORNING,DOSE_AFTERNOON,DOSE_EVENING,DOSE_NIGHT,CURR_DISPENSE_YN,MERGED_YN,MERGED_MED_PLAN_ID,EFF_STATUS from PH_MEDICATION_PLAN where PATIENT_ID=? and MED_PLAN_ID in ("+sb.substring(0, sb.length()-1)+") and EFF_STATUS='E'");
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				hshmap = new LinkedHashMap();
				order_id = rs.getString("ORDER_ID");
				order_line_no = rs.getString("ORDER_LINE_NUM");
				drug_code = rs.getString("DISP_DRUG_CODE");
				hshmap.put("med_plan_id",rs.getString("MED_PLAN_ID"));
				hshmap.put("drug_code",drug_code);
				hshmap.put("qty_issue",checkForNull(rs.getString("ISSUE_QTY_DTL")));
				hshmap.put("qty_issuelocal",checkForNull(rs.getString("ISSUE_QTY_DTL")));
				hshmap.put("curr_disp_yn",rs.getString("CURR_DISPENSE_YN"));
				hshmap.put("merge_yn",rs.getString("MERGED_YN"));
				hshmap.put("merged_med_plan_id",checkForNull(rs.getString("MERGED_MED_PLAN_ID")));
				hshmap.put("pres_drug_code",rs.getString("PRES_DRUG_CODE"));
				hshmap.put("disp_drug_code",rs.getString("DISP_DRUG_CODE"));
				hshmap.put("impnote",checkForNull(rs.getString("IMPORTANT_NOTE")));
				hshmap.put("impnotelocal",checkForNull(rs.getString("IMPORTANT_NOTE")));
				hshmap.put("howtotake",checkForNull(rs.getString("HOW_TO_TAKE")));
				hshmap.put("howtotakelocal",checkForNull(rs.getString("HOW_TO_TAKE")));
				hshmap.put("order_id",order_id);
				hshmap.put("order_line_no",order_line_no);
				lang_id = rs.getString("LANGUAGE_ID");
				drugdet = getDrugDesc(drug_code,lang_id,order_id,order_line_no);
				hshmap.put("drug_name_local",drugdet.get("DRUG_DESC"));
				hshmap.put("drug_name",drugdet.get("DRUG_DESC"));
				hshmap.put("morning",checkForNull(rs.getString("DOSE_MORNING")));
				hshmap.put("afternoon",checkForNull(rs.getString("DOSE_AFTERNOON")));
				hshmap.put("evening",checkForNull(rs.getString("DOSE_EVENING")));
				hshmap.put("night",checkForNull(rs.getString("DOSE_NIGHT")));
				hshmap.put("morninglocal",checkForNull(rs.getString("DOSE_MORNING")));
				hshmap.put("afternoonlocal",checkForNull(rs.getString("DOSE_AFTERNOON")));
				hshmap.put("eveninglocal",checkForNull(rs.getString("DOSE_EVENING")));
				hshmap.put("nightlocal",checkForNull(rs.getString("DOSE_NIGHT")));
				hshmap.put("chkdrug",rs.getString("EFF_STATUS"));
				hshmap.put("checked","checked");
				hshmap.put("disp_no",checkForNull(rs.getString("DISP_NO")));
				hshmap.put("disp_srl_no",checkForNull(rs.getString("DISP_SRL_NO")));
				hshmap.put("medicationplanner_flag", "true");//added for ML-BRU-SCF-1521.1 [IN:055331](medication planner point alone)
				
				if(lang_id.equals(primary_lang_id)){
						setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id, hshmap);
						hshCompare.put(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id, hshmap);
				}
				else if(lang_id.equals(loc_lang_id)){
						setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hshmap);
						hshCompare.put(order_id+"_"+order_line_no+"_"+drug_code+"_"+lang_id, hshmap);
				}
			}
			if(getStrCalledFrom().equals("Report")){
				if(getMedPlan_DrugDetails().size()==0 || getMedPlan_Local_DrugDetails().size()==0){
					Set <String> hshKeys = new HashSet<String>();
					hshKeys = hshCompare.keySet();
					if(getMedPlan_DrugDetails().size()==0){
						for(String key : hshKeys){
							hshtempmap = (LinkedHashMap)hshCompare.get(key);
							hshmap = new LinkedHashMap();
							drugdet = getDrugDesc(hshtempmap.get("drug_code"),getStrPrimaryLangID(),hshtempmap.get("order_id"),hshtempmap.get("order_line_no"));
							hshmap.put("med_plan_id",hshtempmap.get("med_plan_id"));
							hshmap.put("drug_code",hshtempmap.get("drug_code"));
							hshmap.put("qty_issue",hshtempmap.get("qty_issue"));
							hshmap.put("qty_issuelocal",hshtempmap.get("qty_issuelocal"));
							hshmap.put("curr_disp_yn",hshtempmap.get("curr_disp_yn"));
							hshmap.put("merge_yn",hshtempmap.get("merge_yn"));
							hshmap.put("merged_med_plan_id",hshtempmap.get("merged_med_plan_id"));
							hshmap.put("pres_drug_code",hshtempmap.get("pres_drug_code"));
							hshmap.put("disp_drug_code",hshtempmap.get("disp_drug_code"));
							hshmap.put("impnote",drugdet.get("IMPNOTE"));
							hshmap.put("impnotelocal",drugdet.get("IMPNOTE"));
							hshmap.put("howtotake",drugdet.get("HOW_TO_TAKE_TEXT"));
							hshmap.put("howtotakelocal",drugdet.get("HOW_TO_TAKE_TEXT"));
							hshmap.put("order_id",hshtempmap.get("order_id"));
							hshmap.put("order_line_no",hshtempmap.get("order_line_no"));
							hshmap.put("drug_name",drugdet.get("DRUG_DESC"));
							hshmap.put("drug_name_local","");
							hshmap.put("morning",hshtempmap.get("morning"));
							hshmap.put("afternoon",hshtempmap.get("afternoon"));
							hshmap.put("evening",hshtempmap.get("evening"));
							hshmap.put("night",hshtempmap.get("night"));
							hshmap.put("morninglocal",hshtempmap.get("morninglocal"));
							hshmap.put("afternoonlocal",hshtempmap.get("afternoonlocal"));
							hshmap.put("eveninglocal",hshtempmap.get("eveninglocal"));
							hshmap.put("nightlocal",hshtempmap.get("nightlocal"));
							hshmap.put("chkdrug",hshtempmap.get("chkdrug"));
							hshmap.put("checked","checked");
							hshmap.put("disp_no",hshtempmap.get("disp_no"));
							hshmap.put("disp_srl_no",hshtempmap.get("disp_srl_no"));
							setMedPlan_DrugDetails(hshtempmap.get("order_id")+"_"+hshtempmap.get("order_line_no")+"_"+hshtempmap.get("drug_code")+"_"+primary_lang_id, hshmap);
						}
					}
					else if(getMedPlan_Local_DrugDetails().size()==0){
						for(String key : hshKeys){
							hshmap = new LinkedHashMap();
							hshtempmap = (LinkedHashMap)hshCompare.get(key);
							drugdet = getDrugDesc(hshtempmap.get("drug_code"),loc_lang_id,hshtempmap.get("order_id"),hshtempmap.get("order_line_no"));
							hshmap.put("med_plan_id",hshtempmap.get("med_plan_id"));
							hshmap.put("drug_code",hshtempmap.get("drug_code"));
							hshmap.put("qty_issue",hshtempmap.get("qty_issue"));
							hshmap.put("qty_issuelocal",hshtempmap.get("qty_issuelocal"));
							hshmap.put("curr_disp_yn",hshtempmap.get("curr_disp_yn"));
							hshmap.put("merge_yn",hshtempmap.get("merge_yn"));
							hshmap.put("merged_med_plan_id",hshtempmap.get("merged_med_plan_id"));
							hshmap.put("pres_drug_code",hshtempmap.get("pres_drug_code"));
							hshmap.put("disp_drug_code",hshtempmap.get("disp_drug_code"));
							hshmap.put("impnote",drugdet.get("IMPNOTE"));
							hshmap.put("impnotelocal",drugdet.get("IMPNOTE"));
							hshmap.put("howtotake",drugdet.get("HOW_TO_TAKE_TEXT"));
							hshmap.put("howtotakelocal",drugdet.get("HOW_TO_TAKE_TEXT"));
							hshmap.put("order_id",hshtempmap.get("order_id"));
							hshmap.put("order_line_no",hshtempmap.get("order_line_no"));
							hshmap.put("drug_name_local",drugdet.get("DRUG_DESC"));
							hshmap.put("drug_name","");
							hshmap.put("morning",hshtempmap.get("morning"));
							hshmap.put("afternoon",hshtempmap.get("afternoon"));
							hshmap.put("evening",hshtempmap.get("evening"));
							hshmap.put("night",hshtempmap.get("night"));
							hshmap.put("morninglocal",hshtempmap.get("morninglocal"));
							hshmap.put("afternoonlocal",hshtempmap.get("afternoonlocal"));
							hshmap.put("eveninglocal",hshtempmap.get("eveninglocal"));
							hshmap.put("nightlocal",hshtempmap.get("nightlocal"));
							hshmap.put("chkdrug",hshtempmap.get("chkdrug"));
							hshmap.put("checked","checked");
							hshmap.put("disp_no",hshtempmap.get("disp_no"));
							hshmap.put("disp_srl_no",hshtempmap.get("disp_srl_no"));
							setMedPlan_Local_DrugDetails(hshtempmap.get("order_id")+"_"+hshtempmap.get("order_line_no")+"_"+hshtempmap.get("drug_code")+"_"+loc_lang_id, hshmap);
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
	}
	private HashMap getDrugDesc(String drug_code,String langid,String order_id, String order_line_num)throws Exception{
		HashMap<String,String> hshmap = new HashMap<String,String>();
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		StringBuilder sb = new StringBuilder();
		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT DRUG_CODE,DRUG_DESC,DRUG_INDICATION,HOW_TO_TAKE_TEXT,(SELECT LABEL_TEXT_1 FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_TYPE='C' AND EFF_STATUS='E' AND LANGUAGE_ID =? AND LABEL_TEXT_ID=CAUTION_LABEL_TEXT_ID_1) CAUTION,(SELECT LABEL_TEXT_1 FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_TYPE='S' AND EFF_STATUS='E' AND LANGUAGE_ID =? AND LABEL_TEXT_ID=SPL_INSTR_LABEL_TEXT_ID) SPLINS FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID=? AND DRUG_CODE =?") ;
			pstmt.setString(1,langid);
			pstmt.setString(2,langid);
			pstmt.setString(3,langid);
			pstmt.setString(4,drug_code);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				hshmap.put("DRUG_DESC",checkForNull(resultSet.getString("DRUG_DESC")));
				sb= new StringBuilder();
				if(!checkForNull(resultSet.getString("DRUG_INDICATION")).equals(""))
					sb.append(checkForNull(resultSet.getString("DRUG_INDICATION"))+"\n");
				if(!checkForNull(resultSet.getString("HOW_TO_TAKE_TEXT")).equals(""))
					sb.append(checkForNull(resultSet.getString("HOW_TO_TAKE_TEXT"))+"\n");
				if(!checkForNull(resultSet.getString("CAUTION")).equals(""))
					sb.append(checkForNull(resultSet.getString("CAUTION"))+"\n");
				if(!checkForNull(resultSet.getString("SPLINS")).equals(""))
					sb.append(checkForNull(resultSet.getString("SPLINS")));
				hshmap.put("IMPNOTE",sb.toString());
			}
			pstmt		= connection.prepareStatement( "select ph_dosage_details(?,?,?,?,?,?) dosage_dtl from dual") ; 
			pstmt.setString(1,login_facility_id);  
			pstmt.setString(2,langid);
			pstmt.setString(3,drug_code);  
			pstmt.setString(4,drug_code);
			pstmt.setString(5,order_id);
			pstmt.setString(6,order_line_num);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				hshmap.put("HOW_TO_TAKE_TEXT", checkForNull(resultSet.getString("DOSAGE_DTL")));
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
		return hshmap;
	}
	public void getPrescribeDrugDetails(StringBuilder sb) throws Exception{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet rs		= null;
		StringBuilder sb1 = new StringBuilder();
		try {
			connection	= getConnection() ;
			String strLocalLangId = getStrLocalLangID();
			String strPrimaryLangID = getStrPrimaryLangID();
			pstmt = connection.prepareStatement("SELECT DRUG_CODE,DRUG_DESC,DRUG_INDICATION,HOW_TO_TAKE_TEXT,(SELECT LABEL_TEXT_1 FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_TYPE='C' AND EFF_STATUS='E' AND LANGUAGE_ID =? AND LABEL_TEXT_ID=CAUTION_LABEL_TEXT_ID_1) CAUTION,(SELECT LABEL_TEXT_1 FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_TYPE='S' AND EFF_STATUS='E' AND LANGUAGE_ID =? AND LABEL_TEXT_ID=SPL_INSTR_LABEL_TEXT_ID) SPLINS FROM PH_DRUG_LANG_VW WHERE DRUG_CODE IN ("+sb.substring(0, sb.length()-1)+") AND LANGUAGE_ID=? ") ;
			pstmt.setString(1,strPrimaryLangID);
			pstmt.setString(2,strPrimaryLangID);
			pstmt.setString(3,strPrimaryLangID);
			rs	= pstmt.executeQuery();
			while (rs.next() ) {
				setDrug_desc(rs.getString("DRUG_CODE"), checkForNull(rs.getString("DRUG_DESC")));
				sb1= new StringBuilder();
				if(!checkForNull(rs.getString("DRUG_INDICATION")).equals(""))
					sb1.append(checkForNull(rs.getString("DRUG_INDICATION"))+"\n");
				if(!checkForNull(rs.getString("HOW_TO_TAKE_TEXT")).equals(""))
					sb1.append(checkForNull(rs.getString("HOW_TO_TAKE_TEXT"))+"\n");
				if(!checkForNull(rs.getString("CAUTION")).equals(""))
					sb1.append(checkForNull(rs.getString("CAUTION"))+"\n");
				if(!checkForNull(rs.getString("SPLINS")).equals(""))
					sb1.append(checkForNull(rs.getString("SPLINS")));
				setDrug_ImpNote(rs.getString("DRUG_CODE"), sb1.toString());
			}
			pstmt = connection.prepareStatement("SELECT DRUG_CODE,DRUG_DESC,DRUG_INDICATION,HOW_TO_TAKE_TEXT,(SELECT LABEL_TEXT_1 FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_TYPE='C' AND EFF_STATUS='E' AND LANGUAGE_ID =? AND LABEL_TEXT_ID=CAUTION_LABEL_TEXT_ID_1) CAUTION,(SELECT LABEL_TEXT_1 FROM PH_LABEL_TEXT_LANG_VW PH_LABEL_TEXT WHERE LABEL_TEXT_TYPE='S' AND EFF_STATUS='E' AND LANGUAGE_ID =? AND LABEL_TEXT_ID=SPL_INSTR_LABEL_TEXT_ID) SPLINS FROM PH_DRUG_LANG_VW WHERE DRUG_CODE IN ("+sb.substring(0, sb.length()-1)+") AND LANGUAGE_ID=? ") ;
			pstmt.setString(1,strLocalLangId);
			pstmt.setString(2,strLocalLangId);
			pstmt.setString(3,strLocalLangId);
			rs	= pstmt.executeQuery();
			while (rs.next()) {
				setDrug_desc_local(rs.getString("DRUG_CODE"), checkForNull(rs.getString("DRUG_DESC")));
				sb1= new StringBuilder();
				if(!checkForNull(rs.getString("DRUG_INDICATION")).equals(""))
					sb1.append(checkForNull(rs.getString("DRUG_INDICATION"))+"\n");
				if(!checkForNull(rs.getString("HOW_TO_TAKE_TEXT")).equals(""))
					sb1.append(checkForNull(rs.getString("HOW_TO_TAKE_TEXT"))+"\n");
				if(!checkForNull(rs.getString("CAUTION")).equals(""))
					sb1.append(checkForNull(rs.getString("CAUTION"))+"\n");
				if(!checkForNull(rs.getString("SPLINS")).equals(""))
					sb1.append(checkForNull(rs.getString("SPLINS")));
				setDrug_ImpNote_Local(rs.getString("DRUG_CODE"), sb1.toString());
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
	}
	public void getTotalPrice_Report(String medplanid,String patient_id,String disp_loc_code,String encounter_id) throws Exception{
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		CallableStatement callableStatement = null;
		List<String> arrList = new ArrayList<String>();
		ResultSet rs1 = null,rs=null;
		double dbl_pat_net_amt =0,item_qty=0,dbl_charge_amt=0,dbl_gross_amt=0;  // dbl_charge_amt=0,dbl_gross_amt=0 Added for ML-BRU-CRF-0469 [IN:065426]
		String sysdate="",orderingFacility="",sal_trn_type="",patient_class="",patient_payable_amt="",disp_stage="",disp_no="",disp_srl_no="";
		String order_id="",order_line_no="",item_code="",batch_str="",key="",patient_charge_amt="",patient_gross_amt=""; // patient_charge_amt="",patient_gross_amt="" Added for ML-BRU-CRF-0469 [IN:065426]
		boolean addPrice=false;
		String dischargeIND="";//ADDED FOR ML-BRU-SCF-1885
		try{
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT A.DISP_DRUG_CODE,B.BILLABLE_ITEM_YN,TO_CHAR(SYSDATE,'DD/MM/YYYY') TOADYDATE,A.ORDER_ID,A.ORDER_LINE_NUM,A.STAGE_IND,A.DISP_NO,A.DISP_SRL_NO FROM PH_MEDICATION_PLAN A,PH_DRUG B WHERE A.DISP_DRUG_CODE = B.DRUG_CODE AND A.MED_PLAN_ID=? AND A.CURR_DISPENSE_YN='Y' AND a.EFF_STATUS='E'");
			pstmt.setString(1,medplanid);
			rs1	= pstmt.executeQuery();
			while(rs1.next()){
				key = rs1.getString("ORDER_ID")+"~"+rs1.getString("ORDER_LINE_NUM")+"~"+rs1.getString("DISP_DRUG_CODE");
				if(!arrList.contains(key)){
					arrList.add(key);
					addPrice = true;}
				else 
					addPrice = false;
				if(rs1.getString("BILLABLE_ITEM_YN").equals("Y") && addPrice){
					sysdate = rs1.getString("TOADYDATE");
					disp_stage = checkForNull(rs1.getString("STAGE_IND"));
					disp_no = checkForNull(rs1.getString("DISP_NO"));
					disp_srl_no	= checkForNull(rs1.getString("DISP_SRL_NO"));
					order_id = checkForNull(rs1.getString("ORDER_ID"));
					order_line_no = checkForNull(rs1.getString("ORDER_LINE_NUM"));
					pstmt = connection.prepareStatement("SELECT PATIENT_CLASS,ORDERING_FACILITY_ID,HOME_LEAVE_MEDN_YN FROM OR_ORDER WHERE ORDER_ID=?");// HOME_LEAVE_MEDN_YN ADDED FOR ML-BRU-SCF-1885
					pstmt.setString(1,order_id);
					rs	= pstmt.executeQuery();
					if(rs.next()){
						orderingFacility = checkForNull(rs.getString("ORDERING_FACILITY_ID"));
						patient_class = checkForNull(rs.getString("PATIENT_CLASS"));
						dischargeIND=checkForNull(rs.getString("HOME_LEAVE_MEDN_YN"));//ADDED FOR ML-BRU-SCF-1885
						if(patient_class.equals("OP"))
							sal_trn_type = "O";
						else if(patient_class.equals("DC"))
							sal_trn_type = "D";
						else if(!(patient_class.equals("IP")||patient_class.equals("EM")))
							sal_trn_type = "R";	
					}
					if(disp_stage.equals("D")){
						pstmt = connection.prepareStatement("SELECT B.ITEM_CODE,B.DISP_QTY,TRADE_ID||';'||BATCH_ID||';'| |TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')||';'||BIN_LOCATION_CODE||';'||B.DISP_QTY||';' BATCH_STR FROM PH_DISP_DRUG_BATCH A,PH_DISP_DTL B WHERE A.DISP_LOCN_CODE(+)=B.DISP_LOCN_CODE AND A.DISP_NO(+)=B.DISP_NO AND A.SRL_NO(+)= B.SRL_NO AND A.FACILITY_ID =? AND A.DISP_LOCN_CODE=? AND A.DISP_NO=? AND A.SRL_NO=? ");
						pstmt.setString(1,login_facility_id);
						pstmt.setString(2,disp_loc_code);
						pstmt.setString(3,disp_no);
						pstmt.setString(4,disp_srl_no);
					}
					else{
						pstmt = connection.prepareStatement("SELECT ITEM_CODE,B.DISP_QTY,TRADE_ID||';'||BATCH_ID||';'| |TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')||';'||BIN_LOCATION_CODE||';'||B.DISP_QTY||';' BATCH_STR FROM PH_DISP_DRUG_BATCH_TMP A,PH_DISP_DTL_TMP B WHERE A.FACILITY_ID =? AND A.DISP_LOCN_CODE(+)=B.DISP_LOCN_CODE AND A.ORDER_ID(+)=B.ORDER_ID AND A.ORDER_LINE_NUM(+)= B.ORDER_LINE_NO AND A.DISP_LOCN_CODE=? AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=?");
						pstmt.setString(1,login_facility_id);
						pstmt.setString(2,disp_loc_code);
						pstmt.setString(3,order_id);
						pstmt.setString(4,order_line_no);
					}
					rs	= pstmt.executeQuery();
					if(rs.next()){
						item_code = checkForNull(rs.getString("ITEM_CODE"));
						item_qty = Double.parseDouble(checkForNull(rs.getString("DISP_QTY")));
						batch_str = checkForNull(rs.getString("BATCH_STR"));
					}
					//ADDED FOR ML-BRU-SCF-1885 START
					pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1")) ;
					pstmt.setString(1,orderingFacility);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,patient_id); 
					rs	= pstmt.executeQuery() ;
					if(rs.next()){
						sal_trn_type = checkForNull(rs.getString("ENC_PATIENT_CLASS"));
					}
					//ADDED FOR ML-BRU-SCF-1885 END
						
					callableStatement	= connection.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"); // ?,? added for MMS-MD-SCF-0102
					callableStatement.setString(1, orderingFacility+"|"+login_facility_id);
					callableStatement.setString(2, patient_id);
					callableStatement.setString(3, "PH");
					callableStatement.setString(4, encounter_id);
					callableStatement.setString(5, sal_trn_type);
					callableStatement.setString(6, sysdate);
					callableStatement.setString(7, item_code);
					callableStatement.setString(8, disp_loc_code);
					callableStatement.setDouble(9, item_qty);
					callableStatement.setString(10,batch_str);
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
					callableStatement.setString(39, "");
				    callableStatement.setString(40, "");
					callableStatement.setString(41, "N"); 
					callableStatement.setString(42, "");
					callableStatement.setString(43, "");
					callableStatement.setString(44, "");
					callableStatement.setString(45,dischargeIND );//MODIFIED FOR ML-BRU-SCF-1885
					callableStatement.registerOutParameter(46, Types.VARCHAR); 
					callableStatement.setString(47,order_id);//added for MMS-MD-SCF-0102
					callableStatement.setString(48, order_line_no);//added for MMS-MD-SCF-0102
					callableStatement.execute();
					
					patient_payable_amt   = checkForNull(callableStatement.getString(25),"0");
					patient_charge_amt    = checkForNull(callableStatement.getString(21),"0"); // Added for ML-BRU-CRF-0469 [IN:065426] - Start
					patient_gross_amt    = checkForNull(callableStatement.getString(19),"0");
					dbl_pat_net_amt += Double.parseDouble(patient_payable_amt);
					dbl_charge_amt  += Double.parseDouble(patient_charge_amt); 
					dbl_gross_amt  += Double.parseDouble(patient_gross_amt); // Added for ML-BRU-CRF-0469 [IN:065426] - End
				}
			}
			DecimalFormat df = new DecimalFormat("#.##");
			df.format(dbl_pat_net_amt);
			setStrTotal_gross_charge_amount(dbl_pat_net_amt+"");
			setStrTotal_gross_amount(dbl_gross_amt+""); // Added for ML-BRU-CRF-0469 [IN:065426]
			setstrTotal_charge_amount(dbl_charge_amt+""); // Added for ML-BRU-CRF-0469 [IN:065426]
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
	}
	public void getDosageDetails(String pres_drug_code,String disp_drug_code,String order_id,String order_line_no) throws Exception{
		Connection connection = null;
		PreparedStatement pstmt	= null;
		ResultSet rSet		= null;
		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "select ph_dosage_details(?,?,?,?,?,?) dosage_dtl from dual") ; 
			pstmt.setString(1,login_facility_id);  
			pstmt.setString(2,getStrPrimaryLangID());
			pstmt.setString(3,pres_drug_code);  
			pstmt.setString(4,disp_drug_code);
			pstmt.setString(5,order_id);
			pstmt.setString(6,order_line_no);
			rSet	= pstmt.executeQuery() ;
			if(rSet.next())
				setDrug_Howtotake(order_id+"~"+order_line_no+"~"+disp_drug_code, checkForNull(rSet.getString("DOSAGE_DTL")));
			
			pstmt		= connection.prepareStatement( "select ph_dosage_details(?,?,?,?,?,?) dosage_dtl from dual") ; 
			pstmt.setString(1,login_facility_id);  
			pstmt.setString(2,getStrLocalLangID());
			pstmt.setString(3,pres_drug_code);  
			pstmt.setString(4,disp_drug_code);
			pstmt.setString(5,order_id);
			pstmt.setString(6,order_line_no);
			rSet	= pstmt.executeQuery() ;
			if(rSet.next())
				setDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+disp_drug_code, checkForNull(rSet.getString("DOSAGE_DTL")));
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
	}
	public String getUOMDesc (String uom_code, String lang_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String short_desc		= "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "select SHORT_DESC from am_uom_lang_vw where UOM_CODE=? and  LANGUAGE_ID=?") ;
			pstmt.setString(1,uom_code);
			pstmt.setString(2,lang_id);
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
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return short_desc;
	}
	public void setMedPlanMethods(String order_id, String order_line_no,String primary_lang_id,String drug_code,String alternate_drug,String loc_lang_id,String qty,String alt_drug_desc,String uom) throws Exception{
		  String dosedet[] = new String[4],dosedetlocal[] = new String[4];
		  String dispno[] = new String[2];
		  LinkedHashMap hsh_med_plan = new LinkedHashMap();
		  DecimalFormat dfToInteger = new DecimalFormat("#.####");
 try{
		  dosedet = getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,alternate_drug);
		  dosedetlocal = getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,alternate_drug);
          getDosageDetails(drug_code,alternate_drug, order_id, order_line_no);

		  dispno = getDispNumber(order_id, order_line_no);
		  hsh_med_plan = disp_bean.getMedPlanDosageDtls(order_id,order_line_no,dispno[0],dispno[1],qty,alternate_drug,alt_drug_desc,drug_code,alternate_drug,dfToInteger.format(Double.parseDouble(qty))+" "+getUOMDesc(uom,loc_lang_id),dfToInteger.format(Double.parseDouble(qty))+" "+getUOMDesc(uom,primary_lang_id),CommonBean.checkForNull(getDrug_ImpNote(alternate_drug)),CommonBean.checkForNull(getDrug_ImpNote_Local(alternate_drug)),CommonBean.checkForNull(getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+alternate_drug)),CommonBean.checkForNull(getDrug_desc_local(alternate_drug)),CommonBean.checkForNull(getDrug_Howtotake(order_id+"~"+order_line_no+"~"+alternate_drug)),dosedetlocal,dosedet);

		  setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+primary_lang_id, hsh_med_plan);
          setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+loc_lang_id, hsh_med_plan);

	   }
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
	}
}
