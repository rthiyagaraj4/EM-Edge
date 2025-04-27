
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P		06/02/2018		 		Ramesh G       GHL-CRF-0487 [IN:065642]
14/02/2018      IN066695        Prathyusha p     14/02/2018        Ramesh G        GHL-CRF-0487_US001 [IN:065642]
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import eOR.Common.OrAdapter;
import webbeans.eCommon.*;
public class TeleRadiologyOrdersBean extends eOR.Common.OrAdapter implements Serializable {
	
	
	private Hashtable recordSet				= new Hashtable();
	HashMap<String, Object> commonStoreMap = new HashMap<String, Object>();
	public HashMap<String, Object> getCommonStoreMap() {
		return commonStoreMap;
	}

	public void setCommonStoreMap(HashMap<String, Object> commonStoreMap) {
		this.commonStoreMap = commonStoreMap;
	}


	public void setAll( Hashtable recordSet ) {
		
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;
	}
	
		// To get the Sysdate, with Properties
	public ArrayList getSysDateTime(Properties properties) throws Exception {
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		ArrayList  currentDate			= new ArrayList();

		try {
				connection				= ConnectionManager.getConnection(properties) ;
				pstmt					= connection.prepareStatement( "select to_char(sysdate,'HH12:MM') sys_time,to_char(sysdate,'dd/mm/yyyy') sys_date, to_char(sysdate+1,'dd/mm/yyyy')   next_sys_date ,to_char(sysdate,'DD/mm/yyyy') || ' 23:59' curr_date, to_char(sysdate - 7,'DD/mm/yyyy') || ' 00:00' last_week_date, to_char(sysdate - 7,'DD/mm/yyyy') last_week_without_date,  to_char(sysdate + 7,'DD/mm/yyyy') next_week_without_date, to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date_time, to_char(sysdate - 30 ,'DD/mm/yyyy') last_month_date, to_char( sysdate, 'HH24:MI:SS' ) sys_time_sec, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi:ss') sys_date_time_sec,USERENV('SESSIONID') session_id from dual" ) ;
				resultSet				= pstmt.executeQuery() ;

				if( resultSet != null && resultSet.next() ) {
					currentDate.add(resultSet.getString("sys_date"))  ;
					currentDate.add(resultSet.getString("last_week_without_date"))  ;
					currentDate.add(resultSet.getString("sys_date_time"))  ;
					currentDate.add(resultSet.getString("next_week_without_date"))  ;
					currentDate.add(resultSet.getString("last_month_date"))  ;
					currentDate.add(resultSet.getString("sys_time_sec"))  ;
				}
			} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
		}

