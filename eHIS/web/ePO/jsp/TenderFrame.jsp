<!DOCTYPE html>
<jsp:useBean id="obj18" scope="page" class="ePO.TenderBean"/>
<jsp:useBean id="obj19" scope="page" class="ePO.TenderDetailBean"/>
<%@ page import=" ePO.*, ePO.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/Tender.js"></script>
    <script>
        function_id			=		"<%= request.getParameter("function_id")%>";
		menu_id				=		"<%= request.getParameter( "menu_id" ) %>"
		module_id			=		"<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale				=		(String)session.getAttribute("LOCALE");
	String params				=		request.getQueryString();
	
	String bean_id				=		"tenderBean";
	String bean_name			=		"ePO.TenderBean";

	TenderBean bean		=		(TenderBean) getBeanObject(bean_id,  bean_name,request);  
	bean.initialize();
	//bean.setEntity_param ((String) session.getAttribute("ACC_ENTITY_ID"));
	bean.setLanguageId(locale);

	String mode					=		request.getParameter("mode");
	String tender_type_code		=		request.getParameter("tender_type_code");
	String tender_no				=		request.getParameter("tender_no");
		
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.loadData(tender_type_code, tender_no);
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("tender_type_code",tender_type_code.trim());
		hmParameter.put("tender_no",tender_no.trim());
		hmParameter.put("trn_type","PO");
		
	}

	putObjectInBean(bean_id,bean,request);
%>

<frameset rows="80,*">
		<frame name='TndrHeaderFrame' src="../../ePO/jsp/TenderHeader.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		<frameset cols="25%,2%,*" id="TenderFrmS" >
			<frame name='TndrDetailFrame' src="../../ePO/jsp/TenderDetails.jsp?<%=params%>" frameborder=0 scrolling="auto"   noresize>
			<frame name='TndrBlankFrame' src="../../ePO/jsp/TenderBlank.jsp" frameborder=0 scrolling="no"   noresize>
			<frame name='TndrListFrame' src="../../ePO/jsp/TenderList.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		</frameset>
	</frameset>

</html> 

