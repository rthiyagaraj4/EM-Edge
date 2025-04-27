<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = "bl_BLGenRcptForVendorsBean";
	String bean_name = "eBL.BLGenRcptForVendorsBean";
	BLGenRcptForVendorsBean bean = (BLGenRcptForVendorsBean) getBeanObject(bean_id, bean_name, request);

	Connection con = ConnectionManager.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	try {
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");
		bean.setLanguageId(locale);

		String facilityId = (String) session.getValue("facility_id");
		String loggedInUser = (String) session.getValue("login_user");
		Properties p = (Properties) session.getValue( "jdbc" ) ;
		String clientIpAddress	= p.getProperty("client_ip_address");
		String mode = (String) hash.get("mode");
		int count = 0;
		if (func_mode != null && func_mode.equals("APPLY")) {
			String fromRcrd = (String) hash.get("fromRcrd");
			String toRcrd = (String) hash.get("toRcrd");
			int startRcrd = Integer.parseInt(fromRcrd);
			int endRcrd = Integer.parseInt(toRcrd);
			
			List<BLGenRcptForVendorsBean> rcptList = new ArrayList<BLGenRcptForVendorsBean>();
			for(int i= startRcrd - 1; i < endRcrd; i++) {
				String chkBoxStatus = nulltoStr((String) hash.get("chk_"+i));
 				if("Y".equals(chkBoxStatus)) {
					BLGenRcptForVendorsBean rcptBean = new BLGenRcptForVendorsBean();
					rcptBean.setChkBoxName("chk_"+i);
					rcptBean.setChkBoxStatus((String) hash.get("chk_"+i));
					rcptBean.setPatientId(nulltoStr((String) hash.get("patId_"+i)));
					rcptBean.setPatientName((String) hash.get("patName_"+i));
					rcptBean.setPractoDocTypeCode((String) hash.get("practoDocTypeCode_"+i));
					rcptBean.setPractoDocNo((String) hash.get("practoDocNo_"+i));
					rcptBean.setPractoReceiptDate((String) hash.get("practoRcptDate_"+i));
					rcptBean.setPractoReceiptAmount((String) hash.get("practoRcptAmt_"+i));
					rcptBean.setSlmtDocRefDesc((String) hash.get("slmtDocRefDesc_"+i));
					rcptBean.setSlmtDocRefDate((String) hash.get("slmtDocRefDate_"+i));
					rcptList.add(rcptBean);
				}
			}
			for(int j = 0; j <bean.getList().size(); j++) {
				BLGenRcptForVendorsBean rcptBean = bean.getList().get(j);
				if("Y".equals(rcptBean.getChkBoxStatus())) {
					rcptBean.setChkBoxName(rcptBean.getChkBoxName());
					rcptBean.setChkBoxStatus(rcptBean.getChkBoxStatus());
					rcptBean.setPatientId(nulltoStr(rcptBean.getPatientId()));
					rcptBean.setPatientName(rcptBean.getPatientName());
					rcptBean.setPractoDocTypeCode(rcptBean.getPractoDocTypeCode());
					rcptBean.setPractoDocNo(rcptBean.getPractoDocNo());
					rcptBean.setPractoReceiptDate(rcptBean.getPractoReceiptDate());
					rcptBean.setPractoReceiptAmount(rcptBean.getPractoReceiptAmount());
					rcptBean.setSlmtDocRefDesc(rcptBean.getSlmtDocRefDesc());
					rcptBean.setSlmtDocRefDate(rcptBean.getSlmtDocRefDate());
					rcptList.add(rcptBean);
				}
			}
			bean.setFacilityId(facilityId);
			bean.setLoginUser(loggedInUser);
			bean.setVendorType((String) hash.get("vendorType"));
			bean.setLoginWsNo(clientIpAddress);
			bean.setStatus((String) hash.get("receiptStatus"));
			bean.setList(rcptList);
		} else if(func_mode != null && func_mode.equals("MODIFY")) {
			String fromRcrd = (String) hash.get("fromRcrd");
			String toRcrd = (String) hash.get("toRcrd");
			int startRcrd = Integer.parseInt(fromRcrd);
			int endRcrd = Integer.parseInt(toRcrd);
			
			List<BLGenRcptForVendorsBean> rcptList = bean.getList();
			for(int i= startRcrd - 1; i < endRcrd; i++) {
				String chkBoxStatus = nulltoStr((String) hash.get("chk_"+i));
				BLGenRcptForVendorsBean rcptBean = new BLGenRcptForVendorsBean();
				rcptBean.setChkBoxName("chk_"+i);
				rcptBean.setChkBoxStatus((String) hash.get("chk_"+i));
				rcptBean.setPatientId(nulltoStr((String) hash.get("patId_"+i)));
				rcptBean.setPatientName((String) hash.get("patName_"+i));
				rcptBean.setDob((String) hash.get("patDob_"+i));
				rcptBean.setGender((String) hash.get("patGender_"+i));
				rcptBean.setPractoTransactionId((String) hash.get("practoTransId_"+i));
				rcptBean.setPractoReceiptNo((String) hash.get("practoRcptNo_"+i));
				rcptBean.setPractoReceiptAmount((String) hash.get("practoRcptAmt_"+i));
				rcptBean.setPractoReceiptDate((String) hash.get("practoRcptDate_"+i));
				rcptBean.setEmReceiptNo((String) hash.get("emRcptNo_"+i));
				rcptBean.setEmReceiptDate((String) hash.get("emRcptDate_"+i));
				rcptBean.setCommnets((String) hash.get("emComments_"+i));
				rcptBean.setPractoDocTypeCode((String) hash.get("practoDocTypeCode_"+i));
				rcptBean.setPractoDocNo((String) hash.get("practoDocNo_"+i));
				rcptBean.setSlmtDocRefDesc((String) hash.get("slmtDocRefDesc_"+i));
				rcptBean.setSlmtDocRefDate((String) hash.get("slmtDocRefDate_"+i));
				rcptList.set(i, rcptBean);
			}
			bean.setList(rcptList);
		}

	} catch (Exception e) {
		System.out.println("Exception from BLGenRcptForVendorsValidation :" + e);
		e.printStackTrace();
	} finally {
		if (pstmt != null)
			pstmt.close();
		if (rs != null)
			rs.close();
		if (con != null)
			ConnectionManager.returnConnection(con);
	}
	putObjectInBean(bean_id, bean, request);
%>

<%!
private String nulltoStr(String inputString) {
	if (inputString == null) {
		return "";
	} else {
		return inputString;
	}
}
%>