		return currentDate;
	}
	public ArrayList getReadoligyOrdersList(String ordering_facility_id,String ordered_by,String order_id,String performing_facility_id,String performed_by,String order_type_code,String order_catalog_code,String reporting_facility_id,String ORDERED_PRACT,String assigned_rad_id,String exam_status,String fromDate,String toDate,String patient_id) throws Exception{
		ArrayList  readoligyOrdersList			= new ArrayList();
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
	String sqlQuery="SELECT sm_get_desc.sm_facility_param (a.ordering_facility_id, ?, 1 ) ordering_facility, d.ordering_facility_id, a.physician_id, a.patient_id, b.order_id, b.order_line_no, b.order_type_code, sm_get_desc.sm_facility_param (b.operating_facility_id, ?, 1 ) operating_facility, b.operating_facility_id, b.request_num, b.request_line_num, TO_CHAR (b.end_time, 'dd/mm/yyyy hh24:mi') end_time, b.exam_code, am_get_desc.am_practitioner (b.performed_by_id, ?, '2' ) performed_by, b.performed_by_id, sm_get_desc.sm_facility_param (b.reporting_facility_id, ?, 1 ) reporting_facility, b.reporting_facility_id, b.reporting_radiologist_id, b.assign_rad_remarks,to_char( b.assign_date,'mm/dd/yyyy hh24:mi') assign_date, am_get_desc.am_practitioner (b.radiologist_id, ?, '2') assign_by,b.radiologist_id, c.order_catalog_code, c.catalog_desc catalog_desc, DECODE (b.status, '50', 'Performed', '60', 'On Hold', '65', 'Prelim', '70', 'Finalized', '85', 'Modified' ) status_name, b.status, (SELECT COUNT (*) FROM rd_assign_radiologist_audit WHERE request_num = b.request_num AND request_line_num = b.request_line_num AND operating_facility_id = b.operating_facility_id) COUNT, (SELECT get_age (date_of_birth) age FROM mp_patient WHERE patient_id = a.patient_id) age, (SELECT sex FROM mp_patient WHERE patient_id = a.patient_id) sex, mp_get_desc.mp_patient (a.patient_id, '1') patient_name, (SELECT APPL_USER_NAME FROM sm_appl_user WHERE  appl_user_id=C.ADDED_BY_ID) ordered_by,sm_get_desc.sm_facility_param (d.performing_facility_id, ?, 1 ) performing_facility, d.performing_facility_id, d.ord_pract_id, d.encounter_id ,(select AM_GET_DESC.AM_SPECIALITY(SPECIALTY_CODE,?,2) from pr_encounter aa where aa.ENCOUNTER_ID = d.ENCOUNTER_ID and rownum=1) speciality_desc,am_get_desc.am_practitioner (d.ord_pract_id, ?, '2' ) ordered_pract_name FROM rd_request a, rd_exam_view_requested b, or_order_line c, or_order d,rd_exams e WHERE a.operating_facility_id = b.operating_facility_id AND b.exam_code = e.exam_code and e.order_catalog_code=c.order_catalog_code AND a.request_num = b.request_num  AND c.order_id = d.order_id AND b.order_id = d.order_id AND a.ordering_facility_id = NVL (?, a.ordering_facility_id) AND d.ord_pract_id = NVL (?, d.ord_pract_id) AND a.patient_id = NVL (?, a.patient_id) AND b.order_id = NVL (?, b.order_id) AND a.operating_facility_id = NVL (?, a.operating_facility_id) AND NVL (b.performed_by_id, '!') = NVL (?, NVL (b.performed_by_id, '!')) AND b.order_type_code = NVL (?, b.order_type_code) AND UPPER(c.catalog_desc) LIKE UPPER (?)  AND NVL (b.reporting_facility_id, '!') = NVL (?, NVL (b.reporting_facility_id, '!')) AND c.added_by_id = NVL (?, c.added_by_id) AND NVL (b.radiologist_id, '!') =NVL (?, NVL (b.radiologist_id, '!'))  AND b.status = DECODE (?, 'A', b.status, 'C', '50', 'H', '60', 'P', '65', 'F', '70', 'M', '85' )AND b.status >= '50' AND b.status NOT IN ('99', '80') AND b.end_time IS NOT NULL AND b.end_time BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') AND TO_DATE (?, 'DD/MM/YYYY HH24:MI') ORDER BY b.end_time DESC";	
	try {
			connection				= ConnectionManager.getConnection(properties) ;
			pstmt					= connection.prepareStatement( sqlQuery ) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,language_id);
			pstmt.setString(3,language_id);
			pstmt.setString(4,language_id);
			pstmt.setString(5,language_id);
			pstmt.setString(6,language_id);
			pstmt.setString(7,language_id);
			pstmt.setString(8,language_id);
			//pstmt.setString(9,language_id);
			pstmt.setString(9,ordering_facility_id);//ordering_facility_id
			pstmt.setString(10,ORDERED_PRACT);//physician_id
			
			pstmt.setString(11,patient_id);//patient_id
			pstmt.setString(12,order_id);//order_id
			pstmt.setString(13,performing_facility_id);//    operating_facility_id

			pstmt.setString(14,performed_by);//performed_by_id
			pstmt.setString(15,order_type_code);//order_type_code

			pstmt.setString(16,order_catalog_code);//order_catalog_code
			pstmt.setString(17,reporting_facility_id);//reporting_facility_id
			pstmt.setString(18,ordered_by);//reporting_radiologist_id
			pstmt.setString(19,assigned_rad_id);//reporting_radiologist_id
			pstmt.setString(20,exam_status);//status
			pstmt.setString(21,fromDate);//from date
			pstmt.setString(22,toDate);//to date
			resultSet				= pstmt.executeQuery() ;
			
			   while (resultSet.next()){
			                 readoligyOrdersList.add(checkForNull(resultSet.getString("STATUS_NAME")));//0
							   readoligyOrdersList.add(checkForNull(resultSet.getString("END_TIME")));//1
							   readoligyOrdersList.add(checkForNull(resultSet.getString("PATIENT_ID")));//2
							    readoligyOrdersList.add(checkForNull(resultSet.getString("PATIENT_NAME")));//3
								readoligyOrdersList.add(checkForNull(resultSet.getString("AGE"))+"/"+checkForNull(resultSet.getString("SEX")));//4
								readoligyOrdersList.add(checkForNull(resultSet.getString("CATALOG_DESC")));//5
								readoligyOrdersList.add(checkForNull(resultSet.getString("PERFORMING_FACILITY")));//6
							   readoligyOrdersList.add(checkForNull(resultSet.getString("PERFORMED_BY")));//7
							   readoligyOrdersList.add(checkForNull(resultSet.getString("REPORTING_FACILITY")));//8
							   readoligyOrdersList.add(checkForNull(resultSet.getString("ASSIGN_BY")));//9
							   readoligyOrdersList.add(checkForNull(resultSet.getString("ASSIGN_RAD_REMARKS")));//10
							   readoligyOrdersList.add(checkForNull(resultSet.getString("ORDERED_PRACT_NAME"))+"/"+checkForNull(resultSet.getString("ORDERING_FACILITY")));//11
							   readoligyOrdersList.add(checkForNull(resultSet.getString("SPECIALITY_DESC")));//12
							   readoligyOrdersList.add(checkForNull(resultSet.getString("ORDERED_BY")));//13
							   readoligyOrdersList.add(checkForNull(resultSet.getString("ORDER_ID")));//14
							     readoligyOrdersList.add(checkForNull(resultSet.getString("REPORTING_FACILITY_ID")));//15
							     readoligyOrdersList.add(checkForNull(resultSet.getString("STATUS")));//16
							   readoligyOrdersList.add(checkForNull(resultSet.getString("REQUEST_NUM")));//17
							   readoligyOrdersList.add(checkForNull(resultSet.getString("REQUEST_LINE_NUM")));//18
							   readoligyOrdersList.add(checkForNull(resultSet.getString("COUNT")));//19
							   readoligyOrdersList.add(checkForNull(resultSet.getString("OPERATING_FACILITY_ID")));//20
							   readoligyOrdersList.add(checkForNull(resultSet.getString("PERFORMED_BY_ID")));//21
							   readoligyOrdersList.add(checkForNull(resultSet.getString("PHYSICIAN_ID")));//22
							   readoligyOrdersList.add(checkForNull(resultSet.getString("REPORTING_RADIOLOGIST_ID")));//23
							    readoligyOrdersList.add(checkForNull(resultSet.getString("RADIOLOGIST_ID")));//24
								readoligyOrdersList.add(checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));//25
								readoligyOrdersList.add(checkForNull(resultSet.getString("ORDERING_FACILITY_ID")));//26
								 readoligyOrdersList.add(checkForNull(resultSet.getString("ORDERED_PRACT_NAME")));//27
				   
			   }

			if( resultSet != null && resultSet.next() ) {
				
			}
		} catch ( Exception e )	{

		e.printStackTrace() ;
		throw e ;
	} finally {
		closeStatement(pstmt) ;
		closeResultSet(resultSet) ;
		if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
	}
		return  readoligyOrdersList;
	}
	
	
	public HashMap modify(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		//String key=null;//51003
	//	ArrayList insertRow				= new ArrayList();//51003
//	   boolean successFlag = false;//51003
		Connection con=null;
		PreparedStatement pstmt = null;
	
		try{
			
		}catch (Exception e) {
			e.printStackTrace();
			map.put( "result", new Boolean( false ) ) ;	
			map.put( "message", "ERROR While updating the record in PH_DISP_DRUG_BATCH"+e.getMessage() ) ;
		}finally{
			try{
			con.close();
			pstmt.close();
			}catch (Exception eclose) {
				
				// TODO: handle exception
				eclose.printStackTrace();
			}
		}
		
		return map;
	}
	
	public ArrayList auditTrailDetails(String ordering_facility_id,String request_num,String request_line_num) throws Exception{
		ArrayList  auditTrailsList			= new ArrayList();
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String auditTrailSql="SELECT a.reporting_facility_id, a.reporting_radiologist_id, b.short_name,a.assign_rad_remarks, TO_CHAR (a.assign_date, 'dd/mm/yyyy hh24:mi') assign_date, a.assign_by_id,(SELECT appl_user_name FROM sm_appl_user_lang_vw WHERE language_id = 'en' AND appl_user_id = a.added_by_id )assign_by,DECODE (a.exam_status,'50', 'Performed','60', 'On Hold','65', 'Prelim','70', 'Finalized','85', 'Modified') exam_status,(SELECT facility_name FROM sm_facility_param_lang_vw WHERE facility_id = a.reporting_facility_id AND language_id = ?) reporting_facility FROM rd_assign_radiologist_audit a, rd_radiologist b WHERE a.reporting_facility_id = b.operational_facility_id AND a.reporting_radiologist_id = b.radiologist_id AND b.language_id = ? AND a.operating_facility_id = ? AND a.request_num = ? AND a.request_line_num = ?  order by a.assign_date desc";
		
		try {
			connection				= ConnectionManager.getConnection(properties) ;
			pstmt					= connection.prepareStatement( auditTrailSql ) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,language_id);
			pstmt.setString(3,ordering_facility_id);
			pstmt.setString(4,request_num);
			pstmt.setString(5,request_line_num);
			
			resultSet				= pstmt.executeQuery() ;
			
			   while (resultSet.next()){
				   auditTrailsList.add(checkForNull(resultSet.getString("exam_status")));//0
				   auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_DATE")));//1
				   auditTrailsList.add(checkForNull(resultSet.getString("REPORTING_FACILITY")));//2
				   auditTrailsList.add(checkForNull(resultSet.getString("SHORT_NAME")));//3
				   auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_RAD_REMARKS")));//4
				   auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_BY_ID")));//5
				   auditTrailsList.add(checkForNull(resultSet.getString("ASSIGN_BY")));//6
				  
				   
				   
			   }

			if( resultSet != null && resultSet.next() ) {
				
			}
		} catch ( Exception e )	{

		e.printStackTrace() ;
		throw e ;
	} finally {
		closeStatement(pstmt) ;
		closeResultSet(resultSet) ;
		if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
	}
		return  auditTrailsList;
	}

	public String getFacilityName(String facility_id,String locale){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		//ArrayList FacilityList =		new ArrayList();
		String facilityName			="";
	
		try {
			connection	 = getConnection() ;
			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RE_ROUTE_SM_FACILITY_SELECT" )) ;
			pstmt			 = connection.prepareStatement("select facility_name from sm_facility_param_lang_vw  where facility_id = ? and status = 'E' and language_id = ?") ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);

			resultSet   = pstmt.executeQuery() ;
			while (resultSet.next()) {
				facilityName= (String)resultSet.getString("facility_name");
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
		return facilityName;
	}
	

public ArrayList getOrderingFacilityId(String locale) {
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	ArrayList result=new ArrayList();
	try {
		connection = getConnection() ;
		//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
		//pstmt = connection.prepareStatement("SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_LANG_VW B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?") ; //commented and added below sql for 033992 - [PH -> ReRoute -> Ordering Facility is not shown in Verification stage]
		pstmt = connection.prepareStatement("SELECT FACILITY_ID ,FACILITY_NAME  FROM  SM_FACILITY_PARAM_LANG_VW  WHERE STATUS ='E'AND LANGUAGE_ID= ? order by FACILITY_NAME") ;
		//pstmt.setString(1,p_user_name); //Commented for 033992 //order by added for ML-BRU-SCF-1517 [IN:053108]
		pstmt.setString(1,locale);

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
	return result;
}
}