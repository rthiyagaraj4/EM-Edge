<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
19/04/2016	IN059255			Karthi L							 			ML-MMOH-CRF-0329.1
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="org.apache.commons.collections.iterators.EntrySetMapIterator"%>
<%@page import="java.sql.*,java.util.*, eCA.*, eOR.*, webbeans.eCommon.* " contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	try{
		String bean_id = "Or_ReviewResults" ;
		String bean_name = "eOR.ReviewResults";
		ReviewResults bean = (ReviewResults)getObjectFromBean(bean_id, bean_name, session);
		bean.setLanguageId(locale);
		
		Hashtable hashObj 			= (Hashtable)XMLobj.parseXMLString(request);
 		hashObj 					= (Hashtable)hashObj.get("SEARCH");
		String l_bean_id 			= (String)hashObj.get("p_bean_id");
		String l_bean_name 			= (String)hashObj.get("p_bean_name");
		String l_action 			= (String)hashObj.get("p_validate") == null?"":(String)hashObj.get("p_validate");
		String l_hist_rec_type 		= (String)hashObj.get("p_histRecType") == null?"":(String)hashObj.get("p_histRecType");
		String l_contrSysId			= (String)hashObj.get("p_contrSysId")== null?"": (String)hashObj.get("p_contrSysId");	
		String l_contrSysEventCode	= (String)hashObj.get("p_contrSysEventCode")== null?"": (String)hashObj.get("p_contrSysEventCode");	
		String l_accessionNum 		= (String)hashObj.get("p_accessionNum") == null?"":(String)hashObj.get("p_accessionNum");
		String l_eventCode			= (String)hashObj.get("p_eventCode") == null?"":(String)hashObj.get("p_eventCode");
		String l_notifyAlert 		= (String)hashObj.get("p_notifyAlert") == null?"":(String)hashObj.get("p_notifyAlert");
		String l_reviewRemarks		= (String)hashObj.get("p_reviewRemarks") == null?"":(String)hashObj.get("p_reviewRemarks");
		String l_caNormalcyInd		= (String)hashObj.get("p_caNormalcyInd") == null?"":(String)hashObj.get("p_caNormalcyInd");
		String l_practitionerId		= (String)hashObj.get("p_practitionerId") == null?"":(String)hashObj.get("p_practitionerId");
		String l_loginUserId		= (String)hashObj.get("p_loginUserId") == null?"":(String)hashObj.get("p_loginUserId");
		String l_reviewType			= "";
		String l_createDateTime 	= "";
		String review_details 		= "";
	 	String[] review_detail_array = new String[2]; 
		CAChartSummaryLabNotifyBean beanObj = (CAChartSummaryLabNotifyBean)getObjectFromBean(l_bean_id, l_bean_name, session);
		
		if(l_action.equals("SET_LAB_NOTIFY_FIELDS")) {
						
			review_details = beanObj.getReviewDetails(l_hist_rec_type, l_contrSysId, l_accessionNum, l_eventCode, l_notifyAlert, l_practitionerId);
			if(review_details != null && !"".equals(review_details)){
				review_detail_array = review_details.split("~");
				l_reviewType 		= review_detail_array[0];
				l_createDateTime 	= review_detail_array[1];
			} 
			
			beanObj.setHist_rec_type(l_hist_rec_type);
			beanObj.setContr_sys_id(l_contrSysId);
			beanObj.setContr_sys_event_code(l_contrSysEventCode);
			beanObj.setAccession_num(l_accessionNum);
			beanObj.setReview_type(l_reviewType);
			beanObj.setCreate_date_time(l_createDateTime);
			beanObj.setReview_remarks(l_reviewRemarks);
			beanObj.setNormalcy_ind(l_caNormalcyInd);
			beanObj.setPractitioner_id(l_practitionerId);
			beanObj.setLogin_user_id(l_loginUserId);
			out.println("callRvwResultsWindow();");
		}
		else if(l_action.equals("COMPLETE_REVIEW")){
			beanObj.setReview_remarks(l_reviewRemarks);
			HashMap statusMap = beanObj.completePendReivew();
			String message = (String)statusMap.get("message");
			System.out.println(" MESSAGE " + message);
			out.println("reviewCompletedStatus(\"" + message + "\" );");
		} 
		else if(l_action.equals("FORWARD_PRACT")){
			ArrayList forwardPractHash = new ArrayList();
			int totalRecs = 1;
	       for (int i = 0;i < totalRecs;i++) {
	           HashMap tempMap = new HashMap();
	           tempMap.put("hist_rec_type",beanObj.getHist_rec_type());
	           tempMap.put("contr_sys_id",beanObj.getContr_sys_id());
	           tempMap.put("accession_num",beanObj.getAccession_num());
	           tempMap.put("review_type",beanObj.getReview_type());
	           tempMap.put("event_code",beanObj.getContr_sys_event_code());
	           tempMap.put("normalcy_ind",beanObj.getNormalcy_ind());
	           forwardPractHash.add(tempMap);
	       }
	       bean.setForwardPractHash(forwardPractHash);
		}   
		
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println(" 69. CAChartSummLabNotifyIntrmdate.jsp = Message => " + ex.getMessage());
		
	}

%>
