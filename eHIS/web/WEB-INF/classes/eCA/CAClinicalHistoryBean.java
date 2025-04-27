/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
15/03/2018	IN066119		Raja S			15/03/2018		Ramesh G		ML-MMOH-CRF-1024
04/03/2019	IN066806		Ramya Maddena	04/03/2019	    Ramesh G		AMRi-CRF-0339
11/04/2019	IN066304		Kamalakannan G		11/04/2019	Ramesh Goli	 	ML-MMOH-CRF-1064
15/04/2021	15950			Nijitha S		15/04/2021						Common-ICN-0030
20/02/2024    54391   Krishna Pranay     21/02/2024     Ramesh Goli      COMMON-ICN-0275 
9/06/2024	  62372			Twinkle Shah   19/04/2021	    ML-MMOH-CRF-2149.1
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
--------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.simple.*;//IN066806
//IN066304 starts
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
//IN066304 ends

import eCA.Common.CaAdapter;
public class CAClinicalHistoryBean extends CaAdapter implements Serializable {
//IN066304 starts	
	LinkedHashMap<String,String> clntMap = new LinkedHashMap<String,String>();
	HashMap<String,String> fullHash = null;
	HashMap<String,HashMap<String,ArrayList<String>>> par = new HashMap<String,HashMap<String,ArrayList<String>>>();
	HashMap<String,HashMap<String,ArrayList<String>>> superParent = new HashMap<String,HashMap<String,ArrayList<String>>>();
	HashMap<String,HashMap<String,ArrayList<String>>> printMaster = new HashMap<String,HashMap<String,ArrayList<String>>>();
	private String parentCheckFlag;
	public String getParentCheckFlag() {
		return parentCheckFlag;
	}
	public void setParentCheckFlag(String parentCheckFlag) {
		this.parentCheckFlag = parentCheckFlag;
	}
//IN066304 ends	
	public String getClinicalHistViewMode(Connection con) throws Exception { 
		
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		String paramQuery =  " SELECT CLN_HIST_DEFAULT_MODE FROM CA_PARAM";
		String cln_hist_default_mode="T";
		
	 try{
		       pStatment = con.prepareStatement(paramQuery.toString());
				resultSet = pStatment.executeQuery();
				
				while(resultSet.next())
				{
					cln_hist_default_mode = resultSet.getString("CLN_HIST_DEFAULT_MODE");
				}
				if(resultSet!=null)resultSet.close();		
				if(pStatment!=null)pStatment.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
		}
		return cln_hist_default_mode;
	}
	//IN066806 starts
	public static JSONObject getstatusbean(Connection con, String patient_id, String encounter_id,String note_type) throws Exception{
		PreparedStatement stmt			= null;
		PreparedStatement stmt1			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String discharged_yn	= "N";
		String noteGroupYN	= "N";

		try{
			//String sql = "Select 'Y' discharged_yn from PR_ENCOUNTER a where a.patient_id='"+patient_id+"' and a.encounter_id='"+encounter_id+"' and a.discharge_date_time is not null ";//common-icn-0180
			String sql = "Select 'Y' discharged_yn from PR_ENCOUNTER a where a.patient_id=? and a.encounter_id=? and a.discharge_date_time is not null ";//common-icn-0180
			String modifySql="SELECT 'Y' noteGroupYN FROM ca_note_group a, ca_note_type b WHERE a.note_group = b.note_group_id AND a.appl_task_id = 'DISCHARGE_SUMMARY' AND b.note_type = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,patient_id);//common-icn-0180
			stmt.setString(2,encounter_id);//common-icn-0180
			rs	= stmt.executeQuery();
			if(rs!=null && rs.next()){
				discharged_yn		= (rs.getString("discharged_yn")==null || rs.getString("discharged_yn").equals(""))?"N":rs.getString("discharged_yn");
			}
               		if(rs!=null)rs.close();
			stmt1 = con.prepareStatement(modifySql);
			stmt1.setString(1,note_type);
			rs	= stmt1.executeQuery();

			if(rs!=null && rs.next()){
				noteGroupYN	= (rs.getString("noteGroupYN")==null || rs.getString("noteGroupYN").equals(""))?"N":rs.getString("noteGroupYN");
			}
			jsonObj.put("discharged_yn",discharged_yn);
			jsonObj.put("noteGroupYN",noteGroupYN);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(stmt1!=null)stmt1.close();//15950
			}catch(Exception ex){
				System.err.println("Exception in getstatusbean - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
		
	} //IN066806 ends
	
	//IN066304 Start
	public LinkedHashMap<String,String> getHistoryTypes(){
		LinkedHashMap<String,String> histTypeMap = new LinkedHashMap<String,String>();
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		try
		{
			String emrResultQuery = "select hist_rec_type, short_desc from CR_HIS_RECTYP_LNG_VW where hist_rec_type not in('ALGY','MEDN','NBDT','FEVT','MHD') AND LANGUAGE_ID = ? order by 2"; //Added MHD for ML-MMOH-CRF-1759
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			
			pstmt.setString( 1 , language_id);
			rs	= pstmt.executeQuery();
			while(rs.next())
				{
					String hist_rec =   checkForNull(rs.getString( "HIST_REC_TYPE" ),"");  
					String shortDesc =   checkForNull(rs.getString( "SHORT_DESC" ),"");  
					histTypeMap.put(hist_rec, shortDesc);
				}
			if(rs !=null) rs.close();//15950
			if(pstmt !=null) //15950
				pstmt.close();//15950
			if(con != null)con.close();//15950
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
			if(rs != null)//Common-ICN-0092  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return histTypeMap;
	}
	public ArrayList<ArrayList<String>> getCAPrintingEmrResult(String patient_id,String from_date,String to_date,String facility_id,String language_id){
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		if(patient_id.equals("") || patient_id==null) patient_id = "";
		if(from_date.equals("") || from_date==null) from_date = "";
		if(to_date.equals("") || to_date==null) to_date = "";
		ArrayList<ArrayList<String>> ResultDetail = null;
		try
		{
			String emrResultQuery = "SELECT a.patient_id, a.facility_id, a.encounter_id encounter_id, am_get_desc.am_patient_class (a.patient_class, ?, '2' ) episode_type_desc, TO_CHAR (a.visit_adm_date_time, 'dd/mm/yyyy hh24:mi:ss') visit_adm_date, TO_CHAR (a.discharge_date_time, 'dd/mm/yyyy hh24:mi:ss' ) discharge_date_time, NVL (am_get_desc.am_practitioner (a.attend_practitioner_id, ?, '2' ), '' ) phy_prov_name, am_get_desc.am_service (a.service_code, ?, '2') speciality, a.patient_class FROM pr_encounter a, mp_patient b WHERE a.patient_id = b.patient_id AND a.patient_id = ? AND ( ( a.patient_class IN ('IP', 'DC') AND a.adt_status NOT IN ('00', '09') ) OR ( a.patient_class IN ('OP', 'EM') AND a.visit_status NOT IN ('01', '02', '99') ) ) AND a.visit_adm_date_time BETWEEN TO_DATE (?, 'dd/mm/yyyy') AND (TO_DATE (?, 'dd/mm/yyyy') + 0.99999) AND a.facility_id = ? order by visit_adm_date desc";
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			
			pstmt.setString( 1 , language_id);
			pstmt.setString( 2 , language_id);
			pstmt.setString( 3 , language_id);
			pstmt.setString( 4 , patient_id);
			pstmt.setString( 5 , from_date);
			pstmt.setString( 6 , to_date);
			pstmt.setString( 7 , facility_id);
			rs	= pstmt.executeQuery();
			ResultDetail = new ArrayList<ArrayList<String>>();
			while(rs.next())
				{
						ArrayList<String> SearchResult	= new ArrayList<String>() ;
				/*0*/	SearchResult.add(rs.getString( "patient_id"));		//patient id
				/*1*/	SearchResult.add(rs.getString( "encounter_id"));	// encounter id
				/*2*/	SearchResult.add(rs.getString( "visit_adm_date")); //visit_adm_date
				/*3*/	SearchResult.add(rs.getString( "discharge_date_time")); //visit_end_date
				/*4*/	SearchResult.add(rs.getString( "patient_class"));	// patient_class_id
						ResultDetail.add(SearchResult);
				}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
		       if(rs != null)//Common-ICN-0092  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null) 
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return ResultDetail;
	}
	public LinkedHashMap<String,String> updateAllClinicalNotePrintingFlags(String hist_type,String flag,String eventList){
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		try
		{
			String[] applicableEvent = eventList.split(",");
			String emrResultQuery = "select EVENT_CLASS, long_desc, SHORT_DESC from CR_EVENT_CLASS_LANG_VW where hist_rec_type=? and language_id = ? order by long_desc";
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			pstmt.setString( 1 , hist_type);
			pstmt.setString( 2 , language_id);
			rs	= pstmt.executeQuery();
			while(rs.next())
				{
					String eventClass =   checkForNull(rs.getString( "EVENT_CLASS" ),"");
					for(int i=0; i<applicableEvent.length; i++){
						if(applicableEvent[i].equals(eventClass)){
							clntMap.put(hist_type+"_"+eventClass, flag);
							break;
						}else{
							if(clntMap.containsKey(hist_type+"_"+eventClass)){
								clntMap.put(hist_type+"_"+eventClass, "N");
							}
						}
					}
				}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
			if(rs != null)//Common-ICN-0092  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return clntMap;
	}
	public ArrayList<String> getClinicalNotePrintingEventClass(String hist_type){
		ArrayList<String> list = new ArrayList<String>();
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		try
		{	
			String emrResultQuery = "select EVENT_CLASS,SHORT_DESC from CR_EVENT_CLASS_LANG_VW where hist_rec_type=? and language_id = ? order by SHORT_DESC";
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			
			pstmt.setString( 1 , hist_type);
			pstmt.setString( 2 ,language_id);
			rs	= pstmt.executeQuery();
			while(rs.next())
				{
					String eventClass =   checkForNull(rs.getString( "EVENT_CLASS" ),"");
					String key = hist_type+"_"+eventClass;
					String flag = "N";
					if(clntMap.containsKey(key)){
						flag = clntMap.get(key);
					}
					String shortDesc =   checkForNull(rs.getString( "SHORT_DESC" ),"");  
					list.add(key+"#"+shortDesc+"%"+flag);
				}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
			if(rs != null)//Common-ICN-0092  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return list;
	}
	public void updateValues(String key,String value){
		key = key.trim();
		clntMap.put(key, value);
		System.out.println("clntMap==>"+clntMap);
	}
	public HashMap<String,String> getAllEventClasses(String flag){
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		fullHash = new HashMap<String, String>();
		try
		{
			String emrResultQuery = "select HIST_REC_TYPE,EVENT_CLASS, long_desc, SHORT_DESC from CR_EVENT_CLASS_LANG_VW where language_id = ? order by long_desc";
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			
			pstmt.setString( 1 , language_id);
			rs	= pstmt.executeQuery();
			while(rs.next())
				{
					String hist_rec =   checkForNull(rs.getString( "HIST_REC_TYPE" ),"");  
					String clntKey =   checkForNull(rs.getString( "EVENT_CLASS" ),"");  
					fullHash.put(hist_rec+"_"+clntKey, flag);
				}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
			if(rs != null)//Common-ICN-0092  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return fullHash;
	}
	public void clearMapObject(){
		clntMap.clear();
	}
	public void clearParMap(){
		par.clear();
		printMaster.clear();
		superParent.clear();
		clntMap.clear();
	}
	public HashMap<String,ArrayList<String[]>> getApplicableRecords(String patient_id,String date_from,String date_to,String encounter_id){
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		HashMap<String, ArrayList<String[]>> applicableRec = new HashMap<String, ArrayList<String[]>>();
		try
		{
			String emrResultQuery = "Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g  WHERE a.patient_id = ?  and a.event_date >= to_date(?,'dd/mm/yyyy')and a.event_date <= to_date(?,'dd/mm/yyyy')+ 0.99999 and a.encounter_id = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'PRABHUG','CA',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y'  and nvl(a.STATUS,'`') not in('S','E')AND g.FACILITY_ID(+) = a.FACILITY_ID AND g.ENCOUNTER_ID(+) = a.ENCOUNTER_ID  ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, a.event_class, event_group_desc, nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate desc ";
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			
			pstmt.setString( 1 , language_id);
			pstmt.setString( 2 , language_id);
			pstmt.setString( 3 , language_id);
			pstmt.setString( 4 , language_id);
			pstmt.setString( 5 , language_id);
			pstmt.setString( 6 , patient_id);
			pstmt.setString( 7 , date_from);
			pstmt.setString( 8 , date_to);
			pstmt.setString( 9 , encounter_id);
			rs	= pstmt.executeQuery();
			ArrayList<String[]> hashValues = new ArrayList<String[]>();
			while(rs.next())
				{
					String histRec =   checkForNull(rs.getString( "HIST_REC_TYPE" ),"");  
					String eventClass =   checkForNull(rs.getString( "EVE_CLASS" ),"");  
					String accessionNo =   checkForNull(rs.getString( "acc_num" ),""); 
					String[] strArr = {eventClass,accessionNo};
					if(applicableRec.containsKey(histRec)){
						hashValues.add(strArr);
						applicableRec.put(histRec, hashValues);
					}else{
						hashValues = new ArrayList<String[]>();
						hashValues.add(strArr);
						applicableRec.put(histRec, hashValues);
					}
				}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
			if(rs != null)//Common-ICN-0092  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return applicableRec;
	}
	
	public HashMap<String,HashMap<String,ArrayList<String>>> applicablePrintingValues(String patient_id,String date_from,String date_to,String encounter_id){
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		superParent = new HashMap<String,HashMap<String,ArrayList<String>>>();
		try
		{
			
				String emrResultQuery = "Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g  WHERE a.patient_id = ?  and a.event_date >= to_date(?,'dd/mm/yyyy')and a.event_date <= to_date(?,'dd/mm/yyyy')+0.99999 and a.encounter_id = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'PRABHUG','CA',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y'  and nvl(a.STATUS,'`') not in('S','E')AND g.FACILITY_ID(+) = a.FACILITY_ID AND g.ENCOUNTER_ID(+) = a.ENCOUNTER_ID  ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, a.event_class, event_group_desc, nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate desc";
				con		= getConnection();	
				pstmt = con.prepareStatement(emrResultQuery);
				
				pstmt.setString( 1 , language_id);
				pstmt.setString( 2 , language_id);
				pstmt.setString( 3 , language_id);
				pstmt.setString( 4 , language_id);
				pstmt.setString( 5 , language_id);
				pstmt.setString( 6 , patient_id);
				pstmt.setString( 7 , date_from);
				pstmt.setString( 8 , date_to);
				pstmt.setString( 9 , encounter_id);
				
				rs	= pstmt.executeQuery();
				ArrayList<String> hashValues = new ArrayList<String>();
				HashMap<String,ArrayList<String>> childMap = new HashMap<String, ArrayList<String>>();//doubt
				ArrayList<String> hashValues1 = null;
				while(rs.next())
					{
						String eventClass =   checkForNull(rs.getString( "EVE_CLASS" ),"");
						String histRec =   checkForNull(rs.getString( "hist_rec_type" ),"");
						String sortEventDateTime = checkForNull(rs.getString( "sort_event_date_time" ),""); 
						String Contrsysid = checkForNull(rs.getString( "sys_id" ),""); 
						String Accessionnum =   checkForNull(rs.getString( "acc_num" ),"");
						String Contrsyseventcode  =   checkForNull(rs.getString( "sys_eve_code" ),""); 
						String value = encounter_id+"`"+histRec+"`"+sortEventDateTime+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;
						
						if(superParent.containsKey(histRec)){
							if(childMap.containsKey(eventClass)){
								hashValues1.add(value);
							}else{
								hashValues1 = new ArrayList<String>();
								hashValues1.add(value);
								childMap.put(eventClass, hashValues1);
							}
						}else{
							hashValues1 = new ArrayList<String>();
							hashValues1.add(value);
							childMap = new HashMap<String, ArrayList<String>>();
							childMap.put(eventClass, hashValues1);
							superParent.put(histRec, childMap);
						}
						
					}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
			if(rs != null)//Common-ICN-0092  
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return superParent;
	}
	public void parentAndChildChkFunc(String hist_rec,String event_class,String flag){
		HashMap<String,ArrayList<String>> tempMap = null;
		ArrayList<String> tempList = null;
		
		if((hist_rec !=null && !("".equals(hist_rec))) && (event_class !=null && !("".equals(event_class)))){
			if("Y".equals(flag)){
				if(printMaster.containsKey(hist_rec)){
					if(!printMaster.get(hist_rec).containsKey(event_class)){
						tempList = new ArrayList<String>();
						tempList = superParent.get(hist_rec).get(event_class);
						printMaster.get(hist_rec).put(event_class, tempList);
					}
				}else{
					tempMap = new HashMap<String,ArrayList<String>>();
					tempMap = superParent.get(hist_rec);
					tempList = new ArrayList<String>();
					tempList = tempMap.get(event_class);
					tempMap = new HashMap<String,ArrayList<String>>();
					tempMap.put(event_class, tempList);
					printMaster.put(hist_rec,tempMap);
				}
			}else if("N".equals(flag)){
				if(printMaster.containsKey(hist_rec)){
					if(printMaster.get(hist_rec).containsKey(event_class)){
						tempMap = new HashMap<String,ArrayList<String>>();
						
						for (Entry<String, ArrayList<String>> iterator : (printMaster.get(hist_rec)).entrySet()){
							tempMap.put(iterator.getKey(), iterator.getValue());
						}
						if(tempMap.size()==1){
							printMaster.remove(hist_rec);
						}else{
							tempMap.remove(event_class);
							printMaster.put(hist_rec, tempMap);
						}
					}
				}
			}
		}else if((hist_rec !=null && !"".equals(hist_rec))){
			if("Y".equals(flag)){
				tempMap = new HashMap<String,ArrayList<String>>();
				tempMap = superParent.get(hist_rec);
				printMaster.put(hist_rec, tempMap);
			}else if("N".equals(flag)){
				if(printMaster.containsKey(hist_rec)){
					printMaster.remove(hist_rec);
				}
			}
		}
	}
	public String UIFunction(String hist_rec){
		HashMap<String,Integer> testing = new HashMap<String,Integer>();
		for (Entry<String, HashMap<String, ArrayList<String>>> iterator : superParent.entrySet()){
				String key   = iterator.getKey();
				int value = (iterator.getValue()).size();
				testing.put(key, value);
		}
		String checkEnable = "N";
		int inc = 0;
		for(Entry<String, String> iterator : clntMap.entrySet()){
			String arr[] = (iterator.getKey()).split("_");
			if(superParent.containsKey(arr[0]) && "Y".equals(iterator.getValue()) && (hist_rec.equals(arr[0]))){
				inc++;
			}
		}
		if(testing.get(hist_rec)==inc){
			checkEnable = "Y";
		}
		return checkEnable;
	}
	public ArrayList<String> finalizePrintList(){
		ArrayList<String> finalPrintList = new ArrayList<String>();
		for (Entry<String, HashMap<String, ArrayList<String>>> iterator : printMaster.entrySet()){
			HashMap<String,ArrayList<String>> tempMap = iterator.getValue();
				for(Entry<String, ArrayList<String>> innerIterator : tempMap.entrySet()){
					ArrayList<String> arrList = innerIterator.getValue();
					finalPrintList.addAll(arrList);
				}
		}
		return finalPrintList;
	}
	public Set<String> getDefaultClntMap(String patient_id,String encounter_id,String date_from,String date_to){
		PreparedStatement pstmt 	= null;
		ResultSet rs 		= null;
		Connection con		 		= null;
		Set<String> selectAllUIset = null;
		int clntMapYesCount = 0;
		try
		{
			String emrResultQuery = "Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type,(select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class ) event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl((select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) , CR_GET_DESC.CR_CLIN_EVENT_MAST (A.HIST_REC_TYPE, A.EVENT_CODE, A.EVENT_CODE_TYPE,?,'1'))event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')		 event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),?,'1') resulted_practitioner,a.encounter_ID, a.normalcy_str,a.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER g  WHERE a.patient_id = ?  and a.event_date >= to_date(?,'dd/mm/yyyy')and a.event_date <= to_date(?,'dd/mm/yyyy')+ 0.99999 and a.encounter_id = ?  and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'PRABHUG','CA',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y'  and nvl(a.STATUS,'`') not in('S','E')AND g.FACILITY_ID(+) = a.FACILITY_ID AND g.ENCOUNTER_ID(+) = a.ENCOUNTER_ID  ORDER BY  hist_rec_type_desc, a.hist_rec_type, event_class_desc, a.event_class, event_group_desc, nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'), sp_event_desc, a.event_code, dummydate desc";
			con		= getConnection();	
			pstmt = con.prepareStatement(emrResultQuery);
			pstmt.setString( 1 , language_id);
			pstmt.setString( 2 , language_id);
			pstmt.setString( 3 , language_id);
			pstmt.setString( 4 , language_id);
			pstmt.setString( 5 , language_id);
			pstmt.setString( 6 , patient_id);
			pstmt.setString( 7 , date_from);
			pstmt.setString( 8 , date_to);
			pstmt.setString( 9 , encounter_id);
			rs	= pstmt.executeQuery();
			selectAllUIset = new HashSet<String>();
			while(rs.next())
				{
					String eventClass =   checkForNull(rs.getString( "EVE_CLASS" ),"");
					String hist_type =   checkForNull(rs.getString( "HIST_REC_TYPE" ),"");
					selectAllUIset.add(hist_type+"_"+eventClass);
				}
			System.out.println("selectAllUIset===>"+selectAllUIset);
			for(Entry<String,String> entry : clntMap.entrySet()){
				if(entry.getValue().equals("Y")){
					clntMapYesCount++;
				}
			}
			if(selectAllUIset.size() == clntMapYesCount){
				setParentCheckFlag("Y");
			}else{
				setParentCheckFlag("N");
			}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}finally {
			if(rs != null)
				try {
					rs.close();//Common-ICN-0092  
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return selectAllUIset;
	}
	public void selectAllCheckBox(String flag,String patient_id,String encounter_id,String date_from,String date_to){
		Set<String> selectAllUIset = null;
		try
		{
			selectAllUIset = new HashSet<String>();
			selectAllUIset = getDefaultClntMap(patient_id,encounter_id,date_from,date_to);
			clntMap.clear();
			for(String parentCheckBox :	selectAllUIset){
				clntMap.put(parentCheckBox, flag);
			}
		}	
		catch(Exception e){
			e.printStackTrace();		
		}
	}
	public void getSelectAllListForPrint(String flag){
		if("Y".equals(flag)){
			printMaster.clear();
			printMaster.putAll(superParent);
		}else{
			printMaster.clear();
		}
	}
	//IN066304 End
//62372  start.	
	public int getAccessRightsViewCopyPreviousBtn(String practitionerId,String facilityId)
	 {   
		Connection con	= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			 int cCount=0;
	 	 String sql = "SELECT COUNT (*) COUNTNUM FROM CA_ACCESS_CTRL_COPY_PRE_PRACT AP, AM_PRACT_FOR_FACILITY PF,am_practitioner am WHERE AP.PRACTITIONER_ID = ? AND AP.PRACTITIONER_ID = PF.PRACTITIONER_ID AND ap.practitioner_id = am.practitioner_id  AND AP.FACILITY_ID = ? AND PF.FACILITY_ID=? AND PF.EFF_STATUS='E'  AND am.EFF_STATUS = 'E' AND ( ( AP.ACCESS_FROM_DATE IS NULL AND AP.ACCESS_TO_DATE IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (AP.ACCESS_TO_DATE, 'DD/MM/YYYY') ) OR ( AP.ACCESS_FROM_DATE IS NOT NULL AND AP.ACCESS_TO_DATE IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (AP.ACCESS_FROM_DATE, 'DD/MM/YYYY') ) OR ( AP.ACCESS_FROM_DATE IS NOT NULL AND AP.ACCESS_TO_DATE IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (AP.ACCESS_FROM_DATE, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (AP.ACCESS_TO_DATE, 'DD/MM/YYYY') ) )";
	 	 try{
	 			 con			= getConnection();
	 			pstmt  = con.prepareStatement(sql);
				pstmt.setString(1, practitionerId);
				pstmt.setString(2, facilityId);
				pstmt.setString(3, facilityId);
				
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					cCount=rs.getInt("countNum");
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
	 				con.close();
	 			} catch (SQLException e) {
	 				e.printStackTrace();
	 			}		
	 	}
	 		return cCount;
	 }
//62372 end.
//68801 start.
	public String isPatinetDichargedYN(String facilityd,String encounterId)
	 {  
		Connection con	= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String isPatientDischrgedYN ="";

	 	 String sql = "SELECT CASE WHEN DISCHARGE_DATE_TIME IS NOT NULL THEN 'Y' ELSE 'N' END AS PATIENT_DISCHARGED FROM PR_ENCOUNTER WHERE ENCOUNTER_ID = ? AND FACILITY_ID = ?";
	 		try{
	 			 con			= getConnection();
	 			pstmt  = con.prepareStatement(sql);
				pstmt.setString(1, encounterId);
				pstmt.setString(2, facilityd);

				rs = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					isPatientDischrgedYN	= rs.getString("PATIENT_DISCHARGED")==null?"N":rs.getString("PATIENT_DISCHARGED");
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
	 		return isPatientDischrgedYN;
	 }
//68801 end
}
	
