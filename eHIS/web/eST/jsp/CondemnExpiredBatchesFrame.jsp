<!DOCTYPE html>
 <%@ page import=" eST.CondemnExpiredBatchesHeaderBean,java.util.ArrayList,java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String mode   = request.getParameter("mode");
		//String trn_type;
	//	String codeDisabled="";	
	//	String facilityid=(String)session.getValue("facility_id");	
		if(mode==null) {
			mode="1";
		}
		//String function_id	= request.getParameter( "function_id" ) ;	
		CondemnExpiredBatchesHeaderBean bean =  null;
	
		try{
			bean = (eST.CondemnExpiredBatchesHeaderBean) getBeanObject( "condemnExpiredBatchesHeaderBean", "eST.CondemnExpiredBatchesHeaderBean",request);
			bean.setLanguageId(locale);
		}
		catch (Exception ex) {
		}
		
       if (mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) 	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013	
		bean.initialize();
	//	bean.setReFamily(request, response);

	 //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 
	String disposable_yn   = bean.checkForNull(request.getParameter("disposable_yn"),"N");
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
	String doc_type_code					=		 bean.checkForNull(request.getParameter("doc_type_code"));
	String doc_no							=		 bean.checkForNull(request.getParameter("doc_no"));
	//String doc_ref                        =        bean.checkForNull(request.getParameter("doc_ref"));
	//String hdr_remarks                    =        bean.checkForNull(request.getParameter("hdr_remarks"));
	String doc_date                         =        bean.checkForNull(request.getParameter("doc_date"));
	if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.setDoc_type_code(doc_type_code);
		//bean.setDoc_ref(doc_ref);
		//bean.setAdj_remarks_Desc(hdr_remarks);
		bean.setDoc_date(doc_date);
		bean.setCon_doc_no(doc_no);
		bean.loadData(doc_type_code, doc_no);
	 }
	//ends

	%>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->		<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
		<script language="JavaScript" src="../../eST/js/CondemnExpiredBatches.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	</head>
	<!--Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 -->
	<!--Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 -->
	<%if(disposable_yn.equals("Y") || mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){%>
	<div>
	<%}else{%>
	<!-- <frameset rows='53,150,*'> -->
	<!-- <frameset rows='53,180,*'> Modified against GHL-CRF-0413.7-->
	<!--  <frameset rows='53,190,*'> -->
	<%}%>
		<iframe name='frameCondemnExpiredBatchesAddModify' src="../../eST/jsp/CondemnExpiredBatchesHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
		<%if(disposable_yn.equals("Y") || mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){%>
		  <iframe name='frameCondemnExpiredBatchesCriteria' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>  
		<iframe name='frameExpiredBatchesList' src="../../eST/jsp/CondemnExpiredBatchesList.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:70vh;width:100vw'></iframe>
	   <%}else{%>
		<iframe name='frameCondemnExpiredBatchesCriteria' src="../../eST/jsp/CondemnExpiredBatchesCriteria.jsp" frameborder=0 scrolling='no' noresize style='height:41vh;width:100vw'></iframe>
		<iframe name='frameExpiredBatchesList' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize style='height:50vh;width:100vw'></iframe>
	 <%}%>		
	</div>
	
	<%putObjectInBean("condemnExpiredBatchesHeaderBean",bean,request);%>
</html>
