package eBL;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlAdapter;

public class PolicyApprovalBean extends BlAdapter implements Serializable {

	private static final long serialVersionUID = 1L;
	private String facilityId;
	private String customerGroup;
	private String customer;
	private String policy;
	private String chkBox;
	private String customerGroupDesc;
	private String customerDesc;
	private String policyDesc;
	private String ChkBoxDBVal;
	private String polStratDate;//Added V191016-Aravindh/NMC-JD-CRF-0010.2
	private String polEndDate;//Added V191016-Aravindh/NMC-JD-CRF-0010.2
	
	private List<PolicyApprovalBean> list;
	private HashMap<String, PolicyApprovalBean> hMap;
	
	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getChkBox() {
		return chkBox;
	}

	public void setChkBox(String chkBox) {
		this.chkBox = chkBox;
	}

	public String getCustomerGroupDesc() {
		return customerGroupDesc;
	}

	public void setCustomerGroupDesc(String customerGroupDesc) {
		this.customerGroupDesc = customerGroupDesc;
	}

	public String getCustomerDesc() {
		return customerDesc;
	}

	public void setCustomerDesc(String customerDesc) {
		this.customerDesc = customerDesc;
	}

	public String getPolicyDesc() {
		return policyDesc;
	}

	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}

	public String getChkBoxDBVal() {
		return ChkBoxDBVal;
	}

	public void setChkBoxDBVal(String chkBoxDBVal) {
		ChkBoxDBVal = chkBoxDBVal;
	}

	public String getPolStratDate() {
		return polStratDate;
	}

	public void setPolStratDate(String polStratDate) {
		this.polStratDate = polStratDate;
	}

	public String getPolEndDate() {
		return polEndDate;
	}

	public void setPolEndDate(String polEndDate) {
		this.polEndDate = polEndDate;
	}

	public List<PolicyApprovalBean> getList() {
		return list;
	}

	public void setList(List<PolicyApprovalBean> list) {
		this.list = list;
	}

	public HashMap<String, PolicyApprovalBean> gethMap() {
		return hMap;
	}

	public void sethMap(HashMap<String, PolicyApprovalBean> hMap) {
		this.hMap = hMap;
	}

	public void setDBValues(String mode, String facilityId,
			String payerGrpCode, String policyTypeCode, String payerCode,
			String applicalbleTo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlStr;
		try {
			sqlStr = "SELECT DECODE (hdr.cust_group_code,'**', 'All Payer Group',(SELECT grp.long_desc FROM ar_cust_group grp  WHERE grp.cust_group_code = hdr.cust_group_code)) payer_group,hdr.cust_group_code,DECODE (hdr.cust_code,'**', 'All Payer',(SELECT cust.long_name FROM ar_customer cust WHERE cust.cust_code = hdr.cust_code)) payer,hdr.cust_code,(SELECT pol.long_desc policy_type FROM bl_ins_policy_types pol WHERE pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id = hdr.operating_facility_id)policy_type, (SELECT pol.policy_type_code policy_type_code FROM bl_ins_policy_types pol WHERE pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id = hdr.operating_facility_id) policy_type_code, nvl(hdr.POLICY_APPROVED_YN,'N') policy_approved_yn, to_char(hdr.policy_eff_from,'dd/mm/yyyy') effective_from, to_char(hdr.policy_eff_to,'dd/mm/yyyy') effective_to FROM bl_ins_policy_type_hdr hdr where hdr.operating_facility_id='"+facilityId+"' and (hdr.CUST_GROUP_CODE='"+payerGrpCode+"' or '"+payerGrpCode+"' is null ) and (hdr.cust_code='"+payerCode+"' or '"+payerCode+"' is null ) and (hdr.policy_type_code ='"+policyTypeCode+"' or '"+policyTypeCode+"' is null) and ( (nvl(hdr.POLICY_APPROVED_YN,'N')= 'Y' and '"+applicalbleTo+"'='A') or (nvl(hdr.POLICY_APPROVED_YN,'N')= 'N' and '"+applicalbleTo+"'='U') or ( '"+applicalbleTo+"'='*'))";

			con = getConnection();
			pstmt = con.prepareStatement(sqlStr);
			System.out.println("BLGenRcptForVendorsBean.java->setDBValues()->sqlStr: " + sqlStr);
			rs = pstmt.executeQuery();
			List<PolicyApprovalBean> list = new ArrayList<PolicyApprovalBean>();
			while (rs.next()) {
				PolicyApprovalBean bean = new PolicyApprovalBean();
				bean.setCustomerGroup(rs.getString("cust_group_code"));
				bean.setCustomer(rs.getString("cust_code"));
				bean.setPolicy(rs.getString("policy_type_code"));
				bean.setChkBox(rs.getString("policy_approved_yn"));
				bean.setCustomerGroupDesc(rs.getString("payer_group"));
				bean.setCustomerDesc(rs.getString("payer"));
				bean.setPolicyDesc(rs.getString("policy_type"));
				bean.setChkBoxDBVal(rs.getString("policy_approved_yn"));
				bean.setPolStratDate(rs.getString("effective_from"));
				bean.setPolEndDate(rs.getString("effective_to"));

				list.add(bean);
			}
			setList(list);

		} catch (Exception ex) {
			System.err.println("Error in PolicyApprovalBean.java->setDBValues: "+ ex);
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
		list.clear();
	}
}
