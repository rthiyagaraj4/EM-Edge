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
import java.util.* ;
import java.sql.* ;
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.IPFill.*;

public class IpFillBean extends PhAdapter implements Serializable {

	private String disp_locn_code	= "";
	private Hashtable recordSet		= new Hashtable();
	private ArrayList ipFillList	= new ArrayList();
	private HashMap	fillListDtl		= new HashMap();
	private ArrayList Records       = new ArrayList();
	private HashMap dispuoms		= new HashMap();

	public IpFillBean(){
		try{
			doCommon() ;
		}
		catch(Exception e) {	e.printStackTrace() ;
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception{
	}

	public void clear(){
		super.clear() ;
		this.disp_locn_code	= "";
		this.fillListDtl	= new HashMap();
		this.ipFillList		= new ArrayList();
		this.dispuoms		= new HashMap();
	}

	/* Function specific methods start */
	
	public void setIpFillList(ArrayList ipFillList){
		this.ipFillList		= ipFillList;
	}
	public ArrayList getIpFillList(){
		return ipFillList;
	}


    public void setDispUoms(HashMap dispuoms){
		this.dispuoms		= dispuoms;
	}
	public HashMap getDispUoms(){
		return dispuoms;
	}


	
	public void setFillListDtl(HashMap fill_list_dtl){
		this.fillListDtl=fill_list_dtl;
	}

	public HashMap getFillListDtl(){
		return fillListDtl;
	}

	public String getLoggedInFacility(){
		return login_facility_id;
	}
	public void setDispenseLocation(String dcode){
		this.disp_locn_code=dcode;
	}

	

	public void setCheckdRecords(ArrayList selectedRecords){
		this.Records		= selectedRecords;
		
	}


	public int validatePharmacist() {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		int valid				= 0;
		String practype			= null;
		try {
			connection = getConnection() ;
			//this query returns the practioner type
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PHARM_SELECT" )) ;
			pstmt.setString(1,login_by_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				practype=resultSet.getString("PRACT_TYPE");
				if (practype.equals("PH")){
					valid=1;
				}else {
					valid=0;
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return 0;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return valid;
	}

	public String getEndTime(String fromdate,String fillperiod,String fillperiodunit){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String enddatetime		= "";
		try {
			connection = getConnection() ;
			//this query calculates end date on change of fill period for routine fill
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ENDTIME_SELECT" )) ;
			pstmt.setString(1,fromdate);
			pstmt.setString(2,fillperiodunit);
			pstmt.setString(3,fillperiod);
			pstmt.setString(4,fillperiod);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				enddatetime=resultSet.getString("ENDDATE");
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			return "0";
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }

		}
		return enddatetime;
	}
	
	public HashMap getStartTime(String disp_locn_code,String fillperiod,String schedule_start){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		HashMap result			= new HashMap();
		boolean flag			= false;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT36" )) ;
			pstmt.setString(1,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
				flag			= true;
				result.put("STARTDATE",resultSet.getString("STARTDATE"));
				result.put("FILL_INT_END_DATE_TIME",resultSet.getString("FILL_INT_END_DATE_TIME"));
				result.put("SCHEDULE_START",resultSet.getString("SCHEDULE_START"));
			}
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			    System.err.println("flag----->"+flag);
			    System.err.println("schedule_start---->"+schedule_start);
				System.err.println("schedule_start--->"+schedule_start);
				System.err.println("login_facility_id---->"+login_facility_id);
				System.err.println("disp_locn_code---->"+disp_locn_code);
				System.err.println("schedule_start--->"+schedule_start);
				System.err.println("fillperiod---->"+fillperiod);
				System.err.println("login_facility_id----->"+login_facility_id);
				System.err.println("disp_locn_code------->"+disp_locn_code);

			if(!flag){
				
				//pstmt = connection.prepareStatement("SELECT TO_CHAR(To_Date(?,'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY HH24:MI') START_DATE ,	 (SELECT TO_CHAR(To_Date(?,'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY')||' '|| TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND   DISP_LOCN_CODE=?) SCHEDULE_START, (SELECT TO_CHAR(To_Date(?,'DD/MM/YYYY hh24:mi')+(?/24),'DD/MM/YYYY')||' '|| '00:00' FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND   DISP_LOCN_CODE=?) FILL_INT_END_DATE_TIME FROM DUAL") ;
				pstmt = connection.prepareStatement("SELECT ( TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),   'DD/MM/YYYY')               || ' '               || TO_CHAR (sysdate, 'HH24:MI'))START_DATE,      (SELECT    TO_CHAR (TO_DATE (?, 'DD/MM/YYYY hh24:mi'),'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?) schedule_start, (SELECT    TO_CHAR(TO_DATE (?, 'DD/MM/YYYY hh24:mi') + ?,                 'DD/MM/YYYY') || ' ' || TO_CHAR (ip_fill_dflt_start_time, 'HH24:MI') FROM ph_disp_locn WHERE facility_id = ? AND disp_locn_code = ?)                                               fill_int_end_date_time FROM DUAL") ;
				pstmt.setString(1,schedule_start);
				pstmt.setString(2,schedule_start);
				pstmt.setString(3,login_facility_id);
				pstmt.setString(4,disp_locn_code);
				pstmt.setString(5,schedule_start);
				pstmt.setString(6,fillperiod);
				pstmt.setString(7,login_facility_id);
				pstmt.setString(8,disp_locn_code);
				resultSet = pstmt.executeQuery() ;
				if(resultSet!=null && resultSet.next()){
					result.put("STARTDATE",resultSet.getString("START_DATE"));
					result.put("FILL_INT_END_DATE_TIME",resultSet.getString("FILL_INT_END_DATE_TIME"));
					result.put("SCHEDULE_START",resultSet.getString("SCHEDULE_START"));
				}
					closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

			}
		}catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }

		}
		 
	    System.err.println("result------->"+result);
		return result;
	}

	public int checkDispRight() {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		int valid				= 0;
		String practype			= null;
		try {
			connection = getConnection() ;
			//this query checks if the practioner has fill right
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			pstmt.setString(3,login_by_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				practype=resultSet.getString("FILL_YN");
				if (practype.equals("Y")) {
					valid=1;
				}else {
					valid=0;
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			return 0;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return valid;
	}

	public int allocateSetup() {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		int valid				= 0;
		String practype			= null;
		try {
			connection = getConnection() ;
			//this query checks if the practioner has fill right
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALLOCATE_SETUP" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				practype=resultSet.getString("IP_FILL_ALLOCATE_BATHCES_YN");
				if ((practype!=null)&&(practype.equals("Y"))) {
					valid=1;
				}else {
					valid=0;
				}
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			return 0;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return valid;
	}

	public ArrayList getDispenseLocation() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_at_ws_no);
			pstmt.setString(3,login_by_id);
			pstmt.setString(4,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("DISP_LOCN_CODE"));
				result.add(resultSet.getString("DISP_DESC"));
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return result;
	}

public ArrayList getOrderingFacilityId(String p_user_name) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//System.err.println("p_user_name----->"+p_user_name);
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
			pstmt = connection.prepareStatement("SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_lang_vw B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?") ;
			pstmt.setString(1,p_user_name);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME"));
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		//System.err.println("result--from bean--->"+result);
		return result;
	}
	


	public ArrayList getCurrentTime() {
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		ArrayList time          = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_CURRTIME_SELECT" )) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				time.add(resultSet.getString("currenthrs"));
				time.add(resultSet.getString("currentmis"));
			}
		}catch ( Exception e ) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return time;
	}
	public ArrayList getFillPeriods() {
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		PreparedStatement pstmt1= null ;
		ResultSet resultSet		= null ;
		ResultSet resultSet1	= null ;
		ArrayList facilities	= new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_FILLPERIOD_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilities.add(resultSet.getString("IP_FILL_PRD_AHEAD"));
				facilities.add(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
				facilities.add(resultSet.getString("SCHEDULE_START_TIME"));
				facilities.add(resultSet.getString("CDATE"));
				facilities.add(resultSet.getString("CMONTH"));
				facilities.add(resultSet.getString("CYEAR"));
				facilities.add(resultSet.getString("CHOURS"));
				facilities.add(resultSet.getString("CMINUTES"));
				facilities.add(resultSet.getString("IP_FILL_PRD_UNIT"));
				facilities.add(resultSet.getString("IP_FILL_ALLOCATE_BATHCES_YN"));
				facilities.add(resultSet.getString("ROUTINE_START_DATE"));
				facilities.add(resultSet.getString("ROUTINE_END_DATE"));
				pstmt1		= connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_FILLPERIOD_SELECT1" )) ;
				pstmt1.setString(1,login_facility_id);
				pstmt1.setString(2,this.disp_locn_code);
				pstmt1.setString(3,resultSet.getString("SCHEDULE_START_TIME"));
				resultSet1 = pstmt1.executeQuery() ;
				if (resultSet1.next()){
					facilities.add(resultSet1.getString("INC_START_DATE"));
					facilities.add(resultSet.getString("ROUTINE_END_DATE"));
					facilities.add("Y");
				} else {
					facilities.add(resultSet.getString("INC_START_DATE"));
					facilities.add(resultSet.getString("ROUTINE_END_DATE"));
					facilities.add("N");
				}
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;

			}
		}catch ( Exception e ) {
			facilities.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return facilities;
	}

