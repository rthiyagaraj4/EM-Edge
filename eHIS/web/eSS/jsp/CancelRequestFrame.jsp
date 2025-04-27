<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* ,java.sql.*, eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alCancelRequestList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale			= (String)session.getAttribute("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
	</head>
<%
	alCancelRequestList.clear();
	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_no					=		request.getParameter("doc_no");
   	String	    bean_id				=		"cancelRequestListBean";
	String 	bean_name				=		"eSS.CancelRequestListBean";
   	String 	bean_id1				=		"cancelRequestBean" ;
	String 	bean_name1				=		"eSS.CancelRequestBean";

	CancelRequestListBean bean		=		(CancelRequestListBean) getBeanObject( bean_id, bean_name, request );  
	CancelRequestBean bean1			=		(CancelRequestBean) getBeanObject( bean_id1, bean_name1 , request );  

	ArrayList alRequestGroupRecords	=		null;
	if( (doc_no!=null) && (doc_type_code!=null) )
	{
		bean1.setDoc_no(doc_no);
		bean1.setDoc_type_code(doc_type_code);
		bean1.loadData();
		bean1.initialize();//Added By Sakti against BRU-HIMS-CRF-374
		try{
			ArrayList alParameters =		new ArrayList();
			//Added By Rabbani against KDAH-CRF-0247(Inc no : 35861) on 26-AUG-13
			alParameters.add(locale);
			alParameters.add(locale);
			//ends
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(doc_type_code);
			alParameters.add(new Long(doc_no));
			alParameters.add(bean1.getReq_on_store_code());
			alRequestGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_REQUEST_DTL_SELECT_MULTIPLE"),alParameters);
			for (int i=0;i<alRequestGroupRecords.size();i++){
				HashMap hmRequestGroupRecord=(HashMap)alRequestGroupRecords.get(i);
				hmRequestGroupRecord.put("group_type",		(String)hmRequestGroupRecord.get("GROUP_TYPE") );
				hmRequestGroupRecord.put("req_group_code",	(String)hmRequestGroupRecord.get("REQ_GROUP_CODE") );
				hmRequestGroupRecord.put("request_qty",		(String)hmRequestGroupRecord.get("REQUEST_QTY")  );
				hmRequestGroupRecord.put("issue_qty",		bean.checkForNull((String)hmRequestGroupRecord.get("ISSUE_QTY") ,"0") );
				hmRequestGroupRecord.put("description",		(String)hmRequestGroupRecord.get("SHORT_DESC"));
				hmRequestGroupRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmRequestGroupRecord.put("blocked_qty",		bean.checkForNull((String)hmRequestGroupRecord.get("BLOCKED_QTY") ,"0") );//Added by Sakti against BRU-HIMS-CRF#274
				hmRequestGroupRecord.remove("GROUP_TYPE") ;
				hmRequestGroupRecord.remove("REQ_GROUP_CODE")  ;
				hmRequestGroupRecord.remove("REQUEST_QTY");
				hmRequestGroupRecord.remove("ISSUE_QTY");
				hmRequestGroupRecord.remove("SHORT_DESC");
				hmRequestGroupRecord.remove("BLOCKED_QTY");//Added by Sakti against BRU-HIMS-CRF#274
				alCancelRequestList.add(hmRequestGroupRecord);
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);

%>
	<iframe name='frameCancelRequestHeader' id='frameCancelRequestHeader'		src="../../eSS/jsp/CancelRequestHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:70vh;width:100vw'></iframe>
		<iframe name='frameCancelRequestDetail' id='frameCancelRequestDetail'		src="../../eSS/jsp/CancelRequestDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:30vh;width:100vw'></iframe>
	
</html>

