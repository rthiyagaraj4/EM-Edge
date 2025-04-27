/*
 * @author Aravindh H
 * Created On 05-02-2018
 * 
 */
package eBL;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import eBL.Common.BlRepository;

public class BLPatientWiseDepositTrans implements Serializable {

	private static final long serialVersionUID = 1L;

	private LinkedHashMap<String, List<BLPatientWiseTransModel>> transMap;
	private HashMap<String, String> legendMap;

	private String facilityName;
	private String hospitalAddress;
	private String gstNo;
	private String patientName;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public LinkedHashMap<String, List<BLPatientWiseTransModel>> getTransMap() {
		return transMap;
	}

	public void setTransMap(
			LinkedHashMap<String, List<BLPatientWiseTransModel>> transMap) {
		this.transMap = transMap;
	}

	public HashMap<String, String> getLegendMap() {
		return legendMap;
	}

	public void setLegendMap(HashMap<String, String> legendMap) {
		this.legendMap = legendMap;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public BLPatientWiseDepositTrans getDetailsFromDB(Connection con,
			String facilityId, String locale, String loggedUser,
			String fromPatId, String toPatId) {

		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		ResultSet rs,rst = null;
		CallableStatement cstmt = null;

		BLPatientWiseDepositTrans splBean = new BLPatientWiseDepositTrans();

		try {

			String getHospHdrQry = BlRepository
					.getBlKeyValue("GET_HOSP_HEADER_DTLS");
			String getHospAddrQry = BlRepository
					.getBlKeyValue("GET_FACILITY_ADDR");
			String getLegendsQry = BlRepository
					.getBlKeyValue("GET_LEGENDS_FRM_DEPOSIT_TRANS_DATA");
			String getDepositTransQry = BlRepository
					.getBlKeyValue("GET_DEPOSIT_TRANS");
		//	String getDepositTransPatientNameQry = BlRepository
				//	.getBlKeyValue("GET_PATIENT_NAME_TRANS_DATA");

			HashMap<String, String> legendMap = new HashMap<String, String>();
			LinkedHashMap<String, List<BLPatientWiseTransModel>> transMap = new LinkedHashMap<String, List<BLPatientWiseTransModel>>();

			List<BLPatientWiseTransModel> transArryOuterList = null;

			BLPatientWiseTransModel model = null;

			cstmt = con.prepareCall(getHospHdrQry);
			cstmt.setString(1, "BL");
			cstmt.setString(2, "BLRPPAD");
			cstmt.setString(3, facilityId);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.setString(8, locale);

			cstmt.execute();

			String facilityName = cstmt.getString(6);

			cstmt.close();

			cstmt = con.prepareCall(getHospAddrQry);
			cstmt.setString(1, locale);
			cstmt.setString(2, facilityId);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);

			cstmt.execute();

			String hospAddr = cstmt.getString(3);
			String gstin = cstmt.getString(4);

			cstmt.close();
			String patientName = "";
			
		//	cstmt.close();
			
			pst = con.prepareStatement(getLegendsQry);
			pst.setString(1, locale);
			//System.out.println("getDepositTransQry "+getLegendsQry);
			rs = pst.executeQuery();

			while (rs != null && rs.next()) {
				legendMap
						.put(rs.getString("pk_value"), rs.getString("legends"));
			}

			rs.close();
			pst.close();

			pst = con.prepareStatement(getDepositTransQry);
			
			pst.setString(1, facilityId);
			pst.setString(2, fromPatId);
			pst.setString(3, toPatId);
			pst.setString(4, fromPatId);
			pst.setString(5, facilityId);
			pst.setString(6, fromPatId);
			pst.setString(7, toPatId);
			pst.setString(8, fromPatId);
			
		/*	pst.setString(1, fromPatId);
			pst.setString(2, toPatId);
			pst.setString(3, facilityId);
			pst.setString(4, fromPatId);
			pst.setString(5, toPatId);
			pst.setString(6, facilityId);
			pst.setString(7, fromPatId);
			pst.setString(8, toPatId);
			pst.setString(9, facilityId);
			*/
			rs = pst.executeQuery();

			while (rs != null && rs.next()) {
				if (!transMap.containsKey(rs.getString("patient_id"))) {
					transArryOuterList = new ArrayList<BLPatientWiseTransModel>();
				}

				
				model = new BLPatientWiseTransModel();
				model.setEncounterId(rs.getString("encounter_id"));
				model.setEpisodeType(rs.getString("episode_desc"));
				model.setDocumentDate(rs.getString("new_org_doc_date"));
				model.setDocumentNumber(rs.getString("org_doc_type_code") + "/"
						+ rs.getString("org_doc_num"));
				model.setDocumentType(rs.getString("doc_type_desc"));
				model.setAmountDr(rs.getString("dr_amt"));
				model.setAmountCr(rs.getString("cr_amt"));
				model.setAmountBal(rs.getString("bal"));
				model.setPackagedtl(rs.getString("packagedtl"));
				model.setPatientName(rs.getString("patient_name"));

				transArryOuterList.add(model);

				transMap.put(rs.getString("patient_id"), transArryOuterList);
			}
			splBean.setFacilityName(facilityName);
			splBean.setHospitalAddress(hospAddr);
			splBean.setGstNo(gstin);
		//	splBean.setPatientName(patientName);
			splBean.setLegendMap(legendMap);
			splBean.setTransMap(transMap);

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst1 != null) {
					pst1.close();
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return splBean;
	}

}
