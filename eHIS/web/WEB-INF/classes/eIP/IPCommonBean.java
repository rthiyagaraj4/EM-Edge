/*Created by Thamizh selvi on 8th May 2017 against ML-MMOH-CRF-0617*/
package eIP;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

public class IPCommonBean implements Serializable{
	
	public static String getAutoCnrmTfrReqParam(Connection con, String facilityId) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String autoCnrmTfrReqYn	= "";

		try{
			String sql = "select auto_confirm_tfr_req_yn from ip_param where facility_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				autoCnrmTfrReqYn		= checkForDefault(rs.getString("auto_confirm_tfr_req_yn"),"N");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAutoCnrmTfrReqParam - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return autoCnrmTfrReqYn;
	
	}//End of getAutoCnrmTfrReqParam 

	public static JSONArray getTransportMode(Connection con) throws Exception{
		Statement stmt					= null;
		ResultSet rs 					= null;
		String transportMode			= "";
		String transportDesc			= "";
		JSONArray transportModeJSONArr	= new JSONArray();

		try{
			String sql = "select transport_mode, short_desc from am_transport_mode where ip_tfr_pat_out_yn = 'Y' and eff_status ='E'";
			
			stmt= con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){

				JSONObject transportModejsonObj	= new JSONObject();

				transportMode		= checkForNull(rs.getString("transport_mode"));
				transportDesc		= checkForNull(rs.getString("short_desc"));
				
				transportModejsonObj.put("transportMode",transportMode);
				transportModejsonObj.put("transportDesc",transportDesc);

				transportModeJSONArr.add(transportModejsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTransportMode - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return transportModeJSONArr;
	
	}//End of getTransportMode 

	//Added by Sangeetha for GDOH-CRF-0151
	public static String isVacantBedAvailable(Connection con, String facilityId, String bed_no, String nursing_unit_code, String Bedcode, String bed_type) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String vacant_yn	= "";

		try{
			String sql = "select ip_check_vacant_bed(?,?,?,?,?) vacant_yn FROM DUAL";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,nursing_unit_code);
			pstmt.setString(2,bed_no);
			pstmt.setString(3,facilityId);
			pstmt.setString(4,Bedcode);
			pstmt.setString(5,bed_type);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				vacant_yn		= checkForNull(rs.getString("vacant_yn"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in isVacantBedAvailable - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		System.err.println("vacant_yn-->"+vacant_yn);
		return vacant_yn;
	
	}
	//Below line added for this CRF ML-MMOH-CRF-0566
	public static String getFromuserId(Connection con, String frmpractId){
	    PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String userId= "";

		try{
			String sql = "select appl_user_id from sm_appl_user where func_role_id='"+frmpractId+"'";	
			
			pstmt= con.prepareStatement(sql);			
			rs	= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				userId	= checkForNull(rs.getString("appl_user_id"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFromuserId - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
	    
		return userId;
	}
	public static String getTouserId(Connection con, String topractId){
	    PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String userId= "";

		try{
			String sql = "select appl_user_id from sm_appl_user where func_role_id='"+topractId+"'";
			pstmt= con.prepareStatement(sql);			
			rs	= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				userId	= checkForNull(rs.getString("appl_user_id"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTouserId - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
	    
		return userId;
	}
	//End this CRF ML-MMOH-CRF-0566
	//Below line added for ML-MMOH-CRF-0566 US3
	public static String getCancelRejectReason(Connection con, String reason_code){
	    PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String reasondesc= "";

		try{
			String sql = "select contact_reason from am_contact_reason where contact_reason_code='"+reason_code+"'";
			pstmt= con.prepareStatement(sql);			
			rs	= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				reasondesc	= checkForNull(rs.getString("contact_reason"));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCancelRejectReason - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
	    
		return reasondesc;
	}

//End ML-MMOH-CRF-0566 US3
	
	/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
	public static JSONObject getIPParam(Connection con, String facilityId) throws Exception{

		PreparedStatement pstmt			= null;
		ResultSet rs 					= null;
		JSONObject jsonObj				= new JSONObject();
		String dispBedClsChangeAuthYn	= "";
		String allow_modify_disc_yn     = ""; // added by mujafar for ML-MMOH-CRF-0659

		try{
			String sql = " select disp_bed_cls_change_auth_yn,ALLOW_USER_MODIFY_DISC_YN from ip_param where facility_id='"+facilityId+"' "; // modified by mujafar for ML-MMOH-CRF-0659
			
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				dispBedClsChangeAuthYn	= checkForDefault(rs.getString("disp_bed_cls_change_auth_yn"),"N");
				allow_modify_disc_yn    = rs.getString("ALLOW_USER_MODIFY_DISC_YN"); // added by mujafar for ML-MMOH-CRF-0659
			}
			
			jsonObj.put("dispBedClsChangeAuthYn",dispBedClsChangeAuthYn);
			jsonObj.put("allow_modify_disc_yn",allow_modify_disc_yn); // added by mujafar for ML-MMOH-CRF-0659

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getIPParam - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}/*End*/

	/*Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779*/
	public static JSONObject getAdmissionForm(Connection con, String admission_form_code, String locale) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();

		try{
			String sql = "select admission_form_code,long_desc,short_desc,specialty_code,am_get_desc.am_speciality(specialty_code,'"+locale+"',2) specialty, by_default, eff_status from IP_ADMISSION_FORM where admission_form_code='"+admission_form_code+"'";
			
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				
				String admission_form_cd = rs.getString("admission_form_code")==null?"":rs.getString("admission_form_code");
				String long_desc		= rs.getString("long_desc")==null?"":rs.getString("long_desc");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				String speciality_code	= rs.getString("specialty_code")==null?"":rs.getString("specialty_code");
				String specialty		= rs.getString("specialty")==null?"":rs.getString("specialty");
				String by_default		= rs.getString("by_default")==null?"":rs.getString("by_default");
				String eff_status		= rs.getString("eff_status")==null?"":rs.getString("eff_status");
				jsonObj.put("admission_form_code",admission_form_cd);
				jsonObj.put("long_desc",long_desc);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("speciality_code",speciality_code);
				jsonObj.put("specialty",specialty);
				jsonObj.put("by_default",by_default);
				jsonObj.put("eff_status",eff_status);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAdmissionForm - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static String getPsychiatryForm(Connection con, String splCode) throws Exception{
		PreparedStatement pstmt			= null;
		ResultSet rs 					= null;
		String admissionFormCode		= "";
		String shortDesc				= "";
		String byDefault				= "";
		String returnStr				= "";
		int	count						= 0;
		JSONArray psychiatryFormJSONArr	= new JSONArray();
		
		try{
			String sql = "select admission_form_code, short_desc, by_default from ip_admission_form where specialty_code ='"+splCode+"' and eff_status ='E' order by short_desc asc";
			
			pstmt= con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){

				JSONObject psychiatryFormjsonObj	= new JSONObject();

				admissionFormCode		= checkForNull(rs.getString("admission_form_code"));
				shortDesc				= checkForNull(rs.getString("short_desc"));
				byDefault				= checkForNull(rs.getString("by_default"));
				
				if(byDefault.equals("Y") && count < 10)
				{
					count++;
				}else
				{
					byDefault = "N";
				}

				psychiatryFormjsonObj.put("admissionFormCode",admissionFormCode);
				psychiatryFormjsonObj.put("shortDesc",shortDesc);
				psychiatryFormjsonObj.put("byDefault",byDefault);
				psychiatryFormJSONArr.add(psychiatryFormjsonObj);

				returnStr = psychiatryFormJSONArr.toString();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPsychiatryForm - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return returnStr;
	}
	/*End ML-MMOH-CRF-0779*/
	
	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	public static JSONObject getAadharCardAndRel(Connection con, String patient_id) throws Exception{

		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject jsonObj			= new JSONObject();
		String citizen_yn			= "";
		String aadhar_card_no		= "";

		try{
			String sql = " SELECT citizen_yn, alt_id4_no FROM mp_patient WHERE patient_id = '"+patient_id+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				citizen_yn		= checkForDefault(rs.getString("citizen_yn"),"N");
				aadhar_card_no	= checkForNull(rs.getString("alt_id4_no"));
			}
			
			jsonObj.put("citizen_yn",citizen_yn);
			jsonObj.put("aadhar_card_no",aadhar_card_no);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAadharCardAndRel - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONObject getAltIdLengthAndType(Connection con) throws Exception{

		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject jsonObj			= new JSONObject();
		String alt_id4_length		= "";
		String alt_id4_alphanum_yn	= "";
		String alt_id4_type_desc	= "";
		String alt_id4_type			= "";

		try{
			String sql = " SELECT a.alt_id4_length, a.alt_id4_accept_alphanumeric_yn, a.alt_id4_type, b.long_desc long_desc FROM mp_param a, mp_alternate_id_type b WHERE b.alt_id_type = a.alt_id4_type ";
			
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				alt_id4_length			= checkForNull(rs.getString("alt_id4_length"));
				alt_id4_alphanum_yn		= checkForNull(rs.getString("alt_id4_accept_alphanumeric_yn"));
				alt_id4_type_desc		= checkForNull(rs.getString("long_desc"));
				alt_id4_type			= checkForNull(rs.getString("alt_id4_type"));
			}
			
			jsonObj.put("alt_id4_length",alt_id4_length);
			jsonObj.put("alt_id4_alphanum_yn",alt_id4_alphanum_yn);
			jsonObj.put("alt_id4_type_desc",alt_id4_type_desc);	
			jsonObj.put("alt_id4_type",alt_id4_type);	

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAltIdLengthAndType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	public static int getAltIdNo4Cnt(Connection con, String alt_id4_no) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt						= 0;

		try{
			sql	= "SELECT COUNT (*) alt_id4_no_cnt FROM mp_patient WHERE alt_id4_no = '"+alt_id4_no+"'";

			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt	= rs.getInt("alt_id4_no_cnt");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAltIdNo4Cnt method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}
	/*End GHL-CRF-0505*/
	
		// added by mujafar for ML-MMOH-CRF-0659 START
	public static JSONObject getPatientDetails(Connection con, String locale,String patient_id) throws Exception
	{
		Statement stmt 	= con.createStatement();
		Statement stmt1 	= con.createStatement();
		ResultSet rs    = null;
		ResultSet rs1   = null;
		int count =0;
		int patient_age = 0;
		JSONObject jsonObj			= new JSONObject();
		String language_direction="";
		
		try{
		   rs = stmt.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ;
		   rs1= stmt1.executeQuery("select calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1) patient_age from mp_patient where patient_id='"+patient_id+"'");
			
			 if ( rs != null && rs.next() ) 
			 {
			 count = rs.getInt("total");
			 }
			 if(rs1 != null && rs1.next())
			 {
				 
				patient_age = Integer.parseInt(rs1.getString("patient_age"));;
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			
			jsonObj.put("patient_age",patient_age); 
			jsonObj.put("language_direction",language_direction);
			
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			
			}
			catch(Exception e)
		{
			System.err.println("Exception in getting getPatientDetails : - "+e.getMessage());
			e.printStackTrace();
		}
		
		
		return jsonObj;
		
		
	}
	

	
	public static JSONArray getDischargeTypes(Connection con, String locale,String indicator ) throws Exception
	
	{
		Statement stmt 	= con.createStatement();
		ResultSet rs    = null;
		StringBuffer dischgtype_Sql	=new StringBuffer();
		String disCode="";
		String disCode1="";
		String disDesc="";	
		
		dischgtype_Sql.append("SELECT deceased_yn, discharge_type_code||'='||indicator  discharge_type_code,discharge_type_code discharge_type_code1 , short_desc from "); 
		dischgtype_Sql.append(" IP_DISCHARGE_TYPE_LANG_VW where language_id = '"+locale+"' and eff_status='E' ");
		if(indicator.equals("DS"))
			dischgtype_Sql.append(" and  indicator  in('DS')  order by short_desc ");
		else
			dischgtype_Sql.append(" and indicator not in('DS')  order by short_desc ");
		
		JSONArray DischargeTypeArray	= new JSONArray();
		
		try
		{
     	if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		stmt = con.createStatement();
		rs= stmt.executeQuery(dischgtype_Sql.toString());
		if(rs!= null)
		{
			while(rs.next())
			{
				disCode = checkForNull(rs.getString("discharge_type_code"));
				disCode1= checkForNull(rs.getString("discharge_type_code1"));
				disDesc = checkForNull(rs.getString("short_desc"));
				JSONObject jsonObj			= new JSONObject();
				
				jsonObj.put("disCode",disCode);
				jsonObj.put("disCode1",disCode1);
				jsonObj.put("disDesc",disDesc);
				DischargeTypeArray.add(jsonObj);
			}
			
			
		}
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		return DischargeTypeArray;
		
		
		
		
		
		
		
	}
	
	
	public static JSONArray getDischargeStatus(Connection con, String locale,String discharge_status_code) throws Exception
	
	{
		Statement stmt 	= con.createStatement();
		ResultSet rs    = null;
		StringBuffer dischgtype_Sql	=new StringBuffer();
		String StatusCode="";
		String StatusDesc="";	
		
		dischgtype_Sql.append("select discharge_status_code,short_desc from IP_DISCHARGE_STATUS_LANG_VW where  language_id='"+locale+"' and eff_status='E' and discharge_status_code='"+discharge_status_code+"' "); 
		
		
		JSONArray DischargeStatusArray	= new JSONArray();
		
		try
		{
     	if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		stmt = con.createStatement();
		rs= stmt.executeQuery(dischgtype_Sql.toString());
		if(rs!= null)
		{
			while(rs.next())
			{
				
				StatusCode = checkForNull(rs.getString("discharge_status_code"));
				StatusDesc = checkForNull(rs.getString("short_desc"));
				
				JSONObject jsonObj			= new JSONObject();
				jsonObj.put("StatusCode",StatusCode);
				jsonObj.put("StatusDesc",StatusDesc);
				
				DischargeStatusArray.add(jsonObj);
			}
			
			
		}
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		return DischargeStatusArray;
		
	
	}
	
	
	public static JSONArray getDischargeStatus_all(Connection con, String locale,String indicator) throws Exception
	
	{
		Statement stmt 	= con.createStatement();
		ResultSet rs    = null;
		StringBuffer dischgtype_Sql	=new StringBuffer();
		String code="";
		String desc="";	
		
		if(indicator.equals("DS"))
		dischgtype_Sql.append("select discharge_status_code , long_desc,short_desc, discharge_status_ind from IP_DISCHARGE_STATUS_LANG_VW where language_id='"+locale+"' and eff_status='E' and  discharge_status_ind = 'D' order by short_desc"); 
		else
		dischgtype_Sql.append("select discharge_status_code , long_desc,short_desc, discharge_status_ind from IP_DISCHARGE_STATUS_LANG_VW where language_id='"+locale+"' and eff_status='E' and  discharge_status_ind in ('C','P','S','W') order by short_desc");
		
		
		JSONArray DischargeStatus_all_Array	= new JSONArray();
		
		try
		{
     	if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		stmt = con.createStatement();
		rs= stmt.executeQuery(dischgtype_Sql.toString());
		if(rs!= null)
		{
			while(rs.next())
			{
				
				code = checkForNull(rs.getString("discharge_status_code"));
				desc = checkForNull(rs.getString("short_desc"));
				
				JSONObject jsonObj			= new JSONObject();
				jsonObj.put("code",code);
				jsonObj.put("desc",desc);
				
				DischargeStatus_all_Array.add(jsonObj);
			}
			
			
		}
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		return DischargeStatus_all_Array;
		
	
	}
	// added by mujafar for ML-MMOH-CRF-0659 END
	//Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050 starts--
	public static String getGender(Connection con, String patient_id) throws Exception{
		PreparedStatement pstmt			= null;
		ResultSet rs 					= null;
		String gender		= "";
		
		
		try{
			String sql = "select sex from mp_patient where patient_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs	= pstmt.executeQuery();

			while(rs.next())
		{
			
			gender = checkForNull(rs.getString("sex"));
			
		}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPsychiatryForm - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return gender;
	}
public static String getDelivaryDate(Connection con, String patient_id) throws Exception{
		PreparedStatement pstmt			= null;
		ResultSet rs 					= null;
		String delivaryDate		= "";
		
		
		try{
			//String sql = "select  to_char(a.time_of_birth,'dd/mm/rrrr hh24:mi')time_of_birth from mp_patient b, mp_birth_register a where b.patient_id=? and a.mother_patient_id=b.patient_id order by time_of_birth desc";
			
			String sql = "select  to_char(a.time_of_birth,'dd/mm/rrrr hh24:mi')time_of_birth from mp_patient b, mp_birth_register a, ip_open_encounter c where b.patient_id=? and a.mother_patient_id=b.patient_id and a.mother_encounter_id=c.encounter_id order by time_of_birth desc"; //Modified by Suji Keerthi for ML-MMOH-SCF-1912

			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs	= pstmt.executeQuery();

			while(rs.next())
		{
			
			delivaryDate = checkForNull(rs.getString("time_of_birth"));
			
		}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPsychiatryForm - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return delivaryDate;
	}
	
	//ENDS

	/*Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074*/
	public static String getIPBedsEffStatus(Connection con, String bed_no, String nursing_unit_code, String facility_id) throws Exception
	{
		PreparedStatement pstmt		= null;
		ResultSet rset				= null;
		String eff_status			= null;
		
		try{

			String sqlQuery1 = " SELECT eff_status FROM ip_nursing_unit_bed WHERE bed_no = ? AND nursing_unit_code = ? AND facility_id = ? ";

			pstmt= con.prepareStatement(sqlQuery1);
			pstmt.setString(1,bed_no);
			pstmt.setString(2,nursing_unit_code);
			pstmt.setString(3,facility_id);
			rset= pstmt.executeQuery();
			
			if(rset!=null && rset.next()){
				eff_status = rset.getString("eff_status")==null?"":rset.getString("eff_status");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getIPBedsEffStatus - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return eff_status;
	}
	/*End ML-MMOH-CRF-1074*/


	public static int getUnfinalizedNewBornCount(Connection con, String motherPatientId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt						= 0;

		try{
			sql	= "SELECT COUNT (*) cnt FROM mp_birth_register WHERE mother_patient_id = '"+motherPatientId+"' and FINALIZED_YN = 'N' ";

			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt	= rs.getInt("cnt");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getUnfinalizedNewBornCount method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}
	//Added by Shanmukh on 1st-AUG-2018 for ML-MMOH-CRF-0618
	public static String getAdmissionType(Connection con, String facilityId) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String admission_type	= "";

		try{
			String sql = "select admission_type from ip_param where facility_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				admission_type		= checkForDefault(rs.getString("admission_type"),"");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAdmissionType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return admission_type;
	
	}
	//Added by Shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	public static String getSpltyNurUnitToEnableYN(Connection con) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String spl_nur_unit_to_enable_yn	= "";

		try{
			String sql = "select SPL_NUR_UNIT_TO_ENABLE_YN from SM_SITE_PARAM";
			
			pstmt= con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				spl_nur_unit_to_enable_yn		= checkForDefault(rs.getString("SPL_NUR_UNIT_TO_ENABLE_YN"),"N");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in spl_nur_unit_to_enable_yn - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return spl_nur_unit_to_enable_yn;
	
	}
	//added by mujafar for MMS-MD-SCF-0096  START

	public static String getSystemDateTime(Connection con,String adm_date_chk_days_type,String adm_date_chk_days) throws Exception{
		Statement stmt		= null;
		ResultSet rs 		= null;
		String sysDateTime	= null;

		try{
			String sysDateSql = "";
			System.out.println("adm_date_chk_days_type::"+adm_date_chk_days_type);
			System.out.println("adm_date_chk_days::"+adm_date_chk_days);
			
			if(adm_date_chk_days_type.equals("H"))
				sysDateSql = "Select TO_CHAR(SYSDATE-"+adm_date_chk_days+"/24,'dd/mm/rrrr hh24:mi') setup_date from dual";
			else
				sysDateSql = "select TO_CHAR(SYSDATE-"+adm_date_chk_days+",'dd/mm/rrrr hh24:mi') setup_date from dual";
			
			System.out.println("sysDateSql>>"+sysDateSql);
			 
			stmt = con.createStatement();
			rs = stmt.executeQuery(sysDateSql);
			
			if(rs!=null && rs.next()){
				sysDateTime = rs.getString("setup_date")==null?"":rs.getString("setup_date");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSystemDateTime - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return sysDateTime;
	}
	//added by mujafar for MMS-MD-SCF-0096 END
	
	//Added by kamatchi S on 23-jun-2020 for ML-MMOH-CRF-1527
	public static String getDischargeTo(Connection con,String facility_id,long encounterid,String patient_id,String patient_class ) throws Exception{
				PreparedStatement pstmt	= null;
				ResultSet rs 			= null;
				String DISCHARGE_TO = "";

				try{
					String sql = "select DISCHARGE_TO from PR_ENCOUNTER WHERE FACILITY_ID='"+facility_id +"'and ENCOUNTER_ID =  '"+encounterid+"' and patient_id ='"+patient_id+"' and PATIENT_CLASS='"+patient_class+"'";
					
					pstmt= con.prepareStatement(sql);
					rs	= pstmt.executeQuery();

					while(rs!=null && rs.next()){
						DISCHARGE_TO = rs.getString("DISCHARGE_TO")==null?"":rs.getString("DISCHARGE_TO");
					}
					
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					try{
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
					}catch(Exception ex){
						System.err.println("Exception in DISCHARGE_TO - "+ex.getMessage());
						ex.printStackTrace();
					}
				}
				return DISCHARGE_TO;
			}

	//Below added by Suji Keerthi for NMC-JD-CRF-0130

public static JSONObject getReferralPriority(Connection con) throws Exception{
			
			PreparedStatement pstmt	= null;
			ResultSet rs 			= null;
			JSONObject json			= new JSONObject();
			JSONArray arrJSON		= new JSONArray();
			String sql				= "";
			

			try{

				 sql = "select priority_Code,priority_Desc from am_referral_priority";

				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();

				while(rs!=null && rs.next()){

						JSONObject jsonObj	= new JSONObject();
						
						
						String priority_Code = checkForNull(rs.getString("priority_Code"));
						String priority_Desc = checkForNull(rs.getString("priority_Desc"));
						
						jsonObj.put("priority_Code",priority_Code);
						jsonObj.put("priority_Desc",priority_Desc);

						arrJSON.add(jsonObj);
				}

				json.put("refPriorityArray",arrJSON);
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in getReferralPriority - "+ex.getMessage());
					ex.printStackTrace();
				}
			}
			
			return json;
			
	}
	
	/*Added by Ashwini on 15-Nov-2022 for ML-MMOH-CRF-1613*/
	public static String insertSyProgParam(Connection con, String facility_id, String episode_id, int session_id, String pgm_date) throws Exception
	{
		PreparedStatement pstmt	= null;
		int rset = 0;
		String inserted_yn = "";
		
		try{

			String sqlQuery = " INSERT INTO sy_prog_param (operating_facility_id, pgm_id, session_id, pgm_date, param3, param4 ) VALUES ('"+facility_id+"', 'BLR0018B', '"+session_id+"', '"+pgm_date+"', '"+episode_id+"', '"+episode_id+"') ";

			pstmt = con.prepareStatement(sqlQuery);
			rset = pstmt.executeUpdate();
			
			if(rset > 0){
				inserted_yn = "Y";
				con.commit();
			}else{
				inserted_yn = "N";
				con.rollback();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in insertSyProgParam - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return inserted_yn;
	}
	/*End ML-MMOH-CRF-1613*/

	public static String getDepositAmt(Connection con, String facilityId, String episodetype, int eid) throws Exception
	{
		CallableStatement cstmt = null ;
		int rset = 0;
		String deposit_collected = "";
		try{

					cstmt=con.prepareCall("{call BLCOMMONPROC.Get_adm_dep_collected(?,?,?,?)}");
					cstmt.setString(1,facilityId);
					cstmt.setString(2,episodetype);
					cstmt.setInt(3,eid);
					cstmt.registerOutParameter(4,java.sql.Types.VARCHAR); 
					cstmt.execute();
					deposit_collected	= cstmt.getString(4);
					System.err.println("deposit_collected====servlet=========>"+deposit_collected);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(cstmt!=null)cstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getDepositAmt - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return deposit_collected;
	}
	
	public static String getDepositVal(Connection con, String facilityId) throws Exception
	{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String deposit = "";

		try{
			String sql = "SELECT 'Deposit collected : ' || base_currency || ' ' || LTRIM (RTRIM (TO_CHAR (NVL (0, 0), DECODE (no_of_decimal, 3, '999,999,999,990.000', '999,999,999,990.00' ) ) ) ) AS deposit FROM sy_acc_entity WHERE acc_entity_id = '"+facilityId+"'";
			
			pstmt= con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				deposit = rs.getString("deposit")==null?"":rs.getString("deposit");
				System.err.println("hi in deposit==>"+deposit);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getDepositVal - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return deposit;
	}

    public static String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	public static String checkForDefault(String inputString, String Default)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? Default : inputString);
	}


}//End of Bean