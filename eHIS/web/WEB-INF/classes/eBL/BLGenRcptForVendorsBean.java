package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlAdapter;

public class BLGenRcptForVendorsBean extends BlAdapter implements Serializable {

	//private static final long serialVersionUID = 1L; //commented checkstyle
	
	private String chkBoxStatus;
	private String facilityId;
	private String loginUser;
	private String loginWsNo;
	private String vendorType;
	private String patientId;
	private String patientName;
	private String dob;
	private String gender;
	private String practoTransactionId;
	private String practoReceiptNo;
	private String practoReceiptAmount;
	private String practoReceiptDate;
	private String emReceiptNo;
	private String emReceiptDate;
	private String commnets;
	private String practoDocTypeCode;
	private String practoDocNo;
	private String status;
	private String slmtDocRefDesc;
	private String slmtDocRefDate;
	private String chkBoxName;

	private List<BLGenRcptForVendorsBean> list;

	/* Getter/Setter Starts */
	public String getChkBoxStatus() {
		return chkBoxStatus;
	}

	public void setChkBoxStatus(String chkBoxStatus) {
		this.chkBoxStatus = chkBoxStatus;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getLoginWsNo() {
		return loginWsNo;
	}

	public void setLoginWsNo(String loginWsNo) {
		this.loginWsNo = loginWsNo;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPractoTransactionId() {
		return practoTransactionId;
	}

	public void setPractoTransactionId(String practoTransactionId) {
		this.practoTransactionId = practoTransactionId;
	}

	public String getPractoReceiptNo() {
		return practoReceiptNo;
	}

	public void setPractoReceiptNo(String practoReceiptNo) {
		this.practoReceiptNo = practoReceiptNo;
	}

	public String getPractoReceiptAmount() {
		return practoReceiptAmount;
	}

	public void setPractoReceiptAmount(String practoReceiptAmount) {
		this.practoReceiptAmount = practoReceiptAmount;
	}

	public String getPractoReceiptDate() {
		return practoReceiptDate;
	}

	public void setPractoReceiptDate(String practoReceiptDate) {
		this.practoReceiptDate = practoReceiptDate;
	}

	public String getEmReceiptNo() {
		return emReceiptNo;
	}

	public void setEmReceiptNo(String emReceiptNo) {
		this.emReceiptNo = emReceiptNo;
	}

	public String getEmReceiptDate() {
		return emReceiptDate;
	}

	public void setEmReceiptDate(String emReceiptDate) {
		this.emReceiptDate = emReceiptDate;
	}

	public String getCommnets() {
		return commnets;
	}

	public void setCommnets(String commnets) {
		this.commnets = commnets;
	}

	public String getPractoDocTypeCode() {
		return practoDocTypeCode;
	}

	public void setPractoDocTypeCode(String practoDocTypeCode) {
		this.practoDocTypeCode = practoDocTypeCode;
	}

	public String getPractoDocNo() {
		return practoDocNo;
	}

	public void setPractoDocNo(String practoDocNo) {
		this.practoDocNo = practoDocNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSlmtDocRefDesc() {
		return slmtDocRefDesc;
	}

	public void setSlmtDocRefDesc(String slmtDocRefDesc) {
		this.slmtDocRefDesc = slmtDocRefDesc;
	}

	public String getSlmtDocRefDate() {
		return slmtDocRefDate;
	}

	public void setSlmtDocRefDate(String slmtDocRefDate) {
		this.slmtDocRefDate = slmtDocRefDate;
	}

	public String getChkBoxName() {
		return chkBoxName;
	}

	public void setChkBoxName(String chkBoxName) {
		this.chkBoxName = chkBoxName;
	}

	public List<BLGenRcptForVendorsBean> getList() {
		return list;
	}

	public void setList(List<BLGenRcptForVendorsBean> list) {
		this.list = list;
	}
	/* Getter/Setter Ends */

	public void setDBValues(String mode, String facilityId, String vendorType,
			String patientId, String patientName, String fromDate,
			String toDate, String receiptStatus) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlStr;
		try {
			sqlStr = "SELECT OPERATING_FACILITY_ID,VENDOR_TYPE,NVL(PATIENT_ID,'') PATIENT_ID,UPPER(SHORT_NAME) SHORT_NAME,TO_CHAR(DATE_OF_BIRTH,'dd/MM/yyyy') DATE_OF_BIRTH,GENDER,PRACTO_DOC_TYPE_CODE,"
					+ " PRACTO_DOC_NUMBER,TO_CHAR(PRACTO_DOC_DATE,'dd/MM/yyyy') PRACTO_DOC_DATE,RECPT_NATURE_CODE,TRX_TYPE_CODE,DOC_AMT,SLMT_DOC_REF_DESC,"
					+ " TO_CHAR(SLMT_DOC_REF_DATE,'dd/MM/yyyy') SLMT_DOC_REF_DATE,SLMT_DOC_REMARKS,ERROR_TEXT,RECEIPT_REMARKS,EM_DOC_TYPE_CODE,EM_DOC_NUMBER,"
					+ " TO_CHAR(EM_DOC_DATE,'dd/MM/yyyy') EM_DOC_DATE,PRACTO_TRANS_ID,NVL(STATUS,'N') STATUS"
					+ " FROM XH_WP_RECEIPT"
					+ " WHERE OPERATING_FACILITY_ID='"
					+ facilityId
					+ "' AND UPPER(VENDOR_TYPE) = NVL(UPPER('"
					+ vendorType
					+ "'),VENDOR_TYPE)"
					+ " AND TRUNC(PRACTO_DOC_DATE) BETWEEN TO_DATE('"
					+ fromDate
					+ "','dd/MM/yyyy') AND TO_DATE('"
					+ toDate
					+ "','dd/MM/yyyy')";
			if (null != patientId && !"".equals(patientId)) {
				sqlStr += " AND PATIENT_ID = NVL('" + patientId
						+ "',PATIENT_ID) ";
			}
			if (null != patientName && !"".equals(patientName)) {
				sqlStr += " AND UPPER(SHORT_NAME) like NVL(UPPER('%"
						+ patientName + "%'),SHORT_NAME)";
			}
			if (!"A".equals(receiptStatus)) {
				sqlStr += " AND STATUS = NVL('" + receiptStatus + "',STATUS)";
			}
			sqlStr += " order by practo_doc_date, practo_doc_type_code, practo_doc_number";

			con = getConnection();
			pstmt = con.prepareStatement(sqlStr);
			System.out.println("BLGenRcptForVendorsBean.java->setDBValues()->sqlStr: " + sqlStr);
			rs = pstmt.executeQuery();
			List<BLGenRcptForVendorsBean> list = new ArrayList<BLGenRcptForVendorsBean>();
			while (rs.next()) {
				BLGenRcptForVendorsBean bean = new BLGenRcptForVendorsBean();
				bean.setFacilityId(rs.getString("OPERATING_FACILITY_ID"));
				bean.setVendorType(rs.getString("VENDOR_TYPE"));
				bean.setPatientId(rs.getString("PATIENT_ID"));
				bean.setPatientName(rs.getString("SHORT_NAME"));
				bean.setDob(rs.getString("DATE_OF_BIRTH"));
				bean.setGender(rs.getString("GENDER"));
				bean.setPractoTransactionId(rs.getString("PRACTO_TRANS_ID"));
				bean.setPractoReceiptNo(rs.getString("PRACTO_DOC_TYPE_CODE")
						+ rs.getString("PRACTO_DOC_NUMBER"));
				bean.setPractoReceiptAmount(rs.getString("DOC_AMT"));
				bean.setPractoReceiptDate(rs.getString("PRACTO_DOC_DATE"));
				String emDocTypeCode = checkForNull(rs.getString("EM_DOC_TYPE_CODE"));
				String emDocNumber = checkForNull(rs.getString("EM_DOC_NUMBER"));
				if(!"".equals(emDocTypeCode) && !"".equals(emDocNumber)) {
					bean.setEmReceiptNo(checkForNull(rs.getString("EM_DOC_TYPE_CODE")) + "/"
							+ checkForNull(rs.getString("EM_DOC_NUMBER")));
				} else {
					bean.setEmReceiptNo(checkForNull(rs.getString("EM_DOC_TYPE_CODE"))
							+ checkForNull(rs.getString("EM_DOC_NUMBER")));
				}
				bean.setEmReceiptDate(checkForNull(rs.getString("EM_DOC_DATE")));
				bean.setCommnets(checkForNull(rs.getString("ERROR_TEXT")));
				bean.setPractoDocTypeCode(checkForNull(rs.getString("PRACTO_DOC_TYPE_CODE")));
				bean.setPractoDocNo(checkForNull(rs.getString("PRACTO_DOC_NUMBER")));
				bean.setSlmtDocRefDesc(checkForNull(rs.getString("SLMT_DOC_REF_DESC")));
				bean.setSlmtDocRefDate(checkForNull(rs.getString("SLMT_DOC_REF_DATE")));
				bean.setStatus(checkForNull(rs.getString("STATUS")));

				list.add(bean);
			}
			setList(list);

		} catch (Exception ex) {
			System.err
					.println("Error in BLGenRcptForVendorsBean.java->setDBValues: "
							+ ex);
			ex.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				ConnectionManager.returnConnection(con);
		}
	}
	
	public void clearBean() {
		chkBoxStatus = "";
		facilityId = "";
		loginUser = "";
		loginWsNo = "";
		vendorType = "";
		patientId = "";
		patientName = "";
		dob = "";
		gender = "";
		practoTransactionId = "";
		practoReceiptNo = "";
		practoReceiptAmount = "";
		practoReceiptDate = "";
		emReceiptNo = "";
		emReceiptDate = "";
		commnets = "";
		practoDocTypeCode = "";
		practoDocNo = "";
		status = "";
		slmtDocRefDesc = "";
		slmtDocRefDate = "";
		chkBoxName = "";

		list.clear();
	}
}
