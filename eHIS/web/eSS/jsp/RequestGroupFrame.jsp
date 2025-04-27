<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <jsp:useBean id="obj0" scope="page" class="eSS.RequestGroupBean"/>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="JavaScript" src="../../eSS/js/RequestGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
		/* alRequestGroupList.clear();
		String doc_type_code			=		(String)request.getParameter("doc_type_code")==null?"":(String)request.getParameter("doc_type_code");
		String doc_no					=		(String)request.getParameter("doc_no")==null?"":(String)request.getParameter("doc_no");

		RequestGroupListBean bean		=		(RequestGroupListBean)getBeanObject( "requestGroupListBean", "eSS.RequestGroupListBean",  request );	
		bean.clear();

		ArrayList alRequestGroupRecords	=		null;
		
		try{
				if( (!doc_no.equals("")) && (!doc_type_code.equals("")) )
					{
						RequestGroupBean bean1		=		 (RequestGroupBean)getBeanObject( "requestGroupBean","eSS.RequestGroupBean" , request);  
						bean1.clear();
						bean1.setDoc_no(doc_no);
						bean1.setDoc_type_code(doc_type_code);
						bean1.loadData();
						
							ArrayList alParameters =		new ArrayList();
							alParameters.add((String)session.getAttribute("LOCALE"));
							alParameters.add((String)session.getAttribute("LOCALE"));
							alParameters.add(session.getAttribute("facility_id"));
							alParameters.add(doc_type_code);
							alParameters.add(new Long(doc_no));
							alParameters.add(bean1.getReq_on_store_code());

							alRequestGroupRecords	=		bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_REQUEST_DTL_SELECT_MULTIPLE"),alParameters);
							for (int i=0;i<alRequestGroupRecords.size();i++){
							HashMap hmRequestGroupRecord=(HashMap)alRequestGroupRecords.get(i);
							hmRequestGroupRecord.put("group_type",		(String)hmRequestGroupRecord.get("GROUP_TYPE") );
							hmRequestGroupRecord.put("req_group_code",	(String)hmRequestGroupRecord.get("REQ_GROUP_CODE") );
							hmRequestGroupRecord.put("auth_group_code",	(String)hmRequestGroupRecord.get("AUTH_GROUP_CODE") );
							hmRequestGroupRecord.put("request_qty",		(String)hmRequestGroupRecord.get("REQUEST_QTY")  );
							hmRequestGroupRecord.put("description",		(String)hmRequestGroupRecord.get("SHORT_DESC"));
							//Commented by Rabbani #INC no:32068 on 07/12/2012
							//hmRequestGroupRecord.put("available_qty",	(String)hmRequestGroupRecord.get("STERILIZED_QTY"));
							//Added by Rabbani #INC no:32068 on 07/12/2012
					        hmRequestGroupRecord.put("available_qty",	(String)hmRequestGroupRecord.get("STERILIZED_BLOCKED_QTY"));
							hmRequestGroupRecord.put("auth_group_desc",	(String)hmRequestGroupRecord.get("AUTH_GROUP_DESC"));
							hmRequestGroupRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
							//Added By Sakti against KDAH-CRF-0247 
							hmRequestGroupRecord.put("surg_description", bean.checkForNull((String)hmRequestGroupRecord.get("SURGERY_TYPE_DESC"),"") );
							hmRequestGroupRecord.put("ot_surg_description", bean.checkForNull((String)hmRequestGroupRecord.get("SURGERY_NAME_DESC"),"") );
							//Added ends
							hmRequestGroupRecord.remove("GROUP_TYPE") ;
							hmRequestGroupRecord.remove("REQ_GROUP_CODE")  ;
							hmRequestGroupRecord.remove("AUTH_GROUP_CODE")  ;
							hmRequestGroupRecord.remove("AUTH_GROUP_DESC")  ;
							hmRequestGroupRecord.remove("REQUEST_QTY");
							hmRequestGroupRecord.remove("SHORT_DESC");
							hmRequestGroupRecord.remove("STERILIZED_QTY");
							hmRequestGroupRecord.remove("STERILIZED_BLOCKED_QTY");//Added by Rabbani #INC no:32068 on 06/12/12
							alRequestGroupList.add(hmRequestGroupRecord);
						}
					

					putObjectInBean("requestGroupBean",bean1,request);
				}		
	
		}
		catch(Exception exception){
			out.print(exception);
		}*/
		//Added by Sakti against BRU-HIMS-CRF-373
		
		String locale			 = (String)session.getAttribute("LOCALE");
		
		
		String mode				 =		request.getParameter("mode");
		String doc_no			 =		request.getParameter("doc_no");
		String doc_type_code	 =		request.getParameter("doc_type_code");
		String req_on_store_code =		request.getParameter("req_on_store_code");
		
				
		String params = request.getQueryString();
		String bean_id = "RequestGroupBean";
		String bean_name = "eSS.RequestGroupBean";
		RequestGroupBean bean = (RequestGroupBean) getBeanObject(bean_id,bean_name,request); 
		bean.setLanguageId(locale);
		
		   
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		 	bean.clear();
			bean.initialize();
		}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			bean.setDoc_type_code (doc_type_code.trim());
			bean.setDoc_no (doc_no.trim());
			
			bean.loadData();
			bean.loadDtlData() ;
						
		}//Added ends
	putObjectInBean("requestGroupListBean",bean,request);

%>
<!-- 	<frameset rows='100,*'>
		<frame name='frameRequestGroupHeader' id='frameRequestGroupHeader'				src="../../eSS/jsp/RequestGroupHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='frameRequestGroupDetail' id='frameRequestGroupDetail'			src="../../eSS/jsp/RequestGroupDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize>
			<frame name='frameRequestGroupList' id='frameRequestGroupList'			src="../../eSS/jsp/RequestGroupList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
		</frameset>

	</frameset> -->
	<frameset rows="150,*">
	<frame name="frameRequestGroupHeader" id="frameRequestGroupHeader" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/RequestGroupHeader.jsp?<%=request.getQueryString()%>">
	<frame name="frameRequestGroupList" id="frameRequestGroupList" src="../../eSS/jsp/RequestGroupList.jsp?<%=request.getQueryString()%>" frameborder="0" noresize scrolling="auto">
</frameset>

</html>
 

