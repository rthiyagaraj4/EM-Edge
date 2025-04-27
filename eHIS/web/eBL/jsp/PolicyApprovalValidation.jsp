<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = "bl_PolicyApprovalBean";
	String bean_name = "eBL.PolicyApprovalBean";
	PolicyApprovalBean bean = (PolicyApprovalBean) getBeanObject(bean_id, bean_name, request);

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
			
			HashMap<String, PolicyApprovalBean> hMap = new HashMap<String, PolicyApprovalBean>();
			for(int i= startRcrd - 1; i < endRcrd; i++) {
				String chkBoxStatus = nulltoStr((String) hash.get("chk_"+i));
				String dbChkBoxStatus = nulltoStr((String) hash.get("chkBxDbVal_"+i));
 				if(!dbChkBoxStatus.equals(chkBoxStatus)) {
					PolicyApprovalBean appBean = new PolicyApprovalBean();
					
					appBean.setChkBox((String) hash.get("chk_"+i));
					appBean.setCustomerGroup(nulltoStr((String) hash.get("custGrp_"+i)));
					appBean.setCustomer((String) hash.get("cust_"+i));
					appBean.setPolicy((String) hash.get("policy_"+i));
					
					hMap.put("chk_"+i, appBean);
				}
			}
			
			for(int i = 0; i < startRcrd-1; i++) {
				PolicyApprovalBean appBean = bean.getList().get(i);
				if(!appBean.getChkBoxDBVal().equals(appBean.getChkBox())) {
					appBean.setChkBox(appBean.getChkBox());
					appBean.setCustomerGroup(appBean.getCustomerGroup());
					appBean.setCustomer(nulltoStr(appBean.getCustomer()));
					appBean.setPolicy(appBean.getPolicy());
					
					hMap.put("chk_"+i, appBean);
				}
			}
			
			for(int i = endRcrd + 1; i < bean.getList().size(); i++) {
				PolicyApprovalBean appBean = bean.getList().get(i);
				if(!appBean.getChkBoxDBVal().equals(appBean.getChkBox())) {
					appBean.setChkBox(appBean.getChkBox());
					appBean.setCustomerGroup(appBean.getCustomerGroup());
					appBean.setCustomer(nulltoStr(appBean.getCustomer()));
					appBean.setPolicy(appBean.getPolicy());
					
					hMap.put("chk_"+i, appBean);
				}
			}
			bean.setFacilityId(facilityId);
			
			bean.sethMap(hMap);
		} else if(func_mode != null && func_mode.equals("MODIFY")) {
			String fromRcrd = (String) hash.get("fromRcrd");
			String toRcrd = (String) hash.get("toRcrd");
			int startRcrd = Integer.parseInt(fromRcrd);
			int endRcrd = Integer.parseInt(toRcrd);
			
			List<PolicyApprovalBean> list = bean.getList();
			for(int i= startRcrd - 1; i < endRcrd; i++) {
				String chkBoxStatus = nulltoStr((String) hash.get("chk_"+i));
				PolicyApprovalBean appBean = new PolicyApprovalBean();
				appBean.setChkBox((String) hash.get("chk_"+i));
				appBean.setChkBoxDBVal((String) hash.get("chkBxDbVal_"+i));
				appBean.setCustomerGroup((String) hash.get("custGrp_"+i));
				appBean.setCustomer(nulltoStr((String) hash.get("cust_"+i)));
				appBean.setPolicy((String) hash.get("policy_"+i));
				appBean.setCustomerGroupDesc((String) hash.get("custGrpDesc_"+i));
				appBean.setCustomerDesc(nulltoStr((String) hash.get("custDesc_"+i)));
				appBean.setPolicyDesc((String) hash.get("policyDesc_"+i));
				
				list.set(i, appBean);
			}
			bean.setList(list);
		}

	} catch (Exception e) {
		System.out.println("Exception from PolicyApprovalValidation: " + e);
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
