<!DOCTYPE html>

<%@page import="eBL.placeorder.model.BLChargePatientExistingOrderBean"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.iba.framework.core.util.UtilDateConverter"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.net.URLDecoder"%>
<%// Page Added by Rajesh V. To Persist all the services in New Order %>

<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%!
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
		
	}
	
	
%>

<%!
private String decodeParamUTF(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding BillReceiptAjax->"+e);
	}
	return output;
}
%>
<%
	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "BLChargePatientExistingOrderBean" ;
	String beanName = "eBL.placeorder.model.BLChargePatientExistingOrderBean";

	BLChargePatientExistingOrderBean serviceBean = (BLChargePatientExistingOrderBean) getObjectFromBean(beanId, beanName, session);
	String facility_id = (String)session.getAttribute("facility_id");
	ResourceBundle rb = null;
	Locale loc = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	Connection 	con = null;
	CallableStatement cstmt = null;
	try 
	{
		con = ConnectionManager.getConnection();
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
		Calendar cal = Calendar.getInstance();
		java.util.Date dt = cal.getTime();
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		
		List<BLChargePatientExistingOrderBean> serviceList = null;
		
		if(func_mode!= null && "persistExistingOrderBean".equals(func_mode)){
			Gson gson = new Gson();
			JsonParser jsonParser = new JsonParser();
			//JSONObject existingOrder = new JSONObject(request.getParameter("existingOrderObject"));
			
			/*serviceBean.setEpisodeType((String) existingOrder.get("episodeType"));
			serviceBean.setEpisodeId((String) existingOrder.get("episodeId"));
			serviceBean.setVisitId((String) existingOrder.get("visitId"));
			serviceBean.setEncounterId((String) existingOrder.get("encounterId"));
			serviceBean.setAcctSeqNo((String) existingOrder.get("acctSeqNo"));
			serviceBean.setPatientId((String) existingOrder.get("patientId"));
			serviceBean.setOrderId((String) existingOrder.get("orderId"));
			serviceBean.setOrderLineNum((String) existingOrder.get("orderLineNum"));
			serviceBean.setSubModuleId((String) existingOrder.get("subModuleId"));
			serviceBean.setSubRegnNum((String) existingOrder.get("subRegnNum"));
			serviceBean.setSubRegnLineNum((String) existingOrder.get("subRegnLineNum"));
			serviceBean.setServCode((String) existingOrder.get("servCode"));
					
			serviceBean.setServDesc((String) existingOrder.get("servDesc"));
			serviceBean.setServOrPanel((String) existingOrder.get("servOrPanel"));		
			serviceBean.setItemCode((String) existingOrder.get("itemCode"));
			serviceBean.setItemDesc((String) existingOrder.get("itemDesc"));
			serviceBean.setServQty((String) existingOrder.get("baseQty"));
			serviceBean.setBaseChargeAmount((String) existingOrder.get("baseChargeAmount"));
			serviceBean.setServDiscount((String) existingOrder.get("disc_amt"));
			serviceBean.setNetCharge((String) existingOrder.get("netChargeAmount"));
			serviceBean.setPhysicianId((String) existingOrder.get("physicianId"));
			serviceBean.setServedpanelQty((String) existingOrder.get("servedpanelQty"));
			serviceBean.setUomCode((String) existingOrder.get("uomCode"));
			serviceBean.setPractStaffInd((String) existingOrder.get("practStaffInd"));
					
			serviceBean.setInclExclInd((String) existingOrder.get("inclExclInd"));
			serviceBean.setReason((String) existingOrder.get("reason"));
					
			serviceBean.setFutureOrder((String) existingOrder.get("futureOrder"));
			serviceBean.setFutureOrderChargeLater((String) existingOrder.get("futureOrderChargeLater"));
			serviceBean.setRemarks((String) existingOrder.get("remarks"));
					
			serviceBean.setPackInd((String) existingOrder.get("packInd"));
			serviceBean.setDailyProcessInd((String) existingOrder.get("dailyProcessInd"));
			serviceBean.setBedTypeCode((String) existingOrder.get("bedTypeCode"));
			serviceBean.setTokenSerial((String) existingOrder.get("tokenSeriesCode"));
			serviceBean.setTokenSerialNo((String) existingOrder.get("tokenSeriesNo"));
			
			serviceBean.setDispLocn((String) existingOrder.get("dispLocn"));		
			serviceBean.setTrxDocRef((String) existingOrder.get("trxDocRef"));
			serviceBean.setTrxDocRefSeqNum((String) existingOrder.get("trxDocRefSeqNum"));
			serviceBean.setTrxDocRefLineNum((String) existingOrder.get("trxDocRefLineNum"));
			serviceBean.setConfirmedYn((String) existingOrder.get("confirmedYn"));
			serviceBean.setBaseRate((String) existingOrder.get("baseRate"));*/
			JsonObject existingOrder = (JsonObject) jsonParser.parse(request.getParameter("existingOrderObject"));
			serviceBean.setEpisodeType(checkForNull(existingOrder.get("episodeType").getAsString()));
			serviceBean.setEpisodeId(checkForNull(existingOrder.get("episodeId").getAsString()));
			serviceBean.setVisitId(checkForNull(existingOrder.get("visitId").getAsString()));
			serviceBean.setEncounterId(checkForNull(existingOrder.get("encounterId").getAsString()));
			serviceBean.setAcctSeqNo(checkForNull(existingOrder.get("acctSeqNo").getAsString()));
			serviceBean.setPatientId(checkForNull(existingOrder.get("patientId").getAsString()));
			serviceBean.setOrderId(checkForNull(existingOrder.get("orderId").getAsString()));
			serviceBean.setOrderLineNum(checkForNull(existingOrder.get("orderLineNum").getAsString()));
			serviceBean.setSubModuleId(checkForNull(existingOrder.get("subModuleId").getAsString()));
			serviceBean.setSubRegnNum(checkForNull(existingOrder.get("subRegnNum").getAsString()));
			serviceBean.setSubRegnLineNum(checkForNull(existingOrder.get("subRegnLineNum").getAsString()));
			serviceBean.setServCode(checkForNull(existingOrder.get("servCode").getAsString()));
					
			serviceBean.setServDesc(decodeParamUTF(existingOrder.get("servDesc").getAsString()));
			serviceBean.setServOrPanel(checkForNull(existingOrder.get("servOrPanel").getAsString()));		
			serviceBean.setItemCode(checkForNull(existingOrder.get("itemCode").getAsString()));
			serviceBean.setItemDesc(checkForNull(existingOrder.get("itemDesc").getAsString()));
			serviceBean.setServQty(checkForNull(existingOrder.get("baseQty").getAsString()));
			serviceBean.setBaseChargeAmount(checkForNull(existingOrder.get("baseChargeAmount").getAsString()));
			serviceBean.setServDiscount(checkForNull(existingOrder.get("disc_amt").getAsString()));
			serviceBean.setNetCharge(checkForNull(existingOrder.get("netChargeAmount").getAsString()));
			serviceBean.setPhysicianId(checkForNull(existingOrder.get("physicianId").getAsString()));
			serviceBean.setServedpanelQty(checkForNull(existingOrder.get("servedpanelQty").getAsString()));
			serviceBean.setUomCode(checkForNull(existingOrder.get("uomCode").getAsString()));
			serviceBean.setPractStaffInd(checkForNull(existingOrder.get("practStaffInd").getAsString()));
					
			serviceBean.setInclExclInd(checkForNull(existingOrder.get("inclExclInd").getAsString()));
			serviceBean.setReason(checkForNull(existingOrder.get("reason").getAsString()));
					
			serviceBean.setFutureOrder(checkForNull(existingOrder.get("futureOrder").getAsString()));
			serviceBean.setFutureOrderChargeLater(checkForNull(existingOrder.get("futureOrderChargeLater").getAsString()));
			serviceBean.setRemarks(checkForNull(existingOrder.get("remarks").getAsString()));
					
			serviceBean.setPackInd(checkForNull(existingOrder.get("packInd").getAsString()));
			serviceBean.setDailyProcessInd(checkForNull(existingOrder.get("dailyProcessInd").getAsString()));
			serviceBean.setBedTypeCode(checkForNull(existingOrder.get("bedTypeCode").getAsString()));
			serviceBean.setTokenSerial(checkForNull(existingOrder.get("tokenSeriesCode").getAsString()));
			serviceBean.setTokenSerialNo(checkForNull(existingOrder.get("tokenSeriesNo").getAsString()));
			
			serviceBean.setDispLocn(checkForNull(existingOrder.get("dispLocn").getAsString()));		
			serviceBean.setTrxDocRef(checkForNull(existingOrder.get("trxDocRef").getAsString()));
			serviceBean.setTrxDocRefSeqNum(checkForNull(existingOrder.get("trxDocRefSeqNum").getAsString()));
			serviceBean.setTrxDocRefLineNum(checkForNull(existingOrder.get("trxDocRefLineNum").getAsString()));
			serviceBean.setConfirmedYn(checkForNull(existingOrder.get("confirmedYn").getAsString()));
			serviceBean.setBaseRate(checkForNull(existingOrder.get("baseRate").getAsString()));
			serviceBean.setAcctSeqNo(checkForNull(existingOrder.get("acctSeqNo").getAsString()));
			serviceBean.setCustGroup(checkForNull(existingOrder.get("payerGroup").getAsString()));
			serviceBean.setCust(checkForNull(existingOrder.get("payer").getAsString()));
			serviceBean.setPolicyCode(checkForNull(existingOrder.get("policy").getAsString()));
			serviceBean.setPolicyNum(checkForNull(existingOrder.get("policyNum").getAsString()));
			serviceBean.setRateIndicator(checkForNull(existingOrder.get("rateIndicator").getAsString()));
			serviceBean.setAdhocDiscount(checkForNull(existingOrder.get("adhocDiscount").getAsString()));
			serviceBean.setChargeDateTime(checkForNull(existingOrder.get("chargeDateTime").getAsString()));
		}
		
		else if(func_mode != null && "cancelAll".equals(func_mode)){
			serviceList = new ArrayList<BLChargePatientExistingOrderBean> ();
			BLChargePatientExistingOrderBean loopBean = null;
			serviceBean.setEpisodeType(checkForNull(request.getParameter("episodeType")));
			serviceBean.setEpisodeId(checkForNull(request.getParameter("episodeId")));
			serviceBean.setVisitId(checkForNull(request.getParameter("visitId")));
			serviceBean.setEncounterId(checkForNull(request.getParameter("encounterId")));
			serviceBean.setPatientId(checkForNull(request.getParameter("patientId")));
			serviceBean.setAcctSeqNo(checkForNull(request.getParameter("acctSeqNo")));
			serviceBean.setCustGroup(checkForNull(request.getParameter("payerGroup")));
			serviceBean.setCust(checkForNull(request.getParameter("payer")));
			serviceBean.setPolicyCode(checkForNull(request.getParameter("policy")));
			serviceBean.setPolicyNum(checkForNull(request.getParameter("policyNum")));
			int lastIndex = Integer.parseInt(request.getParameter("lastIndex"));
			for(int i = 0; i<= lastIndex; i++){
				if(request.getParameter("servCode"+i) != null){
				loopBean = new BLChargePatientExistingOrderBean();
				loopBean.setTrxDocRef(checkForNull(request.getParameter("trxDocRef"+i)));
				loopBean.setTrxDocRefLineNum(checkForNull(request.getParameter("trxDocRefLineNum"+i)));
				loopBean.setTrxDocRefSeqNum(checkForNull(request.getParameter("trxDocRefSeqNum"+i)));
				loopBean.setPrimKeyLineNum(checkForNull(request.getParameter("primKeyLineNo"+i)));
				loopBean.setPrimKeyMain(checkForNull(request.getParameter("primKeyMain"+i)));
				loopBean.setPrimKeyModId(checkForNull(request.getParameter("primKeyModId"+i)));
				loopBean.setConfirmedYn(checkForNull(request.getParameter("confirmedYn"+i)));
				loopBean.setServedpanelQty(checkForNull(request.getParameter("servedPanelQty"+i)));
				loopBean.setServQty(checkForNull(request.getParameter("servQty"+i)));
				loopBean.setPhysicianId(checkForNull(request.getParameter("physicianId"+i)));
				loopBean.setUomCode(checkForNull(request.getParameter("uomCode"+i)));
				loopBean.setPractStaffInd(checkForNull(request.getParameter("practStaffInd"+i)));
				loopBean.setInclExclInd(checkForNull(request.getParameter("inclExclInd"+i)));
				loopBean.setReason(checkForNull(request.getParameter("reason"+i)));
				loopBean.setRemarks(checkForNull(request.getParameter("remarks"+i)));
				loopBean.setDailyProcessInd(checkForNull(request.getParameter("dailyProcessInd"+i)));
				loopBean.setBedTypeCode(checkForNull(request.getParameter("bedType"+i)));
				loopBean.setTokenSerial(checkForNull(request.getParameter("tokenSeriesCode"+i)));
				loopBean.setTokenSerialNo(checkForNull(request.getParameter("tokenSeriesNo"+i)));
				loopBean.setDispLocn(checkForNull(request.getParameter("dispLocn"+i)));
				loopBean.setSubRegnNum(checkForNull(request.getParameter("secKeyMain"+i)));
				loopBean.setSubRegnLineNum(checkForNull(request.getParameter("secKeyLineNo"+i)));
				loopBean.setServOrPanel(checkForNull(request.getParameter("servOrPanel"+i)));
				loopBean.setBaseRate(checkForNull(request.getParameter("baseRate"+i)));
				loopBean.setRateIndicator(checkForNull(request.getParameter("rateIndicator"+i)));
				loopBean.setNetCharge(checkForNull(request.getParameter("netChargeAmount"+i)));
				loopBean.setServCode(checkForNull(request.getParameter("servCode"+i)));
				loopBean.setPackInd(checkForNull(request.getParameter("trxDocRefLineNum"+i)));
				loopBean.setItemCode(checkForNull(request.getParameter("itemCode"+i)));
				serviceList.add(loopBean);
				}
			}
			serviceBean.setServicesList(serviceList);
		}
		else if(func_mode != null && "confirmAll".equals(func_mode)){
			serviceList = new ArrayList<BLChargePatientExistingOrderBean> ();
			BLChargePatientExistingOrderBean loopBean = null;
			int lastIndex = Integer.parseInt(request.getParameter("lastIndex"));
			for(int i = 0; i<= lastIndex; i++){
				if(request.getParameter("servCode"+i) != null){
					loopBean = new BLChargePatientExistingOrderBean();
					loopBean.setTrxDocRef(checkForNull(request.getParameter("trxDocRef"+i)));
					loopBean.setTrxDocRefLineNum(checkForNull(request.getParameter("trxDocRefLineNum"+i)));
					loopBean.setTrxDocRefSeqNum(checkForNull(request.getParameter("trxDocRefSeqNum"+i)));
					loopBean.setPrimKeyLineNum(checkForNull(request.getParameter("primKeyLineNo"+i)));
					loopBean.setPrimKeyMain(checkForNull(request.getParameter("primKeyMain"+i)));
					loopBean.setPrimKeyModId(checkForNull(request.getParameter("primKeyModId"+i)));
					loopBean.setConfirmedYn(checkForNull(request.getParameter("confirmedYn"+i)));
					loopBean.setServCode(checkForNull(request.getParameter("servCode"+i)));
					loopBean.setServOrPanel(checkForNull(request.getParameter("servOrPanel"+i)));
					loopBean.setItemCode(checkForNull(request.getParameter("itemCode"+i)));
					serviceList.add(loopBean);
				}
			}
			serviceBean.setServicesList(serviceList);
		}
		else if(func_mode != null && "processAll".equals(func_mode)){
			serviceList = new ArrayList<BLChargePatientExistingOrderBean> ();
			BLChargePatientExistingOrderBean loopBean = null;
			serviceBean.setEpisodeType(checkForNull(request.getParameter("episodeType")));
			serviceBean.setEpisodeId(checkForNull(request.getParameter("episodeId")));
			serviceBean.setVisitId(checkForNull(request.getParameter("visitId")));
			serviceBean.setEncounterId(checkForNull(request.getParameter("encounterId")));
			serviceBean.setPatientId(checkForNull(request.getParameter("patientId")));
			int lastIndex = Integer.parseInt(request.getParameter("lastIndex"));
			for(int i = 0; i<= lastIndex; i++){
				if(request.getParameter("primKeyMain"+i) != null){
					loopBean = new BLChargePatientExistingOrderBean();
					loopBean.setSubModuleId(checkForNull(request.getParameter("primKeyModId"+i)));
					loopBean.setOrderId(checkForNull(request.getParameter("primKeyMain"+i)));
					loopBean.setSubRegnNum(checkForNull(request.getParameter("secKeyMain"+i)));
					loopBean.setSubRegnLineNum(checkForNull(request.getParameter("secKeyLineNo"+i)));
					serviceList.add(loopBean);
				}
			}
			serviceBean.setServicesList(serviceList);
		}
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BL Function Privilege :" + e);
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con);
	}

	putObjectInBean(beanId,serviceBean,request);

%>


