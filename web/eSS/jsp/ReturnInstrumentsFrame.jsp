<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, eSS.Common.*, eSS.* " %>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="alReturnInstrumentsList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
<%
	alReturnInstrumentsList.clear();
	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_no					=		request.getParameter("doc_no");

	ReturnInstrumentsListBean bean	=		(ReturnInstrumentsListBean) getBeanObject( "returnInstrumentsListBean", "eSS.ReturnInstrumentsListBean",  request );	
	bean.clear();

	ArrayList alReturnInstrumentsRecords	=	null;
	String group_code               = "";//Added for TH-KW-CRF-0030
	
	    
	if( (doc_no!=null) && (doc_type_code!=null) )
	{
		try{
			group_code = bean.getGroupCode(doc_type_code,doc_no);//Added for TH-KW-CRF-0030
			ArrayList alParameters =		new ArrayList();

			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(doc_type_code);
			alParameters.add(new Long(doc_no));
			alReturnInstrumentsRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_RET_ITEM_DTL_SELECT_MULTIPLE"),alParameters);
			for (int i=0;i<alReturnInstrumentsRecords.size();i++){
				HashMap hmReturnInstrumentsRecord=(HashMap)alReturnInstrumentsRecords.get(i);
				hmReturnInstrumentsRecord.put("item_code",		(String)hmReturnInstrumentsRecord.get("ITEM_CODE") );
				hmReturnInstrumentsRecord.put("item_desc",		(String)hmReturnInstrumentsRecord.get("ITEM_DESC") );
				hmReturnInstrumentsRecord.put("contaminated_yn",(String)hmReturnInstrumentsRecord.get("CONTAMINATED_YN")  );
				hmReturnInstrumentsRecord.put("remarks",		bean.checkForNull((String)hmReturnInstrumentsRecord.get("REMARKS")));
				hmReturnInstrumentsRecord.put("ret_item_qty",	(String)hmReturnInstrumentsRecord.get("RET_ITEM_QTY"));
				hmReturnInstrumentsRecord.put("ret_item_cost",	bean.checkForNull((String)hmReturnInstrumentsRecord.get("RET_ITEM_COST")));
				hmReturnInstrumentsRecord.put("damaged_yn",		(String)hmReturnInstrumentsRecord.get("DAMAGED_YN"));
				hmReturnInstrumentsRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmReturnInstrumentsRecord.put("expiry_date",	bean.getExpiryDate(group_code));//Added for TH-KW-CRF-0030
				hmReturnInstrumentsRecord.remove("ITEM_CODE");   
				hmReturnInstrumentsRecord.remove("ITEM_DESC");   
				hmReturnInstrumentsRecord.remove("CONTAMINATED_YN");
				hmReturnInstrumentsRecord.remove("REMARKS");      
				hmReturnInstrumentsRecord.remove("RET_ITEM_QTY"); 
				hmReturnInstrumentsRecord.remove("RET_ITEM_COST");
				hmReturnInstrumentsRecord.remove("DAMAGED_YN");  
				hmReturnInstrumentsRecord.remove("EXPIRY_DATE");  //Added for TH-KW-CRF-0030
				alReturnInstrumentsList.add(hmReturnInstrumentsRecord);
			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}

	putObjectInBean("returnInstrumentsListBean",bean,request);


%>
	<iframe name='frameReturnInstrumentsHeader' id='frameReturnInstrumentsHeader'				src="../../eSS/jsp/ReturnInstrumentsHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:100%;width:100vw'></iframe>
		<iframe name='frameReturnInstrumentsList' id='frameReturnInstrumentsList'			src="../../eSS/jsp/ReturnInstrumentsList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize style='height:56vh;width:100vw'></iframe>
		<iframe name='frameReturnInstrumentsDetail' id='frameReturnInstrumentsDetail'			src="../../eSS/jsp/ReturnInstrumentsDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize style='height:150%;width:100vw'></iframe>

	

</html>

