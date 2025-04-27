package eXH;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.*;
 
import java.sql.*;
import java.util.ArrayList;

public class InsuranceAuthStatusBean implements Serializable {


public static String getPatientName(String strPatientId) throws SQLException {
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	String pat_name="";
	
	try {
	connection = ConnectionManager.getConnection() ;

	pstmt = connection.prepareStatement("SELECT PATIENT_NAME FROM MP_PATIENT  WHERE PATIENT_ID=?") ;

	pstmt.setString(1,strPatientId);

	resultSet = pstmt.executeQuery() ;
	while (resultSet.next()) {
		pat_name = resultSet.getString("PATIENT_NAME");
	}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally{
		//pstmt.close();
		//resultSet.close();
		XHUtil.closeDBResources(resultSet, pstmt, connection);
	}
		
	return pat_name;

}

public static String getEncounterId(String strPatientId) throws SQLException {
	Connection connection = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	String encounter_id="";
	
	try {
	connection = ConnectionManager.getConnection() ;

	pstmt = connection.prepareStatement("SELECT ENCOUNTER_ID FROM PR_ENCOUNTER WHERE PATIENT_ID=?") ;

	pstmt.setString(1,strPatientId);

	resultSet = pstmt.executeQuery() ;
	while (resultSet.next()) {
		encounter_id = resultSet.getString("ENCOUNTER_ID");
	}
	}catch ( Exception e ) {
		e.printStackTrace() ;
	}finally{
		//pstmt.close();
		//resultSet.close();
		XHUtil.closeDBResources(resultSet, pstmt, connection);
		}
		
	return encounter_id;

}


/**** To Handle java.lang.NullPointerException. *****/
public static String checkForNull(String inputString)
{
	return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
}

public static String checkForNull(String inputString, String defaultValue)
{
	return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
}
	
public List<PatientDetails> getInsAuthStatusRecordsDetails (String patient_id,String encounter_id,String fromDate_search,String toDate_search, String episode_type, String disp_location, String auth_status, String facilityId) throws Exception{	

		List<PatientDetails> InsAuthStatus = new ArrayList<PatientDetails>() ;
		PatientDetails patientDetails;
		
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String sqlQuery = null;
		
		int paramsSet = 0;
		
		sqlQuery = "SELECT a.facility_id, a.disp_no, a.disp_date_time, a.order_id, a.patient_id, a.encounter_id, h.visit_adm_date_time, a.patient_class, a.locn_type, a.locn_code, a.speciality_code, a.dispensed_by, a.dispensed_date_time, a.authorized_by, a.disp_authorized_date_time, b.srl_no, b.pres_drug_code, b.disp_drug_code, b.item_code, b.disp_qty, b.disp_uom_code, b.returned_qty, b.issue_qty, b.issue_uom_code, b.approval_no, b.disp_locn_code, DECODE (a.patient_class, 'IP', base_price_ip, 'OP', base_price_op,'EM', base_price_em,'DC', base_price_dc, public_price) net_price, e.claim_id, e.request_status, e.request_status_desc, f.short_desc, g.status item_status, g.benefit_value, g.benefit_currency, e.approval_ref FROM ph_disp_hdr a, ph_disp_dtl b, ph_disp_drug_batch c, bl_st_item_by_tradename d, xh_payer_header e, or_order_catalog f, xh_payer_auth_detail g, pr_encounter h WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no AND a.order_id = b.order_id AND a.facility_id = c.facility_id AND a.disp_no = c.disp_no AND b.srl_no = c.srl_no AND b.item_code = c.item_code AND c.batch_id = d.batch_id(+) AND a.facility_id = d.operating_facility_id AND b.item_code = d.item_code AND SYSDATE BETWEEN effective_from_date AND NVL (d.effective_to_date, SYSDATE + 1) AND a.facility_id = e.request_facility_id(+) AND a.disp_no = e.disp_id(+) AND b.item_code = f.order_catalog_code(+) AND a.facility_id = g.request_facility_id(+) AND a.disp_no = g.disp_id(+) AND b.srl_no = g.item_sequence(+) AND b.item_code = g.drug_code(+) AND e.claim_id = g.claim_id(+) AND a.facility_id = h.facility_id AND a.encounter_id = h.encounter_id AND e.request_type(+) = 'PHPREAUTH' AND a.facility_id = '"+facilityId+"' ";
		
		if(null != patient_id && !"".equals(patient_id)) {
			sqlQuery += " and a.patient_id = ? ";
			++paramsSet;
		}
		
		if(null != encounter_id && !"".equals(encounter_id)) {
			sqlQuery += " and a.encounter_id = ? ";
			++paramsSet;
		}
			
		if(null != episode_type && !"".equals(episode_type)) {
			sqlQuery += " and a.patient_class = ? ";
			++paramsSet;
		}
		
		if(null != disp_location && !"".equals(disp_location)) {
			sqlQuery += " and b.disp_locn_code = ? ";
			++paramsSet;
		}
			
		if(null != auth_status && !"".equals(auth_status)) {
			sqlQuery += " and g.status = ? ";
			++paramsSet;
		}
			
		if(null !=fromDate_search  && !"".equals(fromDate_search)) {
			sqlQuery += " and h.visit_adm_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY HH24:MI') ";
			++paramsSet;
		}
			
		if(null !=toDate_search  && !"".equals(toDate_search)) {
			sqlQuery += " and TO_DATE (?, 'DD/MM/YYYY HH24:MI') ";
			++paramsSet;
		}
			
		sqlQuery += "ORDER BY A.disp_no ";
			
		try {
		
			connection				= ConnectionManager.getConnection();
			pstmt					= connection.prepareStatement( sqlQuery );

			int curr = 1;
 
			while(curr <= paramsSet){
				if(null != patient_id && !"".equals(patient_id)) {
					pstmt.setString(curr, patient_id);
					++curr;
				}
				if(null != encounter_id && !"".equals(encounter_id)) {
					pstmt.setString(curr, encounter_id);
					++curr;
				}
				if(null != episode_type && !"".equals(episode_type)) {
					pstmt.setString(curr, episode_type);
					++curr;
				}
				if(null != disp_location && !"".equals(disp_location)) {
					pstmt.setString(curr, disp_location);
					++curr;
				}
				if(null != auth_status && !"".equals(auth_status)) {
					pstmt.setString(curr, auth_status);
					++curr;
				}
				if(null != fromDate_search && !"".equals(fromDate_search)) {
					pstmt.setString(curr, fromDate_search);
					++curr;
				}
				if(null != toDate_search && !"".equals(toDate_search)) {
					pstmt.setString(curr, toDate_search);
					++curr;
				}
			}

			resultSet = pstmt.executeQuery() ;		

			while(resultSet.next()){ 
			
					patientDetails = new PatientDetails();
					patientDetails.setFacilityId(resultSet.getString("FACILITY_ID")); //1
					patientDetails.setDispNo(resultSet.getString("DISP_NO")); //2
					patientDetails.setDispDateTime(resultSet.getString("DISP_DATE_TIME")); //3
					patientDetails.setOrderId(resultSet.getString("ORDER_ID")); //4
					patientDetails.setPatientId(resultSet.getString("PATIENT_ID")); //5
					patientDetails.setEncounterId(resultSet.getString("ENCOUNTER_ID")); //6
					patientDetails.setPatientClass(resultSet.getString("PATIENT_CLASS")); //7
					patientDetails.setLocnType(resultSet.getString("LOCN_TYPE")); //8
					patientDetails.setLocnCode(resultSet.getString("LOCN_CODE")); //9
					patientDetails.setSpecialityCode(resultSet.getString("SPECIALITY_CODE")); //10
					patientDetails.setDispensedBy(resultSet.getString("DISPENSED_BY")); //11
					patientDetails.setDispensedDateTime(resultSet.getString("DISPENSED_DATE_TIME")); //12
					patientDetails.setAuthorizedBy(resultSet.getString("AUTHORIZED_BY")); //13
					patientDetails.setDispAuthorizedDateTime(resultSet.getString("DISP_AUTHORIZED_DATE_TIME")); //14
					patientDetails.setSrlNo(resultSet.getString("SRL_NO")); //15
					patientDetails.setPresDrugCode(resultSet.getString("PRES_DRUG_CODE")); //16
					patientDetails.setDispDrugCode(resultSet.getString("DISP_DRUG_CODE")); //17
					patientDetails.setItemCode(resultSet.getString("ITEM_CODE")); //18
					patientDetails.setDispQty(resultSet.getString("DISP_QTY")); //19
					patientDetails.setDispUomCode(resultSet.getString("DISP_UOM_CODE")); //20
					patientDetails.setReturnedQty(resultSet.getString("RETURNED_QTY")); //21
					patientDetails.setIssueQty(resultSet.getString("ISSUE_QTY")); //22
					patientDetails.setIssueUomCode(resultSet.getString("ISSUE_UOM_CODE"));//23
					patientDetails.setApprovalNo(resultSet.getString("APPROVAL_REF"));//24
					patientDetails.setNetPrice(resultSet.getString("NET_PRICE"));//25
					patientDetails.setRequestStatus(resultSet.getString("REQUEST_STATUS"));//26 status from xh_payer_header
					patientDetails.setRequestStatusDesc(resultSet.getString("REQUEST_STATUS_DESC"));//27
					patientDetails.setShortDesc(resultSet.getString("SHORT_DESC"));//28
					patientDetails.setAuthStatus(resultSet.getString("ITEM_STATUS"));//29 //status from xh_payer_auth_detail
					patientDetails.setBenefitValue(resultSet.getString("BENEFIT_VALUE"));//30 
					patientDetails.setBenefitCurrency(resultSet.getString("BENEFIT_CURRENCY"));//31
					patientDetails.setDispLocnCode(resultSet.getString("DISP_LOCN_CODE"));//32
					patientDetails.setOrderDateTime(resultSet.getString("VISIT_ADM_DATE_TIME"));//33
					patientDetails.setClaimId(resultSet.getString("CLAIM_ID"));//34
	
				InsAuthStatus.add(patientDetails);
			
			}
	
			}catch (Exception e) {
			  e.printStackTrace();
			} finally {	
				//pstmt.close();
				//resultSet.close();
				XHUtil.closeDBResources(resultSet, pstmt, connection);
			}
			return InsAuthStatus;
	}
	public static String getauthstatusdetails(String strDispId, String strItemSequence, String strDrugCode) throws SQLException {
			Connection connection2 = null ;
			PreparedStatement pstmt2 = null ;
			ResultSet resultSet2 = null ;
			String authstatus="";
			
			try {
			connection2 = ConnectionManager.getConnection() ;

			pstmt2 = connection2.prepareStatement("SELECT STATUS from XH_PAYER_AUTH_DETAIL where DISP_ID=? and ITEM_SEQUENCE=?  and DRUG_CODE=?") ;

			pstmt2.setString(1,strDispId);
			pstmt2.setString(2,strItemSequence);
			pstmt2.setString(3,strDrugCode);

			resultSet2 = pstmt2.executeQuery() ;
			while (resultSet2.next()) {
				authstatus = resultSet2.getString("STATUS");
			}
			}catch ( Exception e ) {
				e.printStackTrace() ;
			}finally{pstmt2.close();
				resultSet2.close();
				connection2.close();
			}		
			return authstatus;
	}
	public static String getapporvedamount(String strDispId, String strItemSequence, String strDrugCode) throws SQLException {
			Connection connection2 = null ;
			PreparedStatement pstmt2 = null ;
			ResultSet resultSet2 = null ;
			String approvedamt="";
			
			try {
			connection2 = ConnectionManager.getConnection() ;

			pstmt2 = connection2.prepareStatement("SELECT BENEFIT_VALUE from XH_PAYER_AUTH_DETAIL where DISP_ID=? and ITEM_SEQUENCE=?  and DRUG_CODE=?") ;

			pstmt2.setString(1,strDispId);
			pstmt2.setString(2,strItemSequence);
			pstmt2.setString(3,strDrugCode);

			resultSet2 = pstmt2.executeQuery() ;
			while (resultSet2.next()) {
				approvedamt = resultSet2.getString("BENEFIT_VALUE");
			}
			}catch ( Exception e ) {
				e.printStackTrace() ;
			}finally{pstmt2.close();
				resultSet2.close();
				connection2.close();
			}		
			return approvedamt;
	}

}