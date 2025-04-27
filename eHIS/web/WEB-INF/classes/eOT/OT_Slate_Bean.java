/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;


public class OT_Slate_Bean extends OTAdapter implements Serializable {


	Properties	p = this.properties;
	String	locale	= "";
	String sql_curr_date="";
	String strRoomCode="";
	String strFromTime="";
	String strFromHiddenTime="";
	String strToTime="";
	String strPatientID="";
	String strPatientName="";
	String strName="";
	String strOperDesc="";
	String strStatus="";
	String strSpltycode="";
	String strSpltycodedesc="";
	String booking_num1="";
	String strOperRoomCode="";
	String strSurgeonName="";
	String strAge="";
	String strGender="";
	String strSurgeon="";
	String strStaff="";
	String strAsstSurgeonOne="";
	String strAsstSurgeonTwo="";
	String strShortDesc="";
	String strDisplayStatus="";
	String strColorCode="";
	String strOperNum="";
	String totalBookingCount="";
	String strDisplayTime="";
	String caseType = "";
	String roleType = "";
	String roleTypeDescSysDef = "";
	
	public String getRoleTypeDescSysDef() {
		return roleTypeDescSysDef;
	}
	public void setRoleTypeDescSysDef(String roleTypeDescSysDef) {
		this.roleTypeDescSysDef = roleTypeDescSysDef;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getTotalBookingCount() {
		return totalBookingCount;
	}
	public void setTotalBookingCount(String totalBookingCount) {
		this.totalBookingCount = totalBookingCount;
	}
	public String getStrStaff() {
		return strStaff;
	}
	public void setStrStaff(String strStaff) {
		this.strStaff = strStaff;
	}
	public String getStrSurgeon() {
		return strSurgeon;
	}
	public void setStrSurgeon(String strSurgeon) {
		this.strSurgeon = strSurgeon;
	}
	int fetchCount=0;
	int Count=0;

	/* Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet resultSet = null; */	//Commented Against Common-ICN-0031
	public OT_Slate_Bean() {
		try {
			doCommon();
		}catch(Exception e) {}
	}
	public void doCommon() throws Exception {
		locale	= (String) p.getProperty("LOCALE");
	}

	public void clear(){
		super.clear();

	}
	
	
	public List<OT_Slate_Bean> getAnaesthetistDtls(String room_no){
		List<OT_Slate_Bean> getAnaesthetist = new ArrayList<OT_Slate_Bean>();
		OT_Slate_Bean getAnaesthetistdtl = null;
	Connection conn = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
		
		try{

			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");

			conn = getConnection();
			pst = conn
					.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL");
			rs = pst.executeQuery();
			if (rs.next()) {
				sql_curr_date = rs.getString("CURRENT_DATE");
			}
			if (pst != null)
				pst.close();
			if (rs != null)
				rs.close();
			//String query1="SELECT a.short_name short_name1 FROM am_practitioner a, ot_staff_assignment b, ot_roles c  WHERE  a.practitioner_id = b.staff_id AND b.role_id = c.role_id AND c.role_type = 'MA' AND SHOW_WIDGET_YN='Y' AND b.assignment_date = TO_CHAR (SYSDATE,'DD/MM/YYYY') and b.oper_room_code=? order by short_name1";
			String query1="SELECT a.short_name short_name1,d.role_type,d.ROLE_TYPE_DESC_SYSDEF FROM am_practitioner a, ot_staff_assignment b, ot_roles c, ot_role_type d WHERE a.practitioner_id = b.staff_id AND b.role_id = c.role_id AND c.role_type = d.role_type AND c.role_type in ( 'MA','AA' ) AND show_widget_yn = 'Y' AND b.assignment_date = TO_CHAR (SYSDATE, 'DD/MM/YYYY') AND b.oper_room_code = ? ORDER BY role_type_desc_sysdef,short_name";
			
		  pst = conn.prepareStatement(query1);
		  pst.setString(1, room_no);
		  rs  = pst.executeQuery();

			
		  while( rs.next()){
				
				getAnaesthetistdtl = new OT_Slate_Bean();
				getAnaesthetistdtl.setStrSurgeon(rs.getString("short_name1"));
				getAnaesthetistdtl.setRoleType(rs.getString("role_type"));
				getAnaesthetistdtl.setRoleTypeDescSysDef(rs.getString("role_type_desc_sysdef"));
				getAnaesthetist.add(getAnaesthetistdtl);
				
				}
			
			if(pst!=null) pst.close();
			if(rs!=null) rs.close();
			
		}
		catch (Exception e){
			System.err.println("Err From OT slate bean  "+e.getMessage());
			e.printStackTrace() ;
		}
		finally{
			try{
			if(pst!=null) pst.close();
			if(rs!=null) rs.close();
			//if(conn!=null) conn.close();
			closeConnection( conn );	//Common-ICN-0052
			}catch(Exception e){

				System.err.println("Err From OT slatebean1 "+e.getMessage());
			}
		}
		

		return getAnaesthetist;
	}  
	// start staff details
	public List<OT_Slate_Bean> getStaffDtls(String room_no){ 
		List<OT_Slate_Bean> getStaff = new ArrayList<OT_Slate_Bean>();
		OT_Slate_Bean getStaffdtl = null;
	Connection conn = null;
	PreparedStatement pst=null;
	ResultSet rs = null;
		
		
		try{

			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");

			conn = getConnection();
			
			//String query2="SELECT a.short_name short_name1 FROM am_practitioner a, ot_staff_assignment b, ot_roles c  WHERE  a.practitioner_id = b.staff_id AND b.role_id = c.role_id AND c.role_type != 'MA' AND SHOW_WIDGET_YN='Y' AND b.assignment_date = TO_CHAR (SYSDATE,'DD/MM/YYYY') and b.oper_room_code=? order by short_name1";
			String query2="SELECT a.short_name short_name1,d.role_type,d.ROLE_TYPE_DESC_SYSDEF FROM am_practitioner a, ot_staff_assignment b, ot_roles c, ot_role_type d WHERE a.practitioner_id = b.staff_id AND b.role_id = c.role_id AND c.role_type = d.role_type AND c.role_type in ('AS','NS') AND show_widget_yn = 'Y'  AND b.assignment_date = TO_CHAR (SYSDATE, 'DD/MM/YYYY')  AND b.oper_room_code = ? ORDER BY role_type_desc_sysdef,short_name";
			
		  pst = conn.prepareStatement(query2);
		  pst.setString(1, room_no);
		  rs  = pst.executeQuery();

		  while( rs.next()){
				
				getStaffdtl = new OT_Slate_Bean();
				getStaffdtl.setStrStaff(rs.getString("short_name1"));
				getStaffdtl.setRoleType(rs.getString("role_type"));
				getStaffdtl.setRoleTypeDescSysDef(rs.getString("role_type_desc_sysdef"));
				getStaff.add(getStaffdtl);
				
				}
			
			if(pst!=null) pst.close();
			if(rs!=null) rs.close();
			
		}
		catch (Exception e){
			System.err.println("Err From OT getStaffDtls1  "+e.getMessage());
			e.printStackTrace() ;
		}
		finally{
			try{
			if(pst!=null) pst.close();
			if(rs!=null) rs.close();
			//if(conn!=null) conn.close();
			closeConnection( conn );	//Common-ICN-0052	
			}catch(Exception e){

				System.err.println("Err From OT getStaffDtls "+e.getMessage());
			}
		}
		

		return getStaff;
	}  // staff details
	
	public ArrayList<OT_Slate_Bean> getBookingDtlsCount(String room_no)
	{
		//int rowCount = 0; //Common-ICN-0055
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        StringBuffer sql = new StringBuffer();
		//int index	= 1; //Common-ICN-0055
		OT_Slate_Bean otSlateBean = null;
		ArrayList<OT_Slate_Bean> dataList = new ArrayList<OT_Slate_Bean>();
		try{
			p = getProperties();
			locale = (String) p.getProperty("LOCALE");
			otSlateBean = new OT_Slate_Bean();

			connection = getConnection();

			pstmt = connection.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL");
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				sql_curr_date = resultSet.getString("CURRENT_DATE");
			}
			if (pstmt != null)
				pstmt.close();
			if (resultSet != null)
				resultSet.close();
			
			//sql = " SELECT  MIN (TO_CHAR (from_time, 'HH24:MI')) from_time, MAX (TO_CHAR (to_time, 'HH24:MI')) to_time, COUNT (a.patient_id) cnt FROM ot_booking_time_slots_vw a, ot_booking_hdr b, mp_patient m,ot_queue q,ot_display_mapping d, ot_booking_dtls e WHERE a.booking_num = b.booking_num(+) AND a.operating_facility_id = b.operating_facility_id(+) AND a.patient_id = m.patient_id(+) AND a.patient_id = q.patient_id(+) AND a.booking_num = q.appt_ref_num(+) and a.booking_num = e.booking_num (+) AND a.operating_facility_id = e.operating_facility_id(+) AND q.oper_status = d.status_code(+) AND q.operating_facility_id = d.operating_facility_id(+) AND a.operating_facility_id = ? AND a.oper_room_code = ? AND NVL (a.language_id, ?) = ? AND a.patient_id NOT LIKE '*%' AND a.booking_date = TO_DATE (?, 'DD/MM/YYYY')ORDER BY TO_DATE (TO_CHAR (from_time, 'HH24:MI'), 'HH24:MI') ";
//			sql = " SELECT MIN (from_time) from_time, MAX (to_time) to_time, SUM (bcnt) cnt FROM (SELECT   TO_CHAR (a.from_time, 'HH24:MI') from_time, TO_CHAR (a.to_time, 'HH24:MI') to_time, CASE WHEN a.booking_num = a.display_text THEN COUNT (a.booking_num) END bcnt FROM ot_booking_time_slots_vw a WHERE a.operating_facility_id = ? AND a.oper_room_code = ? AND NVL (a.language_id, ?) = ? AND a.booking_date = TO_DATE (?, 'DD/MM/YYYY') GROUP BY from_time, to_time, booking_num, a.display_text) ";
			sql.append(" SELECT MIN (TO_CHAR (a.from_time, 'HH24:MI')) from_time,	");
			sql.append(" MAX (TO_CHAR (a.to_time, 'HH24:MI')) to_time	");
			sql.append(" FROM ot_booking_time_slots_vw a	");
			sql.append(" WHERE a.operating_facility_id = ?	");
			sql.append(" AND a.oper_room_code = ?	");
			sql.append(" AND a.booking_date = TO_DATE (?, 'DD/MM/YYYY')	");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, room_no);
			pstmt.setString(3, sql_curr_date);
			resultSet = pstmt.executeQuery();
			
			while(resultSet!=null && resultSet.next())
			{
				otSlateBean.setStrFromTime(resultSet.getString("from_time"));
				otSlateBean.setStrToTime(resultSet.getString("to_time"));
				// dataList.add(otSlateBean);
			}
			
			sql.delete(0, sql.length());
			if (pstmt != null)
				pstmt.close();
			if (resultSet != null)
				resultSet.close();
			
			sql.append(" SELECT COUNT (patient_id)cnt	");
			sql.append(" FROM (SELECT   patient_id	");
			sql.append(" FROM ot_schd_opers_vw	");
			sql.append(" WHERE appt_date = TO_DATE (?, 'DD/MM/YYYY')	");
			sql.append(" AND booking_stage IN (	");
			sql.append(" SELECT stage_code	");
			sql.append(" FROM ot_booking_fin_stages	");
			sql.append(" WHERE serial_no IN (	");
			sql.append(" SELECT MAX (serial_no)	");
			sql.append(" FROM ot_booking_fin_stages))	");
			sql.append(" AND oper_status != '99'	");
			sql.append(" AND oper_room_code = ?	");
			sql.append(" and OPERATING_FACILITY_ID = ?	");
			sql.append(" GROUP BY patient_id, oper_num	");
			sql.append(" UNION ALL	");
			sql.append(" SELECT   patient_id	");
			sql.append(" FROM ot_unschd_opers_vw	");
			sql.append(" WHERE oper_date = TO_DATE (?, 'DD/MM/YYYY')	");
			sql.append(" AND oper_room_code = ?	");
			sql.append(" and OPERATING_FACILITY_ID = ?	");
			sql.append(" GROUP BY patient_id, oper_num)   	");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(1, sql_curr_date);
			pstmt.setString(2, room_no);
			pstmt.setString(3, login_facility_id);
			pstmt.setString(4, sql_curr_date);
			pstmt.setString(5, room_no);
			pstmt.setString(6, login_facility_id);
			resultSet = pstmt.executeQuery();

			while(resultSet!=null && resultSet.next())
			{
				otSlateBean.setTotalBookingCount(resultSet.getString("cnt"));
				dataList.add(otSlateBean);
			}
		}
		catch ( Exception e ) 
		{
            e.printStackTrace() ;
		}
		finally 
		{
            try
            {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }
            catch(Exception es)
            {
            	es.printStackTrace();
            }
        }
		return dataList;
	
	}
	
	
	public Map<String, List<OT_Slate_Bean>> getBookingDtls(String room_no, String from, String to) {

		List<OT_Slate_Bean> otSlateBeanList = new ArrayList<OT_Slate_Bean>();
		OT_Slate_Bean otSlateBean = null;
		Map<String, List<OT_Slate_Bean>> roomDetailsMap = new HashMap<String, List<OT_Slate_Bean>>();
		Connection connection = null;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		StringBuffer sql = new StringBuffer();
		List roomCodesList = null;
		int setIndex = 0;
		boolean isWidgetSelection =false;  //Added Against AAKH-SCF-0585
		try {

			p = getProperties();
			locale = (String) p.getProperty("LOCALE");
			roomCodesList = new ArrayList();

			connection = getConnection();
			      
			isWidgetSelection = CommonBean.isSiteSpecific(connection,"OT","OT_WIDGET_SELECTION");
			if(connection == null)
				return roomDetailsMap;

			pstmt = connection.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL");
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				sql_curr_date = resultSet.getString("CURRENT_DATE");
			}
			if (pstmt != null)
				pstmt.close();
			if (resultSet != null)
				resultSet.close();
/*			
 * 			pstmt = connection.prepareStatement("SELECT OT_ROOM_CODE1,OT_ROOM_CODE2,OT_ROOM_CODE3,STAFF_ASSIGN_YN from ot_widget_selection where FACILITY_ID = ? ");
			System.out.println("==============login_facility_id==========bean====="+login_facility_id);
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				strRoomCode = resultSet.getString("OT_ROOM_CODE1");
			}
			if (pstmt != null)
				pstmt.close();
			if (resultSet != null)
				resultSet.close();
*/			
//			String sql = " SELECT * FROM (SELECT ROWNUM rn, TO_CHAR (a.from_time, 'HH24:MI') from_time1, TO_CHAR (a.from_time, 'DD/MM/YYYY HH24:MI') from_time2, TO_CHAR (a.to_time, 'HH24:MI') to_time1, a.patient_id patient_id1, DECODE (a.language_id, 'en', a.patient_name, patient_loc_name ) patient_name1, get_desc (a.language_id, 'AM_PRACTITIONER_LANG_VW', 'SHORT_NAME', 'PRACTITIONER_ID', a.surgeon_code) surgeon_name, h.speciality_desc, a.speciality_code, a.booking_num booking_num1,f.SHORT_DESC oper_desc, a.oper_room_code, a.status, get_age (m.date_of_birth) age, m.sex,get_desc (a.language_id, 'AM_PRACTITIONER_LANG_VW', 'SHORT_NAME', 'PRACTITIONER_ID', b.asst_surgeon_code  ) asst_surgeon_desc, get_desc (a.language_id, 'AM_PRACTITIONER_LANG_VW', 'SHORT_NAME', 'PRACTITIONER_ID', b.asst_surgeon_code_2 ) asst_surgeon_desc_2,get_desc (a.language_id, 'IP_NURSING_UNIT_LANG_VW', 'SHORT_DESC','NURSING_UNIT_CODE', b.source_code ) short_desc,  nvl(d.display_status, h.STATUS_DESC) display_status, d.color_code, TO_CHAR (e.oper_durn, 'hh24:mi') oper_durn FROM ot_booking_time_slots_vw a, ot_booking_hdr b, mp_patient m,ot_queue q,ot_display_mapping d, ot_booking_dtls e, OT_OPER_MAST f ,ot_schd_opers_vw h WHERE a.booking_num = b.booking_num(+) AND a.operating_facility_id = b.operating_facility_id(+) AND a.patient_id = m.patient_id(+) AND a.patient_id = q.patient_id(+) AND a.booking_num = q.appt_ref_num(+) and a.booking_num = e.booking_num (+) AND a.operating_facility_id = e.operating_facility_id(+) AND e.oper_code = f.oper_code AND q.oper_status = d.status_code(+) and h.ORDER_ID = q.ORDER_ID AND q.operating_facility_id = d.operating_facility_id(+) AND a.operating_facility_id = ? AND a.oper_room_code = ? AND a.patient_id NOT LIKE '*%' AND NVL (a.language_id, ?) = ? AND NVL (h.language_id, ?) = ? AND a.booking_date = TO_DATE (?, 'DD/MM/YYYY')ORDER BY TO_DATE (TO_CHAR (from_time, 'HH24:MI'), 'HH24:MI')asc) WHERE rn BETWEEN ? AND ? ";
			sql.append(" select * from	");
			sql.append(" (SELECT   ROWNUM rn, casetype, oper_num, order_id, from_time1, from_time2,	");
			sql.append(" to_time1, oper_durn, patient_id, patient_name1, age, sex, short_desc,	");
			sql.append(" oper_code, short_desc1, surgeon_name, asst_surgeon_desc,	");
			sql.append(" asst_surgeon_desc_2, display_status, color_code, oper_status,	");
			sql.append(" booking_num, display_time, speciality_code, speciality_desc,	");
			sql.append(" oper_room_code	");
			if(isWidgetSelection)
			sql.append(" FROM (SELECT   1 casetype, LISTAGG (a.oper_num) WITHIN group( ORDER BY a.oper_room_code, a.patient_id) oper_num, a.order_id,	");
			else
			sql.append(" FROM (SELECT   1 casetype, wm_concat (a.oper_num) oper_num, a.order_id,	");
			sql.append(" TO_CHAR (a.appt_from_time, 'HH24:MI') from_time1,	");
			sql.append(" TO_CHAR (a.appt_date, 'DD/MM/YYYY') from_time2,	");
			sql.append(" TO_CHAR (a.appt_to_time, 'HH24:MI') to_time1,	");
			if(isWidgetSelection)
			sql.append(" LISTAGG (TO_CHAR (c.oper_durn, 'hh24:mi')) WITHIN group( ORDER BY c.booking_num,c.line_num) AS oper_durn,	");
			else
			sql.append(" wm_concat (TO_CHAR (c.oper_durn, 'hh24:mi')) AS oper_durn,	");
			sql.append(" a.patient_id patient_id,	");
			sql.append(" DECODE (?,	");
			sql.append(" ?, NVL (d.patient_name, d.patient_name_loc_lang),	");
			sql.append(" NVL (d.patient_name_loc_lang, d.patient_name)) patient_name1,	");
			sql.append(" get_age (d.date_of_birth) age, d.sex,	");
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'IP_NURSING_UNIT_LANG_VW',	");
			sql.append(" 'SHORT_DESC',	");
			sql.append(" 'NURSING_UNIT_CODE',	");
			sql.append(" b.source_code) short_desc,	");
			if(isWidgetSelection)
			{
			sql.append(" LISTAGG (f.oper_code) WITHIN group( ORDER BY f.OPER_CODE) AS oper_code,	");
			sql.append(" LISTAGG (f.long_desc) WITHIN group( ORDER BY f.OPER_CODE) AS short_desc1,	");//MMS-QH-CRF-0199
			}
			else
			{
			sql.append(" wm_concat (f.oper_code) AS oper_code,	");
			sql.append(" wm_concat (f.long_desc) AS short_desc1,	");//MMS-QH-CRF-0199
			}
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'AM_PRACTITIONER_LANG_VW',	");
			sql.append(" 'SHORT_NAME',	");
			sql.append(" 'PRACTITIONER_ID',	");
			sql.append(" a.surgeon_code) surgeon_name,	");
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'AM_PRACTITIONER_LANG_VW',	");
			sql.append(" 'SHORT_NAME',	");
			sql.append(" 'PRACTITIONER_ID',	");
			sql.append(" b.asst_surgeon_code) asst_surgeon_desc,	");
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'AM_PRACTITIONER_LANG_VW',	");
			sql.append(" 'SHORT_NAME',	");
			sql.append(" 'PRACTITIONER_ID',	");
			sql.append(" b.asst_surgeon_code_2) asst_surgeon_desc_2,	");
			sql.append(" a.status_desc display_status, a.color_ind color_code,	");
			sql.append(" a.oper_status, b.booking_num,	");
			sql.append(" CASE	");
			sql.append(" WHEN a.oper_status = 10	");
			sql.append(" THEN NULL	");
			sql.append(" WHEN a.oper_status = 25	");
			sql.append(" THEN NULL	");
			sql.append(" WHEN a.oper_status = 30	");
			sql.append(" THEN TO_CHAR (a.case_called_time,	");
			sql.append(" 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 35	");
			sql.append(" THEN NULL	");
			sql.append(" WHEN a.oper_status = 40	");
			sql.append(" THEN TO_CHAR (g.check_in_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 45	");
			sql.append(" THEN TO_CHAR (g.check_into_holding_area_time,	");
			sql.append(" 'HH24:MI' )	");
			sql.append(" WHEN a.oper_status = 50	");
			sql.append(" THEN TO_CHAR (g.check_into_or_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 55	");
			sql.append(" THEN TO_CHAR (g.recovery_start_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 60	");
			sql.append(" THEN NULL	");
			sql.append(" WHEN a.oper_status = 65	");
			sql.append(" THEN TO_CHAR (g.check_out_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 70	");
			sql.append(" THEN TO_CHAR (g.check_out_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 99	");
			sql.append(" THEN TO_CHAR (g.cancellation_date_time, 'HH24:MI')	");
			sql.append(" END display_time,	");
			sql.append(" a.speciality_code, a.speciality_desc, a.oper_room_code	");
			sql.append(" FROM ot_schd_opers_vw a,	");
			sql.append(" ot_booking_hdr b,	");
			sql.append(" ot_booking_dtls c,	");
			sql.append(" mp_patient d,	");
			sql.append(" ot_oper_mast f,	");
			sql.append(" ot_post_oper_hdr g	");
			sql.append(" WHERE a.operating_facility_id = ?	");
			sql.append(" AND a.operating_facility_id = b.operating_facility_id	");
			sql.append(" AND a.operating_facility_id = g.operating_facility_id(+) ");
			sql.append(" AND a.appt_ref_num = b.booking_num	");
			sql.append(" AND a.operating_facility_id = c.operating_facility_id	");
			sql.append(" AND a.appt_ref_num = c.booking_num	");
			sql.append(" AND a.patient_id = d.patient_id	");
			sql.append(" AND c.oper_code = f.oper_code	");
			sql.append(" AND a.oper_num = g.oper_num(+)	");
			sql.append(" AND a.appt_date = TO_DATE (?, 'dd/mm/yyyy')	");
			if(from != null && from.trim().length() > 0 && to != null && to.trim().length() > 0)
			sql.append(" AND a.oper_room_code = ?	");
			else
				sql.append(" AND a.oper_room_code in ("+room_no+")	");
			sql.append(" AND a.booking_stage IN (	");
			sql.append(" SELECT stage_code	");
			sql.append(" FROM ot_booking_fin_stages	");
			sql.append(" WHERE serial_no IN (	");
			sql.append(" SELECT MAX (serial_no)	");
			sql.append(" FROM ot_booking_fin_stages))	");
			sql.append(" AND a.language_id = ?	");
			sql.append(" GROUP BY a.appt_from_time, a.appt_to_time,	");
			sql.append(" a.patient_id, a.order_id, a.appt_date, a.language_id, a.surgeon_code, a.speciality_code, a.speciality_desc,	");
			sql.append(" a.case_called_time, a.status_desc, a.color_ind, a.oper_status, b.source_code, b.booking_num,  b.asst_surgeon_code,	");
			sql.append(" b.asst_surgeon_code_2, d.patient_name, d.patient_name_loc_lang, d.date_of_birth, d.sex, g.register_date_time, g.cancellation_date_time,	");
			sql.append(" g.check_into_or_time, g.check_in_time, g.check_into_holding_area_time, g.check_into_or_time, g.recovery_start_time, g.trfr_date_time,	");
			sql.append(" g.check_out_time, g.check_out_time, g.cancellation_date_time, a.oper_room_code	");
			sql.append(" UNION ALL	");
			if(isWidgetSelection)
			sql.append(" SELECT   0 casetype, LISTAGG (a.oper_num) WITHIN group( ORDER BY a.oper_room_code, a.patient_id) oper_num, a.order_id,	");
			else
			sql.append(" SELECT   0 casetype, wm_concat (a.oper_num) oper_num, a.order_id,	");
			sql.append(" '23:59' from_time1,	");
			sql.append(" TO_CHAR (a.oper_date, 'DD/MM/YYYY') from_time2,	");
			sql.append(" NULL to_time1,	");
			if(isWidgetSelection)
			sql.append(" LISTAGG (TO_CHAR (i.appt_time, 'HH24:MI')) WITHIN group( ORDER BY a.oper_room_code, a.patient_id) AS oper_durn,	");
			else
			sql.append(" wm_concat (TO_CHAR (i.appt_time, 'HH24:MI')) AS oper_durn,	");
			sql.append(" a.patient_id patient_id,	");
			sql.append(" DECODE (?, ?, NVL (d.patient_name, d.patient_name_loc_lang),	");
			sql.append(" NVL (d.patient_name_loc_lang, d.patient_name)	");
			sql.append(" ) patient_name1,	");
			sql.append(" get_age (d.date_of_birth) age, d.sex,	");
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'IP_NURSING_UNIT_LANG_VW',	");
			sql.append(" 'SHORT_DESC',	");
			sql.append(" 'NURSING_UNIT_CODE',	");
			sql.append(" g.ref_source_code) short_desc,	");
			if(isWidgetSelection)
			{
			sql.append(" LISTAGG (f.oper_code) WITHIN group( ORDER BY f.OPER_CODE) AS oper_code,	");
			sql.append(" LISTAGG (f.long_desc) WITHIN group( ORDER BY f.OPER_CODE) AS short_desc1,	");//MMS-QH-CRF-0199
			}
			else{
			sql.append(" wm_concat (f.oper_code) AS oper_code,	");
			sql.append(" wm_concat (f.long_desc) AS short_desc1,	");//MMS-QH-CRF-0199
			}
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'AM_PRACTITIONER_LANG_VW',	");
			sql.append(" 'SHORT_NAME',	");
			sql.append(" 'PRACTITIONER_ID',	");
			sql.append(" a.surgeon_code) surgeon_name,	");
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'AM_PRACTITIONER_LANG_VW',	");
			sql.append(" 'SHORT_NAME',	");
			sql.append(" 'PRACTITIONER_ID',	");
			sql.append(" g.asst_surgeon_code) asst_surgeon_desc,	");
			sql.append(" get_desc (a.language_id,	");
			sql.append(" 'AM_PRACTITIONER_LANG_VW',	");
			sql.append(" 'SHORT_NAME',	");
			sql.append(" 'PRACTITIONER_ID',	");
			sql.append(" g.asst_surgeon_code_2) asst_surgeon_desc_2,	");
			sql.append(" a.status_desc display_status, a.color_ind color_code,	");
			sql.append(" a.oper_status, g.booking_num,	");
			sql.append(" CASE	");
			sql.append(" WHEN a.oper_status = 10	");
			sql.append(" THEN NULL	");
			sql.append(" WHEN a.oper_status = 25	");
			sql.append(" THEN NULL	");
			sql.append(" WHEN a.oper_status = 30	");
			sql.append(" THEN TO_CHAR (a.case_called_time,	");
			sql.append(" 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 35	");
			sql.append(" THEN NULL	");
			sql.append(" WHEN a.oper_status = 40	");
			sql.append(" THEN TO_CHAR (g.check_in_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 45	");
			sql.append(" THEN TO_CHAR (g.check_into_holding_area_time,	");
			sql.append(" 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 50	");
			sql.append(" THEN TO_CHAR (g.check_into_or_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 55	");
			sql.append(" THEN TO_CHAR (g.recovery_start_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 60	");
			sql.append(" THEN TO_CHAR (g.trfr_date_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 65	");
			sql.append(" THEN TO_CHAR (g.check_out_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 70	");
			sql.append(" THEN TO_CHAR (g.check_out_time, 'HH24:MI')	");
			sql.append(" WHEN a.oper_status = 99	");
			sql.append(" THEN TO_CHAR (g.cancellation_date_time, 'HH24:MI')	");
			sql.append(" END display_time,	");
			sql.append(" a.speciality_code, a.speciality_desc, a.oper_room_code	");
			sql.append(" FROM ot_unschd_opers_vw a,	");
			sql.append(" mp_patient d,	");
			sql.append(" ot_oper_mast f,	");
			sql.append(" ot_post_oper_hdr g,	");
			sql.append(" ot_post_oper_dtls h,	");
			sql.append(" or_order_catalog i	");
			sql.append(" WHERE a.operating_facility_id = ?	");
			sql.append(" AND a.operating_facility_id = g.operating_facility_id	");
			sql.append(" AND a.oper_num = g.oper_num	");
			sql.append(" AND a.operating_facility_id = h.operating_facility_id	");
			sql.append(" AND a.oper_num = h.oper_num	");
			sql.append(" AND a.patient_id = d.patient_id	");
			sql.append(" AND h.oper_code = f.oper_code	");
			sql.append(" AND f.order_catalog_code = i.order_catalog_code	");
			sql.append(" AND a.oper_date = TO_DATE (?, 'dd/mm/yyyy')	");
			if(from != null && from.trim().length() > 0 && to != null && to.trim().length() > 0)
			sql.append(" AND a.oper_room_code = ?	");
			else
				sql.append(" AND a.oper_room_code in ("+room_no+")	");
			sql.append(" AND a.language_id = ?	");
			sql.append(" GROUP BY a.patient_id, a.order_id, a.oper_date, a.language_id, a.surgeon_code, a.speciality_code, a.speciality_desc,	");
			sql.append(" a.case_called_time, a.status_desc, a.color_ind, a.oper_status, g.ref_source_code, g.booking_num, g.asst_surgeon_code, g.asst_surgeon_code_2,	");
			sql.append(" d.patient_name, d.patient_name_loc_lang, d.date_of_birth, d.sex, g.register_date_time, g.cancellation_date_time, g.check_into_or_time,	");
			sql.append(" g.check_in_time, g.check_into_holding_area_time, g.check_into_or_time, g.recovery_start_time, g.trfr_date_time, g.check_out_time, 	");
			sql.append(" g.check_out_time, g.cancellation_date_time, a.oper_room_code)	");
			sql.append(" ORDER BY oper_room_code, from_time1 asc, patient_id)	");
			if(from != null && from.trim().length() > 0 && to != null && to.trim().length() > 0)
			sql.append(" where rn between ? and ?	");
			pstmt = connection.prepareStatement(sql.toString());
			pstmt.setString(++setIndex, locale);
			pstmt.setString(++setIndex, locale);
			pstmt.setString(++setIndex, login_facility_id);
			pstmt.setString(++setIndex, sql_curr_date);
			if(from != null && from.trim().length() > 0 && to != null && to.trim().length() > 0)
				pstmt.setString(++setIndex, room_no);
			pstmt.setString(++setIndex, locale);
			pstmt.setString(++setIndex, locale);
			pstmt.setString(++setIndex, locale);
			pstmt.setString(++setIndex, login_facility_id);
			pstmt.setString(++setIndex, sql_curr_date);
			if(from != null && from.trim().length() > 0 && to != null && to.trim().length() > 0)
				pstmt.setString(++setIndex, room_no);
			pstmt.setString(++setIndex, locale);
			if(from != null && from.trim().length() > 0 && to != null && to.trim().length() > 0)
			{
				pstmt.setString(++setIndex, from);
				pstmt.setString(++setIndex, to);
			}
			System.out.println("sql in 608, Ot Slate Bean : "+sql.toString());
			
			
			resultSet = pstmt.executeQuery();
			fetchCount = 0;
			while (resultSet.next()) {
				String patientID = resultSet.getString("PATIENT_ID");
				if(patientID == null || patientID.equals(""))
				{
					continue;
				}
				otSlateBean = new OT_Slate_Bean();
				otSlateBean.setStrPatientID(resultSet.getString("PATIENT_ID"));
				otSlateBean.setStrFromTime(resultSet.getString("FROM_TIME1"));
				otSlateBean.setStrToTime(resultSet.getString("TO_TIME1"));
				otSlateBean.setStrPatietName(resultSet.getString("PATIENT_NAME1"));
				otSlateBean.setStrSpltycodedesc(resultSet.getString("SPECIALITY_DESC"));
				otSlateBean.setStrOperDesc(resultSet.getString("short_desc1"));
				otSlateBean.setStrSurgeonName(resultSet.getString("SURGEON_NAME"));
				otSlateBean.setStrOperRoomCode(resultSet.getString("OPER_ROOM_CODE"));
				otSlateBean.setStrAge(resultSet.getString("AGE"));
				otSlateBean.setStrGender(resultSet.getString("SEX"));
				otSlateBean.setStrAsstSurgeonOne(resultSet.getString("asst_surgeon_desc"));
				otSlateBean.setStrAsstSurgeonTwo(resultSet.getString("asst_surgeon_desc_2"));
				otSlateBean.setStrShortDesc(resultSet.getString("short_desc"));
				otSlateBean.setStrDisplayStatus(resultSet.getString("display_status"));
				otSlateBean.setStrColorCode(resultSet.getString("color_code"));
				otSlateBean.setStrOperNum(resultSet.getString("oper_durn"));
				otSlateBean.setStrDisplayTime(resultSet.getString("display_time"));
				otSlateBean.setCaseType(resultSet.getString("CASETYPE"));
				otSlateBeanList.add(otSlateBean);
				if(!roomCodesList.contains(otSlateBean.getStrOperRoomCode()))
					roomCodesList.add(otSlateBean.getStrOperRoomCode());
				roomDetailsMap.put("ROOMDETAILS", otSlateBeanList);
				roomDetailsMap.put("ROOMCODES", roomCodesList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null)
					closeConnection( connection );	//Common-ICN-0052
					//connection.close();

			} catch (Exception e) {
				System.err.println("Err From OT_Slate_Bean===== " + e.getMessage());
				e.printStackTrace();
			}
		}

		return roomDetailsMap;
	}
	
	public String getStrRoomCode() {
		return strRoomCode;
	}
	public void setStrRoomCode(String strRoomCode) {
		this.strRoomCode = strRoomCode;
	}
	public String getStrFromTime() {
		return strFromTime;
	}
	public void setStrFromTime(String strFromTime) {
		this.strFromTime = strFromTime;
	}
	public String getStrFromHiddenTime() {
		return strFromHiddenTime;
	}
	public void setStrFromHiddenTime(String strFromHiddenTime) {
		this.strFromHiddenTime = strFromHiddenTime;
	}
	public String getStrToTime() {
		return strToTime;
	}
	public void setStrToTime(String strToTime) {
		this.strToTime = strToTime;
	}
	public String getStrPatientID() {
		return strPatientID;
	}
	public void setStrPatientID(String strPatientID) {
		this.strPatientID = strPatientID;
	}
	public String getStrPatientName() {
		return strPatientName;
	}
	public void setStrPatietName(String strPatientName) {
		this.strPatientName = strPatientName;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrOperDesc() {
		return strOperDesc;
	}
	public void setStrOperDesc(String strOperDesc) {
		this.strOperDesc = strOperDesc;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	public String getStrSpltycode() {
		return strSpltycode;
	}
	public void setStrSpltycode(String strSpltycode) {
		this.strSpltycode = strSpltycode;
	}
	public String getStrSpltycodedesc() {
		return strSpltycodedesc;
	}
	public void setStrSpltycodedesc(String strSpltycodedesc) {
		this.strSpltycodedesc = strSpltycodedesc;
	}
	
	public String getStrOperRoomCode() {
		return strOperRoomCode;
	}
	public void setStrOperRoomCode(String strOperRoomCode) {
		this.strOperRoomCode = strOperRoomCode;
	}
	public String getStrSurgeonName() {
		return strSurgeonName;
	}
	public void setStrSurgeonName(String strSurgeonName) {
		this.strSurgeonName = strSurgeonName;
	}
	public String getStrAge() {
		return strAge;
	}
	public void setStrAge(String strAge) {
		this.strAge = strAge;
	}
	public String getStrGender() {
		return strGender;
	}
	public void setStrGender(String strGender) {
		this.strGender = strGender;
	}
	public String getStrAsstSurgeonOne() {
		return strAsstSurgeonOne;
	}
	public void setStrAsstSurgeonOne(String strAsstSurgeonOne) {
		this.strAsstSurgeonOne = strAsstSurgeonOne;
	}
	public String getStrAsstSurgeonTwo() {
		return strAsstSurgeonTwo;
	}
	public void setStrAsstSurgeonTwo(String strAsstSurgeonTwo) {
		this.strAsstSurgeonTwo = strAsstSurgeonTwo;
	}
	public String getStrShortDesc() {
		return strShortDesc;
	}
	public void setStrShortDesc(String strShortDesc) {
		this.strShortDesc = strShortDesc;
	}
	public String getStrDisplayStatus() {
		return strDisplayStatus;
	}
	public void setStrDisplayStatus(String strDisplayStatus) {
		this.strDisplayStatus = strDisplayStatus;
	}
	public String getStrColorCode() {
		return strColorCode;
	}
	public void setStrColorCode(String strColorCode) {
		this.strColorCode = strColorCode;
	}
	public String getStrOperNum() {
		return strOperNum;
	}
	public void setStrOperNum(String strOperNum) {
		this.strOperNum = strOperNum;
	}
	public String getStrDisplayTime() {
		return strDisplayTime;
	}
	public void setStrDisplayTime(String strDisplayTime) {
		this.strDisplayTime = strDisplayTime;
	}
	public void setStrPatientName(String strPatientName) {
		this.strPatientName = strPatientName;
	}
	
	
}