 // added by suri
 	public ArrayList getIpFillList(String fill_int_start_date_time,String fill_int_end_date_time,String Proc_Type,String intermittent,String disp_locn_code,String nursing_unit_or_locn,String compound_drug_ind,String Building_Code,String Floor_Code,String Nursing_Unit_From, String Nursing_Unit_To, String order_by_for_list,String locale,String OrderingFacility_code,String ip_fill_excl_prd_behind) throws Exception{

		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		ArrayList ip_fill_list		= new ArrayList();
		HashMap	  ip_fill_order		= new HashMap();
		
		try {
            connection	= getConnection() ;
			//pstmt		=connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_DETAILS_SELECT"));
			//pstmt		=connection.prepareStatement("SELECT Ph_CalculateDispQty(e.order_id,e.order_line_num)  || ' ' ||e.ORDER_UOM  Tot_Disp_Qty, Ph_Display_Stock_UNIT(Or_Order.ORDERING_FACILITY_ID,	Or_Order.PERFORMING_DEPTLOC_CODE,	e.Order_id,	e.ordeR_line_num,	e.order_Catalog_code,	nvl((select to_char(next_fill_date,'DD/MM/YYYY HH24:MI') from or_order_line_ph where order_id = e.ordeR_id and order_line_num = e.order_line_num),?),	?,	?,	NUll,	e.start_Date_time,	e.end_Date_Time,	e.durn_type,	e.durn_value, 	e.order_line_Status, 	e.order_qty,	e.ORDER_UOM,	?) Disp_qty,  Mp_patient.patient_Name ,Get_Age(Mp_patient.date_of_birth) date_of_birth ,Mp_patient.sex,Mp_patient.patient_id, ip_open_encounter.BED_NUM Patient_Details,   e.order_Catalog_code order_Catalog_code,CATALOG_DESC Drug_Name ,	e.ORDER_QTY,	e.ORDER_UOM, 	   e.ORDER_ID,	IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE SOURCE_CODE, ORDERING_FACILITY_ID, TO_CHAR(OR_ORDER.ORD_DATE_TIME,  'DD/MM/YYYY HH24:MI') ORD_DATE_TIME, MP_PATIENT.PATIENT_ID,  OR_ORDER.ENCOUNTER_ID,  OR_ORDER.ORD_PRACT_ID,	e.order_line_status,	e.start_Date_Time,	TO_CHAR(e.end_date_Time,  'DD/MM/YYYY HH24:MI') end_date_Time,	e.DURN_VALUE,	e.DURN_TYPE,	IP_NURSING_UNIT.SHORT_DESC NURSING_UNIT_DESC, e.ordeR_line_num ORDER_LINE_NUM, OR_ORDER.PATIENT_CLASS PATIENT_CLASS, OR_ORDER.SOURCE_TYPE SOURCE_TYPE, IP_OPEN_ENCOUNTER.ROOM_NUM ROOM_NUM, IP_OPEN_ENCOUNTER.BED_NUM BED_NUM,IP_OPEN_ENCOUNTER.BED_CLASS_CODE BED_CLASS_CODE, IP_OPEN_ENCOUNTER.BED_TYPE_CODE BED_TYPE_CODE, IP_OPEN_ENCOUNTER.SPECIALTY_CODE SPECIALTY_CODE,IP_OPEN_ENCOUNTER.ATTEND_PRACTITIONER_ID ATTEND_PRACTITIONER_ID FROM	OR_ORDER,  	MP_PATIENT, IP_OPEN_ENCOUNTER, OR_ORDER_LINE E ,IP_NURSING_UNIT_lang_vw	IP_NURSING_UNIT ,ph_drug_lang_vw g,ph_disp_locn h WHERE    OR_ORDER.ORDER_ID = E.ORDER_ID	AND  OR_ORDER.ORDER_CATEGORY = 'PH'	AND  PERFORMING_DEPTLOC_CODE = ? 	 AND h.disp_locn_code = performing_deptloc_code  AND h.facility_id = or_order.ordering_facility_id AND  OR_ORDER.PATIENT_CLASS = 'IP' AND TRUNC(E.END_DATE_TIME) >=TRUNC(SYSDATE) AND IP_OPEN_ENCOUNTER.FACILITY_ID =  IP_NURSING_UNIT.FACILITY_ID AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE = IP_NURSING_UNIT.NURSING_UNIT_CODE AND   (E.START_DATE_TIME  BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI')  AND To_date(?,'DD/MM/YYYY HH24:MI') OR  E.END_DATE_TIME  BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI')  AND To_date(?,'DD/MM/YYYY HH24:MI')   OR To_date(? ,'DD/MM/YYYY HH24:MI')  BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME    OR To_date(?,'DD/MM/YYYY HH24:MI')  BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME )   AND  OR_ORDER.ENCOUNTER_ID=IP_OPEN_ENCOUNTER.ENCOUNTER_ID 	AND  OR_ORDER.ORDERING_FACILITY_ID=IP_OPEN_ENCOUNTER.FACILITY_ID 	AND   OR_ORDER.PATIENT_ID=MP_PATIENT.PATIENT_ID  AND  MP_PATIENT.DECEASED_YN='N' 	AND OR_ORDER.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS <> 'N') 	AND  OR_ORDER.PRIORITY= 'R'   	AND  ((?  = 'N' AND  IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE  BETWEEN NVL(?,'!') AND  NVL(?,'~')) OR (?  = 'L' AND  IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE  IN (SELECT  NURSING_UNIT_CODE    FROM  IP_NURSING_UNIT_LOCATION WHERE FACILITY_ID = OR_ORDER.ORDERING_FACILITY_ID AND  BLDNG_CODE  =? AND  FLOOR_CODE = ?))) AND  ( ( ? ='B' AND  (IV_PREP_YN IN ('N','I','1','4','5')   OR IV_PREP_YN IS NULL)) OR (? ='Y' AND  IV_PREP_YN IN ('1','4','5'))  OR(? ='N' AND  IV_PREP_YN IS NULL)) AND  ( (?='R' AND  OR_ORDER.ORD_DATE_TIME<( To_date(?,'DD/MM/YYYY HH24:MI')-(1/24*0)) and(  ip_verf_yn = 'Y'		    AND or_order.order_status IN ('VF', 'DP')   OR     ip_verf_yn = 'N'  AND or_order.order_status IN ('OS', 'VF', 'DP')                  ) ) OR(? = 'I' and (   ip_verf_yn = 'Y' AND or_order.order_status IN ('VF')                   OR ip_verf_yn = 'N' AND or_order.order_status IN ('OS'))) )   AND or_order.ord_date_time between sysdate-100 and sysdate And exists (select 'Y' from am_frequency where freq_code = e.freq_code 	and FREQ_NATURE IN ('F','I'))	AND EXISTS (Select 'Y' from or_order_line_ph where order_id = e.order_id and order_line_num = e.order_line_num 	AND (	(TRUNC(NEXT_FILL_DATE)>=TRUNC(To_Date(?,'DD/MM/YYYY HH24:MI'))) OR (NEXT_FILL_DATE IS NULL)))  and e.order_Catalog_code = g.drug_code and g.language_id =? and IP_NURSING_UNIT.language_id=? Order By  IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE,decode(?,'B',NVL(IP_OPEN_ENCOUNTER.bed_NUM,or_order.patient_id),or_order.patient_id)");
			
			pstmt		=connection.prepareStatement("SELECT Ph_CalculateDispQty(e.order_id,e.order_line_num)  || ' ' ||e.ORDER_UOM  Tot_Disp_Qty, Ph_Display_Stock_UNIT(Or_Order.PERFORMING_FACILITY_ID,	Or_Order.PERFORMING_DEPTLOC_CODE,	e.Order_id,	e.ordeR_line_num,	e.order_Catalog_code,?,?,?,	NUll,	e.start_Date_time,	e.end_Date_Time,	e.durn_type,	e.durn_value, 	e.order_line_Status, 	e.order_qty,	e.ORDER_UOM,	?,?,?,?,?,?,?,?) Disp_qty,  Mp_patient.patient_Name ,Get_Age(Mp_patient.date_of_birth) date_of_birth ,Mp_patient.sex,Mp_patient.patient_id, ip_open_encounter.BED_NUM Patient_Details,   e.order_Catalog_code order_Catalog_code,CATALOG_DESC Drug_Name ,	e.ORDER_QTY,	e.ORDER_UOM, 	   e.ORDER_ID,	IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE SOURCE_CODE, ORDERING_FACILITY_ID, TO_CHAR(OR_ORDER.ORD_DATE_TIME,  'DD/MM/YYYY HH24:MI') ORD_DATE_TIME, MP_PATIENT.PATIENT_ID,  OR_ORDER.ENCOUNTER_ID,  OR_ORDER.ORD_PRACT_ID,	e.order_line_status,	e.start_Date_Time,	TO_CHAR(e.end_date_Time,  'DD/MM/YYYY HH24:MI') end_date_Time,	e.DURN_VALUE,	e.DURN_TYPE,	IP_NURSING_UNIT.SHORT_DESC NURSING_UNIT_DESC, e.ordeR_line_num ORDER_LINE_NUM, OR_ORDER.PATIENT_CLASS PATIENT_CLASS, OR_ORDER.SOURCE_TYPE SOURCE_TYPE, IP_OPEN_ENCOUNTER.ROOM_NUM ROOM_NUM, IP_OPEN_ENCOUNTER.BED_NUM BED_NUM,IP_OPEN_ENCOUNTER.BED_CLASS_CODE BED_CLASS_CODE, IP_OPEN_ENCOUNTER.BED_TYPE_CODE BED_TYPE_CODE, IP_OPEN_ENCOUNTER.SPECIALTY_CODE SPECIALTY_CODE,IP_OPEN_ENCOUNTER.ATTEND_PRACTITIONER_ID ATTEND_PRACTITIONER_ID,PERFORMING_FACILITY_ID FROM	OR_ORDER,  	MP_PATIENT, IP_OPEN_ENCOUNTER, OR_ORDER_LINE E ,IP_NURSING_UNIT_lang_vw	IP_NURSING_UNIT ,ph_drug_lang_vw g,ph_disp_locn h WHERE    OR_ORDER.ORDER_ID = E.ORDER_ID	AND  OR_ORDER.ORDER_CATEGORY = 'PH'	AND  PERFORMING_DEPTLOC_CODE = ? 	 AND h.disp_locn_code = performing_deptloc_code  AND h.facility_id = or_order.PERFORMING_FACILITY_ID AND  OR_ORDER.PATIENT_CLASS = 'IP' AND TRUNC(E.END_DATE_TIME) >=TRUNC(SYSDATE) AND IP_OPEN_ENCOUNTER.FACILITY_ID =  IP_NURSING_UNIT.FACILITY_ID AND IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE = IP_NURSING_UNIT.NURSING_UNIT_CODE AND   (E.START_DATE_TIME  BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI')  AND To_date(?,'DD/MM/YYYY HH24:MI') OR  E.END_DATE_TIME  BETWEEN To_date(? ,'DD/MM/YYYY HH24:MI')  AND To_date(?,'DD/MM/YYYY HH24:MI')   OR To_date(? ,'DD/MM/YYYY HH24:MI')  BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME    OR To_date(?,'DD/MM/YYYY HH24:MI')  BETWEEN E.START_DATE_TIME AND E.END_DATE_TIME )   AND  OR_ORDER.ENCOUNTER_ID=IP_OPEN_ENCOUNTER.ENCOUNTER_ID 	AND  OR_ORDER.ORDERING_FACILITY_ID=IP_OPEN_ENCOUNTER.FACILITY_ID AND  OR_ORDER.ORDERING_FACILITY_ID=? AND   OR_ORDER.PATIENT_ID=MP_PATIENT.PATIENT_ID  AND  MP_PATIENT.DECEASED_YN='N' 	AND OR_ORDER.ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM PH_ORDER_TYPE_FOR_DRUG_CLASS WHERE DRUG_CLASS <> 'N') 	AND  OR_ORDER.PRIORITY= 'R'   	AND  ((?  = 'N' AND  IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE  BETWEEN NVL(?,'!') AND  NVL(?,'~')) OR (?  = 'L' AND  IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE  IN (SELECT  NURSING_UNIT_CODE    FROM  IP_NURSING_UNIT_LOCATION WHERE FACILITY_ID = ? AND  BLDNG_CODE  =? AND  FLOOR_CODE = ?))) AND  ( ( ? ='B' AND  (IV_PREP_YN IN ('N','I','1','4','5')   OR IV_PREP_YN IS NULL)) OR (? ='Y' AND  IV_PREP_YN IN ('1','4','5'))  OR(? ='N' AND  IV_PREP_YN IS NULL)) AND  ( (?='R' AND  OR_ORDER.ORD_DATE_TIME<( To_date(?,'DD/MM/YYYY HH24:MI')-(1/24*?)) and(  ip_verf_yn = 'Y'		    AND or_order.order_status IN ('VF', 'DP','DD')   OR     ip_verf_yn = 'N'  AND or_order.order_status IN ('OS', 'VF', 'DP','DD') ) ) OR(? = 'I' and (   ip_verf_yn = 'Y' AND or_order.order_status IN ('VF')                   OR ip_verf_yn = 'N' AND or_order.order_status IN ('OS'))) )   AND or_order.ord_date_time between sysdate-100 and sysdate And exists (select 'Y' from am_frequency where freq_code = e.freq_code 	and FREQ_NATURE IN ('F','I')) and e.order_Catalog_code = g.drug_code and g.language_id =? and IP_NURSING_UNIT.language_id=? Order By  IP_OPEN_ENCOUNTER.NURSING_UNIT_CODE,decode(?,'B',NVL(IP_OPEN_ENCOUNTER.bed_NUM,or_order.patient_id),or_order.patient_id)");

			int i=1	;
			pstmt.setString(i++,fill_int_start_date_time);          		 //1    	 
			pstmt.setString(i++,fill_int_end_date_time);            		 //2    	 
			pstmt.setString(i++,Proc_Type);				    		 		 //3    	 
			pstmt.setString(i++,"N");					    		 		 //4    	 
																			        	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //5    	 
			pstmt.setString(i++,Nursing_Unit_From);							 //6    	 
			pstmt.setString(i++,Nursing_Unit_To);							 //7    	 
			pstmt.setString(i++,Building_Code);								 //8    	 
			pstmt.setString(i++,Floor_Code);								 //9    	 
			pstmt.setString(i++,checkForNull(ip_fill_excl_prd_behind));	     //10        
			pstmt.setString(i++,compound_drug_ind);					         //11        
		  	pstmt.setString(i++,disp_locn_code);		    		         //12        
			pstmt.setString(i++,fill_int_start_date_time);  				 //13   	 
			pstmt.setString(i++,fill_int_end_date_time);    				 //14   	 
			pstmt.setString(i++,fill_int_start_date_time);  		 		 //15   	 
			pstmt.setString(i++,fill_int_end_date_time);    		 		 //16   	 
			pstmt.setString(i++,fill_int_start_date_time);					 //17   	 
			pstmt.setString(i++,fill_int_end_date_time);					 //18   	 
			pstmt.setString(i++,OrderingFacility_code);	    				 //19   	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //20   	 
			pstmt.setString(i++,Nursing_Unit_From);							 //21   	 
			pstmt.setString(i++,Nursing_Unit_To);							 //22   	 
			pstmt.setString(i++,nursing_unit_or_locn);						 //23   	 
			pstmt.setString(i++,OrderingFacility_code);						 //24   	 
			pstmt.setString(i++,Building_Code);								 //25   	 
			pstmt.setString(i++,Floor_Code);								 //26   	 
			pstmt.setString(i++,compound_drug_ind);							 //27   	 
			pstmt.setString(i++,compound_drug_ind);							 //28   	 
			pstmt.setString(i++,compound_drug_ind);							 //29   	 
			pstmt.setString(i++,Proc_Type);									 //30   	 
			pstmt.setString(i++,fill_int_start_date_time);			         //31        
			pstmt.setString(i++,checkForNull(ip_fill_excl_prd_behind));	 	 //32   	 
			pstmt.setString(i++,Proc_Type);							     	 //33   	 
			//pstmt.setString(i++,fill_int_start_date_time);			     	 //34   	 
			pstmt.setString(i++,locale);							     	 //35   	 
		    pstmt.setString(i++,locale);							     	 //36   	 
			pstmt.setString(i++,order_by_for_list);					     	 //37   	 

		
			System.err.println("fill_int_start_date_time----->"+fill_int_start_date_time);
            System.err.println("+fill_int_end_date_time--->"+fill_int_end_date_time);
            System.err.println("Proc_Type----->"+Proc_Type);
            System.err.println("N");

			System.err.println("nursing_unit_or_locn----->"+nursing_unit_or_locn);
			System.err.println("nursing_unit_or_locn----->"+Nursing_Unit_From);
			System.err.println("Nursing_Unit_To----->"+Nursing_Unit_To);
			System.err.println("Building_Code---->"+Building_Code);
			System.err.println("Floor_Code---->"+Floor_Code);
			System.err.println("ip_fill_excl_prd_behind---->"+ip_fill_excl_prd_behind);
			System.err.println("compound_drug_ind----->"+compound_drug_ind);

            System.err.println("disp_locn_code----->"+disp_locn_code);
            System.err.println("fill_int_start_date_time--->"+fill_int_start_date_time);
            System.err.println("fill_int_end_date_time--->"+fill_int_end_date_time);
			System.err.println("fill_int_start_date_time----->"+fill_int_start_date_time);
			System.err.println("fill_int_end_date_time----->"+fill_int_end_date_time);
			System.err.println("fill_int_start_date_time---->"+fill_int_start_date_time);
			System.err.println("fill_int_end_date_time---->"+fill_int_end_date_time);
			System.err.println("OrderingFacility_code---->"+OrderingFacility_code);
			System.err.println("nursing_unit_or_locn----->"+nursing_unit_or_locn);
			System.err.println("nursing_unit_or_locn----->"+Nursing_Unit_From);
			System.err.println("Nursing_Unit_To----->"+Nursing_Unit_To);
			System.err.println("nursing_unit_or_locn--->"+nursing_unit_or_locn);
			System.err.println("OrderingFacility_code--->"+OrderingFacility_code);
			System.err.println("Building_Code---->"+Building_Code);
			System.err.println("Floor_Code---->"+Floor_Code);
			System.err.println("compound_drug_ind----->"+compound_drug_ind);
			System.err.println("compound_drug_ind---->"+compound_drug_ind);
			System.err.println("compound_drug_ind---->"+compound_drug_ind);
			System.err.println("Proc_Type---->"+Proc_Type);
			System.err.println("fill_int_start_date_time---->"+fill_int_start_date_time);
			System.err.println("ip_fill_excl_prd_behind---->"+ip_fill_excl_prd_behind);
			System.err.println("Proc_Type---->"+Proc_Type);
			System.err.println("fill_int_start_date_time----->"+fill_int_start_date_time);
			System.err.println("locale--->"+locale);
		    System.err.println("locale---->"+locale);
			System.err.println("order_by_for_list--->"+order_by_for_list);
			
					
	   	resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null){
				while(resultSet.next()){
					ip_fill_order	= new HashMap();
					ip_fill_order.put("Tot_Disp_Qty",checkForNull(resultSet.getString("Tot_Disp_Qty")));
					ip_fill_order.put("Disp_qty",checkForNull(resultSet.getString("Disp_qty")));
					ip_fill_order.put("Patient_Details",checkForNull(resultSet.getString("Patient_Details")));
					ip_fill_order.put("patient_Name",checkForNull(resultSet.getString("patient_Name")));
					ip_fill_order.put("date_of_birth",checkForNull(resultSet.getString("date_of_birth")));
					ip_fill_order.put("sex",checkForNull(resultSet.getString("sex")));
					ip_fill_order.put("patient_id",checkForNull(resultSet.getString("patient_id")));
				   	ip_fill_order.put("Drug_Code",checkForNull(resultSet.getString("order_Catalog_code")));
					ip_fill_order.put("Drug_Name",checkForNull(resultSet.getString("Drug_Name")));
					ip_fill_order.put("ORDER_QTY",checkForNull(resultSet.getString("ORDER_QTY")));
					ip_fill_order.put("ORDER_UOM",checkForNull(resultSet.getString("ORDER_UOM")));
					ip_fill_order.put("ORDER_ID",checkForNull(resultSet.getString("ORDER_ID")));
					ip_fill_order.put("SOURCE_CODE",checkForNull(resultSet.getString("SOURCE_CODE")));
					ip_fill_order.put("ORDERING_FACILITY_ID",checkForNull(resultSet.getString("ORDERING_FACILITY_ID")));
					ip_fill_order.put("ORD_DATE_TIME",checkForNull(resultSet.getString("ORD_DATE_TIME")));
					ip_fill_order.put("PATIENT_ID",checkForNull(resultSet.getString("PATIENT_ID")));
					ip_fill_order.put("ENCOUNTER_ID",checkForNull(resultSet.getString("ENCOUNTER_ID")));
					ip_fill_order.put("ORD_PRACT_ID",checkForNull(resultSet.getString("ORD_PRACT_ID")));
					ip_fill_order.put("order_line_status",checkForNull(resultSet.getString("order_line_status")));
					ip_fill_order.put("start_Date_Time",checkForNull(resultSet.getString("start_Date_Time")));
					ip_fill_order.put("end_date_Time",checkForNull(resultSet.getString("end_date_Time")));
					ip_fill_order.put("DURN_VALUE",checkForNull(resultSet.getString("DURN_VALUE")));
					ip_fill_order.put("DURN_TYPE",checkForNull(resultSet.getString("DURN_TYPE")));
					ip_fill_order.put("NURSING_UNIT_DESC",checkForNull(resultSet.getString("NURSING_UNIT_DESC")));
					ip_fill_order.put("ORDER_LINE_NUM",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
					ip_fill_order.put("PATIENT_CLASS",checkForNull(resultSet.getString("PATIENT_CLASS")));
					ip_fill_order.put("SOURCE_TYPE",checkForNull(resultSet.getString("SOURCE_TYPE")));
					ip_fill_order.put("ROOM_NUM",checkForNull(resultSet.getString("ROOM_NUM")));
					ip_fill_order.put("BED_NUM",checkForNull(resultSet.getString("BED_NUM")));
					ip_fill_order.put("BED_CLASS_CODE",checkForNull(resultSet.getString("BED_CLASS_CODE")));
					ip_fill_order.put("BED_TYPE_CODE",checkForNull(resultSet.getString("BED_TYPE_CODE")));
					ip_fill_order.put("SPECIALTY_CODE",checkForNull(resultSet.getString("SPECIALTY_CODE")));
					ip_fill_order.put("ATTEND_PRACTITIONER_ID",checkForNull(resultSet.getString("ATTEND_PRACTITIONER_ID")));
					ip_fill_order.put("PERFORMING_FACILITY_ID",checkForNull(resultSet.getString("PERFORMING_FACILITY_ID")));

					ip_fill_list.add(ip_fill_order);


				  // System.err.println("ip_fill_list---from bean---->"+ip_fill_list);
				}
				 

			}
		}catch ( Exception e ) {												
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		this.ipFillList = ip_fill_list;
		//System.err.println("ip_fill_list----------->"+ip_fill_list);
		return ip_fill_list;
	
	}
  public ArrayList getBuildingList() {
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		ArrayList facilities    = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TRANS_BUILDING_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.disp_locn_code);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilities.add(resultSet.getString("BLDNG_CODE"));
				facilities.add(resultSet.getString("SHORT_DESC"));
			}
		}catch ( Exception e ) {
			facilities.add(e.toString());
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				facilities.add(es.toString());
			}
		}
		return facilities;
	}
	public void setAll( Hashtable recordSet ) {
		/* 
			This function also is called by the controller when apply is pressed
			recordSet is nothing but a hashtable containing all form values
		*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;

	}

	public ArrayList getFloorList(String BldngCode) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList facilities = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TRANS_FLOOR_SELECT" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,BldngCode);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilities.add(resultSet.getString("FLOOR_CODE"));
				facilities.add(resultSet.getString("SHORT_DESC"));
			}
		}catch ( Exception e ) {

			e.printStackTrace() ;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return facilities;
	}

	public String getCashCollectionStage(String disp_location_code){
		String disp_cash_coll_stage	="";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,disp_location_code);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				disp_cash_coll_stage=resultSet.getString("DISP_CASH_COLL_STAGE");// DISP_BILL_STAGE changed to DISP_CASH_COLL_STAGE for SRR20056-SCF-7639 ICN027720
			}
		}
        catch ( Exception e ) {
            System.err.println( "getFunctRollID:Error loading values from database" ) ;
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
		return disp_cash_coll_stage;
}



public String getDispBillingStage(){
		String disp_bill_stage	="";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT155") ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				disp_bill_stage=resultSet.getString("DISP_BILL_STAGE");
				
			}
		}
        catch ( Exception e ) {
            System.err.println( "getDispBillingStage  : getFunctRollID:Error loading values from database" ) ;
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
		System.err.println("disp_bill_stage---from bean---->"+disp_bill_stage);
		return disp_bill_stage;
}






public String getBLInterfaceYN(){
		String bl_interface_yn	= "";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2") ) ;
			pstmt.setString(1,login_facility_id.trim());
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
				
			}
		}
        catch ( Exception e ) {
            System.err.println( "getBLInterfaceYN:Error loading values from database" ) ;
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
		return bl_interface_yn;
}







	 public HashMap insert() {

//		HashMap result = new HashMap();
		HashMap tabData= new HashMap();
		HashMap sqlMap = new HashMap();
		HashMap recordSet = this.fillListDtl;

		tabData.put("flag","465759855");
		tabData.put("result",new Boolean(true));
		tabData.put("iv_drug_ind",recordSet.get("iv_drug_ind").toString());
		tabData.put("compound_drug_ind",recordSet.get("compound_drug_ind").toString());
				

		tabData.put("ip_excl_intermittent_fill",recordSet.get("ip_excl_intermittent_fill").toString());
		tabData.put("nursing_unit_or_locn",recordSet.get("nursing_unit_or_locn").toString());
		tabData.put("Nursing_Unit_From",recordSet.get("Nursing_Unit_From_Code").toString());
		tabData.put("Nursing_Unit_To",recordSet.get("Nursing_Unit_To_Code").toString());
		tabData.put("Building_Code",recordSet.get("Building_Code").toString());
		tabData.put("Floor_Code",recordSet.get("Floor_Code").toString());
		tabData.put("Proc_Type",recordSet.get("Proc_Type").toString());
		tabData.put("schedule_start",(com.ehis.util.DateUtils.convertDate(recordSet.get("schedule_start").toString(),"DMYHM",getLanguageId(),"en")).toString());
		tabData.put("Ip_Fill_Prd_Ahead",recordSet.get("Ip_Fill_Prd_Ahead").toString());
		tabData.put("ip_fill_prd_unit",recordSet.get("Fill_Period_Unit").toString());
		tabData.put("ip_fill_excl_prd_behind",recordSet.get("ip_fill_excl_prd_behind").toString());	
		tabData.put("order_by_for_list",recordSet.get("order_by_for_list").toString());
		tabData.put("login_facility_id",login_facility_id);
		tabData.put("disp_locn_code",recordSet.get("disp_locn_code").toString());
		tabData.put("user_id",login_by_id);
		tabData.put("fill_int_start_date_time",(com.ehis.util.DateUtils.convertDate(recordSet.get("fill_int_start_date_time").toString(),"DMYHM",getLanguageId(),"en")));
		tabData.put("fill_int_end_date_time",(com.ehis.util.DateUtils.convertDate(recordSet.get("fill_int_end_date_time").toString(),"DMYHM",getLanguageId(),"en")));
		tabData.put("cut_off_limit_for_new_ord",recordSet.get("cut_off_limit_for_new_ord").toString());
		tabData.put("login_at_ws_no",login_at_ws_no);
		tabData.put("message","ddd");
		tabData.put( "properties", getProperties() );
		tabData.put( "login_by_id", login_by_id );
		tabData.put( "facility_id", login_facility_id );
		tabData.put( "mode",getMode());
		tabData.put("LanguageId",recordSet.get("locale").toString());
		tabData.put( "CashCollectionStage",getCashCollectionStage(recordSet.get("disp_locn_code").toString()));
		tabData.put("BL_INTERFACE_YN", getBLInterfaceYN());
		tabData.put("DispBillingStage",getDispBillingStage());
		tabData.put("ipFillList",this.ipFillList);
		tabData.put("selectedRecords",this.Records);
		tabData.put("DISPUOMS",this.dispuoms);
	

		//System.err.println("tabData---------->"+tabData);


		try{
			sqlMap.put("SQL_PH_FILLPARAM_INSERT",PhRepository.getPhKeyValue( "SQL_PH_FILLPARAM_INSERT"));
			sqlMap.put("SQL_PH_FILLPARAM_SEQUENCE",PhRepository.getPhKeyValue( "SQL_PH_FILLPARAM_SEQUENCE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT56",PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_SELECT56"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT2",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT2"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT3",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT3"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT4",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT4"));
			sqlMap.put("SQL_PH_FILL_PROCESS_SELECT5",PhRepository.getPhKeyValue( "SQL_PH_FILL_PROCESS_SELECT5"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE",PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE"));
			sqlMap.put("SQL_PH_DISP_DTL_TMP_IP_UPDATE",PhRepository.getPhKeyValue( "SQL_PH_DISP_DTL_TMP_IP_UPDATE"));
			sqlMap.put("SQL_PH_DISP_BATCH_TMP_IP_UPDATE",PhRepository.getPhKeyValue( "SQL_PH_DISP_BATCH_TMP_IP_UPDATE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT1",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT1"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT2",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT2"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT3",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT3"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT4",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT4"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT5",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT5"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT6",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT6"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT7",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT7"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT8",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT8"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT9",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT9"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT10",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT10"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT11",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT11"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT12",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT12"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT13",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT13"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT14",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT14"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT15",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT15"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT16",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT16"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT17",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT17"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT18",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT18"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT19",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT19"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT20",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT20"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT21",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT21")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT22",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT22")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT23",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT23")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT24",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT24")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT25",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT25")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT26",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT26")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT27",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT27")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT28",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT28")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT29",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT29")); 
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT30",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT30"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT31",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT31"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT32",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT32"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT33",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT33"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT34",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT34"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT38",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT38"));			
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A"		,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_A"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_LAST_FILL_INT_DTL"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A"			,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_A"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_LAST_FILL_INT_DTL"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP","INSERT INTO PH_DISP_HDR_TMP (DISP_TMP_NO, FACILITY_ID, DISP_LOCN_CODE,ORDER_ID, RECORD_DATE_TIME, FILL_PROC_ID,ORDERING_FACILITY_ID, ORD_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, LOCN_TYPE, LOCN_CODE, ROOM_TYPE, ROOM_NO, BED_NO, BED_CLASS, BED_TYPE, SPECIALITY_CODE, ATTEND_PRACTITIONER_ID, PRES_PHYSICIAN_ID, DISPENSED_BY, DISPENSED_DATE_TIME,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES(?,?,?,?,SYSDATE,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		//	sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_HDR_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_DTL_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_DTL_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_INSERT_DRUG_BATCH_TMP"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE_PH"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER_LINE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER",PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_UPDATE_ORDER"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_TMP_UPDATE"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_HRD_UPDATE"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_HRD_UPDATE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_EQVL_VALUE"    ,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_EQVL_VALUE"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS" ,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_CAL_NO_OF_DAYS"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT64"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT64"));
			sqlMap.put("SQL_PH_IP_FILL_PROCESS_SELECT22A"    ,PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT22A"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_SELECT141"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT141"));
			sqlMap.put("SQL_PH_DISP_MEDICATION_BL_SELECT1"    ,PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT1"));

			

			
		}catch (Exception e) {
			e.printStackTrace() ;
		}

		
		HashMap map=new HashMap();
		try {
			
			 Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_IP_FILL" ),IPFillHome.class,getLocalEJB());

			 Object busObj =(home.getClass().getMethod("create",null)).invoke(home,null);

					 
			 Object argArray[] =new Object[2];
			 argArray[0]= tabData;
			 argArray[1]=sqlMap;

			 Class  paramArray[] = new Class[2];
			 paramArray[0]= tabData.getClass();
			 paramArray[1] = sqlMap.getClass();
					
			// map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			//(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		   
			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			 // System.err.println("map-----from bean----907--->"+map);
		    if(((String)map.get("msgid")).equals("RECORD_NOT_INSERTED_FILL")){
				     map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH")) ;
				     map.put( "flag", (String)map.get("flag") ) ;
					System.err.println("inside 912");
			}else if(((String)map.get("msgid")).equals("PH_DOC_TYPE_SETTINGS_NOT_AVAIL")){
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH")) ;
					System.err.println("inside 916");
			}else if(((String)map.get("msgid")).equals("")){
					map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED_FILL","PH")) ;
                    System.err.println("inside 919");
			}else if(!((String)map.get("msgid")).equals("")){
			        map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED_FILL","PH")+getMessage(getLanguageId(),"WITH_ERRORS","PH")+ (String)map.get("msgid") ) ;
					System.err.println("inside 922");
			}
		    

			/*if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH") ) ;
				System.err.println("in side if condition");				 
			    }
			else{
				if(!((String)map.get("msgid")).equals("RECORD_NOT_INSERTED_FILL")){
				map.put( "message", (String)map.get("msgid") ) ;
				map.put( "flag", (String)map.get("flag") ) ;
					System.err.println("inside 878");
				}else if(((String)map.get("msgid")).equals("PH_DOC_TYPE_SETTINGS_NOT_AVAIL")){
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid"),"PH")) ;
					System.err.println("inside 882");
				}
			 }*/
		 }catch (Exception e){
			e.printStackTrace();
		 }
		
		System.err.println("map----from bean---928--->"+map);
		return map;
	 }
	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

	public HashMap getNextEffStartDateEndDate(String start_date_time){
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
	//	String eff_start_date   = "";  Removed for IN063877
	//	String eff_end_date     = "";  Removed for IN063877
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35" )) ;
			resultSet = pstmt.executeQuery() ;
			
			while (resultSet!=null && resultSet.next()) {
				if(resultSet.getInt("COUNT")>0){
					eff_dates.put("EFF_START_DATE",resultSet.getString("EFF_START_DATE"));
					eff_dates.put("EFF_END_DATE"  ,resultSet.getString("EFF_END_DATE"));
				}
			}								  
		 }catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return eff_dates;
	}

    public HashMap getEffStartDateEndDate(String start_date_time){
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35" )) ;
			pstmt = connection.prepareStatement("select to_char(sysdate,'DD/MM/YYYY HH24:MI') EFF_START_DATE from dual") ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet!=null && resultSet.next()) {
				 	eff_dates.put("EFF_START_DATE",resultSet.getString("EFF_START_DATE"));
					
				}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		return eff_dates;
	}
	
	public HashMap getNextRoutineEffStartDateEndDate(String start_date_time,String fill_period,String disp_locn_code,String schedule_start,boolean flag){
		HashMap		eff_dates	= new HashMap();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36D")) ;
			pstmt		= connection.prepareStatement("SELECT NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY'))||' '||(SELECT TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') FROM PH_DISP_LOCN WHERE FACILITY_ID=? AND DISP_LOCN_CODE=? ) START_DATE FROM DUAL") ;
			
			pstmt.setString(1,schedule_start);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,disp_locn_code);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				start_date_time = resultSet.getString("START_DATE");
			}	
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
			
			if(flag){
				pstmt = connection.prepareStatement("select 1 from dual where to_date(?,'dd/mm/yyyy hh24:mi') > sysdate");
				System.err.println("start_date_time---1052---->"+start_date_time);
				pstmt.setString(1,start_date_time.substring(0,16));
				resultSet	= pstmt.executeQuery() ;

				if (resultSet!=null && resultSet.next()){
					if(fill_period != null) {
						System.err.println("fill_period...before"+fill_period);
						Integer i = new Integer(fill_period);
						Integer j = new Integer((i.intValue()-24));
						fill_period = j.toString();
						System.err.println("fill_period...after"+fill_period);
					}

				}	
				closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

			}
			 /*System.err.println("start_date_time---1-->"+start_date_time);
			 System.err.println("start_date_time---2-->"+start_date_time.substring(0,10));
			 System.err.println("start_date_time---3-->"+start_date_time.substring(0,16));*/

		//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT35A" )) ;
		 pstmt = connection.prepareStatement("SELECT TO_CHAR(TO_DATE((NVL(?,TO_CHAR(SYSDATE,'DD/mm/yyyy'))) ||' '|| TO_CHAR(TO_DATE(?,'dd/mm/yyyy hh24:mi'),'hh24:mi'),'DD/MM/YYYY HH24:MI')+(?/24),'dd/mm/yyyy hh24:MI') EFF_END_DATE FROM DUAL") ;
			
			pstmt.setString(1,start_date_time.substring(0,10));
			pstmt.setString(2,start_date_time.substring(0,16));
			pstmt.setString(3,fill_period);

			resultSet = pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()) {
				eff_dates.put("EFF_START_DATE",start_date_time);
				eff_dates.put("EFF_END_DATE"  ,resultSet.getString("EFF_END_DATE"));
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		  //System.err.println("eff_dates---from bean---->"+eff_dates);

		return eff_dates;
	}
	
	public HashMap getNextRoutineEffStartDateEndDate(String start_date_time,String fill_period,String disp_locn_code,String schedule_start){
		return getNextRoutineEffStartDateEndDate(start_date_time,fill_period,disp_locn_code,schedule_start,false);
	}

	public String compareDates(String from_date_time) throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String result		      = from_date_time;
		String today			  = ""; 
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36B"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				today   = resultSet.getString("TODAY");
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36C")) ;
			pstmt.setString(1,from_date_time);
			pstmt.setString(2,today);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("VAL")<0){
					 pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36D")) ;
					 pstmt.setString(1,login_facility_id);
					 pstmt.setString(2,disp_locn_code);
					 resultSet	= pstmt.executeQuery() ;
					 if (resultSet!=null && resultSet.next()){
						 result = resultSet.getString("START_DATE");
					 }		
				}
			}	
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;

		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return result;
	}
	
	public boolean isGreaterThanSysdate(String date_time) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		boolean result			  = false; 
		String today			  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36B"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				today   = resultSet.getString("TODAY");
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36C")) ;
			pstmt.setString(1,date_time);
			pstmt.setString(2,today);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("VAL")>=0){
					result	= true;
				}
			}
			closeStatement( pstmt ) ;
				closeResultSet( resultSet ) ;
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return result;
	}

	public String getSysDateTime() throws Exception{
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String today			  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT36B"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				today   = resultSet.getString("TODAY");
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return today;
	}

 //added by suri
  public ArrayList getFillListAltDrugs(String disp_locn_code,int ord_drug_qty,String fill_int_end_date_time,String ord_drug_code,String locale) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList fl_alt_drugs = new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_ALT_DRUGS_SELECT" )) ;
			//pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG A, PH_DRUG B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND    EXISTS (SELECT COUNT(*) FROM  AM_UOM_EQVL WHERE (UOM_CODE=A.STRENGTH_UOM AND   EQVL_UOM_CODE=B.STRENGTH_UOM) OR   (UOM_CODE=B.STRENGTH_UOM AND   EQVL_UOM_CODE=A.STRENGTH_UOM) ) AND   A.STRENGTH_VALUE<>0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.GENERIC_ID=(SELECT GENERIC_ID FROM PH_DRUG WHERE DRUG_CODE = ?) AND   B.DRUG_CODE=? AND  A.DISP_MULTI_STRENGTH_YN='Y' AND  PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL )  >  ?") ;
			//pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG_lang_vw A, PH_DRUG_lang_vw B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND    EXISTS (SELECT COUNT(*) FROM  AM_UOM_EQVL WHERE (UOM_CODE=A.STRENGTH_UOM AND   EQVL_UOM_CODE=B.STRENGTH_UOM) OR   (UOM_CODE=B.STRENGTH_UOM AND   EQVL_UOM_CODE=A.STRENGTH_UOM) ) AND   A.STRENGTH_VALUE<>0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.GENERIC_ID=(SELECT GENERIC_ID FROM PH_DRUG WHERE DRUG_CODE = ?) AND   B.DRUG_CODE=? AND  A.DISP_MULTI_STRENGTH_YN='Y' AND a.language_id= b.language_id and a.language_id=? and PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL )  >  ?") ;



			//pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG_lang_vw A, PH_DRUG_lang_vw B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND    EXISTS (SELECT COUNT(*) FROM  AM_UOM_EQVL WHERE (UOM_CODE=A.STRENGTH_UOM AND   EQVL_UOM_CODE=B.STRENGTH_UOM) OR   (UOM_CODE=B.STRENGTH_UOM AND   EQVL_UOM_CODE=A.STRENGTH_UOM) ) AND   A.STRENGTH_VALUE<>0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.GENERIC_ID=(SELECT GENERIC_ID FROM PH_DRUG WHERE DRUG_CODE = ?) AND   B.DRUG_CODE=? AND  A.STRENGTH_VALUE =B.STRENGTH_VALUE and A.DISP_MULTI_STRENGTH_YN='Y' AND a.language_id= b.language_id and a.language_id=? and a.DISCONTINUED_YN='N' and b.DISCONTINUED_YN='N'   and PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL )  >  ?");
			
		//and A.DISP_MULTI_STRENGTH_YN='Y' REMOVED FOR GHL-CRF-0548
			
			pstmt = connection.prepareStatement("SELECT   A.DRUG_CODE CODE,   A.DRUG_DESC || '  (AVAIL QTY  :' || PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL ) || ')'  DESCRIPTION FROM PH_DRUG_lang_vw A, PH_DRUG_lang_vw B, AM_UOM C, PH_INVENTORY_ITEM_FOR_DRUG F WHERE    A.GENERIC_ID=B.GENERIC_ID AND   A.ROUTE_CODE=B.ROUTE_CODE AND   (( B.DISP_ALT_FORM_YN='N' AND B.FORM_CODE=A.FORM_CODE ) OR  B.DISP_ALT_FORM_YN='Y') AND A.STRENGTH_UOM=C.UOM_CODE AND    EXISTS (SELECT COUNT(*) FROM  AM_UOM_EQVL WHERE (UOM_CODE=A.STRENGTH_UOM AND   EQVL_UOM_CODE=B.STRENGTH_UOM) OR   (UOM_CODE=B.STRENGTH_UOM AND   EQVL_UOM_CODE=A.STRENGTH_UOM) ) AND   A.STRENGTH_VALUE<>0 AND   A.DRUG_CODE=F.DRUG_CODE(+) AND   A.GENERIC_ID=(SELECT GENERIC_ID FROM PH_DRUG WHERE DRUG_CODE = ?) AND   B.DRUG_CODE=? AND  A.STRENGTH_VALUE =B.STRENGTH_VALUE  AND a.language_id= b.language_id and a.language_id=? and a.DISCONTINUED_YN='N' and b.DISCONTINUED_YN='N'   and PH_RET_STOCK_AVAIL_STATUS(F.INVENTORY_ITEM_CODE,?,?,'Y',TO_DATE(?,'DD/MM/YYYY'),'N',NULL )  >  ?");
			pstmt.setString(1,disp_locn_code);
			pstmt.setInt(2,ord_drug_qty);
			pstmt.setString(3,fill_int_end_date_time);
			pstmt.setString(4,ord_drug_code);
			pstmt.setString(5,ord_drug_code);
			pstmt.setString(6,locale);
			pstmt.setString(7,disp_locn_code);
			pstmt.setInt(8,ord_drug_qty);
			pstmt.setString(9,fill_int_end_date_time);
			pstmt.setInt(10,ord_drug_qty);

		/*	System.err.println("disp_locn_code---------->"+disp_locn_code);
			System.err.println("ord_drug_qty---------->"+ord_drug_qty);
			System.err.println("fill_int_end_date_time---------->"+fill_int_end_date_time);
			System.err.println("ord_drug_code---------->"+ord_drug_code);
			System.err.println("ord_drug_code---------->"+ord_drug_code);
*/
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				fl_alt_drugs.add(resultSet.getString("CODE"));
				fl_alt_drugs.add(resultSet.getString("DESCRIPTION"));
