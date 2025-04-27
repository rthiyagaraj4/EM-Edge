<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.Hashtable,java.util.ArrayList, java.util.HashMap,java.util.Enumeration, eBL.Common.*, eBL.*, eCommon.Common.*, webbeans.eCommon.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	System.err.println("Persitence file called.deff.");
	String params = request.getQueryString();
	String beanId = "bl_BLRCMTransactionsBean";
	String beanName = "eBL.BLRCMTransactionsBean";
	System.err.println("Drug category Persitence file called..");
	
	
	BLRCMTransactionsBean policyBean = (BLRCMTransactionsBean) getBeanObject(beanId, beanName, request);
	
	if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<BLRCMTransactionsBean>>());
	}
	
	HashMap<String, List<BLRCMTransactionsBean> > policyMap = policyBean.getPolicyMap();
	
	try 
	{
	
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
	
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    	hash = (Hashtable)hash.get( "SEARCH" ) ;	
			
			String facilityId = (String)session.getValue( "facility_id" ) ;
			String loggedInUser = (String)session.getValue("login_user");	
			List<BLRCMTransactionsBean> covList = new ArrayList<BLRCMTransactionsBean>();
			BLRCMTransactionsBean covBean = null;
			int cnt = Integer.parseInt((String)hash.get("bill_tot_rec"));
			
			System.err.println("Rowcount is:"+cnt);
			
			for(int i=0; i<cnt; i++){
				covBean = new BLRCMTransactionsBean();
				System.err.println("covList is:"); 
				System.err.println("Status is:"+hash.get("checkedStatus_"+i));
				
				covBean.setFacilityId((String)hash.get("facility_id"));
				covBean.setPayerGroupCode((String)hash.get("payerGrpCode_"+i));
				covBean.setPayerCode((String)hash.get("payerCode_"+i));
				covBean.setPolicyTypeCode((String)hash.get("policyTypeCode_"+i));
				covBean.setApprDocRefNum((String)hash.get("apprDocRefNum_" + i));
				covBean.setClaimID((String)hash.get("claimID_" + i));
				covBean.setEpisodeType((String)hash.get("episodeType_"+i));
				covBean.setEncounterId((String)hash.get("encounterId_" + i));
				covBean.setVisitAdmitDt((String)hash.get("visitAdmitDt_" + i));
				covBean.setCheckoutDiscDt((String)hash.get("checkoutDiscDt_" + i));  
				covBean.setPatientId((String)hash.get("patientId_" + i));
				covBean.setPatientName((String)hash.get("patientName_" + i));
				covBean.setBillDocTypeCode((String)hash.get("billDocTypeCode_" + i));
				covBean.setBillNum((String)hash.get("billNum_" + i));
				covBean.setNetBillAmt((String)hash.get("netBillAmt_" + i));
				covBean.setApprBillAmt((String)hash.get("apprBillAmt_" + i)); 
				covBean.setReceiptDocRefNum((String)hash.get("receiptDocRefNum_" + i));
				covBean.setBillRemarks((String)hash.get("billRemarks_"+i));
				covBean.setClaimStatus((String)hash.get("claimStatus_" + i));
				covBean.setCheckedStatus((String)hash.get("checkedStatus_" + i));
				covBean.setClaimsServicesLevel((String)hash.get("claimsServicesLevel_" + i));  
				covBean.setStateDurFrom((String)hash.get("StateDurFrom"));
				covBean.setStateDurTo((String)hash.get("StateDurTo"));
				covBean.setApprTotalRec((String)hash.get("apprTotalRec"));
				covBean.setBillTotalRec((String)hash.get("billTotalRec"));
				covBean.setMembershipNo((String)hash.get("membershipNo_"+i));
				covBean.setFileName((String)hash.get("fileName_"+i));
				
				System.err.println("EnID "+(String)hash.get("encounterId_" + i));
				System.err.println("PatID "+(String)hash.get("patientId_" + i));
				System.err.println("BillDocTypeCode "+(String)hash.get("billDocTypeCode_" + i));
				System.err.println("BillNo "+(String)hash.get("billNum_" + i));
				System.err.println("membershipNo "+(String)hash.get("membershipNo_" + i));
				System.err.println("fileName "+(String)hash.get("fileName_" + i));
				
				covList.add(covBean); 
				System.err.println("covList .."+covList.isEmpty());   
			}  
			if(!(covList.isEmpty()))
				policyMap.put("BLRCMTransactionsDtl", covList);  
			 
			
			System.err.println("Data is in Policy Map..");
		
	
		
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println("Exception from BLDischargeValidation :" + e);
	} 
	putObjectInBean("bl_BLRCMTransactionsBean",policyBean,request);   
	
	
	
%>
