/*Created by Thamizh selvi on 31st Mar 2017 against GDOH-CRF-0124*/
package eIP;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;

public class IPCancelTransferBean implements Serializable{

	public static JSONObject getCancelTrfResult(Connection con,String patientId,String facilityId,String locale) throws Exception{
		PreparedStatement pstmt=null;
		ResultSet rs 	= null;
		JSONObject jsonObj	= new JSONObject();
		StringBuffer sqlSb			= new StringBuffer();

		try{
			sqlSb.append(" SELECT  a.encounter_id, a.patient_id, a.fr_nursing_unit_code, a.to_nursing_unit, a.srl_no, a.fr_service_code, a.fr_bed_class_code, a.fr_bed_type_code, a.fr_practitioner_id, a.fr_specialty_code, a.fr_subservice_code, a.tfr_type, to_char(b.modified_date,'dd/mm/rrrr hh24:mi:ss') modified_date, a.tfr_req_ref_no,");
			sqlSb.append("ip_get_desc.ip_nursing_unit(a.facility_id,a.fr_nursing_unit_code,'"+locale+"','2') frm_nursing_unit_short_desc,");
			sqlSb.append("ip_get_desc.ip_bed_class (a.fr_bed_class_code,'"+locale+"','2') frm_bed_class_short_desc, "); 
			sqlSb.append("ip_get_desc.ip_bed_type (a.fr_bed_type_code,'"+locale+"','2') frm_bed_type_short_desc,");      
			sqlSb.append("a.fr_room_no frm_room_no, a.fr_bed_no frm_bed_no, ");
			sqlSb.append("ip_get_desc.ip_nursing_unit (a.facility_id, a.to_nursing_unit,'"+locale+"','2') to_nursing_unit_short_desc,  ");
			sqlSb.append("ip_get_desc.ip_bed_class(a.to_bed_class_code, 'en', '2' ) to_bed_class_short_desc,  ");
			sqlSb.append("ip_get_desc.ip_bed_type (a.to_bed_type_code, 'en', '2' ) to_bed_type_short_desc, ");
			sqlSb.append("a.to_room_no to_room_no, a.to_bed_no to_bed_no FROM ip_adt_trn a, ip_open_encounter b, mp_patient c where a.patient_id='"+patientId+"' ");
			sqlSb.append(" and a.facility_id= '"+facilityId+"' AND a.trn_type = 'T' AND a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND a.patient_id = c.patient_id ");
			sqlSb.append(" and a.practitioner_tfr_yn = 'N' and a.fr_nursing_unit_code != a.to_nursing_unit");
			sqlSb.append(" and b.ip_leave_status is null ");
			sqlSb.append(" and a.trn_date_time = (select max(trn_date_time) from ip_adt_trn where encounter_id = a.encounter_id and facility_id = a.facility_id and trn_type = 'T')");
			
			
			pstmt = con.prepareStatement(sqlSb.toString());
			rs	 = pstmt.executeQuery();

			if(rs!=null && rs.next()){

				String encounter_id		= rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
				String patient_id		= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				
				String srlNo			= rs.getString("srl_no")==null?"":rs.getString("srl_no");
				String frmServcode		= rs.getString("fr_service_code")==null?"":rs.getString("fr_service_code");
				String frmBedClsCode	= rs.getString("fr_bed_class_code")==null?"":rs.getString("fr_bed_class_code");
				String frmBedTypeCode	= rs.getString("fr_bed_type_code")==null?"":rs.getString("fr_bed_type_code");
				String frmPractId		= rs.getString("fr_practitioner_id")==null?"":rs.getString("fr_practitioner_id");
				String frmSpecCode		= rs.getString("fr_specialty_code")==null?"":rs.getString("fr_specialty_code");
				String frmSubServCode	= rs.getString("fr_subservice_code")==null?"":rs.getString("fr_subservice_code");
				String tfrType			= rs.getString("tfr_type")==null?"":rs.getString("tfr_type");
				
				String frmNursCode		= rs.getString("fr_nursing_unit_code")==null?"":rs.getString("fr_nursing_unit_code");
				String frmNursDesc		= rs.getString("frm_nursing_unit_short_desc")==null?"":rs.getString("frm_nursing_unit_short_desc");
				String frmBedCls		= rs.getString("frm_bed_class_short_desc")==null?"":rs.getString("frm_bed_class_short_desc");
				String frmBedType		= rs.getString("frm_bed_type_short_desc")==null?"":rs.getString("frm_bed_type_short_desc");
				String frm_room_no		= rs.getString("frm_room_no")==null?"":rs.getString("frm_room_no");
				String frm_bed_no		= rs.getString("frm_bed_no")==null?"":rs.getString("frm_bed_no");
				
				String toNursCode		= rs.getString("to_nursing_unit")==null?"":rs.getString("to_nursing_unit");
				String toNurs			= rs.getString("to_nursing_unit_short_desc")==null?"":rs.getString("to_nursing_unit_short_desc");
				String toBedCls			= rs.getString("to_bed_class_short_desc")==null?"":rs.getString("to_bed_class_short_desc");
				String toBedType		= rs.getString("to_bed_type_short_desc")==null?"":rs.getString("to_bed_type_short_desc");
				String to_room_no		= rs.getString("to_room_no")==null?"":rs.getString("to_room_no");
				String to_bed_no		= rs.getString("to_bed_no")==null?"":rs.getString("to_bed_no");

				String modified_date = rs.getString("modified_date")==null?"":rs.getString("modified_date");
				String tfr_req_ref_no = rs.getString("tfr_req_ref_no")==null?"":rs.getString("tfr_req_ref_no");
			
				jsonObj.put("encounterId",encounter_id);
				jsonObj.put("patientId",patient_id);
				
				jsonObj.put("srlNum",srlNo);
				jsonObj.put("frServCode",frmServcode);
				jsonObj.put("frBedClsCode",frmBedClsCode);
				jsonObj.put("frBedTypeCode",frmBedTypeCode);
				jsonObj.put("frPractId",frmPractId);
				jsonObj.put("frSpecCode",frmSpecCode);
				jsonObj.put("frSubServCode",frmSubServCode);
				jsonObj.put("trfType",tfrType);
				
				jsonObj.put("frmNursUtCode",frmNursCode);
				jsonObj.put("frmNursUtDesc",frmNursDesc);
				jsonObj.put("frmBedClsDesc",frmBedCls);
				jsonObj.put("frmBedTypeDesc",frmBedType);
				jsonObj.put("frmRoomNo",frm_room_no);
				jsonObj.put("frmBedNo",frm_bed_no);
				
				jsonObj.put("toNursUtCode",toNursCode);
				jsonObj.put("toNursUt",toNurs);
				jsonObj.put("toBedClsDesc",toBedCls);
				jsonObj.put("toBedTypeDesc",toBedType);
				jsonObj.put("toRoomNo",to_room_no);
				jsonObj.put("toBedNo",to_bed_no);

				jsonObj.put("modified_date",modified_date);
				jsonObj.put("tfrReqRefNo",tfr_req_ref_no);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCancelTrfResult - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static String validateForCancelTrf(Connection con,String encId,String facilityId, String nursUnit, String roomNo, String bedNo) throws Exception{
		PreparedStatement pstmt1=null;
		ResultSet rs1 	= null;
		PreparedStatement pstmt2=null;
		ResultSet rs2 	= null;
		PreparedStatement pstmt3=null;
		ResultSet rs3 	= null;
		String returnValue	= null;
		String returnValue1	= null;
		String returnValue2	= null;
		String returnValue3	= null;

		//Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074
		PreparedStatement pstmt4 = null;
		ResultSet rs4 = null;
		String returnValue4	= null;

		try{
			
			int occupiedBedCount = 0;
			int dischAdvCount = 0;
			int patOutCount = 0;

			String occupiedBedSql = "Select count(1) count from ip_nursing_unit_bed where facility_id='"+facilityId+"' and nursing_unit_code ='"+nursUnit+"'  and room_no = '"+roomNo+"' and bed_no='"+bedNo+"' and occupying_patient_id IS NOT NULL";

			pstmt1 = con.prepareStatement(occupiedBedSql);
			rs1	 = pstmt1.executeQuery();
			
			if(rs1!=null && rs1.next()){
				occupiedBedCount = rs1.getInt("count");
				if(occupiedBedCount != 0)
				{
					returnValue1	= "bed_occupied";
				}
			}

			String dischAdvSql = "Select count(1) count from ip_discharge_advice where facility_id='"+facilityId+"' and encounter_id='"+encId+"' and dis_adv_status != '9' ";

			pstmt2 = con.prepareStatement(dischAdvSql);
			rs2	 = pstmt2.executeQuery();
			
			if(rs2!=null && rs2.next()){
				dischAdvCount = rs2.getInt("count");
				if(dischAdvCount != 0)
				{
					returnValue2	= "disch_adv";
				}
			}

			String patOutSql = "Select count(1) count from ip_transfer_request where facility_id='"+facilityId+"' and encounter_id='"+encId+"' and tfr_req_status='3' ";
			
			pstmt3 = con.prepareStatement(patOutSql);
			rs3	 = pstmt3.executeQuery();

			if(rs3!=null && rs3.next()){
				patOutCount = rs3.getInt("count");
				if(patOutCount != 0)
				{
					returnValue3	= "pat_out_exist";
				}
			}
			
			/*Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074*/
			String effStatusSql = " SELECT eff_status FROM ip_nursing_unit_bed WHERE bed_no = '"+bedNo+"' AND nursing_unit_code = '"+nursUnit+"' AND facility_id = '"+facilityId+"' ";
			
			pstmt4 = con.prepareStatement(effStatusSql);
			rs4 = pstmt4.executeQuery();

			if(rs4!=null && rs4.next()){
				String effStatus = rs4.getString("eff_status");
				if(("D").equals(effStatus))
				{
					returnValue4 = "DisabledBed";
				}
			}
			/*End ML-MMOH-CRF-1074*/

			returnValue = returnValue1 + "|" + returnValue2 + "|" + returnValue3 + "|" + returnValue4; //Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074
			

			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs1!=null)rs1.close();
				if(pstmt1!=null)pstmt1.close();
				if(rs2!=null)rs2.close();
				if(pstmt2!=null)pstmt2.close();
				if(rs3!=null)rs3.close();
				if(pstmt3!=null)pstmt3.close();
				if(rs4!=null)rs4.close();
				if(pstmt4!=null)pstmt4.close();
			}catch(Exception ex){
				System.err.println("Exception in validateForCancelTrf - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return returnValue;
	}

	public static String MRUserLevelRestriction(Connection con,String facilityId, String userId) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String cancelTrfPatIn	= null;

		try{
		
			String accessRightsSql = "select CANCEL_TRANSFER_IN_YN from mr_user_access_rights where facility_id='"+facilityId+"' and appl_user_id='"+userId+"' ";

			pstmt = con.prepareStatement(accessRightsSql);
			rs	 = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				cancelTrfPatIn = rs.getString("CANCEL_TRANSFER_IN_YN");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in MRUserLevelRestriction - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cancelTrfPatIn;
	}

}