//System.err.println("==fl_alt_drugs====="+fl_alt_drugs);
			}
		}catch ( Exception e ) {

			e.printStackTrace() ;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return fl_alt_drugs;
	}
	
	public int getMaxDurnForIPPres()throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		int max_durn_for_ip_pres	= 1;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				max_durn_for_ip_pres   = resultSet.getInt("MAX_DURN_FOR_IP_PRES");
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return max_durn_for_ip_pres;		
	}

	public String getAltDrugBtchDtls(String disp_locn_code,String alt_drug_code,String fill_int_start_date_time,String fill_int_end_date_time,String order_id,String Proc_Type,String drug_code) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String alt_drg_btch_dtls  = "";
		String alternate  ="A";
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_IP_FILL_PROCESS_SELECT40" )) ;

			pstmt = connection.prepareStatement("SELECT PH_DISPLAY_STOCK_UNIT(?,	?, E.ORDER_ID,	E.ORDER_LINE_NUM,	?,	NVL((SELECT TO_CHAR(NEXT_FILL_DATE,'DD/MM/YYYY HH24:MI') FROM OR_ORDER_LINE_PH WHERE ORDER_ID = E.ORDER_ID AND ORDER_LINE_NUM = E.ORDER_LINE_NUM),?),	?,	?,	NULL,	E.START_DATE_TIME,	E.END_DATE_TIME,	E.DURN_TYPE,	E.DURN_VALUE, 	E.ORDER_LINE_STATUS, 	E.ORDER_QTY,	E.ORDER_UOM,	?) DISP_QTY FROM OR_ORDER_LINE E WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?") ;
            if(alt_drug_code.equals(drug_code)) {
				alternate ="N";
			} 

	 	    pstmt.setString(1,login_facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,alt_drug_code);
			pstmt.setString(4,fill_int_start_date_time);
			pstmt.setString(5,fill_int_end_date_time);
			pstmt.setString(6,Proc_Type);
			pstmt.setString(7,alternate);
			pstmt.setString(8,order_id);
			pstmt.setString(9,"1");

			 /*System.err.println("login_facility_id----->"+login_facility_id);
			 System.err.println("disp_locn_code----->"+disp_locn_code);
			 System.err.println("alt_drug_code----->"+alt_drug_code);
			 System.err.println("fill_int_start_date_time----->"+fill_int_start_date_time);
			 System.err.println("fill_int_end_date_time----->"+fill_int_end_date_time);
			 System.err.println("Proc_Type----->"+Proc_Type);
			 System.err.println("alternate----->"+alternate);
			 System.err.println("order_id----->"+order_id);	*/
			
			

			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				alt_drg_btch_dtls  = resultSet.getString("DISP_QTY"); 
			}
		}catch ( Exception e ) {

			e.printStackTrace() ;
		}finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) { es.printStackTrace(); }
		}
		return alt_drg_btch_dtls;
	}


	public String getAltStockUOM(String drug_code)throws Exception{
		Connection connection	    = null;
        PreparedStatement pstmt	    = null;
        ResultSet resultSet		    = null;
		String Stock_uom			= "";
		try {
            connection	= getConnection() ;
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IP_FILL_PROCESS_SELECT37"));
			pstmt		= connection.prepareStatement("SELECT STOCK_UOM FROM PH_DRUG WHERE DRUG_CODE =?");
			
            pstmt.setString(1,drug_code);

			resultSet	= pstmt.executeQuery() ;

			if (resultSet!=null && resultSet.next()){
				Stock_uom   = resultSet.getString("STOCK_UOM");
			}
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return Stock_uom;		
	}

	
	
}
